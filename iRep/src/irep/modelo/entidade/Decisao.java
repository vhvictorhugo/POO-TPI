/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.entidade;

public class Decisao {
    
    private int idDecisao, quantidadeVotosSim,quantidadeVotosNao;
    private String descricao;
    private int isTomada;   // 0 pedendete, 1 para aceita, 2 para recusada
    
    public Decisao (int idDecisao, String descricao){
        this.idDecisao = idDecisao;
        this.descricao = descricao;
        this.quantidadeVotosSim = 0;
        this.quantidadeVotosNao = 0;
        this.isTomada = 0;
    }
    
    // Getters
    public int getIdDecisao(){ return this.idDecisao; }
    public String getDescricao() { return this.descricao; }
    public String getIsTomada() {
        if(isTomada == 1){
            return "Aceita";
        }if(isTomada == 2){
            return "Recusada";
        }else{
            return "Pendente";
        }
    }
    public int getQuantidadeVotosSim (){ return this.quantidadeVotosSim; }
    public int getQuantidadeVotosNao (){ return this.quantidadeVotosNao; }
    
    // Setters
    public void setQuantidadeVotosSim (int quantidadeVotosSim){
        this.quantidadeVotosSim = quantidadeVotosSim;
    }
    public void setQuantidadeVotosNao (int quantidadeVotosNao){
        this.quantidadeVotosNao = quantidadeVotosNao;
    }
    public void setIsTomada (int isTomada){
        this.isTomada = isTomada;
    }
    
    @Override
    public String toString(){
        return("ID: "+ this.getIdDecisao() + "\n" +
                "Descricao: "+ this.getDescricao() + "\n" + 
                "Status: "+ this.getIsTomada()+ "\n" +
                "+: "+ this.getQuantidadeVotosSim()+ "\n"+
                "-: "+this.getQuantidadeVotosNao()+"\n");
    }
}
