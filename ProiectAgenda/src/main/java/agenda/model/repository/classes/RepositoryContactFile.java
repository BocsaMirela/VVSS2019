package agenda.model.repository.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.model.repository.interfaces.IRepositoryContact;

public class RepositoryContactFile implements IRepositoryContact {

    private String filename;
    private List<Contact> contacts;

    public RepositoryContactFile(String filename) throws Exception {
        this.filename = filename;
        contacts = new LinkedList<Contact>();
        BufferedReader br = null;
//		String currentDir = new File(".").getAbsolutePath();
//		System.out.println(currentDir);
        try {
            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(filename)));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                Contact c = null;
                try {
                    String[] s = line.split("#");
                    if (s.length != 3) throw new InvalidFormatException("Cannot convert", "Invalid data");
                    if (!validTelefon(s[2])) throw new InvalidFormatException("Cannot convert", "Invalid phone number");
                    if (!validName(s[0])) throw new InvalidFormatException("Cannot convert", "Invalid name");
                    if (!validAddress(s[1])) throw new InvalidFormatException("Cannot convert", "Invalid address");

                    c = new Contact(s[0], s[1], s[2]);
                    contacts.add(c);
                    i++;
                } catch (InvalidFormatException e) {
                    throw new Exception("Error in file at line " + i,
                            new Throwable(e.getCause().getMessage()));
                }

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (br != null) br.close();
        }
    }

    @Override
    public List<Contact> getAll() {
        return new LinkedList<Contact>(contacts);
    }

    @Override
    public boolean add(Contact contact) {
        try {
            if (!validTelefon(contact.getTelefon()))
                throw new InvalidFormatException("Cannot convert", "Invalid phone number");
            if (!validName(contact.getName())) throw new InvalidFormatException("Cannot convert", "Invalid name");
            if (!validAddress(contact.getAddress()))
                throw new InvalidFormatException("Cannot convert", "Invalid address");
            contacts.add(contact);
            saveContracts();
            return true;
        }catch (InvalidFormatException ex) {
            return false;
        }

    }

    @Override
    public boolean remove(Contact contact) {
        int index = contacts.indexOf(contact);
        if (index < 0)
            return false;
        else
            contacts.remove(index);
        return true;
    }

    @Override
    public boolean update(Contact item) {
        return false;
    }

    private boolean saveContracts() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(filename));
            for (Contact c : contacts)
                pw.println(c.toString());
        } catch (Exception e) {
            return false;
        } finally {
            if (pw != null) pw.close();
        }
        return true;
    }

    private static boolean validName(String str) {

        String[] s = str.split("[\\p{Punct}\\s]+");
        if (s.length > 2) return false;
        return true;
    }

    private static boolean validAddress(String str) {
        return true;
    }

    private static boolean validTelefon(String tel) {
        String[] s = tel.split("[\\p{Punct}\\s]+");
        if (tel.charAt(0) == '+' && s.length == 2) return true;
        if (tel.charAt(0) != '0') return false;
        if (s.length != 1) return false;
        return true;
    }

}
