/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (????) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws Exception{        
        Principal principal = new Principal();
        List<Morador> moradores = new LinkedList<Morador>();

        principal.cadastraMorador(moradores);
        //principal.editaMorador(moradores);        
    }
    
    public void cadastraMorador(List moradores)throws Exception {
        System.out.println("---------- CADASTRO DE MORADORES ----------");
        
        int qtMoradores;
        String nomeLeitura, dataNascimentoLeitura;
        
        Scanner scan = new Scanner(System.in); 
        
        System.out.print("Entre com a quantidade de moradores a cadastrar: ");        
        
        qtMoradores = scan.nextInt();
        
        for (int i = 0; i < qtMoradores; i++) {
            
            System.out.println("---------- MORADOR "+(i+1)+" ----------");
            System.out.print("Entre com o nome do Morador: ");
            nomeLeitura = scan.nextLine();
            System.out.print("Entre com a data de nascimento (dd/MM/yyyy): ");
            dataNascimentoLeitura = scan.nextLine();
            
            // converte data do tipo 'String' em data do tipo 'Date'
            Date dataNascimento = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimentoLeitura);
            
            //Morador morador = new Morador(nomeLeitura, dataNascimento);            
            //moradores.add(morador);
        }
    }
    
    /*public void editaMorador(List moradores){
        System.out.println("---------- EDITAR MORADORES ----------");
        
        String nomeMorador;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Entre com o nome do morador a editar: ");
        nomeMorador = scan.nextLine();
        
        moradores.contains(moradores);
        
    }*/
}
