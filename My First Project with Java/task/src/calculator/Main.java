package calculator;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Dictionary<String, Integer> dict = CreateDict();
        PrintEarnedBruttoAmount(dict);

        System.out.println("Staff expenses:");
        int staffExpenses = scanner.nextInt();
        System.out.println("Other expenses:");
        int otherExpenses = scanner.nextInt();
        PrintAndCalcNettoAmount(dict, staffExpenses, otherExpenses);
    }

    public static Dictionary<String, Integer> CreateDict() {
        Dictionary<String, Integer> dict = new Hashtable<>();

        dict.put("Bubblegum", 202);
        dict.put("Toffee", 118);
        dict.put("Ice cream", 2250);
        dict.put("Milk chocolate", 1680);
        dict.put("Doughnut", 1075);
        dict.put("Pancake", 80);

        return dict;
    }

    public static void PrintEarnedBruttoAmount(Dictionary<String, Integer> dict) {

        Enumeration<String> keys = dict.keys();

        System.out.println("Earned amount:");
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + ": $ " + dict.get(key));
        }

        System.out.println("\n" + "Income: $" + CalcAmount(dict));


    }

    public static int CalcAmount(Dictionary<String, Integer> dict) {
        Enumeration<String> keys = dict.keys();

        int sum = 0;
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            sum += dict.get(key);
        }

        return sum;
    }

    public static void PrintAndCalcNettoAmount(Dictionary<String, Integer> dict, int staffExpenses, int otherExpenses) {

        int sum = (int) CalcAmount(dict) - staffExpenses - otherExpenses;
        System.out.println("Net income: $" + sum);

    }
}