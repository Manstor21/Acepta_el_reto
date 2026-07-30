import java.util.*;

/*
 * Problema 109 - Liga de padel
 *
 * Tenemos una liga donde cada victoria da 2 puntos y cada
 * derrota da 1 punto. Si no se juega un partido, da 0.
 * Cada pareja juega contra todas las demas dos veces (ida y
 * vuelta). Las no-asistencias no aparecen en la entrada.
 *
 * Para cada categoria, hay que decir la pareja ganadora
 * (o EMPATE) y el numero de partidos no jugados.
 */
public class Padel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String categoria = sc.nextLine();
            if (categoria.equals("FIN")) break;

            Map<String, int[]> puntos = new HashMap<>();
            int partidosJugados = 0;

            while (sc.hasNext()) {
                String linea = sc.nextLine();
                if (linea.equals("FIN")) break;

                String[] partes = linea.split(" ");
                String local = partes[0];
                int setsLocal = Integer.parseInt(partes[1]);
                String visitante = partes[2];
                int setsVisit = Integer.parseInt(partes[3]);

                partidosJugados++;

                // Registrar equipos
                if (!puntos.containsKey(local))
                    puntos.put(local, new int[]{0, 0}); // pts, partidos
                if (!puntos.containsKey(visitante))
                    puntos.put(visitante, new int[]{0, 0});

                if (setsLocal > setsVisit) {
                    puntos.get(local)[0] += 2;
                    puntos.get(visitante)[0] += 1;
                } else {
                    puntos.get(visitante)[0] += 2;
                    puntos.get(local)[0] += 1;
                }
            }

            int numEquipos = puntos.size();
            int partidosPosibles = numEquipos * (numEquipos - 1);
            int noJugados = partidosPosibles - partidosJugados;

            // Buscar ganador
            String ganador = null;
            int maxPts = -1;
            boolean empate = false;

            for (Map.Entry<String, int[]> e : puntos.entrySet()) {
                int pts = e.getValue()[0];
                if (pts > maxPts) {
                    maxPts = pts;
                    ganador = e.getKey();
                    empate = false;
                } else if (pts == maxPts) {
                    empate = true;
                }
            }

            if (empate) {
                System.out.println("EMPATE " + noJugados);
            } else {
                System.out.println(ganador + " " + noJugados);
            }
        }
        sc.close();
    }
}
