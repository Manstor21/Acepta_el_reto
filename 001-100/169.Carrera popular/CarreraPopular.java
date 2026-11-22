import java.util.Scanner;

/*
 * Los apellidos llegan agrupados y con mayusculas erraticas,
 * basta con mirar rachas consecutivas ignorando el caso.
 * "====" separa casos, no es un participante.
 */
public class CarreraPopular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        sc.nextLine();

        for (int c = 0; c < casos; c++) {
            int participantes = 0;
            int conHermano = 0;
            String apellidoActual = null;
            int tamGrupo = 0;

            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();

                if (linea.isEmpty()) {
                    continue;
                }
                if (linea.equals("====")) {
                    break;
                }

                participantes++;
                int coma = linea.indexOf(',');
                String apellido = (coma >= 0 ? linea.substring(0, coma) : linea).trim();

                if (apellidoActual == null) {
                    apellidoActual = apellido;
                    tamGrupo = 1;
                } else if (apellido.equalsIgnoreCase(apellidoActual)) {
                    tamGrupo++;
                } else {
                    if (tamGrupo > 1) {
                        conHermano += tamGrupo;
                    }
                    apellidoActual = apellido;
                    tamGrupo = 1;
                }
            }

            if (tamGrupo > 1) {
                conHermano += tamGrupo;
            }

            System.out.println(participantes + " " + conHermano);
        }
    }
}
