package web.dao;

import java.util.List;
import web.model.User;

public interface UserDAO {

  void add(User user);
  public List<User> getUsers();
}
