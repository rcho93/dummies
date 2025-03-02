import java.util.*;

public class List<T> {
    T[] list = (T[]) new Object[100000]; 
    int size = 0;

    public List() {
    }

    public void add(T input) {
        list[size++] = input;
    }

    public T get(int index) {
        return list[index];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        List<Integer> lt = new List<>();

        lt.add(2);
        lt.add(3);
        lt.add(4);
        lt.add(4);
        lt.add(4);
        lt.add(4);
        lt.add(4);
        lt.add(4);
        lt.add(4);
        lt.add(4);
        System.out.println(lt.size());
        System.out.println(lt.get(1));
    }

}