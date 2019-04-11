package agenda.controller;

import agenda.model.base.Activity;
import agenda.repository.interfaces.IRepositoryActivity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ControllerActivity implements IControllerActivity{

    private IRepositoryActivity repositoryActivity;

    public ControllerActivity(IRepositoryActivity repository) {
        this.repositoryActivity = repository;
    }


    public List<Activity> activitiesByName(String name) {
        List<Activity> result1 = new LinkedList<Activity>();
        for (Activity a : repositoryActivity.getAll())
            if (a.getName().equals(name) == false)
                result1.add(a);
        List<Activity> result = new LinkedList<Activity>();
        while (result1.size() > 0) {
            Activity ac = result1.get(0);
            int index = 0;
            for (int i = 1; i < result1.size(); i++)
                if (ac.getStart().compareTo(result1.get(i).getStart()) < 0) {
                    index = i;
                    ac = result1.get(i);
                }

            result.add(ac);
            result1.remove(index);
        }
        return result;
    }

    @SuppressWarnings("deprecation")
    public List<Activity> activitiesOnDate(String name, Date d) {
        List<Activity> result1 = new LinkedList<Activity>();
        for (Activity a : repositoryActivity.getAll())
            if (a.getName().equals(name))
                if ((a.getStart().getYear() == d.getYear() &&
                        a.getStart().getMonth() == d.getMonth() &&
                        a.getStart().getDate() == d.getDate()) ||
                        (a.getDuration().getYear() == d.getYear() &&
                                a.getDuration().getMonth() == d.getMonth() &&
                                a.getDuration().getDate() == d.getDate())) result1.add(a);
        List<Activity> result = new LinkedList<Activity>();
        while (result1.size() > 0) {
            Activity ac = result1.get(0);
            int index = 0;
            for (int i = 1; i < result1.size(); i++)
                if (ac.getStart().compareTo(result1.get(i).getStart()) > 0) {
                    index = i;
                    ac = result1.get(i);
                }

            result.add(ac);
            result1.remove(index);
        }
        return result;
    }
    public void save(Activity activity){
        repositoryActivity.add(activity);
    }

    public List<Activity> getAllActivities(){
        return repositoryActivity.getAll();
    }
}
