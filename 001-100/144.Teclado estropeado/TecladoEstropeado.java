import java.util.Scanner;

public class TecladoEstropeado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int cursor = 0;
            for (char c : linea.toCharArray()) {
                switch (c) {
                    case '-': // Inicio: cursor al principio
                        cursor = 0;
                        break;
                    case '+': // Fin: cursor al final
                        cursor = sb.length();
                        break;
                    case '*': // Flecha derecha
                        if (cursor < sb.length()) {
                            cursor++;
                        }
                        break;
                    case '3': // Supr: borra la letra a la derecha del cursor
                        if (cursor < sb.length()) {
                            sb.deleteCharAt(cursor);
                        }
                        break;
                    default: // Insertar el caracter en la posicion del cursor
                        sb.insert(cursor, c);
                        cursor++;
                        break;
                }
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}