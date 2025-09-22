import java.util.*;
class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phone ;
    }
}
public class ContactManagement {
    static ArrayList<Contact> contactList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Phone: ");
        String phone = sc.next();
        contactList.add(new Contact(name, phone));
        System.out.println("Contact added successfully!👍️\n");}
    public static void updatecontact() {
    	System.out.print("Enter name to update: ");
        String nameToUpdate = sc.next();
        boolean found=false;
        for (Contact c : contactList) {
            if (c.name.equalsIgnoreCase(nameToUpdate)) {
                System.out.print("Enter new phone: ");
                c.phone = sc.next();
                System.out.println("Contact updated successfully!👍️\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.👎️\n");
        }
    }
    public static void searchcontact() {
    	System.out.print("Enter the name");
    	String searchname=sc.next();
    	boolean found=false;
    	for (Contact c : contactList){
    		if (c.name.equalsIgnoreCase(searchname)){
    			System.out.println("Contact found!👍️\n"+c);
    			found=true;}}
    	if (!found) {
    		System.out.println("Contact not found.👎️\n");
    		}
    		}
    public static void deletecontact(){
    	System.out.print("Enter the name");
    	String dletecont=sc.next();
    	boolean removed = contactList.removeIf(c -> c.name.equalsIgnoreCase(dletecont));

        if (removed) {
            System.out.println("Contact deleted successfully!\n");
        } else {
            System.out.println("Contact not found.\n");
        }}
    public static void main(String args[]){
    int choice;
    	do {
    	System.out.println("*****CONTACT MANAGEMENT*****");
    	System.out.println("1.Create new contact");
    	System.out.println("2.Update existing contact");
    	System.out.println("3.Delete contact");
    	System.out.println("4.Search contact");
    	System.out.println("5.Exit");
    	System.out.print("Enter your choice :");
    	choice =(sc.nextInt());
    	switch (choice){
    	case 1:addContact();break;
    	case 2:updatecontact();break;
    	case 3:deletecontact();break;
    	case 4:searchcontact();break;
    	case 5:System.out.println("Exiting....");break;
    	default:System.out.println("Enter a valid choice!");}
    	} while (choice != 6);
    	}
    	}
    	
    			
  

 
        
