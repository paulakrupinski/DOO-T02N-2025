# Paradigmas de Programação: Imperativo e Declarativo

## Introdução

Os paradigmas de programação são abordagens distintas para estruturar e desenvolver soluções computacionais. Dois paradigmas amplamente utilizados são o imperativo e o declarativo.

## Paradigma Imperativo

O paradigma imperativo foca em como a computação deve ser realizada. Ele define sequências de comandos e mudanças de estado explícitas. Linguagens como Java, C e Python seguem esse modelo, utilizando variáveis, loops e estruturas condicionais para controlar o fluxo do programa.

## Paradigma Declarativo

O paradigma declarativo, por outro lado, se concentra no que deve ser feito, sem especificar detalhadamente o fluxo de execução. Esse paradigma inclui linguagens funcionais e lógicas, como Prolog e Haskell, onde o programador descreve o problema e o ambiente de execução se encarrega de encontrar a solução.

Comparação entre Java e Prolog

A seguir, apresentamos dois trechos de código que resolvem o mesmo problema: verificar se um número está presente em uma lista.

### Código em Java (Paradigma Imperativo)

```java

public class BuscaNumero {
    public static boolean contem(int[] lista, int numero) {
        for (int elemento : lista) {
            if (elemento == numero) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        System.out.println(contem(numeros, 3)); // true
        System.out.println(contem(numeros, 6)); // false
    }
}
```
### Análise do Código em Java

O programa segue um fluxo controlado explicitamente com um loop (for) que percorre a lista.

Utiliza variáveis e um retorno explícito (return true ou return false).

O programador precisa definir cada passo do processo de busca na lista.

### Código em Prolog (Paradigma Declarativo)

```prolog

membro(X, [X|_]).
membro(X, [_|T]) :- membro(X, T).

?- membro(3, [1, 2, 3, 4, 5]). % true
?- membro(6, [1, 2, 3, 4, 5]). % 
```

### Análise do Código em Prolog

Define-se relações lógicas em vez de comandos sequenciais.

A recursão é usada para verificar se o elemento está na lista.

O mecanismo de inferência do Prolog busca automaticamente uma solução com base nas regras definidas.

O programador descreve o problema, mas não precisa especificar como a busca ocorre internamente.

## Conclusão

O paradigma imperativo (exemplificado pelo Java) exige que o programador detalhe cada etapa do processo, enquanto o paradigma declarativo (exemplificado pelo Prolog) permite descrever regras e relações, deixando a resolução para o interpretador. A escolha entre esses paradigmas depende do problema a ser resolvido e das preferências do desenvolvedor.