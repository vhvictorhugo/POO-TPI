/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.persistencia;

import irep.modelo.entidade.Conta;
import java.util.ArrayList;
import java.util.List;


public class ContaDAO {
    private List <Conta> contas = new ArrayList<>();
    
    public ContaDAO (){
        
        this.contas = new ArrayList();
    }
    
    public void addConta(Conta c){
        contas.add(c);
    }
    
    public List<Conta> listarContas(){
        return contas;
    }
    
    public Conta pesquisaConta(int idConta){
        for(Conta c : contas){
            if(c.getIdConta() == idConta){
                return c;
            }            
        }
        return null;
    }
}