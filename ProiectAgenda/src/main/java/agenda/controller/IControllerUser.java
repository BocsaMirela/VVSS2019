package agenda.controller;

import agenda.model.base.Activity;
import agenda.model.base.User;

import java.util.Date;
import java.util.List;

public interface IControllerUser {

    public User getByUsername(String username);
    public User getByName(String name);
    public boolean changePasswd(User user, String oldPasswd, String newPasswd);
    public boolean checkPassword(String password);
}
