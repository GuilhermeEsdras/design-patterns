# Builder pattern - Creational (Criação)

## Intenção

*Separar a construção de um objeto complexo da sua representação de modo que o mesmo processo de construção possa criar diferentes representações.*

## Visão Geral

- O padrão sugere a separação do código que cria e o código que usa o objeto;
- Trata da criação de objetos complexos (complexos de verdade):
  - Construtores muito complexos;
  - Composição de vários objetos (composite);
  - Algoritmo de criação do objeto complexo.
- Permite a criação de um objeto em etapas;
  - Exemplo: Sem precisar passar tudo de uma vez no construtor, vai preenchendo os atributos do objeto através de etapas utilizando métodos.
- Permite *method chaining*;
  - Exemplo: De dentro de um método chama-se outro método que chama outro método, e assim por diante.
- O objeto final pode variar de acordo com a necessidade;
- É um padrão complexo.

## Estrutura

![Estrutura do Builder](diagramas/Builder%20-%20estrutura.png)

## Exemplo

```typescript
export class Person {
  constructor(public name?: string, public age?: number) {}
}
```

```typescript
export class PersonBuilder {
  private person = new Person();

  newPerson(): void {
    this.person = new Person();
  }

  setName(name: string): this {
    this.person.name = name;
    return this; // O retorno do this permite o method chaining (encadeamento de chamadas de método)
  }

  setAge(age: number): this {
    this.person.age = age;
    return this;
  }

  getResult(): Person {
    return this.person;
  }
}

const personBuilder = new PersonBuilder();
const person1 = personBuilder.setName('Guilherme').setAge(30).getResult();
const person2 = personBuilder.setName('Esdras').setAge(50).getResult();
```

A mesma coisa:

```typescript
type Person = { name?: string; age?: number };
const person1: Person = { name: 'Guilherme' };
const person2: Person = { name: 'Esdras', age: 50 };
```

## Aplicabilidade

Use o Builder quando:

- a criação do objeto se torna complexa
- quiser que o código seja capaz de gerar diferentes representações ;do mesmo objeto.

## Consequências

|                        Bom                       |                     Ruim                     |
|:------------------------------------------------:|:--------------------------------------------:|
| Separa criação de utilização                     | O código final pode se tornar muito complexo |
| O cliente não precisa criar objetos diretamente  |                                              |
| O mesmo código pode construir objetos diferentes |                                              |
| Ajuda na aplicação dos princípios SRP e OCP      |                                              |
