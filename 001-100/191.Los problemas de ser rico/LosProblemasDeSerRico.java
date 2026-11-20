import java.util.Scanner;

/*
 * Problema 191 - Los problemas de ser rico
 *
 * Los compartimentos forman una progresión aritmética decreciente:
 * capacidad, capacidad - diferencia, capacidad - 2*diferencia, ...
 */
public class LosProblemasDeSerRico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int casos = sc.nextInt();

        for (int c = 0; c < casos; c++) {
            long compartimentos = sc.nextLong();
            long capacidad = sc.nextLong();
            long diferencia = sc.nextLong();
            long total = compartimentos * capacidad
                    - diferencia * compartimentos * (compartimentos - 1) / 2;
            System.out.println(total);
        }

        sc.close();
    }
}
