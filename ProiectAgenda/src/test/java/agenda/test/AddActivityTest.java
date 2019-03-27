//package agenda.test;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//import agenda.model.base.Activity;
//import agenda.model.repository.classes.RepositoryActivityMock;
//import agenda.model.repository.interfaces.IRepositoryActivity;
//
//import org.junit.Before;
//import org.junit.Test;
//
//public class AddActivityTest
//{
//	private Activity act;
//	private IRepositoryActivity rep;
//
//	@Before
//	public void setUp() throws Exception {
//		rep = new RepositoryActivityMock();
//	}
//
//	@Test
//	public void testCase1()
//	{
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		try {
//			act = new Activity("name1",
//					df.parse("03/20/2013 12:00"),
//					df.parse("03/20/2013 13:00"),
//					null,
//					"Lunch break");
//			rep.add(act);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void testCase2()
//	{
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		try{
//			for (Activity a : rep.getAll())
//				rep.remove(a);
//
//			act = new Activity("name1",
//					df.parse("03/20/2013 12:00"),
//					df.parse("03/20/2013 13:00"),
//					null,
//					"Lunch break");
//			rep.add(act);
//
//			act = new Activity("name1",
//					df.parse("03/21/2013 12:00"),
//					df.parse("03/21/2013 13:00"),
//					null,
//					"Lunch break");
//			rep.add(act);
//		}
//		catch(Exception e){}
//		int c = rep.getAll().size();
//		assertTrue( c == 2);
//		for (Activity a : rep.getAll())
//			rep.remove(a);
//	}
//
//	@Test
//	public void testCase3()
//	{
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		try{
//			for (Activity a : rep.getAll())
//				rep.remove(a);
//
//			act = new Activity("name1",
//					df.parse("03/20/2013 12:00"),
//					df.parse("03/20/2013 13:00"),
//					null,
//					"Lunch break");
//			rep.add(act);
//
//			act = new Activity("name1",
//					df.parse("03/20/2013 12:30"),
//					df.parse("03/20/2013 13:30"),
//					null,
//					"Lunch break");
//			assertFalse(rep.add(act));
//		}
//		catch(Exception e){}
//		assertTrue( 1 == rep.getAll().size());
//		for (Activity a : rep.getAll())
//			rep.remove(a);
//	}
//
//	@Test
//	public void testCase4()
//	{
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		try{
//			for (Activity a : rep.getAll())
//				rep.remove(a);
//
//			act = new Activity("name1",
//					df.parse("03/20/2013 12:00"),
//					df.parse("03/20/2013 13:00"),
//					null,
//					"Lunch break");
//			rep.add(act);
//
//			act = new Activity("name1",
//					df.parse("03/20/2013 13:30"),
//					df.parse("03/20/2013 14:00"),
//					null,
//					"Curs");
//			rep.add(act);
//
//			act = new Activity("name1",
//					df.parse("03/20/2013 13:30"),
//					df.parse("03/20/2013 14:30"),
//					null,
//					"Lunch break");
//			assertFalse(rep.add(act));
//		}
//		catch(Exception e){}
//		assertTrue( 2 == rep.getAll().size());
//		for (Activity a : rep.getAll())
//			rep.remove(a);
//	}
//
//	@Test
//	public void testCase5()
//	{
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		try{
//			for (Activity a : rep.getAll())
//				rep.remove(a);
//
//			act = new Activity("name1",
//					df.parse("03/20/2013 12:00"),
//					df.parse("03/20/2013 13:00"),
//					null,
//					"Lunch break");
//			rep.add(act);
//
//			assertFalse(rep.add(act));
//		}
//		catch(Exception e){}
//		assertTrue( 1 == rep.getAll().size());
//		for (Activity a : rep.getAll())
//			rep.remove(a);
//	}
//}
