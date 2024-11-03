# Tree Api - Criar uma Árvore Binária para posterior Análise Hierárquica
## Descrição
Este projeto se trata de uma API para análise hierárquica de frases e organiza-as em uma estrutura de árvore.
O projeto foi desenvolvido em Java e permite a manipulação de estruturas de dados hierárquicas.

### Funcionalidades
- POST : Cadastramos uma árvore, seus nós e folhas.
- GetById: Devolvendo uma árvore em especifico
- Analyzer: Análise apartir de uma frase se alguma palavra especifica corresponde com uma cadastrada na árvore.

### Estrutura do Projeto
O projeto é organizado da seguinte maneira:

- **Entity/**: Contém a classe de modelo utilizada na aplicação.
- **Controller/**: Contém os métodos de controle HTTP.
- **Service/**: Contém as regras de negócios que estão disponivéis e que serão implementados.
- **Repository/**: Contém o repositório das árvores registradas salvas.
- **Config/**: Possui a configuração do CROS para permitir acesso do front-end para o back-end.
- **TreeApiApplication**: O ponto de entrada da aplicação.

## Requisitos

Para executar o projeto, você precisa ter instalado:

- Java JDK 11 ou superior
- Maven (ou outra ferramenta de build)
- Git (para controle de versão)

### Como Executar

1. Compile o projeto utilizando uma ferramenta de build como Maven.
 ```bash
   mvn clean install
   ```
2. Com a API em execução é possivel enviar uma requisição POST em http://localhost:8080/Tree para criar uma árvore:

```bash
  {
  "nodeTitle": "Animais"
  }
```
3.  É possível continuar adicionando filhos com novas requisições POST em http://localhost:8080/Tree definindo quem é o pai.

```bash
   {
     "nodeTitle": "Mamiferos",
     "parent": {
       "id": 1
     }
   }
```
4. Para visualizar o retorno da árvore em especifico enviamos um requisição GET/id em http://localhost:8080/Tree/1.
```bash
   {
       "id": 1,
       "nodeTitle": "Animais",
       "children": [
           {
               "id": 2,
               "nodeTitle": "Mamiferos",
               "children": []
           }
       ]
   }
```
5. Neste exemplo:
Words : "Eu amo Mamiferos" é a frase a ser analisada.<br/>
Id : 1 indica que estamos analisando a árvore 1 de (Animais).<br/>
Depth 0 define a profundidade máxima da árvore.<br/>
Result é o retorno para analise.


### Exemplo de Saída
```
   {
       "words": "Eu amo Mamiferos",
       "id": 1,
       "depth": 0,
       "result": "{Animais=1}"
   }
```




