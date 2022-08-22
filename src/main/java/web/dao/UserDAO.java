package web.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaTransactionManager;
import web.model.User;

public interface UserDAO {

  void saveUser(User user);
  void deleteUser(Long id);
  User show(Long id);
  public List<User> getUsers();
}
