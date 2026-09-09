import java.util.ArrayList;
import java.util.Scanner;

/*
 * Problema 127 - Una, dola, tela, catola...
 *
 * Variante de Josephus: un grupo en circulo se elimina cantando una cancion
 * de K palabras. La persona senalada en la ultima palabra queda eliminada y
 * el siguiente conteo empieza por la persona que sigue a la eliminada.
 *
 * Se repite hasta que queden tantas personas como camas. Las camas se
 * muestran en el orden original del circulo.
 */
public class Cantinela {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();

        while (casos-- > 0) {
            ArrayList<String> circulo = new ArrayList<String>();
            String nombre;
            while (!(nombre = sc.next()).equals("F")) {
                circulo.add(nombre);
            }
            int camas = sc.nextInt();
            int k = sc.nextInt();

            int n = circulo.size();
            if (camas >= n) {
                System.out.println("TODOS TIENEN CAMA");
            } else if (camas == 0) {
                System.out.println("NADIE TIENE CAMA");
            } else {
                int idx = 0;
                while (circulo.size() > camas) {
                    idx = (idx + k - 1) % circulo.size();
                    circulo.remove(idx);
                }
                for (int i = 0; i < circulo.size(); i++) {
                    if (i > 0) System.out.print(" ");
                    System.out.print(circulo.get(i));
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
