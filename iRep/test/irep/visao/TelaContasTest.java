package irep.visao;

import irep.controlador.ContaController;
import irep.modelo.persistencia.ContaDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TelaContasTest {
    
    @org.junit.jupiter.api.Test
    public void testCadastroConta() {
        TelaContas instance = new TelaContas();
        ContaController contaController = new ContaController();
        ContaDAO contaDAO = new ContaDAO();
        
        int idConta = 1;
        String nome = "A";
        double valorConta = 10.2;
        String vencimentoLeitura = "10/10/2010";
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato);
        contaController.addConta(idConta, nome, valorConta, dataVencimento);
        
        assertEquals(1, contaDAO.listarContas().get(0).getIdConta());        
      }
    
}
