/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.entidade;

public class Tarefa {
    private int idTarefa;
    private String nome;    
    private int idMorador;
    private boolean isFeito;

    // Getters
    public int getIdTarefa(){ return  this.idTarefa;}
    public String getNome(){ return this.nome; }   
    public int getIdMorador() { return this.idMorador; }
    public String getIsFeito(){
        if (this.isFeito == true){
            return "Feita";
        }
        
        return "Pendente";
    }

    // Setters
    public void setIdTarefa(int id){  this.idTarefa = id; }
    public void setNome(String nome){ this.nome = nome; }   
    public void setIdMorador(int idMorador){ this.idMorador = idMorador; }
    public void setIsFeito(boolean isFeito){ this.isFeito = isFeito; }
    
    public Tarefa(int idTarefa, String tarefa){
        this.setNome(tarefa);
        this.setIdTarefa(idTarefa);
        this.setIsFeito(false);
    }
    
    @Override
    public String toString(){
        return ("ID: " + this.getIdTarefa() + "\n" +
                "Nome: " + this.getNome() + "\n" +                
                "Status: " + this.getIsFeito() + "\n" + 
                "ID Morador: "+ this.getIdMorador() + "\n");
    }
}

