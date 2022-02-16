/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep;

import irep.Visão.TelaUsuario;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception{
        TelaUsuario tela = new TelaUsuario();
        tela.telaInicial();
//        Principal principal = new Principal();
//        List<Morador> moradores = new LinkedList<Morador>();
//        List<Conta> contas = new LinkedList<Conta>();
//        List<Tarefa> tarefas = new LinkedList<Tarefa>();        
//
//        principal.cadastraMorador(moradores);
//        for (int i = 0; i < moradores.size(); i++) {
//            System.out.println(moradores.get(i));
//        }
//
//        principal.cadastraConta(contas);
//        for (int i = 0; i < contas.size(); i++) {
//            System.out.println(contas.get(i));
//        }
//        
//        principal.cadastraTarefa(tarefas);
//        for (int i = 0; i < tarefas.size(); i++) {
//            System.out.println(tarefas.get(i));           
//        }
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
    public void cadastraTarefa(List tarefas){
        System.out.println("---------- CADASTRO DE TAREFAS ----------");
        
        int qtTarefas;
        String nome;
        long idTarefa;
        
        Scanner scan = new Scanner(System.in); 
        
        System.out.print("\nEntre com a quantidade de tarefas a cadastrar: ");        
        
        qtTarefas = scan.nextInt();
        
        for (int i = 0; i < qtTarefas; i++) {
            
            System.out.println("---------- TAREFA "+(i+1)+" ----------");
            System.out.print("Entre com o nome da Tarefa: ");
            if(i == 0) scan.nextLine();    // conserta bug scan
            nome = scan.nextLine();
            System.out.print("Entre com o id: ");
            idTarefa = scan.nextLong();
            Tarefa tarefa = new Tarefa(nome, idTarefa);            
            tarefas.add(tarefa);
        }
    }
}
