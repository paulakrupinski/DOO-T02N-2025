```markdown
# Paradigmas de Programação: Imperativo vs Declarativo

Os paradigmas de programação definem diferentes abordagens para a construção de software. Dois paradigmas amplamente utilizados são:

- **Paradigma Imperativo**: Baseia-se em comandos sequenciais que modificam o estado do programa. Linguagens como Java e C são exemplos desse paradigma.
- **Paradigma Declarativo**: Foca no que deve ser feito, em vez de como fazer. Prolog e SQL são exemplos de linguagens que seguem essa abordagem.

## Comparação entre Java (Imperativo) e Prolog (Declarativo)

Abaixo, comparamos dois trechos de código que verificam se um número é par.

### Exemplo em Java (Imperativo)

```java
public class Paridade {
    public static boolean Par(int numero) {
        return numero % 2 == 0;
    }

    public static void main(String[] args) {
        int numero = 4;
        System.out.println("O número " + numero + " é par? " + Par(numero));
    }
}
```

#### Como funciona?
1. A função `Par` recebe um número inteiro.
2. O operador `%` é usado para verificar se há resto na divisão por 2.
3. Se o resto for zero, o número é par, retornando `true`, caso contrário, retorna `false`.
4. O método `main` executa o código chamando a função `Par` e imprimindo o resultado.

### Exemplo em Prolog (Declarativo)

```prolog
par(X) :- X mod 2 =:= 0.

?- par(4).
```

#### Como funciona?
1. A regra `par(X)` define que um número é par se `X mod 2 =:= 0`.
2. O programa não executa instruções passo a passo como no Java; ele apenas verifica se a consulta `par(4)` é verdadeira.
3. O motor de inferência do Prolog avalia a condição e responde se a afirmação é válida.

## Conclusão

O código em Java segue um modelo **imperativo**, onde especificamos cada passo necessário para determinar se um número é par. Já o código em Prolog segue um modelo **declarativo**, onde simplesmente definimos a regra e deixamos que o sistema determine a resposta. Enquanto o paradigma imperativo foca no **como fazer**, o paradigma declarativo foca no **o que deve ser feito**.
```
