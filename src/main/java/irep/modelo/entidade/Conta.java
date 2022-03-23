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
    private int idConta;
    private String nome;
    private double valorConta;
    private boolean isPaga;
    private LocalDate vencimento;    
    
    // Getters
    public int getIdConta(){ return this.idConta; }
    public String getNome(){ return this.nome; }
    public double getValorConta(){ return this.valorConta; }
    public String getIsPaga(){
        if (this.isPaga == true){
            return "Paga";
        }
        
        return "Em Aberto";
    }
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
    public void setIsPaga(boolean isPaga){ this.isPaga = isPaga; }
    
    // Constructor     
    public Conta(int idConta, String nome, double valorConta, LocalDate vencimento){
        this.setNome(nome);
        this.setValorConta(valorConta);
        this.setVencimento(vencimento);        
        this.idConta = idConta;
        this.isPaga = false;
    }
    
    @Override
    public String toString(){
        return ("ID: " + this.getIdConta()+ "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Valor: " + this.getValorConta() + "\n" +
                "Status: " + this.getIsPaga()+ "\n" +
                "Vencimento: " + this.getVencimento() + "\n");
    }
}