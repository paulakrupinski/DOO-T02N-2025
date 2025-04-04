# Comparação entre Paradigmas de Programação: Imperativo vs. Declarativo

A aula teórica do dia 20/03/2025 abordou os principais paradigmas de programação, destacando os estilos imperativo e declarativo. Neste documento, serão discutidos os conceitos de cada paradigma, suas características e será realizada uma comparação prática entre dois trechos de código – um escrito em Java, representando o paradigma imperativo, e outro em Prolog, exemplificando o paradigma declarativo.

---

## Paradigma Imperativo

O paradigma imperativo é baseado em uma sequência de comandos que modificam o estado do programa. Nele, o programador define **como** a solução deve ser executada, detalhando cada passo necessário para atingir o objetivo. Esse estilo é frequentemente associado a linguagens como Java, C e Python. Entre as principais características estão:

- **Controle do fluxo:** Uso explícito de estruturas de repetição (loops), condicionais e manipulação direta de variáveis.
- **Estado mutável:** As variáveis podem ser alteradas ao longo da execução, refletindo mudanças no estado do sistema.
- **Procedimentos e funções:** O problema é dividido em sub-rotinas ou procedimentos que realizam tarefas específicas.

### Exemplo de Código em Java

```java
public class Exemplo {
    public static void main(String[] args) {
        int soma = 0;
        for (int i = 1; i <= 5; i++) {
            soma += i;
        }
        System.out.println("Soma dos números de 1 a 5: " + soma);
    }
}

Nesse exemplo, o programa executa um laço de repetição que soma os números de 1 a 5. O fluxo de execução é claro e sequencial, demonstrando a característica imperativa de especificar explicitamente cada passo do processamento.
Paradigma Declarativo

O paradigma declarativo, por sua vez, concentra-se no que deve ser resolvido, delegando ao sistema a responsabilidade de encontrar a melhor forma de realizar a tarefa. Linguagens como Prolog, SQL e Haskell exemplificam esse estilo. Suas características principais incluem:

    Abstração: O programador descreve relações e propriedades desejadas, sem detalhar a sequência de operações para alcançar o resultado.

    Menor ênfase no estado: Em geral, o estado mutável é minimizado, e a execução baseia-se em regras ou relações.

    Resolução de problemas via inferência: O mecanismo interno da linguagem utiliza motores de inferência para deduzir respostas a partir das regras definidas.

Exemplo de Código em Prolog

% Definindo fatos: números de 1 a 5
numero(1). 
numero(2).
numero(3).
numero(4).
numero(5).

% Regra para somar dois números
soma(0, []).
soma(S, [H|T]) :- soma(S1, T), S is H + S1.

% Consulta: calcular a soma de todos os números listados
?- findall(N, numero(N), Lista), soma(S, Lista).

No exemplo em Prolog, definem-se fatos e regras que descrevem o relacionamento entre os elementos. Ao fazer a consulta, o interpretador utiliza mecanismos de busca e unificação para determinar a soma dos números, sem que o programador precise controlar explicitamente cada iteração.
Análise Comparativa
Controle de Fluxo e Abstração

    Java (Imperativo):
    O controle de fluxo é explícito. O uso de um laço for e a manipulação direta da variável soma exemplificam o detalhamento do processo de cálculo, caracterizando o estilo imperativo.

    Prolog (Declarativo):
    O código não especifica um procedimento de iteração; em vez disso, define o que é um número e como deve ser calculada a soma através de regras lógicas. A consulta final delega ao interpretador a tarefa de buscar e aplicar as regras, enfatizando o foco no resultado e não no processo.

Gerenciamento de Estado

    Java:
    O estado do programa é alterado a cada iteração, onde a variável soma é atualizada. Esse gerenciamento explícito reflete a natureza imperativa da linguagem.

    Prolog:
    O paradigma declarativo evita o gerenciamento explícito de estado. Em Prolog, a lógica e as relações definidas são suficientes para que o sistema deduza o valor final sem a necessidade de variáveis mutáveis.

Legibilidade e Manutenção

    Java:
    Em programas mais complexos, o detalhamento dos passos pode aumentar a verbosidade do código, exigindo um cuidado maior para evitar erros lógicos na manipulação do estado.

    Prolog:
    A clareza na definição de relações e regras pode facilitar a compreensão do que o código pretende alcançar, mas a depuração pode ser mais desafiadora para aqueles não familiarizados com o raciocínio lógico.

Considerações Finais

A escolha entre um paradigma imperativo e um declarativo depende do problema a ser resolvido e da familiaridade do programador com os conceitos subjacentes. O paradigma imperativo oferece controle detalhado sobre cada etapa do processo, sendo útil quando a precisão do fluxo de execução é crucial. Por outro lado, o paradigma declarativo permite descrever soluções de forma mais abstrata, delegando ao sistema a complexidade do controle de fluxo e inferência, o que pode resultar em soluções mais concisas e de manutenção potencialmente simplificada.

Este exercício demonstrou, através dos exemplos em Java e Prolog, que ambos os paradigmas podem atingir o mesmo objetivo – no caso, calcular a soma de uma sequência de números – porém, por meio de abordagens fundamentalmente distintas, refletindo a diversidade de pensamento e técnicas disponíveis na programação contemporânea.