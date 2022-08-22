package web.dao;

import java.util.List;
import java.util.Queue;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public void saveUser(User user) {
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(user);
  }

  @Override
  public void deleteUser(Long id) {
    User user = entityManager.find(User.class, id);
    entityManager.remove(user);
  }

  @Override
  public User show(Long id) {
    User user = entityManager.find(User.class, id);
    return user;
  }


  @Override
  public List<User> getUsers() {
    TypedQuery<User> query = entityManager.createQuery("select user from User user", User.class);
    return query.getResultList();
  }
}
