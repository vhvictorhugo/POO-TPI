/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/
package irep;

public class Tarefa {
    private String Tarefa;
    private Long idSemana;
    private Morador nome;
    private boolean  isFeito;
    
    // Getters
    public String getNomeTarefa(){ return this.Tarefa; }

    // Setters
    public void setNomeTarefa(String nome){ this.Tarefa = nome; }
    public void setIdSemana( Long id){  this.idSemana = id; }
    public void setMoradores(Morador nome){ this.nome = nome; }
    public void setIsFeito(boolean isFeito){ this.isFeito = isFeito; }
    
    public Tarefa(String tarefa , Long idSemana,Morador nome, boolean status){
        this.setNomeTarefa(tarefa);
        this.setIdSemana(idSemana);
        this.setMoradores(nome);
        this.setIsFeito(status);
    }
}

