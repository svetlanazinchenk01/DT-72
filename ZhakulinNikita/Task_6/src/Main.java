import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String s = in.nextLine();
        int len = s.length();

        System.out.println("Данная строка задом-наперед:");
        for (int i=len-1; i>=0; i--)
        {
            System.out.print(s.charAt(i));
        }
    }
}
