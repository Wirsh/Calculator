import actions.Addiction;
import actions.Division;
import actions.Multiply;
import actions.Substraction;

import java.util.Stack;

public class ExpressionConverter {

    public static int getPriority(char action) {

        if (action == '*' || action == '/') {
            return 3;
        } else if (action == '+' || action == '-') {
            return 2;
        } else if (action == '(') {
            return 1;

        } else if (action == ')') {
            return -1;
        } else return 0;

    }

    public static String exprToRpn(String expr) {
        String rpn = "";
        Stack<Character> stringStack = new Stack<>();
        int priority;
        for (int i = 0; i < expr.length(); i++) {

            priority = getPriority(expr.charAt(i));

            if (priority == 0) {
                rpn += expr.charAt(i);
            } else if (priority == 1) {
                stringStack.push(expr.charAt(i));

            } else if (priority > 1) {
                rpn += " ";
                while (!stringStack.empty()) {

                    if (getPriority(stringStack.peek()) >= priority) {
                        rpn += stringStack.pop();
                    } else break;

                }
                stringStack.push(expr.charAt(i));
            } else if (priority == -1) {
                rpn += " ";
                while (getPriority(stringStack.peek()) != 1) {
                    rpn += stringStack.pop();
                }
                stringStack.pop();
            }

        }
        while (!stringStack.empty()) {

            rpn += " " + stringStack.pop();
        }


        return rpn;
    }

    public static Double rpnToAnswer(String rpn) {

        String operand = "";
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < rpn.length(); i++) {
            if (rpn.charAt(i) == ' ') {
                continue;
            } else if (getPriority(rpn.charAt(i)) == 0) {
                while (rpn.charAt(i) != ' ') {
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(operand));
                operand="";
            } else if (getPriority(rpn.charAt(i))>1) {
                double a =stack.pop();
                double b =stack.pop();
                char ch= rpn.charAt(i);
                switch (ch){
                    case '+' : stack.push(new Addiction().invoke(b,a)); break;
                    case '-' : stack.push(new Substraction().invoke(b,a)); break;
                    case '*' : stack.push(new Multiply().invoke(b,a)); break;
                    case '/' : stack.push(new Division().invoke(b,a)); break;
                }
            }
        }
        return stack.pop();
    }
}
