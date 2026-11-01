# 📊 Projeto Calculadora — FinançApp

## 📌 Descrição do Projeto
O **Projeto Calculadora** é um módulo base desenvolvido em **Java** para a startup fictícia **FinançApp**, responsável por construir um aplicativo mobile voltado ao controle de finanças pessoais.

Este módulo fornece as operações matemáticas fundamentais utilizadas em diferentes funcionalidades do aplicativo:
- **Cálculo de orçamento mensal** (consolidação de receitas e subtração de despesas);
- **Divisão de despesas** entre participantes ou categorias;
- **Projeção de economia financeira** ao longo de múltiplos períodos;
- **Cálculo de valores básicos** utilizados internamente pelo sistema.

---

## 🎯 Objetivo da Atividade
Desenvolver a capacidade prática na construção, validação, manutenção e documentação de software aplicando conceitos essenciais de Engenharia e Qualidade de Software:
- **Testes Funcionais e Unitários**;
- **Tratamento de Erros e Exceções**;
- **Refatoração de Código** (Clean Code);
- **Documentação Técnica e JavaDoc**;
- **Versionamento de Software com Git e GitHub** (`main` e `Refatoracao`).

---

## 🛠️ Tecnologias Utilizadas
| Tecnologia / Ferramenta | Finalidade |
| :--- | :--- |
| **Java (JDK)** | Linguagem de programação principal do módulo (`calculadora`) |
| **JavaDoc** | Ferramenta oficial para geração da documentação técnica em HTML (`docs/`) |
| **Git** | Controle de versão local e gerenciamento de branches (`main` e `Refatoracao`) |
| **GitHub** | Hospedagem do repositório remoto e histórico de commits |

---

## ➗ Explicação das Operações
A classe `Calculadora` (localizada no pacote `calculadora`) disponibiliza o método principal `calc(int a, int b, String op)` e métodos específicos para cada operação aritmética:

1. **Soma (`+` / `somar(int a, int b)`)**
   - Recebe dois números inteiros e retorna a adição (`a + b`).
   - *Aplicação no FinançApp:* soma de entradas financeiras e aportes.
2. **Subtração (`-` / `subtrair(int a, int b)`)**
   - Recebe dois números inteiros e retorna a diferença (`a - b`).
   - *Aplicação no FinançApp:* abatimento de despesas sobre a renda mensal.
3. **Multiplicação (`*` / `multiplicar(int a, int b)`)**
   - Recebe dois números inteiros e retorna o produto (`a * b`).
   - *Aplicação no FinançApp:* projeção de metas de economia por vários meses.
4. **Divisão (`/` / `dividir(int a, int b)`)**
   - Recebe o dividendo e o divisor e retorna o quociente inteiro (`a / b`).
   - **Tratamento de erro:** impede a divisão por zero (`b == 0`), lançando/tratando `ArithmeticException` com mensagem explicativa no console e retornando `0` sem interromper a execução do sistema.
5. **Validação de Operações Inválidas**
   - Caso seja informado um operador não suportado (ex.: `"x"`, `"%"` ou `null`), o sistema captura `IllegalArgumentException`, exibe uma mensagem informativa no console e mantém a execução segura.

---

## 🔄 Processo de Refatoração (Branch `Refatoracao`)
Na branch `Refatoracao`, o código inicial da branch `main` passou por melhorias estruturais mantendo 100% do comportamento esperado nos testes:
- **Extração de Métodos:** criação dos métodos `somar`, `subtrair`, `multiplicar` e `dividir`.
- **Melhoria nos Nomes de Variáveis e Encapsulamento:** substituição da variável pública `r` pelo atributo privado `ultimoResultado` (acessível via `getUltimoResultado()`) e parâmetros descritivos (`primeiroValor`, `segundoValor`, `dividendo`, `divisor`).
- **Simplificação de Estruturas Condicionais:** substituição de múltiplos blocos `if / else if` aninhados por uma estrutura `switch (op)`.
- **Tratamento Estruturado de Exceções:** uso de `try-catch` com `ArithmeticException` e `IllegalArgumentException`.

---

## 🧪 Execução dos Testes (`TesteCalculadora.java`)

