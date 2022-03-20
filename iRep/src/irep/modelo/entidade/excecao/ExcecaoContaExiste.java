package irep.modelo.entidade.excecao;

public class ExcecaoContaExiste extends RuntimeException{
    public ExcecaoContaExiste(){
        System.err.println("Conta com ID já existente!");
    }
}