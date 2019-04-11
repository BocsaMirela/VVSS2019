package agenda.repository.classes;


import java.util.LinkedList;
import java.util.List;

import agenda.model.base.Activity;
import agenda.repository.interfaces.IRepositoryActivity;

public class RepositoryActivityMock implements IRepositoryActivity {

    private List<Activity> activities;

    public RepositoryActivityMock() {
        activities = new LinkedList<Activity>();
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
            return true;
        }
        return false;
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
