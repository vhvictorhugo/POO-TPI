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


public class TarefaDAO implements GenericDAO<Tarefa>{
    private List <Tarefa> tarefas;
    
    public TarefaDAO (){
        this.tarefas = new ArrayList<>();
    }

    @Override
    public Tarefa add(Tarefa t) {
        tarefas.add(t);
        return t;
    }

    @Override
    public Tarefa pesquisa(int ID) {
        for (Tarefa t : tarefas){
            if(t.getIdTarefa() == ID){
                return t;
            }
        }        
        return null;
    }

    @Override
    public Tarefa remove(int ID) {
        Tarefa tarefa = pesquisa(ID);
        if(tarefa != null){    // se a decisao existe
            for (Tarefa t : tarefas){ // recupera o index da decisao na lista de decisaos
                if(t.getIdTarefa() == ID){
                    tarefas.remove(t);
                    return t;
                }
            }
        }
        return null;
    }

    @Override
    public List<Tarefa> listar() {
        return tarefas;
    }    
}
