/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.excecao;

public class ExcecaoMoradorNaoPossuiTarefas extends RuntimeException{
    public ExcecaoMoradorNaoPossuiTarefas(){
        System.err.println("Morador não possui tarefas atribuídas!");
    }
}
