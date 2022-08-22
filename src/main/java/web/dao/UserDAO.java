package web.dao;

import java.util.List;
import web.model.User;

public interface UserDAO {

  void add(User user);
  User show(long id);
  public List<User> getUsers();
}
