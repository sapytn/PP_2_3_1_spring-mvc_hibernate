package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.service.UserService;
import web.service.UserServiceImpl;

@Controller
public class Main {

    @Autowired
    private static UserService userService;

    public static void main(String[] args) {
        System.out.printf(userService.show(1).toString());
    }
}
