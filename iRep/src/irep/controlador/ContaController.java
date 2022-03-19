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
import java.util.ArrayList;
import java.util.List;

public class ContaController {
    
    ContaDAO contaDAO;
    
    public ContaController (){
        this.contaDAO = new ContaDAO();
    }
    
    public Conta addConta(int idConta, String nome, double valorConta, LocalDate vencimento){
        Conta c = new Conta(idConta, nome, valorConta, vencimento);
        
        Conta cVerificaExistente = contaDAO.pesquisaConta(idConta); // recebe o idAtual e verifica pelo id se há itens iguais
        
        if(cVerificaExistente != null){
            System.err.println("Conta com ID "+ idConta + " ja existente!");
            return null;
        }else{
            contaDAO.addConta(c);
            return c;
        }
        
    }
    
    public List<String> listarContas(){
        List <String> contasStr = new ArrayList<>();
        List <Conta> contas = contaDAO.listarContas();
        
        for (Conta c : contas){
            contasStr.add(c.toString());
        }        
        return contasStr;
    }
    
    // criar solucao para verificar se a conta ja esta paga
    // criar solucao para tratar id inexistente
    public void efetuaPagamentoConta(int idConta){
        for (Conta c : contaDAO.listarContas()){
            if(c.getIdConta() == idConta){
                c.setIsPaga(true);
            }            
        }
    }
}
