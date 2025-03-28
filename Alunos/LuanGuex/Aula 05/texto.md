# Paradigmas de Programação: Imperativo vs Declarativo

## Introdução
Os paradigmas de programação definem diferentes abordagens para resolver problemas computacionais. Dois dos principais paradigmas são o **imperativo** e o **declarativo**. 

## Paradigma Imperativo
O paradigma imperativo se baseia em comandos sequenciais que modificam o estado do programa. Ele descreve **como** alcançar um objetivo, utilizando variáveis, loops e estruturas de controle de fluxo. Linguagens como **C, Java e Python** são exemplos de linguagens imperativas.

## Paradigma Declarativo
O paradigma declarativo foca no **o que** deve ser feito, sem especificar os passos exatos para alcançar esse resultado. O programador descreve as relações entre os dados, e o motor da linguagem determina como resolver o problema. Linguagens como **SQL, Prolog e Haskell** pertencem a esse paradigma.

---

## Comparação entre Java (Imperativo) e Prolog (Declarativo)
Vamos comparar a solução de um problema simples: verificar se um número pertence a uma lista.

### Código em Java (Paradigma Imperativo)
```java
import java.util.Arrays;

public class BuscaNumero {
    public static boolean pertence(int num, int[] lista) {
        for (int elemento : lista) {
            if (elemento == num) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5};
        System.out.println(pertence(3, lista)); // true
        System.out.println(pertence(6, lista)); // false
    }
}
```
**Explicação:**
- O código percorre a lista com um loop `for`.
- Compara cada elemento ao número desejado.
- Se encontrar, retorna `true`; caso contrário, `false`.

### Código em Prolog (Paradigma Declarativo)
```prolog
pertence(X, [X|_]).
pertence(X, [_|T]) :- pertence(X, T).

% Testes
?- pertence(3, [1, 2, 3, 4, 5]). % true
?- pertence(6, [1, 2, 3, 4, 5]). % false
```
**Explicação:**
- A primeira cláusula indica que `X` pertence à lista se for o primeiro elemento.
- A segunda cláusula usa **recursão**, verificando se `X` pertence ao restante da lista (`T`).
- O interpretador do Prolog executa a busca automaticamente, sem um loop explícito.

## Conclusão
Enquanto Java exige a implementação manual do controle de fluxo e iteração, Prolog permite descrever a relação entre os elementos e deixa a resolução para o motor lógico. Isso ilustra bem a diferença entre os paradigmas: o **imperativo** detalha os passos para resolver o problema, enquanto o **declarativo** apenas define as regras e deixa a execução para a linguagem.
