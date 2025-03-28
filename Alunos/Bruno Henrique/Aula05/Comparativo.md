# Comparação Entre os Paradigmas Imperativo e Declarativo

## Introdução

Na programação, diferentes paradigmas são utilizados para estruturar a lógica e a resolução de problemas. Dois dos 
principais paradigmas abordados na aula foram o **imperativo** e o **declarativo**. Esses estilos 
possuem abordagens distintas para a construção de algoritmos e têm impacto direto na forma como desenvolvemos software.

## Paradigma Imperativo

O paradigma **imperativo** se baseia na descrição explícita dos passos necessários para alcançar um determinado 
resultado. Ele utiliza comandos sequenciais, laços e manipulação direta do estado do programa. 
Linguagens como **Java** geralmente adotam esse paradigma.

### Exemplo em Java:
```java
public class Soma {
    public static int soma(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int resultado = soma(5, 3);
        System.out.println("Resultado: " + resultado);
    }
}
```

Neste código, temos uma função `soma` que recebe dois números e retorna a soma deles. O programa é executado seguindo 
uma sequência clara de instruções, desde a chamada do método `soma` até a exibição do resultado na tela.

## Paradigma Declarativo

Por outro lado, o paradigma **declarativo** enfatiza a descrição do que deve ser feito, em vez de como fazer. 
Nesse contexto, o foco é na lógica do problema, sem a necessidade de descrever cada passo detalhadamente. 
Linguagens como **Prolog** seguem essa abordagem.

### Exemplo em Prolog:
```prolog
soma(A, B, Resultado) :- Resultado is A + B.
```
Aqui, a relação `soma/3` define que `Resultado` será o valor da soma de `A` e `B`. 
Ao consultar `soma(5, 3, X).`, o interpretador do Prolog resolve a equação automaticamente, retornando `X = 8` 
sem que seja necessário especificar os passos detalhados do cálculo.

## Comparação

1. **Forma de Resolução:** Em Java, descrevemos **passo a passo** o que deve ser feito. 
Já em Prolog, **definimos uma relação** e o interpretador deduz o resultado.


2. **Controle de Fluxo:** No imperativo, temos controle total sobre o fluxo do programa. 
No declarativo, o motor lógico da linguagem gerencia a execução.


3. **Abstração:** O código em Prolog é mais conciso e expressa diretamente o objetivo, enquanto o Java 
exige mais estrutura para alcançar o mesmo resultado.

## Conclusão

Os paradigmas imperativo e declarativo representam formas distintas de programar, cada uma com suas vantagens. 
O imperativo oferece maior controle sobre os passos da execução, já o declarativo permite um código mais 
expressivo e enxuto. Escolher entre esses paradigmas dependerá do contexto do problema e das necessidades 
do desenvolvedor.
