package agenda.model.repository.classes;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import agenda.model.base.Activity;
import agenda.model.repository.interfaces.IRepositoryActivity;

public class RepositoryActivityMock implements IRepositoryActivity {

    private List<Activity> activities;

    public RepositoryActivityMock() {
        activities = new LinkedList<Activity>();
//		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		try {
//			Activity act = new Activity(df.parse("03/20/2013 12:00"), 
//					df.parse("03/20/2013 14:00"),
//					null,
//					"Meal break",
//					"Memo");
//			activities.add(act);
//			act = new Activity(df.parse("03/21/2013 12:00"), 
//					df.parse("03/21/2013 14:00"),
//					null,
//					"Meal break",
//					"Memo");
//			activities.add(act);
//			act = new Activity(df.parse("03/22/2013 12:00"), 
//					df.parse("03/22/2013 14:00"),
//					null,
//					"Meal break",
//					"Memo");
//			activities.add(act);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
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
            if (activities.get(i).getStart().compareTo(activity.getDuration()) < 0 &&
                    activity.getStart().compareTo(activities.get(i).getDuration()) < 0)
                conflicts = true;
            i++;
        }
        if (!conflicts) {
            activities.add(activity);
            return true;
        }
        return false;
//		for (int i = 0; i< activities.size(); i++)
//		{
//			if (activity.intersect(activities.get(i))) return false;
//		}	
//		int index = activities.indexOf(activity);
//		//if (index >= 0 ) return false;
//		activities.add(activity);
//		return true;
    }

    @Override
    public boolean remove(Activity activity) {
        int index = activities.indexOf(activity);
        if (index < 0) return false;
        activities.remove(index);
        return true;
    }

    @Override
    public boolean update(Activity item) {
        return false;
    }

}
