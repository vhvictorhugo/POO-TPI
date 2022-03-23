package irep.teste.controlador;

import org.junit.Before;
import org.junit.Test;

import irep.modelo.entidade.Tarefa;
import irep.modelo.entidade.excecao.ExcecaoIDExiste;
import irep.controlador.TarefaController;

import java.util.ArrayList;
import java.util.List;

public class TarefaControllerTest {
    TarefaController tarefaController;

    public TarefaControllerTest() {
        tarefaController = new TarefaController();
    }

    List<Tarefa> initTarefe() {
        List<Tarefa> tarefas = new ArrayList<>();

        int idTarefa = 1;
        String nome = "A";
        Tarefa tarefa = tarefaController.addTarefa(idTarefa, nome);
        tarefas.add(tarefa);

        idTarefa = 2;
        nome = "B";
        Tarefa tarefa2 = tarefaController.addTarefa(idTarefa, nome);
        tarefas.add(tarefa2);
        return tarefas;
    }

    @Test
    public void testAddTarefa() {
        int idTarefa = 1;
        String nome = "A";
        try {
            initTarefe();
            tarefaController.addTarefa(idTarefa, nome);
        } catch (ExcecaoIDExiste ce) {
        }
    }

}