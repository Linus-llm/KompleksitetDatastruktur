package app;

import java.util.*;

import app.ArrayLinkedHelper;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> numbersArrayList = new ArrayList<>();
        LinkedList<Integer> numbersLinkedList = new LinkedList<>();

        for(int i = 0; i < 500000; i++){
            numbersArrayList.add(i);
            numbersLinkedList.add(i);
        }

        ArrayLinkedHelper.compareArrayListAndLinkedListOnGetMethod(numbersArrayList, numbersLinkedList);
        ArrayLinkedHelper.compareArrayListAndLinkedListOnAddMethod(numbersArrayList, numbersLinkedList);
        ArrayLinkedHelper.compareArrayListAndLinkedListOnRemoveMethod(numbersArrayList, numbersLinkedList);
        ArrayLinkedHelper.compareArrayListAndLinkedListOnAddFirstMethod(numbersArrayList, numbersLinkedList);

        //Forklaring af kompleksitet get(index)
        /* ArrayList: For ArrayList kan tiden beskrives med tidskompleksiteten O(1). Det kan det fordi den bruger sit index
        til at finde elementet i det underliggende array.
        LinkedList: For LinkedList kan tiden beskrives med tidskompleksiteten O(n). Den skal følge n referencer for at nå det rigtige
        element. Den starter fra nærmeste ende.
         */
        //Forklaring af kompleksitet add(index, value)
        /* ArrayList: For ArrayList kan tiden beskrives med tidskompleksiteten O(n). Da den skal rykke n elementer en plads til højre.
        LinkedList: For LinkedList kan tiden beskrives med tidskompleksiteten O(n), da den skal følge n referencer og derefter rette pointers.
         */
        //Forklaring af kompleksitet remove(index)
        /* ArrayList: For ArrayList kan tiden beskrives med tidskompleksiteten O(n), da den skal rykke n elementer en plads til venstre.
        LinkedList: For LinkedList kan tiden beskrives med tidskompleksiteten O(n), da den skal følge n referencer igennem og derefter rette pointers.
         */
        //Forklaring af kompleksitet addFirst(value)
        /* ArrayList: For ArrayList kan tiden beskrives med tidskompleksiteten O(n), da den skal rykke n elementer en plads til højre.
        LinkedList: For LinkedList kan tiden beskrives med tidskompleksiteten O(1), da den kun skal rette pointers på den første og anden reference.
         */

        //Hvorfor opfører de sig forskellige, selvom begge implementerer List?
        /*
        List definerer hvilke operation eller metoder som kan bruges, ikke hvordan de er implementeret. Det fortæller ikke noget om hvordan elementer gemmes
        eller håndteres. Det er derfor at de opfører sig forskelligt.
         */

        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < 500000; i++){
            arrayList.add(i);
            hashSet.add(i);
        }

        ListvsHashSetHelper.compareArrayListAndHashSetOnContainForFirstElement(arrayList, hashSet);
        ListvsHashSetHelper.compareArrayListAndHashSetOnContainForLastElement(arrayList,hashSet);
        ListvsHashSetHelper.compareArrayListAndHasSetOnContainForNonExistentElement(arrayList, hashSet);

        /*
        1. kald er ArrayList og her er tidskompleksiteten O(1) pga at det er det første element vi undersøger
        2. kald er HashSet og her er tidskompleksiteten O(1), da den bruger hashkoden til at beregne indekset på den relevante bucket.
        3. kald er ArrayList og her er tidskompleksiteten O(n), pga at den skal tjekke hvert element i listen.
        4. kald er HashSet og her er tidskompleksiteten O(1), da den igen bruger hashkoden til at beregne indekset på bucket'en
        5. kald er ArrayList og her er tidskompleksiteten O(n), pga at den skal tjekke hvert element i listen.
        6. kald er HashSet og her er tidskompleksiteten O(1), da den igen bruger hashkoden til at beregne indekset og ikke finder noget.
        Worst-case for listen er: er et element der ikke findes og det sidste element i en liste. Den skal løbe igennem hele listen i begge scenarier bortset fra det sidste element,
        men det har sådan en lille betydning at det ikke giver mening at sige den ene er bedre end den anden.
         */
        Student n1 = new Student(1,"n1");
        Student n2 = new Student(2, "n2");

        TreeSet<Student> studentTreeSet = new TreeSet<>();
        HashSet<Student> studentHashSet = new HashSet<>();


        studentTreeSet.add(n1); //Tidskompleksitet: O(log n) den skal lave sammenligninger ned i gennem træet som forgrener sig med halvering
        studentHashSet.add(n1); //Tidskompleksitet: O(1) den skal kun give en hashkode og tjekke equals
        studentTreeSet.remove(n1); //Tidskompleksitet: O(log n) den skal lave sammenligninger ned igennem træet indtil at equals() er true
        studentHashSet.remove(n1); //Tidskompleksitet: O(1) den skal beregne hashkode og finde bucket og derefter fjerne objektet
        studentTreeSet.add(n2);
        studentHashSet.add(n2);
        studentTreeSet.contains(n2); //Tidskompleksitet: O(log n) den skal lave sammenligninger ned igennem træet indtil at compareTo() returnerer 0 eller når enden.
        studentHashSet.contains(n2); //Tidskompleksitet: O(1) den skal beregne hashkode og finde bucket. Derefter vil equals() give true eller false

        Student.populator(studentTreeSet, studentHashSet);

        Student[] testStudents = new Student[10_000];

        for (int i = 0; i < testStudents.length; i++) {
            int id = 500_000 + i;
            testStudents[i] = new Student(id, String.valueOf(id));
        }

        Student.compareAddTreeSetHashset(studentTreeSet, studentHashSet, testStudents);
        Student.compareContainsTreeSetHashSet(studentTreeSet, studentHashSet, testStudents);
        Student.compareRemoveTreeSetHashSet(studentTreeSet, studentHashSet, testStudents);


        /*
        TreeSet bruger compareTo().
        HashSet bruger equals() og hashCode().
        Det er vigtigt at man husker at sætte compare op til det der gør objekter unikke.
         */

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        ArrayDeque<Integer> aDeque = new ArrayDeque<>();
        ArrayDeque<Integer> aQueue = new ArrayDeque<>();

        //Tidskompleksiteten for PriorityQueue og indsættelse er O(log n), da den er bygget op som et træ. (heap) .offer() og .add()
        //Tidskompleksiteten for PriorityQueue og fjernelse af element er O(log n), da den fjerner head fra queue'en og derefter skal genjustere træet.
        // head bestemmes efter prioritet.

        //Tidskompleksiteten for ArrayDeque som stak med indsættelse er O(1) amortiseret. O(n) hvis stakken skal udvides. .push()
        //Tidskompleksiteten for ArrayDeque som stak med fjernelse af element er O(1). O(n) hvis det er det sidste element fordi der skal poppes n gange. .pop()
        // LIFO - Last in First out

        //Tidskompleksiteten for ArrayDeque som kø med indsættelse er O(1) amortiseret, da vi indsætter fra toppen eller bunden, men hvis array'et skal udvides er worst case O(n)
        //Tidskompleksiteten for ArrayDeque som kø med fjernelse af element er i worst case O(1), da den altid fjerner enten det forreste eller bagerste element
        // FIFO - First in First out er muligt med kø.

        //Hvilket element tager vi ud af hver struktur?
        //PriorityQueue tager vi head ud som bestemmes efter prioritet med poll
        //ArrayDeque som stak tager vi det sidste element ud først med pop
        //ArrayDeque som kø tager vi det første element ud med poll.


        //Hvad skal strukturen gøre, når der sættes et element ind eller tages et ud, for at det rigtige element står klar næste gang?

        //PriorityQueue ved indsættelse bliver elementet placeret ved næste ledige plads nederst,
        // hvis højere prioritet flyttes det op indtil at det er på plads.

        //PriorityQueue ved fjernelse bliver head fjernet og det sidste element sættes som head, hvis et af børnene har højere prioritet,
        // så byttes der plads gentages indtil barnet med højest prioritet er head.

        //ArrayDeque(stak) ved indsættelse bliver elementet bare indsat i toppen og opdaterer indekset
        //ArrayDeque(stak) ved fjernelse bliver det forrest element fjernet og lader indekset pege på den nye top

        //ArrayDeque(kø) ved fjernelse bliver elementet fjernet fra enden og opdaterer indeks for bagende
        //ArrayDeque(kø) ved indsættelse bliver elementet sat ind fra starten af kø'en og indeks opdateres for forenden.


        //Hvorfor er der forskel på PriorityQueue og ArrayDeque, når de begge er køer?

        //Grunden til at der er forskel er på grund af deres implementation. Den ene bruger compareTo() og har en heap struktur.
        //Den anden bruger en listestruktur

    }
}