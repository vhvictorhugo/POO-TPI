/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import irep.modelo.entidade.Morador;

public class MoradorDAO implements GenericDAO<Morador>{
    private List <Morador> moradores;

    public MoradorDAO(){
        this.moradores = new ArrayList<>(); 
    }

    @Override
    public Morador add(Morador m) {
        moradores.add(m);
        return m;
    }

    @Override
    public Morador pesquisa(int ID) {
        for (Morador m : moradores){
            if(m.getIdMorador() == ID){
                return m;
            }
        }        
        return null;
    }

    @Override
    public Morador remove(int ID) {
        Morador mor = pesquisa(ID);
        if(mor != null){    // se a decisao existe
            for (Morador m : moradores){ // recupera o index da decisao na lista de decisaos
                if(m.getIdMorador() == ID){
                    moradores.remove(m);
                    return m;
                }
            }
        }
        return null;
    }

    @Override
    public List<Morador> listar() {
        return moradores;
    }
    
}
