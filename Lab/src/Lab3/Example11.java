package Lab3;

public class Example11 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};

        NodeForExample11 headList = createFromHead(values);
        System.out.println("Список, созданный с головы:");
        printList(headList);

        NodeForExample11 tailList = createFromTail(values);
        System.out.println("Список, созданный с хвоста:");
        printList(tailList);
    }

    private static NodeForExample11 createFromHead(int[] values) {
        NodeForExample11 head = null;
        for (int value : values) {
            head = new NodeForExample11(value, head);
        }
        return head;
    }

    private static NodeForExample11 createFromTail(int[] values) {
        NodeForExample11 head = null;
        NodeForExample11 tail = null;

        for (int value : values) {
            NodeForExample11 newNode = new NodeForExample11(value, null);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    private static void printList(NodeForExample11 head) {
        NodeForExample11 current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class NodeForExample11 {
    int value;
    NodeForExample11 next;

    NodeForExample11(int value, NodeForExample11 next) {
        this.value = value;
        this.next = next;
    }
}
