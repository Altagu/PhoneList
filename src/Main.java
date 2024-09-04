import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneList phoneList = new PhoneList(); // Create an instance of PhoneList
        int choice = 1;

        while (choice != 0) {
            System.out.println("1. Add contact\n2. Remove contact\n3. Search contact\n4. Print all\n0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneList.addContact(name, phoneNumber);  // Call the method with parameters
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    phoneList.deleteContact(removeName);  // Call the method with the name parameter
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    phoneList.searchContact(searchName);  // Call the method with the name parameter
                    break;

                case 4:
                    phoneList.printAllContacts();  // Call the method to print all contacts
                    break;

                default:
                    choice = 0;  // Exit the loop
                    break;
            }
        }
    }
}