import java.util.Arrays;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
    };
    public void add(int index, E element) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) elements[i + 1] = elements[i];
        elements[index] = element;
        size++;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements, 0, newData, 0, size);
            elements = newData;
        }
    };

    public E remove(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");
        E e = (E) elements[index];
        for (int j = index; j < size - 1; j++)
            elements[j] = elements[j + 1];
        elements[size - 1] = null;
        size--;
        return e;
    }

}
