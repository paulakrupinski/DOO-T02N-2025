Aluno: Wellington Davies Dos Santos

trabalho de desenvolvimento orientado a objetos
# Paradigmas de programação

### Introdução

# Paradigmas de Programação: Uma Introdução

Quando estamos estudando programação, principalmente na universidade, é possível perceber o quão multifacetada ela é, com diferentes abordagens, ou paradigmas. À medida que começamos a resolver problemas e construir soluções, notamos que cada paradigma reflete uma forma distinta de entender a estrutura e o funcionamento do código.

​Os paradigmas de programação são estilos ou modelos que definem a abordagem utilizada para resolver problemas e estruturar a lógica dos programas. Eles estabelecem um conjunto de princípios e técnicas que orientam a forma como os desenvolvedores escrevem e organizam o código. Cada paradigma oferece uma perspectiva distinta sobre como os programas devem ser construídos e executados.

Para iniciantes, compreender esses paradigmas é fundamental para navegar no mundo da programação de maneira eficiente e produtiva.

## Programação Orientada a Objetos (POO)
A POO é um paradigma que modela o mundo real por meio de objetos, que são instâncias de classes. Cada objeto possui atributos (dados) e métodos (funções) que definem seu comportamento. A POO oferece uma maneira intuitiva e estruturada de construir programas complexos.

- **Encapsulamento**: Este conceito protege os dados internos de um objeto, permitindo acesso apenas por meio de métodos definidos. Isso ajuda a evitar manipulações acidentais ou indevidas de dados.
- **Herança**: Permite que uma classe herde propriedades e métodos de outra classe, promovendo a reutilização de código e a criação de hierarquias estruturais.
- **Polimorfismo**: Um método pode ter diferentes implementações baseadas na classe de onde é chamado, permitindo que diferentes objetos respondam de maneira única a uma mesma mensagem.

**Exemplos de Linguagens**: Java, C++, Python e Ruby são linguagens que suportam a POO de maneira robusta.

## Programação Funcional
A programação funcional se concentra em funções puras e imutabilidade, promovendo um estilo declarativo de programação. Isso significa que, em vez de dizer ao computador como fazer algo (como na programação imperativa), você declara o que precisa ser feito.

- **Funções Puras**: Estas sempre produzem a mesma saída para uma dada entrada, sem causar efeitos colaterais, facilitando a depuração e o teste de código.
- **Imutabilidade**: Dados são tratados como imutáveis, reduzindo a possibilidade de erros e promovendo a consistência ao longo do programa.
- **Composição de Funções**: Funções podem ser passadas como argumentos, retornadas como valores e compostas para criar novas funções, promovendo reutilização e modularidade.

**Exemplos de Linguagens**: Haskell, Lisp e Scala são exemplos de linguagens funcionais.

## Programação Lógica
A programação lógica baseia-se em regras e fatos declarativos, permitindo que o mecanismo de inferência encontre soluções para problemas.

- **Regras e Fatos**: O programador define um conjunto de regras e fatos que descrevem a lógica do problema, e o motor de inferência resolve-o automaticamente.
- **Prolog**: Uma linguagem proeminente neste paradigma, utilizada em inteligência artificial, sistemas de recomendação e outras aplicações lógicas.

## Programação Reativa
A programação reativa é orientada a eventos e responde a mudanças em fontes de dados ou no ambiente.

- **Orientada a Eventos**: Responde a eventos, como cliques de usuário ou mudanças em dados, tornando-a essencial para interfaces gráficas e programação assíncrona.

**Exemplos de Bibliotecas**: RxJS (JavaScript) e ReactiveX proporcionam suporte robusto para programação reativa, integrando-a em diversas linguagens.

## Programação Imperativa
A programação imperativa se concentra em alterar o estado do programa por meio de uma sequência de comandos.

- **Sequência de Comandos**: Instruções são executadas de cima para baixo, a menos que alteradas por estruturas de controle, como loops ou condicionais.
- **Estruturas de Controle**: Ferramentas como loops e condicionais ajudam a controlar o fluxo do programa.

**Exemplos de Linguagens**: C, Pascal e Basic são exemplos de linguagens imperativas.

## Programação Procedural
A programação procedural é uma subcategoria da programação imperativa e concentra-se em dividir um programa em procedimentos ou funções, facilitando a organização e a estruturação do código.

- **Sequência de Execução**: As instruções são executadas na ordem em que aparecem, de cima para baixo, a menos que alteradas por estruturas de controle.
- **Modularidade**: Funções ou procedimentos são usados para dividir o código em módulos independentes, tornando a manutenção e a reutilização mais fáceis.
- **Variáveis**: São utilizadas para armazenar dados, sendo acessadas e modificadas ao longo do código.
- **Estruturas de Controle**: Loops (for, while) e condicionais (if-else) ajudam a controlar o fluxo do programa.

**Exemplos de Linguagens**: C, Pascal e Fortran são exemplos de linguagens de programação procedurais.

---

Cada paradigma de programação oferece uma maneira única de abordar e resolver problemas de programação. Para iniciantes, é importante explorar e entender cada paradigma, identificando suas vantagens e desvantagens. Com essa compreensão, você pode escolher o paradigma que melhor atende às necessidades de um projeto específico, ou até mesmo combinar diferentes paradigmas para aproveitar ao máximo suas características. Essa flexibilidade e entendimento são essenciais para uma carreira de sucesso em programação.


# Comparação entre um codigo em java e prolog


## Codigo em java( Abordagem imperativa ):
Esse codigo Cria uma matriz, define os valores, cria as variaveis de controle, então o codigo descreve o que deve ser executado passo a passo, usa Loops explicitos para percorrer as linhas e colunas, atualiza a variavel de controle a cada iteração sendo o fluxo de execução é linear e pré-definido.

```java
public class SomaMatriz {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int soma = 0;

        // Percorre linhas e colunas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                soma += matriz[i][j];
            }
        }
        System.out.println("Soma: " + soma); // 45
    }
}
```

## Codigo em Prolog( Abordagem declarativa ):
O código define o que é verdade (regras lógicas) em vez de instruções, substitui loops por recursão (caso base + caso recursivo), não há variáveis mutáveis; valores são calculados através de unificação, se houvesse múltiplas soluções, Prolog as encontraria (não é o caso aqui).

```prolog
% Define a matriz
matriz([[1, 2, 3], [4, 5, 6], [7, 8, 9]]).

% Soma uma linha
soma_linha([], 0).
soma_linha([H|T], Soma) :-
    soma_linha(T, SomaResto),
    Soma is H + SomaResto.

% Soma a matriz
soma_matriz([], 0).
soma_matriz([Linha|Resto], SomaTotal) :-
    soma_linha(Linha, SomaLinha),
    soma_matriz(Resto, SomaResto),
    SomaTotal is SomaLinha + SomaResto.

% Consulta
?- matriz(M), soma_matriz(M, Soma). % Soma = 45
```

    Com esse comparativo concluo que diferentes tipos de abordagens, diferentes para cada linguagem de programação, criam maneiras completamente distintas para a resolução de um problema, utilizando paradigmas especificos, em qualquer linguagem é possivel chegar no mesmo resultado