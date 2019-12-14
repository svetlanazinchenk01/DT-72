package z;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static z.Local.*;


class Local {

     static public List<Integer> getNewList(int size, final List<Integer> list)  {
         List<Integer> list1 = new ArrayList<>();

         for (int i = 0; i <size; i++){
             list1.add(list.get(i));
         }
         Integer m = findMin(list1);
         int index = list1.indexOf(m);
         for (int i = size; i < list.size(); i++){
             if (list.get(i) > m ) {
                 //System.out.println(i);
                 list1.set(index,list.get(i));
                 m=findMin(list1);
                 index=list1.indexOf(m);
             }
         }
         return list1;
     }

     static public Integer findMin(List<Integer> list){
         Integer min= 200;
         for (int i = 0; i<list.size(); i++){
             if(list.get(i)<min){
                 min=list.get(i);
             }

         }
         return min;
     }


    static public boolean printListInTxt(List<Integer> list)
    {
        try (
            FileWriter writer = new FileWriter("text.txt", false)) {
            for (int i = 0; i<list.size() ; i++) {
                writer.write((i+1) + ". "+list.get(i));
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    static  public List<Integer> rangeList (List<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        return list;
    }
}

public class Main {

    public static void main(String[] args) {
        final  Integer size = 150;
        final  Integer size1 =15;
        final  List<Integer> alpha = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < size; i++) {
            alpha.add(abs(random.nextInt(200)));}


        List<Integer> betha = Local.getNewList(size1, alpha);
        System.out.println("Before sort new list :");
        for (int i = 0; i<size1 ; i++) {
            System.out.println((i+1) + ". "+betha.get(i));
        }
        System.out.println("|||||||||||||||||||||||||||||||||||||");
        System.out.println("After sort new lsit :");
        betha = rangeList(betha);
        for (int i = 0; i<size1 ; i++) {
            System.out.println((i+1) + ". "+betha.get(i));
        }

        if(printListInTxt(betha)){
            System.out.println("List in file");
        }
        else {
            System.out.println("List not in file");
        }
    }
}
