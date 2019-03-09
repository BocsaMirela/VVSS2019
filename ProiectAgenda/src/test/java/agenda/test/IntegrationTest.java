package agenda.test;

import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryActivityFile;
import agenda.model.repository.classes.RepositoryContactFile;
import agenda.model.repository.interfaces.IRepositoryActivity;
import agenda.model.repository.interfaces.IRepositoryContact;

import org.junit.Before;
import org.junit.Test;


public class IntegrationTest {

	private IRepositoryActivity repAct;
	private IRepositoryContact repCon;

	@Before
	public void setup() throws Exception {
		repCon = new RepositoryContactFile("contactText.txt");
		repAct = new RepositoryActivityFile("activities.txt",repCon.getAll());

		for (Activity a : repAct.getAll())
			repAct.remove(a);
	}

	@Test
	public void test1() {
		int n = repCon.getAll().size();

		try {
			Contact c = new Contact("name", "address1", "+071122334455");
			repCon.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertTrue(n + 1 == repCon.getAll().size());
	}

	@Test
	public void test2() {
		Activity act = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", df.parse("03/20/2013 12:00"),
					df.parse("03/20/2013 13:00"), null, "Lunch break");
			repAct.add(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertTrue(repAct.getAll().get(0).equals(act)
				&& repAct.getAll().size() == 1);
	}

	@Test
	public void test3() {
		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20, 12, 00);
		Date start = c.getTime();

		c.set(2013, 3 - 1, 20, 12, 30);
		Date end = c.getTime();

		Activity act = new Activity("name1", start, end,
				new LinkedList<Contact>(), "description2");

		repAct.add(act);

		c.set(2013, 3 - 1, 20);


	}

	@Test
	public void test4() {
		Activity act = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", df.parse("03/20/2013 12:00"),
					df.parse("03/20/2013 13:00"), null, "Lunch break");
			repAct.add(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertTrue(repAct.getAll().get(0).equals(act)
				&& repAct.getAll().size() == 1);

		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20);


	}

	@Test
	public void test5() {
		boolean part1 = false;
		Activity act = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", df.parse("03/20/2013 12:00"),
					df.parse("03/20/2013 13:00"), null, "Lunch break");
			repAct.add(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			repAct.add((Activity) (Object) 5);
		} catch (Exception e) {
			part1 = true;
		}
		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20);


	}

	@Test
	public void test6() {
		boolean part1 = false;
		Activity act = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", df.parse("03/20/2013 12:00"),
					df.parse("03/20/2013 13:00"), null, "Lunch break");
			repAct.add(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (repAct.getAll().get(0).equals(act) && repAct.getAll().size() == 1)
			part1 = true;


	}

	@Test
	public void test7() {
		boolean part1 = false, part2 = false;
		int n = repCon.getAll().size();

		try {
			Contact c = new Contact("name", "address1", "+071122334455");
			repCon.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (n + 1 == repCon.getAll().size())
			part1 = true;
		Activity act = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", df.parse("03/20/2013 12:00"),
					df.parse("03/20/2013 13:00"), null, "Lunch break");
			repAct.add(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (repAct.getAll().get(0).equals(act) && repAct.getAll().size() == 1)
			part2 = true;

		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20);


	}

	@Test
	public void test8() {
		boolean part1 = false, part2 = false;

		try {
			repCon.add((Contact) new Object());
		} catch (Exception e) {
			part1 = true;
		}

		Activity act = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", df.parse("03/20/2013 12:00"),
					df.parse("03/20/2013 13:00"), null, "Lunch break");
			repAct.add(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (repAct.getAll().get(0).equals(act) && repAct.getAll().size() == 1)
			part2 = true;

		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20);


	}

	@Test
	public void test9() {
		boolean part1 = false, part2 = false;
		int n = repCon.getAll().size();

		try {
			Contact c = new Contact("name", "address1", "+071122334455");
			repCon.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (n + 1 == repCon.getAll().size())
			part1 = true;
		Activity act = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", df.parse("03/20/2013 12:00"),
					df.parse("03/20/2013 13:00"), null, "Lunch break");
			repAct.add(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			repAct.add((Activity) (Object) 5);
		} catch (Exception e) {
			part2 = true;
		}

		Calendar c = Calendar.getInstance();
		c.set(2013, 3 - 1, 20);


	}

	@Test
	public void test10() {
		boolean part1 = false, part2 = false, part3 = false;
		int n = repCon.getAll().size();

		try {
			Contact c = new Contact("name", "address1", "+071122334455");
			repCon.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (n + 1 == repCon.getAll().size())
			part1 = true;
		Activity act = null;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		try {
			act = new Activity("name1", df.parse("03/20/2013 12:00"),
					df.parse("03/20/2013 13:00"), null, "Lunch break");
			repAct.add(act);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (repAct.getAll().get(0).equals(act) && repAct.getAll().size() == 1)
			part2 = true;


	}
}
