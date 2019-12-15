package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        String n1,n2,n3= null;
        boolean n4= true;
        list.add("element1");
        long start1 = System.nanoTime();
        list.add("element2");
        long finish1 = System.nanoTime();
        long result1 = finish1 - start1;
        list.add("element3");
        list.add("element4");
        list.add("element5");
        long start2 = System.nanoTime();
        list.remove(2);
        long finish2 = System.nanoTime();
        long result2 = finish2 - start2;
        long start3 = System.nanoTime();
        n1=list.get(1);
        long finish3 = System.nanoTime();
        long result3 = finish3 - start3;


        ArrayList<String> array = new ArrayList<>();
        array.add("element1");
        long start4 = System.nanoTime();
        array.add("element2");
        long finish4 = System.nanoTime();
        long result4 = finish4 - start4;
        array.add("element3");
        array.add("element4");
        array.add("element5");
        long start5 = System.nanoTime();
        array.remove(2);
        long finish5 = System.nanoTime();
        long result5 = finish5 - start5;
        long start6 = System.nanoTime();
        n2=array.get(1);
        long finish6 = System.nanoTime();
        long result6 = finish6 - start6;


        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("element1");
        long start8 = System.nanoTime();
        treeSet.add("element2");
        long finish8 = System.nanoTime();
        long result8 = finish8 - start8;
        treeSet.add("element3");
        treeSet.add("element4");
        treeSet.add("element5");
        long start9 = System.nanoTime();
        treeSet.remove("element3");
        long finish9 = System.nanoTime();
        long result9 = finish9 - start9;
        long start10 = System.nanoTime();
        n3=treeSet.first();
        long finish10 = System.nanoTime();
        long result10 = finish10 - start10;

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("element1");
        long start11 = System.nanoTime();
        hashSet.add("element2");
        long finish11 = System.nanoTime();
        long result11 = finish11 - start11;
        hashSet.add("element3");
        hashSet.add("element4");
        hashSet.add("element5");
        long start12 = System.nanoTime();
        hashSet.remove("element3");
        long finish12 = System.nanoTime();
        long result12 = finish12 - start12;
        long start13 = System.nanoTime();
        n4=hashSet.contains("element1");
        long finish13 = System.nanoTime();
        long result13 = finish13 - start13;
        System.out.println("Додавання елементу:   Linked list  " +result1+ " Array List  " +result4+  " Treeset  " +result8+ " HashSet " +result11  );
        System.out.println("Видалення елементу:   Linked list  " +result2+ " Array List  " +result5+  " Treeset  " +result9+ " HashSet " +result12  );
        System.out.println("Знаходження елементу:   Linked list  " +result3+ " Array List  " +result6+  " Treeset  " +result10+ " HashSet " +result13  );
    }
}


/* Додавання: найменший -HashSet, найбільший - TreeSet
   Видалення: найменший -HashSet, найбільший - TreeSet
   Знаходження: найменший -ArrayList, найбільший - TreeSet*/