package agenda.controller;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.repository.interfaces.IRepositoryContact;

import java.util.List;

public class ControllerContact implements IControllerContact {
    private IRepositoryContact repositoryContact;

    public ControllerContact(IRepositoryContact repository) {
        this.repositoryContact = repository;
    }

    public Contact getByName(String string) {
        for (Contact c : repositoryContact.getAll())
            if (c.getName().equals(string))
                return c;
        return null;
    }

    public void save(String name, String address, String telefon) throws InvalidFormatException {
        Contact contact = new Contact(name, address, telefon);
        if (!validTelefon(contact.getTelefon()))
            throw new InvalidFormatException("Cannot convert", "Invalid phone number");
        if (!validName(contact.getName())) throw new InvalidFormatException("Cannot convert", "Invalid name");
        if (!validAddress(contact.getAddress()))
            throw new InvalidFormatException("Cannot convert", "Invalid address");
        repositoryContact.add(contact);
    }

    public List<Contact> getAll() {
        return repositoryContact.getAll();
    }

    /**
     * @param str - name that needs to be verify if it is correct
     * @return true if str is String and length(str)>2, false otherwise
     */
    private boolean validName(String str) {
        if (str.length() <= 2) return false;
        return true;
    }

    private boolean validAddress(String str) {
        return true;
    }

    /**
     * @param tel - phone number that needs to be verify if it is correct
     * @return true if tel is String and starts with 0, false otherwise
     */
    private boolean validTelefon(String tel) {
        if (tel.length() == 0) return false;
        if (tel.charAt(0) != '0') return false;
        return true;
    }


}
