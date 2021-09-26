# Sistema de Postagem de Mensagens

## Padrões aplicados:

- Observer
- Façade

## Para executar esta aplicação deve-se:
  1) Fazer download do arquivo "postagem-guilherme.jar"
  2) Executar este arquivo .jar (usando a versão 11 ou superior do java)
      Por exemplo:
        java -jar postagem-guilherme.jar [args]

### Observação:
  Este projeto de Sistema de Mensagens cria um "banco de dados fictício" (salva os dados em um .txt) para persistir os usuários.
  Este "bd" fica na mesma pasta onde o arquivo "postagem-guilherme.jar" é executado.

## Comandos

  - add [email]
    Descrição:
      - Adiciona um usuário a lista de membros do grupo
    Exemplo:
      $> java -jar postagem-guilherme.jar add guilherme.esdras@academico.ifpb.edu.br

  - del [email]
    Descrição:
      - Deleta um usuário da lista de membros do grupo
    Exemplo:
      $> java -jar postagem-guilherme.jar del guilherme.esdras@academico.ifpb.edu.br

  - msg [email] "mensagem"
    Descrição:
      - Envia uma mensagem usando um determinado email
    Exemplo:
      $> java -jar postagem-guilherme.jar msg guilherme.esdras@academico.ifpb.edu.br "Mensagem exemplo"

  - lst
    Descrição:
      - Lista todos os usuários da lista de membros do grupo
    Exemplo:
      $> java -jar postagem-guilherme.jar lst


