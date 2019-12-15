package ru.shara.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.shara.application.model.Role;
import ru.shara.application.model.User;
import ru.shara.application.sevice.RoleService;
import ru.shara.application.sevice.UserService;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    private UserService userService;
    private RoleService roleService;



    @Autowired
    public void setUserService(UserService userService, RoleService userServiceRole) {
        this.userService = userService;
        this.roleService = userServiceRole;

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView userPage() {
        ModelAndView model = new ModelAndView();
        model.setViewName("UserPage");
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView add() throws Exception {
        ModelAndView model = new ModelAndView("RegistrationPage");
        model.addObject("user", new User());
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute User user, @RequestParam("role") String role) throws SQLException {
        ModelAndView model = new ModelAndView();
        Set<Role> roles = new HashSet<>();
        if (userService.getUserByName(user.getName()) == null && role.equals("ADMIN,USER")) {
            String[] res = role.split(",");
            roles.add(roleService.getUserRole(res[0]));
            roles.add(roleService.getUserRole(res[1]));
            user.setUserRoles(roles);
            userService.addUser(user);
            model.setViewName("redirect:/login");
        } else if (userService.getUserByName(user.getName()) == null){
            roles.add(roleService.getUserRole(role));
            user.setUserRoles(roles);
            userService.addUser(user);
            model.setViewName("redirect:/login");
        }
        return model;
    }
}
