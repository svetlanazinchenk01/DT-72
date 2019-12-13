import java.util.Scanner;

class Gues {
    private int randomNumber;
    private int n;

    public Gues() {
        this.randomNumber = (int)(Math.random()*100);
    }
    private int comparison(){
        if(n > randomNumber) return 1;
        else if(n < randomNumber) return -1;
        return 0;
    }
    public int getRandomNumber(){
        return  this.randomNumber;
    }
    public void check(){
        try {
            if (n < 0 || n > 100) throw new IllegalArgumentException();;
        }
        catch (IllegalArgumentException e){
            System.out.println("You should enter value between 0 and 100");
            enterNumber();
            check();
        }
    }

    public void enterNumber(){
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
    }

    public void sugesRange(){
        int[] range = new int[2];
        range[0] = ((n+randomNumber)/2);
        range[1] = randomNumber + (randomNumber - range[0]);
        System.out.println("Try in gange: [" + Math.min(range[0], range[1]) + "; " + Math.max(range[0], range[1]) + "]");
    }

    public void game(){
        System.out.println("Enter number in range [0; 100]");
        enterNumber();
        check();
        while(true) {
            switch (comparison()) {
                case 0:
                    System.out.println(" My congatulations!");
                    return;
                case 1: {
                    System.out.println("Try bigger number");
                    sugesRange();
                    enterNumber();
                    check();
                }
                case -1: {
                    System.out.println("Try less number");
                    sugesRange();
                    enterNumber();
                    check();
                }
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Gues g = new Gues();
        g.game();
    }
}