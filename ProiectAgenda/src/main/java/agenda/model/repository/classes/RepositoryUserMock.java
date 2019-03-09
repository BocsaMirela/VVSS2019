package agenda.model.repository.classes;

import agenda.model.base.User;
import agenda.model.repository.interfaces.IRepository;

import java.util.List;

public class RepositoryUserMock implements IRepository<User>{


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
        return null;
    }
}
