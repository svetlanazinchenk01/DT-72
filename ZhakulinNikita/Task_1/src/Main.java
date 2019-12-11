import java.util.*;

public class Main
{
    static int N = 40000;
    static long adding(Collection<Character> collection){
        long millis = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
        {
            collection.add((char) i);
        }
        return System.currentTimeMillis() - millis;
    }

    static long searching(Collection<Character> collection){
        long millis = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
        {
            collection.contains((char) i);
        }
        return System.currentTimeMillis() - millis;
    }

    static long removing(Collection<Character> collection){
        long millis = System.currentTimeMillis();
        for (int i = 0; i < N; i++)
        {
            collection.remove((char) i);
        }
        return System.currentTimeMillis() - millis;
    }

    public static void main(String[] args) {
        Collection<Character> arrayList = new ArrayList<>();
        Collection<Character> linkedList = new LinkedList<>();
        Collection<Character> treeSet = new TreeSet<>();
        Collection<Character> hashSet = new HashSet<>();

        System.out.println("Adding:\n\tLinkedList:\t" + adding(linkedList) + " ms\n\tArrayList: \t" + adding(arrayList) + " ms\n\tTreeSet: \t" + adding(treeSet) + " ms\n\tHashSet: \t" + adding(hashSet) + " ms");

        System.out.println("Searching:\n\tLinkedList:\t" + searching(linkedList) + " ms\n\tArrayList: \t" + searching(arrayList) + " ms\n\tTreeSet: \t" + searching(treeSet) + " ms\n\tHashSet: \t" + searching(hashSet) + " ms");

        System.out.println("Removing:\n\tLinkedList:\t" + removing(linkedList) + " ms\n\tArrayList: \t" + removing(arrayList) + " ms\n\tTreeSet: \t" + removing(treeSet) + " ms\n\tHashSet: \t" + removing(hashSet) + " ms");
    }
}