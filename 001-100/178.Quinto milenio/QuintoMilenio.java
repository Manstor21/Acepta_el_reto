import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuintoMilenio {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String primera = br.readLine();
        while (primera != null && primera.trim().isEmpty()) {
            primera = br.readLine();
        }
        int casos = Integer.parseInt(primera.trim());

        StringBuilder salida = new StringBuilder();
        for (int c = 0; c < casos; c++) {
            String titular = br.readLine().toLowerCase();
            String mensaje = br.readLine().replace(" ", "").toLowerCase();

            int pos = 0;
            for (int i = 0; i < titular.length() && pos < mensaje.length(); i++) {
                if (titular.charAt(i) == mensaje.charAt(pos)) {
                    pos++;
                }
            }
            salida.append(pos == mensaje.length() ? "SI" : "NO").append('\n');
        }
        System.out.print(salida);
    }
}
