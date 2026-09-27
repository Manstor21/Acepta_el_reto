import java.util.Scanner;
import java.util.Stack;

public class ParentesisBalanceados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            if (linea.isEmpty()) {
                continue;
            }
            System.out.println(balanceado(linea) ? "YES" : "NO");
        }
        sc.close();
    }

    static boolean balanceado(String linea) {
        Stack<Character> pila = new Stack<>();
        for (char c : linea.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    pila.push(c);
                    break;
                case ')':
                    if (pila.isEmpty() || pila.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (pila.isEmpty() || pila.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (pila.isEmpty() || pila.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    // Cualquier otro simbolo se ignora
                    break;
            }
        }
        return pila.isEmpty();
    }
}