import java.util.Scanner;

public class Calculator {

    static int negativo(int n) {
        int resultado = 0;
        if (n > 0) {
            while (n != 0) {
                resultado--;
                n--;
            }
        } else {
            while (n != 0) {
                resultado++;
                n++;
            }
        }
        return resultado;
    }

    static int sumar(int a, int b) {
        while (b > 0) {
            a++;
            b--;
        }
        while (b < 0) {
            a--;
            b++;
        }
        return a;
    }

    static int restar(int a, int b) {
        return sumar(a, negativo(b));
    }

    static int multiplicar(int a, int b) {
        int resultado = 0;
        boolean esNegativo = false;

        if (a < 0) {
            a = negativo(a);
            esNegativo = !esNegativo;
        }
        if (b < 0) {
            b = negativo(b);
            esNegativo = !esNegativo;
        }

        while (b > 0) {
            resultado = sumar(resultado, a);
            b--;
        }

        if (esNegativo) {
            resultado = negativo(resultado);
        }
        return resultado;
    }

    static int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir entre 0");
        }

        int cociente = 0;
        boolean esNegativo = false;

        if (a < 0) {
            a = negativo(a);
            esNegativo = !esNegativo;
        }
        if (b < 0) {
            b = negativo(b);
            esNegativo = !esNegativo;
        }

        while (a >= b) {
            a = restar(a, b);
            cociente++;
        }

        if (esNegativo) {
            cociente = negativo(cociente);
        }
        return cociente;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Calculadora con ++ y -- ===");
        System.out.print("Ingresa el primer número: ");
        int a = sc.nextInt();
        System.out.print("Ingresa el segundo número: ");
        int b = sc.nextInt();

        System.out.println("Suma: " + sumar(a, b));
        System.out.println("Resta: " + restar(a, b));
        System.out.println("Multiplicación: " + multiplicar(a, b));
        try {
            System.out.println("División: " + dividir(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
