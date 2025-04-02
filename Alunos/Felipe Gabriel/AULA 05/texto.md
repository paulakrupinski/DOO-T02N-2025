# Paradigmas de Programação: Imperativo vs. Declarativo

Ao longo da história da programação, surgiram diversos paradigmas que influenciaram a forma como desenvolvemos software, cada um com sua abordagem e filosofia própria. Dentre eles, os paradigmas imperativo e declarativo se destacam como os mais proeminentes.

No paradigma imperativo, o objetivo é detalhar a sequência exata de ações que o computador deve executar para atingir o resultado desejado. O programador descreve de maneira explícita como o processo deve ocorrer, utilizando estruturas como loops, condições e variáveis mutáveis. Linguagens como C, Java e Python são exemplos típicos desse estilo.

Em contraste, o paradigma declarativo foca na descrição do que deve ser feito, sem especificar os detalhes de como isso será alcançado. A ênfase está nas relações e na lógica dos dados, utilizando conceitos como imutabilidade e recursão. Linguagens como Prolog e SQL são exemplos proeminentes desse paradigma.

## Comparação entre Java (Imperativo) e Prolog (Declarativo)

A seguir, apresentamos a comparação entre dois trechos de código que verificam se um número é par, um em Java (paradigma imperativo) e outro em Prolog (paradigma declarativo), para destacar as diferenças entre esses dois paradigmas.

### Código em Java (Paradigma Imperativo)

```java
Copiar
public class VerificadorParidade {
    public static boolean ehNumeroPar(int numero) {
        return numero % 2 == 0; // Verifica se o resto da divisão por 2 é zero
    }

    public static void main(String[] args) {
        int numeroTeste = 4;
        if (ehNumeroPar(numeroTeste)) { // Verifica se o número é par
            System.out.println(numeroTeste + " é par.");
        } else {
            System.out.println(numeroTeste + " é ímpar.");
        }
    }
}

% Regra para verificar se um número é par
par(X) :- 0 is X mod 2.

% Exemplo de consulta
% ?- par(4).
% Resultado: true
