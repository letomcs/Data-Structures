// Tom Le
// COSC 2336-01
// Instructor: Dr. Jane Liu
// Programming Assignment 3
// Due: 9/22/22
// Modify Listing 20.12 EvaluateExpression.java to add operators ^ for exponent and % for modulus.
// Have the program display the output to the console

import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpressionTomLe {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter an expression
        System.out.print("Enter the expression to be evaluated: ");
        String expression = input.nextLine();
        try {
            System.out.println(expression + " = " + evaluateExpression(expression));
        } catch (Exception ex) {
            System.out.println("Wrong expression: " + expression);
        }

        input.close();
    }

    /** Evaluate an expression */
    public static int evaluateExpression(String expression) {
        // Create operandStack to store operands
        Stack<Integer> operandStack = new Stack<>();

        // Create operatorStack to store operators
        Stack<Character> operatorStack = new Stack<>();

        // Insert blanks around (, ), +, -, /, *, ^, and %
        expression = insertBlanks(expression);

        // Extract operands and operators
        String[] tokens = expression.split(" ");

        // Phase 1: Scan tokens
        for (String token : tokens) {
            if (token.length() == 0) {
                // Blank space
                continue; // Back to the while loop to extract the next token
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                // Process all +, -, *, /, ^, % in the top of the operator stack 
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '+' ||
                                operatorStack.peek() == '-' ||
                                operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/' ||
                                operatorStack.peek() == '^' ||
                                operatorStack.peek() == '%')) {
                    processAnOperator(operandStack, operatorStack);
                }
                // Push the + or - operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
                // Process all *, /, % in the top of the operator stack 
                while (!operatorStack.isEmpty() &&
                        (operatorStack.peek() == '*' ||
                                operatorStack.peek() == '/' ||
                                operatorStack.peek() == '%')) {
                    processAnOperator(operandStack, operatorStack);
                }
                // Push the *, /, or % operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.charAt(0) == '^') {
                // Process all ^ operators in the top of the operator stack
                while (!operatorStack.isEmpty() && operatorStack.peek() == '^') {
                    processAnOperator(operandStack, operatorStack);
                }
                // Push the ^ operator into the operator stack
                operatorStack.push(token.charAt(0));
            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); // Push '(' to stack
            } else if (token.trim().charAt(0) == ')') {
                // Process all the operators in the stack until seeing '('
                while (operatorStack.peek() != '(') {
                    processAnOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); // Pop the '(' symbol from the stack
            } else {
                // An operand scanned, push it to the stack
                operandStack.push(Integer.parseInt(token));
            }
        }

        // Phase 2: process all the remaining operators in the stack 
        while (!operatorStack.isEmpty()) {
            processAnOperator(operandStack, operatorStack);
        }
        // Return the result
        return operandStack.pop();
    }

    /** Process one operator: Take an operator from operatorStack and
     * apply it on the operands in the operandStack */
    public static void processAnOperator(
            Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        switch (op) {
            case '+':
                operandStack.push(op2 + op1);
                break;
            case '-':
                operandStack.push(op2 - op1);
                break;
            case '*':
                operandStack.push(op2 * op1);
                break;
            case '/':
                operandStack.push(op2 / op1);
                break;
            case '^':
                operandStack.push((int) Math.pow(op2, op1));
                break;
            case '%':
                operandStack.push(op2 % op1);
                break;
        }
    }

    public static String insertBlanks(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')' ||
                    ch == '+' || ch == '-' ||
                    ch == '*' || ch == '/' ||
                    ch == '^' || ch == '%') {
                result.append(" ").append(ch).append(" ");
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}