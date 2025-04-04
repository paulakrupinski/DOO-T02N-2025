# Paradigmas de Programação: Imperativo vs. Declarativo

A programação pode ser classificada em diferentes paradigmas, sendo dois dos mais relevantes o **imperativo** e o **declarativo**. 

## Paradigma Imperativo
O paradigma imperativo se baseia na definição explícita dos passos que o programa deve seguir para alcançar um resultado. Ele foca em **como** o problema deve ser resolvido, utilizando estruturas como loops e condicionais. Linguagens como **Java, C e Python** frequentemente seguem esse paradigma.

## Paradigma Declarativo
Já o paradigma declarativo se concentra mais em **o que** deve ser feito do que em como deve ser realizado. Ele descreve a lógica do programa sem detalhar o fluxo de controle. Linguagens como **Prolog e SQL** são exemplos desse paradigma.

## Comparação Entre Código Java e Prolog
Abaixo, temos um exemplo de um programa que verifica se um número pertence a uma lista.

### Implementação em Java (Paradigma Imperativo)
```java
import java.util.Arrays;

public class BuscaNumero {
    public static boolean pertence(int numero, int[] lista) {
        for (int elemento : lista) {
            if (elemento == numero) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5};
        int numero = 3;
        System.out.println("Número pertence à lista? " + pertence(numero, lista));
    }
}
```
### Implementação em Prolog (Paradigma Declarativo)
```prolog
pertence(X, [X|_]).
pertence(X, [_|T]) :- pertence(X, T).

?- pertence(3, [1, 2, 3, 4, 5]).
```

## Comparação de Funcionamento

- **Java (Imperativo):**
  - Utiliza um loop para percorrer a lista e verificar se o número está presente.
  - A abordagem é baseada em instruções explícitas e controle do fluxo de execução.
  - O código manipula variáveis e repete operações até encontrar o resultado.

- **Prolog (Declarativo):**
  - Define a relação lógica entre um elemento e a lista.
  - Utiliza recursão para percorrer a lista, sem a necessidade de loops explícitos.
  - A consulta `?- pertence(3, [1, 2, 3, 4, 5]).` verifica se o número está na lista e retorna `true` ou `false`.

A principal diferença entre os paradigmas se reflete na estrutura do código: enquanto Java detalha **como** encontrar o número na lista, Prolog apenas declara a relação entre os elementos e deixa que o interpretador resolva o problema de forma lógica.
