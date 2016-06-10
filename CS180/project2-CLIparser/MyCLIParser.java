import java.util.Scanner;

public class MyCLIParser {
    public static void main(String[] args) {
        // if no arguments, print help and return
        if (args.length == 0) {
            help(args);
            return;
        }
        //-help
        else if (args[0].equals("-help"))  help(args);
        //-add
        else if (args[0].equals("-add"))   add(args);
        //-sub
        else if (args[0].equals("-sub"))   sub(args);
        //-mul
        else if (args[0].equals("-mul"))   mul(args);
        //-div
        else if (args[0].equals("-div"))   div(args);
        //-stats
        else if (args[0].equals("-stats")) stats(args);
        //-table
        else if (args[0].equals("-table")) table(args);
    }
    
    public static boolean isInteger(String s) {
        Scanner a = new Scanner(System.in);
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (s.charAt(0) == '-') {
            if(length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = s.charAt(i);
            if(c <= '/' || c >= ':') {
                return false;
            }
        }
        return true;
        
    }
    
    private static void help(String[] args) {
        // CODE HERE
        System.out.println("-help:list of commands and instructions");
        System.out.println("-add:add integer arguments and print the result"); 
        System.out.println("-sub:subtract two integer arguments and print the result");
        System.out.println("-mul:multiply integer arguments and print the result");
        System.out.println("-div:divide 1st integer by 2nd integer and print result");
        System.out.println("-stat:takes integer arguments and prints total,maximum,minimum and average");
        System.out.println("-table:add integer argument to multiplication table from [0,9] and prints it");
        
    }
    
    private static void add(String[] args) {
        // CODE HERE
        int sum = 0;
        if (args.length == 1) {
            System.out.println("Argument count mismatch");
            return;
        }
        for (int i = 1; i < args.length; i++) {
            if (isInteger(args[i])) {
                int v = Integer.parseInt(args[i]);
                sum = sum + v;
            } else {
                System.out.println("Argument type mismatch");
                return;
            } 
            
        }
        System.out.println(sum);
    }
    
    private static void sub(String[] args) {
        // CODE HERE
        int sub = 0;
        if (args.length != 3) {
            System.out.println("Argument count mismatch");
            return;
        }
        if (isInteger(args[1]) && isInteger(args[2])) {
            sub = Integer.parseInt(args[1]) - Integer.parseInt(args[2]);
        } else {
            System.out.println("Argument type mismatch");
            return;
        }
        System.out.println(sub);
    }
    
    
    private static void mul(String[] args) {
        // CODE HERE
        int mul = 1;
        if (args.length == 1) {
            System.out.println("Argument count mismatch");
            return;
        }
        for (int i = 1; i < args.length; i++) {
            if (isInteger(args[i])) {
                int v = Integer.parseInt(args[i]);
                mul = mul * v;
            } else {
                System.out.println("Argument type mismatch");
                return;
            }  
        }
        System.out.println(mul);
    }
    
    
    private static void div(String[] args) {
        // CODE HERE
        double div = 0;
        if (args.length != 3) {
            System.out.println("Argument count mismatch");
            return;  
        }
        
        if (isInteger(args[1]) && isInteger(args[2])) {
            if (Integer.parseInt(args[2]) == 0) {
                System.out.println("undefined");
                return;
            }
            div = Double.parseDouble(args[1]) / Double.parseDouble(args[2]);
        } else {
            System.out.println("Argument type mismatch");
            return;
        }
        System.out.printf("%.2f\n", div);
    }
    
    
    
    private static void stats(String[] args) {
        // CODE HERE
        int total = 0;
        int max = 0;
        int min = 0;
        int n = 0;
        double average = 0;
        if (args.length == 1) {
            System.out.println("Argument count mismatch");
            return;
        }
        if (isInteger(args[1])) {
            max = Integer.parseInt(args[1]);
            min = Integer.parseInt(args[1]);
        }
        
        for (int i = 1; i < args.length; i++) {
            if (isInteger(args[i])) {
                total = total + Integer.parseInt(args[i]);
                n = n+1;
                if (max < Integer.parseInt(args[i])) {
                    max = Integer.parseInt(args[i]);
                }
                if (min > Integer.parseInt(args[i])) {
                    min = Integer.parseInt(args[i]);
                }
                
            } else {
                System.out.println("Argument type mismatch");
                return;
            }
        }
        average = (double) total / (double) n;
        System.out.println(total);
        System.out.println(max);
        System.out.println(min);
        System.out.printf("%.2f\n", average);;
    }
    
    
    
    
    private static void table(String[] args) {
        // CODE HERE
        if (args.length ==1) {
            System.out.println("Argument count mismatch");
            return;
        }
        if (isInteger(args[1])) {
            int[][] array = new int[10][10];
            for (int i = 0; i < 10; i++) {
                array[i][0] = 0;
            }
            for (int j = 0; j < 10; j++) {
                array[0][j] = 0;
            }
            for (int i = 1; i < 10; i++) {
                for(int j = 1; j < 10; j++) {
                    array[i][j] = array[i][j-1] + i;
                }
                
            }
            
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < 10; j++) {
                    array[i][j] = array[i][j] + Integer.parseInt(args[1]);
                }
            }
            for (int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    System.out.printf("%6d",array[i][j]);
                }
                System.out.print("\n");
            }
        } else {
            System.out.println("Argument type mismatch");
        }
    }
}
