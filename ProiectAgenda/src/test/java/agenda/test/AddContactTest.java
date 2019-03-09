package agenda.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import agenda.exceptions.InvalidFormatException;

import agenda.model.base.Contact;
import agenda.model.repository.classes.RepositoryContactMock;
import agenda.model.repository.interfaces.IRepositoryContact;


public class AddContactTest {

	private Contact con;
	private IRepositoryContact rep;
	
	@Before
	public void setUp() throws Exception {
		rep = new RepositoryContactMock();
	}
	
	@Test
	public void testCase1()
	{
		try {
			con = new Contact("name", "address1", "+4071122334455");
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		//int n = rep.count();
		rep.add(con);
		for(Contact c : rep.getAll())
			if (c.equals(con))
			{
				assertTrue(true);
				break;
			}
		//assertTrue(n+1 == rep.count());
	}
	
	@Test
	public void testCase2()
	{
		try{
			rep.add((Contact) new Object());
		}
		catch(Exception e)
		{
			assertTrue(true);
		}	
	}
	
	@Test
	public void testCase3()
	{
		for(Contact c : rep.getAll())
			rep.remove(c);
		
		try {
			con = new Contact("name", "address1", "+071122334455");
			rep.add(con);
		} catch (InvalidFormatException e) {
			assertTrue(false);
		}
		int n  = rep.getAll().size();
		if (n == 1) 
			if (con.equals(rep.getAll().get(0))) assertTrue(true);
			else assertTrue(false);
		else assertTrue(false);
	}
	
}
