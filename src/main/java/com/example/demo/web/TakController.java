package com.example.demo.web;

import com.example.demo.model.binding.TaskBindingModel;
import com.example.demo.model.service.TaskServiceModel;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TakController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public TakController(TaskService taskService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")
    public String add(Model model){
        if (currentUser.isAnonymous()){
            return "redirect:/";
        }
        if (!model.containsAttribute("taskBindingModel")){
            model.addAttribute("taskBindingModel",new TaskBindingModel());
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskBindingModel taskBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskBindingModel", taskBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskBindingModel", bindingResult);
            return "redirect:add";
        }

        this.taskService.add(this.modelMapper.map(taskBindingModel, TaskServiceModel.class));
        return "redirect:/";
    }

    @GetMapping("/progress/{id}")
    public String progress(@PathVariable Long id){
        this.taskService.changeProgress(id);
        return "redirect:/";
    }
}
