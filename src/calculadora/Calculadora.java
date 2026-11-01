package calculadora;

/**
 * Classe responsavel por realizar as operacoes matematicas basicas do sistema FinancApp.
 * <p>
 * Este modulo oferece suporte aos calculos de orcamento mensal, divisao de despesas,
 * projecao de economia financeira e demais operacoes aritmeticas fundamentais.
 * </p>
 *
 * @author Julio
 * @version 2.0
 */
public class Calculadora {

    /**
     * Armazena o resultado da ultima operacao matematica realizada pela calculadora.
     */
    private int ultimoResultado = 0;

    /**
     * Construtor padrao da classe Calculadora.
     * Inicializa o estado interno com o ultimo resultado zerado.
     */
    public Calculadora() {
        // Inicializacao padrao do componente de calculo
        this.ultimoResultado = 0;
    }

    /**
     * Realiza a operacao de adicao entre dois numeros inteiros.
     *
     * @param primeiroValor O primeiro numero inteiro (parcela) a ser somado.
     * @param segundoValor  O segundo numero inteiro (parcela) a ser somado.
     * @return O resultado da soma entre {@code primeiroValor} e {@code segundoValor}.
     */
    public int somar(int primeiroValor, int segundoValor) {
        // Soma simples utilizada, por exemplo, na consolidacao de receitas e despesas
        return primeiroValor + segundoValor;
    }

    /**
     * Realiza a operacao de subtracao entre dois numeros inteiros.
     *
     * @param primeiroValor O valor base (minuendo) da subtracao.
     * @param segundoValor  O valor a ser subtraido (subtraendo).
     * @return O resultado da diferenca entre {@code primeiroValor} e {@code segundoValor}.
     */
    public int subtrair(int primeiroValor, int segundoValor) {
        // Subtracao utilizada para calculo de saldo restante no orcamento mensal
        return primeiroValor - segundoValor;
    }

    /**
     * Realiza a operacao de multiplicacao entre dois numeros inteiros.
     *
     * @param primeiroValor O primeiro fator (multiplicando) da operacao.
     * @param segundoValor  O segundo fator (multiplicador) da operacao.
     * @return O produto resultante da multiplicacao entre os dois fatores.
     */
    public int multiplicar(int primeiroValor, int segundoValor) {
        // Multiplicacao util para projecao de economia financeira ao longo de varios meses
        return primeiroValor * segundoValor;
    }

    /**
     * Realiza a operacao de divisao inteira entre dois numeros.
     *
     * @param dividendo O valor total a ser dividido.
     * @param divisor   O numero pelo qual o dividendo sera dividido.
     * @return O quociente inteiro da divisao entre {@code dividendo} e {@code divisor}.
     * @throws ArithmeticException Caso o {@code divisor} seja igual a zero.
     */
    public int dividir(int dividendo, int divisor) throws ArithmeticException {
        // Verifica se o divisor e zero para impedir falha aritmetica na divisao de despesas
        if (divisor == 0) {
            throw new ArithmeticException("Erro: divisao por zero nao e permitida.");
        }
        return dividendo / divisor;
    }

    /**
     * Metodo principal de fachada que executa a operacao matematica solicitada
     * com base no simbolo do operador informado.
     * <p>
     * Este metodo trata internamente divisoes por zero e operadores invalidos,
     * exibindo mensagens informativas no console e evitando a interrupcao do programa.
     * </p>
     *
     * @param a  O primeiro operando inteiro da operacao.
     * @param b  O segundo operando inteiro da operacao.
     * @param op O simbolo da operacao desejada: {@code "+"}, {@code "-"}, {@code "*"} ou {@code "/"}.
     * @return O resultado inteiro da operacao ou {@code 0} caso ocorra erro de validacao ou divisao por zero.
     */
    public int calc(int a, int b, String op) {
        // Validacao preventiva contra operador nulo
        if (op == null) {
            System.out.println("Erro: operacao invalida (nula).");
            ultimoResultado = 0;
            return ultimoResultado;
        }

        // Seleciona e executa a operacao correspondente com tratamento seguro de excecoes
        try {
            switch (op) {
                case "+":
                    ultimoResultado = somar(a, b);
                    break;
                case "-":
                    ultimoResultado = subtrair(a, b);
                    break;
                case "*":
                    ultimoResultado = multiplicar(a, b);
                    break;
                case "/":
                    ultimoResultado = dividir(a, b);
                    break;
                default:
                    throw new IllegalArgumentException("Operacao invalida: " + op);
            }
        } catch (ArithmeticException | IllegalArgumentException e) {
            // Captura erros matematicos ou de operador invalido sem interromper a execucao do sistema
            System.out.println(e.getMessage());
            ultimoResultado = 0;
        }

        // Exibe e retorna o resultado obtido na operacao
        System.out.println("Resultado = " + ultimoResultado);
        return ultimoResultado;
    }

    /**
     * Obtem o valor armazenado da ultima operacao executada pela calculadora.
     *
     * @return O ultimo resultado calculado.
     */
    public int getUltimoResultado() {
        return ultimoResultado;
    }
}
