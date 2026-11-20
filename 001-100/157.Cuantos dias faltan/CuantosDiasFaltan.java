import java.util.Scanner;

/*
 * Problema 157 - Cuantos dias faltan
 *
 * Se parte de un anno no bisiesto (365 dias). Para cada fecha se calcula
 * el numero de dia del anno en que cae y se resta de 365: asi, al 28 de
 * diciembre (dia 362) le faltan 3 dias (29, 30 y 31), y al 1 de enero
 * (dia 1) le faltan 364.
 */
public class CuantosDiasFaltan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (casos-- > 0) {
            int dia = sc.nextInt();
            int mes = sc.nextInt();

            int diaDelAnio = dia;
            for (int i = 0; i < mes - 1; i++) {
                diaDelAnio += diasPorMes[i];
            }

            System.out.println(365 - diaDelAnio);
        }
        sc.close();
    }
}
