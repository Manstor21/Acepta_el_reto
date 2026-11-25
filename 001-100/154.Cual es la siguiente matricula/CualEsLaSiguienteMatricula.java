import java.util.Scanner;

public class CualEsLaSiguienteMatricula {
    // Vocales y Ñ estan excluidas de las matriculas, por eso no estan aqui
    private static final String LETRAS = "BCDFGHJKLMNPQRSTVWXYZ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String numero = sc.next();
            String letras = sc.next();
            if (numero.equals("9999") && letras.equals("ZZZ")) {
                break;
            }
            int n = Integer.parseInt(numero);
            if (n < 9999) {
                n++;
            } else {
                n = 0;
                char[] letrasMatricula = letras.toCharArray();
                int i = letrasMatricula.length - 1;
                while (i >= 0) {
                    int posicion = LETRAS.indexOf(letrasMatricula[i]) + 1;
                    if (posicion < LETRAS.length()) {
                        letrasMatricula[i] = LETRAS.charAt(posicion);
                        break;
                    }
                    // Z vuelve a B y el incremento pasa a la letra anterior
                    letrasMatricula[i] = LETRAS.charAt(0);
                    i--;
                }
                letras = new String(letrasMatricula);
            }
            System.out.printf("%04d %s%n", n, letras);
        }
        sc.close();
    }
}
