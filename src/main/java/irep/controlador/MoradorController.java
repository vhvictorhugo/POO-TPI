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
import irep.modelo.excecao.ExcecaoIDNaoExiste;
import irep.modelo.excecao.ExcecaoMoradorNaoPossuiTarefas;
import irep.modelo.excecao.ExcecaoNadaParaListar;
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

    public List<String> listarMoradores() throws ExcecaoNadaParaListar{
        List<String> moradoresStr = new ArrayList<>();
        List<Morador> moradores = moradorDAO.listar();

        if(moradores.size() == 0){
            throw new ExcecaoNadaParaListar();
        }

        for (Morador t : moradores) {
            moradoresStr.add(t.toString());
        }
        return moradoresStr;
    }

    public String exibirMoradorPorID(int idMorador) throws ExcecaoIDNaoExiste{
        Morador morador = moradorDAO.pesquisa(idMorador);

        if (morador == null){
            throw new ExcecaoIDNaoExiste();
        }
        return (morador.toString());
    }

    public List<String> listarTarefasAtribuidas(int idMorador)
            throws ExcecaoIDNaoExiste, ExcecaoNadaParaListar, ExcecaoMoradorNaoPossuiTarefas{
        Morador m = moradorDAO.pesquisa(idMorador);
        List <Tarefa> tarefas = tarefaDAO.listar();
        List <String> tarefasStr = new ArrayList<>();

        if (m == null){
            throw new ExcecaoIDNaoExiste();
        }

        if (tarefas.size() == 0){
            throw new ExcecaoNadaParaListar();
        }

        int quantidadeTarefasAtribuidas = 0;
        // verifica se morador tem pelo menos 1 tarefa atribuida      
        for (int i = 0; i < tarefas.size(); i++) {
            if(tarefas.contains(tarefas.get(i).getIdMorador() == idMorador)){
                quantidadeTarefasAtribuidas++;
                break;                
            }
        }

        if(quantidadeTarefasAtribuidas == 0){
            throw new ExcecaoMoradorNaoPossuiTarefas();
        }       

        for (Tarefa t : tarefas){
            if(t.getIdMorador() == idMorador){
                tarefasStr.add(t.toString());
            }
        }
        return tarefasStr;
    }
    
}
