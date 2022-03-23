/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.Decisao;
import irep.modelo.entidade.excecao.ExcecaoIDExiste;
import irep.modelo.persistencia.DecisaoDAO;
import java.util.ArrayList;
import java.util.List;
 
public class DecisaoController {
    List <Decisao> decisoes;
    DecisaoDAO decisaoDAO;    
   
    public DecisaoController(){
        decisaoDAO = new DecisaoDAO();
    }
     
    public Decisao addDecisao(int idDecisao, String descricao) throws ExcecaoIDExiste{
        Decisao d = new Decisao(idDecisao, descricao);
        
        Decisao dVerificaExistente = decisaoDAO.pesquisaDecisao(idDecisao);
        if(dVerificaExistente != null){
            throw new ExcecaoIDExiste();
        }else{
            decisaoDAO.addDecisao(d);
            return d;
        }           
    }

    public List<String> listarDecisoes() {
        decisoes  = decisaoDAO.listarDecisoes();
        List <String> decisoesStr = new ArrayList<>();
        
        for (Decisao d : decisoes){
            decisoesStr.add(d.toString());
        }
        return decisoesStr;
    }

    public void efetuaVoto(boolean isVotoPositivo, int idDecisao) {
        decisoes  = decisaoDAO.listarDecisoes();
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
        decisoes  = decisaoDAO.listarDecisoes();
        for(Decisao d : decisoes){
            if((d.getIdDecisao() == idDecisao)){
                if(d.getQuantidadeVotosSim() > d.getQuantidadeVotosNao()){
                    d.setIsTomada(1);
                    System.out.println("Calculo efetuado com sucesso!");
                    return;
                }else if(d.getQuantidadeVotosSim() < d.getQuantidadeVotosNao()){
                    d.setIsTomada(2);
                    System.out.println("Calculo efetuado com sucesso!");
                    return;
                }
            }
        } 
    }
}  
