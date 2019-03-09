package agenda.controller;

import agenda.model.base.Activity;

import java.util.Date;
import java.util.List;

public interface IControllerActivity {

    public List<Activity> activitiesByName(String name);
    public List<Activity> activitiesOnDate(String name, Date d);
    public List<Activity> getAllActivities();

    void save(Activity act);
}
