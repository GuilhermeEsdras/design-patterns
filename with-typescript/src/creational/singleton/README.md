# Singleton Pattern

## Intenção Oficial

Garantir que uma classe tenha somente uma instância no programa e fornecer um ponto de acesso global para a mesma.

### Somente uma instância?

- Geralmente usado para acesso a **recursos compartilhados**, como acesso à base de dados, interfaces gráficas, sistema de arquivos, servidores de impressão e mais.
- Também usado para substituir variáveis globais, como em casos de uso de **objetos de configuração do sistema** como um todo.

### Ponto de acesso global?

- Você pode permitir acesso global ao Singleton em toda sua aplicação, assim como fazíamos (ou fazemos) com variáveis globais.
- Uma vantagem do Singleton é que podemos proteger a instância com encapsulamento, evitando que outro código sobrescreva seu valor.

## Diagrama

![Estrutura do Singleton](diagramas/Singleton%20-%20Estrutura.png)

## Implementação

```typescript
export class Singleton {
  private static _instance: Singleton | null = null;

  private constructor() {
    // new not allowed outside the class
  }

  static get instance(): Singleton {
    if (Singleton._instance === null) {
      Singleton._instance = new Singleton();
    }

    return Singleton._instance;
  }
}

const instance1 = Singleton.instance;
const instance2 = Singleton.instance;

console.log(instance1 === instance2); // true
```

## Aplicabilidade

- Use o Singleton quando uma classe precisa ter somente uma instância disponível em todo o seu programa;
- Use o singleton quando perceber que está usando variáveis globais para manter partes importantes do programa, como variáveis de configuração que são usadas por toda a aplicação.

## Consequências

|                                Bom                                |                                                   Ruim                                                   |
|:-----------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------:|
| Acesso controlado à instância única                               | É mais difícil de testar                                                                                 |
| É fácil permitir um número maior de instâncias caso mude de ideia | Viola o princípio da responsabilidade única                                                              |
| Usa *lazy instantiation*, o Singleton só é criado no momento do uso | Requer tratamento especial em casos de concorrência                                                      |
| Substitui variáveis globais                                       | Erich Gamma (autor) descreveu que este seria o único padrão que ele removeria se fosse refatorar o livro |
