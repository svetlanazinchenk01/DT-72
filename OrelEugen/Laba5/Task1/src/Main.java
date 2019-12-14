
import java.util.*;

public class Main {

    public static <CustomList extends AbstractCollection> void AddingTime(int Len, CustomList Collection)
    {
        long startLinked =  System.nanoTime();
        for(int i = 0; i < Len; i++)
            Collection.add(i);
        long finishLinked =  System.nanoTime();
        System.out.println(" adding took: " + (finishLinked - startLinked));
    }

    public static <CustomList extends AbstractCollection> void FindingTime (int el,CustomList Collection)
    {
        long startLinked =  System.nanoTime();
        Iterator<Integer> iterator = Collection.iterator();
        while (iterator.hasNext()) {
            Integer node = iterator.next();
            if (node == el) break;
        }
        long finishLinked =  System.nanoTime();
        System.out.println(" adding took: " + (finishLinked - startLinked));
    }

    public static <CustomList extends AbstractCollection> void DeleteTime(int Len, CustomList Collection)
    {
        long startLinked =  System.nanoTime();
        Collection.remove(Len/2);
        long finishLinked =  System.nanoTime();
        System.out.println(" delete took: " + (finishLinked - startLinked));
    }
    public static void main(String[] args)
    {

        int lenght = 1500;

        System.out.println("Hashset");
        HashSet<Iterator> hashSet = new HashSet<Iterator>();

        AddingTime(lenght, hashSet);
        FindingTime(lenght/3, hashSet);
        DeleteTime(lenght, hashSet);

        System.out.println("Linkedlist");
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        AddingTime(lenght, linkedList);
        FindingTime(lenght/3,linkedList);
        DeleteTime(lenght, linkedList);

        System.out.println("Treeset");
        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        AddingTime(lenght, treeSet);
        FindingTime(lenght/3, treeSet);
        DeleteTime(lenght, treeSet);

        System.out.println("Arraylist");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        AddingTime(lenght, arrayList);
        FindingTime(lenght/3, arrayList);
        DeleteTime(lenght, arrayList);

    }
}