# Chain Of Responsibility - Behavioural (Comportamental)

## Intenção

*Evitar o acoplamento do remetente de uma solicitação ao seu destinatário, dando a mais de um objeto a chance de tratar a solicitação. Encadeia os objetos receptores e passa a solicitação ao longo da cadeia até que um objeto a trate*

### Sobre

- É usado quando uma requisição precisa passar por uma sequência de operações até ser totalmente tratada
- Desacopla quem envia de quem vai tratar a requisição
- É muito usado com requisições HTTP
- É a base para outros padrões de projeto conhecidos (como Middleware usado no express)
- Permite que um objeto **TRATE** a requisição e chame o **PRÓXIMO** objeto da cadeia
- Permite que um objeto **NÃO TRATE** a requisição e chame o **PRÓXIMO** objeto da cadeia
- Permite que um objeto **TRATE** a requisição e **FINALIZE** a cadeia
- Permite que um objeto **NÃO TRATE** a requisição e **FINALIZE** a cadeia
- O cliente pode iniciar a requisição de qualquer objeto caso necessário

![Chain of Responbility sobre](diagramas/sobre.svg)

---

## Estrutura / Diagrama

![Chain of Responsibility diagram](diagramas/chain-of-responsibility-diagram.svg)

## Aplicabilidade

Use o Chain Of Responsibility quando:

- seu sistema precisa processar uma requisição em várias etapas diferentes e você não quer criar uma ordem rígida para o processamento. O chain of responsibility permite que você altere a ordem dos objetos na cadeia facilmente (mesmo assim, mantendo uma ordem específica)
- você quer aplicar o princípio da responsabilidade única para tratamento de dados da requisição. Cada objeto fica responsável por tratar apenas a parte que lhe couber
- você quer permitir que os objetos responsáveis pelo tratamento de requisição possam variar em tempo de execução



## Exemplo de Implementação

```typescript
abstract class ObjetoDaCadeia {
  protected proximo: ObjetoDaCadeia | null = null;

  adcProximo(proximo: ObjetoDaCadeia): ObjetoDaCadeia {
    this.proximo = proximo;
    return proximo;
  }

  trata(requisição: string): string {
    if (this.proximo) return this.proximo.trata(requisição);
    return requisição;
  }
}

class ObjA extends ObjetoDaCadeia {
  trata(requisição: string): string {
    return super.trata(requisição + 'ObjA, ');
  }
}

class ObjB extends ObjetoDaCadeia {
  trata(requisição: string): string {
    return super.trata(requisição + 'ObjB, ');
  }
}

const objetoA = new ObjA();
objetoA.adcProximo(new ObjB()).adcProximo(new ObjB()).adcProximo(new ObjA());
console.log(objetoA.trata('Inicial, ')); // Inicial, ObjA, ObjB, ObjB, ObjA
```

## Consequências

O que é bom ou ruim no Chain Of Responsibility:

**Bom:**
- Aplica o princípio da responsabilidade única (SRP)
- Aplica o princípio do aberto e fechado (OCP)
- Permite que você altere a cadeia de objetos e a ordem das chamadas facilmente

**Ruim:**
- é comum uma requisição passar por toda a cadeia e não ser tratada
