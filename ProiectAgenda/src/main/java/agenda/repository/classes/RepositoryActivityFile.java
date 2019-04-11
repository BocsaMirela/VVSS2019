package agenda.repository.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import agenda.model.base.Activity;
import agenda.model.base.Contact;
import agenda.repository.interfaces.IRepositoryActivity;

public class RepositoryActivityFile implements IRepositoryActivity {

    private String filename;
    private List<Activity> activities;

    public RepositoryActivityFile(String filename, List<Contact> listOfContact) throws Exception {
        this.filename = filename;
        activities = new LinkedList<Activity>();
        //DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                Activity act= fromString(line,listOfContact);
                if (act == null)
                    throw new Exception("Error in file at line " + i, new Throwable("Invalid Activity"));
                activities.add(act);
                i++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (br != null) br.close();
        }
    }

    @Override
    public List<Activity> getAll() {
        return new LinkedList<Activity>(activities);
    }

    @Override
    public boolean add(Activity activity) {
        int i = 0;
        boolean conflicts = false;

        while (i < activities.size()) {
            if (activities.get(i).getStart().compareTo(activity.getDuration()) < 0)
                   if (activity.getStart().compareTo(activities.get(i).getDuration()) < 0)
                conflicts = true;
            i++;
        }
        if (!conflicts) {
            activities.add(activity);
            saveActivities();
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Activity activity) {
        int index = activities.indexOf(activity);
        if (index < 0)
            return false;
        activities.remove(index);
        return true;
    }

    private boolean saveActivities() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileOutputStream(filename));
            for (Activity a : activities)
                pw.println(a.toString());
        } catch (Exception e) {
            return false;
        } finally {
            if (pw != null) pw.close();
        }
        return true;
    }

    @Override
    public boolean update(Activity item) {
        return false;
    }

    private Contact getByName(String name, List<Contact> listOfContact){
        for (Contact c:listOfContact){
            if(c.getName().equals(name)) return c;
        }
        return null;
    }

    private Activity fromString(String line, List<Contact> listOfContact) {
        try {
            String[] str = line.split("#");
            String name = str[0];
            Date start = new Date(Long.parseLong(str[1]));
            Date duration = new Date(Long.parseLong(str[2]));
            String description = str[3];
            List<Contact> conts = new LinkedList<Contact>();
            for (int i = 4; i < str.length; i++) {
                conts.add(getByName(name,listOfContact));
            }
            return new Activity(name, start, duration, conts, description);
        } catch (Exception e) {
            return null;
        }
    }

}
