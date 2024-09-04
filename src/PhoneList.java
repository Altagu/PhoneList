import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class PhoneList {
    private HashMap<String, String> contacts;  // Make it non-static

    public PhoneList() {
        this.contacts = new HashMap<>();  // Initialize in the constructor
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println("Contact added! \nName: " + name + "\nNumber: " + phoneNumber+"\n");
    }

    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted: " + name);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    public void searchContact() {
        Scanner sc = new Scanner(System.in);
        String name;

        while (true) {
            System.out.print("Enter contact name to search:\n");
            name = sc.nextLine();
            if (contacts.containsKey(name)) {
                System.out.println("Contact found: \nName: " + name + "\nNumber: " + contacts.get(name) + "\n");
                break;
            } else {
                System.out.println("Contact not found: " + name);
                System.out.println("Please try again.\n");
            }
        }
    }

    public void printAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("All Contacts:");
            for (String name : contacts.keySet()) {
                System.out.println("Name: "+ name + "\nNumber: " + contacts.get(name)+"\n");
            }
        }
    }

    // Method to save contacts to a file
    public void saveToFile() {  // Make this method non-static
        try (FileWriter writer = new FileWriter("PHONE_CONTACTS.txt")) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            System.out.println("Contacts have been saved to file");
        } catch (IOException e) {
            System.out.println("An error occurred while saving contacts to the file.");
            e.printStackTrace();
        }
    }

    // Method to load contacts from a file
    public void loadFromFile() {  // Make this method non-static
        try (BufferedReader reader = new BufferedReader(new FileReader("PHONE_CONTACTS.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    String telefon = parts[1];
                    contacts.put(name, telefon);
                }
            }
            System.out.println("Contacts have been loaded from file");
        } catch (FileNotFoundException e) {
            System.out.println("No existing contacts file found. Starting with an empty contact list.");
        } catch (IOException e) {
            System.out.println("An error occurred while loading contacts from the file.");
            e.printStackTrace();
        }
    }
}