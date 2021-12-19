/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/
package irep;

public class Tarefa {
    private String Tarefa;
    private Long idTarefa;
    private Morador nome;
    private boolean  isFeito;

    // Getters
    public String getNomeTarefa(){ return this.Tarefa; }
    public Long getIdSemana(){ return  this.idTarefa;}
    public boolean getIsFeito(){ return this.isFeito; }
    // Setters
    public void setNomeTarefa(String nome){ this.Tarefa = nome; }
    public void setidTarefa( Long id){  this.idTarefa = id; }
    public void setMoradores(Morador nome){ this.nome = nome; }
    public void setIsFeito(boolean isFeito){ this.isFeito = isFeito; }
    
    public Tarefa(String tarefa , Long idTarefas){
        this.setNomeTarefa(tarefa);
        this.setidTarefa(idTarefas);
        this.setMoradores(nome);
        this.setIsFeito(false);
    }
}

