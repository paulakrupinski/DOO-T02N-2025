# Paradigmas de Programação: Imperativo vs Declarativo

## Introdução
Os paradigmas de programação definem diferentes formas de estruturar e resolver problemas computacionais. Dois dos mais conhecidos são:

- **Paradigma Imperativo**: Baseia-se em instruções passo a passo que modificam o estado do programa. É a abordagem usada por linguagens como C, Java e Python.
- **Paradigma Declarativo**: Foca mais na descrição do que precisa ser feito, deixando os detalhes de execução para o sistema. Exemplos incluem Prolog e SQL.

## Comparação entre Java (Imperativo) e Prolog (Declarativo)

A seguir, dois trechos de código resolvem o mesmo problema: verificar se um número está presente em uma lista.

### **Código em Java (Paradigma Imperativo)**
```java
public class BuscaElemento {
    public static boolean pertence(int[] lista, int numero) {
        for (int elemento : lista) {
            if (elemento == numero) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] lista = {1, 2, 3, 4, 5};
        System.out.println(pertence(lista, 3)); // true
    }
}
```
**Como funciona?**
- O código percorre a lista com um laço `for`, comparando cada elemento com o número buscado.
- Se encontrar, retorna `true`. Caso contrário, retorna `false`.
- O fluxo de execução é explícito: o programador define exatamente o que acontece a cada etapa.

### **Código em Prolog (Paradigma Declarativo)**
```prolog
pertence(X, [X|_]).
pertence(X, [_|T]) :- pertence(X, T).

?- pertence(3, [1,2,3,4,5]). % true
```
**Como funciona?**
- A primeira regra diz que um número pertence à lista se for o primeiro elemento (`X|_`).
- A segunda regra verifica recursivamente os elementos restantes (`[_|T]`).
- Quando fazemos a consulta `?- pertence(3, [1,2,3,4,5]).`, o Prolog responde `true` automaticamente, sem precisarmos definir loops.

## Conclusão
- No **Java**, o programador precisa controlar o fluxo de execução detalhadamente.
- No **Prolog**, basta definir as regras e o sistema encontra a solução sozinho.
- O paradigma imperativo é ótimo para manipular estados e ter controle direto sobre o programa.
- O paradigma declarativo se destaca em problemas baseados em lógica e regras.

Cada abordagem tem seus pontos fortes e fracos. Escolher a melhor depende do problema que você quer resolver!
