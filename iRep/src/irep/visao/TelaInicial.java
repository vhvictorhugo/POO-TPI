/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;

import java.util.Scanner;


public class TelaInicial {
    Scanner scan;
    
    public TelaInicial(){
        scan = new Scanner(System.in);
    }
    
    public void mostrar(){
        int opcao;
        
        opcao = mostrarMenu();
        while (opcao != 5){
            
            switch(opcao){
                case 1:
                    // morador visualiza suas informações
                    break;
                case 2:
                    // aba contas
                    break;
                case 3:
                    // aba tarefas
                    break;
                case 4:
                    // aba decisões
                    break;
                case 5:
                    // aba decisões
                    System.exit(0);
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
        System.out.println("1-Visualizar Perfil");
        System.out.println("2-Contas");
        System.out.println("3-Tarefas");
        System.out.println("4-Decisões");
        System.out.println("5- Sair");
        System.out.println("\nDigite um numero: ");
        
        opcao = scan.nextInt();
        
        return opcao;
        
    }


}
