import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int rand = (int) (Math.random()*100);
        int k = 0, a=0, b=100;
        while (k != rand) {
            System.out.println("Введите число от " + a + " до " + b + " ");

            Scanner in = new Scanner(System.in);
            k = in.nextInt();
            if ((k < b) && (k > a)) {
                if (k == rand) {
                    System.out.println("Вы угадали!");
                } else {
                    if ((k > rand)) {
                        System.out.println("Ваше число больше загаданного");
                        b = k;
                    } else {
                        System.out.println("Ваше число меньше загаданного");
                        a = k;
                    }
                }
            } else {
                System.out.println("Ответ должен быть от " + a + " до " + b);
            }
        }
    }
}

