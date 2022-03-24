/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.persistencia;

import irep.modelo.entidade.Decisao;
import java.util.ArrayList;
import java.util.List;

public class DecisaoDAO implements GenericDAO<Decisao> {
    
    private List <Decisao> decisoes  = new ArrayList<>();
    
    public DecisaoDAO(){
        decisoes = new ArrayList<>();
    }

    @Override
    public Decisao add(Decisao d) {
        decisoes.add(d);
        return null;
    }

    @Override
    public Decisao pesquisa(int ID) {
        for(Decisao d : decisoes){
            if(d.getIdDecisao() == ID){
                return d;
            }
        }
        return null;  
    }

    @Override
    public Decisao remove(int ID) {
        Decisao decisao = pesquisa(ID);
        if(decisao != null){    // se a decisao existe
            for (Decisao d : decisoes){ // recupera o index da decisao na lista de decisaos
                if(d.getIdDecisao() == ID){
                    decisoes.remove(d);
                    return d;
                }
            }
        }
        return null; 
    }

    @Override
    public List<Decisao> listar() {
        return decisoes;
    }   
}