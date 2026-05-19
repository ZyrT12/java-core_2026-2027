package Lab3;

public class Example5Dop {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Последовательность обхода дерева рекурсивных вызовов для fib " + n + ":");
        int result = fact(n, 0);
        System.out.println("Результат: " + result);
    }

    public static int fact(int n, int step) {
        space(step);
        System.out.println("fib " + n + " -->");

        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            result = fact(n - 2, step + 1) + fact(n - 1, step + 1);
        }

        space(step);
        System.out.println("fib " + n + " <-- " + result);
        return result;
    }

    public static void space(int step) {
        for (int i = 0; i < step; i++) {
            System.out.print(" ");
        }
    }
}
