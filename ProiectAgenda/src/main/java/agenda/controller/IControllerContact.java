package agenda.controller;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Activity;
import agenda.model.base.Contact;

import java.util.Date;
import java.util.List;

public interface IControllerContact {

    public Contact getByName(String string) ;
    public void save(String name, String address, String telefon) throws InvalidFormatException;
    public List<Contact> getAll();
}
