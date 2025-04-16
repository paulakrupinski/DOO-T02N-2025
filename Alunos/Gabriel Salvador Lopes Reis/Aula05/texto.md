# Paradigmas de programação

## Oque é um paradigma

No nosso cotidiano entendemos que paradigmas são "formas" de pensar ou como estruturamos nosso pensamento. Quando 
trazemos esse termo para a área de programação nos referimos a forma na qual estruturamos nosso código, ter esses 
paradigmas definidos facilitam a vida do programador já que ele ira apenas se preocupar com a lógica do seu problema 
sem precisar definir ele mesmo a estrutura do código.

## Exemplos de paradigmas

1. **Programação Imperativa**
   1. **Programação Orientada a Objetos**
   2. **Programação Estruturada**
   3. **Programação Procedural**
<br><br>
2. **Programação Declarativa**
   1. **Programação Funcional**
   2. **Programação Lógica**

## Comparação entre paradigmas

Para entender mais sobre paradigmas vou comparar as duas abordagems e identificar suas características.

### Programação Imperativa

Na programação imperativa, como o próprio nome já diz você dita oque deve ser feito, com intruções imperativas que 
ditam o código passo a passo.

*Segue o exemplo de um simlpes código em Java*

```Java
public class EvenOdd {
   // Método para checar se o número é par
   public static boolean Par(int n) {
      return n % 2 == 0;
   }

   // Método para checar se o número é impar
   public static boolean Impar(int n) {
      return n % 2 != 0;
   }

   public static void main(String[] args) {
      int number = 7;

      if (isEven(number)) {
         System.out.println(number + " é par.");
      } else {
         System.out.println(number + " é impar.");
      }
   }
}
```


### Programação declarativa

Diferentemente da programação imperativa a programação declarativa não parte do príncipio de impor e descrever como 
cada intrução deve ser executada, nela declaramos regras e partir dessas regras o cógido toma *"decisões"*.

*A baixo segue um outro exemplo do memso código mostrado a cima, dessa vez em prolog uma linguagem baseada em 
programação declarativa*

``` Prolog
% Regra para verificar se um número é par
par(N) :- 
    N mod 2 =:= 0.

% Regra para verificar se um número é ímpar
impar(N) :- 
    N mod 2 =\= 0.

% Exemplos de consultas:
% ?- par(4).
% Resposta esperada: true.
% ?- impar(7).
% Resposta esperada: true.
```