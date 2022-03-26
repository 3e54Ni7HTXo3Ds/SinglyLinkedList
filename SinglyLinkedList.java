package data.linkedlist;

/**
 * Singly linked list.
 *
 * @author Vladimir Ivanov (ivanov.vladimir.l@gmail.com)
 */
public class SinglyLinkedList<T> {


	static class Node<T> {
		T value;
		Node<T> next;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	protected int size = 0;
	private Node<T> head;

	public static void main(String[] args) {
		final SinglyLinkedList<String> list = new SinglyLinkedList<>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		System.out.println("получение");
		System.out.println(list.size());
		System.out.println(list.get(6));
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println("удаление");
		System.out.println(list.remove(-1));
		System.out.println(list.remove(2));
		System.out.println(list.remove(0));
		System.out.println(list.remove(0));
		System.out.println(list.size());
	}

	public T remove(int index) {
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

	public void add(T value) {
		size++;
		if (head == null) {
			head = new Node<>(value, null);
			return;
		}

		head = new Node<>(value, head);
	}












	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		Node<T> val = this.head;
		for (int i = 0; i < index; i++) {
			val = val.next;
		}
		return val.value;
	}

	public int size() {
		return size;
	}


}
