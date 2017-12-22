package com.nrobillard.controleurs;

import com.nrobillard.modeles.classes.User;
import javax.servlet.http.HttpSession;
import com.nrobillard.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping(method = RequestMethod.POST, value="login", params={"courriel","password"})
    public ModelAndView login(@RequestParam("courriel") String courriel, @RequestParam("password")
            String password,ModelMap model, HttpSession session)
    {
        if( courriel == null || "".equals(courriel.trim())
            || password == null || "".equals(password.trim()))
            model.addAttribute("message","Tout les champs doivent être remplis");
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
                  model.addAttribute("courriel", courriel);
                  break;
              case 2:
                  model.addAttribute("message","Le mot de passe entré est incorrect.");
                  model.addAttribute("courriel", courriel);
                  break;
          }
        }
        if (session.getAttribute("User") == null)
            return new ModelAndView("login", model);
        else
            return new ModelAndView("redirect:/book/catalogue");
    }
    
    @RequestMapping(method = RequestMethod.GET, value="inscription")
    public String inscription(){
        return "inscription";
    }
    
    @RequestMapping(method = RequestMethod.POST, value="inscription", params={"courriel","password"})
    public ModelAndView inscription(@RequestParam("courriel") String courriel, @RequestParam("password") String password,ModelMap model)
    {
        if( courriel == null || "".equals(courriel.trim())
            || password == null || "".equals(password.trim()))
        {
            model.addAttribute("message","Tout les champs doivent être remplis");
            model.addAttribute("courriel", courriel);
            return new ModelAndView("inscription", model);
        }    
        User user = new User(courriel,password);
        boolean resultat = service.inscription(user);
        if(resultat){
            model.addAttribute("creation", "Votre compte a ete cree");
            //Redirection pour éviter les double submit
            return new ModelAndView("redirect:/user/login", model);
        }
        else{
            model.addAttribute("message","Un compte avec le courriel entré existe déja");
            model.addAttribute("courriel", courriel);
            return new ModelAndView("inscription", model);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String logout(ModelMap model, HttpSession session){
        session.invalidate();
        return "login";
    }
}
