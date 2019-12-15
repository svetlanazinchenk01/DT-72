import java.util.*;

public class Main
{
    static long n = 10000L;
    static long add(Collection<Character> c){
        long m = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
        {
            c.add((char) i);
        }
        return System.currentTimeMillis() - m;
    }

    static long search(Collection<Character> c){
        long m = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
        {
            c.contains((char) i);
        }
        return System.currentTimeMillis() - m;
    }

    static long remove(Collection<Character> c){
        long m = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
        {
            c.remove((char) i);
        }
        return System.currentTimeMillis() - m;
    }

    public static void main(String[] args) {
        Collection<Character> arrayList = new ArrayList<>();
        Collection<Character> linkedList = new LinkedList<>();
        Collection<Character> treeSet = new TreeSet<>();
        Collection<Character> hashSet = new HashSet<>();

        System.out.println("Adding:\nLinkedList:" + add(linkedList) + " ms\nArrayList: " + add(arrayList) + " ms\nTreeSet: " + add(treeSet) + " ms\nHashSet: " + add(hashSet) + " ms");
        System.out.println();
        System.out.println("Searching:\nLinkedList:" + search(linkedList) + " ms\nArrayList: " + search(arrayList) + " ms\nTreeSet: " + search(treeSet) + " ms\nHashSet: " + search(hashSet) + " ms");
        System.out.println();
        System.out.println("Removing:\nLinkedList:" + remove(linkedList) + " ms\nArrayList: " + remove(arrayList) + " ms\nTreeSet: " + remove(treeSet) + " ms\nHashSet: " + remove(hashSet) + " ms");
    }
}