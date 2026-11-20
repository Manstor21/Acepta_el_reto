import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Queue;

public class EvaluandoExpresiones {

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // En ambas evaluaciones el primer valor extraido es el segundo operando.
    private static Integer evaluarPila(String expr) {
        Stack<Integer> pila = new Stack<Integer>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (!esOperador(c)) {
                pila.push(c - '0');
            } else {
                if (pila.size() < 2) {
                    return null;
                }
                int b = pila.pop();
                int a = pila.pop();
                Integer r = aplicar(c, a, b);
                if (r == null) {
                    return null;
                }
                pila.push(r);
            }
        }
        if (pila.size() != 1) {
            return null;
        }
        return pila.peek();
    }

    private static Integer evaluarCola(String expr) {
        Queue<Integer> cola = new ArrayDeque<Integer>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (!esOperador(c)) {
                cola.offer(c - '0');
            } else {
                if (cola.size() < 2) {
                    return null;
                }
                int b = cola.poll();
                int a = cola.poll();
                Integer r = aplicar(c, a, b);
                if (r == null) {
                    return null;
                }
                cola.offer(r);
            }
        }
        if (cola.size() != 1) {
            return null;
        }
        return cola.peek();
    }

    private static Integer aplicar(char op, int a, int b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return (b == 0) ? null : a / b;
            default: return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String expr = sc.nextLine().trim();
            if (expr.isEmpty()) {
                continue;
            }
            Integer p = evaluarPila(expr);
            Integer q = evaluarCola(expr);
            String sp = (p == null) ? "ERROR" : p.toString();
            String sq = (q == null) ? "ERROR" : q.toString();
            String cmp = (p == null && q == null)
                    || (p != null && q != null && p.equals(q)) ? "=" : "!=";
            System.out.println(sp + " " + cmp + " " + sq);
        }
        sc.close();
    }
}
