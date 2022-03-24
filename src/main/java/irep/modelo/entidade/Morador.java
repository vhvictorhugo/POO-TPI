/*
*   Projeto iRep - um jeito diferente de morar em repúblicas
*   Autores: Lucas Takeshi (2665) e Victor Hugo (3510)
*   Matéria: CCF 313 - Programação Orientada a Objetos
*   Professor: Fabrício Aguiar Silva
*/

package irep.modelo.entidade;

import java.time.LocalDate;

// nao podera existir morador com id == 0
public class Morador {
    private int idMorador;
    private String nome, apelido, curso;
    private LocalDate dataNascimento, dataEntrada;
    private int idade;
    //private Tarefa tarefaAtribuida;
    
    // Getters 
    public int getIdMorador(){ return this.idMorador; }
    public String getNome(){ return this.nome; }
    public String getApelido(){ return this.apelido; }
    public String getCurso(){ return this.curso; }
    public LocalDate getDataNascimento(){ return this.dataNascimento; }
    public LocalDate getDataEntrada(){ return this.dataEntrada; }
    public int getIdade(){ return this.idade; }
    
    // Setters
    public void setNome(String nome){ this.nome = nome; }
    public void setApelido(String apelido){ this.apelido = apelido; }
    public void setCurso(String curso){ this.curso = curso; }
    public void setDataNascimento(LocalDate dataNascimento){ this.dataNascimento = dataNascimento; }
    public void setDataEntrada(LocalDate dataEntrada){ this.dataEntrada = dataEntrada; }
    public void setIdade(LocalDate dataNascimento, LocalDate dataAtual){
        this.idade = dataAtual.getYear() - dataNascimento.getYear();
    }
    
    public Morador(int idMorador, String nome, String apelido, String curso, LocalDate dataNascimento){
        LocalDate dataAtual;
        this.idMorador = idMorador;
        this.setNome(nome);
        this.setApelido(apelido);
        this.setCurso(curso);
        this.setDataNascimento(dataNascimento);        
        // atribui data atual da execução
        dataAtual = LocalDate.now();
        this.setDataEntrada(dataAtual); // dataAtual será considerada a data de entrada
        this.setIdade(dataNascimento, dataAtual);       
    }    
    
    @Override
    public String toString(){
        return ("ID: " + this.getIdMorador() + "\n" +
                "Nome: " + this.getNome() + "\n" +
                "Data de Nascimento: "+ this.getDataNascimento() + "\n" +
                "Apelido: " + this.getApelido() + "\n" +
                "Curso: " + this.getCurso() + "\n" +
                "Idade: " + this.getIdade() + "\n" +
                "Data de entrada: " + this.getDataEntrada() + "\n");
    }
}