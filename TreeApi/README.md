# Tree Api - Criar uma Árvore Binária para posterior Análise Hierárquica
## Descrição
Este projeto se trata de uma API para análise hierárquica de frases e organiza-as em uma estrutura de árvore.
O projeto foi desenvolvido em Java e permite a manipulação de estruturas de dados hierárquicas.

### Funcionalidades
- POST : Cadastramos uma arvóre, seus nós e folhas.]
- GetByLevel{id} : Devolvendo uma arvóre em especifico
- GetAll : Retornando uma listagem das Arvóres cadastradas
-
- SHORTLY : Navegação e busca em árvores de nós.
- SHORTLY : Análise de uma palavra especifica por toda uma árvore.

### Estrutura do Projeto
O projeto é organizado da seguinte maneira:

- **Entity/**: Contém a classe de modelo utilizada na aplicação.
- **Controller/**: Contém os métodos de controle HTTP.
- **Repository/**: Contém o repositório das árvores registradas salvas.
- **Service/**: Contém as regras de negócios que estão disponivéis e que serão implementados.
- **Main.java**: O ponto de entrada da aplicação CLI.

## Requisitos

Para executar o projeto, você precisa ter instalado:

- Java JDK 11 ou superior
- Maven (ou outra ferramenta de build)
- Git (para controle de versão)

### Como Executar

1. Compile o projeto utilizando uma ferramenta de build como Maven.
   ```bash
   mvn clean install
Com a API em execução é possivel enviar uma requisição POST em http://localhost:8080/Tree para criar uma árvore:

```bash
   {
  "nodeTitle": "Animais"
    }
```
Neste exemplo:
--depth 2 define a profundidade máxima da árvore.
"Eu amo papagaios" é a frase a ser analisada.

### Exemplo de Saída
```
   {
  "nodeTitle": "Animais",
  "parent": null
   }
```




