import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

public class P4 {
    public static void main(String[] args) {
        // --- 1. Doubly-Linked List End Operations ---
        System.out.println("--- 1. LinkedList as Double-Ended List ---");
        LinkedList<String> taskList = new LinkedList<>();

        taskList.add("Task 2");
        taskList.addFirst("Task 1"); // Inserts at the beginning: O(1)
        taskList.addLast("Task 3");  // Inserts at the end: O(1)

        System.out.println("Current tasks: " + taskList);
        System.out.println("First element: " + taskList.getFirst());
        System.out.println("Last element: " + taskList.getLast());

        taskList.removeFirst(); // Removes "Task 1"
        taskList.removeLast();  // Removes "Task 3"
        System.out.println("After removals: " + taskList);

        // --- 2. LinkedList as a Queue (FIFO: First-In-First-Out) ---
        System.out.println("\n--- 2. LinkedList as a Queue (FIFO) ---");
        Queue<String> printQueue = new LinkedList<>();

        // Enqueue operations
        printQueue.offer("Doc_A.pdf");
        printQueue.offer("Doc_B.pdf");
        printQueue.offer("Doc_C.pdf");

        System.out.println("Front of Queue (peek): " + printQueue.peek());

        // Dequeue operations (removes from front)
        while (!printQueue.isEmpty()) {
            System.out.println("Processing: " + printQueue.poll());
        }

        // --- 3. LinkedList as a Stack (LIFO: Last-In-First-Out) ---
        System.out.println("\n--- 3. LinkedList as a Stack (LIFO) ---");
        Deque<String> backStack = new LinkedList<>();

        // Push operations (add to top of stack)
        backStack.push("Page 1 (Home)");
        backStack.push("Page 2 (Products)");
        backStack.push("Page 3 (Checkout)");

        System.out.println("Top of Stack (peek): " + backStack.peek());

        // Pop operations (removes from top)
        while (!backStack.isEmpty()) {
            System.out.println("Popping: " + backStack.pop());
        }
    }
}

