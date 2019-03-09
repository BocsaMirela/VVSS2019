package agenda.controller;

import agenda.model.base.Contact;
import agenda.model.repository.interfaces.IRepositoryContact;

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

    public void save(Contact contact){
        repositoryContact.add(contact);
    }

    public List<Contact> getAll(){
        return repositoryContact.getAll();
    }


}
