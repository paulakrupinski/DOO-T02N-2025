# **Paradigmas de Programação: Imperativo vs Declarativo**

## **Programação Imperativa**

A programação imperativa é baseada em instruções sequenciais que modificam o estado do programa. Esse paradigma se aproxima da forma como os computadores executam operações, com comandos explícitos sobre o que deve ser feito e como deve ser feito. Linguagens como **Java, C e Python** são exemplos de linguagens imperativas.

## **Programação Declarativa**

Já a programação declarativa se concentra no *o que* deve ser feito, em vez de *como* deve ser feito. O foco está na lógica do problema, e não na sequência de instruções. Linguagens como **Prolog, SQL e Haskell** seguem esse paradigma.

---

## **Comparação entre Java (Imperativo) e Prolog (Declarativo)**

### **Exemplo de Código: Fatorial**

#### **Java (Imperativo)**

public class Fatorial {  
    public static int calcularFatorial(int n) {  
        int resultado \= 1;  
        for (int i \= 2; i \<= n; i++) {  
            resultado \*= i;  
        }  
        return resultado;  
    }

    public static void main(String\[\] args) {  
        System.out.println(calcularFatorial(5)); // Saída: 120  
    }

}

**Explicação:**  
No código Java, temos um **laço de repetição (\*\***for***\*\****\*\*\*\*)\*\* que multiplica os números sucessivamente, modificando uma variável de estado (resultado). O fluxo de execução é controlado de forma explícita.

#### **Prolog (Declarativo)**

fatorial(0,1).  
fatorial(N, Resultado) :-  
    N \> 0,  
    N1 is N \- 1,  
    fatorial(N1, R1),

    Resultado is N \* R1.

**Explicação:**  
Em Prolog, o cálculo do fatorial é definido **recursivamente**. Não há necessidade de laços ou manipulação explícita de estado. O interpretador resolve a consulta de forma declarativa, buscando uma solução para fatorial(N, Resultado) com base nas regras fornecidas.

---

## **Conclusão**

A abordagem imperativa, exemplificada pelo Java, requer um controle detalhado do fluxo do programa e das variáveis de estado. Já a abordagem declarativa, como em Prolog, descreve relações e regras, permitindo que o próprio sistema encontre a solução. Cada paradigma tem suas vantagens e é adequado para diferentes contextos.

