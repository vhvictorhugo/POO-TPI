/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;

import irep.controlador.DecisaoController;
import java.util.List;
import java.util.Scanner;

public class TelaDecisoes {
    
    Scanner scan;
    DecisaoController controller;
    
    public TelaDecisoes(){
        this.scan = new Scanner(System.in);
        this.controller = new DecisaoController();
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
        System.out.println("-------------- CADASTRO DE DECISOES --------------");
        
        System.out.print("Entre com o ID da decisao: ");
        scan.nextLine();
        int idDecisao = scan.nextInt();
        
        System.out.print("Entre com a descricao: ");
        scan.nextLine();
        String descricao = scan.nextLine();       
        
        controller.addDecisao(idDecisao, descricao);
    }
    
    private void listarDecisoes() {
       System.out.println("-------------- LISTAGEM DE DECISOES --------------");
       List <String> decisoes = controller.listarDecisoes();
       
       if(decisoes.size() < 0){
           System.err.println("Sem decisoes cadastradas!");
           return;
       }
       
       System.out.println("Total de decisoes: " + decisoes.size());
       for (String t : decisoes){
           System.out.println(t);
       }       
    }
    
    private void votaDecisao() {
        System.out.println("-------------- VOTO DE DECISOES --------------");
        
        System.out.print("Entre com o ID da decisao: ");
        int idDecisao = scan.nextInt();
        
        System.out.print("Entre com o seu voto (sim/nao) para esta decisao: ");
<<<<<<< Updated upstream
        scan.nextLine();
=======
        String votoMorador = scan.nextLine().toLowerCase();
        
        System.out.println(votoMorador);
>>>>>>> Stashed changes
        
        String votoMorador = scan.nextLine().toLowerCase(); 
        
        if("sim".equals(votoMorador)){
<<<<<<< Updated upstream
            controller.efetuaVoto(true, idDecisao);
        }else if("nao".equals(votoMorador)){
            controller.efetuaVoto(false, idDecisao);            
=======
             
            controller.efetuaVoto(idDecisao, 1,0);
        }else if("nao".equals(votoMorador)){
             
            controller.efetuaVoto(idDecisao, 0,1);            
>>>>>>> Stashed changes
        }       
    }   

    private void calculaResultado() {
        System.out.println("-------------- RESULTADO DE DECISOES --------------");
        
        System.out.print("Entre com o ID da decisão: ");
        int idDecisao = scan.nextInt();
        
        controller.calculaResultado(idDecisao);
    }
}
