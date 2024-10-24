import java.util.Scanner;
class Delnode {
    int item;
    Delnode next;
}
public class delLinkedList {
static Delnode last,temp,ptr,head,prevptr;
static Scanner input;

public static void createList(){
    char ch = 'y';
    while(ch == 'y') {
        temp = new Delnode();
        System.out.print("Enter the number u want to insert: ");
        int item = input.nextInt();
        temp.item = item;
        temp.next = null;
        if (head == null) {
            head = temp;
            last = temp;
        } else {
            ptr = head;
            while(ptr.next!= null)
                ptr = ptr.next;
            ptr.next = temp;
        }
        System.out.println("Item inserted");
        System.out.print("Would you like to keep adding (y/n): ");
        ch = input.next().charAt(0);
    }
}
public static void displayList(){
    if(head!= null) {
        ptr = head;
        System.out.print("List:");
        while (ptr != null) {
            System.out.print("\t" + ptr.item);
            ptr = ptr.next;
        }
    }
    else
        System.out.println("List doesn't exist!");
}
public static void deleteFirst(){
    if(head != null){
        temp = head;
        head = head.next;
        System.out.println("Item deleted is: " + temp.item);
        temp = null;
    }
    else
        System.out.println("List doesn't exist!");
}
public static void deleteLast(){
    if(head != null){
        ptr = head;
        while(ptr.next!=null) {
            prevptr = ptr;
            ptr = ptr.next;
        }
        if(ptr == head){
            System.out.println("Item deleted is: " + ptr.item);
            head=null;
        }
        else {
            System.out.println("Item deleted is: " + ptr.item);
            prevptr.next = null;
            ptr = null;
        }
    }
    else
        System.out.println("List doesn't exist!");
}
public static void nthDelete(){
    if(head != null){
        int c = 0;
        System.out.print("Enter the position you want to delete from: ");
        int p = input.nextInt();
        if(p == 1){
            temp = head;
            head = head.next;
            System.out.println("Item deleted is: " + temp.item);
            temp = null;
        }
        else {
            ptr = head;
            while(ptr!=null) {
                c++;
                ptr = ptr.next;
            }
            if(p == c){
                ptr = head;
                while(ptr.next != null){
                    prevptr = ptr;
                    ptr = ptr.next;
                }
                prevptr.next = null;
                System.out.println("Item deleted is: " + ptr.item);
                ptr = null;
                }
            else{
                if(p > c)
                    System.out.println("Position doesn't exist");
                else{
                    ptr = head;
                    for(int i = 1;i<=p-1;i++){
                        prevptr = ptr;
                        ptr = ptr.next;
                    }
                    prevptr.next = ptr.next;
                    System.out.println("Item deleted is: " + ptr.item );
                    ptr = null;
                }
            }
            }
        }
    else
        System.out.println("List doesn't Exist!");
    }
    public static void searchDelete(){
    int found = 0;
    if(head != null){
        System.out.print("Enter the item you want to delete: ");
        int item = input.nextInt();
        ptr = head;
        while(ptr.next!= null ){
            prevptr = ptr;
            ptr = ptr.next;
            if(ptr.item == item){
                found = 1;
                System.out.println("\nItem deleted is: " + ptr.item);
                temp = ptr;
                prevptr.next = ptr.next;
                temp = null;
            }
        }
        if(found == 0)
            System.out.println("Item was not found!");
    }
    else
        System.out.println("List doesn't exist!");
    }

    public static void main(String[] args) {
        char choice = ' ';
       input = new Scanner(System.in);
        while(true){
            System.out.println("\n1: Create List/Add to list");
            System.out.println("2: Display");
            System.out.println("3: Delete from first");
            System.out.println("4: Delete from last");
            System.out.println("5: Delete nth term");
            System.out.println("6: Search Delete");
            System.out.println("7: Exist");
            System.out.print("\nEnter your choice: ");
            choice = input.next().charAt(0);

            switch (choice){
                case '1':
                    createList();
                    break;
                case '2':
                    displayList();
                    break;
                case '3':
                    deleteFirst();
                    break;
                case '4':
                    deleteLast();
                    break;
                case '5':
                    nthDelete();
                    break;
                case '6':
                    searchDelete();
                    break;
                case '7':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid choice!");
                    break;
            }
        }
    }
}


