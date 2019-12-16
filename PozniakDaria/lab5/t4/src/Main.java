import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int k = (int) (Math.random() * 100);
        int start = 0, end = 100;
        int guess = -1;
        Boolean win = true;
        Scanner in = new Scanner(System.in);
        Boolean a = true;
        while(a) {
            try {
                while (guess != k) {
                    System.out.println("Enter number [" + start + ";" + end + "]");
                    guess = in.nextInt();
                    if ((guess <= end) && (guess >= start)) {
                        if (k > guess) {
                            System.out.println("More than " + guess);
                            start = guess;
                        } else if (k < guess) {
                            System.out.println("Less than " + guess);
                            end = guess;
                        } else  a = false;
                    } else System.out.println("Wrong! Try once more.");
                }
            }
            catch (Exception e) {
                System.out.println("Wrong format!");
            }
        }
        System.out.println("Congrats! You won!");
    }
}