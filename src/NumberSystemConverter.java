import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class NumberSystemConverter {
    public static void main(String[] args) {
        System.out.println("                                      Number Base converter");
        System.out.println("                                   ===========================");
        System.out.println("                     [1] (Dec)imal, [2] (Bin)ary, [3] (Hex)adecimal, [4] (Oct)al\n");

        int currentBase= getBase("Number system to convert from: ");

        String number= getValidNumber(currentBase);
        int requiredBase=getBase("Number system to convert to: ");
        //String convertednumber=convert(number,currentBase,requiredBase);
        //System.out.println("Converted number: "+convertednumber);
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
                System.out.println("Invalid input...Try again");
            }
        }while (notValid);

        return number;
    }
    static boolean valid(String number, int base){
        boolean result=false;
        System.out.println("Checking for base: "+base+" & number: "+number);
        switch (base) {
            case 1 -> result = number.matches("^[0-9]+$");
            case 2 -> result = number.matches("^[0-1]+$");
            case 3 -> result = number.matches("^[0-9A-Fa-f]+$");
            case 4 -> result = number.matches("^[0-7]+$");
            default -> System.out.println("Should not have happened...");
        }
        return result;
    }
    static int getBase(String promt){
        int choice;
        Scanner scan= new Scanner(System.in);

        choiceTaken: while (true){
            System.out.print(promt);
            String userChoice =scan.nextLine().toLowerCase();
            switch (userChoice){
                case "1":
                case "decimal":
                case "dec":
                    choice=1;
                    break choiceTaken;
                case "2":
                case "binary":
                case "bin":
                    choice=2;
                    break choiceTaken;
                case "3":
                case "hexadecimal":
                case "hex":
                    choice=3;
                    break choiceTaken;
                case "4":
                case "octal":
                case "oct":
                    choice=4;
                    break choiceTaken;
                default:
                    System.out.println("Invalid Input try again");
            }
        }


        return choice;
    }
}
