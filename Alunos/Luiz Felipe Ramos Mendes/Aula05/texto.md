# Paradigmas de Programação: Imperativo e Declarativo

## Introdução
Na programação, dois paradigmas amplamente utilizados são o **imperativo** e o **declarativo**. Cada um possui abordagens distintas para resolver problemas de programação, e isso se reflete diretamente na maneira como os programadores escrevem e estruturam o código. O paradigma **imperativo** se foca no "como" as coisas são feitas, ou seja, no controle detalhado do fluxo de execução do programa. Já o paradigma **declarativo** se concentra no "o que" deve ser feito, permitindo que o sistema decida como executar as instruções, com menos intervenção do programador.

## Paradigma Imperativo (Java)

O paradigma imperativo é caracterizado pela sequência de comandos que descrevem precisamente como uma tarefa deve ser realizada. No exemplo abaixo, temos um código em **Java**, uma linguagem que segue o paradigma imperativo:

### Exemplo de código em Java:

```java
public class Soma {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int resultado = a + b;
        System.out.println("A soma é: " + resultado);
    }
}
Como funciona?
Primeiramente, o código declara duas variáveis, a e b, e as inicializa com os valores 5 e 10, respectivamente.

Em seguida, realiza-se a soma desses dois valores e o resultado é armazenado na variável resultado.

Por fim, o código exibe o valor de resultado na tela.

Este exemplo reflete o estilo imperativo pois o programador controla explicitamente como o cálculo da soma deve ocorrer e como os resultados são apresentados. Cada passo é claramente indicado pelo código.

Paradigma Declarativo (Prolog)
O paradigma declarativo, por outro lado, é focado na descrição do que deve ser feito, sem se preocupar diretamente com o passo a passo de como isso será feito. O Prolog, uma linguagem lógica, segue esse paradigma.

Exemplo de código em Prolog:
prolog
Copiar
soma(A, B, Resultado) :- Resultado is A + B.

?- soma(5, 10, R).
Como funciona?
O código define uma relação entre as variáveis A, B e Resultado, onde Resultado é a soma de A e B.

Quando perguntamos ?- soma(5, 10, R)., o Prolog processa a consulta e retorna o valor de R, que é 15.

No código acima, o programador não precisa especificar como a soma deve ser feita ou controlar o fluxo da execução. O Prolog resolve a tarefa com base na declaração da relação, o que demonstra a natureza declarativa dessa linguagem.

Comparação entre os Paradigmas
1. Controle do Fluxo
No paradigma imperativo (Java), o programador define exatamente como cada passo será realizado. Há um controle explícito sobre o fluxo de execução, o que torna o código mais detalhado e sequencial.

No paradigma declarativo (Prolog), o programador descreve a lógica do problema, mas deixa o sistema decidir como a solução será alcançada. O código é mais conciso e foca em expressar a relação entre as variáveis.

2. Alteração de Estado
O paradigma imperativo (Java) lida com a alteração direta de variáveis e o gerenciamento do estado do programa. O programador manipula explicitamente os dados e controla o estado do sistema em cada momento.

O paradigma declarativo (Prolog), por outro lado, não exige manipulação explícita do estado. As variáveis são definidas em termos de relações, e o sistema é responsável por resolver o problema.

3. Enfoque
O imperativo foca no "como" fazer as coisas. O código descreve a sequência exata de operações para alcançar o objetivo.

O declarativo foca no "o que" deve ser feito. O programador descreve a solução desejada e o sistema cuida do resto.