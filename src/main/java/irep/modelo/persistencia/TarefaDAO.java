/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.persistencia;

import irep.modelo.entidade.Tarefa;
import java.util.ArrayList;
import java.util.List;


public class TarefaDAO {
    private List <Tarefa> tarefas = new ArrayList<>();
    
    public TarefaDAO (){
        this.tarefas = new ArrayList<>();
    }
    
    public void addTarefa (Tarefa t){
        tarefas.add(t);
    }
    
    public List<Tarefa> listarTarefas(){
        return tarefas;
    }
    
    public Tarefa pesquisaTarefa (int idTarefa){
        for (Tarefa t : tarefas){
            if(t.getIdTarefa() == idTarefa){
                return t;
            }
        }        
        return null;
    }    
}
