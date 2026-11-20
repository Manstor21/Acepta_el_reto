import java.util.Scanner;

public class NumerosReversibles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next().trim();
            if (s.isEmpty()) {
                continue;
            }
            long n = Long.parseLong(s);
            if (n == 0) {
                break;
            }
            System.out.println(esReversible(s) ? "SI" : "NO");
        }
        sc.close();
    }

    private static boolean esReversible(String s) {
        // Si termina en 0, al invertirlo se pierde un digito.
        if (s.charAt(s.length() - 1) == '0') {
            return false;
        }
        long n = Long.parseLong(s);
        long rev = Long.parseLong(new StringBuilder(s).reverse().toString());
        String suma = Long.toString(n + rev);
        for (int i = 0; i < suma.length(); i++) {
            if ((suma.charAt(i) - '0') % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
