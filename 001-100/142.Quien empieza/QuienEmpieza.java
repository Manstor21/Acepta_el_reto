import java.util.Scanner;

public class QuienEmpieza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int ninos = sc.nextInt();
            int saltos = sc.nextInt();
            if (ninos == 0 && saltos == 0) {
                break;
            }
            // Josephus: cada ronda se elimina al (saltos+1)-esimo desde el actual
            int k = saltos + 1;
            int superviviente = 0; // indice 0 cuando queda 1 nino
            for (int i = 2; i <= ninos; i++) {
                superviviente = (superviviente + k) % i;
            }
            System.out.println(superviviente + 1);
        }
        sc.close();
    }
}