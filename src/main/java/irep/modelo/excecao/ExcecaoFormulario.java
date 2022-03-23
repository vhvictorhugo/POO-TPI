/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.excecao;

public class ExcecaoFormulario extends RuntimeException {

    public ExcecaoFormulario(String message) {
        super(message);
    }

    public ExcecaoFormulario(int i) {
        super("Entre com inteiros válidos, por favor!");
    }

    public ExcecaoFormulario(Throwable t) {
        super(t);
    }
}