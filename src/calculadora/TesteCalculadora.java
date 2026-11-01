package calculadora;

public class TesteCalculadora {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("==================================================");
        System.out.println("        EXECUCAO DE TESTES - FINANCAPP            ");
        System.out.println("==================================================\n");

        // 1. Teste de Soma (+)
        executarTeste(calc, "Teste de Soma", 2, 3, "+", 5);
        executarTeste(calc, "Teste de Soma (valores maiores)", 150, 250, "+", 400);

        // 2. Teste de Subtracao (-)
        executarTeste(calc, "Teste de Subtracao", 10, 4, "-", 6);
        executarTeste(calc, "Teste de Subtracao (resultado negativo)", 5, 12, "-", -7);

        // 3. Teste de Multiplicacao (*)
        executarTeste(calc, "Teste de Multiplicacao", 3, 5, "*", 15);
        executarTeste(calc, "Teste de Multiplicacao por Zero", 25, 0, "*", 0);

        // 4. Teste de Divisao (/)
        executarTeste(calc, "Teste de Divisao Exata", 8, 2, "/", 4);
        executarTeste(calc, "Teste de Divisao de Despesas", 100, 4, "/", 25);

        // 5. Teste de Divisao por Zero
        executarTeste(calc, "Teste de Divisao por Zero", 8, 0, "/", 0);

        // 6. Teste de Operacoes Invalidas
        executarTeste(calc, "Teste de Operacao Invalida ('x')", 5, 5, "x", 0);
        executarTeste(calc, "Teste de Operacao Invalida ('%')", 10, 2, "%", 0);

        System.out.println("==================================================");
        System.out.println("          FIM DA EXECUCAO DOS TESTES              ");
        System.out.println("==================================================");
    }

    private static void executarTeste(Calculadora calc, String descricao, int a, int b, String op, int esperado) {
        System.out.println(">>> " + descricao);
        System.out.println("Entradas utilizadas : a = " + a + ", b = " + b + ", op = \"" + op + "\"");
        System.out.println("Resultado esperado  : " + esperado);

        try {
            int obtido = calc.calc(a, b, op);
            System.out.println("Resultado obtido    : " + obtido);

            if (obtido == esperado) {
                System.out.println("Status do Teste     : [PASSOU]");
            } else {
                System.out.println("Status do Teste     : [FALHOU]");
            }
        } catch (Exception e) {
            System.out.println("Excecao capturada   : " + e.getMessage());
            System.out.println("Status do Teste     : [TRATADO COM EXCECAO]");
        }
        System.out.println("--------------------------------------------------");
    }
}
