package recursion;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        printLinkedList(n2);
        Node reversed = reverseList(n2);
        System.out.println();
        printLinkedList(reversed);


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
