package agenda;

import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.repository.classes.RepositoryActivityMock;
import agenda.repository.interfaces.IRepositoryActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class RepositoryActivityFileTest {
    private IRepositoryActivity repositoryActivity;

    @Before
    public void setUp() {
        repositoryActivity = new RepositoryActivityMock();
    }

    @Test
    public void test_f02_TC1() {
        Activity activity1 = new Activity("n", new Date(Long.parseLong("1363777200000")),
                new Date(Long.parseLong("1363775400000")), new ArrayList<Contact>(), "d");
        boolean result = repositoryActivity.add(activity1);
        assertTrue(result);

    }

    @Test
    public void test_f02_TC2() {
        Activity activity = new Activity("n", new Date(Long.parseLong("1363775400000")),
                new Date(Long.parseLong("1363775400000")), new ArrayList<Contact>(), "d");
        boolean result = repositoryActivity.add(activity);
        assertTrue(result);
        int nBefore = repositoryActivity.getAll().size();

        Activity activity2 = new Activity("n", new Date(Long.parseLong("1363775400000")),
                new Date(Long.parseLong("1363775400000")), new ArrayList<Contact>(), "d");

        result = repositoryActivity.add(activity2);
        int nAfter = repositoryActivity.getAll().size();

        assertTrue(result);
        assert (nBefore == nAfter - 1);

    }

    @Test
    public void test_f02_TC3() {
        Activity activity = new Activity("n", new Date(Long.parseLong("1363773600000")),
                new Date(Long.parseLong("1363877200000")), new ArrayList<Contact>(), "d");
        boolean result = repositoryActivity.add(activity);
        assertTrue(result);

        Activity activity2 = new Activity("n", new Date(Long.parseLong("1539198005784")),
                new Date(Long.parseLong("1573506005784")), new ArrayList<Contact>(), "d");
        result = repositoryActivity.add(activity2);
        assertTrue(result);

        int nBefore = repositoryActivity.getAll().size();

        Activity activity3 = new Activity("n", new Date(Long.parseLong("1363770000000")),
                new Date(Long.parseLong("1363775400000")), new ArrayList<Contact>(), "d");

        result = repositoryActivity.add(activity3);
        int nAfter = repositoryActivity.getAll().size();

        assertFalse(result);
        assert (nBefore == nAfter);

    }

    @Test
    public void test_f02_TC4() {
        Activity activity = new Activity("n", new Date(Long.parseLong("1363777200000")),
                new Date(Long.parseLong("1363775400000")), new ArrayList<Contact>(), "d");
        boolean result = repositoryActivity.add(activity);
        assertTrue(result);
        int nBefore = repositoryActivity.getAll().size();

        Activity activity2 = new Activity("n", new Date(Long.parseLong("1573506005784")),
                new Date(Long.parseLong("1539198005784")), new ArrayList<Contact>(), "d");

        result = repositoryActivity.add(activity2);
        int nAfter = repositoryActivity.getAll().size();

        assertTrue(result);
        assert (nBefore == nAfter - 1);
    }

    @After
    public void tearDown() throws Exception {
    }
}