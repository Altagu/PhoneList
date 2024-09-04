import java.util.HashMap;

class PhoneList {
    private HashMap<String, String> contacts;

    public PhoneList() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        System.out.println("Contact added: " + name + " -> " + phoneNumber);
    }

    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            contacts.remove(name);
            System.out.println("Contact deleted: " + name);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    public void searchContact(String name) {
        if (contacts.containsKey(name)) {
            System.out.println("Contact found: " + name + " -> " + contacts.get(name));
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    public void printAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("All Contacts:");
            for (String name : contacts.keySet()) {
                System.out.println(name + " -> " + contacts.get(name));
            }
        }
    }
}