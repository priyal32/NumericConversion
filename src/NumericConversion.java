import java.util.Scanner;
public class NumericConversion {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // variable menu to store the menu
        String menu = "Decoding Menu\n-------------\n1. Decode hexadecimal\n2. Decode binary\n3. Convert binary to hexadecimal\n4. Quit\n\nPlease enter an option: ";
        System.out.print(menu);
        int chosenOption = scnr.nextInt();

        //If user chooses option 1 then then the hexadecimal will be converted to decimal
        while (chosenOption == 1) {
            System.out.print("Please enter the numeric string to convert: ");
            String hexString = scnr.next();
            System.out.println("Result: " + hexStringDecode(hexString)+"\n");
            System.out.print(menu);
            chosenOption = scnr.nextInt();
        }
        //If user chooses option 2 then the binary string will be converted to decimal
        while (chosenOption == 2){
            System.out.print("Please enter the numeric string to convert: ");
            String binary = scnr.next();
            System.out.println("Result: " + binaryStringDecode(binary)+"\n");
            System.out.print(menu);
            chosenOption = scnr.nextInt();

        }
        //If user chooses option 3 then the binary string will be converted to hexadecimal
        while (chosenOption == 3) {
            System.out.print("Please enter the numeric string to convert: ");
            String binaryString = scnr.next();
            System.out.println("Result: " + binaryToHex(binaryString)+"\n");
            System.out.print(menu);
            chosenOption = scnr.nextInt();
        }
        System.out.print("Goodbye!"); // For when user chooses option 4 to quit the program
    }

    // method used to assign values to Hexadecimal characters
    public static short hexCharDecode(char digit) {
        short hexDigit;
        // assigns values to the hexadecimal letters
        if(digit == 'a'){
            hexDigit = 10;
        } else if (digit == 'b'){
            hexDigit = 11;
        } else if (digit == 'c'){
            hexDigit = 12;
        } else if (digit == 'd'){
            hexDigit = 13;
        } else if (digit == 'e'){
            hexDigit = 14;
        } else if (digit == 'f'){
            hexDigit = 15;
        } else {
            hexDigit = (short)Character.getNumericValue(digit); // returns the int value that the character represents
        }
        return hexDigit;

    }

    // method used to convert hexadecimal string to a decimal number
    public static Long hexStringDecode(String hex) {
        hex = hex.toLowerCase(); // will convert the input to all lowercase
        long valPerIndex;
        long val = 0;
        int i = 0;
        int j = i;
        // if the input starts with 0x then the for loop will start with i = 2
        if (hex.charAt(i) == '0' && hex.charAt(i+1) == 'x') {
            j =i + 2;
        }
        /* till i does reach the length of the input string the variable valPerIndex variable will keep
        updating by taking the character at index i and giving it the value through the hexCharDecode method
        and then multiplying it to 16 raised to power of the length of the string - 1 - the character index*/
        for (i = j; i < hex.length(); i++) {
                valPerIndex = (long) (hexCharDecode(hex.charAt(i)) * Math.pow(16, (hex.length() - 1 - i)));
                val = valPerIndex + val;
            }
        return val;
    }

    public static short binaryStringDecode (String binary) {
        short val = 0;
        int i = 0;
        int j = i;
        // if the input starts with 0b then the for loop will start with i = 2
        if(binary.charAt(i) == '0' && binary.charAt(i+1) == 'b') {
            j = i + 2;
        }
        /* till i is less then the length of the input string, the val variable will multiply itself with 2.
        If the character at an index i is 0 then val will add 0 to itself and if it is 1 val will add 1 to itself*/
        for (i = j; i < binary.length(); i++) {
            val *= 2;
            if (binary.charAt(i) == '0') {
                val += 0;
            } else {
                val += 1;
            }
        }
        return val;
    }

    //method for converting a binary string to hexadecimal
    public static String binaryToHex(String binary) {
        //variable binaryToDec turns the binary string into decimal using the binaryStringDecode method
        short binaryToDec = binaryStringDecode(binary);
        String Hexadecimal = "0123456789ABCDEF";
        String hexString = "";
        int remainder;

        /*As long as binaryToDec is a positive number, number will be divided by 16 and the number will be stored in
        variable remainder. The hexString variable will get the value of the remainder from the hexadecimal string
        and then add it to itself. The decimal number will be then divided by 16 and the process will be looped until binaryToDec
        reaches 0 or less*/
        while(binaryToDec > 0){
            remainder = binaryToDec % 16;
            hexString = Hexadecimal.charAt(remainder) + hexString;
            binaryToDec = (short) (binaryToDec/16);
        }
        return hexString;
    }

}





