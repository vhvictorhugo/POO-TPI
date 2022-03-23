package irep.modelo.entidade.excecao;

public class ExcecaoIDExiste extends RuntimeException{
    public ExcecaoIDExiste(){
        System.err.println("ID já existente!");
    }    
}
