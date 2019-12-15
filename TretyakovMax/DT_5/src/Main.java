import java.io.IOException;
import java.util.*;
import java.text.Collator;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String args[])
    {
        try {
            ArrayList<String> arrayList = new ArrayList();
            Scanner filename_s = new Scanner(System.in);
            System.out.println("Type filename (without extension, e.g. 'test1', 'test2', 'test3'):");
            String filename = filename_s.nextLine();
            Scanner file_s = new Scanner(new File(filename + ".txt"));
            while (file_s.hasNext()) {
                arrayList.add(file_s.next());
            }
            String[] array = new String[arrayList.size()];
            array = arrayList.toArray(array);
            System.out.print("Words from file: ");
            for (int i = 0; i < array.length; i++)
                System.out.print(array[i] + " ");
            System.out.println();
            Arrays.sort(array, Collator.getInstance());
            System.out.print("Sorted words case-insensitive: ");
            for (int i = 0; i < array.length; i++)
                System.out.print(array[i] + " ");
            file_s.close();
        }catch (IOException e){
            System.out.println("Incorrect filename");
        }
    }
}
