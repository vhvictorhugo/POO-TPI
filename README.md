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
     - [x] Listar contas
       - [x] Excecao para nao listar se array = vazio
     - [x] Efetua o pagamento da conta
       - [x] Mostrar contas quando for pagar
       - [x] Excecao para ID inexistente
  2. Gerenciamento de **Tarefas da Casa**
  
     - [x] Cadastro de Tarefas da Casa (colocar o lixo na rua, limpeza geral, cozinha, etc)
       - [x] Excecao para id ser inteiro
     - [x] Lista tarefas
       - [x] Excecao para nao listar se array = vazio
     - [x] Atribui tarefa - cada morador terá uma determinada tarefa em uma determinada semana
       - [x] Atribuição real (tarefa-morador)
         - [x] Transpor para morador
     - [x] Conclui tarefa
       - [x] Excecao se idtarefa nao existe
       - [x] Excecao se tarefa ja esta concluída
       - [x] Excecao se tarefa nao atribuida
  3. Gerenciamento de **Decisões**
  
     - [x] Cadastro de Decisões
       - [x] Excecao para id ser inteiro
     - [x] Lista Decisões
       - [x] Excecao para nao listar se array = vazio
     - [x] Votação
       - [x] Excecao se iddecisao nao existe
       - [x] Numero de votos totais deve ser menor ou igual a quantidade de moradores atual
         - [x] Excecao
     - [x] Contabilizar Voto - morador vota sim ou não para a decisão
       - [x] Resultado - contagem
         - [x] Excecao se iddecisao nao existe
  
  
     * Ex: Comprar um Freezer - compra **para a casa** com **alto custo**, que necessita de aprovação da **maioria** dos moradores
  
  4. **Moradores**
  
     - [x] Cadastrar Morador
     - [x] Listar Moradores
       - [x] Excecao para nao listar se array = vazio
     - [x] Exibir informações morador
     - [x] Listar tarefas por morador
       - [x] Excecao morador nao existe
       - [x] Excecao nao existem tarefas
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
