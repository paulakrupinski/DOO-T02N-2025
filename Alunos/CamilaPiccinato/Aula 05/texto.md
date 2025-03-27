# Imperativo e Declarativo

## Visão Geral
Diferentes abordagens podem ser utilizadas para resolver problemas em programação. Entre elas, destacam-se as metodologias **processual** e **lógica**, que influenciam diretamente como o código é estruturado e executado.

## Programação Processual
A programação processual é baseada em uma sequência de comandos que manipulam o estado do programa. O foco está na **execução passo a passo**, onde o programador define exatamente como as operações devem ser realizadas.

## Programação Lógica
Já a programação lógica enfatiza a **definição de fatos e regras**, permitindo que o motor da linguagem deduza soluções. O programador especifica **o que** precisa ser resolvido, e não **como** resolver. Prolog é um exemplo clássico desse paradigma.

---

### Implementação em Java (Imperativo)
```java
import java.util.Arrays;

public class ContemNumero {
    public static boolean contem(int numero, int[] lista) {
        for (int elemento : lista) {
            if (elemento == numero) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] lista = {5, 15, 25, 35, 45};
        System.out.println(contem(25, lista)); // true
        System.out.println(contem(10, lista)); // false
    }
}
```
**Explicação:**
- O programa percorre a lista utilizando um laço `for`.
- A cada iteração, verifica se o número desejado está presente.
- Se encontrado, retorna `true`; caso contrário, `false`.


### Implementação em Prolog (Declarativa)
```prolog
fatorial(0, 1).
fatorial(N, F) :- N > 0, N1 is N - 1, fatorial(N1, F1), F is N * F1.

% Testes
?- fatorial(5, Resultado). % Resultado = 120
?- fatorial(3, Resultado). % Resultado = 6
```
**Explicação:**
- A primeira regra define que o fatorial de `0` é `1`.
- A segunda regra usa **recursão** para calcular `N! = N * (N-1)!`.
- O interpretador Prolog encontra a solução automaticamente.