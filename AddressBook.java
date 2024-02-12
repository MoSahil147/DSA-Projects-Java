import java.util.*;

class contact {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public contact(String name, String address, String phoneNumber,  String email){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}
public String getPhoneNumber() {
    return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}
public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

@Override
public String toString(){
    return "Name: " + name + "\n Address: " + address + "\n Phone number: " + phoneNumber + "\n Email: " + email;
}
}

public class AddressBook{
    private List<contact> contacts;
    private Scanner sc;

    public AddressBook(){
        contacts = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void addContact(){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email: ");
        String email;
        do{
            email  = sc.nextLine().toLowerCase();
            if(!email.contains("@")){
                System.out.println("Invalid mail, must contain '@' in mail");
            }
        } while(!email.contains("@")); //will stuck in loop untill, right email is entered

        contact Contact = new contact(name, address, phoneNumber, email);
        contacts.add(Contact);
        System.out.println("Contact added successfully!\n");
    }

    public void searchContact() {
        System.out.print("Enter the name of the contact to search: ");
        String name = sc.nextLine();

        boolean found = false;
        for(contact Contact : contacts){
            if(Contact.getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println("\nFound contact:\n" + Contact);
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("No contact found with that name.\n");
        }
    }
public void modifyContact() {
    System.out.println("Modifying an existing contact");
    System.out.println("Enter name of contact to modify: ");
    String name = sc.nextLine();

    boolean found = false;
    for(int i = 0; i < contacts.size(); i++){
        contact Contact = contacts.get(i);
        if (Contact.getName().toLowerCase().equals(name.toLowerCase())){
            //contact found, allow modification

            System.out.println("\n Current Details: \n" + Contact);
            System.out.println("\nWhat do you want to modify?");
                System.out.println("1. Name");
                System.out.println("2. Address");
                System.out.println("3. Phone number");
                System.out.println("4. Email");
                System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                        System.out.println("Enter new name: ");
                        String newName = sc.nextLine();
                        Contact.setName(newName);
                        break;

                case 2:
                        System.out.print("Enter new address: ");
                        String newAddress = sc.nextLine();
                        Contact.setAddress(newAddress);
                        break;

                case 3:
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = sc.nextLine();
                        Contact.setPhoneNumber(newPhoneNumber);
                        System.out.println("Phone number updated successfully.\n");
                        break;

                case 4:
                        System.out.print("Enter new email: ");
                        String newEmail = sc.nextLine();
                        Contact.setEmail(newEmail);
                        System.out.println("Email updated successfully.\n");
                        break;

                default:
                        System.out.println("Invalid choice. Please choose a valid option.\n");
            }

            found = true; //set contact to true once the contact is modiefied
            break;
        }
        if(!found){
            System.out.println("Contact not found.\n");
        }
    }
}
    public static void main(String[] args){
        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("Address Book menu");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Modify Contact");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                addressBook.addContact();
                break;

                case 2:
                addressBook.searchContact();
                break;

                case 3:
                addressBook.modifyContact();
                break;

                case 4:
                System.out.println("Exiting Address Book");
                break;

                default:
                System.out.println("Inavlid choice. Please Try again.");
            }
        }
        while(choice != 4); //if the consumer didnt enter 4, consumer has not choosen to exit
    }
} 




