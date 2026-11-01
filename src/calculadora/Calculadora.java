package calculadora;

public class Calculadora {

    private int ultimoResultado = 0;

    public int somar(int primeiroValor, int segundoValor) {
        return primeiroValor + segundoValor;
    }

    public int subtrair(int primeiroValor, int segundoValor) {
        return primeiroValor - segundoValor;
    }

    public int multiplicar(int primeiroValor, int segundoValor) {
        return primeiroValor * segundoValor;
    }

    public int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Erro: divisao por zero nao e permitida.");
        }
        return dividendo / divisor;
    }

    public int calc(int a, int b, String op) {
        if (op == null) {
            System.out.println("Erro: operacao invalida (nula).");
            ultimoResultado = 0;
            return ultimoResultado;
        }

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
            System.out.println(e.getMessage());
            ultimoResultado = 0;
        }

        System.out.println("Resultado = " + ultimoResultado);
        return ultimoResultado;
    }

    public int getUltimoResultado() {
        return ultimoResultado;
    }
}
