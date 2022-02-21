/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;

import irep.controlador.ContaController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TelaContas {
    Scanner scan;
    ContaController controller;
    
    public TelaContas (){        
        scan = new Scanner(System.in);   
        controller = new ContaController();
    }
    
    public void mostrar(){
        int opcao;
        
        opcao = mostrarMenu();
        while (opcao != 4){            
            switch(opcao){
                case 1:
                    // Cadastrar conta
                    cadastroConta();
                    break;
                case 2:
                    // listar contas
                    listarContas();                    
                    break;
                case 3:
                    // pagar conta
                    pagamentoConta();                    
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
    
    private void cadastroConta(){
        System.out.println("-------------- CADASTRO DE CONTAS --------------");
        
        System.out.print("Entre com o ID da conta: ");
        scan.nextLine();
        int idConta = scan.nextInt();
        
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

        controller.addConta(idConta, nome, valorConta, dataVencimento);
        
    }
    
    private void listarContas() {
        System.out.println("-------------- LISTAGEM DE CONTAS --------------");
        List<String> contas = controller.listarContas();
        
        if(contas.size() < 0){
           System.err.println("Sem contas cadastradas!");
           return;
       }
        
        System.out.println("Total de contas: "+ contas.size());
        for (String c : contas){
            System.out.println(c);
        }
    }
    
    private void pagamentoConta(){
        System.out.println("-------------- PAGAMENTO DE CONTAS --------------");
        
        System.out.print("Digite o ID da conta a ser paga: ");
        
        int idConta;
        idConta = scan.nextInt();
        
        controller.efetuaPagamentoConta(idConta); 
        
    }
}
