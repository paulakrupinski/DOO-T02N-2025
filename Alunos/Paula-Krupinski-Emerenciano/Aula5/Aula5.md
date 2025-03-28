# Paradigmas de Programação

Paradigmas de programação são modelos ou estilos que definem a maneira como um programa deve ser escrito e estruturado. Eles estabelecem regras e princípios que guiam a organização do código, a forma como os dados são manipulados e como as instruções são executadas.

## Paradigma Imperativo

O paradigma imperativo determina que as instruções passadas ao computador devem especificar o passo a passo das ações que serão executadas. Esse paradigma é baseado no conceito de estado mutável, onde variáveis armazenam valores que podem ser modificados ao longo da execução do programa. A programação imperativa se assemelha à maneira como descrevemos tarefas no dia a dia, detalhando cada etapa necessária para atingir um objetivo final.

Esse paradigma surgiu com as primeiras linguagens de programação, como Assembly e Fortran, e influenciou muitas linguagens modernas, como C, Java e Python.

### Principais Características:

- Uso de variáveis para armazenar dados e modificá-los ao longo da execução.
- Uso de estruturas de controle como loops (for, while) e condicionais (if, switch).
- O programador define exatamente como o programa deve executar as tarefas.
- O código é geralmente mais explícito, pois detalha cada passo necessário para resolver um problema.

## Paradigma Declarativo

O paradigma declarativo determina que as instruções passadas ao computador devem especificar o que precisa ser feito, em vez de descrever como isso deve ser realizado. Esse paradigma busca minimizar o uso de variáveis mutáveis e enfatiza a descrição do problema de forma mais abstrata.

Diferente do paradigma imperativo, onde há uma sequência detalhada de passos, na programação declarativa o programador foca na lógica do problema, deixando para a linguagem de programação ou framework o trabalho de definir a melhor forma de executá-lo.

Linguagens que seguem esse paradigma incluem SQL, Prolog, Lisp, Haskell e até mesmo abordagens funcionais em Python e JavaScript.

### Principais Características:
- Foco no resultado desejado e não no processo para alcançá-lo.
- Uso de funções puras (sem efeitos colaterais) e imutabilidade em linguagens funcionais.
- Maior facilidade na paralelização e otimização do código.
- O código tende a ser mais conciso e descritivo.

Um exemplo comum de programação declarativa é o uso de SQL, onde escrevemos "o que" queremos buscar no banco de dados:

```sql
SELECT nome, idade FROM usuarios WHERE idade > 18;
```

### Comparação entre os Paradigmas

| Característica           | Paradigma Imperativo    | Paradigma Declarativo  |
|--------------------------|--------------------------|-------------------------|
| **Abordagem**            | Explicita o "como" fazer | Explicita "o que" precisa ser feito |
| **Uso de variáveis**     | Geralmente mutáveis      | Prefere evitar mutabilidade |
| **Controle de fluxo**    | Uso de loops e condicionais | Usa funções e expressões matemáticas |
| **Facilidade** | Mais difícil  | Mais fácil |
| **Exemplos de Linguagens** | C, Java, Python (procedural) | Haskell, SQL, Prolog, Python (funcional) |


### Exemplo Imperativo (Java)

```java
public class Main {
    static int somar(int a, int b) {
        return a + b; // Retorna a soma de a e b
    }

    public static void main(String[] args) {
        System.out.println(somar(3, 7)); // Testa com 3 e 7
    }
}
```

- Saída: **10**

**Explicação:**

- Criamos uma função somar(int a, int b), que retorna a + b.

- No main, chamamos a função com 3 e 7 e imprimimos o resultado.

### Exemplo Declarativo (Prolog)

```
soma(A, B, S) :- S is A + B.
?- soma(3, 7, X)
```

 - Saída: X = **10**

**Explicação:**

- Criamos uma regra lógica onde S é a soma de A e B.

- Ao perguntar ?- soma(3, 7, X), o Prolog retorna X = 10.


