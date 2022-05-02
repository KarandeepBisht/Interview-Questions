class ReverseKAlternate {
    static Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node kAlternate(Node node, int k) {
        Node current = node;
        Node next = null, prev = null;
        int count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (node != null) {
            node.next = current;
        }
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }
        if (current != null) {
            current.next = kAlternate(current.next, k);
        }
        return prev;
    }
    // Node kAlternate(Node head, int k) {
    // return _kAlternate(head, k, true);
    // }

    // Node _kAlternate(Node node, int k, boolean b) {
    // if (node == null) {
    // return null;
    // }
    // int count = 1;
    // Node prev = null;
    // Node current = node;
    // Node next = null;
    // while (current != null && count <= k) {
    // next = current.next;
    // if (b == true) {
    // current.next = prev;
    // }
    // prev = current;
    // current = next;
    // count++;
    // }
    // if (b == true) {
    // node.next = _kAlternate(current, k, !b);
    // return prev;
    // } else {
    // prev.next = _kAlternate(current, k, !b);
    // return node;
    // }
    // }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    void push(int newdata) {
        Node mynode = new Node(newdata);
        mynode.next = head;
        head = mynode;
    }

    public static void main(String[] args) {
        ReverseKAlternate list = new ReverseKAlternate();
        for (int i = 6; i > 0; i--) {
            list.push(i);
        }
        list.printList(head);
        System.out.println();
        head = list.kAlternate(head, 3);
        list.printList(head);
    }
}