import java.util.Scanner;
public class deQue {
    final static int[] data = new int[20];
    static int left = 0;
    static int right = -1;
    static int count=0;
    static int max = 5;

    public static void insertLeft(int item){
        if(count == max)
            System.out.println("Queue is full");
        else {
            left--;
            if(left < 0)
                left = max-1;

            data[left] = item;
            count++;
        }
    }
    public static void insertRight(int item){
        if(count == max)
            System.out.println("Queue is full");
        else{
            right++;
            if(right >=max)
                right = 0;

            data[right] = item;
            count++;
        }
    }
    public static void delLeft(){
        if(count == 0)
            System.out.println("Queue is empty");
        else {
            int item;
            item = data[left];
            System.out.println(item);
            left++;
            if (left >= max)
                left = 0;
            count--;
        }
    }
    public static void delRight(){
        if(count == 0)
            System.out.println("Queue is empty");
        else {
            int item;
            item = data[right];
            System.out.println(item);
            right--;
            if(right<0)
                right = max-1;
            count--;
        }
    }
    public static void display(){
        if(count ==0)
            System.out.println("Queue is empty");
        else{
            int i = left;
            System.out.print("Queue has: ");
            for(int j=0; j<count;j++){
                System.out.print(data[i] + " ");
                i++;
                if(i > max-1)
                    i = 0;
            }
        }
    }
    public static void displayOperators(){
        System.out.println("\nLeft: " + left);
        System.out.println("Right: " + right);
    }

    public static void main(String[] args) {
        char choice = ' ';
        Scanner input = new Scanner(System.in);
        int item;
        while(true){
            System.out.println("\n1: Insert from Right");
            System.out.println("2: Insert from Left");
            System.out.println("3: Delete from Right");
            System.out.println("4: Delete from Left");
            System.out.println("5: Display");
            System.out.println("6: Exit");

            System.out.print("\nYour Choice: ");
            choice = input.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter value to insert from right: ");
                    item = input.nextInt();
                    insertRight(item);
                    break;
                case '2':
                    System.out.print("Enter value to insert from left: ");
                    item = input.nextInt();
                    insertLeft(item);
                    break;
                case '3':
                    System.out.println("Delete from right...");
                    delRight();
                    break;
                case '4':
                    System.out.println("Deleting from left...");
                    delLeft();
                    break;
                case '5':
                    display();
                    break;
                case '6':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid choice!");
                    break;
            }
            displayOperators();
        }
    }
}
