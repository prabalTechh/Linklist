package DoublyLinkedList;

public class Insertion {
    public static class Node {
        public int data;
        public Node Next;
        public Node Prev;

        // Constructor for a Node with data, next, and previous references
        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.Next = next;
            this.Prev = prev;
        }

        // Constructor for a Node with only data
        public Node(int data) {
            this(data, null, null);
        }
    }

    static class Insert {
        // Function to create a doubly linked list from an array
        static Node Insertion(int[] arr) {
            Node Head = new Node(arr[0]);
            Node Prev = Head;
            for (int i = 1; i < arr.length; i++) {
                Node temp = new Node(arr[i], null, Prev);
                Prev.Next = temp;
                Prev = temp;
            }
            return Head;
        }

        // Function to print the doubly linked list
        private static void print(Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.Next;
            }
            System.out.println();
        }

        // Function to insert a new node with value 'k' at the end of the doubly linked list
        private static Node insertAtTail(Node head, int k) {
            Node newNode = new Node(k);

            if (head == null) {
                return newNode;
            }

            Node current = head;
            while (current.Next != null) {
                current = current.Next;
            }

            current.Next = newNode;
            newNode.Prev = current;

            return head;
        }

        public static void main(String[] args) {
            int[] arr = {12, 5, 6, 8, 4};
            Node head = Insertion(arr);

            System.out.println("Doubly Linked List Initially:");
            print(head);

            System.out.println("Doubly Linked List After Inserting at the tail:");
            head = insertAtTail(head, 10);
            print(head);
        }
    }
}
