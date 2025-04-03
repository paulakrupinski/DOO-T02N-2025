# Paradigmas de Programação: Imperativo e Declarativo

## Introdução

Os paradigmas de programação são modelos que definem a abordagem utilizada para resolver problemas computacionais. Dois paradigmas amplamente utilizados são o imperativo e o declarativo. O paradigma imperativo foca em instruções sequenciais que modificam o estado do programa, enquanto o paradigma declarativo descreve o que deve ser feito, deixando a execução sob responsabilidade do sistema.

## Paradigma Imperativo

O paradigma imperativo é baseado em comandos sequenciais que alteram diretamente o estado do programa. Ele segue a lógica de "como fazer", utilizando conceitos como atribuição de variáveis, loops e estruturas condicionais. Linguagens como C, Java e Python seguem essa abordagem.

### Exemplo de código em Java para calcular o fatorial de um número:

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
        System.out.println("Fatorial de " + numero + " é " + calcularFatorial(numero));
    }
}
```

Neste exemplo, a função calcularFatorial utiliza um laço for para iterar e multiplicar sucessivamente os números até n, modificando a variável resultado em cada iteração.

## Paradigma Declarativo

O paradigma declarativo enfatiza "o que deve ser feito" ao invés de "como fazer". Nele, o programador define regras e relações lógicas, sem especificar detalhadamente o fluxo de controle. Linguagens como SQL, Prolog e Haskell são exemplos de abordagem declarativa.

### Exemplo de código em Prolog para calcular o fatorial:

fatorial(0,1).
fatorial(N,F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.

Aqui, o fatorial é definido recursivamente: o caso base (
fatorial(0,1)) estabelece que o fatorial de 0 é 1. Para N > 0, o programa calcula o fatorial de N-1 antes de multiplicá-lo por N. O interpretador do Prolog resolve a consulta automaticamente seguindo as regras definidas.

## Comparativo

Em resumo, o paradigma imperativo detalha a sequência de passos necessária para atingir um resultado, enquanto o paradigma declarativo expressa o problema por meio de regras e relações, deixando a resolução para o sistema. Ambos são eficientes em seus contextos, e a escolha depende das necessidades do projeto e das características desejadas na implementação.