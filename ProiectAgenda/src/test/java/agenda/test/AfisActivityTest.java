//package agenda.test;
//
//import static org.junit.Assert.*;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.LinkedList;
//import java.util.List;
//
//import agenda.model.base.Activity;
//import agenda.model.base.Contact;
//import agenda.model.repository.classes.RepositoryActivityFile;
//import agenda.model.repository.classes.RepositoryContactFile;
//import agenda.model.repository.interfaces.IRepositoryActivity;
//import agenda.model.repository.interfaces.IRepositoryContact;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class AfisActivityTest {
//
//	IRepositoryActivity rep;
//
//	@Before
//	public void setUp() throws Exception {
//		IRepositoryContact repcon = new RepositoryContactFile("contactTest.txt");
//		rep = new RepositoryActivityFile("activitiesTest.txt",repcon.getAll());
//	}
//
//	@Test
//	public void testCase1() {
//		for (Activity act : rep.getAll())
//			rep.remove(act);
//
//		Calendar c = Calendar.getInstance();
//		c.set(2013, 3 - 1, 20, 12, 00);
//		Date start = c.getTime();
//
//		c.set(2013, 3 - 1, 20, 12, 30);
//		Date end = c.getTime();
//
//		Activity act = new Activity("name1", start, end,
//				new LinkedList<Contact>(), "description2");
//
//		rep.add(act);
//
//		c.set(2013, 3 - 1, 20);
//
//
//	}
//
//	@Test
//	public void testCase2() {
//		for (Activity act : rep.getAll())
//			rep.remove(act);
//
//		Calendar c = Calendar.getInstance();
//		c.set(2013, 3 - 1, 20, 12, 00);
//		Date start = c.getTime();
//
//		c.set(2013, 3 - 1, 20, 12, 30);
//		Date end = c.getTime();
//
//		Activity act = new Activity("name1", start, end,
//				new LinkedList<Contact>(), "description2");
//
//		rep.add(act);
//
//		c.set(2013, 3 - 1, 20);
//
//	}
//
//	@Test
//	public void testCase3() {
//		for (Activity act : rep.getAll())
//			rep.remove(act);
//
//
//	}
//
//	@Test
//	public void testCase4() {
//		for (Activity act : rep.getAll())
//			rep.remove(act);
//
//		try {
//			rep.add((Activity)(Object)1);
//
//			Calendar c = Calendar.getInstance();
//			c.set(2013, 3 - 1, 20);
//		} catch (Exception e) {
//			assertTrue(true);
//		}
//	}
//
//	@Test
//	public void testCase5() {
//		for (Activity act : rep.getAll())
//			rep.remove(act);
//
//		Calendar c = Calendar.getInstance();
//		c.set(2013, 3 - 1, 20);
//
//	}
//}
