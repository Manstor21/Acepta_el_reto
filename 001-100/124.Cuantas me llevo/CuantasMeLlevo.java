import java.util.Scanner;

/*
 * Problema 124 - Cuantas me llevo
 *
 * Se suman dos numeros digitos a digito de derecha a izquierda. Cada vez
 * que la suma de dos digitos mas el acarreo previo llega a 10 se genera
 * un acarreo. Se pide contar cuantos acarreos hay en total.
 *
 * Los numeros llegan hasta 1000 digitos, asi que se leen como String y se
 * suman columna a columna con un acarreo (0/1).
 */
public class CuantasMeLlevo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            if (a.equals("0") && b.equals("0")) break;

            int i = a.length() - 1;
            int j = b.length() - 1;
            int acarreo = 0;
            int total = 0;

            while (i >= 0 || j >= 0) {
                int da = (i >= 0) ? a.charAt(i) - '0' : 0;
                int db = (j >= 0) ? b.charAt(j) - '0' : 0;
                int suma = da + db + acarreo;
                if (suma >= 10) {
                    total++;
                    acarreo = 1;
                } else {
                    acarreo = 0;
                }
                i--;
                j--;
            }

            System.out.println(total);
        }

        sc.close();
    }
}
