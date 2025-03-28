# Paradigmas de Programação: Imperativo vs. Declarativo

## Introdução

Ao iniciar a faculdade de Engenharia de Software, um dos primeiros conceitos que aprendemos é sobre **paradigmas de programação**. Esses paradigmas representam diferentes formas de estruturar e resolver problemas computacionais. Dois dos principais paradigmas são o **imperativo** e o **declarativo**.

De forma simples, o **paradigma imperativo** é como uma receita de bolo: seguimos um conjunto de passos para chegar ao resultado final. Já o **paradigma declarativo** é mais como dizer o que queremos sem nos preocupar com os detalhes de como isso será feito. Neste texto, vou apresentar esses dois paradigmas e comparar um exemplo em **Java** (imperativo) com outro em **Prolog** (declarativo).

## Paradigma Imperativo

O paradigma **imperativo** é baseado em comandos sequenciais que alteram o estado do programa. Ele segue uma lógica procedural, onde descrevemos passo a passo o que precisa ser feito. Linguagens como **C, Java e Python** seguem esse modelo.

### Exemplo em Java:

```java
public class Fatorial {
    public static int calcularFatorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int numero = 5;
        System.out.println("Fatorial de " + numero + " é: " + calcularFatorial(numero));
    }
}
```

### Explicação:

Aqui, criamos um método `calcularFatorial` que recebe um número inteiro e usa um **loop** `for` para multiplicar os valores até chegar ao resultado final. Essa abordagem descreve **passo a passo** como o cálculo deve ser feito, modificando a variável `resultado` a cada iteração.

## Paradigma Declarativo

O paradigma **declarativo** foca em descrever **o que** precisa ser feito, sem especificar **como** isso será realizado. Em vez de comandos sequenciais, usamos regras e relações. Linguagens como **Prolog, SQL e Haskell** seguem esse modelo.

### Exemplo em Prolog:

```prolog
fatorial(0,1).
fatorial(N, Resultado) :- 
    N > 0,
    N1 is N - 1,
    fatorial(N1, R1),
    Resultado is N * R1.
```

### Explicação:

No código acima, usamos uma abordagem **recursiva** para definir o fatorial. A primeira linha `fatorial(0,1).` define que o fatorial de 0 é 1. A segunda regra explica que para um número `N`, o fatorial é `N * fatorial(N-1)`. Aqui, não precisamos dizer ao computador como fazer os cálculos passo a passo; ele mesmo resolve isso.

## Comparação entre os Paradigmas

| Aspecto                       | Java (Imperativo)                                     | Prolog (Declarativo)                  |              |   |
| ----------------------------- | ----------------------------------------------------- | ------------------------------------- | ------------ | - |
| **Forma de pensar**           |                                                       | Foca no "o quê" resolver              |              |   |
| **Fluxo de execução**         | Sequencial, baseado em loops e variáveis              | Baseado em regras e inferência lógica |              |   |
| **Estado do programa**\* \*\* | Modificado explicitamente a Gerenciado implicitamente |                                       |              |   |
| ada passo                     | **Controle de fluxo**\* \*\*                          | Usa loops (`for`, `while`)            | Usa recursão |   |

## Conclusão

Aprender sobre os paradigmas de programação é essencial para qualquer estudante de Engenharia de Software. O **paradigma imperativo** é mais intuitivo para quem está começando, pois segue uma lógica sequencial. Já o **paradigma declarativo** pode parecer mais abstrato, mas é muito útil para resolver problemas complexos, como consultas em bancos de dados e inteligência artificial. Ambos os paradigmas têm suas vantagens, e saber escolher o mais adequado para cada situação é uma habilidade importante para futuros desenvolvedores!

