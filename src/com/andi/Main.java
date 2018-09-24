package com.andi;

public class Main {

    public static InterpreterContext interpreterContext;


    public Main(InterpreterContext interpreterContext) {
        this.interpreterContext = interpreterContext;
    }

    public static void main(String[] args) {

        String first = "13 in Binary";
        String second = "28 in Hexadecimale";

        Main interpreter = new Main(new InterpreterContext());
        System.out.println(first + " = " + interpreter.interpret(first));
        System.out.println(second + " = " + interpreter.interpret(second));

    }

    public static String interpret(String str){

        Expression expression = null;

        if(str.contains("Hexadecimale")){
            expression = new IntToHexExpression(Integer.parseInt(str.substring(0, str.indexOf(" ") )));
        } else if (str.contains("Binary")){
            expression = new IntToBinaryExpression(Integer.parseInt(str.substring(0, str.indexOf(" ") )));
        } else
            return str;
        return expression.interpreter(interpreterContext);
    }
}
