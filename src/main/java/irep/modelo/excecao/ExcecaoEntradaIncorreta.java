/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.excecao;

import java.util.InputMismatchException;

public class ExcecaoEntradaIncorreta extends InputMismatchException{
    public ExcecaoEntradaIncorreta(){
        System.err.println("Entrada com formato inválido!");
    }
}
