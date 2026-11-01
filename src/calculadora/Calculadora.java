package calculadora;

/**
 * Classe que implementa as operacoes basicas da calculadora para o FinancApp.
 *
 * @author Julio
 * @version 1.0
 */
public class Calculadora {

    /**
     * Guarda o resultado da ultima operacao realizada.
     */
    public int resultado = 0;

    /**
     * Construtor padrao da classe Calculadora.
     */
    public Calculadora() {
    }

    /**
     * Realiza a soma de dois numeros inteiros.
     *
     * @param a primeiro valor da soma
     * @param b segundo valor da soma
     * @return resultado da soma de a e b
     */
    public int somar(int a, int b) {
        return a + b;
    }

    /**
     * Realiza a subtracao entre dois numeros inteiros.
     *
     * @param a primeiro valor
     * @param b valor que sera subtraido
     * @return resultado da subtracao
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Realiza a multiplicacao de dois numeros inteiros.
     *
     * @param a primeiro valor
     * @param b segundo valor
     * @return resultado da multiplicacao
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Realiza a divisao inteira entre dois numeros.
     *
     * @param a dividendo
     * @param b divisor
     * @return resultado da divisao
     * @throws ArithmeticException caso o divisor (b) seja igual a zero
     */
    public int dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Erro: divisao por zero nao permitida");
        }
        return a / b;
    }

    /**
     * Metodo principal que chama a operacao escolhida conforme o operador informado.
     *
     * @param a primeiro numero inteiro
     * @param b segundo numero inteiro
     * @param op operador matematico ("+", "-", "*" ou "/")
     * @return resultado da operacao ou 0 em caso de erro
     */
    public int calc(int a, int b, String op) {
        // Escolhe a operacao de acordo com o simbolo recebido
        try {
            switch (op) {
                case "+":
                    resultado = somar(a, b);
                    break;
                case "-":
                    resultado = subtrair(a, b);
                    break;
                case "*":
                    resultado = multiplicar(a, b);
                    break;
                case "/":
                    resultado = dividir(a, b);
                    break;
                default:
                    System.out.println("Erro: operacao invalida");
                    resultado = 0;
                    break;
            }
        } catch (ArithmeticException e) {
            // Trata o erro de divisao por zero sem travar o programa
            System.out.println(e.getMessage());
            resultado = 0;
        }

        System.out.println("Resultado = " + resultado);
        return resultado;
    }
}
