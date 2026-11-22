import java.util.Scanner;

/*
 * Cada nivel multiplica por 4 el numero de cuadrados y divide el lado entre 2.
 * La tinta es el perimetro de cada cuadrado, 4*lado, sumado en todos los niveles.
 * lado/=2 trunca bien porque el enunciado garantiza lados enteros.
 */
public class PintandoFractales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLong()) {
            long lado = sc.nextLong();
            long tinta = 0;
            long cuadrados = 1;

            while (lado > 0) {
                tinta += cuadrados * 4 * lado;
                cuadrados *= 4;
                lado /= 2;
            }

            System.out.println(tinta);
        }
    }
}
