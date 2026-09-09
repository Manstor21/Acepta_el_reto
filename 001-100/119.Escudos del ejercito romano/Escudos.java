import java.util.Scanner;

/*
 * Problema 119 - Escudos del ejercito romano
 *
 * El general forma el cuadrado MAS GRANDE posible con sus legionarios
 * y repite con los sobrantes hasta no dejar ninguno. Para cada formacion
 * cuadrada de lado k:
 *   - legionarios interiores (no en el borde): 1 escudo cada uno
 *   - legionarios en el flanco pero NO en esquina: 2 escudos cada uno
 *   - legionarios en esquina: 3 escudos cada uno
 * Una formacion de 1 solo legionario (1x1) necesita 5 escudos.
 *
 * Se pide el numero total minimo de escudos necesarios.
 *
 * Para una formacion de lado k: 4 esquinas (3) + 4*(k-2) flanco-no-esquina
 * (2) + (k-2)^2 interiores (1). Total = 12 + 8*(k-2) + (k-2)^2, salvo el
 * caso k = 1 que vale 5.
 */
public class Escudos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while (n != 0) {
            long escudos = 0;
            while (n > 0) {
                int k = (int) Math.sqrt(n);
                // Si no se formara un cuadrado perfecto, k^2 <= n siempre.
                escudos += escudosFormacion(k);
                n -= k * k;
            }
            System.out.println(escudos);
            n = sc.nextInt();
        }

        sc.close();
    }

    // Escudos que necesita una formacion cuadrada de lado k.
    private static long escudosFormacion(int k) {
        if (k == 1) return 5;
        int interior = k - 2;
        return 12 + 8L * interior + (long) interior * interior;
    }
}
