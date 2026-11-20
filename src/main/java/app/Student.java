package app;

import java.util.HashSet;
import java.util.TreeSet;

public class Student implements Comparable<Student> {
    private final int id;
    private final String name;
    static long startTime;
    static long endTime;
    static long durationTree;
    static long durationHash;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void compareAddTreeSetHashset(TreeSet<Student> studentTreeSet, HashSet<Student> studentHashSet, Student[] testStudents) {

        startTime = System.nanoTime();
        for (Student student : testStudents) {
            studentTreeSet.add(student);
        }
        endTime = System.nanoTime();
        durationTree = endTime - startTime;

        startTime = System.nanoTime();
        for (Student student : testStudents) {
            studentHashSet.add(student);
        }
        endTime = System.nanoTime();
        durationHash = endTime - startTime;

        System.out.println("Add time for TreeSet: " + durationTree + " nanoseconds");
        System.out.println("Add time for HashSet: " + durationHash + " nanoseconds");
    }

    public static void compareRemoveTreeSetHashSet(TreeSet<Student> studentTreeSet, HashSet<Student> studentHashSet, Student[] testStudents) {

        startTime = System.nanoTime();
        for (Student student : testStudents) {
            studentTreeSet.remove(student);
        }
        endTime = System.nanoTime();
        durationTree = endTime - startTime;

        startTime = System.nanoTime();
        for (Student student : testStudents) {
            studentHashSet.remove(student);
        }
        endTime = System.nanoTime();
        durationHash = endTime - startTime;

        System.out.println("Remove time for TreeSet: " + durationTree + " nanoseconds");
        System.out.println("Remove time for HashSet: " + durationHash + " nanoseconds");
    }

    public static void compareContainsTreeSetHashSet(TreeSet<Student> studentTreeSet, HashSet<Student> studentHashSet, Student[] testStudents) {

        int foundStudentsInTree = 0;
        int foundStudentsInHash = 0;

        startTime = System.nanoTime();
        for (Student student : testStudents) {
            if (studentTreeSet.contains(student)) {
                foundStudentsInTree++;
            }
        }
        endTime = System.nanoTime();
        durationTree = endTime - startTime;

        startTime = System.nanoTime();
        for (Student student : testStudents) {
            if (studentHashSet.contains(student)) {
                foundStudentsInHash++;
            }
        }
        endTime = System.nanoTime();
        durationHash = endTime - startTime;

        System.out.println("Contains time for TreeSet: " + durationTree + " nanoseconds, found: " + foundStudentsInTree);
        System.out.println("Contains time for HashSet: " + durationHash + " nanoseconds, found: " + foundStudentsInHash);
    }

    public static void populator(
            TreeSet<Student> studentTreeSet,
            HashSet<Student> studentHashSet) {

        for (int i = 0; i < 500_000; i++) {
            Student student = new Student(i, String.valueOf(i));
            studentTreeSet.add(student);
            studentHashSet.add(student);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Student other && this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public int compareTo(Student otherStudent) {
        return Integer.compare(this.id, otherStudent.id);
    }
}