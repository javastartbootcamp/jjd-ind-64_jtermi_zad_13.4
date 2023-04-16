package pl.javastart.task;

import java.util.*;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T>  {

    private T[] arrayOfData;

    public CustomList() {
        arrayOfData = (T[]) new Object[0];
    }

    public void add(T a) {
        arrayOfData = Arrays.copyOf(arrayOfData, arrayOfData.length + 1);
        arrayOfData[arrayOfData.length - 1] = a;
    }

    public void add(int i, T a1) {

        if (i > arrayOfData.length || i < 0) {
            throw new IndexOutOfBoundsException("element tablicy o takim numerze nie moze byc utworzony");
        }

        if ((arrayOfData.length + 1) == 1) {
            add(a1);
        } else {
            arrayOfData = Arrays.copyOf(arrayOfData, arrayOfData.length + 1);
            for (int j = arrayOfData.length - 1; j > i; j--) {
                arrayOfData[j] = arrayOfData[j - 1];
            }
            arrayOfData[i] = a1;
        }
    }

    public T get(int i) {
        return arrayOfData[i];
    }

    public int size() {
        return arrayOfData.length;
    }

    public void remove(int i) {
        if (i + 1 > arrayOfData.length || i < 0) {
            throw new IndexOutOfBoundsException("element tablicy o takim numerze nie istnieje");
        }
        if (i + 1 < arrayOfData.length) {
            for (int j = i + 1; j < arrayOfData.length; j++) {
                arrayOfData[j - 1] = arrayOfData[j];
            }
        }
        arrayOfData = Arrays.copyOf(arrayOfData, arrayOfData.length - 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(arrayOfData);
    }
}

