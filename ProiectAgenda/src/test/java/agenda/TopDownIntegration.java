package agenda;

import agenda.controller.ControllerActivity;
import agenda.controller.ControllerContact;
import agenda.controller.IControllerActivity;
import agenda.controller.IControllerContact;
import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.repository.classes.RepositoryActivityFile;
import agenda.repository.classes.RepositoryActivityMock;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.classes.RepositoryContactMock;
import agenda.repository.interfaces.IRepositoryActivity;
import agenda.repository.interfaces.IRepositoryContact;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TopDownIntegration {
    private IControllerContact controllerContact;
    private IRepositoryActivity repositoryActivity;
    private IRepositoryContact repositoryContact;
    private IControllerActivity controllerActivity;

    @Before
    public void setUp() throws Exception {
        IRepositoryContact contactRep = new RepositoryContactFile("");
        controllerContact = new ControllerContact(contactRep);
        repositoryActivity = new RepositoryActivityFile("", new ArrayList<Contact>());
        controllerActivity = new ControllerActivity(repositoryActivity);
    }

    //test module A - F01 - unit testing
    @Test
    public void testUnitA() throws Exception {
        repositoryContact = new RepositoryContactFile("");
        controllerContact = new ControllerContact(repositoryContact);

        try {
            controllerContact.save("Jhon", "address", "07");
            Assert.assertTrue(true);
        } catch (InvalidFormatException e) {
            fail();
        }
        for (Contact c : controllerContact.getAll())
            if (c.getName().equals("Jhon") && c.getAddress().equals("address") && c.getTelefon().equals("07")) {
                Assert.assertTrue(true);
                return;
            }
        fail();
    }

    //integration P->A(valid)
    @Test
    public void testIntegrationPA() throws Exception {
        controllerContact=new ControllerContact(new RepositoryContactFile(""));
        repositoryActivity=new RepositoryActivityMock();//use B as mock
        controllerActivity=new ControllerActivity(repositoryActivity);

        Contact contact = new Contact("Jhon", "address", "07");
        controllerContact.save("Jhon", "address", "07");

        List<Contact> list1 = new ArrayList<Contact>();
        list1.add(contact);
        Activity activity = new Activity("name1", new Date(Long.parseLong("1363775400000")),
                new Date(Long.parseLong("1363775400000")), list1, "description");
        repositoryActivity.add(activity);

        List<Activity> list = controllerActivity.activitiesOnDate("name1", new Date(Long.parseLong("1363775400000")));

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("name1", list.get(0).getName());
        assertEquals(new Date(Long.parseLong("1363775400000")), list.get(0).getDuration());
    }

    //test module B -F02 -unit testing
    @Test
    public void testUnitB() throws Exception {
        repositoryActivity = new RepositoryActivityFile("", new ArrayList<Contact>());

        Activity activity = new Activity("n", new Date(Long.parseLong("1363775400000")),
                new Date(Long.parseLong("1363775400000")), new ArrayList<Contact>(), "d");
        boolean result = repositoryActivity.add(activity);
        Assert.assertTrue(result);
        int nBefore = repositoryActivity.getAll().size();

        Activity activity2 = new Activity("n", new Date(Long.parseLong("1363775400000")),
                new Date(Long.parseLong("1363775400000")), new ArrayList<Contact>(), "d");

        result = repositoryActivity.add(activity2);
        int nAfter = repositoryActivity.getAll().size();

        Assert.assertTrue(result);
        assert (nBefore == nAfter - 1);

    }

    //integration P->A(valid)->B(valid)
    @Test
    public void testIntegrationPAB() throws Exception {
        controllerContact=new ControllerContact(new RepositoryContactFile(""));
        repositoryActivity=new RepositoryActivityFile("",new ArrayList<Contact>());
        controllerActivity=new ControllerActivity(repositoryActivity);

        Contact contact = new Contact("Jhon", "address", "07");
        controllerContact.save("Jhon", "address", "07");

        List<Contact> list1 = new ArrayList<Contact>();
        list1.add(contact);
        Activity activity = new Activity("name1", new Date(Long.parseLong("1363775400000")),
                new Date(Long.parseLong("1363775400000")), list1, "description");
        repositoryActivity.add(activity);

        List<Activity> list = controllerActivity.activitiesOnDate("name1", new Date(Long.parseLong("1363775400000")));

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("name1", list.get(0).getName());
        assertEquals(new Date(Long.parseLong("1363775400000")), list.get(0).getDuration());
    }



    //test module C -F03 -unit testing
    @Test
    public void testUnitC() throws Exception {
        repositoryActivity=new RepositoryActivityMock();
        controllerActivity=new ControllerActivity(repositoryActivity);

        long dateLongTestS = Long.parseLong("1363775400000");
        long dateLongTestD = Long.parseLong("1363875400000");
        repositoryActivity.add(new Activity("name1", new Date(dateLongTestS), new Date(dateLongTestD), new ArrayList<Contact>(), "Activity"));

        long dateLong = Long.parseLong("1363777200000");
        List<Activity> list = controllerActivity.activitiesOnDate("name1", new Date(dateLong));
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("name1", list.get(0).getName());
    }
    
    //integration P->A(valid)->B(valid)->C(valid)
    @Test
    public void testIntegrationPABC() throws Exception {

        Contact contact = new Contact("Jhon", "address", "07");
        controllerContact.save("Jhon", "address", "07");

        List<Contact> list1 = new ArrayList<Contact>();
        list1.add(contact);
        Activity activity = new Activity("name1", new Date(Long.parseLong("1363775400000")),
                new Date(Long.parseLong("1363775400000")), list1, "description");
        repositoryActivity.add(activity);

        List<Activity> list = controllerActivity.activitiesOnDate("name1", new Date(Long.parseLong("1363775400000")));

        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("name1", list.get(0).getName());
        assertEquals(new Date(Long.parseLong("1363775400000")), list.get(0).getDuration());

    }

    @After
    public void tearDown() {
    }
}
