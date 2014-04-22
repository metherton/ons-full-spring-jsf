package com.martinetherton.ons.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    @RequestMapping("/bla")
    public String overzicht(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("overzicht", "visited");
        return "overzicht";
    }
    
    @RequestMapping("/print")
    @ResponseStatus(HttpStatus.FOUND)
    public String print(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("print", "visited");
        response.setHeader("Location", "bevestiging");
        return "print";
    }    

    @RequestMapping("/senddms")
    public String senddms(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("senddms", "visited");
        return "redirect:print";
    }      
    
    @RequestMapping("/bevestiging")
    public String bevestiging(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("overzicht", session.getAttribute("overzicht"));        
        model.addAttribute("senddms", session.getAttribute("senddms"));       
        model.addAttribute("sendmessage", session.getAttribute("sendmessage"));
        model.addAttribute("print", session.getAttribute("print"));
        model.addAttribute("bevestiging", "visited");
        return "bevestiging";
    }          
    
}
