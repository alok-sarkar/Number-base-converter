import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberSystemConverter {
    static final String ANSI_GREEN = "\u001B[32m";
    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_YELLOW = "\u001B[33m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_BLUE = "\u001B[34m";
    static final String ANSI_PURPLE = "\u001B[35m";
    static final String ANSI_CYAN = "\u001B[36m";
    public static void main(String[] args) {
        System.out.println("                                      Number Base converter");
        System.out.println("                                   ===========================");
        System.out.println("                     [1] (Dec)imal, [2] (Bin)ary, [3] (Hex)adecimal, [4] (Oct)al\n");

        int currentBase= getBase("Number system to convert from: ");

        String number= getValidNumber(currentBase);
        int requiredBase=getBase("Number system to convert to: ");
        String convertednumber=convert(number,currentBase,requiredBase);
        System.out.println("Converted number: "+convertednumber);
    }
    static String getValidNumber(int base){
        Scanner scan= new Scanner(System.in);
        String number;
        boolean notValid;
        do{
            System.out.print("Enter the number: ");
            number= scan.nextLine();

            notValid=!valid(number,base);
            if(notValid){
                System.out.println(ANSI_RED+"Invalid input...Try again"+ANSI_RESET);
            }
        }while (notValid);

        return number;
    }
    static boolean valid(String number, int base){
        boolean result=false;
        System.out.println("Checking for base: "+base+" & number: "+number);
        switch (base) {
            case 10 -> result = number.matches("^[0-9]+$");
            case 2 -> result = number.matches("^[0-1]+$");
            case 16 -> result = number.matches("^[0-9A-Fa-f]+$");
            case 8 -> result = number.matches("^[0-7]+$");
            default -> System.out.println("Should not have happened...");
        }
        return result;
    }
    static int getBase(String promt){
        int choice;
        Scanner scan= new Scanner(System.in);

        choiceTaken: while (true){
            System.out.print(ANSI_YELLOW+promt+ANSI_RESET);
            String userChoice =scan.nextLine().toLowerCase();
            switch (userChoice){
                case "1":
                case "decimal":
                case "dec":
                    choice=10;
                    break choiceTaken;
                case "2":
                case "binary":
                case "bin":
                    choice=2;
                    break choiceTaken;
                case "3":
                case "hexadecimal":
                case "hex":
                    choice=16;
                    break choiceTaken;
                case "4":
                case "octal":
                case "oct":
                    choice=8;
                    break choiceTaken;
                default:
                    System.out.println(ANSI_RED+"Invalid Input try again"+ANSI_RESET);
            }
        }


        return choice;
    }
    static String convert(String number, int currentBase, int requiredBase){
        int decimalValue=0;
        if(currentBase==10){
            decimalValue=Integer.parseInt(number);
        }else if (currentBase==2){
            decimalValue=Integer.parseInt(number,2);

        } else if (currentBase==8) {
            decimalValue=Integer.parseInt(number,8);
        }else if(currentBase==16){
            decimalValue=Integer.parseInt(number,16);
        }else {
            System.out.println(ANSI_RED+"Invalid base..... Should not have happened"+ANSI_RESET);
            return "";
        }
        if(requiredBase==2){
            return Integer.toBinaryString(decimalValue);
        }else if(requiredBase==8){
            return Integer.toOctalString(decimalValue);
        } else if (requiredBase==16) {
            return Integer.toHexString(decimalValue);
        }else if (requiredBase==10){
            return Integer.toString(decimalValue);
        }else {
            System.out.println(ANSI_RED+"Invalid base..... Should not have happened"+ANSI_RESET);
            return "";
        }
    }
}
