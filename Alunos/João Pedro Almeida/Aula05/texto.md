# Paradigmas de Programação: Imperativo vs. Declarativo

A programação, ao longo de sua evolução, tem sido moldada por diversos paradigmas, cada um com sua própria filosofia e abordagem. Dentre eles, os paradigmas **imperativo** e **declarativo** se destacam como os mais influentes.

No paradigma **imperativo**, o foco reside na descrição detalhada da sequência de passos necessários para alcançar um objetivo. O programador define explicitamente *como* o computador deve executar cada ação, utilizando estruturas de controle como loops, condicionais e variáveis mutáveis. Linguagens como C, Java e Python são exemplos clássicos desse paradigma.

Por outro lado, o paradigma **declarativo** prioriza a descrição do *que* deve ser feito, sem especificar o *como*. A ênfase está na lógica e nas relações entre os dados, utilizando conceitos como imutabilidade e recursão. Prolog e SQL são exemplos notáveis desse estilo.

## Comparação entre Java (Imperativo) e Prolog (Declarativo)

A seguir, comparamos dois trechos de código que verificam a paridade de um número, um em **Java** (paradigma imperativo) e outro em **Prolog** (paradigma declarativo), ilustrando as diferenças entre os paradigmas.

### Código em Java (Paradigma Imperativo)

```java
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
