package irep.modelo.entidade.excecao;

public class ExcecaoTarefaNaoExiste extends RuntimeException {
    public ExcecaoTarefaNaoExiste() {
        System.err.println("Tarefa não existe!");
    }
}
