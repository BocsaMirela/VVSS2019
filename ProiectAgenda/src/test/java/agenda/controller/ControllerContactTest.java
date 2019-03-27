package agenda.controller;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactFile;
import agenda.model.repository.interfaces.IRepositoryContact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ControllerContactTest {
    private IControllerContact controllerContact;

    @Before
    public void setUp() throws Exception {
        final String filenameContact = "D:\\VVSS2019\\ProiectAgenda\\filesTest\\contactsTest.txt";
        IRepositoryContact contactRep = new RepositoryContactFile(filenameContact);
        controllerContact = new ControllerContact(contactRep);
    }

    @Test
    public void test1ECP() {
        try {
            controllerContact.save("Jhon", "address", "07");
            assertTrue(true);
        } catch (InvalidFormatException e) {
            fail();
        }
        for (Contact c : controllerContact.getAll())
            if (c.getName().equals("Jhon") && c.getAddress().equals("address") && c.getTelefon().equals("07")) {
                assertTrue(true);
                return;
            }
        fail();
    }

    @Test
    public void test3ECP() {
        int n = controllerContact.getAll().size();
        try {
            controllerContact.save("nn", "address", "099");
            fail();
        } catch (InvalidFormatException ex) {
            assertTrue(true);
        }
        int nAfter = controllerContact.getAll().size();
        assert (n == nAfter);
    }

    @Test
    public void test5ECP() {
        int n = controllerContact.getAll().size();
        try {
            controllerContact.save("nn", "address", "9999");
            fail();
        } catch (InvalidFormatException ex) {
            assertTrue(true);
        }
        int nAfter = controllerContact.getAll().size();
        assert (n == nAfter);
    }

    @Test
    public void test1BVA() {
        int n = controllerContact.getAll().size();
        try {
            controllerContact.save("", "address", "09");
            fail();
        } catch (InvalidFormatException ex) {
            assertTrue(true);
        }
        int nAfter = controllerContact.getAll().size();
        assert (n == nAfter);
    }

    @Test
    public void test5BVA() {
        int n = controllerContact.getAll().size();
        try {
            controllerContact.save("abc", "address", "09");
            assertTrue(true);
        } catch (InvalidFormatException ex) {
            fail();
        }
        int nAfter = controllerContact.getAll().size();
        assert (n == nAfter - 1);
        for (Contact c : controllerContact.getAll())
            if (c.getName().equals("abc") && c.getAddress().equals("address") && c.getTelefon().equals("09")) {
                assertTrue(true);
                return;
            }
        fail();
    }

    @Test
    public void test7BVA() {
        int n = controllerContact.getAll().size();
        try {
            controllerContact.save("abc", "address", "");
            fail();
        } catch (InvalidFormatException ex) {
            assertTrue(true);
        }
        int nAfter = controllerContact.getAll().size();
        assert (n == nAfter);
    }

    @Test
    public void test8BVA() {
        int n = controllerContact.getAll().size();
        try {
            controllerContact.save("name", "address", "0");
            assertTrue(true);
        } catch (InvalidFormatException ex) {
            fail();
        }
        int nAfter = controllerContact.getAll().size();
        assert (n == nAfter - 1);

        for (Contact c : controllerContact.getAll())
            if (c.getName().equals("name") && c.getAddress().equals("address") && c.getTelefon().equals("0")) {
                assertTrue(true);
                return;
            }
        fail();
    }

    @Test
    public void test11BVA() {
        int n = controllerContact.getAll().size();
        try {
            controllerContact.save("name", "address", "023");
            assertTrue(true);
        } catch (InvalidFormatException ex) {
            fail();
        }
        int nAfter = controllerContact.getAll().size();
        assert (n == nAfter - 1);

        for (Contact c : controllerContact.getAll())
            if (c.getName().equals("name") && c.getAddress().equals("address") && c.getTelefon().equals("023")) {
                assertTrue(true);
                return;
            }
        fail();
    }

    @After
    public void tearDown() throws Exception {
    }
}