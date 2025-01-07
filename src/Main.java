import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {

            System.out.println("Digite o primeiro número:");
            double a = sc.nextDouble();

            System.out.println("Digite o segundo número:");
            double b = sc.nextDouble();

            System.out.println("Digite o operador:");
            char operador = sc.next().charAt(0);

            Calculadora calculadora = new Calculadora();
            double resultado = 0;

            switch (operador) {
                case '+':
                    resultado = calculadora.somar(a, b);
                    break;
                case '-':
                    resultado = calculadora.subtrair(a, b);
                    break;
                case '*':
                    resultado = calculadora.multiplicar(a, b);
                    break;
                case '/':
                    try {
                        resultado = calculadora.dividir(a, b);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    break;
                default:
                    System.out.println("Operador inválido! Use +, -, * ou /.");
                    continue;
            }

            System.out.println("Resultado = " + resultado);

            System.out.println("Deseja fazer outra operação ? (responda com 's')");
            char resposta = sc.next().charAt(0);
            if (resposta != 's' && resposta != 'S'){
                continuar = false;
            }
        }
        sc.close();
    }
}
