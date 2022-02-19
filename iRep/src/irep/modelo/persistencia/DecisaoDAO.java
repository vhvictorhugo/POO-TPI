
package irep.modelo.persistencia;

import irep.modelo.entidade.Decisao;
import java.util.ArrayList;
import java.util.List;

public class DecisaoDAO {
    
    private List <Decisao> decisoes  = new ArrayList<>();
    
    public DecisaoDAO(){
        decisoes = new ArrayList();
    }
    
    public void addDecisao(Decisao d){
        decisoes.add(d);
    }
    
    public List<Decisao> listarDecisoes() {
        return decisoes;
    }
    
    public Decisao pesquisaDecisao(int idDecisao){
        for(Decisao d : decisoes){
            if(d.getIdDecisao() == idDecisao){
                return d;
            }
        }
        return null;     
    }

    
}
