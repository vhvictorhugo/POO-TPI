# POO - TPI :books:

###### Dupla: **Lucas Takeshi Moreira Chang** (2665) e Victor Hugo Rezende dos Santos (3510)

###### Professor: Fabrício Aguiar Silva

###### Disciplina: **CCF 313 - Programação Orientada a Objetos**

###### Projeto: iRep



Guia:

1- fazer a estrutura do projeto aplicando os conceitos da arquitetura MVC

2- verificar erros do usuário 

2.1- criar contas, tarefas, etc com id iguais

3- verificar autenticações

3.1- quais usuários podem mudar o estado 



###### Descrição:

- O projeto **iRep** tem como principal **objetivo** construir do zero um sistema utilizando a linguagem de programação **Java** para **moradores de uma república** gerenciarem diversas situações cotidianas de uma república para facilitar a organização geral da casa, facilitando a boa convivência. 

  

- O projeto conta com as seguintes funcionalidades:

  1. Gerenciamento de **Contas**
     
     - [x] Cadastro de Contas (luz, água, internet, etc)
     - [x] Listar contas
     - [x] Efetua o pagamento da conta
     - [ ] Notificação para lembrar das contas (próxima da data de vencimento) (funcionalidade extra)
     
  2. Gerenciamento de **Tarefas da Casa**
  
     - [ ] Cadastro de Tarefas da Casa (colocar o lixo na rua, limpeza geral, cozinha, etc)
     - [ ] Lista tarefas
       - [ ] Checklist (extra/interface) - para cada tarefa
     - [ ] Atribui tarefa - cada morador terá uma determinada tarefa em uma determinada semana
     - [ ] Conclui tarefa
     - [ ] Notificação para lembrar das tarefas (próximo ao fim da semana) 
  
  3. Gerenciamento de **Decisões**
  
     - [ ] Cadastro de Decisões
     - [ ] Lista Decisões
       - [ ] Decisões tomadas
       - [ ] Decisões pendentes
     - [ ] Votação
       - [ ] Contabilizar Voto - morador vota sim ou não para a decisão
       - [ ] Resultado - contagem
  
     * Ex: Comprar um Freezer - compra **para a casa** com **alto custo**, que necessita de aprovação da **maioria** dos moradores
  
  5. **Moradores**
     * **Usuários**
     * Hierarquia - calouro e veterano (opcional) 
  
  

###### Tecnologias Utilizadas:

- Java 8
- Apache NetBeans IDE 12.5
- JavaFX Scene Builder 2.0
- GIT/GITHUB para versionamento de código



###### Objetivos do Projeto:

* Alcançar um domínio maior da orientação a objetos e da tecnologia Java;
* Organizar um sistema em módulos bem definidos, reduzindo o acoplamento e
  aumentando a coesão;
* Amadurecer a experiência de se trabalhar em equipe;
* Aprender a usar de forma apropriada uma ferramenta de controle de versão.



###### Detalhes sobre ENTREGA 2:

O repositório conta com 2 branches (main e dev), favor verificar os commits de ambas. Sempre que possível a dupla fará o merge entre elas. Vale lembrar que a branch 'main' contém a versão mais estável do código.



###### Feedback ENTREGA 2 (tarefas ainda em aberto):

• Implementar alguns testes enquanto ainda está no começo, para não dificultar mais no final;

• Deixando o curso como String, pode acontecer de diferentes cadastros ficarem com diferentes nomes. Sugiro utilizar um ENUM para o curso.



###### Próximos Passos:

• Implementar Testes Unitários;

• Converter projeto para o padrão MVC - aplicando corretamente conceitos vistos durante as aulas (modularidade, encapsulamento e herança);

• Terminar de implementar funcionalidades listadas anteriormente.

