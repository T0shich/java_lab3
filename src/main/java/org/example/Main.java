package org.example;


public class Main {
    private static final int ITERATIONS = 1000;

    public static void main(String[] args) {


        System.out.println(" ОПЕРАЦИЯ: ADD (Добавление элементов) x" + ITERATIONS + "\n");

        System.out.println("1. ArrayList.addLast():");
        ArrayList<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.addLast(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double avgTime = (double) duration / ITERATIONS;
        printTime("addLast (total)", duration);

        System.out.println("\n2. LinkedList.addLast():");
        LinkedList<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            linkedList.addLast(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        avgTime = (double) duration / ITERATIONS;
        printTime("addLast (total)", duration);

        System.out.println("\n ОПЕРАЦИЯ: GET (Получение элементов) x" + ITERATIONS + "\n");

        // ArrayList - get
        System.out.println("3. ArrayList.get():");
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            arrayList.get(i % arrayList.getSize());
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        avgTime = (double) duration / ITERATIONS;
        printTime("get (total)", duration);

        System.out.println("\n4. LinkedList.getByIndex():");
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            linkedList.getByIndex(i % linkedList.getSize());
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        avgTime = (double) duration / ITERATIONS;
        printTime("getByIndex (total)", duration);

        System.out.println("\n ОПЕРАЦИЯ: DELETE (Удаление элементов) x" + (ITERATIONS / 2) + "\n");

        System.out.println("5. ArrayList.removeLast():");
        startTime = System.nanoTime();
        int removeCount = ITERATIONS / 2;
        for (int i = 0; i < removeCount; i++) {
            if (!arrayList.isEmpty()) {
                arrayList.removeLast();
            }
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        avgTime = (double) duration / removeCount;
        printTime("removeLast (total)", duration);


        System.out.println("\n6. LinkedList.removeLast():");
        startTime = System.nanoTime();
        for (int i = 0; i < removeCount; i++) {
            if (!linkedList.isEmpty()) {
                linkedList.removeLast();
            }
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        avgTime = (double) duration / removeCount;
        printTime("removeLast (total)", duration);


    }

    static void printTime(String operation, long nanoseconds) {
        double milliseconds = nanoseconds / 1_000_000.0;
        double seconds = nanoseconds / 1_000_000_000.0;

        System.out.println("  Операция: " + operation);
        System.out.println("  Наносекунды: " + nanoseconds + " ns");
        System.out.println("  Миллисекунды: " + String.format("%.4f", milliseconds) + " ms");
        System.out.println("  Секунды: " + String.format("%.6f", seconds) + " s");
    }
}
