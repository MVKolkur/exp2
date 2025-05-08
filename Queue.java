package one;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class Queue {
    private Node front, rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }
    public void insertion(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public int deletion() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public int peek() {
        if (front == null) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.insertion(10);
        queue.insertion(20);
        queue.insertion(30);
        queue.display();

        System.out.println("deleted: " + queue.deletion());
        queue.display();
        System.out.println(queue.peek());
    }
}