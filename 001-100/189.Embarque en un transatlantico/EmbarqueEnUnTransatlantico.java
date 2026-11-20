import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

/*
 * Problema 189 - Embarque en un transatlántico
 *
 * Un árbol Fenwick mantiene qué posiciones originales siguen en la cola.
 * Por cada cubierta se guardan las posiciones donde aparece, de modo que
 * un EMBARQUE sólo toca sus propias casillas (cada una se borra una vez).
 * Una búsqueda binaria sobre el Fenwick responde las CONSULTA.
 */
public class EmbarqueEnUnTransatlantico {
    static class IntList {
        int[] datos = new int[4];
        int tam = 0;

        void add(int v) {
            if (tam == datos.length) datos = Arrays.copyOf(datos, datos.length * 2);
            datos[tam++] = v;
        }
    }

    static int[] arbol;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder salida = new StringBuilder();

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) break;

            arbol = new int[n + 1];
            for (int i = 1; i <= n; i++) arbol[i] = 1;
            for (int i = 1; i <= n; i++) {
                int j = i + (i & -i);
                if (j <= n) arbol[j] += arbol[i];
            }

            int[] cubierta = new int[n];
            boolean[] enCola = new boolean[n];
            HashMap<Integer, IntList> porCubierta = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int c = sc.nextInt();
                cubierta[i] = c;
                enCola[i] = true;
                IntList lista = porCubierta.get(c);
                if (lista == null) {
                    lista = new IntList();
                    porCubierta.put(c, lista);
                }
                lista.add(i); // posición 0-based
            }

            int restantes = n;
            int acciones = sc.nextInt();
            for (int a = 0; a < acciones; a++) {
                String accion = sc.next();
                int valor = sc.nextInt();
                if (accion.equals("EMBARQUE")) {
                    IntList lista = porCubierta.get(valor);
                    if (lista != null) {
                        for (int k = 0; k < lista.tam; k++) {
                            int i = lista.datos[k];
                            if (enCola[i]) {
                                enCola[i] = false;
                                add(i + 1, -1); // Fenwick es 1-based
                                restantes--;
                            }
                        }
                    }
                    salida.append(restantes).append('\n');
                } else { // CONSULTA
                    salida.append(cubierta[kth(valor) - 1]).append('\n');
                }
            }
            salida.append("*\n");
        }

        System.out.print(salida);
        sc.close();
    }

    static void add(int i, int delta) {
        while (i < arbol.length) {
            arbol[i] += delta;
            i += i & -i;
        }
    }

    static int kth(int k) {
        int idx = 0;
        for (int paso = Integer.highestOneBit(arbol.length - 1); paso != 0; paso >>= 1) {
            int sig = idx + paso;
            if (sig < arbol.length && arbol[sig] < k) {
                idx = sig;
                k -= arbol[sig];
            }
        }
        return idx + 1;
    }
}
