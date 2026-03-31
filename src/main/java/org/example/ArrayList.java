package org.example;

public class ArrayList<T> {
    private Object[] elements;
    private int size;

    // Инициализирует пустой контейнер без элементов.
    public ArrayList() {
        this.elements = new Object[10];
        this.size = 0;
    }

    // Добавляет элемент в конец контейнера.
    public void addLast(T value) {
        if (size == elements.length) {
            resize();
        }
        elements[size] = value;
        size++;
    }

    // Добавляет элемент в начало контейнера.
    public void addFirst(T value) {
        if (size == elements.length) {
            resize();
        }
        System.arraycopy(elements, 0, elements, 1, size);
        elements[0] = value;
        size++;
    }

    // Вставляет элемент по указанному индексу, сдвигая последующие элементы вправо.
    public void addByIndex(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        if (size == elements.length) {
            resize();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            throw new IllegalStateException("ArrayList is empty");
        }
        System.arraycopy(elements, 1, elements, 0, size - 1);
        elements[size - 1] = null;
        size--;
    }

    public void removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + ", Size: " + size);
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}
