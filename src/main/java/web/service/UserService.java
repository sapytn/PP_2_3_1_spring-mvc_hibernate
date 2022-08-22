package web.service;

import java.util.List;
import web.model.User;

public interface UserService {

  public void saveUser(User user);
  public void deleteUser(Long id);

  public List<User> getUsers();

  public User show(Long id);

}
