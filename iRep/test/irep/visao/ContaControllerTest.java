package irep.visao;

import irep.controlador.ContaController;
import irep.modelo.entidade.Conta;
import irep.modelo.persistencia.ContaDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaControllerTest {
    
    @org.junit.jupiter.api.Test
    public void testCadastroConta() {
        ContaController contaController = new ContaController();
        ContaDAO contaDAO = new ContaDAO();
        
        int idConta = 1;
        String nome = "A";
        double valorConta = 10.2;
        String vencimentoLeitura = "10/10/2010";
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato);
        Conta contaMock = new Conta(idConta, nome, valorConta, dataVencimento);
        
        Conta conta = contaController.addConta(idConta, nome, valorConta, dataVencimento);
        
        assertEquals(conta,contaMock);        
      }

}
