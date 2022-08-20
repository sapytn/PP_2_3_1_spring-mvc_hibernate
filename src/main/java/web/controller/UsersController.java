package web.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

  @Autowired
  private UserService userService;

  @RequestMapping("/users")
  public String showAllUser(Model model) {
    List<User> allUser = userService.getUsers();
    model.addAttribute("users", allUser);
    return "user";
  }

  @RequestMapping("/addUser")
  public String addNewUser(Model model) {
    User user = new User();
    model.addAttribute("user",user);
    return "user-info";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String addUser(User user) {
    userService.add(user);
    return "redirect:/users";
  }

  @RequestMapping("/edit/{id}")
  public ModelAndView editForm(@PathVariable("id")int id){
    ModelAndView modelAndView = new ModelAndView("edit_user");
    return null;
  }

  @GetMapping(value = "/index")
  public String printWelcome(ModelMap model) {
    List<String> messages = new ArrayList<>();
    messages.add("Hello!");
    messages.add("I'm Spring MVC application");
    messages.add("5.2.0 version by sep'19 ");
    model.addAttribute("messages", messages);
    return "index";
  }

}
