package ru.zhyldyz;

public class LSJava01 {
    public static void main(String[] args) {

        //применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int
        int a = 20;
        int b = 5;

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);

        int result = a + b - 3 * b / 2;
        System.out.println("Result = " + result);

        //применить несколько арифметических операций над int и double в одном выражении
        int c = 10;
        double d = 2.5;

        System.out.println(c + d);
        System.out.println(c - d);
        System.out.println(c * d);
        System.out.println(c / d);

        //применить несколько логических операций ( < , >, >=, <= )

        System.out.println("false =" + (a < b));
        System.out.println("true =" + (a > b));
        System.out.println("true =" + (a >= 20));
        System.out.println("true =" + (b <= 10));

        int x = 15;
        int y = 20;

        boolean example = (x < y) && (y >= 20);
        System.out.println("Example " + example);

        String name = "Alex";
        String surname = "Smith";
        int age = 30;
        System.out.println("true = "  + (name.equals("Alex")&& surname.equals("Smith")&& age == 30));
        System.out.println("true = "  + (name.equals("Alex")|| surname.equals("Smith")|| age >= 25));
        System.out.println("true = "  + (!name.equals("Alex")|| surname.equals("Smith")));
        System.out.println("false = "  + (!name.equals("Alex")|| !surname.equals("Smith")&& age > 25));
        System.out.println("false = "  + (!(name.equals("Alex")&& surname.equals("Smith")&& age > 25)));
        System.out.println("true = "  + ((name instanceof String) && (surname instanceof String)));

        String status = age >= 18 ? "Adult" : "Minor";
        System.out.println("Status: " + status);

        if(age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Minor");

        }

        //прочитать про диапазоны типов данных для вещественных / чисел с плавающей точкой (какие максимальные и минимальные значения есть, как их получить) и переполнение
        //получить переполнение при арифметической операции

        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);

        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

        System.out.println(Integer.MAX_VALUE);

        int max = Integer.MAX_VALUE;
        System.out.println(max);

        max = max + 1;
        System.out.println(max);

        int min = Integer.MIN_VALUE;
        System.out.println(min);

        min = min - 1;
        System.out.println(min);


    }
}
