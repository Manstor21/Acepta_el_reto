import java.util.Scanner;

public class TrenDelAmor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String tren = sc.nextLine();
            if (tren.isEmpty()) {
                continue;
            }
            int parejas = 0;
            int hombresAltos = 0;
            int hombresBajos = 0;
            for (char c : tren.toCharArray()) {
                switch (c) {
                    case 'H': // Hombre alto sin emparejar
                        hombresAltos++;
                        break;
                    case 'h': // Hombre bajo sin emparejar
                        hombresBajos++;
                        break;
                    case 'M': // Mujer alta: solo le interesa un hombre alto
                        if (hombresAltos > 0) {
                            hombresAltos--;
                            parejas++;
                        }
                        break;
                    case 'm': // Mujer baja: solo le interesa un hombre bajo
                        if (hombresBajos > 0) {
                            hombresBajos--;
                            parejas++;
                        }
                        break;
                    case '@': // Mercancia bloqueante: los hombres no avanzan mas
                        hombresAltos = 0;
                        hombresBajos = 0;
                        break;
                    default: // Otras mercancias: se saltan sin efecto
                        break;
                }
            }
            System.out.println(parejas);
        }
        sc.close();
    }
}