package irep;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import irep.controlador.ContaController;
import irep.controlador.DecisaoController;
import irep.controlador.MoradorController;
import irep.controlador.TarefaController;
import irep.modelo.entidade.Conta;
import irep.modelo.entidade.Decisao;
import irep.modelo.entidade.Tarefa;
import irep.modelo.excecao.ExcecaoContaPaga;
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoNadaParaListar;
import irep.modelo.excecao.ExcecaoTodosJaVotaram;
import irep.modelo.excecao.ExcecaoTarefaJaConcluida;
import irep.modelo.excecao.ExcecaoTarefaNaoAtribuida;
import irep.modelo.excecao.ExcecaoTarefaJaAtribuida;
import irep.modelo.excecao.ExcecaoMoradorNaoPossuiTarefas;
import irep.modelo.persistencia.TarefaDAO;
import irep.modelo.persistencia.MoradorDAO;
import irep.modelo.persistencia.ContaDAO;
import irep.modelo.persistencia.DecisaoDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Unit test for simple App.
 */

public class AppTest {
    ContaController contaController;
    TarefaController tarefaController;
    DecisaoController decisaoController;
    MoradorController moradorController;
    ContaDAO contaDAO;
    TarefaDAO tarefaDAO;
    DecisaoDAO decisaoDAO;
    MoradorDAO moradorDAO;

    void initBeforeAll() {
        contaDAO = new ContaDAO();
        tarefaDAO = new TarefaDAO();
        decisaoDAO = new DecisaoDAO();
        moradorDAO = new MoradorDAO();

        contaController = new ContaController(contaDAO);
        tarefaController = new TarefaController(tarefaDAO, moradorDAO);
        decisaoController = new DecisaoController(decisaoDAO, moradorDAO);
        moradorController = new MoradorController(moradorDAO, tarefaDAO);
        String vencimentoLeitura = "10/10/2010";
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato);
        contaController.addConta(1, "AC", 20.2, dataVencimento);
        contaController.addConta(2, "BC", 30.3, dataVencimento);
        tarefaController.addTarefa(1, "AT");
        tarefaController.addTarefa(2, "BT");
        moradorController.addMorador(1, "AM ", "J", "cdc", dataVencimento);
        moradorController.addMorador(2, "BM ", "Y", "eal", dataVencimento);
        decisaoController.addDecisao(1, "AaaaaD");
        decisaoController.addDecisao(2, "BbbbbD");
    }

    @Test
    public void testListaContas() {
        try {
            initBeforeAll();
            List<String> lista = contaController.listarContas();
            assert (lista.size() == 2);
        } catch (ExcecaoNadaParaListar npl) {
        }
    }

    @Test
    public void testEfetuaPagamento() {
        try {
            initBeforeAll();
            contaController.efetuaPagamentoConta(1);
            Conta conta = contaDAO.pesquisa(1);
            assertEquals(conta.getIsPaga(), "Paga");
        } catch (ExcecaoIDNaoExiste ine) {
        } catch (ExcecaoContaPaga cp) {
        }
    }

    @Test
    public void testExibeEmAberto() {
        try {
            initBeforeAll();
            List<String> lista = contaController.exibirContasEmAberto();
            assert (lista.size() == 2);
        } catch (ExcecaoNadaParaListar npl) {
        }
    }

    @Test
    public void testListarDecisao() {
        try {
            initBeforeAll();
            List<String> lista = decisaoController.listarDecisoes();
            assert (lista.size() == 2);
        } catch (ExcecaoNadaParaListar npl) {
        }
    }

    @Test
    public void testEfetuaVoto() {
        try {
            initBeforeAll();
            decisaoController.efetuaVoto(true, 1);
            Decisao decisao = decisaoDAO.pesquisa(1);
            assert (decisao.getQuantidadeVotosSim() == 1);
        } catch (ExcecaoIDNaoExiste ine) {
        } catch (ExcecaoTodosJaVotaram tdjv) {
        }
    }

    @Test
    public void testCalculaResultado() {
        try {
            initBeforeAll();
            decisaoController.efetuaVoto(true, 1);
            decisaoController.calculaResultado(1);
            Decisao decisao = decisaoDAO.pesquisa(1);
            assertEquals(decisao.getIsTomada(), "Aceita");
        } catch (ExcecaoIDNaoExiste ine) {
        }
    }

    @Test
    public void testEfetuaAtribuicaoTarefa() {
        try {
            initBeforeAll();
            tarefaController.efetuaAtribuicaoTarefa(1, 1);
            Tarefa tarefa = tarefaDAO.pesquisa(1);
            assert (tarefa.getIdMorador() == 1);
        } catch (ExcecaoIDNaoExiste ine) {
        } catch (ExcecaoTarefaJaAtribuida tja) {
        }
    }

    @Test
    public void testConcluiTarefa() {
        try {
            initBeforeAll();
            tarefaController.concluiTarefa(1);
            Tarefa tarefa = tarefaDAO.pesquisa(1);
            assertEquals(tarefa.getIsFeito(),"Feita");
        } catch (ExcecaoIDNaoExiste ine) {
        } catch (ExcecaoTarefaJaConcluida tjc) {
        }  catch (ExcecaoTarefaNaoAtribuida tna) {
        }
    }
    @Test
    public void testListarTarefa() {
        try {
            initBeforeAll();
            List<String> lista = tarefaController.listarTarefas();
            assert (lista.size() == 2);
        } catch (ExcecaoNadaParaListar npl) {
        }
    }
    @Test
    public void testListarMorador() {
        try {
            initBeforeAll();
            List<String> lista = moradorController.listarMoradores();
            assert (lista.size() == 2);
        } catch (ExcecaoNadaParaListar npl) {
        }
    }
    @Test
    public void testListarTarefasAtribuidas() {
        try {
            initBeforeAll();
            List<String> lista = moradorController.listarTarefasAtribuidas(1);
            assert (lista.size() == 1);
        } 
        catch (ExcecaoIDNaoExiste inexistente) {
        }catch (ExcecaoNadaParaListar npl) {
        }catch (ExcecaoMoradorNaoPossuiTarefas mnpt) {
        }
    }
    @Test
    public void testExibirMoradorPorID() {
        try {
            initBeforeAll();
            String morador = moradorController.exibirMoradorPorID(3);
        } 
        catch (ExcecaoIDNaoExiste inexistente) {
            assert (true);
        }catch (ExcecaoNadaParaListar npl) {
        }catch (ExcecaoMoradorNaoPossuiTarefas mnpt) {
        }
    }

}