import java.util.Scanner;

public class pQueue {
    static pQueue[] pq;
    static int count = -1;
    static int max = 5;
    int value;
    int priority;

    public static void pqInsert(int item, int p) {
        if (count == max - 1)
            System.out.println("Priority Queue is full...");
        else {
            count++;
            pq[count].value = item;
            pq[count].priority = p;
            System.out.println("Value: " + item + " Priority: " + p + " At index: " + count);
        }
        visualizeArray();
    }

    public static void pqDelete() {
        if (count == -1)
            System.out.println("Priority Queue is empty");
        else {
            int location = 0;
            int maxPr = pq[0].priority;

            for (int i = 1; i <= count; i++) {
                if (maxPr < pq[i].priority) {
                    maxPr = pq[i].priority;
                    location = i;
                }
            }
            System.out.println("\nItem deleted is: " + pq[location].value + " With priority: " + pq[location].priority + " At index: " + location);

            // Shift remaining elements
            for (int i = location; i < count; i++) {
                pq[i].value = pq[i + 1].value;
                pq[i].priority = pq[i + 1].priority;
            }
            count--;  // Decrement count
        }
        visualizeArray();
    }

    public static void display() {
        if (count == -1)
            System.out.println("Priority Queue is empty");
        else {
            visualizeArray();
        }
    }

    public static void visualizeArray() {
        System.out.println("\nArray visualization:");

        // Print array indexes
        for (int i = 0; i < max; i++) {
            System.out.print("[" + i + "]   ");
        }
        System.out.println();

        // Print values and priorities
        for (int i = 0; i < max; i++) {
            if (i <= count)
                System.out.print(pq[i].value + "(" + pq[i].priority + ") ");
            else
                System.out.print("[]   ");  // Empty slot
        }
        System.out.println();
    }

    public static void main(String[] args) {
        pq = new pQueue[max];  // Initialize the array
        for (int i = 0; i < max; i++) {
            pq[i] = new pQueue();
        }

        Scanner input = new Scanner(System.in);
        char choice;

        while (true) {
            System.out.println("\n1: Insert in priority queue");
            System.out.println("2: Delete from priority queue");
            System.out.println("3: Display priority queue");
            System.out.println("4: Exit");
            System.out.print("\nEnter your choice: ");

            choice = input.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("\nEnter the item you want to insert: ");
                    int value = input.nextInt();
                    System.out.print("Enter its priority: ");
                    int priority = input.nextInt();
                    pqInsert(value, priority);
                    break;
                case '2':
                    pqDelete();
                    break;
                case '3':
                    display();
                    break;
                case '4':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid choice!");
            }
        }
    }
}
