/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import java.time.LocalDate;
import java.util.List;

import irep.modelo.persistencia.MoradorDAO;

public class MoradorController {

    public MoradorController(MoradorDAO moradorDAO) {
    }

    public void addMorador(int idMorador, String nome, String apelido, String curso, LocalDate dataNascimento) {
    
    }

    public List<String> listarMoradores() {
        return null;
    }

    public char[] exibirMoradorPorID(int idMorador) {
        return null;
    }
    
}
