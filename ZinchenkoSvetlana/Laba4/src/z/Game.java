package z;

import java.util.Random;

public class Game {
    private int start;
    private int end;
    private int random;

    public Game(int start, int end){
       this.start=start;
       this.end=end;
       Random random = new Random();
       this.random=random.nextInt(end)+start;
    }

    public boolean checkWin(int answer){
        if(answer>random){
            setEnd(answer);
            return true;
        }
        else {
            if (answer < random) {
                setStart(answer);
                return true;
            }
        }
        return false;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "Interval, where random is " +
                "( " + start +
                " , " + end +
                " )";
    }


}
