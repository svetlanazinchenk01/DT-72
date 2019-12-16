import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the word you want to read backwards:");
        String inp = scan.next();
        char[] signs = inp.toCharArray();
        int length = inp.length();
        char[] reverse= new char[length];
        for(int i=0;i< length; i++){
            reverse[i]= signs[length-i-1];
        }
        String Rev = "";
        for(int i=0;i< length; i++){
            Rev+=reverse[i];
        }
        System.out.println("The word vice versa " + Rev);
    }
}
