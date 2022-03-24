/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import irep.modelo.entidade.Morador;
import irep.modelo.entidade.Tarefa;
import irep.modelo.excecao.ExcecaoIDExiste;
import irep.modelo.persistencia.MoradorDAO;
import irep.modelo.persistencia.TarefaDAO;

public class MoradorController {
    MoradorDAO moradorDAO;
    TarefaDAO tarefaDAO;

    public MoradorController(MoradorDAO moradorDAO, TarefaDAO tarefaDAO) {
        this.moradorDAO = moradorDAO;
        this.tarefaDAO = tarefaDAO;
    }

    public void addMorador(int idMorador, String nome, String apelido, String curso, LocalDate dataNascimento) {
        Morador m = new Morador(idMorador, nome, apelido, curso, dataNascimento);

        Morador mVerificaExistente = moradorDAO.pesquisa(idMorador);
        if (mVerificaExistente != null) {
            throw new ExcecaoIDExiste();
        }else{
            moradorDAO.add(m);
        }
    }

    public List<String> listarMoradores() {
        List<String> moradoresStr = new ArrayList<>();
        List<Morador> moradores = moradorDAO.listar();

        for (Morador t : moradores) {
            moradoresStr.add(t.toString());
        }
        return moradoresStr;
    }

    public String exibirMoradorPorID(int idMorador) {
        Morador morador = moradorDAO.pesquisa(idMorador);
        return (morador.toString());
    }

    public List<String> listarTarefasAtribuidas(int idMorador) {
        List <Tarefa> tarefas = tarefaDAO.listar();
        List <String> tarefasStr = new ArrayList<>();

        for (Tarefa f : tarefas){
            if(f.getIdMorador() == idMorador){
                tarefasStr.add(f.toString());
            }
        }
        return tarefasStr;
    }
    
}
