/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.Conta;
import irep.modelo.persistencia.ContaDAO;
import java.time.LocalDate;

public class ContaController {
    
    ContaDAO contaDAO;
    
    public ContaController (){
        this.contaDAO = new ContaDAO();
    }
    
    public void addConta(int idConta, String nome, double valorConta, LocalDate vencimento){
        Conta c = new Conta(idConta, nome, valorConta, vencimento);
        
        Conta cVerificaExistente = contaDAO.pesquisaConta(idConta); // recebe o idAtual e verifica pelo id se há itens iguais
        
        if(cVerificaExistente != null){
            System.err.println("Produto com ID "+ idConta + " ja existente!");
        }else{
            contaDAO.addConta(c);
        }
        
    }
    
    public String listarContas(){
        String contasStr = "";
        if (contaDAO.listarContas().size() > 0){            
            contasStr += contaDAO.listarContas().toString();
            return contasStr;
        }
        
        return "Sem contas cadastradas!";
    }
    
    public void efetuaPagamentoConta(int idConta){
        for (Conta c : contaDAO.listarContas()){
            if(c.getIdConta() == idConta){
                c.setIsPaga(true);
            }            
        }
    }
}
