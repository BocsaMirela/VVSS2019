package agenda.controller;

import agenda.model.base.Activity;
import agenda.model.base.Contact;

import java.util.Date;
import java.util.List;

public interface IControllerContact {

    public Contact getByName(String string) ;
    public void save(Contact contact);
    public List<Contact> getAll();
}
