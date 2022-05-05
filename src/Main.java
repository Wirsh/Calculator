import actions.Division;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression :");
        System.out.println("Result is "+ExpressionConverter.rpnToAnswer(ExpressionConverter.exprToRpn(sc.nextLine())));

    }
}
