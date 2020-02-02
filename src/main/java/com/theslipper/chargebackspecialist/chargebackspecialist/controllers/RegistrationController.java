package com.theslipper.chargebackspecialist.chargebackspecialist.controllers;

import com.google.common.collect.Lists;
import com.theslipper.chargebackspecialist.chargebackspecialist.dto.UserRegistrationDto;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUser;
import com.theslipper.chargebackspecialist.chargebackspecialist.models.SystemUserRole;
import com.theslipper.chargebackspecialist.chargebackspecialist.services.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

@Controller
public class RegistrationController {

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/registration")
    public String showRegistrationForm(Model model) {
        UserRegistrationDto dto = new UserRegistrationDto();
        model.addAttribute("registrationDto", dto);
        return "registration";
    }

    @RequestMapping(value = "/registration/process")
    public RedirectView registerUserAccount(RedirectAttributes attributes,
                                            @ModelAttribute("user") @Valid UserRegistrationDto dto) {
        boolean addedUsr = false;
        if (systemUserService.getSystemUsersByEmail(dto.geteMail()).size() < 1
            && Lists.newArrayList(systemUserService.getSystemUsersByLogin(dto.getLogin()).iterator()).size() < 1 &&
                dto.getPassword().equals(dto.getPasswordConfirm())) {
            systemUserService.addSystemUser(new SystemUser(
                    UUID.randomUUID(),
                    dto.getName(),
                    dto.getSurname(),
                    dto.geteMail(),
                    dto.getLogin(),
                    passwordEncoder.encode(dto.getPassword()),
                    new Date(),
                    null,
                    this.systemUserService.getSystemUserRolesByName("New User").iterator().next(),
                    true
            ));
            addedUsr = true;
        }
        if (addedUsr)
            return new RedirectView("/login");
        else {
            return new RedirectView("/login?error");
        }
    }
}
