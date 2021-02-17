package com.example.demo.web;

import com.example.demo.security.CurrentUser;
import com.example.demo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model){
        if (currentUser.isAnonymous()){
            return "index";
        }
        model.addAttribute("allTasks",this.taskService.findAllTask());
        return "home";
    }


}
