
# Paradigmas de Programação: Imperativo x Declarativo

## Introdução

Na aula teórica do dia 20/03/2025, foram discutidos os paradigmas de programação imperativo e declarativo, que representam formas distintas de estruturar soluções para problemas computacionais. Compreender essas abordagens é essencial para o desenvolvimento de sistemas eficientes, legíveis e adequados ao contexto de aplicação.

## Paradigma Imperativo

O paradigma imperativo é baseado na ideia de comandos sequenciais que modificam o estado do programa. Nele, o programador descreve  a tarefa deve ser realizada, passo a passo, controlando o fluxo de execução com estruturas como laços, condicionais e variáveis mutáveis.

Exemplo em Java (Imperativo)

java
public class Fatorial {
    public static int calcularFatorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println(calcularFatorial(5)); // Saída: 120
    }
}


## Paradigma Declarativo

No paradigma declarativo, o foco está em **o que** deve ser feito, e não em como. O programador descreve as propriedades do resultado desejado, deixando que o mecanismo de execução encontre a solução. É comum em linguagens como Prolog, SQL e Haskell.

### Exemplo em Prolog (Declarativo)

    prolog
fatorial(0, 1).
fatorial(N, F) :-
    N > 0,
    N1 is N - 1,
    fatorial(N1, F1),
    F is N * F1.


## Comparação

| Característica         | Java (Imperativo)                        | Prolog (Declarativo)                         |
|------------------------|------------------------------------------|----------------------------------------------|
| Controle de execução   | Explícito (comandos e fluxo definido)    | Implícito (motor de inferência)              |
| Estilo de programação  | Passo a passo, baseado em estado         | Baseado em lógica e relações                 |
| Facilidade de depuração| Mais direta em pequenos programas        | Pode ser desafiadora pela abstração do fluxo |
| Paradigma principal    | Imperativo/Orientado a Objetos           | Lógico/Declarativo                           |

## Conclusão

Ambos os paradigmas têm seus pontos fortes e são adequados para diferentes tipos de problemas. O paradigma imperativo é mais intuitivo para tarefas com controle rígido do fluxo, enquanto o declarativo brilha em domínios que envolvem conhecimento simbólico e raciocínio lógico. Entender essas abordagens amplia a capacidade de selecionar a ferramenta certa para cada desafio computacional.
