/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrobillard.controleurs;

import com.nrobillard.modeles.classes.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.nrobillard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Vengor
 */
@Controller
public class UserControleur
{
    private UserService service;

    public void setService(UserService service) {
        this.service = service;
    }
    
    @RequestMapping(method = RequestMethod.GET, value="login")
    public String login()
    {
        return "login";
    }
    
    //retourne 0 pour un login réussi, 1 pour une erreur de compte
    // et 2 pour un mot de passe incorrect
    @RequestMapping(method = RequestMethod.POST, value="login", params={"courriel","password"})
    public ModelAndView login(@RequestParam("courriel") String courriel, @RequestParam("password") 
            String password,ModelMap model, HttpSession session){
        if( courriel == null || "".equals(courriel.trim()) 
            || password == null || "".equals(password.trim()))
            model.addAttribute("message","Tout les champs doivent être remplis");
        }
        else
        {
          User user = new User(courriel,password);
          int resultat = service.login(user);
          switch (resultat){
              case 0:
                  session.setAttribute("User",user);
                  break;

              case 1:
                  model.addAttribute("message","Le compte entré n'existe pas.");
                  break;

              case 2:
                  model.addAttribute("message","Le mot de passe entré est incorrect.");
                  model.addAttribute("courriel", courriel);
                  break;
          }
        }
        return new ModelAndView("login", model);
    }
    
    @RequestMapping(method = RequestMethod.GET, value="inscription")
    public String inscription(){
        return "inscription";
    }
    
    @RequestMapping(method = RequestMethod.POST, value="inscription", params={"courriel","password"})
    public String inscription(@RequestParam("courriel") String courriel, @RequestParam("password") String password,ModelMap model){
        
        if((courriel.isEmpty() || courriel.equalsIgnoreCase(""))){
            model.addAttribute("message","votre courriel doit etre au moin 1 caractere");
            return "login";
        }
        
        if( courriel == null || "".equals(courriel.trim()) 
            || password == null || "".equals(password.trim()))
            model.addAttribute("message","Tout les champs doivent être remplis");
        
        User user = new User(courriel,password);
        boolean resultat = service.inscription(user);
        
        if(resultat){
            model.addAttribute("message", "Votre compte a été créé");
            return "login";
        }
        else{
            model.addAttribute("message","inscription a echouer");
            return "inscription";
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String logout(ModelMap model, HttpSession session){
        session.invalidate();
        return "login";
    }
}
