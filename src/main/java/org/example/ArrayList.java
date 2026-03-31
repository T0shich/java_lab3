package org.example;

import java.util.Arrays;

/**
 * Реализация динамического массива (ArrayList)
 * @param <T> - тип элементов, хранящихся в контейнере
 */

public class ArrayList<T> {
    private Object[] elements;
    private int size;

    public ArrayList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    /**
     * Добавление элемента в конец контейнера. Если массив заполнен, он расширяется.
     * @param value - элемент, который нужно добавить в контейнер
     */
    public void addLast(T value) {
        if (size == elements.length) {
            resize();
        }
        elements[size] = value;
        size++;
    }

    /**
     * Добавление элемента в начало контейнера. Если массив заполнен, он расширяется.
     * @param value - элемент, который нужно добавить в контейнер
     */
    public void addFirst(T value) {
        if (size == elements.length) {
            resize();
        }
        for (int i = size; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = value;
        size++;
    }

    /**
     * Добавляет элемент по указанному индексу, сдвигая последующие элементы вправо. Если массив заполнен, он расширяется.
     * @param index - индекс после которого нужно вставить значение
     * @param value -  элемент, который нужно добавить в контейнер
     */
    public void addByIndex(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        if (size == elements.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
        size++;
    }

    /**
     * Удадение первого элемент из контейнера.
     */
    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("ArrayList is empty");
        }
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    public void removeLast() {
        if (size == 0) {
            throw new IllegalStateException("ArrayList is empty");
        }
        elements[size - 1] = null;
        size--;
    }

    /**
     * Удадение элемент по индексу.
     * @param index - индекс после которого нужно удалить значение
     */
    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    /**
     * Измененние размера массива в два раза
     */
    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * Получение элемента по индексу.
     * @param index - индекс элемента, который нужно получить
     * @return элемент по указанному индексу
     */

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    /**
     * Возвращает размер контейнера (количество элементов).
     * @return количество элементов в контейнере
     */
    public int getSize() {
        return size;
    }

    /**
     * Проверяет, пуст ли контейнер.
     * @return true если контейнер пуст, иначе false
     */
    public boolean isEmpty() {
        return size == 0;
    }
}