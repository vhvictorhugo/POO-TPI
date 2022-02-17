/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.entidade;

import java.time.LocalDate;
import java.util.Scanner;

public class Conta {
    private Long idConta;
    private String nome;
    private double valorConta;
    boolean isPaga;
    LocalDate vencimento;    
    
    // Getters
    public Long getIdConta(){ return this.idConta; }
    public String getNome(){ return this.nome; }
    public double getValorConta(){ return this.valorConta; }
    public boolean getIsPaga(){ return this.isPaga; }
    public LocalDate getVencimento(){ return this.vencimento; }
    
    // Setters
    public void setNome(String nome){ this.nome = nome; }
    public void setValorConta(double valorConta){
        Scanner scan = new Scanner(System.in);
        
        while(valorConta <= 0){
            System.err.println("Valor deve ser maior que 0!");
            System.out.print("Entre com o valor correto: ");
            valorConta = scan.nextDouble();
        }
        this.valorConta = valorConta;
    }
    public void setVencimento(LocalDate vencimento){ this.vencimento = vencimento; }
    public void setIsPaga(boolean isPaga){ this.isPaga = false; }
    
    // Constructor     
    public Conta(String nome, double valorConta, LocalDate vencimento){
        this.setNome(nome);
        this.setValorConta(valorConta);
        this.setVencimento(vencimento);
    }
    
    @Override
    public String toString(){
        return ("Nome: " + this.getNome() + "\n" +
                "Valor: " + this.getValorConta() + "\n" +
                "Valor em Aberto: " + this.getIsPaga()+ "\n" +
                "Vencimento: " + this.getVencimento() + "\n");
    }
}
