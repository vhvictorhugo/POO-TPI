/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package irep.teste.controlador;

import irep.controlador.ContaController;
import irep.modelo.entidade.Conta;
import irep.modelo.entidade.excecao.ExcecaoIDExiste;
import irep.modelo.entidade.excecao.ExcecaoContaPaga;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContaControllerTest {
    ContaController contaController;

    List<Conta> initConta() {
        // criado array auxiliar de contas, para operacoes
        List<Conta> contas = new ArrayList<>();

        // conta 1
        int idConta = 1;
        String nome = "A";
        double valorConta = 20.2;
        String vencimentoLeitura = "10/10/2010";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato);
        Conta conta = contaController.addConta(idConta, nome, valorConta, dataVencimento);
        contas.add(conta);

        // conta 2
        idConta = 2;
        nome = "B";
        valorConta = 30.3;
        vencimentoLeitura = "10/10/2020";
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataVencimento = LocalDate.parse(vencimentoLeitura, formato);
        Conta conta2 = contaController.addConta(idConta, nome, valorConta, dataVencimento);
        contas.add(conta2);
        return contas;
    }

    public ContaControllerTest() {
        contaController = new ContaController();
    }

    @Test
    // tenta adicionar conta não existente
    public void testAddConta() {

        int idConta = 3;
        String nome = "A";
        double valorConta = 20.2;
        String vencimentoLeitura = "10/10/2010";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato);

        try {
            initConta();
            contaController.addConta(idConta, nome, valorConta, dataVencimento);
        }catch(ExcecaoIDExiste ce){ }
    }

    @Test
    // tenta adicionar conta já existente
    public void testAddConta2() {

        int idConta = 1;
        String nome = "A";
        double valorConta = 20.2;
        String vencimentoLeitura = "10/10/2010";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato);

        try {
            initConta();
            contaController.addConta(idConta, nome, valorConta, dataVencimento);
        }catch(ExcecaoIDExiste ce){ }
    }

    @Test
    // verifica se as contas adicionadas foram realmente registradas
    public void testListarContas() {
        // array de string contendo as contas do banco de dados
        List<String> arrayString = contaController.listarContas();
        // array retornado pelo método initConta() contendo as contas inseridas
        List<Conta> arrayContas = initConta();
        // assert tamanhos dos arrays
        for (int index = 0; index < arrayString.size(); index++) {
            assertEquals(arrayString, arrayContas.get(index).toString());
        }
    }

    @Test
    // verifica se uma conta foi paga
    public void testPagamentoConta() {
        // teste que paga conta não paga
        Conta conta = initConta().get(0);
        // efetua pagamento conta da primeira posicao do array de contas
        // ou seja, a primeira conta inserida
        try {
            contaController.efetuaPagamentoConta(conta.getIdConta());
            assertEquals(conta.getIsPaga(), "Paga");
        } catch (ExcecaoContaPaga cp) {
        }
    }

    @Test
    // verifica se uma conta foi paga
    public void testPagamentoConta2() {
        // teste que tenta pagar conta já paga
        Conta conta = initConta().get(0);
        // efetua pagamento conta da primeira posicao do array de contas
        // ou seja, a primeira conta inserida
        try {
            contaController.efetuaPagamentoConta(conta.getIdConta());
            contaController.efetuaPagamentoConta(conta.getIdConta());
        }catch(ExcecaoContaPaga cp){
            assertEquals(conta.getIsPaga(),"Paga");
        }
    }
}