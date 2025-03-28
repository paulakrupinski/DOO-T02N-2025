# Aula 5 - PARADGIMAS
## _Imperativo e Declarativo_ - Java / Prolog

Antes de começarmos precisamos entender do que se trata os Paradigmas.

Paradigma é uma forma de pensar. É quando você pensa de uma forma já estabelecida, usando um padrão
já conhecido por você. 

Como assim?

>***Existem várias formas de pensar***

* Seja ela na área científica
* Seja ela na área religiosa
* Seja ela na área da ***programação***

Na programação, o modo _paradgimático_ de pensar está muito ligado na forma como um código deve ser escrito.
Antes de começarmos a escrever o código em si, já pensamos em como vamos estruturar cada parte dele. Logo,
todos os códigos possuem uma regra a ser seguida enquanto são escritos.

Até o momento, iremos falar sobre ***2 tipos de paradgimas*** encontrados dentro da programação.

## São eles:

>***Paradigma imperativo e Paradgima declarativo***

## Paradgima imperativo:
É uma forma de escrita de código na qual, quando escrevemos, damos ordens ao computador com o fim
de atingir um determinado objetivo. Quando estamos escrevendo esse tipo de texto, o código
começa a funcionar através de comandos e instruções que dizem ao sistema, como passo a passo, de 
que forma aquela tarefa será realizada.

>No paradigma imperativo, o programador é que tem o total controle sobre o fluxo de execução
> do próprio código. Pois é ele quem padroniza a forma que o código será executado.

É aqui que o desenvolvedor usa estruras de controle como:

* Laços
* Condicionais
* E atribuições diretas (aquelas feitas dentro das variáveis) 

## Exemplo em Java - Verificando se um número é par
![código em java](https://github.com/Felip8/imagens-para-a-aula-5/blob/main/java.png?raw=true)

Aqui conseguimos notar que o desenvolvedor pensou em escrever o código dentro de uma main diretamente.
Logo após, o mesmo criou uma varíavel to tipo [***int***] com o nome [***número***] e deu um valor 8 para a 
variável.
>Aqui foi feita uma atribuição direta a variável, ***como falado anteriormente***.

Então o desenvolvedor usou de um laço de repetição para dizer que: se o número determinado anteriormente for par, então o que vai ser mostrado na tela será ***par***.
Se o número determinado anteriormente for ímpar, então o que vai ser mostrado na tela será ***ímpar***.

Notasse também que o método para saber se um número é ***ímpar*** ou ***par*** vem através dessa linha de código:

![if](https://github.com/Felip8/imagens-para-a-aula-5/blob/main/if.png?raw=true)

## Outra forma de escrever o código
![método impar ou par](https://github.com/Felip8/imagens-para-a-aula-5/blob/main/java1.png?raw=true)

Essa é outra forma de escrever o código anterior, mas ainda segue a mesma ideia do ***Paradigma imperativo***.

Nós ainda temos um método no qual possue as suas próprias regras de como rodar o código, a única coisa que mudou
é que agora temos dois métodos, _um para fazer o teste lógico e outro para rodar esse teste lógico_.

### Conclusão

Tudo neste código está muito bem explícito sobre qual é o papel dele ao ser compilado.

## Paradgima declarativo

Totalmente diferente do ***Paradigma imperativo***, o ***Paradigma declarativo*** é baseado na ideia de descrever
o que você quer, ao invés de fazer exatamente como você quer que ele seja feito.

Nesse caso, você se responsabiliza por dizer ao sistema relações e fatos que terão dentro do sistema, e cabe ao sistema
encontrar alguma solução para aquela resposta usando a sua própria lógica interna.

>Aqui, o compilador do próprio sistema analisa e resolve o problema por meio de inferência lógica.

Esse tipo de paradigma é muito usado em áreas como:

* Programação funcional
* Programação lógica
* E banco de dados relacionais

## Exemplo em Prolog - Verificando se um número é par
![impar ou par Prolog](https://github.com/Felip8/imagens-para-a-aula-5/blob/main/prolog.png?raw=true)

No começo do código é definido que um número é par se o resto da divisão por 2 (mod) for igual a zero (=:=).
Depois que isso é feito ele desce para a próxima linha.

Ao compilar a linha 3, o Prolog avalia essa afirmação com base nas regras que já foram definidas. Então, se a expressão for verdadeira, retorna true,
se for falsa, retorna false.

### Conclusão
A avaliação acontece de forma automática, isso quer dizer que você precisa definir a lógica, sem descrever como
que esse cálculo seria explicado. Aqui você não tem um controle direto, você não precisa dizer como o sistema deve fazer
a verificação, só define a relação lógica.

## Diferença entre Imperativo e Declarativo

* **Imperativo:** 
  * Foco em como fazer.
  * O desenvolvedor precisa definir cada detalhe do processo.
  * A execução depende da ordem das instruções.
* **Declarativo:**
  * Foca no que fazer.
  * O sistema resolve automaticamente o problema com base em regras.
  * A ordem das instruções não é importante, o sistema usa lógica para resolver























