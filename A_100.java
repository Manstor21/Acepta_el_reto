package aceptaelreto;

import java.util.Scanner;

public class A_100 {

    final static int const_kaprekar = 6174;

    public static int invertirNumero(int numero) {
        int numero_inv = 0;
        while (numero > 0) {
            int digito = numero % 10;
            numero_inv = (numero_inv * 10) + digito;
            numero = numero / 10;
        }
        return numero_inv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_cas = 0;
        int numero = 0;
        int contador = 0;
        
        num_cas = sc.nextInt();
        boolean kaprekar = false;
        for (int i = 0; i < num_cas; i++) {
            numero = sc.nextInt();
            if (numero > invertirNumero(numero)) {
                numero = numero - invertirNumero(numero);
                contador++;
                if (numero == const_kaprekar) {
                    System.out.println(contador);
                }
            } else {
                numero = invertirNumero(numero) - numero;
                contador++;
                if (numero == const_kaprekar) {
                    System.out.println(contador);
                }
            }
        }
    }
}
