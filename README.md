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
     * Cadastro de Contas (luz, água, internet, etc)
     * Notificação para lembrar das contas (próxima da data de vencimento) (funcionalidade extra)
     * Efetua o pagamento da conta
     
  2. Gerenciamento de **Tarefas da Casa**
     * Cadastro de Tarefas da Casa (colocar o lixo na rua, limpeza geral, cozinha, etc)
     * Atribuição de Tarefas para os moradores - cada morador terá uma determinada tarefa em uma determinada semana
     * Notificação para lembrar das tarefas (próximo ao fim da semana) 
     * Checklist
  3. Gerenciamento de **Decisões**
     * Cadastro de Decisões
       * Decisões já tomadas
       * Decisões a serem tomadas
     * Votação 
       * moradores votam
       * caso a maioria vote 'sim', a decisão é tomada,
       * caso contrário, a decisão é recusada
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

