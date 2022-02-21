/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import irep.modelo.entidade.Decisao;
import irep.modelo.persistencia.DecisaoDAO;
import java.util.ArrayList;
import java.util.List;

public class DecisaoController {
    
    DecisaoDAO decisaoDAO;    
    
    public DecisaoController(){
        decisaoDAO = new DecisaoDAO();
        
    }

    public void addDecisao(int idDecisao, String descricao) {
        Decisao d = new Decisao(idDecisao, descricao);
        
        Decisao dVerificaExistente = decisaoDAO.pesquisaDecisao(idDecisao);
        if(dVerificaExistente != null){
            System.err.println("Decisao com ID "+ idDecisao + " ja existente!");
            return;
        }
            
        decisaoDAO.addDecisao(d);
    }

    public List<String> listarDecisoes() {
        List <Decisao> decisoes = decisoes  = decisaoDAO.listarDecisoes();
        List <String> decisoesStr = new ArrayList<>();
        
        for (Decisao d : decisoes){
            decisoesStr.add(d.toString());
        }
        
        
        return decisoesStr;
    }

    public void efetuaVoto(int idDecisao, int quantidadeVotosSim, int quantidadeVotosNao) {        
        List <Decisao> decisoes = decisoes  = decisaoDAO.listarDecisoes();
        
        Decisao decisao = decisaoDAO.pesquisaDecisao(idDecisao);
        
        int votosAtuaisPositivos = decisao.getQuantidadeVotosSim();
        int votosAtuaisNegativos = decisao.getQuantidadeVotosNao();
        
        int votosNovosPositivos = votosAtuaisPositivos + quantidadeVotosSim;
        int votosNovosNegativos = votosAtuaisNegativos + quantidadeVotosNao;
        
        decisao.setQuantidadeVotosSim(votosNovosPositivos);
        decisao.setQuantidadeVotosNao(votosNovosNegativos);
    }

    public void calculaResultado(int idDecisao) {
        List <Decisao> decisoes = decisoes  = decisaoDAO.listarDecisoes();
        for(Decisao d : decisoes){
            if((d.getIdDecisao() == idDecisao)){
                if(d.getQuantidadeVotosSim() > d.getQuantidadeVotosNao()){
                    d.setIsTomada(1);
                    System.out.println("Calculo efetuado com sucesso!");
                    return;
                }else if(d.getQuantidadeVotosSim() < d.getQuantidadeVotosNao()){
                    d.setIsTomada(2);
                    System.out.println("Calculo efetuado com sucesso n!");
                    return;
                }
            }
        }
        System.out.println("Calculo efetuado com sucesso!");
    }
}  
