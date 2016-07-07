/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address.controller;

import com.thesoftwareguild.interfaces.dao.AddressBookDaoInterface;
import com.thesoftwareguild.interfaces.dto.Address;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Brennan
 */
public class AddressController {

    Scanner read = new Scanner(System.in);
    ConsoleIO ci = new ConsoleIO();
//    AddressDaoLamdaImpl ldao = new AddressDaoLamdaImpl();
    
    AddressBookDaoInterface ldao;
    
    public AddressController(AddressBookDaoInterface ldao)  {
        this.ldao = ldao;
    }

    public void run() {

        boolean runAgain = true;
        while (runAgain) {

            ci.displayString("Please choose an option below: ");
            ci.displayString("1. Add Address");
            ci.displayString("2. Remove Address");
            ci.displayString("3. Display # of addresses in book");
            ci.displayString("4. List all addresses");
            ci.displayString("5. Find by last name");
            ci.displayString("6. Edit an address");
            ci.displayString("7. Exit");
            ci.displayString("8. Test state");
            int selection = read.nextInt();

            switch (selection) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    showBookSize();
                    break;
                case 4:
                    listAllAddresses();
                    break;
                case 5:
                    findByLastName();
                    break;
                case 6:
                    editAddress();
                    break;
                case 7:
                    runAgain = false;
                default:
                    ci.displayString("Invalid choice");
                    break;
            }

        }
    }

    public void addAddress() {

        String fname = ci.getWord("Enter first name: ");
        String lname = ci.getWord("Enter last name: ");
        String snum = ci.getWord("Enter street number: ");
        String sname = ci.getWord("Enter street name: ");
        String state = ci.getWord("Enter state: ");
        String city = ci.getWord("Enter city: ");
        String zipcode = ci.getWord("Enter Zipcode: ");

        Address myAddress = new Address();
        myAddress.setFirstName(fname);
        myAddress.setLastName(lname);
        myAddress.setStreetNumber(snum);
        myAddress.setStreetName(sname);
        myAddress.setState(state);
        myAddress.setCity(city);
        myAddress.setZip(zipcode);

        ldao.create(myAddress);

    }

    public void removeAddress() {

        int id = ci.enterInt("Please enter address ID to delete: ");

        Address myAddress = new Address();
        myAddress.setId(id);

        ldao.delete(id);

    }

    public void showBookSize() {

        List<Address> addresses = ldao.list();
        int booksize = addresses.size();
        ci.displayString("There are " + booksize + " addresses in the book.");

    }

    public void listAllAddresses() {

        List<Address> addresses = ldao.list();

        for (Address myAddress : addresses) {
            ci.displayString("|Id:" + myAddress.getId() + "|FirstName:" + myAddress.getFirstName() + "|LastName:"
                    + myAddress.getLastName() + "|HouseAddress:" + myAddress.getStreetNumber()
                    + "|StreetName:" + myAddress.getStreetName()+ "|State:" + myAddress.getState() + "|City:" + myAddress.getCity() + "|Zipcode:" + myAddress.getZip() + "|");
        }

    }

    public void findByLastName() {

        List<Address> addresses = ldao.list();

        ci.displayString("List of last names in address book: ");
        for (Address myAddress : addresses) {
            ci.displayString(myAddress.getLastName());
        }

        String search = ci.getWord("Enter the last name that you want the address info for?");

        for (Address myAddress : addresses) {
            ci.displayString("|Id:" + myAddress.getId() + "|FirstName:" + myAddress.getFirstName() + "|LastName:"
                    + myAddress.getLastName() + "|HouseAddress:" + myAddress.getStreetNumber()
                    + "|StreetName:" + myAddress.getStreetName()+ "|State:" + myAddress.getState() + "|City:" + myAddress.getCity() + "|Zipcode:" + myAddress.getZip() + "|");
        
        }

    }

    public void editAddress() {

        List<Address> addresses = ldao.list();

       for (Address myAddress : addresses) {
            ci.displayString("|Id:" + myAddress.getId() + "|FirstName:" + myAddress.getFirstName() + "|LastName:"
                    + myAddress.getLastName() + "|HouseAddress:" + myAddress.getStreetNumber()
                    + "|StreetName:" + myAddress.getStreetName()+ "|State:" + myAddress.getState() + "|City:" + myAddress.getCity() + "|Zipcode:" + myAddress.getZip() + "|");
        }

        int search = ci.enterInt("Enter the ID of the address that you would want to edit");
//        String edit = ci.getWord("Enter the field that you want to edit: ");

        Address myAddress = ldao.get(search);
        String fname = ci.getWord("Enter first name: ");
        String lname = ci.getWord("Enter last name: ");
        String type = ci.getWord("Enter type: ");
        String snum = ci.getWord("Enter street number: ");
        String sname = ci.getWord("Enter street name: ");
        String state = ci.getWord("Enter state: ");
        String city = ci.getWord("Enter city: ");
        String zipcode = ci.getWord("Enter Zipcode: ");

        myAddress.setFirstName(fname);
        myAddress.setLastName(lname);
        myAddress.setStreetNumber(snum);
        myAddress.setStreetName(sname);
        myAddress.setState(state);
        myAddress.setCity(city);
        myAddress.setZip(zipcode);

        ldao.update(myAddress);
    }

}
