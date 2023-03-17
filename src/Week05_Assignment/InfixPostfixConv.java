package Week05_Assignment;
import java.util.Stack;

public class InfixPostfixConv {

    // Function to return precedence of operators
    private static int precedence(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    // Function that converts infix expression to postfix expression
    public static String infixPostfixConv(String infix) {
        // Just found out about 'StringBuilder'. Unlike 'String', it provides
        // a mutable succession of Characters.
        StringBuilder postfix = new StringBuilder();
        Stack<Character> infix_char = new Stack<>();

        for (int i = 0 ; i < infix.length() ; i++) {
            char ch = infix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
//                Test purposes
//                System.out.println(infix_char);
//                System.out.println(postfix);
            } else if (ch == '(') {
                infix_char.push(ch);
            } else if (ch == ')') {
                while (!infix_char.isEmpty() && infix_char.peek() != '(') {
                    postfix.append(infix_char.pop());
                }
                if (!infix_char.isEmpty() && infix_char.peek() != '(') {
                    return "Error, expression not balanced.";
//                    infix_char.pop();
                } else {
                    infix_char.pop();
            }
            } else {
                while (!infix_char.isEmpty() && precedence(ch) <= precedence(infix_char.peek())) {
                    postfix.append(infix_char.pop());
                }
                infix_char.push(ch);
            }
        }
        while (!infix_char.isEmpty()) {
            postfix.append(infix_char.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "a+(b^c)*d-e";
        String postfix = infixPostfixConv(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }
}
