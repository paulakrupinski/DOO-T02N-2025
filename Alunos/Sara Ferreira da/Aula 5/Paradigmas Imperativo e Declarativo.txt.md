Paradigmas Imperativo e Declarativo
Os paradigmas de programação podem ser classificados em diversos tipos, sendo os mais comuns o imperativo e o declarativo. A principal diferença entre eles está na forma como o programador especifica o que deseja alcançar.

Paradigma Imperativo
No paradigma imperativo, o programador define uma sequência de instruções que o computador deve seguir para atingir o objetivo desejado. Ou seja, o foco está em como o problema será resolvido.
A programação imperativa se baseia em comandos que alteram o estado do sistema, geralmente utilizando loops, condicionais e atribuições de variáveis. Linguagens como Java, C e Python são típicas do paradigma imperativo.

Paradigma Declarativo
Por outro lado, o paradigma declarativo se preocupa com o que deve ser alcançado, e não com os passos necessários para isso. No paradigma declarativo, o programador descreve o problema a ser resolvido e deixa para o sistema a responsabilidade de determinar como
atingir a solução. Linguagens como SQL, HTML e Prolog são exemplos de linguagens declarativas, em que o foco está em expressar as relações e restrições entre os dados ou condições, e não em como manipulá-los passo a passo.

Comparação de Código: Java vs Prolog
Exemplo em Java (Imperativo) tem como objetivo encontrar o fatorial de um número:
public class Fatorial {
    public static void main(String[] args) {
        int n = 5;
        int fatorial = 1;
        for (int i = 1; i <= n; i++) {
            fatorial *= i;
        }
        System.out.println("Fatorial de " + n + " é " + fatorial);
    }
}
Como funciona:

O código segue uma sequência de instruções para calcular o fatorial de um número.

O programa utiliza um laço for para multiplicar uma variável fatorial por cada número de 1 até n.

Esse processo de repetição e alteração de estado (variáveis) é um exemplo típico do paradigma imperativo, onde a ordem das operações e as modificações do estado do sistema são explicitamente definidas.

Exemplo em Prolog (Declarativo) o mesmo objetivo (calcular o fatorial) em uma linguagem declarativa:
fatorial(0, 1).
fatorial(N, F) :- N > 0, N1 is N - 1, fatorial(N1, F1), F is N * F1.
Como funciona:

O código em Prolog descreve as regras que determinam o fatorial. A primeira regra afirma que o fatorial de 0 é 1.

A segunda regra define que o fatorial de um número N é igual a N multiplicado pelo fatorial de N-1, e assim por diante.

Prolog, portanto, não especifica como as operações serão feitas em termos de fluxo de controle, mas apenas define as relações entre os valores. O sistema de Prolog é responsável por calcular o fatorial, utilizando recursão para explorar as regras e encontrar a solução.

Comparação
Java (Imperativo): No código em Java, o programador especifica detalhadamente cada passo necessário para calcular o fatorial. O foco está em controlar o fluxo de execução, e o estado do programa (variáveis) é alterado explicitamente.
O programador precisa se preocupar com o como o problema será resolvido.

Prolog (Declarativo): No código em Prolog, o programador define as relações entre os números e a condição do problema, sem se preocupar com o controle do fluxo ou a implementação do algoritmo.
O sistema de Prolog, por meio de seu mecanismo de inferência, determina a forma de resolver o problema.

Portanto, enquanto o código em Java exige uma abordagem mais detalhada e procedural, o código em Prolog expressa a lógica do problema de forma mais abstrata e compacta, delegando o controle ao sistema.

Conclusão
Os paradigmas imperativo e declarativo refletem abordagens distintas para resolver problemas.
O paradigma imperativo exige que o programador defina os passos a serem seguidos, enquanto no paradigma declarativo, o programador se limita a descrever as relações e deixar para o sistema a responsabilidade de como resolver o problema.
A comparação entre os exemplos de código em Java e Prolog ilustra bem essas diferenças:
Java com seu controle explícito de fluxo e manipulação de estado, e Prolog com a definição de regras que o sistema executa automaticamente.