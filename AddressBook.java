import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Entry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
        System.out.println("Entry added successfully.");
    }

    public void removeEntry(String email) {
        Entry entryToRemove = null;
        for (Entry entry : entries) {
            if (entry.getEmail().equals(email)) {
                entryToRemove = entry;
                break;
            }
        }

        if (entryToRemove != null) {
            entries.remove(entryToRemove);
            System.out.println("Entry removed successfully.");
        } else {
            System.out.println("Entry not found.");
        }
    }

    public void searchEntry(String searchQuery) {
        List<Entry> searchResults = new ArrayList<>();
        for (Entry entry : entries) {
            if (entry.getFirstName().contains(searchQuery) ||
                    entry.getLastName().contains(searchQuery) ||
                    entry.getPhoneNumber().contains(searchQuery) ||
                    entry.getEmail().contains(searchQuery)) {
                searchResults.add(entry);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No matching entries found.");
        } else {
            System.out.println("Search Results:");
            for (Entry entry : searchResults) {
                System.out.println(entry);
            }
        }
    }

    public void printAddressBook() {
        if (entries.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("Address Book:");
            for (Entry entry : entries) {
                System.out.println(entry);
            }
        }
    }

    public void deleteAddressBook() {
        entries.clear();
        System.out.println("Address book deleted successfully.");
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Entry");
            System.out.println("2. Remove Entry");
            System.out.println("3. Search for Entry");
            System.out.println("4. Print the contents of Address Book");
            System.out.println("5. Delete the contents of Address Book");
            System.out.println("6. Quit");
            System.out.print("Enter your choice (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email Address: ");
                    String email = scanner.nextLine();

                    Entry newEntry = new Entry(firstName, lastName, phoneNumber, email);
                    addressBook.addEntry(newEntry);
                    break;
                case 2:
                    System.out.print("Enter Email Address: ");
                    String removeEmail = scanner.nextLine();
                    addressBook.removeEntry(removeEmail);
                    break;
                case 3:
                    System.out.print("Enter Search Query: ");
                    String searchQuery = scanner.nextLine();
                    addressBook.searchEntry(searchQuery);
                    break;
                case 4:
                    addressBook.printAddressBook();
                    break;
                case 5:
                    addressBook.deleteAddressBook();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

class Entry {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Entry(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
