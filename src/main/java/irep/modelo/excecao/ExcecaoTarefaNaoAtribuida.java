/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.excecao;

public class ExcecaoTarefaNaoAtribuida extends RuntimeException{
    public ExcecaoTarefaNaoAtribuida(){
        System.err.println("Tarefa ainda não foi atribuida!");
    }
}