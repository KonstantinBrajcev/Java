package list;
import java.util.Iterator;

//Это публичный КЛАСС MyArrayList и реализует интерфейс "MyList<E>"
//означает, что он должен предоставлять реализацию всех методов, определенных в интерфейсе "MyList"
//Comparable<Е> - означает что тип "Е" должен быть сравнимым с самим собой
public class MyArrayList <E extends Comparable <E>> implements MyList <E>{

    //Внутри класса определены поля:
    private E[] values;
    private int index;
    private int size;
    private int capacity;


    //Конструктор для инициализации массива:
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.index = 0;
        this.size = 0;
        this.capacity = 10;
        try{
            this.values = (E[]) new Comparable[capacity];
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    //Реализуем добавление элемента в MyList
    //для метода add(E element)
    private void addCapacity () {
        E[] temp = (E[]) new Comparable[capacity+capacity/2];
        System.arraycopy(values, 0, temp, 0, values.length);
        values = temp;
    }

    @Override
    //Добавляем элемент MyList
    public void add(E element) {
        if (size == capacity){
            addCapacity();
        }
        values[size] = element;
        size++;
    }

    @Override
    // Получаем элемент из MyList по индексу
    public E get(int index) {
        return values[index];
    }

    public int geting(E element){
        for (int i = 0; i < values.length; i++) {
            E el = values[i];
            if (el.equals(element)){
                return i;
            }
        }
        return 0;
    }

    @Override
    //Выводим размер массива MyList
    public int size() {
        return size;
    }

    @Override
    //Удаляем элемент по индексу из MyList
    public void delete(int index) {
        E[] temp = (E[]) new Comparable[capacity-1];
        System.arraycopy(values, 0, temp, 0, index);
        int amountElementsAfterIndex = temp.length - index - 1;
        System.arraycopy(values, index+1, temp, index, amountElementsAfterIndex);
        values = temp;
        size--;
    }

    @Override
    //Удаляем требуемый элеимент из MyList
    public void delete(E element) {
        for (int i = 0; i < values.length; i++) {
            E el = values[i];
            if (el.equals(element)){
                delete(i);
            }
        }
    }

    @Override
    // Метод который дает возможность итерироваться по MyList
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            @Override
            //Возвращает булевую возможность дальнейшей итерации
            public boolean hasNext() {
                return index < values.length;
            }
            @Override
            //Возвращает следующий элемент массива
            public E next() {
                return values[index++];
            }
        };
    }

    @Override
    //Переопределение метода для печати MyList
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(values[i]).append(", ");
        }
        if (builder.length() == 1) return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}