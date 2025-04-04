# Paradigmas de Programação: Imperativo vs. Declarativo

A programação pode ser abordada de diferentes formas, sendo os paradigmas **imperativo** e **declarativo** dois dos principais estilos de desenvolvimento. Cada paradigma define uma maneira distinta de pensar e resolver problemas computacionais.

## Paradigma Imperativo

O paradigma **imperativo** é baseado na ideia de **comandos sequenciais** que modificam o estado do programa. Nele, o programador **descreve detalhadamente como** uma tarefa deve ser executada, utilizando estruturas como **laços**, **condicionais** e **variáveis mutáveis**. Linguagens como **Java**, **C** e **Python** são exemplos que seguem esse paradigma.

### Exemplo em Java

```java
public class Fatorial {
    public static int fatorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(fatorial(5)); // Saída: 120
    }
}
```

Neste código, o cálculo do fatorial é feito **passo a passo**. O programador especifica o controle do laço, a inicialização da variável e a multiplicação iterativa. Isso exemplifica a característica **imperativa** de detalhar o **como fazer**.

## Paradigma Declarativo

Por outro lado, o paradigma **declarativo** foca em descrever **o que** deve ser feito, sem necessariamente explicitar o caminho para chegar ao resultado. Nele, o programador define **relações e condições**, deixando a resolução para o motor da linguagem.

**Prolog**, **SQL** e **Haskell** são linguagens declarativas.

### Exemplo em Prolog

```prolog
fatorial(0, 1).
fatorial(N, F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.
```

No exemplo acima, o código define **regras lógicas** para o cálculo do fatorial. A linguagem Prolog lida com **backtracking** e **inferência automática** para encontrar a solução. Aqui, o foco está no **o que é o fatorial**, e não **como** calculá-lo passo a passo.

## Comparação

| Aspecto              | Java (Imperativo)              | Prolog (Declarativo)                    |
|----------------------|--------------------------------|-----------------------------------------|
| **Abordagem**        | Passo a passo                  | Definição de regras                     |
| **Controle de execução** | Explícito (laços, variáveis)    | Implícito (motor lógico da linguagem)   |
| **Ênfase**           | Como fazer                     | O que é o problema                      |
| **Legibilidade**     | Mais fácil para fluxos conhecidos | Mais expressivo para problemas lógicos |

## Conclusão

Enquanto o paradigma **imperativo** oferece **controle detalhado** sobre o fluxo do programa, o paradigma **declarativo** permite resolver problemas por meio da **descrição de suas propriedades**.

A escolha entre eles depende do tipo de aplicação, da complexidade do domínio e do estilo do programador. Compreender **ambos** é essencial para a formação de um profissional completo em ciência da computação.
