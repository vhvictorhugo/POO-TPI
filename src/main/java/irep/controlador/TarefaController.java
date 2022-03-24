/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.Morador;
import irep.modelo.entidade.Tarefa;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoTarefaJaAtribuida;
import irep.modelo.persistencia.MoradorDAO;   // mudar para morador
import irep.modelo.persistencia.TarefaDAO;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {

    TarefaDAO tarefaDAO;
    MoradorDAO moradorDAO;

    public TarefaController(TarefaDAO tarefaDAO, MoradorDAO moradorDAO) {
        this.tarefaDAO = tarefaDAO;
        this.moradorDAO = moradorDAO;
    }

    public void addTarefa(int idTarefa, String nome) throws ExcecaoIDExiste{
        Tarefa t = new Tarefa(idTarefa, nome);

        Tarefa tVerificaExistente = tarefaDAO.pesquisa(idTarefa);
        if (tVerificaExistente != null) {
            throw new ExcecaoIDExiste();
        } else {
            tarefaDAO.add(t);
        }
    }

    public List<String> listarTarefas() {
        List<String> tarefasStr = new ArrayList<>();
        List<Tarefa> tarefas = tarefaDAO.listar();

        for (Tarefa t : tarefas) {
            tarefasStr.add(t.toString());
        }

        return tarefasStr;

    }

    public void efetuaAtribuicaoTarefa(int idTarefa, int idMorador) 
            throws ExcecaoIDNaoExiste, ExcecaoTarefaJaAtribuida{
        Tarefa tarefa = tarefaDAO.pesquisa(idTarefa);
        Morador morador = moradorDAO.pesquisa(idMorador);

        // verifica existencia da tarefa
        if(tarefa == null){
            throw new ExcecaoIDNaoExiste();
        }
        // verifica existencia do morador
        if (morador == null){
            throw new ExcecaoIDNaoExiste();
        }
        if(tarefa.getIdMorador() != 0){
            throw new ExcecaoTarefaJaAtribuida();
        }
        tarefaDAO.pesquisa(idTarefa).setIdMorador(idMorador);
    }

    public void concluiTarefa(int idTarefa) {
        for (Tarefa t : tarefaDAO.listar()) {
            if (t.getIdTarefa() == idTarefa) {
                t.setIsFeito(true);
            }
        }
    }
}