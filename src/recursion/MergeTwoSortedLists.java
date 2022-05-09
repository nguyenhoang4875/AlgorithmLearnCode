package recursion;

public class MergeTwoSortedLists {


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(5);
        Node n3 = new Node(13);
        Node n4 = new Node(14);
        Node n5 = new Node(550);

        Node n1_1 = new Node(2);
        Node n2_2 = new Node(15);
        Node n3_3 = new Node(130);
        Node n4_4 = new Node(200);
        Node n5_5 = new Node(350);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        n1_1.setNext(n2_2);
        n2_2.setNext(n3_3);
        n3_3.setNext(n4_4);
        n4_4.setNext(n5_5);

        Node sortMerge = mergeLists(n1, n1_1);
        printLinkedList(sortMerge);

    }

    public static Node mergeLists(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        if (n1.val <= n2.val) {
            n1.next = mergeLists(n1.next, n2);
            return n1;
        } else {
            n2.next = mergeLists(n1, n2.next);
            return n2;
        }

    }

    public static Node reverseList(Node node) {
        if (node == null || node.next == null) {
            return node; // the node end of the LinkedList
        }
        Node p = reverseList(node.next);// the node end of the LinkedList
        node.next.next = node; // node.next.next == p.next (add backward node)
        node.next = null; // break forward node
        return p;

    }

    public static void printLinkedList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.getNext();
        }
    }

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
