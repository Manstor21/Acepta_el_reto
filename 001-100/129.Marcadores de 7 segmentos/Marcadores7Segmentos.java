import java.util.Scanner;

/*
 * Problema 129 - Marcadores de 7 segmentos
 *
 * Un cartel con digitos de 7 segmentos muestra un mensaje que entra
 * desde la derecha y sale por la izquierda. Se cuenta el numero total
 * de cambios de estado (encendidos + apagados) de los LEDs durante
 * todo el proceso, desde todo apagado hasta todo apagado.
 *
 * Cada digito se modela como un bitmask de 7 bits (segmentos a-g).
 * Cada posicion del marcador ve pasar el mensaje completo: vacio, luego
 * los W digitos en orden, luego vacio. El coste por posicion es
 * popcount(m0) + sum popcount(m_{i-1}^m_i) + popcount(m_{W-1}), y el
 * total es ese coste por las W posiciones.
 */
public class Marcadores7Segmentos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] segmentos = {0x3F, 0x06, 0x5B, 0x4F, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F};

        while (sc.hasNext()) {
            int primero = sc.nextInt();
            if (primero == -1) break;

            int[] mensaje = new int[64];
            mensaje[0] = primero;
            int longitud = 1;
            while (true) {
                int val = sc.nextInt();
                if (val == -1) break;
                if (longitud == mensaje.length) {
                    int[] nuevo = new int[mensaje.length * 2];
                    System.arraycopy(mensaje, 0, nuevo, 0, longitud);
                    mensaje = nuevo;
                }
                mensaje[longitud++] = val;
            }

            int W = longitud;
            long cambiosPorPosicion = Integer.bitCount(segmentos[mensaje[0]]);
            for (int i = 1; i < W; i++) {
                cambiosPorPosicion += Integer.bitCount(segmentos[mensaje[i - 1]] ^ segmentos[mensaje[i]]);
            }
            cambiosPorPosicion += Integer.bitCount(segmentos[mensaje[W - 1]]);

            System.out.println((long) W * cambiosPorPosicion);
        }

        sc.close();
    }
}
