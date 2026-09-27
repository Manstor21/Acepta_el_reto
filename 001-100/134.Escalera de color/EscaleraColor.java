import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EscaleraColor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String primera = sc.next();
            if (primera.equals("0")) {
                break;
            }
            char palo = sc.next().charAt(0);

            Carta[] mano = new Carta[4];
            mano[0] = new Carta(primera, palo);
            for (int i = 1; i < 4; i++) {
                String valor = sc.next();
                char p = sc.next().charAt(0);
                mano[i] = new Carta(valor, p);
            }

            // Todas las cartas deben ser del mismo palo
            boolean mismoPalo = true;
            for (Carta c : mano) {
                if (c.palo != palo) {
                    mismoPalo = false;
                }
            }
            if (!mismoPalo) {
                System.out.println("NADA");
                continue;
            }

            // Asi solo puede ir al final (despues de K), valor 14
            // Buscar la escalera de color MAS ALTA posible: probamos desde
            // A-K-Q-J-10 hacia abajo y nos quedamos con la primera que encaje.
            String resultado = "NADA";
            for (int inicio = 10; inicio >= 2; inicio--) {
                List<Integer> escalera = new ArrayList<>();
                for (int v = inicio; v < inicio + 5; v++) {
                    escalera.add(v);
                }

                boolean cubierta = true;
                for (Carta c : mano) {
                    if (!escalera.contains(c.valor)) {
                        cubierta = false;
                        break;
                    }
                }
                if (!cubierta) {
                    continue;
                }

                // La carta que falta es la unica de la escalera no presente en la mano
                List<Integer> presentes = new ArrayList<>();
                for (Carta c : mano) {
                    presentes.add(c.valor);
                }
                for (Integer v : escalera) {
                    if (presentes.indexOf(v) == -1) {
                        resultado = Carta.textoValor(v) + " " + palo;
                        break;
                    }
                }
                break;
            }

            System.out.println(resultado);
        }
    }

    static class Carta {
        int valor;      // 2..14 (A = 14)
        char palo;      // P, D, T, C

        Carta(String texto, char palo) {
            this.valor = valorDe(texto);
            this.palo = palo;
        }

        static int valorDe(String s) {
            switch (s) {
                case "J": return 11;
                case "Q": return 12;
                case "K": return 13;
                case "A": return 14;
                default:  return Integer.parseInt(s);
            }
        }

        static String textoValor(int v) {
            switch (v) {
                case 11: return "J";
                case 12: return "Q";
                case 13: return "K";
                case 14: return "A";
                default:  return String.valueOf(v);
            }
        }
    }
}