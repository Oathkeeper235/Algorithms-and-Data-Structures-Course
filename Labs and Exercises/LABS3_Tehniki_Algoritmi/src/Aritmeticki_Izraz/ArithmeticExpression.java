package Aritmeticki_Izraz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    Даден е некој аритметички израз. Аритметичкиот израз е во облик (A+B) или (A-B)
    каде што А и B истовремено се други аритметички изрази или цифри од 0-9.
    Потребно е да го евалуирате дадениот израз.
*/

public class ArithmeticExpression {

    static int odrediZnak(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
        }
        return -1;
    }

    static char[] infixVoPostfix(char[] c, int l, int r) {

        String rezultat = new String("");

        Stack<Character> stack = new Stack<>();

        for (int i = l; i < r; i++) {

            if (Character.isLetterOrDigit(c[i]))
                rezultat += c[i];
            else if (c[i] == '(')
                stack.push(c[i]);
            else if (c[i] == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    rezultat += stack.pop();
                    stack.pop();
                }
            } else {
                while (!stack.isEmpty() && odrediZnak(c[i]) <= odrediZnak(stack.peek())) {
                    rezultat += stack.pop();
                }
                stack.push(c[i]);
            }
        }

        while (!stack.isEmpty()) {
            rezultat += stack.pop();
        }

        return rezultat.toCharArray();
    }


    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char[] c, int l, int r) {
        // Vasiot kod tuka

        Stack<Integer> stack = new Stack<>();

        for (int i = l; i < r; i++) {

            char ch = c[i];

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char[] exp = expression.toCharArray();
        char[] temp = infixVoPostfix(exp, 0, exp.length - 1);

        int rez = presmetaj(temp, 0, temp.length - 1);
        System.out.println(rez);

        br.close();

    }

}
