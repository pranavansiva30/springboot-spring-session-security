package com.wavesdev.session.controller;

import com.wavesdev.session.service.UserService;
import com.wavesdev.session.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pranavan on 4/5/18.
 */
@Controller
@RequestMapping(value="/user/**")
public class UserController {

    @Autowired
    @Qualifier("sessionRegistry")
    private SessionRegistry sessionRegistry;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/activesessionusers")
    private String usersNamesList(Model model) {
        List<Object> principals = sessionRegistry.getAllPrincipals();

        List<String> usersNamesList = new ArrayList<String>();

        for (Object principal : principals) {
            if (principal instanceof User) {
                usersNamesList.add(((User) principal).getUsername());
            }
        }
        model.addAttribute("users",usersNamesList);
return "activesessionusers";

    }
    @RequestMapping(method = RequestMethod.POST,value="/resetpassword")
    public String updateUser(@ModelAttribute com.wavesdev.session.model.User user, final BindingResult errors, final HttpServletRequest request, HttpServletResponse response
    ) throws ServletRequestBindingException {
        com.wavesdev.session.model.User entity = userService.findOne(user.getId());
        if(entity!=null) {
            if(!user.getPassword().equals(entity.getPassword())) {
                userService.resetPassword(user);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                new SecurityContextLogoutHandler().logout(request, response, auth);
                return "redirect:/login";
            }
            else{

                userService.updateUser(user);

            }
        }

        return "redirect:/resetpassword";

    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json" ,value="/resetpassword")
    public String resetPassword(Model model, Principal principal){

        com.wavesdev.session.model.User user = userService.findByUsername(principal.getName());
        model.addAttribute("user",user);

        return "resetpassword";

    }



}
