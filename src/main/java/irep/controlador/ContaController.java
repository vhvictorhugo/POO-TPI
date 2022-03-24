/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.Conta;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoNadaParaListar;
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
    
    public void addConta(int idConta, String nome, double valorConta, LocalDate vencimento) throws ExcecaoIDExiste{

        Conta c = new Conta(idConta, nome, valorConta, vencimento);
      
        Conta cVerificaExistente = contaDAO.pesquisa(idConta); // recebe o idAtual e verifica pelo id se há itens
                                                                    // iguais
        if(cVerificaExistente != null){
            throw new ExcecaoIDExiste();
        }else{        
          contaDAO.add(c);
        }
    }

    public List<String> listarContas() throws ExcecaoNadaParaListar{
        List<String> contasStr = new ArrayList<>();
        List<Conta> contas = contaDAO.listar();

        if(contas.size() == 0){
            throw new ExcecaoNadaParaListar();
       }

        for (Conta c : contas) {
            contasStr.add(c.toString());
        }
        return contasStr;
    }

    // criar solucao para verificar se a conta ja esta paga
    // criar solucao para tratar id inexistente
    public void efetuaPagamentoConta(int idConta) throws ExcecaoContaPaga, ExcecaoIDNaoExiste {
        Conta conta = contaDAO.pesquisa(idConta);

        if(conta == null){
            throw new ExcecaoIDNaoExiste();
        }

        if ("Em Aberto".equals(conta.getIsPaga())) {
            conta.setIsPaga(true);
        } else {
            throw new ExcecaoContaPaga();
        }
    }

    public List<String> exibirContasEmAberto() {
        List<Conta> contas = contaDAO.listar();
        List<String> contasEmAbertoStr = new ArrayList<>();

        for(Conta c : contas){
            if(c.getIsPaga().equals("Em Aberto")){
                contasEmAbertoStr.add(c.toString());
            }
        }

        if((contas.size() == 0) || (contasEmAbertoStr.size() == 0)){
            throw new ExcecaoNadaParaListar();
        }
        return contasEmAbertoStr;
    }
}