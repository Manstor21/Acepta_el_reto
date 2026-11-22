import java.util.Scanner;

public class CampoDeMinas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int ancho = sc.nextInt();
            int alto = sc.nextInt();
            if (ancho == 0 && alto == 0) {
                break;
            }

            String[] tablero = new String[alto];
            for (int i = 0; i < alto; i++) {
                tablero[i] = sc.next();
            }

            int total = 0;
            for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                    if (tablero[i].charAt(j) == '*') {
                        continue;
                    }
                    int minas = 0;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            if (di == 0 && dj == 0) {
                                continue;
                            }
                            int ni = i + di;
                            int nj = j + dj;
                            if (ni >= 0 && ni < alto && nj >= 0 && nj < ancho
                                    && tablero[ni].charAt(nj) == '*') {
                                minas++;
                            }
                        }
                    }
                    // Seis minas alrededor hacen insegura la casilla
                    if (minas >= 6) {
                        total++;
                    }
                }
            }
            System.out.println(total);
        }
    }
}
