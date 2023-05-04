package ModifiedXML;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class CheckXML {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();

        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni

        Stack<String> stack = new Stack<String>();
        int valid = 1;

        for (int i = 0; i < n; i++) {
            if (redovi[i].charAt(0) == '[') {
                if (redovi[i].charAt(1) != '/')
                    stack.push(redovi[i]);
                else {
                    String tag = stack.pop();
                    tag = tag.substring(1, tag.length() - 1);
                    String comparator = redovi[i].substring(2, redovi[i].length() - 1);

                    if (!tag.equals(comparator)) {
                        valid = 0;
                        break;
                    }
                }
            }
        }

        System.out.println(valid);

        br.close();
    }
}