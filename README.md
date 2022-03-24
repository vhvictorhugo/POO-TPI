# POO - TPI :books:

###### Dupla: **Lucas Takeshi Moreira Chang** (2665) e Victor Hugo Rezende dos Santos (3510)

###### Professor: Fabrício Aguiar Silva

###### Disciplina: **CCF 313 - Programação Orientada a Objetos**

###### Projeto: iRep



###### Descrição:

- O projeto **iRep** tem como principal **objetivo** construir do zero um sistema utilizando a linguagem de programação **Java** para **moradores de uma república** gerenciarem diversas situações cotidianas de uma república para facilitar a organização geral da casa, facilitando a boa convivência. 

- Inicialização das classes: todas devem possuir ID diferente de 0

- O projeto conta com as seguintes funcionalidades:

  1. Gerenciamento de **Contas**
  
     - [x] Cadastro de Contas (luz, água, internet, etc)
       - [ ] Excecao id inteiro
       - [ ] Excecao para valor ser double e > 0
       - [ ] Excecao para data ser no formato correto
     - [x] Listar contas
       - [ ] Excecao para nao listar se array = vazio
     - [x] Efetua o pagamento da conta
       - [ ] lancar excecao para ID inexistente
       - [ ] Hierarquia: somente veteranos pagam
  
  2. Gerenciamento de **Tarefas da Casa**
  
     - [x] Cadastro de Tarefas da Casa (colocar o lixo na rua, limpeza geral, cozinha, etc)
       - [ ] Excecao para id ser inteiro
     - [x] Lista tarefas
       - [ ] Excecao para nao listar se array = vazio
     - [x] Atribui tarefa - cada morador terá uma determinada tarefa em uma determinada semana
       - [ ] Atribuição real (tarefa-morador)
         - [ ] Transpor para morador
       - [ ] Acrescentar: somente veteranos atribuem
     - [x] Conclui tarefa
       - [ ] Excecao se idtarefa nao existe
       - [ ] Excecao se tarefa ja esta concluida
       - [ ] Acrescentar: somente morador da própria tarefa pode efetuar 
  
  3. Gerenciamento de **Decisões**
  
     - [x] Cadastro de Decisões
       - [ ] Excecao para id ser inteiro
  
     - [x] Lista Decisões
       - [ ] Excecao para nao listar se array = vazio
  
     - [x] Votação
       - [ ] Excecao se iddecisao nao existe
       - [ ] Excecao se voto != sim ou != nao
       - [x] Contabilizar Voto - morador vota sim ou não para a decisão
       - [x] Resultado - contagem
         - [ ] Excecao se iddecisao nao existe
  
  
     * Ex: Comprar um Freezer - compra **para a casa** com **alto custo**, que necessita de aprovação da **maioria** dos moradores
  
  4. **Moradores**
  
     - [ ] Cadastrar Morador
       - [ ] Hierarquia - calouro e veterano (Herança)
       - [ ] Colocar enum para curso
       
     - [ ] Listar Moradores
       - [ ] Excecao para nao listar se array = vazio
  
     - [ ] Exibir informações morador
  
  5. **Possíveis Futuras Implementações**
  
     - Emitir Notificações
  
       - Notificação para lembrar das contas (próxima da data de vencimento)
  
       - Notificação para lembrar das tarefas (próximo ao fim da semana) 
  
     - Checklist para cada tarefa
     - Projeto Pessoal
  
  

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

• <font color='red'>Implementar Testes Unitários</font>;

• Terminar de converter o projeto para o padrão MVC - falta somente a classe Morador;

• Verificar erros de projeto - tratamento de exceções

• verificar autenticações

​		• quais usuários podem mudar o estado

• Terminar de implementar funcionalidades listadas anteriormente.
