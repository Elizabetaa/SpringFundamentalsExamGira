package com.example.demo.web;

import com.example.demo.model.binding.LoginBindingModel;
import com.example.demo.model.binding.RegisterBindingModel;
import com.example.demo.model.service.LoginServiceModel;
import com.example.demo.model.service.RegisterServiceModel;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;

    public UserController(ModelMapper modelMapper, UserService userService, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("registerBindingModel")) {
            model.addAttribute("registerBindingModel", new RegisterBindingModel());
            model.addAttribute("emailExist", false);
            model.addAttribute("usernameExist", false);
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid RegisterBindingModel registerBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !registerBindingModel.getPassword().equals(registerBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerBindingModel", bindingResult);
            return "redirect:register";
        }
        String isExist = this.userService.register(this.modelMapper.map(registerBindingModel, RegisterServiceModel.class));
        if (isExist.equals("")){
            return "redirect:login";
        }
        if (isExist.equals("User email already exist")){
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("emailExist", true);
        }
        if (isExist.equals("Username already exist")){
            redirectAttributes.addFlashAttribute("registerBindingModel", registerBindingModel);
            redirectAttributes.addFlashAttribute("usernameExist", true);
        }

        return "redirect:register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("loginBindingModel")) {
            model.addAttribute("loginBindingModel", new LoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid LoginBindingModel loginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginBindingModel", bindingResult);

            return "redirect:login";
        }

        if (!this.userService.login(this.modelMapper.map(loginBindingModel, LoginServiceModel.class))) {
            redirectAttributes.addFlashAttribute("loginBindingModel", loginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        this.userService.logout();
        return "redirect:/";
    }
}
