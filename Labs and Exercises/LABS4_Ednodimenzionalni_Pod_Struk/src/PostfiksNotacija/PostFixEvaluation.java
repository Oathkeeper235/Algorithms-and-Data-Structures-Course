package PostfiksNotacija;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class PostFixEvaluation {

    static int evaluirajPostFix(char[] c) {

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < c.length; i++) {

            char ch = c[i];

            if (ch == ' ')
                continue;

            else if (Character.isDigit(ch)) {
                int n = 0;

                while (Character.isDigit(ch)) {
                    n = n * 10 + (int) (ch - '0');
                    i++;
                    ch = c[i];
                }
                i--;

                stack.push(n);

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
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char[] exp = expression.toCharArray();

        br.close();

        System.out.println(evaluirajPostFix(exp));
    }
}
