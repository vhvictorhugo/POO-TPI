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


public class ContaDAO implements GenericDAO<Conta>{
    private List <Conta> contas = new ArrayList<>();
    
    public ContaDAO (){
        
        this.contas = new ArrayList<>();
    }

    @Override
    public Conta add(Conta c) {
        contas.add(c);
        return c;
    }

    @Override
    public Conta pesquisa(int ID) {
        for(Conta c : contas){
            if(c.getIdConta() == ID){
                return c;
            }            
        }
        return null;
    }

    @Override
    public Conta remove(int ID) {
        Conta conta = pesquisa(ID);
        if(conta != null){    // se a conta existe
            for (Conta c : contas){ // recupera o index da conta na lista de contas
                if(c.getIdConta() == ID){
                    contas.remove(c);
                    return c;
                }
            }
        }
        return null;  
    }

    @Override
    public List<Conta> listar() {
        return contas;
    }
}