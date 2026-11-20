package app;

import java.util.ArrayList;
import java.util.HashSet;

public class ListvsHashSetHelper {
    static long startTime;
    static long endTime;
    static long durationArray;
    static long durationSet;
    public static void compareArrayListAndHashSetOnContainForFirstElement(ArrayList<Integer> arrayList, HashSet<Integer> hashSet){
        startTime = System.nanoTime();
        arrayList.contains(0);
        endTime = System.nanoTime();
        durationArray = endTime - startTime;

        startTime = System.nanoTime();
        hashSet.contains(0);
        endTime = System.nanoTime();
        durationSet = endTime - startTime;
        System.out.println("contain time for first element ArrayList: " + durationArray + " nanoseconds");
        System.out.println("contain time for first element HashSet: " + durationSet + " nanoseconds");

    }

    public static void compareArrayListAndHashSetOnContainForLastElement(ArrayList<Integer> arrayList, HashSet<Integer> hashSet){
        int arrayLast = arrayList.getLast();
        startTime = System.nanoTime();
        arrayList.contains(arrayLast);
        endTime = System.nanoTime();
        durationArray = endTime - startTime;

        int setLast = hashSet.size()-1;
        startTime = System.nanoTime();
        hashSet.contains(setLast);
        endTime = System.nanoTime();
        durationSet = endTime - startTime;
        System.out.println("contain time for last element ArrayList: " + durationArray + " nanoseconds, number being used: "+arrayLast);
        System.out.println("contain time for last element HashSet: " + durationSet + " nanoseconds, number being used: "+setLast);
    }

    public static void compareArrayListAndHasSetOnContainForNonExistentElement(ArrayList<Integer> arrayList, HashSet<Integer> hashSet){
        int nonExistent = arrayList.getLast()+1;
        startTime = System.nanoTime();
        boolean foundArray= arrayList.contains(nonExistent);
        endTime = System.nanoTime();
        durationArray = endTime - startTime;

        int nonExistentSet = hashSet.size();
        startTime = System.nanoTime();
        boolean found = hashSet.contains(nonExistentSet);
        endTime = System.nanoTime();
        durationSet = endTime - startTime;
        System.out.println("contain time for non existent element ArrayList: " + durationArray + " nanoseconds, found in set: "+foundArray);
        System.out.println("contain time for non existent element HashSet: " + durationSet + " nanoseconds, found in set: "+found);
    }
}
