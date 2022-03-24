/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.visao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import irep.controlador.MoradorController;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.persistencia.MoradorDAO;
import irep.modelo.persistencia.TarefaDAO;

public class TelaMorador {
    Scanner scan;
    MoradorController controller;

    public TelaMorador (MoradorDAO moradorDAO, TarefaDAO tarefaDAO){
        scan = new Scanner(System.in);
        controller = new MoradorController(moradorDAO, tarefaDAO);
    }

    public void mostrar(){
        int opcao;
        
        opcao = mostrarMenu();
        while (opcao != 5){
            switch(opcao){
                case 1:
                    // Cadastrar morador
                    cadastroMorador();
                    break;
                case 2:
                    // listar moradores
                    listarMoradores();                    
                    break;
                case 3:
                    // exibir por id
                    exibirPorID();                    
                    break;
                case 4:
                    // exibir por id
                    exibirTarefasAtribuidas();                    
                    break;
                default:
                    System.err.println("Opção inválida!");
            }            
            opcao = mostrarMenu();
        }
    }    

    private int mostrarMenu(){
        int opcao;
        System.out.println("-------------- MORADOR --------------");
        System.out.println("1- Cadastrar Morador");
        System.out.println("2- Listar Moradores");
        System.out.println("3- Exibir informações por ID");
        System.out.println("4- Exibir Tarefas Atribuídas");
        System.out.println("5- Sair");
        System.out.print("\nDigite um numero: ");
        
        opcao = scan.nextInt();
        
        return opcao;
    }
    // String nome, String apelido, String curso, LocalDate dataNascimento
    private void cadastroMorador() {
        System.out.println("-------------- CADASTRO DE MORADORES --------------");
        System.out.print("Entre com o ID do morador: ");
        int idMorador = scan.nextInt();
        
        System.out.print("Entre com o nome: ");
        String nome = scan.next();
        
        System.out.print("Entre com o apelido: ");
        String apelido = scan.next();
        
        System.out.print("Entre com o curso: ");
        String curso = scan.next();

        System.out.print("Entre com a data de nascimento (dd/MM/yyyy): ");
        String nascimentoLeitura = scan.next();
        // converte data do tipo 'String' em data do tipo 'LocalDate'c
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataNascimento = LocalDate.parse(nascimentoLeitura, formato);

        try{
            controller.addMorador(idMorador, nome, apelido, curso, dataNascimento);
        }catch(ExcecaoIDExiste ce){ }
        
    }
    
    private void listarMoradores() {
       System.out.println("-------------- LISTAGEM DE MORADORES --------------");
       List <String> moradores = controller.listarMoradores();
       
       if(moradores.size() < 0){
           System.err.println("Sem moradores cadastrados!");
           return;
       }
       
       System.out.println("Total de moradores: " + moradores.size());
       for (String m : moradores){
           System.out.println(m);
       }       
    }

    private void exibirPorID(){
        System.out.println("-------------- INFORMAÇÕES DO MORADOR --------------");
        
        System.out.print("Digite o ID do morador: ");
        
        int idMorador;
        idMorador = scan.nextInt();

        System.out.println(controller.exibirMoradorPorID(idMorador));
    }

    private void exibirTarefasAtribuidas() {
        System.out.println("-------------- TAREFAS ATRIBUÍDAS --------------");
        List <String> tarefas;

        System.out.print("Digite o ID do morador: ");
        
        int idMorador;
        idMorador = scan.nextInt();

        tarefas = controller.listarTarefasAtribuidas(idMorador);
        
        if(tarefas.size() < 0){
            System.err.println("Sem tarefas atribuidas!");
            return;
        }
        
        System.out.println("Total de tarefas atribuidas: " + tarefas.size());
        for (String t : tarefas){
            System.out.println(t);
        }
    }
}
