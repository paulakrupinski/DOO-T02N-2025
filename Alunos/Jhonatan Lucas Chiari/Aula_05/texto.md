# Markdown e Paradigmas da Programação

## **Markdown**
Markdown é uma **linguagem de marcação** utilizada para formatar texto na internet sem a necessidade de páginas web. Ele permite a criação de documentos estruturados com cabeçalhos, listas, negrito, itálico e outros elementos de formatação de maneira simples e intuitiva.

---

## **Paradigmas da Programação**
Paradigmas de programação são **maneiras de estruturar o pensamento** ao escrever código. Eles representam um conjunto de regras, princípios e conceitos que determinam como um programa é escrito e organizado.

Cada paradigma define **o estilo de escrita e organização do código** e influencia diretamente como um desenvolvedor modela e resolve problemas.

### **Abordagens de Paradigmas**

1. **Imperativo** - Baseado em comandos sequenciais que indicam exatamente o que deve ser feito.
   - **Programação Estruturada**: Utiliza módulos, pacotes, estruturas de controle e laços de repetição (ex.: `if`, `else`, `for`).
   - **Programação Procedural**: Baseada em chamadas de procedimentos (funções), organizando o código em etapas lógicas.

2. **Funcional** - Baseia-se no princípio de que tudo são funções.

3. **Lógica** - Define regras e permite que o computador processe essas regras logicamente.
   - Linguagens como **Prolog** e **Datalog** trabalham com declarações de fatos e regras.

4. **Declarativo** - Foca na **lógica e no resultado**, deixando a execução detalhada para o computador.

### **Exemplo de Abordagem Imperativa**
Criar um algoritmo para **fazer chá** envolve um conjunto de passos a serem seguidos, como:
1. Esquentar a água
2. Colocar o chá
3. Aguardar um tempo
4. Servir

---

## **Programação Orientada a Objetos (POO)**
A **POO** modela sistemas baseando-se em **objetos** que possuem propriedades e comportamentos. Isso permite **encapsulamento, reutilização de código e melhor organização**.

### **Pilares da POO**
- **Herança**: Criação de novas classes baseadas em classes existentes.
- **Polimorfismo**: Capacidade de um objeto assumir múltiplas formas.
- **Encapsulamento**: Controle de acesso aos métodos e atributos (`private`, `public`, `getters`, `setters`).
- **Abstração**: Representação dos conceitos essenciais do mundo real.

### **Benefícios da POO**
- Reutilização de código
- Modularidade
- Flexibilidade e escalabilidade
- Melhor organização e coesão

---

## **Comparação entre Java e Prolog - Sistema de Parentesco**

### Vamos comparar o mesmo código, escrito em duas linguagens distintas (`Java` e `prolog`):

## Java:
```java

import java.util.ArrayList;
import java.util.List;

class Pessoa {
    String nome;
    List<Pessoa> filhos;

    public Pessoa(String nome) {
        this.nome = nome;
        this.filhos = new ArrayList<>();
    }

    public void adicionarFilho(Pessoa filho) {
        this.filhos.add(filho);
    }

    public boolean ehAncestral(Pessoa descendente) {
        if (this.filhos.contains(descendente)) {
            return true;
        }
        for (Pessoa filho : filhos) {
            if (filho.ehAncestral(descendente)) {
                return true;
            }
        }
        return false;
    }
}

public class Parentesco {
    public static void main(String[] args) {
        Pessoa avo = new Pessoa("João");
        Pessoa pai = new Pessoa("Carlos");
        Pessoa filho = new Pessoa("Lucas");

        avo.adicionarFilho(pai);
        pai.adicionarFilho(filho);

        System.out.println("João é ancestral de Lucas? " + avo.ehAncestral(filho));
    }
}
````
## Prolog:
````prolog
% Definição de relacionamentos
pai(joao, carlos).
pai(carlos, lucas).

% Regra para definir ancestralidade
ancestral(X, Y) :- pai(X, Y).
ancestral(X, Y) :- pai(X, Z), ancestral(Z, Y).

% Consulta: João é ancestral de Lucas?
% ?- ancestral(joao, lucas).
% Resposta: true.
````

### **1. Definição de Relacionamentos**

#### **Java:**
```java
class Pessoa {
    String nome;
    List<Pessoa> filhos;
    
    public Pessoa(String nome) {
        this.nome = nome;
        this.filhos = new ArrayList<>();
    }

    public void adicionarFilho(Pessoa filho) {
        this.filhos.add(filho);
    }
}

```
- Criamos uma classe Pessoa com nome e uma lista de filhos.

- O método adicionarFilho() adiciona um filho à lista.

### **Prolog:**

```prolog

pai(joao, carlos).
pai(carlos, lucas).

```
### Em Prolog, declaramos fatos diretamente:

-João é pai de Carlos.

-Carlos é pai de Lucas.

## 2. Lógica para Verificar Ancestralidade
## Java:
````Java
public boolean ehAncestral(Pessoa descendente) {
    if (this.filhos.contains(descendente)) {
        return true;
    }
    for (Pessoa filho : filhos) {
        if (filho.ehAncestral(descendente)) {
            return true;
        }
    }
    return false;
}
````
- Verifica recursivamente se uma pessoa é ancestral de outra.
## Prolog:
```Prolog

ancestral(X, Y) :- pai(X, Y).
ancestral(X, Y) :- pai(X, Z), ancestral(Z, Y).

```
- Regra recursiva: Se X é pai de Z e Z é ancestral de Y, então X também é ancestral de Y.

## 3. Consulta e Execução
## Java
````java
public class Parentesco {
    public static void main(String[] args) {
        Pessoa avo = new Pessoa("João");
        Pessoa pai = new Pessoa("Carlos");
        Pessoa filho = new Pessoa("Lucas");

        avo.adicionarFilho(pai);
        pai.adicionarFilho(filho);

        System.out.println("João é ancestral de Lucas? " + avo.ehAncestral(filho));
    }
}
````
- Criamos objetos manualmente e usamos ehAncestral() para verificar ancestralidade.

## Prolog
```prolog

?- ancestral(joao, lucas).
```
- Apenas fazemos a consulta, e o Prolog verifica automaticamente se a relação existe.

# Conclusão
- O **Java** exige uma implementação manual das estruturas de dados e da lógica de ancestralidade.

- Já o **Prolog** permite resolver o problema de forma mais declarativa, focando apenas em definir fatos e regras.

### Essa comparação mostra que o Java requer um controle explícito do fluxo, enquanto o Prolog usa inferência lógica, tornando a solução mais abstrata e enxuta.