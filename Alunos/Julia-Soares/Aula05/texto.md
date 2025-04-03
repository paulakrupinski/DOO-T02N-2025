# Paradigmas de Programação: Imperativo e Declarativo  

As abordagens de programação oferecem distintas maneiras de desenvolver softwares. Entre elas, os paradigmas **imperativo** e **declarativo** se destacam, apresentando diferenças na forma como instruções são formuladas para resolver desafios computacionais.  

## Paradigma Imperativo  

O paradigma imperativo se baseia na especificação clara das etapas a serem seguidas para atingir um objetivo. Ele enfatiza **como** a solução deve ser executada, utilizando sequências de instruções, laços e estruturas condicionais. Linguagens como **C, Java e Python** operam nesse modelo.  

### Exemplo em Java: Verificar se uma palavra é um palíndromo  

```java
public class Palindromo {
    public static boolean ehPalindromo(String palavra) {
        String invertida = new StringBuilder(palavra).reverse().toString();
        return palavra.equalsIgnoreCase(invertida);
    }

    public static void main(String[] args) {
        String palavra = "radar";
        System.out.println("A palavra \"" + palavra + "\" é um palíndromo? " + ehPalindromo(palavra));
    }
}
Neste exemplo:

A função ehPalindromo inverte a palavra e compara com a original.

Se forem iguais, significa que a palavra é um palíndromo.

O programa executa uma sequência de etapas para verificar essa condição.

Paradigma Declarativo
O paradigma declarativo concentra-se no o que precisa ser realizado, sem especificar como atingir esse objetivo. Ele utiliza regras e expressões matemáticas, delegando a execução ao interpretador ou compilador. Linguagens como SQL, Haskell e Prolog utilizam essa abordagem.

Exemplo em Prolog: Verificar se uma palavra é um palíndromo


palindromo(Palavra) :- reverse(Palavra, Palavra).

?- palindromo([r,a,d,a,r]).
true.
Neste caso:

A regra palindromo(Palavra) verifica se a palavra invertida é igual à original.

A consulta ?- palindromo([r,a,d,a,r]). retorna true, indicando que "radar" é um palíndromo.

Prolog define a lógica do problema sem especificar os passos exatos da execução.

Comparação entre os Paradigmas

No caso do Java (Imperativo), seu foco é como alcançar a solução, na execução é sequencial de etapas, sua estrutura são laços, condicionais e variáveis, o controle é definido pelo programador.

Partindo para o prolog (Declarativo), o foco é como aquele objetivo deve ser alcançado, na execução é racicínio lógico, sua estrutura é baseada em regras e fatos e o seu controle é definido pelo interpretador.

O paradigma imperativo, exemplificado pelo Java, descreve em detalhes cada passo necessário para resolver um problema. Já o paradigma declarativo, como no Prolog, enfatiza as condições que precisam ser satisfeitas, deixando a execução a cargo do interpretador. A escolha entre esses paradigmas depende do problema a ser resolvido e da abordagem preferida pelo programador.

