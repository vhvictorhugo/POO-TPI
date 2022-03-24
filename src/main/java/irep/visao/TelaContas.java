/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;
import irep.controlador.ContaController;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoNadaParaListar;
import irep.modelo.persistencia.ContaDAO;
import irep.modelo.excecao.ExcecaoContaPaga;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class TelaContas {
    Scanner scan;
    ContaController controller;
    private static final Logger LOGGER = Logger.getLogger("irep");
    
    public TelaContas (ContaDAO contaDAO){        
        this.scan = new Scanner(System.in);
        this.controller = new ContaController(contaDAO);
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
        LOGGER.info("INICIADO: Cadastro de conta");
        System.out.println("-------------- CADASTRO DE CONTAS --------------");
        System.out.print("Entre com o ID da conta: ");
        int idConta = scan.nextInt();        
        
        System.out.print("Entre com o nome: ");
        String nome = scan.next();        
        
        System.out.print("Entre com o valor: ");
        double valorConta = scan.nextDouble();  
        
        System.out.print("Entre com a data de vencimento (dd/MM/yyyy): ");
        String vencimentoLeitura = scan.next();
        // converte data do tipo 'String' em data do tipo 'LocalDate'c
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato); 

        try{
            controller.addConta(idConta, nome, valorConta, dataVencimento);
            LOGGER.debug("CADASTRO: Conta");
        }catch(ExcecaoIDExiste ce){
            LOGGER.error("Este ID já existe para Conta!");
        }   
    }
    
    private void listarContas() {
        LOGGER.info("INICIADO: Listagem  de contas");
        System.out.println("-------------- LISTAGEM DE CONTAS --------------");
        try{
        List<String> contas = controller.listarContas();
            System.out.println("Total de contas: "+ contas.size());
            for (String c : contas){
                System.out.println(c);
            }
            LOGGER.debug("LISTAR: Morador");
        }catch(ExcecaoNadaParaListar npl){
            LOGGER.error("Não há contas para listar!");
        }
    }
    
    private void pagamentoConta(){
        LOGGER.info("INICIADO: Pagamento de contas");
        System.out.println("-------------- PAGAMENTO DE CONTAS --------------");
        
        System.out.println("Contas a pagar:");
        
        try{
            for(String s : controller.exibirContasEmAberto()){
                System.out.println(s);
            }        
            
            System.out.print("Digite o ID da conta a ser paga: ");
            
            int idConta;
            idConta = scan.nextInt();
            
            try{
                controller.efetuaPagamentoConta(idConta); 
                LOGGER.debug("EFETUA PAGAMENTO: Conta");
            }catch(ExcecaoContaPaga cp){ }
            catch(ExcecaoIDNaoExiste ine){
                LOGGER.error("Não há este ID para Conta!");
             }
        }catch(ExcecaoNadaParaListar npl){
            LOGGER.error("Não há contas em aberto!");
        }            
    }
}