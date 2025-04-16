# Paradigmas de Programação: Imperativo vs. Declarativo

A programação pode ser abordada por diferentes paradigmas, sendo os mais proeminentes o **imperativo** e o **declarativo**. No paradigma **imperativo**, o foco está na definição explícita da sequência de passos necessários para alcançar um objetivo, utilizando estruturas como loops, condicionais e variáveis mutáveis. Linguagens como C, Java e Python frequentemente seguem esse modelo. Por outro lado, o paradigma **declarativo** enfatiza a descrição do que deve ser feito, sem especificar como. Aqui, prevalecem conceitos como imutabilidade e recursão, sendo Prolog e SQL exemplos desse estilo.

## Comparação entre Java (Imperativo) e Prolog (Declarativo)

A seguir, comparamos dois trechos de código que verificam se um número é par, um em Java e outro em Prolog.

### Código em Java (Paradigma Imperativo)
```java
public class Paridade {
    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }
    
    public static void main(String[] args) {
        int numero = 4;
        if (ehPar(numero)) {
            System.out.println(numero + " é par.");
        } else {
            System.out.println(numero + " é ímpar.");
        }
    }
}
```
**Descrição:**
- O código define uma função `ehPar` que recebe um número inteiro e retorna `true` se o resto da divisão por 2 for zero.
- No `main`, um número é testado e uma estrutura condicional (`if-else`) imprime o resultado na tela.
- A abordagem é sequencial e explícita, definindo todas as operações de maneira detalhada.

### Código em Prolog (Paradigma Declarativo)
```prolog
eh_par(N) :- N mod 2 =:= 0.

?- eh_par(4).
```
**Descrição:**
- A regra `eh_par(N)` define que um número é par se a condição `N mod 2 =:= 0` for verdadeira.
- No interpretador Prolog, consulta-se `?- eh_par(4).`, e a resposta será `true` ou `false`.
- Diferente do Java, o código não especifica como executar a verificação, apenas expressa a relação lógica entre os elementos.

## Conclusão
O paradigma imperativo, exemplificado pelo Java, descreve detalhadamente os passos necessários para determinar a paridade de um número. Já no paradigma declarativo, representado pelo Prolog, apenas a propriedade matemática do número par é definida, deixando para o motor de inferência da linguagem a responsabilidade de avaliar a consulta. Ambos os paradigmas possuem aplicações distintas e são escolhidos conforme a necessidade do problema a ser resolvido.
