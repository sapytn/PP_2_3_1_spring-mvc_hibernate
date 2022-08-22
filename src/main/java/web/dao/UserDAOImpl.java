package web.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public void add(User user) {
    sessionFactory.getCurrentSession().save(user);
  }

  @Override
  public User show(long id) {
    User user = (User) sessionFactory.getCurrentSession().
            createSQLQuery("select * from users where id = :id")
            .setParameter("id", id).getSingleResult();
    return user;
  }


  @Override
  public List<User> getUsers() {
    TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
    return query.getResultList();
  }
}
