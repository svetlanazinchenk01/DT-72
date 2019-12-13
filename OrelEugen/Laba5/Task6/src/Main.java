import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word: ");
        String InputWord = scanner.next();
        StringBuilder InputString = new StringBuilder(InputWord.length());

        for (int i = InputWord.length() - 1; i >= 0; i--){
            InputString.append(InputWord.charAt(i));
        }
        String Result = InputString.toString();
        System.out.println("Result word: " + Result);
    }
}
