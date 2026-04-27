package org.example;

public class Main {
    private static final int ITERATIONS = 1000;

    public static void main(String[] args) {

        long timeArrAddLast, timeLnkAddLast;
        long timeArrAddFirst, timeLnkAddFirst;
        long timeArrGet, timeLnkGet;
        long timeArrRemLast, timeLnkRemLast;
        long timeArrRemFirst, timeLnkRemFirst;

        ArrayList<Integer> arrLast = new ArrayList<>();
        LinkedList<Integer> lnkLast = new LinkedList<>();

        /**
         * Проверка добавления в конец списка
         */
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) arrLast.addLast(i);
        timeArrAddLast = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) lnkLast.addLast(i);
        timeLnkAddLast = System.nanoTime() - startTime;

        /**
         * Проверка получения элемента по индексу
         */
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) arrLast.get(i % arrLast.getSize());
        timeArrGet = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) lnkLast.get(i % lnkLast.getSize());
        timeLnkGet = System.nanoTime() - startTime;

        ArrayList<Integer> arrFirst = new ArrayList<>();
        LinkedList<Integer> lnkFirst = new LinkedList<>();

        /**
         * Проверка добавления в начало списка
         */
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) arrFirst.addFirst(i);
        timeArrAddFirst = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) lnkFirst.addFirst(i);
        timeLnkAddFirst = System.nanoTime() - startTime;

        /**
         *  Проверка удаления первого элемента из списка
         */
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
           arrFirst.removeFirst();
        }
        timeArrRemFirst = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            lnkFirst.removeFirst();
        }
        timeLnkRemFirst = System.nanoTime() - startTime;

        /**
         *  Проверка удаления последнего элемента из списка
         */
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            arrLast.removeLast();
        }
        timeArrRemLast = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            lnkLast.removeLast();
        }
        timeLnkRemLast = System.nanoTime() - startTime;

        System.out.println("\n" + "=".repeat(110));
        System.out.printf("%-25s | %-15s | %-25s | %-20s\n",
                "Название метода", "Кол-во вызовов", "Время (наносекунды)", "Время (миллисекунды)");
        System.out.println("-".repeat(110));

        String row = "%-25s | %-15d | %-25d | %-20.4f\n";

        System.out.printf(row, "ArrayList.addLast", ITERATIONS, timeArrAddLast, timeArrAddLast / 1000000.0);
        System.out.printf(row, "LinkedList.addLast", ITERATIONS, timeLnkAddLast, timeLnkAddLast / 1000000.0);
        System.out.println("-".repeat(110));

        System.out.printf(row, "ArrayList.addFirst", ITERATIONS, timeArrAddFirst, timeArrAddFirst / 1000000.0);
        System.out.printf(row, "LinkedList.addFirst", ITERATIONS, timeLnkAddFirst, timeLnkAddFirst / 1000000.0);
        System.out.println("-".repeat(110));

        System.out.printf(row, "ArrayList.get", ITERATIONS, timeArrGet, timeArrGet / 1000000.0);
        System.out.printf(row, "LinkedList.getByIndex", ITERATIONS, timeLnkGet, timeLnkGet / 1000000.0);
        System.out.println("-".repeat(110));

        System.out.printf(row, "ArrayList.removeFirst", ITERATIONS, timeArrRemFirst, timeArrRemFirst / 1000000.0);
        System.out.printf(row, "LinkedList.removeFirst", ITERATIONS, timeLnkRemFirst, timeLnkRemFirst / 1000000.0);
        System.out.println("-".repeat(110));

        System.out.printf(row, "ArrayList.removeLast", ITERATIONS, timeArrRemLast, timeArrRemLast / 1000000.0);
        System.out.printf(row, "LinkedList.removeLast", ITERATIONS, timeLnkRemLast, timeLnkRemLast / 1000000.0);

        System.out.println("=".repeat(110));
    }
}