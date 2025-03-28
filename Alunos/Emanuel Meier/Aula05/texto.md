# Paradigmas de Programação: Markdown, POO, Imperativo e Declarativo

## Introdução
Na aula teórica do dia 20/03/2025, foram abordados diversos paradigmas de programação, incluindo **Markdown**, **Programação Orientada a Objetos (POO)**, **Abordagem Imperativa** e **Abordagem Declarativa**. Cada um desses paradigmas apresenta conceitos distintos que influenciam a forma como os programas são escritos e estruturados.

## Markdown
Markdown é uma linguagem de marcação leve usada para formatar textos de forma simples e intuitiva. Ela é amplamente utilizada em documentação, blogs e repositórios de código.

### Exemplo de Markdown:
```markdown
# Título Principal
## Subtítulo
- Item 1
- Item 2
- **Texto em negrito**
- *Texto em itálico*
```
Esse formato permite a criação de documentos bem estruturados sem necessidade de editores complexos.

## Programação Orientada a Objetos (POO)
A **Programação Orientada a Objetos (POO)** é um paradigma baseado no conceito de objetos e classes. Seu principal objetivo é modelar o software de forma mais próxima à realidade.

### Princípios da POO:
- **Encapsulamento**: Protege os dados dentro de uma classe.
- **Herança**: Permite que uma classe reutilize atributos e métodos de outra.
- **Polimorfismo**: Capacidade de uma função se comportar de diferentes maneiras.

### Exemplo em Java:
```java
class Veiculo {
    void mover() {
        System.out.println("O veículo está se movendo");
    }
}

class Carro extends Veiculo {
    void mover() {
        System.out.println("O carro está andando");
    }
}
```
Neste exemplo, a classe `Carro` herda de `Veiculo` e sobrescreve o método `mover()`.

## Abordagem Imperativa
O paradigma **imperativo** foca em **como** o problema deve ser resolvido, utilizando sequências de comandos e manipulação de estado.

### Exemplo em Java:
```java
public class Soma {
    public static int somar(int a, int b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        System.out.println(somar(5, 3));
    }
}
```
Esse código segue um fluxo estruturado, determinando exatamente como a soma será feita.

## Abordagem Declarativa
Já a abordagem **declarativa** foca **no que** deve ser feito, sem detalhar o fluxo de controle.

### Exemplo em Prolog:
```prolog
soma(A, B, Resultado) :- Resultado is A + B.
```
Aqui, definimos a relação `soma/3` sem especificar um fluxo de execução explícito.

## Comparação entre Imperativo e Declarativo
| Característica    | Imperativo (Java) | Declarativo (Prolog) |
|------------------|------------------|----------------------|
| Estilo           | Sequencial        | Baseado em regras |
| Controle de fluxo | Explicito        | Implícito         |
| Mutabilidade     | Variáveis mutáveis | Predicados fixos  |
| Foco             | Como fazer        | O que fazer       |