A classe `TesteCalculadora` valida todos os cenários obrigatórios demonstrando **entradas utilizadas**, **resultado esperado** e **resultado obtido**:

| Cenário de Teste | Entradas (`a`, `b`, `op`) | Resultado Esperado | Resultado Obtido | Status |
| :--- | :---: | :---: | :---: | :---: |
| Soma simples | `2, 3, "+"` | `5` | `5` | ✅ `[PASSOU]` |
| Soma (valores maiores) | `150, 250, "+"` | `400` | `400` | ✅ `[PASSOU]` |
| Subtração simples | `10, 4, "-"` | `6` | `6` | ✅ `[PASSOU]` |
| Subtração (resultado negativo) | `5, 12, "-"` | `-7` | `-7` | ✅ `[PASSOU]` |
| Multiplicação simples | `3, 5, "*"` | `15` | `15` | ✅ `[PASSOU]` |
| Multiplicação por zero | `25, 0, "*"` | `0` | `0` | ✅ `[PASSOU]` |
| Divisão exata | `8, 2, "/"` | `4` | `4` | ✅ `[PASSOU]` |
| Divisão de despesas | `100, 4, "/"` | `25` | `25` | ✅ `[PASSOU]` |
| Divisão por zero | `8, 0, "/"` | `0` *(com mensagem de erro)* | `0` | ✅ `[PASSOU]` |
| Operação inválida (`"x"`) | `5, 5, "x"` | `0` *(com mensagem de erro)* | `0` | ✅ `[PASSOU]` |
| Operação inválida (`"%"`) | `10, 2, "%"` | `0` *(com mensagem de erro)* | `0` | ✅ `[PASSOU]` |

### Print da Execução dos Testes
![Print da Execução dos Testes](./assets/print_testes.svg)

<details>
<summary>📋 Ver saída completa do console em texto</summary>

```text
==================================================
        EXECUCAO DE TESTES - FINANCAPP            
==================================================

>>> Teste de Soma
Entradas utilizadas : a = 2, b = 3, op = "+"
Resultado esperado  : 5
Resultado = 5
Resultado obtido    : 5
Status do Teste     : [PASSOU]
--------------------------------------------------
>>> Teste de Divisao por Zero
Entradas utilizadas : a = 8, b = 0, op = "/"
Resultado esperado  : 0
Erro: divisao por zero nao e permitida.
Resultado = 0
Resultado obtido    : 0
Status do Teste     : [PASSOU]
--------------------------------------------------
>>> Teste de Operacao Invalida ('x')
Entradas utilizadas : a = 5, b = 5, op = "x"
Resultado esperado  : 0
Operacao invalida: x
Resultado = 0
Resultado obtido    : 0
Status do Teste     : [PASSOU]
--------------------------------------------------
```
</details>

---

## 📚 Documentação JavaDoc (`docs/`)

A documentação HTML foi gerada utilizando a ferramenta oficial `javadoc` na pasta [`docs/`](./docs/index.html), contendo as anotações `@author`, `@version`, `@param`, `@return` e `@throws`.

- **Arquivo principal:** [`docs/index.html`](./docs/index.html)
- **Documentação da Calculadora:** [`docs/calculadora/Calculadora.html`](./docs/calculadora/Calculadora.html)
- **Documentação dos Testes:** [`docs/calculadora/TesteCalculadora.html`](./docs/calculadora/TesteCalculadora.html)

### Print da Documentação JavaDoc
![Print da Documentação JavaDoc](./assets/print_javadoc.svg)

---

## 🚀 Como Compilar, Executar e Gerar o JavaDoc

```bash
# 1. Compilar as classes do pacote calculadora
javac -d bin src/calculadora/*.java

# 2. Executar a bateria de testes unitários
java -cp bin calculadora.TesteCalculadora

# 3. Gerar a documentação HTML via JavaDoc
javadoc -d docs -author -version -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 -sourcepath src calculadora
```

---

## 🔗 Link do Repositório
- **Repositório GitHub:** `https://github.com/SEU_USUARIO/projeto_calculadora` *(atualize com a URL do seu repositório ao publicar)*
- **Branches disponíveis:**
  - `main`: Implementação inicial funcional e testes unitários.
  - `Refatoracao`: Código refatorado, documentado com JavaDoc e pasta `docs/` gerada.
