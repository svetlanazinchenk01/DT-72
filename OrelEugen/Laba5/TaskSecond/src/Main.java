import java.io.FileWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer>alpha=new ArrayList<>();
        ArrayList<Integer>beta=new ArrayList<>();

        alpha = FillList( alpha, 150, 200);
        System.out.println("alpha" + alpha);

        beta = GetNMax( alpha, 15);

        System.out.println("Beta list:" + beta);
        System.out.println("Alpha list" + alpha);

        String FileName="FileTxt.txt";
        try {
            FileWriter fileWriter=new FileWriter(FileName);
            for (Integer el: beta) fileWriter.write(Integer.toString(el) + " ");
            fileWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Integer> FillList(ArrayList<Integer> List, int ListLen, int RandBound)
    {
        Random rand = new Random();
        for (int i = 0; i < ListLen; i = i + 1)
            List.add(rand.nextInt(RandBound) + 1);
        return List;
    }

    public static ArrayList<Integer> GetNMax(ArrayList<Integer> List, int N)
    {
        ArrayList<Integer> TempList = new ArrayList<Integer>();
        for (Integer el: List) TempList.add(el);
        Collections.sort(TempList, Collections.reverseOrder());
        for (int i=0; i<List.size()-N; i=i+1) TempList.remove(TempList.size()-1);
        return TempList;
    }
}
