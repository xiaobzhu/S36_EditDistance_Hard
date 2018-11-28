import java.util.Scanner;

/**
 * @author xiaobzhu
 * this is the main class for the editdistance,in this file it will work as to let user input the string that used to do
 * the calculation for the editdistance.
 */
public class EditDistance {
    /**
     * this is the main method, that used to run the project, in this method it use the scanner to get the user input
     * also do the check that if the user input the digits, it will show the error message
     * @param args the parameter in the main method
     */
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the first String"); // this part I create two scanner to let the user input the String that They want to do the calculation on the edit distance
        String input = scanner.nextLine();
        for(int i = 0; i < input.length(); i++){
            if(!Character.isLetter(input.charAt(i))){
                System.out.println("Invalid input");
                throw new IllegalArgumentException("Invalid input");
            }
        }
        System.out.println("Please input the second String");
        Scanner scanner1 = new Scanner(System.in);
        String input1 = scanner1.nextLine();
        for(int i = 0; i < input1.length(); i++){
            if(!Character.isLetter(input1.charAt(i))){
                System.out.println("Invalid input");
                throw new IllegalArgumentException("Invalid input");
            }
        }
        DistanceCalculate distanceCalculate = new DistanceCalculate(input, input1); // call the constructor of the DistanceCalculation class, the pass the value in
        }
}
