import java.util.Scanner;

class Node{
    int item;
    Node next;
}
class LinkedList{
    private static Node last,head,ptr,temp;
    private static Scanner input;

    public static void linkCreate(){
        int n;
        char ch = 'y';
        while(ch == 'y'){
            System.out.print("Enter the item you want to insert: ");
           n = input.nextInt();
            temp = new Node();
            temp.item = n;
            temp.next = null;
            if(head == null){
                head = temp;
                last = temp;
            }
            else{
                last.next = temp;
                last = temp;
            }
            System.out.println("\nItem Inserted!");
            System.out.print("You want to insert more? (y/n)");
            ch = input.next().charAt(0);
        }
    }

    public static void firstInsert(){
        int item;
        if(head!=null){
            temp = new Node();
            System.out.print("Enter the number you want to insert: ");
            item = input.nextInt();
            temp.item = item;
            temp.next = head;
            head = temp;
            System.out.println("Item Inserted!");
        }
        else
            System.out.println("List doesn't exist!");
    }
    public static void lastInsert(){
        int item;
        if(head!=null){
          temp = new Node();
            System.out.print("Enter the number you want to insert: ");
            item = input.nextInt();
            temp.item = item;
            temp.next = null;
            ptr = head;
            while(ptr.next != null)
                ptr = ptr.next;

            ptr.next = temp;
            System.out.println("Item Inserted!");
        }
        else
            System.out.println("List is not created!");
    }
    public static void displayList(){
        if(head != null){
            ptr = head;
            while(ptr!=null){
                System.out.print("\t" + ptr.item);
                ptr = ptr.next;
            }
        }
        else
            System.out.println("List doesn't exist!");
    }
    public static void searchList(){
        if(head!=null){
            int item;
            int found = 0;
            System.out.print("Enter the item u want to search: ");
            item = input.nextInt();
            ptr = head;
            while(ptr!=null && found != 1){
                if(ptr.item == item)
                    found = 1;

                ptr = ptr.next;
            }
            if(found == 1)
                System.out.println("Item is found");
            else
                System.out.println("Item is not found");
        }
        else
            System.out.println("List doesn't exist!");
    }

    public static void nthInsert(){
        if(head!= null){
            int c = 0;
            System.out.print("Enter the value u want to insert: ");
            int n = input.nextInt();
            temp = new Node();
            temp.item = n;
            temp.next = null;
            System.out.print("\nEnter the position you want to insert at: ");
            int p = input.nextInt();
            if(p == 1){
                temp.next = head;
                head = temp;
                System.out.println("\nValue Inserted at 1");
            }
            else
            {
                ptr = head;
                while(ptr!=null){
                    c++;
                    ptr = ptr.next;
                }
                if(p == c+1){
                    ptr = head;
                    while(ptr.next!= null)
                        ptr = ptr.next;
                    ptr.next = temp;
                    System.out.println("\nItem inserted at " + p);
                }
                else {
                    if(p > c+1)
                        System.out.println("Position is out of bounds");
                    else {
                        ptr = head;
                        for(int i = 1;i<=p-2;i++)
                            ptr = ptr.next;
                        temp.next = ptr.next;
                        ptr.next = temp;
                        System.out.println("\nItem inserted at " + p);
                    }
                }
            }
        }
        else
            System.out.println("List doesn't exist!");
    }

    public static void main(String[] args) {
        char choice = ' ';
        input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        while(choice != 6){
            System.out.println("\n1: Create List");
            System.out.println("2: Display List");
            System.out.println("3: Insert from start");
            System.out.println("4: Insert from last");
            System.out.println("5: Insert nth term");
            System.out.println("6: Search");
            System.out.println("7: Exit");
            System.out.print("Enter your choice: ");
            choice = input1.next().charAt(0);
            switch (choice){
                case '1':
                    linkCreate();
                    break;
                case '2':
                    displayList();
                    break;
                case '3':
                    firstInsert();
                    break;
                case '4':
                    lastInsert();
                    break;
                case '5':
                    nthInsert();
                    break;
                case '6':
                    searchList();
                    break;
                case '7':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid choice!");
            }
        }
    }
}