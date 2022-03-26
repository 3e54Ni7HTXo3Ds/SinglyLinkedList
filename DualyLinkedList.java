package data.linkedlist;

public class DualyLinkedList<T> {

    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<T> getPrev(Node<T> node) {
        return node.prev;
    }

    Node<T> getNext(Node<T> node) {
        return node.next;
    }


    protected int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        final DualyLinkedList<String> list = new DualyLinkedList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test5");
        list.add("test6");
        list.add("test7");
        list.add("test8");
        list.add("test9");
        System.out.println("получение всего списка");
        System.out.println(list);
        list.printlist(list);
        System.out.println("Размер " + list.size());
        System.out.println();

        System.out.println("получение всего списка по элементам");
        System.out.println("Элемент 7  " + list.get(6));
        System.out.println("Элемент 13 " + list.get(12));
        System.out.println("Элемент 1  " + list.get(0));
        System.out.println("Элемент 2  " + list.get(1));
        System.out.println("Элемент 3  " + list.get(2));
        System.out.println("удаление");
        System.out.println();
        System.out.println("Элемент -1  " + list.remove(-1));
        System.out.println("Элемент 3   " + list.remove(2));
        System.out.println("Элемент 1   " + list.remove(0));
        System.out.println("Элемент 1  " + list.remove(0));
        System.out.println("Размер " + list.size());
        System.out.println(list);
    }


    public T remove(int index) {  // метод еще не переделан
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) { // включает случай size == 1
            final T value = head.value;
            size--;
            head = head.next;
            return value;
        }

        Node<T> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        size--;
        final Node<T> val = prev.next;
        prev.next = val.next;
        return val.value;
    }


    public void add(T value) {      // метод вроде бы переделан
        size++;
        if (head == null) {
            head = new Node<>(value, null, null);
            tail = head;                // если элемент первый - хвост=голова
            return;
        }


        Node<T> prev = tail;


        tail = new Node<>(value, null, prev);
        prev.next = tail;


    }


    public T get(int index) {       // метод еще не переделан
        if (index < 0 || index >= size) {
            return null;
        }

        Node<T> val = this.head;
        for (int i = 0; i < index; i++) {
            if (val.next != null) {
                val = val.next;
            } else {
                return val.value;
            }

        }
        return val.value;
    }

    public Node<T> getNode(int ind) {      // получение ноды
        if (ind < 0 || ind >= size) {
            return null;
        }

        Node<T> val = this.head;
        for (int i = 0; i < ind; i++) {
            if (val.next != null) {
                val = val.next;
            } else {
                return val;
            }
        }
        return val;
    }

    public void printNode(Node node){
        System.out.println(node.next);
    }

    public void printlist(DualyLinkedList list) {

        for (int i = 0; i < list.size; i++) {

            System.out.println("значение " + list.get(i) + " ссылка на предыдущий "
                    + getPrev(getNode(i)) + " ссылка на последующий " + getNext(getNode(i))+"     "+ (getNode(i).toString()));;


        }
    }


    public int size() {
        return size;
    }

    @Override
    public String toString() {

        return "DualLinkedList{" +
                "size=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }


//    public void add(T value) {      // метод вроде бы переделан
//        size++;
//        if (head == null) {
//            head = new Node<>(value, null, null);
//            tail = head;                // если элемент первый - хвост=голова
//            return;
//        }
//
//
//        Node<T> prev = head;
//
//        head = new Node<>(value, null, prev);
//        prev.next = head;
//
//    }

}
