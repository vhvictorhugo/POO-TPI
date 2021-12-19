/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (????) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Morador {
    
    private String nome, apelido, curso;
    private Date dataNascimento, dataEntrada;
    private int idade;
    //private Tarefa tarefaAtribuida;
    
    // Setters
    public void setNome(String nome){ this.nome = nome; }
    public void setApelido(String apelido){ this.apelido = apelido; }
    public void setCurso(String curso){ this.curso = curso; }
    public void setDataNascimento(Date dataNascimento){ this.dataNascimento = dataNascimento; }
    public void setDataEntrada(Date dataEntrada){ this.dataEntrada = dataEntrada; }
    /*public void setIdade(Date dataNascimento, Date dataAtual){
        int anoNascimento, anoAtual;
        
        anoNascimento = 
        anoAtual = 
        
        this.idade = idade;
    }*/
    
    public Morador(String nome, String apelido, String curso, Date dataNascimento){        
        this.setNome(nome);
        this.setApelido(apelido);
        this.setCurso(curso);
        this.setDataNascimento(dataNascimento);        
        // atribui data atual da execução
        Date dataAtual = new Date(System.currentTimeMillis());   // coleta dados da data atual
        this.setDataEntrada(dataAtual); // dataAtual será considerada a data de entrada
        //this.setIdade(dataNascimento, dataAtual);       
    }    
    
    //public String getNome(){ return this.nome; }
    
    
    
    
}
