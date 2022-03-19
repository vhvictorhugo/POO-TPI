/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package irep.teste.controlador;

import irep.controlador.ContaController;
import irep.modelo.entidade.Conta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lucas
 */
public class ContaControllerTest {
    
    public ContaControllerTest() {
        
    }

    @Test
    public void testAddConta() {
        
        ContaController contaController = new ContaController();
        
        int idConta = 1;
        String nome = "A";
        double valorConta = 10.2;
        String vencimentoLeitura = "10/10/2010";
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato);
        Conta contaMock = new Conta(idConta, nome, valorConta, dataVencimento);
        
        Conta conta = contaController.addConta(idConta, nome, valorConta, dataVencimento);
        
        assertEquals(contaMock.getIdConta(),conta.getIdConta());
        
    }

    @Test
    public void testAddConta2() {
        
        ContaController contaController = new ContaController();
        
        int idConta = 1;
        String nome = "A";
        double valorConta = 20.2;
        String vencimentoLeitura = "10/10/2020";
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        
        LocalDate dataVencimento = LocalDate.parse(vencimentoLeitura, formato);
        Conta contaMock = new Conta(idConta, nome, valorConta, dataVencimento);
        
        Conta conta = contaController.addConta(idConta, nome, valorConta, dataVencimento);
        
        assertEquals(contaMock.getIdConta(),conta.getIdConta());        
        
    }
    
}