/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws Exception{
        
        Principal principal = new Principal();
        List<Morador> moradores = new LinkedList<Morador>();
        List<Conta> contas = new LinkedList<Conta>();

        principal.cadastraConta(contas);
        System.out.println(contas.get(0).getNome());
        System.out.println(contas.get(0).getValorConta());
        System.out.println(contas.get(0).getValorEmAberto());
        System.out.println(contas.get(0).getVencimento());
        /*principal.cadastraMorador(moradores);
        System.out.println(moradores.get(0).getNome());
        System.out.println(moradores.get(0).getApelido());
        System.out.println(moradores.get(0).getIdade());
        System.out.println(moradores.get(0).getDataEntrada());
        System.out.println(moradores.get(0).getDataNascimento());
        System.out.println(moradores.get(0).getCurso());*/
    }
    
    public void cadastraMorador(List moradores)throws Exception {
        System.out.println("---------- CADASTRO DE MORADORES ----------");
        
        int qtMoradores;
        String nome, apelido, curso, dataNascimentoLeitura;
        
        Scanner scan = new Scanner(System.in); 
        
        System.out.print("\nEntre com a quantidade de moradores a cadastrar: ");        
        
        qtMoradores = scan.nextInt();
        
        for (int i = 0; i < qtMoradores; i++) {
            
            System.out.println("---------- MORADOR "+(i+1)+" ----------");
            System.out.print("Entre com o nome: ");
            if(i == 0) scan.nextLine();    // conserta bug scan
            nome = scan.nextLine();            
            System.out.print("Entre com o apelido: ");
            apelido = scan.nextLine();
            System.out.print("Entre com o curso: ");
            curso = scan.nextLine();
            System.out.print("Entre com a data de nascimento (dd/MM/yyyy): ");
            dataNascimentoLeitura = scan.nextLine();
            
            // converte data do tipo 'String' em data do tipo 'Date'
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            LocalDate dataNascimento = LocalDate.parse(dataNascimentoLeitura, formato); 
            
            Morador morador = new Morador(nome, apelido, curso, dataNascimento);            
            moradores.add(morador);
        }
    }
    
    public void cadastraConta(List contas){
        System.out.println("---------- CADASTRO DE CONTAS ----------");
        
        int qtContas;
        String nome, vencimentoLeitura;
        double valorConta;
        
        Scanner scan = new Scanner(System.in); 
        
        System.out.print("\nEntre com a quantidade de contas a cadastrar: ");        
        
        qtContas = scan.nextInt();
        
        for (int i = 0; i < qtContas; i++) {
            
            System.out.println("---------- CONTA "+(i+1)+" ----------");
            System.out.print("Entre com o nome: ");
            if(i == 0) scan.nextLine();    // conserta bug scan
            nome = scan.nextLine();
            System.out.print("Entre com o valor: ");
            valorConta = scan.nextDouble();
            System.out.print("Entre com a data de vencimento (dd/MM/yyyy): ");
            if(i == 0) scan.nextLine();    // conserta bug scan
            vencimentoLeitura = scan.nextLine();
            
            // converte data do tipo 'String' em data do tipo 'Date'
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
            LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato); 
            
            Conta conta = new Conta(nome, valorConta, dataVencimento);            
            contas.add(conta);
        }
    }
}
