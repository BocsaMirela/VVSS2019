package agenda.controller;

import agenda.exceptions.InvalidFormatException;
import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.repository.classes.RepositoryActivityFile;
import agenda.repository.classes.RepositoryActivityMock;
import agenda.repository.classes.RepositoryContactFile;
import agenda.repository.interfaces.IRepositoryActivity;
import agenda.repository.interfaces.IRepositoryContact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ControllerActivityTest {
    private IControllerActivity controllerActivity;
    private IRepositoryActivity repositoryActivity;


    @Before
    public void setUp() throws Exception {
        repositoryActivity = new RepositoryActivityMock();
        controllerActivity = new ControllerActivity(repositoryActivity);
        long dateLongTestS = Long.parseLong("1363775400000");
        long dateLongTestD = Long.parseLong("1363875400000");
        repositoryActivity.add(new Activity("name1",new Date(dateLongTestS),new Date(dateLongTestD),new ArrayList<Contact>(),"Activity"));
    }

    @Test
    public void testValid() {
        long dateLong = Long.parseLong("1363777200000");
        List<Activity> list=controllerActivity.activitiesOnDate("name1", new Date(dateLong));
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("name1",list.get(0).getName());
    }

    @Test
    public void testInvalid() {
        long dateLong = Long.parseLong("1363777200000");
        List<Activity> list=controllerActivity.activitiesOnDate("", new Date(dateLong));
        assertTrue(list.isEmpty());
    }

    @After
    public void tearDown() throws Exception {
    }
}