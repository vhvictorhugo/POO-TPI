/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;

import irep.controlador.TarefaController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TelaTarefas {
    Scanner scan;
    TarefaController controller;
    
    public TelaTarefas (){
        scan = new Scanner(System.in);   
        controller = new TarefaController();
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
        System.out.println("-------------- CADASTRO DE TAREFAS --------------");
        
        System.out.print("Entre com o ID da tarefa: ");
        scan.nextLine();
        int idTarefa = scan.nextInt();
        
        System.out.print("Entre com o nome: ");
        scan.nextLine();
        String nome = scan.nextLine();       
        
        controller.addTarefa(idTarefa, nome);
    }
    
       private void listarTarefas() {
       System.out.println("-------------- LISTAGEM DE TAREFAS --------------");
       List <String> tarefas = controller.listarTarefas();
       
       if(tarefas.size() < 0){
           System.err.println("Sem tarefas cadastradas!");
           return;
       }
       
       System.out.println("Total de tarefas: " + tarefas.size());
       for (String t : tarefas){
           System.out.println(t);
       }       
    }
    
    private void atribuiTarefa(){
        System.out.println("-------------- ATRIBUIÇÃO DE TAREFAS --------------");
        
        System.out.print("Digite o ID da tarefa: ");
        
        int idTarefa;
        idTarefa = scan.nextInt();
        
        System.out.print("Digite o ID do morador a ser atribuido: ");
        
        int idMorador;
        idMorador = scan.nextInt();
        
        controller.efetuaAtribuicaoTarefa(idTarefa, idMorador);
        
    }

    private void concluiTarefa() {
        System.out.println("-------------- FECHAMENTO DE TAREFAS --------------");
        
        System.out.print("Digite o ID da tarefa: ");
        
        int idTarefa;
        idTarefa = scan.nextInt();
        
        controller.concluiTarefa(idTarefa);
    }
}
