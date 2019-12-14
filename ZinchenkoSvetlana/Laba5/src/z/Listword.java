package z;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Listword{

    private final Object e;
    public List<String> list;


   public Listword(String paths , String name){
       this.e = null;
       try {
           Path path = Paths.get(paths, name);
           List<String> allLinesFromFile = Files.readAllLines(path, Charset.forName("utf-8"));
           System.out.println("Текст из файлa " + path.getFileName());
           for (String s : allLinesFromFile) System.out.println(s);
           List<String> words = new ArrayList<>();
           this.list = new ArrayList<>();
           for (int i = 0; i < allLinesFromFile.size(); i++) {
               words = Arrays.asList(allLinesFromFile.get(i).split("[\\pP\\s]+"));
               for (int j = 0; j < words.size(); j++) {
                   this.list.add(words.get(j));
               }
           }
       }
       catch (java.io.IOException e) {
           System.out.println("An error occurred.");

       }
   }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }


    public void sortList(){
       try {
           Collections.sort(list, new SalaryAndNameComparator());
       }
       catch (Exception e){
           System.out.println("ERROR");
       }
       }

    @Override
    public String toString() {
        return "" +
                "list=" + list +
                '}';
    }
}

class SalaryAndNameComparator implements Comparator<String> {
    public int compare(String a, String b) {
        int result;
            result = a.compareToIgnoreCase(b);
        return result;
    }
}

