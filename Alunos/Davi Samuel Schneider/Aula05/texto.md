# Paradigmas de Programação: Imperativo vs Declarativo

## Introdução

Na programação, diferentes paradigmas definem como um problema pode ser resolvido. Dois dos mais comuns são o **imperativo** e o **declarativo**.

- **Paradigma Imperativo:** O programador dá instruções detalhadas sobre o que fazer e como fazer, controlando o fluxo do programa passo a passo.
- **Paradigma Declarativo:** O foco está em descrever o que precisa ser feito, deixando que a linguagem ou o interpretador se encarregue da execução.

## Comparação entre Java e Prolog

Vamos analisar um exemplo de código em Java (paradigma imperativo) e Prolog (paradigma declarativo) para verificar se um número é par.

### Código em Java (Imperativo)

```java
public class Paridade {
    public static void main(String[] args) {
        System.out.println(ehPar(4)); // true
        System.out.println(ehPar(7)); // false
    }

    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }
}
```

### Código em Prolog (Declarativo)

```prolog
eh_par(N) :- N mod 2 =:= 0.

?- eh_par(4). % true
?- eh_par(7). % false
```

## Diferenças entre os paradigmas

### Java (Imperativo)

- O código descreve explicitamente como a verificação de paridade deve ser feita.
- O fluxo de execução é controlado por chamadas de funções e operações condicionais.
- O estado do programa muda conforme a execução avança.

### Prolog (Declarativo)

- A solução é descrita como uma relação lógica, sem necessidade de detalhar o fluxo de execução.
- O interpretador processa a consulta e responde com base nas regras definidas.
- O código é mais próximo da matemática, focado na descrição do problema e não na sequência de passos.

## Conclusão

O paradigma imperativo fornece mais controle sobre o comportamento do programa, enquanto o declarativo permite uma abordagem mais abstrata e expressiva. A escolha entre um ou outro depende da natureza do problema e do nível de detalhamento desejado na implementação.
