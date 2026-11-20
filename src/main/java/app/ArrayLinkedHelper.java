package app;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayLinkedHelper {
    static long startTime;
    static long endTime;
    static long durationArray;
    static long durationLinked;

    public static void compareArrayListAndLinkedListOnGetMethod(ArrayList<Integer> numbersArrayList, LinkedList<Integer> numbersLinkedList) {
        startTime = System.nanoTime();
        numbersArrayList.get(250000);
        endTime = System.nanoTime();
        durationArray = endTime - startTime;

        startTime = System.nanoTime();
        numbersLinkedList.get(250000);
        endTime = System.nanoTime();
        durationLinked = endTime - startTime;

        System.out.println("Access time for ArrayList: " + durationArray + " nanoseconds");
        System.out.println("Access time for LinkedList: " + durationLinked + " nanoseconds");
    }

    public static void compareArrayListAndLinkedListOnAddMethod (ArrayList<Integer> numbersArrayList, LinkedList<Integer> numbersLinkedList){
        startTime = System.nanoTime();
        numbersArrayList.add(250000,99);
        endTime = System.nanoTime();
        durationArray = endTime - startTime;

        startTime = System.nanoTime();
        numbersLinkedList.add(250000,99);
        endTime = System.nanoTime();
        durationLinked = endTime - startTime;

        System.out.println("Add time for ArrayList: " + durationArray + " nanoseconds");
        System.out.println("Add time for LinkedList: " + durationLinked + " nanoseconds");
    }

    public static void compareArrayListAndLinkedListOnRemoveMethod(ArrayList<Integer> numbersArrayList, LinkedList<Integer> numbersLinkedList){
        startTime = System.nanoTime();
        numbersArrayList.remove(250000);
        endTime = System.nanoTime();
        durationArray = endTime - startTime;

        startTime = System.nanoTime();
        numbersLinkedList.remove(250000);
        endTime = System.nanoTime();
        durationLinked = endTime - startTime;

        System.out.println("remove time for ArrayList: " + durationArray + " nanoseconds");
        System.out.println("remove time for LinkedList: " + durationLinked + " nanoseconds");
    }

    public static void compareArrayListAndLinkedListOnAddFirstMethod(ArrayList<Integer> numbersArrayList, LinkedList<Integer> numbersLinkedList){
        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++){
            numbersArrayList.add(0,67);
        }
        endTime = System.nanoTime();
        durationArray = endTime - startTime;

        startTime = System.nanoTime();
        for(int i= 0; i < 10000; i++) {
            numbersLinkedList.add(0, i);
        }
        endTime = System.nanoTime();
        durationLinked = endTime - startTime;

        System.out.println("addFirst time for ArrayList: " + durationArray + " nanoseconds (method called 10000)");
        System.out.println("addFirst time for LinkedList: " + durationLinked + " nanoseconds (method called 10000)");
    }
}
