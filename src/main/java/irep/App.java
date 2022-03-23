/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep;

import irep.modelo.persistencia.ContaDAO;
import irep.modelo.persistencia.DecisaoDAO;
import irep.modelo.persistencia.MoradorDAO;
import irep.modelo.persistencia.TarefaDAO;
import irep.visao.TelaInicial;

public class App 
{
    public static void main( String[] args ){
        // instanciando banco de dados
        ContaDAO contaDAO = new ContaDAO();
        DecisaoDAO decisaoDAO = new DecisaoDAO();
        TarefaDAO tarefaDAO = new TarefaDAO();
        MoradorDAO moradorDAO = new MoradorDAO();
        TelaInicial tela = new TelaInicial();
        
        tela.mostrar(contaDAO, decisaoDAO, tarefaDAO, moradorDAO);
    }
}
