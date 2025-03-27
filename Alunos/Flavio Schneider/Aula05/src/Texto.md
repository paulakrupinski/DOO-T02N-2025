# Comparação entre os Paradigmas Imperativo e Declarativo


## O que são Paradigmas?


**Paradigmas da Programação** são diferentes formas de como lidar com um problema na programação. Cada paradigma tem suas próprias regras de como organizar o código, ou seja, um paradigma determina como escrever o código e organizar a lógica do problema. Irei citar dois tipos de paradigmas e darei exemplos práticos deles usando código.


1. ### Paradigma Imperativo
- **Descrição:** É mais focado em como realizar a tarefa, ou seja, o programador deve dar uma sequência de instruções e comandos para a máquina para chegar no resultado esperado.


- **Exemplos:** Java, C, Python.


- **Exemplo de código em Java:**


 ```java
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Set;


 public class Ancestral {
    private static HashMap<String, String> pai = new HashMap<>();


    public static void adicionarRelacao(String filho, String paiNome) {
        pai.put(filho, paiNome);
    }


    public static boolean ehAncestral(String ancestral, String pessoa) {
        while (pai.containsKey(pessoa)) {
            if (pai.get(pessoa).equals(ancestral)) {
                return true;
            }
            pessoa = pai.get(pessoa);
        }
        return false;
    }


    public static void main(String[] args) {
        adicionarRelacao("Carlos", "Ana");
        adicionarRelacao("Ana", "João");


        System.out.println(ehAncestral("João", "Carlos")); // true
    }
 }
 ```


## Estrutura do Código

O código em **Java** implementa um sistema para verificar se uma pessoa é ancestral de outra. Ele utiliza um **HashMap** para armazenar relações de parentesco e um método para percorrer essas relações até encontrar um possível ancestral.
**Explicação:**


1. **Declaração de variáveis**


 ```java
 private static HashMap<String, String> pai = new HashMap<>();
 ```
- Aqui, criamos um *HashMap* chamado pai, que armazena a relação "pai-filho".


- Exemplo de como os dados são armazenados:


 ```java
 "Carlos" -> "Ana"
 "Ana" -> "João"
 ```
Isso significa que **Ana é mãe de Carlos e João é pai de Ana.**


2. **Método para Adicionar Relações de Parentesco**


 ```java
 public static void adicionarRelacao(String filho, String paiNome) {
    pai.put(filho, paiNome);
 }
 ```


- Esse método adiciona uma nova relação de parentesco ao *HashMap*.


- Ele recebe dois argumentos:
- *filho*: nome de pessoa que tem um pai.
- *paiNome*: nome do pai pessoa.


- Usa *pai.put(filho, paiNome)* para armazenar a relação.


3. **Método para Verificar se Alguém é Ancestral**


 ```java
 public static boolean ehAncestral(String ancestral, String pessoa) {
    while (pai.containsKey(pessoa)) {
        if (pai.get(pessoa).equals(ancestral)) {
            return true;
        }
        pessoa = pai.get(pessoa);
    }
    return false;
 }
 ```
- Esse método percorre os registros de pais no *HashMap*, subindo na árvore genealógica até encontrar o ancestral ou esgotar os registros.


- Ele recebe dois parâmetros:
- *ancestral*: Nome da pessoa que queremos verificar se é um ancestral.
- *pessoa*: Nome da pessoa cujo ancestral queremos encontrar.


- **Enquanto** *pessoa* estiver registrado no *HashMap, verificamos:
-  Se *pai.get(pessoa).equals(ancestral)*, significa que encontramos o ancestral e retornamos *true*.
- Caso contrário, subimos um nível na árvore, buscando o pai da pessoa atual.


4. **Método *main*: Testando a Lógica**


 ```java
 public static void main(String[] args) {
    adicionarRelacao("Carlos", "Ana");
    adicionarRelacao("Ana", "João");


    System.out.println(ehAncestral("João", "Carlos")); // true
 }
 ```
- Criamos duas relações:
1. **Carlos é filho de Ana**
2. **Ana é filha de João**


- Depois, verificamos se *João* é ancestral de *Carlos* e imprimimos o resultado.


2. ### Paradigma Declarativo


- **Descrição:** Aqui, o programador descreve o que deve ser feito, e não o passo a passo de como isso será feito. O foco está na lógica do problema e não nos detalhes de implementação.


- **Exemplo:** Prolog, SQL, Haskell.


- **Exemplo de código em Prolog:**


 ```prolog
 % Fatos: Relacionamento pai-filho
 pai(joao, ana).
 pai(ana, carlos).


 % Regra: Uma pessoa é ancestral se for pai direto ou se for pai de um ancestral
 ancestral(X, Y) :- pai(X, Y).
 ancestral(X, Y) :- pai(X, Z), ancestral(Z, Y).


 /* Consultas de exemplo:
 ?- ancestral(joao, carlos).  % Retorna true
 ?- ancestral(ana, joao).     % Retorna false
 */
 ```


## Estrutura do Código


Diferente da versão em Java, que precisa de **loops e estruturas condicionais**, o código em **Prolog** apenas **declara os fatos e regras** e permite que o interpretador resolva as consultas automaticamente.


1. **Declaração dos Fatos**


 ```prolog
 pai(joao, ana).
 pai(ana, carlos).
 ```


- Estes são **fatos**, ou seja, informações conhecidas sobre o domínio do problema.

- Indicam que **João é pai de Ana e Ana é mãe de Carlos.**


- O Prolog usa esses fatos para inferir relações de ancestralidade.


2. **Definição da Regra de Ancestralidade**


  ```prolog
  ancestral(X, Y) :- pai(X, Y).
  ```
- Aqui dizemos que **X é ancestral de Y se X for pai de Y.**


- Ou seja, **ancestralidade direta** (pai-filho imediato).


- Isso cobre casos como *pai(joao, ana)*, onde João é ancestral direto de Ana.


3. **Regra Recursiva para Encontrar Ancestralidade Indireta**


 ```prolog
 ancestral(X, Y) :- pai(X, Z), ancestral(Z, Y).
 ```


- Aqui estamos dizendo:
  **"X é ancestral de Y se X dor pai de Z e Z for ancestral de Y."**


- Isso permite encontrar **ancestrais mais distantes** atraves da **recursão**.


- Se João for pai de Ana e Ana for ancestral de Carlos, então João também é ancestral de Carlos.


4. **Como Usar e Interpretar as Consultas**


- Em Prolog, executamos consultas para verificar se alguém é ancestral de outra pessoa.


**Exemplo: João é ancestral de Carlos?


 ```prolog
 ?- ancestral(joao, carlos).
 ```


- O interpretador Prolog analisa os fatos e regras:

1. João é pai de Ana -> *pai(joao, ana)*.
2. Ana é mãe de Carlos → *pai(ana, carlos)*.
3. Como João é pai de Ana e Ana é ancestral de Carlos, **João também é ancestral de Carlos**.


- Resposta: *true*.
