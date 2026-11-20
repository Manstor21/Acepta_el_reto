import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SudokusVacios {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        sc.nextLine();

        // Descartamos las lineas en blanco (las hay antes del primero y entre casos).
        List<String> lineas = new ArrayList<String>();
        while (sc.hasNextLine()) {
            String linea = sc.nextLine().trim();
            if (!linea.isEmpty()) {
                lineas.add(linea);
            }
        }

        int indice = 0;
        for (int c = 0; c < casos; c++) {
            String[] sudoku = new String[9];
            for (int i = 0; i < 9; i++) {
                sudoku[i] = lineas.get(indice++);
            }
            System.out.println(esValido(sudoku) ? "SI" : "NO");
        }
        sc.close();
    }

    private static boolean esValido(String[] sudoku) {
        int rellenas = 0;
        boolean simetrico = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boolean a = sudoku[i].charAt(j) != '-';
                boolean b = sudoku[8 - i].charAt(8 - j) != '-';
                if (a) {
                    rellenas++;
                }
                if (a != b) {
                    simetrico = false;
                }
            }
        }
        return simetrico && rellenas <= 32;
    }
}
