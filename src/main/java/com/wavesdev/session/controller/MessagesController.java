package com.wavesdev.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MessagesController {


    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        List<String> msgs = (List<String>) session.getAttribute("MY_MESSAGES");
        if(msgs == null) {
            msgs = new ArrayList<>();
        }
        model.addAttribute("messages", msgs);
        return "index";
    }

    @PostMapping("/messages")
    public String saveMessage(@RequestParam("msg") String msg, HttpServletRequest request) {
        List<String> msgs = (List<String>) request.getSession().getAttribute("MY_MESSAGES");
        if(msgs == null) {
            msgs = new ArrayList<>();

        }


        msgs.add(msg);
        request.getSession().setAttribute("MY_MESSAGES", msgs);
        return "redirect:/";
    }
}
