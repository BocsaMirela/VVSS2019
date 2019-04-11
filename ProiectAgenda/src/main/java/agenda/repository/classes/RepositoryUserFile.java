package agenda.repository.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import agenda.model.base.User;
import agenda.repository.interfaces.IRepositoryUser;

public class RepositoryUserFile implements IRepositoryUser {

	private List<User> users;
	private  String filename;

	public RepositoryUserFile(String filename) throws Exception
	{
		this.filename=filename;
		users = new LinkedList<User>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String line;
			int i = 0;
			while (( line = br.readLine())!= null)
			{
				String[] str = line.split("#");
				User u=null;
				try {
					u=new  User(str[0], str[1], str[2]);
				} catch (Exception e) {
				}
				if (u == null) 
					throw new Exception("Error in file at line "+i, new Throwable("Invalid Activity"));
				users.add(u);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (br!=null) br.close();
		}
	}

	public boolean save() {
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new FileOutputStream(filename));
			for(User u : users)
				pw.println(u.toString());
		}catch (Exception e)
		{
			return false;
		}
		finally{
			if (pw!=null) pw.close();
		}
		return true;
	}

	@Override
	public boolean add(User item) {
		return false;
	}

	@Override
	public boolean remove(User item) {
		return false;
	}

	@Override
	public boolean update(User item) {
		return false;
	}

	@Override
	public List<User> getAll() {
		return new LinkedList<User>(users);
	}


}
