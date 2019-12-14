package z;

public class Main {

    public static void main(String[] args) {
        int k = 1;
        while (k == 1) {
            Game game = new Game(0, 100);

            System.out.println("|                  Hello                    |");
            System.out.println("|             Guess the number              |");
            System.out.println("|                                           |");
            System.out.println("|                                           |");
            System.out.println("|           Random number is ready          |");

            boolean checkingWin = true;

            do {
                System.out.println(game);

                int answer;
                answer = Keyin.inInt("Input your answer");

                while ((answer < (game.getStart())) || (answer > (game.getEnd()))) {
                    System.out.println("You must select number in interval - " + game);
                    answer = Keyin.inInt("Input your answer");
                }

                checkingWin = game.checkWin(answer);
            }
            while (checkingWin == true);

            System.out.println("|                          You are win!!!                         |");
            System.out.println("|                     Random number is " + game.getRandom() + "                         |");
            System.out.println("|                                                                 |");
            System.out.println("|                                                                 |");
            System.out.println("|                         Restart Game?                           |");
            System.out.println("|                        1.Start new Game                         |");
            System.out.println("|                             2.Exit                              |");

            k = Keyin.inInt("Input your answer");
            while(k<1||k>2){
                System.out.println("You must write 1 or 2");
                k = Keyin.inInt("Input your answer");
            }
        }
    }
}



