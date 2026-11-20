import java.util.Scanner;

/*
 * Problema 163 - Sumale uno
 *
 * Los numeros pueden tener hasta 100 digitos, asi que no caben en un
 * entero: se suma uno sobre los propios digitos, propagando el acarreo
 * desde la derecha. Si todos son F, aparece un 1 por la izquierda.
 */
public class SumaleUno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String numero = sc.next();
            if (numero.equals("FIN")) {
                break;
            }
            System.out.println(siguiente(numero));
        }
        sc.close();
    }

    static String siguiente(String numero) {
        char[] digitos = numero.toCharArray();
        int i = digitos.length - 1;

        while (i >= 0 && digitos[i] == 'F') {
            digitos[i] = '0';
            i--;
        }

        if (i < 0) {
            return "1" + new String(digitos);
        }

        if (digitos[i] == '9') {
            digitos[i] = 'A';
        } else {
            digitos[i]++;
        }
        return new String(digitos);
    }
}
