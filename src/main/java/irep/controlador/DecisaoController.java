/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.Decisao;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.persistencia.DecisaoDAO;
import java.util.ArrayList;
import java.util.List;
 
public class DecisaoController {
    List <Decisao> decisoes;
    DecisaoDAO decisaoDAO;
   
    public DecisaoController(DecisaoDAO decisaoDAO){
        this.decisaoDAO = decisaoDAO;
    }
     
    public Decisao addDecisao(int idDecisao, String descricao) throws ExcecaoIDExiste{
        Decisao d = new Decisao(idDecisao, descricao);
        
        Decisao dVerificaExistente = decisaoDAO.pesquisa(idDecisao);
        if(dVerificaExistente != null){
            throw new ExcecaoIDExiste();
        }else{
            decisaoDAO.add(d);
            return d;
        }           
    }

    public List<String> listarDecisoes() {
        decisoes  = decisaoDAO.listar();
        List <String> decisoesStr = new ArrayList<>();
        
        for (Decisao d : decisoes){
            decisoesStr.add(d.toString());
        }
        return decisoesStr;
    }

    public void efetuaVoto(boolean isVotoPositivo, int idDecisao) {
        decisoes  = decisaoDAO.listar();
        int incrementaVoto;
        for(Decisao d : decisoes){
            if(d.getIdDecisao() == idDecisao){
                if(isVotoPositivo == true){
                    incrementaVoto=d.getQuantidadeVotosSim();
                    incrementaVoto= incrementaVoto + 1;
                    d.setQuantidadeVotosSim(incrementaVoto);
                }else if(isVotoPositivo == false){
                    incrementaVoto=d.getQuantidadeVotosNao();
                    incrementaVoto= incrementaVoto + 1;
                    d.setQuantidadeVotosNao(incrementaVoto);
                }
             return;
            }
        }       
    }

    public void calculaResultado(int idDecisao) {
        decisoes  = decisaoDAO.listar();
        for(Decisao d : decisoes){
            if((d.getIdDecisao() == idDecisao)){
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
    }
}