package com.assigment.chat.controller;

import com.assigment.chat.protocol.registration.RegistrationForm;
import com.assigment.chat.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping
    public String saveCredentials(@Valid RegistrationForm registrationForm, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors() && userService.loginIsExists(registrationForm.getLogin())) {
            bindingResult.addError(new FieldError(RegistrationForm.class.getName(), "login", "login already exists"));
        }
        if (!bindingResult.hasErrors() && !registrationForm.getPassword().equals(registrationForm.getPasswordAgain())) {
            bindingResult.addError(new FieldError(RegistrationForm.class.getName(), "passwordAgain", "password must be the same"));
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("validation", bindingResult);
            model.addAttribute("registrationForm", registrationForm);
            return "registration";
        }
        userService.createUser(registrationForm);
        return "redirect:/login";
    }
}
