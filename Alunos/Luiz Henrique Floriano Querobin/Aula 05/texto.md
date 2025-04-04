# Paradigmas de Programação
## Imperativo
- Baseado em instruções sequenciais
- Manipulação explícita de estados e variáveis
- Uso de estruturas de controle (loops, condicionais)
- Estado mutável e mudanças de estado visíveis

### Liguagens Imperativas
- C
- JAVA
- Python

### Exemplo de Código

```java
public class SomaImperativa {
    public static void main(String[] args) {
        int soma = 0;
        for (int i = 1; i <= 5; i++) {
            soma += i;
        }
        System.out.println("Soma: " + soma);
    }
}
```
1. O código diz explicitamente como realizar a soma.
2. Ele usa um loop for para iterar de 1 a 5.
3. A variável soma é mutável e seu valor muda a cada iteração.
4. Segue o paradigma imperativo, pois manipula diretamente o estado do programa.

## Declarativo
- Especifica o resultado desejado sem descrever o passo a passo
- Reduz ou elimina estados mutáveis
- Foca em expressões matemáticas e regras de transformação de dados
- Maior abstração comparado ao imperativo

### Linguages Declarativas
- SQL
- Prolog
- Haskell

### Exemplo de Código
```prolog
soma(0, 0).
soma(N, S) :- 
    N > 0, 
    N1 is N - 1, 
    soma(N1, S1),
    S is S1 + N.
```
#### Consulta para calcular a soma de 1 a 5:
```prolog
?- soma(5, S).
S = 15.
```

1. O código não descreve como somar passo a passo, apenas define a relação matemática entre N e S.
2. Ele usa recursão em vez de loops para calcular a soma.
3. soma/2 é um fato e uma regra que define a soma de N números.
4. O Prolog encontra a resposta por inferência, sem modificar estados de variáveis.
5. Segue o paradigma declarativo, pois descreve o que queremos e não como calcular diretamente.
