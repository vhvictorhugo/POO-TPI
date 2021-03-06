/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;

import irep.controlador.TarefaController;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoNadaParaListar;
import irep.modelo.excecao.ExcecaoTarefaJaAtribuida;
import irep.modelo.excecao.ExcecaoTarefaNaoAtribuida;
import irep.modelo.persistencia.MoradorDAO;
import irep.modelo.persistencia.TarefaDAO;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class TelaTarefas {
    Scanner scan;
    TarefaController controller;
    private static final Logger LOGGER = Logger.getLogger("irep");
    
    public TelaTarefas (TarefaDAO tarefaDAO, MoradorDAO moradorDAO){
        scan = new Scanner(System.in);   
        controller = new TarefaController(tarefaDAO, moradorDAO);
    }
    
    public void mostrar(){
        int opcao;
        
        opcao = mostrarMenu();
        while (opcao != 5){            
            switch(opcao){
                case 1:
                    // Cadastrar tarefa
                    cadastroTarefa();
                    break;
                case 2:
                    // listar tarefas
                    listarTarefas();                    
                    break;
                case 3:
                    // atribuir tarefa a morador
                    atribuiTarefa();
                    break;
                case 4:
                    // set conclusao para tarefa
                    concluiTarefa();                    
                    break;                  
                default:
                    System.err.println("Opção inválida!");
            }            
            opcao = mostrarMenu();
        }
    }
    
    private int mostrarMenu(){
        int opcao;
        System.out.println("-------------- TAREFAS --------------");
        System.out.println("1- Cadastrar Tarefa");
        System.out.println("2- Listar Tarefas");
        System.out.println("3- Atribuir Tarefa a um Morador");
        System.out.println("4- Concluir uma Tarefa");
        System.out.println("5- Sair");
        System.out.print("\nDigite um numero: ");
        
        opcao = scan.nextInt();
        
        return opcao;        
    }
    
    private void cadastroTarefa() {
        LOGGER.info("INICIADO: Cadastro de tarefa");
        System.out.println("-------------- CADASTRO DE TAREFAS --------------");
        
        try{
            System.out.print("Entre com o ID da tarefa: ");
            scan.nextLine();
            int idTarefa = scan.nextInt();
            
            System.out.print("Entre com o nome: ");
            scan.nextLine();
            String nome = scan.nextLine();       
            
            try{
                controller.addTarefa(idTarefa, nome);
                LOGGER.debug("CADASTRO: Tarefa");
            }catch(ExcecaoIDExiste ie){
                LOGGER.error("Este ID já existe para Tarefa!");
            }
        }catch (InputMismatchException e){
            System.err.println("Insira valores inteiros, por favor!");
            scan.nextLine(); //descarta a entrada errada do usuário
        }        
    }
    
    private void listarTarefas() {
        LOGGER.info("INICIADO: Listagem  de tarefas");
       System.out.println("-------------- LISTAGEM DE TAREFAS --------------");
       try{
            List <String> tarefas = controller.listarTarefas();
            
            System.out.println("Total de tarefas: " + tarefas.size());
            for (String t : tarefas){
                System.out.println(t);
            }
            LOGGER.debug("LISTAR: Tarefa");
        }catch(ExcecaoNadaParaListar npl){
            LOGGER.error("Não há tarefas para listar!");
        }  
    }
    
    private void atribuiTarefa(){
        LOGGER.info("INICIADO: Atribuição  de tarefas");
        System.out.println("-------------- ATRIBUIÇÃO DE TAREFAS --------------");
        
        System.out.print("Digite o ID da tarefa: ");
        
        int idTarefa;
        idTarefa = scan.nextInt();
        
        System.out.print("Digite o ID do morador a ser atribuido: ");
        
        int idMorador;
        idMorador = scan.nextInt();
        
        try{
            controller.efetuaAtribuicaoTarefa(idTarefa, idMorador);
            LOGGER.debug("ATRIBUI TAREFA: Tarefa");
        }catch(ExcecaoIDNaoExiste ine){
            LOGGER.error("Não há este ID para Tarefa!");
        }
        catch(ExcecaoTarefaJaAtribuida tja){}   
    }

    private void concluiTarefa(){
        LOGGER.info("INICIADO: Conclui  de tarefas");
        System.out.println("-------------- FECHAMENTO DE TAREFAS --------------");
        try{
            System.out.print("Digite o ID da tarefa: ");
        
        int idTarefa;
        idTarefa = scan.nextInt();
        
        controller.concluiTarefa(idTarefa);
        LOGGER.debug("CONCLUI TAREFA: Tarefa");
        }catch(ExcecaoIDNaoExiste ine){
            LOGGER.error("Não há este ID para Tarefa!");
        }
        catch(ExcecaoTarefaJaAtribuida tja) { }
        catch(ExcecaoTarefaNaoAtribuida tna) { }
    }
}
