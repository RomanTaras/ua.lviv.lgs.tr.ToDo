package ua.lviv.lgs.tr.ToDo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.lviv.lgs.tr.ToDo.command.LoginCommand;
import ua.lviv.lgs.tr.ToDo.command.RegCommand;
import ua.lviv.lgs.tr.ToDo.domain.Todo;
import ua.lviv.lgs.tr.ToDo.domain.User;
import ua.lviv.lgs.tr.ToDo.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/reg_form"})
    public String register(Model m) {
        RegCommand cmd = new RegCommand();
        m.addAttribute("command", cmd);
        return "register";
    }

    @RequestMapping(value = {"/register"})
    public String registerUser(@ModelAttribute("command") RegCommand cmd, Model m) {
        User u = cmd.getU();
        userService.register(u);
        return "redirect:loginform?act=reg";
    }

    @RequestMapping(value = {"/loginform"})
    public String loginForm(Model m) {
        LoginCommand cmd = new LoginCommand();
        m.addAttribute("command", cmd);
        return "login";
    }

    @RequestMapping(value = {"/logindo"})
    public String logindo(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
        if (loggedInUser == null) {
            m.addAttribute("error", "You provided wrong information.</br>Please provide valid credentials");
            return "login";
        } else {
            addUserInSession(loggedInUser, session);
            return "redirect:addTask?act=task page";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=log";
    }

    @RequestMapping(value = {"/addTask"})
    public String addTask(Model m) {
        Todo todo = new Todo();
        m.addAttribute("command", todo);

        return "addNewTask";
    }

    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
    }

}
