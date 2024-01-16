//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    String email;

    Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

public class contactmanage {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View contacts");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Contact Manager. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter the contact's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the contact's phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter the contact's email address: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);

        System.out.println(name + " has been added to your contacts.");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Your contacts list is empty.");
        } else {
            System.out.println("Your Contacts:");
            for (int i = 0; i < contacts.size(); i++) {
                Contact contact = contacts.get(i);
                System.out.println((i + 1) + ". " + contact.name + " - " + contact.phoneNumber + " - " + contact.email);
            }
        }
    }

    private static void editContact() {
        viewContacts();
        if (contacts.isEmpty()) {
            return;
        }

        try {
            System.out.print("Enter the number of the contact you want to edit: ");
            int index = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            Contact selectedContact = contacts.get(index - 1);

            System.out.println("Editing " + selectedContact.name + ":");
            System.out.print("Enter the new name (leave blank to keep current): ");
            selectedContact.name = scanner.nextLine();
            System.out.print("Enter the new phone number (leave blank to keep current): ");
            selectedContact.phoneNumber = scanner.nextLine();
            System.out.print("Enter the new email address (leave blank to keep current): ");
            selectedContact.email = scanner.nextLine();

            System.out.println(selectedContact.name + " has been updated.");
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid contact number.");
            scanner.nextLine();  // Consume the invalid input
        }
    }

    private static void deleteContact() {
        viewContacts();
        if (contacts.isEmpty()) {
            return;
        }

        try {
            System.out.print("Enter the number of the contact you want to delete: ");
            int index = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            Contact deletedContact = contacts.remove(index - 1);

            System.out.println(deletedContact.name + " has been deleted from your contacts.");
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid contact number.");
            scanner.nextLine();  // Consume the invalid input
        }
    }
}