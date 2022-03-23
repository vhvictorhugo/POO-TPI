/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.excecao.ExcecaoIDExiste;
import irep.modelo.entidade.excecao.ExcecaoTarefaNaoExiste;
import irep.modelo.entidade.Tarefa;
import irep.modelo.persistencia.TarefaDAO;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {

    TarefaDAO tarefaDAO;

    public TarefaController() {
        tarefaDAO = new TarefaDAO();
    }

    public Tarefa addTarefa(int idTarefa, String nome) {
        Tarefa t = new Tarefa(idTarefa, nome);

        Tarefa tVerificaExistente = tarefaDAO.pesquisaTarefa(idTarefa);
        if (tVerificaExistente != null) {
            throw new ExcecaoIDExiste();
        } else {
            tarefaDAO.addTarefa(t);
            return t;
        }
    }

    public List<String> listarTarefas() {
        List<String> tarefasStr = new ArrayList<>();
        List<Tarefa> tarefas = tarefaDAO.listarTarefas();

        for (Tarefa t : tarefas) {
            tarefasStr.add(t.toString());
        }

        return tarefasStr;

    }

    public void efetuaAtribuicaoTarefa(int idTarefa, int idMorador) {
        for (Tarefa t : tarefaDAO.listarTarefas()) {

            if (t.getIdTarefa() == idTarefa) {
                if (t.getIdTarefa() == idMorador) {
                    t.setIdTarefa(idTarefa);
                    t.setIdMorador(idMorador);
                    t.setIsFeito(false);
                } else {
                    throw new ExcecaoIDExiste();
                }
            } else {
                throw new ExcecaoTarefaNaoExiste();
            }
        }
    }

    public void concluiTarefa(int idTarefa) {
        for (Tarefa t : tarefaDAO.listarTarefas()) {
            if (t.getIdTarefa() == idTarefa) {
                t.setIsFeito(true);
            }
        }
    }
}
