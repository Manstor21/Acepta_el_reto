import java.util.Scanner;

/*
 * Problema 111 - Aprobar quimica
 *
 * Configuracion electronica segun el diagrama de Moeller.
 *
 * Orden de llenado: 1s 2s 2p 3s 3p 4s 3d 4p 5s 4d 5p 6s 4f
 *                   5d 6p 7s 5f 6d 7p
 *
 * Capacidad de cada orbital: s=2, p=6, d=10, f=14
 *
 * Para Z=0 escribimos 1s0.
 */
public class Quimica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] orden = {"1s", "2s", "2p", "3s", "3p", "4s", "3d", "4p",
                          "5s", "4d", "5p", "6s", "4f", "5d", "6p", "7s",
                          "5f", "6d", "7p"};
        int[] capacidad = {2, 2, 6, 2, 6, 2, 10, 6,
                           2, 10, 6, 2, 14, 10, 6, 2,
                           14, 10, 6};

        while (sc.hasNext()) {
            String nombre = sc.nextLine();
            if (nombre.equals("Exit")) break;
            int z = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (z == 0) {
                System.out.println("1s0");
                continue;
            }

            StringBuilder sb = new StringBuilder();
            int restantes = z;

            for (int i = 0; i < orden.length && restantes > 0; i++) {
                int electrones = Math.min(restantes, capacidad[i]);
                sb.append(orden[i]).append(electrones).append(" ");
                restantes -= electrones;
            }

            System.out.println(sb.toString().trim());
        }
        sc.close();
    }
}
