# Paradigma de Programação 

Paradigma de Programação refere-se a como o código é estruturado seguindo um conjunto de regras ou principíos já estabelecidos. Os Paradigmas de Programação são dividos em dois tópicos são eles : Imperativo e Declarativo.

Paradigma imperativo foca em como o programa deve executar a tarefa, por meio de instruções claras e objetivas ele define um passo a passo, afim de obter um fluxo de controle. Como exemplo de uma linguagem de programação que faz uso desse paradigma temos: o Java que possui o paradigma imperativo Orientado a Objetos, utilizado para desenvolver aplicações, como jogos, software empresarial, aplicativos móveis e da web. 

Já o paradigma declarativo preza apenas naquilo que deve ser feito, sem especificar instruções ou comando para a execução, seu foco e apenas no resultado, um exemplo de linguagem de programação com o paradigma declarativo do tipo lógico é o Prolog, usado para a tradução de linguagem natural, lógica e computação numérica e simbólica.

Uma aplicação prática dos paradigmas de programação em nosso cotidiano seria a de uma receita de bolo. O paradigma imperativo descreve de uma forma explícita do que deve ser feito e como deve ser feito com instruções passo a passo para possamos fazer o bolo, já o paradigma declarativo busca apenas alcançar o objetivo e foca somente na lógica para execução sem considerar o fluxo de trabalho.

### Comparação de um código Prolog e Java de uma árvore familiar

Este código em prolog refere-se a criação de uma árvore familiar onde nele definimos as fatos sobre os gêneros, sobre os pais e seus filhos alem de definirmos as regras para sabermos a resposta sobre uma proposição (questão) exemplo: ?- father(X, mike). A resposta seria X = john

``` Prolog
% Definindo os fatos sobre os gêneros
male(john).
male(mike).
male(alex).
male(james).

female(lisa).
female(susan).
female(mary).
female(emily).

% Definindo fatos sobre os pais
parent(john, mike).
parent(john, susan).
parent(lisa, mike).
parent(lisa, susan).
parent(mike, alex).
parent(mike, emily).
parent(mary, alex).
parent(mary, emily).

% Definindo as Regras
father(X, Y) :- male(X), parent(X, Y).
mother(X, Y) :- female(X), parent(X, Y).

sibling(X, Y) :- parent(P, X), parent(P, Y), X \= Y.
brother(X, Y) :- sibling(X, Y), male(X).
sister(X, Y) :- sibling(X, Y), female(X).

grandparent(X, Y) :- parent(X, Z), parent(Z, Y).
grandfather(X, Y) :- grandparent(X, Y), male(X).
grandmother(X, Y) :- grandparent(X, Y), female(X).

ancestor(X, Y) :- parent(X, Y).
ancestor(X, Y) :- parent(X, Z), ancestor(Z, Y).

% Resposta para a questão seria: john
?- father(X, mike) 
```
Este código abaixo em java é uma maneira de criar uma árvore familiar, no entanto como o java é de paradigma imperativo Orientado a Objetos, logo devemos criar as classes Person, Family Tree para que possamos definir as regras e estrutura com as instruções passo a passo, para que possamos alcançar nosso objetivo.

``` Java
import java.util.*;

class Person {
    private String name;
    private String gender;
    private List<Person> parents;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    public boolean isMale() {
        return gender.equalsIgnoreCase("male");
    }

    public boolean isFemale() {
        return gender.equalsIgnoreCase("female");
    }
}

class FamilyTree {
    private Map<String, Person> members = new HashMap<>();

    public void addPerson(String name, String gender) {
        members.putIfAbsent(name, new Person(name, gender));
    }

    public void addParentChildRelation(String parentName, String childName) {
        Person parent = members.get(parentName);
        Person child = members.get(childName);
        if (parent != null && child != null) {
            child.addParent(parent);
        }
    }

    public Person getPerson(String name) {
        return member  s.get(name);
    }

    public String findFather(String childName) {
        Person child = members.get(childName);
        if (child != null) {
            for (Person parent : child.getParents()) {
                if (parent.isMale()) {
                    return parent.getName();
                }
            }
        }
        return "Unknown";
    }

    public String findMother(String childName) {
        Person child = members.get(childName);
        if (child != null) {
            for (Person parent : child.getParents()) {
                if (parent.isFemale()) {
                    return parent.getName();
                }
            }
        }
        return "Unknown";
    }

    public List<String> findSiblings(String personName) {
        Person person = members.get(personName);
        List<String> siblings = new ArrayList<>();
        if (person != null) {
            for (Person parent : person.getParents()) {
                for (Person child : members.values()) {
                    if (!child.getName().equals(personName) && child.getParents().contains(parent)) {
                        siblings.add(child.getName());
                    }
                }
            }
        }
        return siblings;
    }

    public List<String> findGrandparents(String personName) {
        Person person = members.get(personName);
        List<String> grandparents = new ArrayList<>();
        if (person != null) {
            for (Person parent : person.getParents()) {
                for (Person grandparent : parent.getParents()) {
                    grandparents.add(grandparent.getName());
                }
            }
        }
        return grandparents;
    }
}

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Adicionado membros a árvore Familiar
        familyTree.addPerson("John", "male");
        familyTree.addPerson("Lisa", "female");
        familyTree.addPerson("Mike", "male");
        familyTree.addPerson("Susan", "female");
        familyTree.addPerson("Mary", "female");
        familyTree.addPerson("Alex", "male");
        familyTree.addPerson("Emily", "female");

        // Definido as relações de Pai-Fliho
        familyTree.addParentChildRelation("John", "Mike");
        familyTree.addParentChildRelation("Lisa", "Mike");
        familyTree.addParentChildRelation("John", "Susan");
        familyTree.addParentChildRelation("Lisa", "Susan");
        familyTree.addParentChildRelation("Mike", "Alex");
        familyTree.addParentChildRelation("Mike", "Emily");
        familyTree.addParentChildRelation("Mary", "Alex");
        familyTree.addParentChildRelation("Mary", "Emily");

        // Pergunta: Quem é o pai de Mike Resposta: John
        System.out.println("Father of Mike: " + familyTree.findFather("Mike"));
    }
}
```
Por fim realizamos a mesma pergunta feita em prolog, agora no Java para descobrirmos quem é o pai de Mike.

