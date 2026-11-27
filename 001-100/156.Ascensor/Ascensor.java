import java.util.Scanner;

public class Ascensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                continue;
            }
            String[] partes = linea.split("\\s+");
            int primero = Integer.parseInt(partes[0]);
            if (primero < 0) {
                break;
            }
            // -1 cierra la lista de parejas de esta linea
            int actual = primero;
            long recorrido = 0;
            int i = 1;
            while (i < partes.length) {
                int origen = Integer.parseInt(partes[i++]);
                if (origen == -1) {
                    break;
                }
                int destino = Integer.parseInt(partes[i++]);
                // Primero va a recoger a quien llama y despues al destino
                recorrido += Math.abs(origen - actual) + Math.abs(destino - origen);
                actual = destino;
            }
            System.out.println(recorrido);
        }
        sc.close();
    }
}
