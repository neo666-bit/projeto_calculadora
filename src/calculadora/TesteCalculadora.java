package calculadora;

/**
 * Classe responsavel pela execucao dos testes unitarios e funcionais da classe {@link Calculadora}.
 * <p>
 * Valida todas as operacoes basicas (soma, subtracao, multiplicacao e divisao),
 * alem dos cenarios de tratamento de erros (divisao por zero e operacoes invalidas),
 * exibindo as entradas utilizadas, o resultado esperado e o resultado obtido.
 * </p>
 *
 * @author Julio
 * @version 2.0
 */
public class TesteCalculadora {

    /**
     * Construtor padrao da classe de testes TesteCalculadora.
     */
    public TesteCalculadora() {
        // Construtor padrao
    }

    /**
     * Metodo principal que inicia a bateria de testes automatizados no console.
     *
     * @param args Argumentos de linha de comando (nao utilizados).
     */
    public static void main(String[] args) {
        // Instancia o modulo de calculadora para validacao
        Calculadora calc = new Calculadora();

        System.out.println("==================================================");
        System.out.println("        EXECUCAO DE TESTES - FINANCAPP            ");
        System.out.println("==================================================\n");

        // 1. Testes de Soma (+)
        executarTeste(calc, "Teste de Soma", 2, 3, "+", 5);
        executarTeste(calc, "Teste de Soma (valores maiores)", 150, 250, "+", 400);

        // 2. Testes de Subtracao (-)
        executarTeste(calc, "Teste de Subtracao", 10, 4, "-", 6);
        executarTeste(calc, "Teste de Subtracao (resultado negativo)", 5, 12, "-", -7);

        // 3. Testes de Multiplicacao (*)
        executarTeste(calc, "Teste de Multiplicacao", 3, 5, "*", 15);
        executarTeste(calc, "Teste de Multiplicacao por Zero", 25, 0, "*", 0);

        // 4. Testes de Divisao (/)
        executarTeste(calc, "Teste de Divisao Exata", 8, 2, "/", 4);
        executarTeste(calc, "Teste de Divisao de Despesas", 100, 4, "/", 25);

        // 5. Teste de Divisao por Zero
        executarTeste(calc, "Teste de Divisao por Zero", 8, 0, "/", 0);

        // 6. Testes de Operacoes Invalidas
        executarTeste(calc, "Teste de Operacao Invalida ('x')", 5, 5, "x", 0);
        executarTeste(calc, "Teste de Operacao Invalida ('%')", 10, 2, "%", 0);

        System.out.println("==================================================");
        System.out.println("          FIM DA EXECUCAO DOS TESTES              ");
        System.out.println("==================================================");
    }

    /**
     * Metodo auxiliar que executa um caso de teste individual e compara o valor obtido
     * com o valor esperado, imprimindo um relatorio detalhado no console.
     *
     * @param calc      A instancia de {@link Calculadora} a ser testada.
     * @param descricao A descricao textual do cenario de teste.
     * @param a         O primeiro valor inteiro de entrada.
     * @param b         O segundo valor inteiro de entrada.
     * @param op        O simbolo da operacao matematica a ser testada.
     * @param esperado  O resultado inteiro esperado ao final da execucao.
     */
    private static void executarTeste(Calculadora calc, String descricao, int a, int b, String op, int esperado) {
        System.out.println(">>> " + descricao);
        System.out.println("Entradas utilizadas : a = " + a + ", b = " + b + ", op = \"" + op + "\"");
        System.out.println("Resultado esperado  : " + esperado);

        try {
            // Executa a operacao na calculadora e armazena o retorno obtido
            int obtido = calc.calc(a, b, op);
            System.out.println("Resultado obtido    : " + obtido);

            // Verifica se o resultado obtido corresponde exatamente ao esperado
            if (obtido == esperado) {
                System.out.println("Status do Teste     : [PASSOU]");
            } else {
                System.out.println("Status do Teste     : [FALHOU]");
            }
        } catch (Exception e) {
            // Caso alguma excecao externa ocorra, registra sem interromper os demais testes
            System.out.println("Excecao capturada   : " + e.getMessage());
            System.out.println("Status do Teste     : [TRATADO COM EXCECAO]");
        }
        System.out.println("--------------------------------------------------");
    }
}
