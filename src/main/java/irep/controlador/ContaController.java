/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.Conta;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.excecao.ExcecaoContaPaga;
import irep.modelo.persistencia.ContaDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContaController {

    ContaDAO contaDAO;

    public ContaController(ContaDAO contaDAO) {
        this.contaDAO = contaDAO;
    }
    
    public Conta addConta(int idConta, String nome, double valorConta, LocalDate vencimento) throws ExcecaoIDExiste{

        Conta c = new Conta(idConta, nome, valorConta, vencimento);
      
        Conta cVerificaExistente = contaDAO.pesquisaConta(idConta); // recebe o idAtual e verifica pelo id se há itens
                                                                    // iguais
        if(cVerificaExistente != null){
            throw new ExcecaoIDExiste();
        }else{        
          contaDAO.addConta(c);
            return c;
        }
    }

    public List<String> listarContas() {
        List<String> contasStr = new ArrayList<>();
        List<Conta> contas = contaDAO.listarContas();

        for (Conta c : contas) {
            contasStr.add(c.toString());
        }
        return contasStr;
    }

    // criar solucao para verificar se a conta ja esta paga
    // criar solucao para tratar id inexistente
    public void efetuaPagamentoConta(int idConta) throws ExcecaoContaPaga {
        for (Conta c : contaDAO.listarContas()) {
            if (c.getIdConta() == idConta) {
                if ("Em Aberto".equals(c.getIsPaga())) {
                    c.setIsPaga(true);
                } else {
                    throw new ExcecaoContaPaga();
                }
            }
        }
    }
}