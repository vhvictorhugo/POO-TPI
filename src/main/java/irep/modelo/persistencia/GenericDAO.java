/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.persistencia;

import java.util.List;


// GenericDAO para quaisquer outros DAO's
public interface GenericDAO<T> {    // T é a entidade genérica
    public T add(T o);
    public T pesquisa(int ID);
    public T remove(int ID);    
    public List<T> listar();
    // métodos devem retornar um tipo, a fim de favorecer a verificação de testes
}
