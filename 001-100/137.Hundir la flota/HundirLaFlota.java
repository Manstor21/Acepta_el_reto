import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HundirLaFlota {
    static int tam;
    static int[][] tablero;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] esperados = new int[n];
            for (int i = 0; i < n; i++) {
                esperados[i] = sc.nextInt();
            }
            tam = sc.nextInt();
            tablero = new int[tam][tam];
            for (int i = 0; i < tam; i++) {
                for (int j = 0; j < tam; j++) {
                    tablero[i][j] = sc.nextInt();
                }
            }
            System.out.println(esCorrecto(esperados) ? "SI" : "NO");
        }
        sc.close();
    }

    static boolean esCorrecto(int[] esperados) {
        // 1) Barcos no pueden tocarse ni en diagonal, ni formar esquinas en L
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (tablero[i][j] == 1) {
                    // Diagonal hacia abajo-derecha y abajo-izquierda (cada par se mira una vez)
                    if (i + 1 < tam && j + 1 < tam && tablero[i + 1][j + 1] == 1) {
                        return false;
                    }
                    if (i + 1 < tam && j - 1 >= 0 && tablero[i + 1][j - 1] == 1) {
                        return false;
                    }
                    // Esquina: barco a la derecha Y barco abajo al mismo tiempo -> L invalida
                    boolean derecha = j + 1 < tam && tablero[i][j + 1] == 1;
                    boolean abajo = i + 1 < tam && tablero[i + 1][j] == 1;
                    if (derecha && abajo) {
                        return false;
                    }
                }
            }
        }

        // 2) Contar componentes conexas (los barcos reales) y sus longitudes
        List<Integer> longitudes = new ArrayList<>();
        boolean[][] visitado = new boolean[tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (tablero[i][j] == 1 && !visitado[i][j]) {
                    int[] len = new int[1];
                    dfs(i, j, visitado, len);
                    longitudes.add(len[0]);
                }
            }
        }

        if (longitudes.size() != esperados.length) {
            return false;
        }
        int[] reales = new int[longitudes.size()];
        for (int k = 0; k < longitudes.size(); k++) {
            reales[k] = longitudes.get(k);
        }
        Arrays.sort(reales);
        Arrays.sort(esperados);
        return Arrays.equals(reales, esperados);
    }

    static void dfs(int i, int j, boolean[][] visitado, int[] len) {
        if (i < 0 || i >= tam || j < 0 || j >= tam) {
            return;
        }
        if (tablero[i][j] != 1 || visitado[i][j]) {
            return;
        }
        visitado[i][j] = true;
        len[0]++;
        dfs(i + 1, j, visitado, len);
        dfs(i - 1, j, visitado, len);
        dfs(i, j + 1, visitado, len);
        dfs(i, j - 1, visitado, len);
    }
}