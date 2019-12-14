import java.io.IOException;
import java.util.*;
import java.text.Collator;
import java.io.File;

public class Main {
    public static void main(String args[])
    {
        List<String> list = new ArrayList<>();
        Scanner a = new Scanner(System.in);
        System.out.println("Введите имя файла, в котором слова разделены пробелом: (например 'eng', 'rus', 'ukr')");
        String s = a.nextLine();
        try {
            Scanner in = new Scanner(new File(s + ".txt"));
            while (in.hasNext()) {
                list.add(in.next());
            }
            String[] arr = new String[list.size()];
            arr = list.toArray(arr);
            System.out.print("Слова неотсортированного текста: ");
            System.out.println(Arrays.toString(arr));
            Arrays.sort(arr, Collator.getInstance());
            System.out.print("Отсортированные слова case-insensitive: ");
            System.out.println(Arrays.toString(arr));
            in.close();
        }catch(IOException e){System.out.println("Неправильное имя файла");}
    }
}
