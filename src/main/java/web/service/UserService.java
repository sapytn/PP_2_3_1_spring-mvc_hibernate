package web.service;

import java.util.List;
import web.model.User;

public interface UserService {

  public void add(User user);

  public List<User> getUsers();

}
