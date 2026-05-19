package Lab3;

public class Example12 {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.createTail(new int[]{1, 2, 3, 4});
        System.out.println("Создание с хвоста: " + list);

        list.addFirst(0);
        System.out.println("После addFirst(0): " + list);

        list.addLast(5);
        System.out.println("После addLast(5): " + list);

        list.insert(3, 99);
        System.out.println("После insert(3, 99): " + list);

        list.removeFirst();
        System.out.println("После removeFirst(): " + list);

        list.removeLast();
        System.out.println("После removeLast(): " + list);

        list.remove(2);
        System.out.println("После remove(2): " + list);

        SinglyLinkedList recursiveList = new SinglyLinkedList();
        recursiveList.createTailRec(new int[]{10, 20, 30, 40});
        System.out.println("Рекурсивное создание с хвоста: " + recursiveList.toStringRec());

        SinglyLinkedList recursiveHeadList = new SinglyLinkedList();
        recursiveHeadList.createHeadRec(new int[]{10, 20, 30, 40});
        System.out.println("Рекурсивное создание с головы: " + recursiveHeadList.toStringRec());
    }
}

class SinglyLinkedList {
    private ListNode head;

    public void createHead() {
        createHead(new int[]{1, 2, 3, 4, 5});
    }

    public void createHead(int[] values) {
        head = null;
        for (int value : values) {
            addFirst(value);
        }
    }

    public void createTail() {
        createTail(new int[]{1, 2, 3, 4, 5});
    }

    public void createTail(int[] values) {
        head = null;
        for (int value : values) {
            addLast(value);
        }
    }

    public void addFirst(int value) {
        head = new ListNode(value, head);
    }

    public void addLast(int value) {
        ListNode newNode = new ListNode(value, null);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(int index, int value) {
        if (index <= 0 || head == null) {
            addFirst(value);
            return;
        }

        ListNode current = head;
        int currentIndex = 0;
        while (current.next != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        current.next = new ListNode(value, current.next);
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void remove(int index) {
        if (head == null) {
            return;
        }
        if (index <= 0) {
            removeFirst();
            return;
        }

        ListNode current = head;
        int currentIndex = 0;
        while (current.next != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void createHeadRec() {
        createHeadRec(new int[]{1, 2, 3, 4, 5});
    }

    public void createHeadRec(int[] values) {
        head = null;
        createHeadRec(values, 0);
    }

    private void createHeadRec(int[] values, int index) {
        if (index == values.length) {
            return;
        }
        addFirst(values[index]);
        createHeadRec(values, index + 1);
    }

    public void createTailRec() {
        createTailRec(new int[]{1, 2, 3, 4, 5});
    }

    public void createTailRec(int[] values) {
        head = null;
        head = createTailRec(values, 0);
    }

    private ListNode createTailRec(int[] values, int index) {
        if (index == values.length) {
            return null;
        }
        return new ListNode(values[index], createTailRec(values, index + 1));
    }

    public String toStringRec() {
        return toStringRec(head).trim();
    }

    private String toStringRec(ListNode current) {
        if (current == null) {
            return "";
        }
        return current.value + " " + toStringRec(current.next);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            result.append(current.value).append(' ');
            current = current.next;
        }
        return result.toString().trim();
    }
}

class ListNode {
    int value;
    ListNode next;

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
