import java.util.Scanner;

public class ElPanEnLasBodas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();

            if (linea.isEmpty()) {
                continue;
            }

            String[] partes = linea.split("\\s+");
            if (Integer.parseInt(partes[0]) == 0) {
                break;
            }

            String configuracion = partes.length > 1 ? partes[1] : "";

            // En una mesa circular, para que todos coman todos deben elegir
            // el mismo lado: si aparece al menos una I y una D, siempre hay
            // dos comensales que se disputan la misma barrita.
            boolean hayIzquierda = configuracion.indexOf('I') >= 0;
            boolean hayDerecha = configuracion.indexOf('D') >= 0;

            System.out.println(hayIzquierda && hayDerecha ? "ALGUNO NO COME" : "TODOS COMEN");
        }
    }
}
