# Paradigmas de Programação

## Introdução
A programação é uma área repleta de diferentes abordagens, cada uma com sua própria forma de estruturar e organizar o código. Entre essas abordagens, temos dois paradigmas: o **imperativo** e o **declarativo**.

O **paradigma imperativo** foca no *como* um problema deve ser resolvido, ou seja, ele define passo a passo as instruções que o computador deve seguir para alcançar um resultado. Já o **paradigma declarativo** se preocupa mais com *o que* precisa ser feito, deixando que a linguagem de programação se encarregue dos detalhes de execução.

---

## Comparação entre Java e Prolog
### Código em Java (Paradigma Imperativo)
```java
public class Fatorial {
    public static int calcularFatorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    public static void main(String[] args) {
        System.out.println("Fatorial de 5: " + calcularFatorial(5));
    }
}
```
### Código em Prolog (Paradigma Declarativo)
```prolog
fatorial(0, 1).
fatorial(N, F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.
```

---

## Comparação entre os códigos
### Java: Passo a passo e controle total
No código em Java, seguimos um estilo **imperativo**, no qual:
- Definimos explicitamente **como** o fatorial será calculado.
- Utilizamos uma variável (`resultado`) que sofre modificações ao longo da execução.
- O cálculo é feito através de um **loop** (`for`), que percorre os números de `2` até `n`, multiplicando cada um ao valor anterior.

Esse modelo é característico de linguagens como **C, C++ e Java**, nas quais o desenvolvedor tem controle total sobre a sequência de execução do código.

### Prolog: Definição lógica do problema
Já o código em Prolog segue um estilo **declarativo**, onde:
- O foco está em **definir a lógica do problema**, e não em detalhar os passos de execução.
- Utilizamos **recursão** para descrever matematicamente o fatorial: o fatorial de `N` é `N * fatorial(N-1)`, com a exceção de que `fatorial(0) = 1`.
- Não há um loop explícito; o próprio interpretador Prolog resolve as chamadas recursivas até encontrar o resultado final.

Esse estilo é comum em linguagens **lógicas e funcionais**, como **Prolog, Haskell e Lisp**, onde o programador se preocupa mais com a relação entre os elementos do problema do que com o fluxo de execução.

---

## Conclusão
Os paradigmas **imperativo** e **declarativo** representam formas distintas de pensar a programação:
- O **paradigma imperativo** é ideal quando precisamos de controle preciso sobre cada etapa do processo, definindo claramente a ordem das operações.
- O **paradigma declarativo** favorece a simplicidade e a expressividade, permitindo que nos concentremos no que queremos resolver, sem nos preocuparmos tanto com o como.
- Enquanto Java exige que detalhemos todas as instruções para calcular um fatorial, Prolog simplesmente define uma relação matemática e permite que o sistema descubra a resposta. Nenhuma abordagem é melhor que a outra—cada uma tem seus usos dependendo do contexto e do problema a ser resolvido.

