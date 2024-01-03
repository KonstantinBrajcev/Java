package list;

//Публичный КЛАСС MyLinkedList
public class MyLinkedList <T>{

    private Node<T> head;

    private static class Node<T>{
        private final T value;
        private Node <T> next;

        public Node(T value){
            this.value = value;
        }

        @Override
        //Переопределение ВЫВОДА значений LinkedList
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
    //Добавление в НАЧАЛО LinkedList
    public void addFirst(T t){
        Node<T> firstNode = new Node<>(t);
        firstNode.next = head;
        head = firstNode;
    }

    //Добавление в КОНЕЦ LinkedList
    public void addLast(T t){
        if(head == null){
            head = new Node<>(t);
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(t);
    }


    //Получение НУЖНОГО индекса записи из LinkedList
    public int get(T t){
        if (head == null) return -1;
        if (head.value.equals(t)) return 0;
        Node<T> currentNode = head;
        int result = 0;
        while (currentNode.next != null){
            result++;
            if (currentNode.next.value.equals(t)) return result;
            currentNode = currentNode.next;
        }
        return -1;
    }

    //Удаление ТРЕБУЕМОЙ записи из LinkedList
    public void remove(T t){
        if (head == null) return;
        if (head.value == t) {
            head = head.next;
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null){
            if (currentNode.next == t) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }

    @Override
    //Переопределение ВЫВОДА LInkedList
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}