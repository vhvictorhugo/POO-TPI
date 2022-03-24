/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.Decisao;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoNadaParaListar;
import irep.modelo.excecao.ExcecaoTodosJaVotaram;
import irep.modelo.persistencia.DecisaoDAO;
import irep.modelo.persistencia.MoradorDAO;

import java.util.ArrayList;
import java.util.List;
 
public class DecisaoController {
    List <Decisao> decisoes;
    DecisaoDAO decisaoDAO;
    MoradorDAO moradorDAO;
   
    public DecisaoController(DecisaoDAO decisaoDAO, MoradorDAO moradorDAO){
        this.decisaoDAO = decisaoDAO;
        this.moradorDAO = moradorDAO;
    }
     
    public void addDecisao(int idDecisao, String descricao) throws ExcecaoIDExiste{
        Decisao d = new Decisao(idDecisao, descricao);
        
        Decisao dVerificaExistente = decisaoDAO.pesquisa(idDecisao);
        if(dVerificaExistente != null){
            throw new ExcecaoIDExiste();
        }else{
            decisaoDAO.add(d);
        }           
    }

    public List<String> listarDecisoes() throws ExcecaoNadaParaListar{
        decisoes  = decisaoDAO.listar();
        List <String> decisoesStr = new ArrayList<>();

        if(decisoes.size() == 0){
            throw new ExcecaoNadaParaListar();
        }
        
        for (Decisao d : decisoes){
            decisoesStr.add(d.toString());
        }
        return decisoesStr;
    }

    public void efetuaVoto(boolean isVotoPositivo, int idDecisao) throws ExcecaoIDNaoExiste, ExcecaoTodosJaVotaram{
        Decisao d = decisaoDAO.pesquisa(idDecisao);

        if(d == null){
            throw new ExcecaoIDNaoExiste();
        }

        // verifica se todos moradores ja votaram
        if((d.getQuantidadeVotosNao() + d.getQuantidadeVotosNao()) >= moradorDAO.listar().size()){
            throw new ExcecaoTodosJaVotaram();
        }

        int incrementaVoto;

        if(isVotoPositivo == true){
            incrementaVoto=d.getQuantidadeVotosSim();
            incrementaVoto= incrementaVoto + 1;
            d.setQuantidadeVotosSim(incrementaVoto);
        }else{
            incrementaVoto=d.getQuantidadeVotosNao();
            incrementaVoto= incrementaVoto + 1;
            d.setQuantidadeVotosNao(incrementaVoto);
        }
    }

    public void calculaResultado(int idDecisao) throws ExcecaoIDNaoExiste{
        Decisao d = decisaoDAO.pesquisa(idDecisao);

        if(d == null){
            throw new ExcecaoIDNaoExiste();
        }

        if(d.getQuantidadeVotosSim() > d.getQuantidadeVotosNao()){
            d.setIsTomada(1);
            System.out.println("Calculo efetuado com sucesso!");
            return;
        }else{  // se a decisao nao foi aceita, mesmo que haja empate, ela é recusada, pois é necessário o consenso da maioria
            d.setIsTomada(2);
            System.out.println("Calculo efetuado com sucesso!");
            return;
        }
    }
}