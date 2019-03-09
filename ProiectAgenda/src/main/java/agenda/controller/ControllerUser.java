package agenda.controller;

import agenda.model.base.User;
import agenda.model.repository.interfaces.IRepositoryUser;

import javax.jws.soap.SOAPBinding;

public class ControllerUser implements IControllerUser{

    private IRepositoryUser repositoryUser;

    public ControllerUser(IRepositoryUser repository){
        this.repositoryUser=repository;
    }

    public User getByUsername(String username) {
        for (User u : repositoryUser.getAll())
            if (u.getUsername().equals(username)) return u;
        return null;
    }

    public User getByName(String name) {
        for (User u : repositoryUser.getAll())
            if (u.getName().equals(name)) return u;
        return null;
    }

    public boolean changePasswd(User user, String oldPasswd, String newPasswd) {
        int index = repositoryUser.getAll().indexOf(user);
        if (index < 0) return false;
        if (user.getPassword().equals(oldPasswd)) {
            repositoryUser.remove(user);
            user.setPassword(newPasswd);
            repositoryUser.add(user);
            return true;
        }
        return false;
    }


    public boolean checkPassword(String password) {
        for(User user:repositoryUser.getAll())
            if (user.getPassword().equals(password))
            return true;
       return false;
    }
}
