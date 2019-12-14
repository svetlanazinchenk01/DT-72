package z;

import java.io.PrintStream;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        long n = 10000L;
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        TreeSet treeSet = new TreeSet();
        HashSet hashSet = new HashSet();

        long milis = System.currentTimeMillis();
        for(int i = 0; (long)i < n; ++i) {
            linkedList.add(Integer.toString(i));
        }

        long addingLinkedList = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            linkedList.contains(Integer.toString(i));
        }

        long searchingLinkedList = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            linkedList.remove(Integer.toString(i));
        }

        long removingLinkedList = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            arrayList.add(Integer.toString(i));
        }

        long addingArrayList = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            arrayList.contains(Integer.toString(i));
        }

        long searchingArrayList = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            arrayList.remove(Integer.toString(i));
        }

        long removingArrayList = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            treeSet.add(Integer.toString(i));
        }

        long addingTreeSet = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            treeSet.contains(Integer.toString(i));
        }

        long searchingTreeSet = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            treeSet.remove(Integer.toString(i));
        }

        long removingTreeSet = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            hashSet.add(Integer.toString(i));
        }

        long addingHashSet = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            hashSet.contains(Integer.toString(i));
        }

        long searchingHashSet = System.currentTimeMillis() - milis;
        milis = System.currentTimeMillis();

        for(int i = 0; (long)i < n; ++i) {
            hashSet.remove(Integer.toString(i));
        }

        long removingHashSet = System.currentTimeMillis() - milis;
        PrintStream var10000 = System.out;
        try {
            var10000.println("addingTreeSet - " + addingTreeSet);
            var10000.println("addingHashSet - " + addingHashSet);
            var10000.println("addingArrayList - " + addingArrayList);
            var10000.println("addingLinkedList - " + addingLinkedList);
            var10000.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        PrintStream var10003 = System.out;
        try {
            var10003.println("searchingTreeSet - " + searchingTreeSet);
            var10003.println("searchingHashSet - " + searchingHashSet);
            var10003.println("searchingArrayList - " + searchingArrayList);
            var10003.println("searchingLinkedList - " + searchingLinkedList);
            var10000.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        PrintStream var10006 = System.out;
        try {
            var10006.println("removingTreeSet - " + removingTreeSet);
            var10006.println("removingHashSet - " + removingHashSet);
            var10006.println("removingArrayList - " + removingArrayList);
            var10006.println("removingLinkedList - " + removingLinkedList);
            var10006.flush();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

