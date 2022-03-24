package irep.modelo.excecao;

import java.util.InputMismatchException;

public class ExcecaoEntradaIncorreta extends InputMismatchException{
    public ExcecaoEntradaIncorreta(){
        System.err.println("Entrada com formato inválido!");
    }
}
