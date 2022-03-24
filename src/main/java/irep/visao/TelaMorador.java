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
import org.apache.log4j.Logger;
import irep.controlador.MoradorController;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoMoradorNaoPossuiTarefas;
import irep.modelo.excecao.ExcecaoNadaParaListar;
import irep.modelo.persistencia.MoradorDAO;
import irep.modelo.persistencia.TarefaDAO;

public class TelaMorador {
    Scanner scan;
    MoradorController controller;
    private static final Logger LOGGER = Logger.getLogger("irep");

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
        LOGGER.info("INICIADO: Cadastro de morador");
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
            LOGGER.debug("CADASTRO: Morador");
        }catch(ExcecaoIDExiste ce){
            LOGGER.error("Este ID já existe para Morador!");
         }
        
    }
    
    private void listarMoradores() {
        LOGGER.info("INICIADO: Listagem  de moradores");
        System.out.println("-------------- LISTAGEM DE MORADORES --------------");
        
        try{
            List <String> moradores = controller.listarMoradores();
            
            System.out.println("Total de moradores: " + moradores.size());
            for (String m : moradores){
                System.out.println(m);
            }
            LOGGER.debug("LISTAR: Morador");
        }catch(ExcecaoNadaParaListar npl) {
            LOGGER.error("Não há moradores para listar!");
        }
             
    }

    private void exibirPorID(){
        LOGGER.info("INICIADO: Exibir informações do morador");
        System.out.println("-------------- INFORMAÇÕES DO MORADOR --------------");
        
        System.out.print("Digite o ID do morador: ");
        
        int idMorador;
        idMorador = scan.nextInt();
        try{
            System.out.println(controller.exibirMoradorPorID(idMorador));
            LOGGER.debug("EXIBIR POR ID: Morador");
        }catch(ExcecaoIDNaoExiste ine){
            LOGGER.error("Não há este ID para Morador!");
        }
    }

    private void exibirTarefasAtribuidas() {
        LOGGER.info("INICIADO: Exibir tarefas do morador");
        System.out.println("-------------- TAREFAS ATRIBUÍDAS --------------");
        
        List <String> tarefas;
        
        System.out.print("Digite o ID do morador: ");
        
        int idMorador = scan.nextInt();
        
        try{
            tarefas = controller.listarTarefasAtribuidas(idMorador);
            
            System.out.println("Total de tarefas: " + tarefas.size());
            for (String t : tarefas){
                System.out.println(t);
            LOGGER.debug("EXIBIR TAREFAS ATRIBUIDAS: Morador");
            }
        }catch(ExcecaoNadaParaListar npl) {
            LOGGER.error("Não há tarefas cadastradas!");
        }
        catch(ExcecaoIDNaoExiste ine) {
            LOGGER.error("Não há este ID para Morador!");
        }
        catch(ExcecaoMoradorNaoPossuiTarefas mnpt) {}
    }
}
