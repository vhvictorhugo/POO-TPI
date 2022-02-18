
package irep.visao;

import irep.controlador.ContaController;
import irep.modelo.entidade.Conta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TelaContas {
    Scanner scan;
    
    public TelaContas (){        
        scan = new Scanner(System.in);        
    }
    
    public void mostrar(ContaController controller){
        int opcao;
        
        opcao = mostrarMenu();
        while (opcao != 4){            
            switch(opcao){
                case 1:
                    // Cadastrar conta
                    controller.addConta(cadastroConta());
                    System.out.println("Conta adicionada com sucesso!");
                    break;
                case 2:
                    // listar contas                    
                    System.out.println(controller.listarContas());
                    System.out.println("Listagem efetuada com sucesso!");
                    break;
                case 3:
                    // pagar conta
                    System.out.print("Digite o ID da conta (de acordo com o indice) a ser paga: ");
                    int idConta = scan.nextInt();
                    controller.efetuaPagamentoConta(idConta);
                    System.out.println("Conta paga com sucesso!");
                    break;
            default:
                System.err.println("Opção inválida!");
            }
            
            opcao = mostrarMenu();
        }        
    }
    
    private int mostrarMenu(){
        int opcao;
        System.out.println("-------------- CONTAS --------------");
        System.out.println("1- Cadastrar Contas");
        System.out.println("2- Listar Contas");
        System.out.println("3- Pagar Conta");
        System.out.println("4- Sair");
        System.out.print("\nDigite um numero: ");
        
        opcao = scan.nextInt();
        
        return opcao;
        
    }
    
    private Conta cadastroConta(){
        System.out.println("-------------- CADASTRO DE CONTAS --------------");
        
        System.out.print("Entre com o nome: ");
        scan.nextLine();
        String nome = scan.nextLine();        
        
        System.out.print("Entre com o valor: ");
        double valorConta = scan.nextDouble();        
        
        scan.nextLine();
        System.out.print("Entre com a data de vencimento (dd/MM/yyyy): ");
        String vencimentoLeitura = scan.nextLine();
        // converte data do tipo 'String' em data do tipo 'LocalDate'c
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato); 

        Conta conta = new Conta(nome, valorConta, dataVencimento);
        
        return conta;
    }   

}
