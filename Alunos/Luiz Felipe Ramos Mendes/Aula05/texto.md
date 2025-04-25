### Paradigmas de Programação: Imperativo e Declarativo

## Introdução
Na programação, dois paradigmas amplamente utilizados são o **imperativo** e o **declarativo**. 
**Imperativo**: Foca no "como" fazer as coisas, ou seja, fazendo o passo a passo
**Declarativo**: Foca no "o que" deve ser feito, deixando que o sistema descubra como resolver o problema.



## Paradigma Imperativo (Java)
No paradigma imperativo, o código segue uma sequência de comandos bem definida.


### Exemplo de código em Java:

````java
public class Soma {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int resultado = a + b;
        System.out.println("A soma é: " + resultado);
    }
}
````

### Como funciona?
**1**. Declaramos as variáveis a e b e atribuimos valores a elas.
**2**. Somamos os valores e armazenamos em resultado.
**3**. Exibimos o resultado na tela.

Aqui, o programador tem controle total sobre cada passo, dizendo como a soma deve ser feita.

## Paradigma Declarativo (Prolog)

No paradigma declarativo, apenas dizemos o que queremos, e o sistema resolve o resto.

### Exemplo de código em Prolog:

````prolog

soma(A, B, Resultado) :- Resultado is A + B.

?- soma(5, 10, R).
````

### Como funciona?
**1**.Definimos que Resultado é a soma de A e B.
**2**.Quando perguntamos ?- soma(5, 10, R)., o Prolog responde que R = 15.

Aqui, não dizemos como calcular, apenas declaramos a relação, e o sistema resolve.


## Comparação entre os Paradigmas

### 1. Controle do Fluxo
- **Imperativo (Java)**: O programador define passo a passo como a tarefa será executada.
.
- **Declarativo (Prolog)**: O programador diz o que quer, e o sistema decide como resolver.

### 2. Alteração de Estado
- **Imperativo (Java)**: Manipula diretamente variáveis e o estado do programa.
- **Declarativo (Prolog)**: Não altera o estado diretamente; apenas define relações entre os valores.

### 3. Enfoque
- **Imperativo**: Explica "como" o processo deve acontecer.
- **Declarativo**: Explica "o que" precisa ser feito, deixando os detalhes para o sistema.
