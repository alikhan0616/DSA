import java.util.Scanner;

public class circQ {
    static int[] cq = new int[20];
    static int max = 5;
    static int front = -1, rear = -1;

    public static void cqInsert(int item) {
        if (front == 0 && rear == max - 1 || front == rear + 1)
            System.out.println("Queue is overflow...");
        else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else {
                if (rear == max - 1)
                    rear = 0;
                else
                    rear = rear + 1;
            }
            cq[rear] = item;
            System.out.println("\nItem inserted at index: " + rear);
        }
        visualizeArray();
    }

    public static void cqDelete() {
        if (front == -1)
            System.out.println("Queue is underflow...");
        else {
            int item = cq[front];
            System.out.println("Item deleted is: " + item + " at index: " + front);
            cq[front] = -1;  // Mark the deleted position as empty (optional).
            if (front == rear)
                front = rear = -1;
            else {
                if (front == max - 1)
                    front = 0;
                else
                    front = front + 1;
            }
        }
        visualizeArray();
    }

    public static void cqDisplay() {
        if (rear != -1) {
            int num = front;
            System.out.println("Queue elements: ");
            while (true) {
                System.out.print(cq[num] + " ");
                if (num == rear)
                    break;

                num++;
                if (num == max)
                    num = 0;
            }
            System.out.println();
        } else
            System.out.println("Queue is underflow...");
        visualizeArray();
    }

    public static void displayPointers() {
        System.out.println("\nFront: " + front + " Rear: " + rear);
    }

    public static void visualizeArray() {
        System.out.println("\nArray visualization:");
        // Print the array indexes.
        for (int i = 0; i < max; i++) {
            System.out.print("[" + i + "] ");
        }
        System.out.println();

        // Print the array elements.
        for (int i = 0; i < max; i++) {
            if (cq[i] == -1)  // If the position is marked as empty.
                System.out.print("[]  ");  // Empty slot.
            else
                System.out.print(cq[i] + "   ");
        }
        System.out.println();

        // Print the positions of Front and Rear below the array.
        for (int i = 0; i < max; i++) {
            if (i == front && i == rear)
                System.out.print("FR  ");  // Both Front and Rear at same position.
            else if (i == front)
                System.out.print("F   ");  // Front position.
            else if (i == rear)
                System.out.print("R   ");  // Rear position.
            else
                System.out.print("    ");  // Empty space for alignment.
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Initialize the array with a marker for empty slots (optional).
        for (int i = 0; i < max; i++) {
            cq[i] = -1;  // Assuming -1 indicates an empty slot.
        }

        Scanner input = new Scanner(System.in);
        char choice = ' ';

        while (true) {
            System.out.println("\n1: Insert in Circular Queue");
            System.out.println("2: Delete in Circular Queue");
            System.out.println("3: Display Circular Queue");
            System.out.println("4: Exit");
            System.out.print("\nEnter your choice: ");
            choice = input.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter the number to insert: ");
                    int item = input.nextInt();
                    cqInsert(item);
                    break;
                case '2':
                    cqDelete();
                    break;
                case '3':
                    cqDisplay();
                    break;
                case '4':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid choice!");
                    break;
            }
        }
    }
}
