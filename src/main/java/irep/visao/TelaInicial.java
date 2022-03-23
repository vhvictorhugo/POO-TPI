/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;

import java.util.Scanner;

import irep.modelo.persistencia.ContaDAO;
import irep.modelo.persistencia.DecisaoDAO;
import irep.modelo.persistencia.MoradorDAO;
import irep.modelo.persistencia.TarefaDAO;

public class TelaInicial {
    Scanner scan;
    
    public TelaInicial(){
        scan = new Scanner(System.in);
    }
    
    public void mostrar(ContaDAO contaDAO, DecisaoDAO decisaoDAO, TarefaDAO tarefaDAO, MoradorDAO moradorDAO){
        int opcao;
        TelaContas telaContas = new TelaContas(contaDAO);
        TelaTarefas telaTarefas = new TelaTarefas(tarefaDAO, contaDAO);
        TelaDecisoes telaDecisoes = new TelaDecisoes(decisaoDAO);
        
        opcao = mostrarMenu();
        while (opcao != 5){            
            switch(opcao){
                case 1:
                    // morador visualiza suas informações
                    break;
                case 2:
                    // aba contas
                    telaContas.mostrar();
                    break;
                case 3:
                    // aba tarefas
                    telaTarefas.mostrar();
                    break;
                case 4:
                    // aba decisões
                    telaDecisoes.mostrar();
                    break;
            default:
                System.err.println("Opção inválida!");
            }            
            opcao = mostrarMenu();
        }        
        System.out.println("Obrigado por Utilizar");        
    }
    
    private int mostrarMenu(){
        int opcao;
        System.out.println("-------------- iRep --------------");
        System.out.println("1- Visualizar Perfil");
        System.out.println("2- Contas");
        System.out.println("3- Tarefas");
        System.out.println("4- Decisões");
        System.out.println("5- Sair");
        System.out.print("\nDigite um numero: ");
        
        opcao = scan.nextInt();
        
        return opcao;        
    }
}
