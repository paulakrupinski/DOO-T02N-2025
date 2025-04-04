# Paradigmas de Programacao: Imperativo vs. Declarativo

A programacao de computadores pode ser categorizada em diferentes paradigmas, cada um com uma abordagem distinta para a solucao de problemas. Dois paradigmas fundamentais sao o **imperativo** e o **declarativo**.

## Programacao Imperativa

A programacao imperativa e baseada na definicao de uma sequencia de instrucoes que alteram o estado do programa ao longo do tempo. Linguagens como **C, Java e Python** seguem esse paradigma. O foco esta em **como** a tarefa deve ser realizada, utilizando estruturas como **loops, condicionais e variaveis mutaveis**.

### Exemplo em Java

O codigo abaixo implementa a verificacao de numeros pares utilizando o paradigma imperativo:

```java
public class Main {
    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(ehPar(4)); // true
    }
}
```

Neste codigo, a funcao `ehPar` calcula o resto da divisao por 2 e retorna `true` se for igual a zero. A execucao segue um fluxo logico bem definido, alterando o estado do programa conforme necessario.

## Programacao Declarativa

A programacao declarativa, ao contrario da imperativa, enfatiza **o que** deve ser feito em vez de **como** faze-lo. **Prolog, SQL e Haskell** sao exemplos de linguagens declarativas. Esse paradigma foca em expressar a logica do problema sem definir explicitamente o controle do fluxo.

### Exemplo em Prolog

O mesmo problema da verificacao de numeros pares pode ser resolvido em Prolog da seguinte forma:

```prolog
par(X) :- X mod 2 =:= 0.
```

#### Consulta:

```prolog
?- par(4).
true.
```

Aqui, declaramos uma regra `par(X)`, que retorna verdadeiro se `X mod 2` for zero. O Prolog, ao receber uma consulta (`?- par(4).`), verifica a base de conhecimento e retorna `true` ou `false` sem a necessidade de controle explicito do fluxo de execucao.

## Comparacao Entre os Paradigmas

- A abordagem **imperativa** exige um detalhamento explicito de cada passo da execucao.
- A abordagem **declarativa** abstrai esses detalhes e se concentra na logica do problema.

## Conclusao

A escolha entre programacao **imperativa** e **declarativa** depende do contexto e do problema a ser resolvido.  
- O **paradigma imperativo** e mais intuitivo para quem esta acostumado a controlar diretamente o fluxo do programa.  
- O **paradigma declarativo** pode ser mais expressivo e eficiente para problemas que envolvem regras logicas e inferencia.  

Ambos tem suas vantagens e desvantagens, sendo uteis em diferentes cenarios da computacao.

