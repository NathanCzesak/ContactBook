import java.util.*;

public ArrayList<Contact> contacts = new ArrayList<>();
public Scanner scanner = new Scanner(System.in);

public void main(){

    //Print menu of options for 1st time
    menu();

    //Get option input from the user

    int userChoice = readChoice(scanner, "Enter Choice: ");

    //Keep asking user for choice from menu
    //until they select 'Quit'
    while(userChoice != 5){

        switch(userChoice){
            case 1: addContact(); break;
            case 2: searchContact(); break;
            case 3: deleteContact(); break;
            case 4: listAllContacts(); break;
            default:
                System.out.println("Invalid choice");
                System.out.println();
                break;
        }
        //Re print menu
        menu();
        userChoice = readChoice(scanner, "Enter Choice: ");
        System.out.println();

    }

    System.out.println("Exiting...");

}

//Menu of user options to pick from
public void menu(){
    System.out.println(
            "1. Add Contact\n" +
            "2. Search Contact\n" +
            "3. Delete Contact\n" +
            "4. List All Contacts\n" +
            "5. Quit"
    );
}

public void addContact(){
    //Have the user fill in all contact information
    System.out.print("Enter Contact First Name: ");
    String firstName =  scanner.nextLine().trim();
    System.out.print("Enter Contact Last Name: ");
    String lastName =  scanner.nextLine().trim();
    System.out.print("Enter Contact Phone Number: ");
    String phoneNumber = scanner.nextLine().trim();
    System.out.println();

    //Create a contact object with entered info
    Contact contact = new Contact(firstName, lastName, phoneNumber);
    //Add new contact object to the public ArrayList of contacts
    contacts.add(contact);

}

public void searchContact(){
    //Give the user a way to search a contact
    System.out.print("Search Contact by: \n" +
                        "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Phone Number\n");

    int searchChoice = readChoice(scanner, "Select Option: ");
    System.out.println();

    boolean found;
    if (searchChoice == 1) {
        System.out.print("Enter Contact's First Name: ");
        String searchFirstName = scanner.nextLine().trim();
        System.out.println();

        //check if the contact exists, if it does then print the info, else say does not exist
        found = false;
        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(searchFirstName)) {
                printContactInfo(contact);
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found");
            System.out.println();
        }
    } else if (searchChoice == 2) {
        System.out.print("Enter Contact's Last Name: ");
        String searchLastName = scanner.nextLine().trim();
        System.out.println();

        found = false;
        for (Contact contact : contacts) {
            if (contact.getLastName().equalsIgnoreCase(searchLastName)) {
                printContactInfo(contact);
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found");
            System.out.println();
        }
    } else if (searchChoice == 3) {
        System.out.print("Enter Contact's Phone Number: ");
        String searchPhoneNumber = scanner.nextLine().trim();
        System.out.println();

        found = false;
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(searchPhoneNumber)) {
                printContactInfo(contact);
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found");
            System.out.println();
        }
    } else {
        System.out.println("Invalid choice");
        System.out.println();
    }


}

public void deleteContact(){
    System.out.print("Enter Contact's First Name: ");
    String deleteFirstName = scanner.nextLine().trim();

    boolean found = false;
    boolean deleted = false;
    for(int i = 0; i < contacts.size(); i++){
        if(contacts.get(i).getFirstName().equalsIgnoreCase(deleteFirstName)){
            found = true;
            printContactInfo(contacts.get(i));
            System.out.print("Delete This Contact? (yes/no): ");
            System.out.println();
            String yesOrNo = scanner.nextLine().trim();
            if(yesOrNo.equalsIgnoreCase("yes")){
                deleted = true;
                contacts.remove(i);
                System.out.println("Removal Successful");
                System.out.println();
                break;
            }
        }
    }
    if (!found) {
        System.out.println("Contact not found");
        System.out.println();
    } else if (!deleted) {
        System.out.println("Contact not deleted");
        System.out.println();
    }

}

public void listAllContacts(){
    for(Contact contact : contacts){
        printContactInfo(contact);
        System.out.println();
    }
}

public void printContactInfo(Contact contact){
    System.out.println("First Name: " + contact.getFirstName());
    System.out.println("Last Name: " + contact.getLastName());
    System.out.println("Phone Number: " + contact.getPhoneNumber());
}

public int readChoice(Scanner scanner, String prompt){
    System.out.print(prompt);
    if(!scanner.hasNextLine()){return 5;}
    String line = scanner.nextLine();
    try{
        return Integer.parseInt(line.trim());
    } catch(NumberFormatException e){
        return -1;
    }
}

public void readEmptyCon

