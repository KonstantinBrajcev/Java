import list.MyArrayList;
import list.MyLinkedList;
import list.MyList;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        Работаем с MyList
        MyList<String> list = new MyArrayList<>();
        list.add("2");
        list.add("used");
        list.add("20");
        list.add("green");
        list.delete(1);
//        System.out.println(list.get(0));
        System.out.println(list);
        System.out.println(2);

//        Работаем с LinkedList ==HOMEWORK==
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.addLast("Dostaevskiy");
        linkedList.addLast("Pushkin");
        linkedList.addLast("Dovlatov");
        linkedList.addLast("Aristotel");
        linkedList.addLast("Esenin");
        linkedList.addFirst("Kafka");
        linkedList.addFirst("Napoleon");
        linkedList.addLast("Petr I");
//        System.out.println("LinkedList - " + linkedList);
//        System.out.println("Index element - " + linkedList.get("Aristotel"));
//        System.out.println("Index element - " + linkedList.get("Tolstoy"));
        linkedList.remove("Kafka");
        System.out.println("LinkedList - " + linkedList);
        System.out.println(linkedList.get("Kafka"));
        System.out.println(linkedList.get("Esenin"));
//        System.out.println(linkedList.get(5));
    }
}