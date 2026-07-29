import java.util.Locale;
import java.util.Scanner;

/*
 * Problema 108 - De nuevo en el bar de Javier
 *
 * Javier registra las ventas de su bar por categorias:
 *   D - Desayunos, A - Comidas, M - Meriendas, I - Cenas, C - Copas
 *
 * Cada dia termina cuando aparece "N 0". Para cada dia hay que
 * determinar la categoria que mas y menos recaudo, y si la media
 * de las comidas supera la media general del dia.
 *
 * Las categorias que no aparecen tienen recaudacion 0.
 */
public class BarJavier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        String[] nombres = {"DESAYUNOS", "COMIDAS", "MERIENDAS", "CENAS", "COPAS"};

        while (sc.hasNext()) {
            double[] totales = new double[5];
            int[] cuentas = new int[5];
            boolean diaActivo = true;

            while (diaActivo && sc.hasNext()) {
                String cat = sc.next();
                double valor = sc.nextDouble();

                if (cat.equals("N")) {
                    diaActivo = false;
                } else {
                    int idx = indiceCategoria(cat);
                    if (idx >= 0) {
                        totales[idx] += valor;
                        cuentas[idx]++;
                    }
                }
            }

            if (!diaActivo) {
                // Calcular media general (solo las ventas registradas)
                double sumaTotal = 0;
                int ventasTotales = 0;
                for (int i = 0; i < 5; i++) {
                    sumaTotal += totales[i];
                    ventasTotales += cuentas[i];
                }
                double mediaGeneral = ventasTotales > 0 ? sumaTotal / ventasTotales : 0;
                double mediaComidas = cuentas[1] > 0 ? totales[1] / cuentas[1] : 0;

                // Buscar maximo y minimo entre los totales
                double max = totales[0], min = totales[0];
                for (int i = 1; i < 5; i++) {
                    if (totales[i] > max) max = totales[i];
                    if (totales[i] < min) min = totales[i];
                }

                // Contar cuantos tienen el maximo y el minimo
                int cuantosMax = 0, cuantosMin = 0;
                for (int i = 0; i < 5; i++) {
                    if (totales[i] == max) cuantosMax++;
                    if (totales[i] == min) cuantosMin++;
                }

                String catMax = cuantosMax == 1 ? nombres[indiceDeValor(totales, max)] : "EMPATE";
                String catMin = cuantosMin == 1 ? nombres[indiceDeValor(totales, min)] : "EMPATE";

                System.out.println(catMax + "#" + catMin + "#" + (mediaComidas > mediaGeneral ? "SI" : "NO"));
            }
        }
        sc.close();
    }

    static int indiceCategoria(String c) {
        switch (c) {
            case "D": return 0;
            case "A": return 1;
            case "M": return 2;
            case "I": return 3;
            case "C": return 4;
            default: return -1;
        }
    }

    static int indiceDeValor(double[] arr, double valor) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valor) return i;
        }
        return -1;
    }
}
