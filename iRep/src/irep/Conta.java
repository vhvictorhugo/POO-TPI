/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep;

import java.time.LocalDate;
import java.util.Scanner;

public class Conta {
    private String nome;
    private double valorConta, valorEmAberto;
    LocalDate vencimento;    
    
    // Getters
    public String getNome(){ return this.nome; }
    public double getValorConta(){ return this.valorConta; }
    public double getValorEmAberto(){ return this.valorEmAberto; }
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
    public void setValorEmAberto(double valorPago){ this.valorEmAberto = this.valorEmAberto - valorPago; }
    public void setVencimento(LocalDate vencimento){ this.vencimento = vencimento; }
    
    // Constructor     
    public Conta(String nome, double valorConta, LocalDate vencimento){
        this.setNome(nome);
        this.setValorConta(valorConta);
        this.valorEmAberto = this.getValorConta();
        this.setVencimento(vencimento);
    }

    public boolean isPaga(){
        if(this.valorEmAberto == 0){
            return true;
        }else{
            return false;
        }        
    }
    
    public void getConta(){
        System.out.println("Nome: "+this.getNome());
        System.out.println("Valor: "+this.getValorConta());
        System.out.println("Valor em Aberto: "+this.getValorEmAberto());
        System.out.println("Vencimento: "+getVencimento());
    }
}
