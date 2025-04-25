## Paradigmas de Programação

A programação pode ser abordada de diversas formas, com base em diferentes paradigmas. Entre os mais importantes, estão o paradigma **imperativo** e o **declarativo**.

### Paradigma Imperativo

No paradigma imperativo, o foco está em como as coisas são feitas. O programador especifica as instruções passo a passo para que o computador execute as tarefas desejadas. Em outras palavras, o código descreve uma sequência de operações que o computador deve realizar para alcançar o objetivo final. A programação imperativa é baseada em mudanças de estado e controle explícito de fluxo.

### Paradigma Declarativo

Por outro lado, o paradigma declarativo foca no que deve ser feito, sem especificar como. O programador descreve o problema e as condições que devem ser atendidas, e o sistema ou a linguagem responsável determina a melhor forma de resolver o problema. Em vez de se preocupar com o controle de fluxo ou com os detalhes de implementação, o desenvolvedor apenas define as propriedades desejadas da solução.

## Comparação entre Java e Prolog

A seguir, serão analisados dois trechos de código, um escrito em **Java**, uma linguagem imperativa, e outro em **Prolog**, uma linguagem declarativa, para mostrar como ambos alcançam o mesmo objetivo de maneira diferente.

### Exemplo de Código em Java

public class Fatorial {    
    public static int calcularFatorial(int n) {    
        int resultado \= 1;    
        for (int i \= 1; i \<= n; i++) {    
            resultado \*= i;    
        }    
        return resultado;    
    }

    public static void main(String\[\] args) {    
        System.out.println(calcularFatorial(5)); // Saída: 120    
    }    
}

### Exemplo em Prolog

prolog fatorial(0, 1). fatorial(N, F) :- N \> 0, N1 is N \- 1, fatorial(N1, F1), F is N \* F1.

### Diferença entre os métodos

A grande diferença entre os dois exemplos é como eles resolvem o problema. No Java, o programador tem que dizer exatamente o que fazer em cada passo do cálculo, como se estivesse dando uma receita bem detalhada. Já no Prolog, a coisa é mais "deixar o sistema se virar". O programador só diz o que precisa ser feito, e o sistema é que cuida de todo o resto, sem precisar explicar o passo a passo.