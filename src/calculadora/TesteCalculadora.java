package calculadora;

/**
 * Classe de testes para validar as operacoes da Calculadora.
 *
 * @author Julio
 * @version 1.0
 */
public class TesteCalculadora {

    /**
     * Construtor padrao da classe TesteCalculadora.
     */
    public TesteCalculadora() {
    }

    /**
     * Metodo principal que executa os testes das operacoes no console.
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("--- Testes da Calculadora ---\n");

        // Teste 1: Soma
        System.out.println("Teste Soma: entradas (2, 3, '+')");
        System.out.println("Resultado esperado: 5");
        int resSoma = calc.calc(2, 3, "+");
        System.out.println("Resultado obtido: " + resSoma + "\n");

        // Teste 2: Subtracao
        System.out.println("Teste Subtracao: entradas (10, 4, '-')");
        System.out.println("Resultado esperado: 6");
        int resSub = calc.calc(10, 4, "-");
        System.out.println("Resultado obtido: " + resSub + "\n");

        // Teste 3: Multiplicacao
        System.out.println("Teste Multiplicacao: entradas (3, 5, '*')");
        System.out.println("Resultado esperado: 15");
        int resMult = calc.calc(3, 5, "*");
        System.out.println("Resultado obtido: " + resMult + "\n");

        // Teste 4: Divisao
        System.out.println("Teste Divisao: entradas (8, 2, '/')");
        System.out.println("Resultado esperado: 4");
        int resDiv = calc.calc(8, 2, "/");
        System.out.println("Resultado obtido: " + resDiv + "\n");

        // Teste 5: Divisao por zero
        System.out.println("Teste Divisao por Zero: entradas (8, 0, '/')");
        System.out.println("Resultado esperado: 0 (mensagem de erro)");
        int resDivZero = calc.calc(8, 0, "/");
        System.out.println("Resultado obtido: " + resDivZero + "\n");

        // Teste 6: Operacao invalida
        System.out.println("Teste Operacao Invalida: entradas (5, 5, 'x')");
        System.out.println("Resultado esperado: 0 (mensagem de operacao invalida)");
        int resInvalido = calc.calc(5, 5, "x");
        System.out.println("Resultado obtido: " + resInvalido + "\n");
    }
}
