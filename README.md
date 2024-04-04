![Logo do Instituto Infnet](https://curso.infnet.com.br/c/wp-content/uploads/sites/59/2022/12/Infnet-Logo.png)
# ASSESSMENT

## **Desenvolvimento de Serviços Web e Testes com Java [24E1_3]**

## **Bloco: Desenvolvimento Back-end [23E4 - 24E1]**

### [GRPADS01C2-N1-P2] - Classe 2 - Noite

Por Marcos Carvalhido Rodrigues

*marcos.carvalhido@al.infnet.edu.br*

---

Link para o AT no Moodle: https://lms.infnet.edu.br/moodle/mod/assign/view.php?id=376921

### Questões:

1. Crie um projeto no intelliJ com um gerenciador de dependências. Estruture seu projeto com os pacotes: *"controller", "dto”, "service" e "model"*.
2. Dentro do pacote "model", crie uma classe de modelo chamada *Usuario*, com os atributos privados *id* (inteiro), *nome* (String) e *senha* (String).: não gere os *getters* e *setters* manualmente. Utilize a biblioteca “Lombok” com as suas respectivas anotações.
3. Dentro do pacote "dto" crie uma classe *UsuarioDTOInput*, com os mesmos atributos da classe *Usuario*.: não gere os *getters* e *setters* manualmente. Utilize a biblioteca “Lombok” com as suas respectivas anotações.
4. Dentro do pacote "dto" crie uma classe *UsuarioDTOOutput*, com os mesmos atributos da classe *Usuario*, exceto o atributo *senha*.: não gere os *getters* e *setters* manualmente. Utilize a biblioteca “Lombok” com as suas respectivas anotações.
5. Dentro do pacote "service" crie uma classe *UsuarioService*. A classe deve possuir um atributo *listaUsuarios*, que é do tipo *List<Usuario>*. Essa lista será a responsável por guardar os usuários atualmente existentes. Essa classe também deve possuir os métodos para listar, inserir, alterar, buscar e excluir.
6. O método *listar* da classe *UsuarioService* não possui parâmetros. O seu retorno é uma lista de objetos da classe *UsuarioDTOOutput*. Essa lista deve ser construída a partir de *lista Usuarios* com a ajuda da biblioteca “ModelMapper”.
7. O método *inserir* da classe *UsuarioService* tem como parâmetro um objeto da classe *UsuarioDTOInput*. Esse objeto deve ser convertido em objeto da classe *Usuario* com a biblioteca “ModelMapper”. O objeto recém-convertido da classe *Usuario* deve ser adicionado em *listaUsuarios*.
8. O método *alterar* da classe *UsuarioService*  tem como parâmetro um objeto da classe *UsuarioDTOInput*. Esse objeto deve ser convertido em objeto da classe *Usuario* com a biblioteca “ModelMapper”. O objeto recém-convertido da classe *Usuario* deve substituir um objeto existente em *listaUsuarios*.
9. O método *buscar* da classe *UsuarioService* tem como parâmetro um inteiro chamado *id*. Com base nesse parâmetro, esse método deve buscar em *listaUsuarios* um objeto existente da classe *Usuario*. O método deve converter esse objeto existente para um objeto da classe *UsuarioDTOOutput* com a biblioteca “ModelMapper”. O objeto recém-convertido deve ser retornado.
10. O método *excluir* da classe *UsuarioService* tem como parâmetro um inteiro chamado *id*. Com base nesse parâmetro, esse método deve buscar em *listaUsuarios* um objeto existente da classe *Usuario*. O método deve remover esse objeto encontrado. Não existe retorno.
11. Crie uma classe chamada *UsuarioController*. Essa classe deve possuir um atributo/objeto da classe *UsuarioService*. Adicionalmente, faça um método na classe chamado *respostasRequisicoes*, sem parâmetro e retorno.
12. Por meio do uso da biblioteca Java Spark, dentro do método *respostasRequisicoes*, escreva um *endpoint* para listagem dos usuários existentes. A URI utilizada deverá ser "/usuarios". O verbo utilizado será o GET. Para construir a resposta, utilize o objeto da classe *UsuarioService* e o seu método *listar*. Converta a lista retornada em um JSON com o auxílio da biblioteca “ObjectMapper”. **Não esqueça de definir corretamente o código de resposta**.
13. Por meio do uso da biblioteca Java Spark, dentro do método *respostasRequisicoes*, escreva um *endpoint* para busca de um usuário existente. A URI utilizada deverá ser "/usuarios/:id". O verbo utilizado será o GET. Para construir a resposta, utilize o objeto da classe *UsuarioService* e o método *buscar*. Converta o objeto retornado em um JSON com o auxílio da biblioteca “ObjectMapper”. **Não esqueça de definir corretamente o código de resposta**.
14. Por meio do uso da biblioteca Java Spark, dentro do método *respostasRequisicoes*, escreva um *endpoint* para exclusão de um usuário existente. A URI utilizada deverá ser "/usuarios/:id". O verbo utilizado será o DELETE. Para construir a resposta, utilize o objeto da classe *UsuarioService* e o método *excluir*. **Não esqueça de definir corretamente o código de resposta**.
15. Por meio do uso da biblioteca Java Spark, dentro do método *respostasRequisicoes*, escreva um *endpoint* para inserção de um novo usuário. A URI utilizada deverá ser "/usuarios". O verbo utilizado será o POST. Para realizar a inserção, utilize o objeto da classe *UsuarioService* e o método *inserir*. Antes, você deverá converter o JSON recebido no corpo da requisição em um objeto da classe *UsuarioDTOInput* com o auxílio da biblioteca “ObjectMapper”. **Não esqueça de definir corretamente o código de resposta**.
16. Por meio do uso da biblioteca Java Spark, dentro do método *respostasRequisicoes*, escreva um *endpoint* para atualização de um usuário. A URI utilizada deverá ser "/usuarios". O verbo utilizado será o PUT. Para realizar a alteração, utilize o objeto da classe *UsuarioService* e o método *alterar*. Antes, você deverá converter o JSON recebido no corpo da requisição em um objeto da classe *UsuarioDTOInput* com o auxílio da biblioteca “ObjectMapper”. **Não esqueça de definir corretamente o código de resposta**.
17. Por meio da biblioteca “JUnit” e de uma instância da classe *UsuarioService,* programe um teste de validação de inserção de um usuário. Para isso, crie uma classe chamada ServiceTest. Nesta classe, um método dedicado deve criar um objeto da classe *UsuarioDTOInput* e executar o método *inserir* da classe *UsuarioService*. Para validar a inserção, execute o método *listar*. Se o tamanho da lista retornada for igual a 1, então a execução foi bem-sucedida.
18. Por meio da biblioteca “JUnit” e de instâncias da classe *URL* e *HttpUrlConnection,* programe um teste de validação de listagens de usuários. Para isso, faça uma requisição para a sua API (que você acabou de desenvolver) já em execução. Se o código de retorno for 200, então a execução foi bem-sucedida.
19. Por meio da biblioteca “JUnit” e de instâncias da classe *URL* e *HttpUrlConnection,* programe um teste de validação de inserção de um usuário.Faça uma requisição para essa API utilizando as classes *URL* e *HttpUrlConnection*. Depois, faça uma requisição para a sua API (que você acabou de desenvolver) já em execução. Se o código de retorno for 201 (created), então a execução foi bem-sucedida.
