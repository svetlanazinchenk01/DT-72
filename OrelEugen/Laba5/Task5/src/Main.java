import java.io.*;
import java.util.*;

public class Main {
    public static final Comparator<String> COMPARE = new Comparator<String>() {

        @Override
        public int compare(String str1, String str2) {
            return str1.compareToIgnoreCase(str2);
        }
    };

    public static void main(String[] args) throws FileNotFoundException {
        Scanner MyScaner = new Scanner(new FileReader("Text.txt"));
        LinkedList<String> Result = new LinkedList();
        while (MyScaner.hasNext()) {
            String Temp = MyScaner.next();
            Result.add(Temp);
        }

        System.out.println("Input text: " + Result);
        Collections.sort(Result, COMPARE);
        System.out.print("Output text: " + Result);
    }
}