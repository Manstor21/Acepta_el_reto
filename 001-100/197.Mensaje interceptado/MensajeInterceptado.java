import java.util.Scanner;

public class MensajeInterceptado {

    private static boolean esVocal(char ch) {
        char c = Character.toLowerCase(ch);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Deshace el paso 2: X'' se formo tomando el primero, el ultimo,
    // el segundo, el penultimo, ... de X'.
    private static String deshacerIntercalado(String s) {
        int n = s.length();
        char[] res = new char[n];
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                res[k / 2] = s.charAt(k);
            } else {
                res[n - 1 - k / 2] = s.charAt(k);
            }
        }
        return new String(res);
    }

    // Deshace el paso 1: invertir las secuencias de no vocales es su propio inverso.
    private static String deshacerEspejo(String s) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (esVocal(s.charAt(i))) {
                res.append(s.charAt(i));
                i++;
            } else {
                int j = i;
                while (j < s.length() && !esVocal(s.charAt(j))) {
                    j++;
                }
                res.append(new StringBuilder(s.substring(i, j)).reverse());
                i = j;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String cifrado = sc.nextLine();
            String original = deshacerEspejo(deshacerIntercalado(cifrado));
            System.out.println(cifrado + " => " + original);
        }
        sc.close();
    }
}
