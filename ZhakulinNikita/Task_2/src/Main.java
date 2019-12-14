import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static int indexOfMaxElement(List<Integer> list, List<Integer> exceptions)
    {
        int max = 0;
        int j=0;
        for (int i = 0; i < 150; i++)
        {
            if ((!exceptions.contains(i))&&(list.get(i)>max)){
                max = list.get(i);
                j=i;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        List<Integer> alpha = new ArrayList<>();
        List<Integer> beta = new ArrayList<>();

        int max = 0;
        for(int i=0; i<150; i++){
            int rand = (int) (Math.random()*199+1);
            alpha.add(rand);
        }
        while (beta.size() < 15){
            max = indexOfMaxElement(alpha, beta);
            beta.add(max);
        }
        for(int i=0; i<15; i++){
            int temp = beta.get(i);
            beta.set(i,alpha.get(temp));
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
            for (int i = 0; i < 15; i++)
            {
                writer.write(String.valueOf(beta.get(i)));
                writer.newLine();
            }
            writer.close();
        }catch(IOException o){
            System.out.println("IOException");
        }
        System.out.println("Коллекция Бета:");
        for (int i = 0; i < 15; i++) {
            System.out.println(beta.get(i));
        }
    }
}
