/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;

import irep.controlador.DecisaoController;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoNadaParaListar;
import irep.modelo.excecao.ExcecaoTodosJaVotaram;
import irep.modelo.persistencia.DecisaoDAO;
import irep.modelo.persistencia.MoradorDAO;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class TelaDecisoes {
    
    Scanner scan;
    DecisaoController controller;
    private static final Logger LOGGER = Logger.getLogger("irep");
    
    public TelaDecisoes(DecisaoDAO decisaoDAO, MoradorDAO moradorDAO){
        this.scan = new Scanner(System.in);
        this.controller = new DecisaoController(decisaoDAO, moradorDAO);
    }
    
    public void mostrar(){
        int opcao;
        
        opcao = mostrarMenu();
        while(opcao != 5){
            switch(opcao){
                case 1:
                    // Cadastrar decisao
                    cadastroDecisao();
                    break;
                case 2:
                    // listar decisoes
                    listarDecisoes();
                    break;
                case 3:
                    // vota em decisao
                    votaDecisao();
                    break;
                case 4:
                    calculaResultado();                  
                    break;                  
                default:
                    System.err.println("Opção inválida!");
            }
            opcao = mostrarMenu();            
        }
    }
    
    private int mostrarMenu(){
        int opcao;
        System.out.println("-------------- DECISOES --------------");
        System.out.println("1- Cadastrar Decisao");
        System.out.println("2- Listar Decisoes");
        System.out.println("3- Votar Decisao");
        System.out.println("4- Calcular Votos Decisao");
        System.out.println("5- Sair");
        System.out.print("\nDigite um numero: ");
        
        opcao = scan.nextInt();
        
        return opcao;        
    }  
    
    private void cadastroDecisao() {
        LOGGER.info("INICIADO: Cadastro de decisao");
        System.out.println("-------------- CADASTRO DE DECISOES --------------");
        
        System.out.print("Entre com o ID da decisao: ");
        try{
            int idDecisao = scan.nextInt();

            System.out.print("Entre com a descricao: ");
            scan.nextLine();
            String descricao = scan.next();

            controller.addDecisao(idDecisao, descricao);
            LOGGER.debug("CADASTRO: Decisao");
        }catch (InputMismatchException e){
            System.err.println("Insira valores inteiros, por favor!");
            scan.nextLine(); //descarta a entrada errada do usuário
        }catch (ExcecaoIDExiste de){
            LOGGER.error("Este ID já existe para Decisao");
         }
    }
    
    private void listarDecisoes() {
        LOGGER.info("INICIADO: Listagem de decisoes");
       System.out.println("-------------- LISTAGEM DE DECISOES --------------");
       try{
           List <String> decisoes = controller.listarDecisoes();
        
            if(decisoes.size() < 0){
                System.err.println("Sem decisoes cadastradas!");
                return;
            }
            
            System.out.println("Total de decisoes: " + decisoes.size());
            for (String t : decisoes){
                System.out.println(t);
            }    
            LOGGER.debug("LISTAR: Morador");
       }catch(ExcecaoNadaParaListar npl){
        LOGGER.error("Não há decisoes para listar!");
       } 
          
    }
    
    private void votaDecisao() {
        LOGGER.info("INICIADO: Voto de decisoes");
        System.out.println("-------------- VOTO DE DECISOES --------------");
        
        System.out.print("Entre com o ID da decisao: ");
        int idDecisao = scan.nextInt();
        
        System.out.print("Entre com o seu voto (sim/nao) para esta decisao: ");
        scan.nextLine();
        
        String votoMorador = scan.nextLine().toLowerCase(); 
        
        try{
            if("sim".equals(votoMorador)){
                controller.efetuaVoto(true, idDecisao);
                LOGGER.debug("EFETUA VOTO: Decisao");
            }else if("nao".equals(votoMorador)){
                controller.efetuaVoto(false, idDecisao);   
                LOGGER.debug("EFETUA VOTO: Decisao");        
            }
        }catch(ExcecaoIDNaoExiste ine){
            LOGGER.error("Não há este ID para Decisao!");
        }
        catch(ExcecaoTodosJaVotaram tjv){}               
    }   

    private void calculaResultado() {
        LOGGER.info("INICIADO: Calcula resultado da decisao");
        System.out.println("-------------- RESULTADO DE DECISOES --------------");
        
        System.out.print("Entre com o ID da decisão: ");
        int idDecisao = scan.nextInt();
        
        try{
            controller.calculaResultado(idDecisao);
            LOGGER.debug("CALCULA RESULTADO: Decisao");
        }catch(ExcecaoIDNaoExiste ine){
            LOGGER.error("Não há este ID para Decisao!");
        }        
    }
}