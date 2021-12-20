/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep;

public class Tarefa {
    private String nome;
    private Long idTarefa;
    //private Morador nome;
    private boolean isFeito;

    // Getters
    public String getNome(){ return this.nome; }
    public Long getIdTarefa(){ return  this.idTarefa;}
    public boolean getIsFeito(){ return this.isFeito; }

    // Setters
    public void setNome(String nome){ this.nome = nome; }
    public void setIdTarefa( Long id){  this.idTarefa = id; }
    //public void setMoradores(Morador nome){ this.nome = nome; }
    public void setIsFeito(boolean isFeito){ this.isFeito = isFeito; }
    
    public Tarefa(String tarefa , Long idTarefas){
        this.setNome(tarefa);
        this.setIdTarefa(idTarefas);
        //this.setMoradores(nome);
        this.setIsFeito(false);
    }
    
    public void getTarefa(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("ID: "+this.getIdTarefa());
        System.out.println("Tarefa está feita? "+getIsFeito());
    }
}

