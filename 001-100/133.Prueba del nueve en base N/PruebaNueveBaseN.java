import java.util.Scanner;

/*
 * Problema 133 - Prueba del nueve en base N
 *
 * Comprobar una division D / d = c con resto r usando la "prueba del
 * nueve" generalizada a base B. El digest de un numero en base B se
 * calcula sumando sus digitos y restando B-1 cuando la suma acumulada
 * es >= B-1. Se verifica: digest(D) == digest(d)*digest(c) + digest(r)
 * reducido de nuevo.
 *
 * Numeros de hasta un millon de digitos, se leen como String y se
 * procesan como char[] sin BigInteger.
 */
public class PruebaNueveBaseN {
    public static int digest(String numero, int base) {
        int suma = 0;
        for (int i = 0; i < numero.length(); i++) {
            suma += valorDigito(numero.charAt(i));
            while (suma >= base - 1) {
                suma -= base - 1;
            }
        }
        return suma;
    }

    public static int valorDigito(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        return c - 'A' + 10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = Integer.parseInt(sc.nextLine().trim());

        for (int caso = 0; caso < numCasos; caso++) {
            String[] partes = sc.nextLine().trim().split("\\s+");
            int base = Integer.parseInt(partes[0]);
            String D = partes[1];
            String d = partes[2];
            String c = partes[3];
            String r = partes[4];

            int digestD = digest(D, base);
            int digestd = digest(d, base);
            int digestc = digest(c, base);
            int digestr = digest(r, base);

            int rhs = digestd * digestc + digestr;
            while (rhs >= base - 1) {
                rhs -= base - 1;
            }

            if (digestD == rhs) {
                System.out.println("POSIBLEMENTE CORRECTO");
            } else {
                System.out.println("INCORRECTO");
            }
        }

        sc.close();
    }
}
