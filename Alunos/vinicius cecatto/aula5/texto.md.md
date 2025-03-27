

# Comparação entre Paradigmas Imperativo e Declarativo: Java vs Prolog

## Introdução aos Paradigmas de Programação

Os paradigmas de programação são abordagens fundamentais que guiam a construção de software, definindo como os problemas são resolvidos e como os programas são estruturados. Entre os diversos paradigmas existentes, destacam-se o **paradigma imperativo** e o **paradigma declarativo**, que representam duas filosofias distintas de desenvolvimento.

- **Paradigma Imperativo**: Baseia-se em instruções explícitas que especificam passo a passo como uma tarefa deve ser executada. O controle do fluxo é detalhado, com ênfase em mudanças de estado e manipulação direta de variáveis. Linguagens como Java são exemplos clássicos deste paradigma.
  
- **Paradigma Declarativo**: Foca em descrever *o que* deve ser feito, sem se preocupar com *como* será feito. A lógica e as regras são definidas, e o sistema se encarrega de encontrar soluções com base nessas descrições. Prolog é uma linguagem que exemplifica este paradigma.

A seguir, apresentamos dois trechos de código escritos em Java (imperativo) e Prolog (declarativo), comparando como cada linguagem aborda a resolução de um mesmo problema.

---

## Problema: Verificar se um Número Pertence a uma Lista

### Código em Java (Paradigma Imperativo)

```java
import java.util.Scanner;

public class VerificaNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lista = {1, 2, 3, 4, 5};
        
        System.out.println("Digite um número para verificar se está na lista:");
        int numero = scanner.nextInt();
        
        boolean encontrado = false;
        for (int i : lista) {
            if (i == numero) {
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            System.out.println("O número " + numero + " está na lista.");
        } else {
            System.out.println("O número " + numero + " não está na lista.");
        }
        
        scanner.close();
    }
}
