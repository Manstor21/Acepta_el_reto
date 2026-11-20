import java.util.Scanner;

public class PerimetroDeUnRectangulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            if (x < 0 || y < 0) {
                break;
            }
            System.out.println(2 * (x + y));
        }
        sc.close();
    }
}
