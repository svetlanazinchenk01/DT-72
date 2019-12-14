package z;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


import static java.lang.Math.abs;
import static z.Local.*;


class Local {

    static public boolean printListInTxt(List<Integer> list)
    {
        try {
            FileWriter fileWriter = new FileWriter("text.txt", false);
            final int[] i = {1};
            list.stream().forEach(x -> {
                try {
                    fileWriter.write((i[0]) + ". " + x);
                    fileWriter.append('\n');
                } catch (IOException e) {
                    e.printStackTrace();
                }
                i[0]++;
            });
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}

public class Main {

    public static void main(String[] args) {
        final  Integer size = 150;
        final  Integer size1 =15;
        final  List<Integer> alpha = new ArrayList<>();

        Random random = new Random();

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
        System.out.println("You have Alpha list with 150 randoms integer elements \n and new beta list with the largest elements from Alpha list");

        for (int i = 0; i < size; i++) {
            alpha.add(abs(random.nextInt(200)));}

        int answer = 0;
        do {
            answer = Keyin.inInt("Do you want to see the alpha list? \n 1-Yes \n 2-No \n");
        } while (answer>2||answer<1);
        if(answer==1) {
            System.out.println("Alpha list :");
            alpha.stream().forEach(x -> System.out.println(x));
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
        }

        List<Integer> beta = alpha.stream().sorted((x1,x2)->x2-x1).limit(size1).collect(Collectors.toList());


        System.out.println("Betha list :");
        beta.stream().forEach(x -> System.out.println(x));

        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");


        if(printListInTxt(beta)){
            System.out.println("List in file");
        }
        else {
            System.out.println("List not in file");
        }

    }
}
