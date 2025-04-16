# Paradigmas de Programação: Imperativo vs. Declarativo

A programação pode ser abordada de diversas formas, sendo os paradigmas imperativo e declarativo dois dos mais comuns. Cada um apresenta uma maneira distinta de estruturar e resolver problemas computacionais.

## Paradigma Imperativo
O paradigma imperativo foca em descrever **como** um programa deve executar suas tarefas, utilizando sequências de comandos que modificam o estado do programa. As linguagens que seguem esse modelo incluem C, Java e Python. Esse paradigma enfatiza estruturas de controle, como loops e condicionais, para manipular variáveis e atingir um determinado objetivo.

## Paradigma Declarativo
No paradigma declarativo, o foco está em **o que** deve ser feito, sem especificar diretamente como a solução deve ser alcançada. Ele se baseia em regras, fatos e expressões lógicas para definir o problema, deixando para o sistema a responsabilidade de encontrar a solução. Linguagens como Prolog e SQL seguem esse modelo.

---

## Comparação de Códigos: Java vs. Prolog
A seguir, compararemos dois trechos de código que verificam se um número é par, utilizando Java (paradigma imperativo) e Prolog (paradigma declarativo).

### Exemplo em Java (Imperativo)
```java
public class Paridade {
    public static boolean ehPar(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        int numero = 4;
        System.out.println("O número " + numero + " é par? " + ehPar(numero));
    }
}
```
### Explicação (Java)
- O código define um método `ehPar` que recebe um número e retorna `true` se for par, utilizando o operador de módulo (`%`).
- A função `main` chama esse método e imprime o resultado, seguindo uma abordagem imperativa baseada em chamadas diretas e execução sequencial.

---

### Exemplo em Prolog (Declarativo)
```prolog
eh_par(N) :- 0 is N mod 2.
```
### Explicação (Prolog)
- A regra `eh_par(N)` define que um número é par se o resto da divisão por 2 for zero.
- Diferente do Java, não há execução explícita de passos, apenas uma regra lógica que será consultada quando necessário.
- Para verificar se um número é par, basta consultar `eh_par(4).`, e o Prolog retornará `true` se for verdadeiro.

---

## Conclusão
Enquanto Java utiliza uma abordagem passo a passo para determinar a paridade de um número, Prolog simplesmente define uma relação lógica. No paradigma imperativo, o programador tem controle sobre o fluxo de execução, enquanto no paradigma declarativo, a linguagem se encarrega de encontrar a solução com base nas regras definidas. A escolha do paradigma depende do contexto e do problema a ser resolvido.
