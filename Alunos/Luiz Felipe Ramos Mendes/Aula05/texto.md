# Paradigmas de Programação: Imperativo e Declarativo

Introdução
Os estilos de programação mostram formas distintas de escrever código maluco. Dois dos principais são o imperativo e o declarativo. Cada um traz suas vantagens e modos de solucionar situações.


O estilo imperativo é aquele onde a gente narra passo a passo o que o programa deve realizar. O foco está no "como fazer".

Exemplo código em Java:

```java
public class Soma {
public static void main(String[] args) {
int a = 5;
int b = 10;
int resultado = a + b;
System.out.println("A soma é: " + resultado);
}
}

# Como funciona?
- Primeiro, declara as variaveis  `a` e `b`
- Depois, depois soma os 2 valores e guarda na variavel  `resultado`
- No final, mostra o resultado na tela 

Paradigma Declarativo
O paradigma declarativo é mais sobre o "o que fazer" . A ideia é descrever a lógica do problema sem se preocupar tanto com o passo a passo

Exemplo de código em Prolog:

```prolog
soma(A, B, Resultado) :- Resultado é A + B.

?- soma(5, 10, R).
```
# Como funciona?
- Aqui, só define a relação: `Resultado` é a soma de `A` e `B`.
- Quando é perguntado `?- soma(5, 10, R).`, o Prolog entende e retorna `R = 15`.
- Não precisa dizer como calcular, só declarar o que queremos.

# Comparação entre os Paradigmas de Programação

- **Controle do Fluxo**:
   - No **imperativo**, você diz exatamente como as coisas vão acontecer, passo a passo. O código é mais detalhado.
   - No **declarativo**, você só fala o que quer que aconteça e deixa o sistema se virar para fazer o resto. Não precisa ficar dizendo como cada coisa deve ser feita.

- **Alteração de Estado**:
   - No **imperativo**, você mexe diretamente nas variáveis e altera o estado do programa. Você tem total controle de tudo que muda.
   - No **declarativo**, Ao vez de ficar alterando variáveis, você define regras e relações, e o sistema resolve como chegar à solução.

- **Enfoque**:
   - O **imperativo** foca no "como" fazer as coisas. Você define o passo a passo de tudo.
   - O **declarativo** foca no "o que" deve ser feito, sem se preocupar tanto com como vai ser feito.


