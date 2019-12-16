import java.util.*;
import java.io.PrintWriter;
public class Main {

    public static void main(String[] args) {

        List <Integer> alfaArray = new ArrayList<>(150);
        for( int i=0; i< 150; i ++){
            Integer item = (int)( Math.random() * 199 + 1);
            alfaArray.add(item);
        }
        Collections.sort(alfaArray);
        List<Integer> betaArray = new ArrayList<>(alfaArray.subList(alfaArray.size() - 15, alfaArray.size()));
        System.out.println(betaArray);

        //output to file
        try {
            PrintWriter writer = new PrintWriter("task2_output.txt", "UTF-8");
            betaArray.forEach(writer::println);
            writer.close();
        }
        catch (Exception e) {}

        alfaArray.clear();
        betaArray.clear();
    }
}