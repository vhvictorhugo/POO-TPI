
package irep.Visão;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class TelaUsuario {
    public void telaInicial(){
        mostarMenu();
        Scanner leitura = new Scanner(System.in);
        int opcao;
        while (true){
            opcao=leitura.nextInt();
            switch(opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                    break;
            default:
                System.err.println("Opção inválida!");
            }
        }
        
    }
    private void mostarMenu(){
        System.out.println("1-Morador");
        System.out.println("2-Republica");
        System.out.println("3-Sair");
        System.out.println("Digite um numero: ");
        
    }


}
