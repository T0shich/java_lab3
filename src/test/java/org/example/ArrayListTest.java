package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    /**
     * Проверка на добавление элементов в список и корректное получение их по индексу
     */
    @Test
    void addOperations() {
        ArrayList<Integer> list = new ArrayList<>();

        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());

        list.addLast(2);
        list.addFirst(1);
        list.addByIndex(2, 4);
        list.addByIndex(2, 3);

        assertEquals(4, list.getSize());
        assertFalse(list.isEmpty());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    /**
     * Проверка на удаление элементов из списка. Удаление первого элемента, последнего элемента и элемента по индексу
     */
    @Test
    void removeOperations() {
        ArrayList<String> list = new ArrayList<>();
        list.addLast("a");
        list.addLast("b");
        list.addLast("c");
        list.addLast("d");

        list.removeFirst();
        assertEquals(3, list.getSize());
        assertEquals("b", list.get(0));

        list.removeLast();
        assertEquals(2, list.getSize());
        assertEquals("c", list.get(1));

        list.removeByIndex(0);
        assertEquals(1, list.getSize());
        assertEquals("c", list.get(0));

    }

    /**
     * Проверка на ошибки при работе с несуществующими индексами
     */
    @Test
    void invalidIndexes() {
        ArrayList<Integer> list = new ArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> list.addByIndex(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.addByIndex(1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeByIndex(0));
    }

    /**
     * Проверка на ошибки при удалении элементов из пустого списка
     */
    @Test
    void removingFromEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();

        assertThrows(IllegalStateException.class, list::removeFirst);
        assertThrows(IllegalStateException.class, list::removeLast);
    }


}
