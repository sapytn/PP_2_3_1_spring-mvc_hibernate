package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import web.config.AppConfig;
import web.model.User;
import web.service.UserService;

public class MainApp {

  public static void main(String[] args) {
    String url = "jdbc:mysql://127.0.0.1:3306/spring_mvc_hiber";
    String username = "bestuser";
    String password = "bestuser";
    System.out.println("Connecting...");

    try (Connection connection = DriverManager.getConnection(url, username, password)) {
      System.out.println("Connection successful!");
    } catch (SQLException e) {
      System.out.println("Connection failed!");
      e.printStackTrace();
    }
  }
}
