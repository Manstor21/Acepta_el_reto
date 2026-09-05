import java.util.Scanner;

/*
 * Problema 123 - Conjugar verbos
 *
 * Se pide conjugar un verbo regular en un tiempo dado (A = presente,
 * P = preterito perfecto simple, F = futuro). El verbo puede llevar
 * mayusculas en medio; la conjugacion se determina por las DOS ULTIMAS
 * letras en minuscula (-ar, -er, -ir), pero se conservan las mayusculas
 * del verbo original en la salida.
 *
 * Se muestran 6 lineas (yo, tu, el, nosotros, vosotros, ellos). Nuestro
 * programa no pone tildes y la primera letra de cada linea va en minuscula.
 */
public class ConjugarVerbos {
    private static final String[] PRONOMBRES =
        {"yo ", "tu ", "el ", "nosotros ", "vosotros ", "ellos "};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String verbo = sc.next();
            String tiempo = sc.next();
            if (tiempo.equals("T")) break;

            String raiz = verbo.substring(0, verbo.length() - 2);
            String terminacion = verbo.substring(verbo.length() - 2).toLowerCase();

            String[] sufijos = sufijos(terminacion, tiempo);
            for (int i = 0; i < 6; i++) {
                System.out.println(PRONOMBRES[i] + raiz + sufijos[i]);
            }
        }

        sc.close();
    }

    // Devuelve los 6 sufijos segun la terminacion y el tiempo.
    private static String[] sufijos(String terminacion, String tiempo) {
        switch (terminacion) {
            case "ar":
                switch (tiempo) {
                    case "A": return new String[] {"o", "as", "a", "amos", "ais", "an"};
                    case "P": return new String[] {"e", "aste", "o", "amos", "asteis", "aron"};
                    default:  return new String[] {"are", "aras", "ara", "aremos", "areis", "aran"};
                }
            case "er":
                switch (tiempo) {
                    case "A": return new String[] {"o", "es", "e", "emos", "eis", "en"};
                    case "P": return new String[] {"i", "iste", "io", "imos", "isteis", "ieron"};
                    default:  return new String[] {"ere", "eras", "era", "eremos", "ereis", "eran"};
                }
            default: // ir
                switch (tiempo) {
                    case "A": return new String[] {"o", "es", "e", "imos", "is", "en"};
                    case "P": return new String[] {"i", "iste", "io", "imos", "isteis", "ieron"};
                    default:  return new String[] {"ire", "iras", "ira", "iremos", "ireis", "iran"};
                }
        }
    }
}
