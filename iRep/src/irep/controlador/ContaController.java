
package irep.controlador;

import irep.modelo.entidade.Conta;
import java.util.ArrayList;
import java.util.List;

public class ContaController {
    
    private List <Conta> contas = new ArrayList<>();
    
    public ContaController (){
        this.contas = new ArrayList();
    }
    
    public void addConta(Conta c){
        contas.add(c);
    }
    
    public String listarContas(){
        String contasStr = "";
        
        contasStr += contas.toString();
        
        return contasStr;
    }
    
    public void efetuaPagamentoConta(int idConta){
        contas.get(idConta).setIsPaga(true);
    }
}
