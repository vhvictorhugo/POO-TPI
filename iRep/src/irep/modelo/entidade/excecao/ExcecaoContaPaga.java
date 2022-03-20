package irep.modelo.entidade.excecao;

public class ExcecaoContaPaga extends RuntimeException{
    public ExcecaoContaPaga(){
        System.err.println("Conta já foi paga!");
    }
}