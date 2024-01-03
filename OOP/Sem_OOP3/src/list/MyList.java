package list;

//Это публичный ИНТЕРФЕЙС MyList
//Comparable<T> - означает что тип "T" должен быть сравнимым с самим собой
//он расширяет интерфейс "Iterable<T>" - должен предоставлять методы для итерации по элементам списка
public interface MyList <T extends Comparable<T>> extends Iterable<T> {

    //Добавляем элемент MyList с реализацией в MyArrayList
    void add(T element);

    //Удаляем элемент MyList по индексу, с реализацией в MyArrayList
    void delete(int index);

    //Удаляем конкретный элемент, MyList с реализацией в MyArrayList
    void delete(T element);

    //Получаем элемент MyList по индексу, с реализацией в MyArrayList
    T get(int index);

    //Получаем размер MyList с реализацией в MyArrayList
    int size();

    int geting(T element);
}