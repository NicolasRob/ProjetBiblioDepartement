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
    
    
    /*private ConverterService converterService;
    public void setConverterService(ConverterService converterService) {
        this.converterService = converterService;
    }*/
    //@ResponseBody
    @RequestMapping("/")
    public String home(ModelMap model) {
        //List<String> liste = this.converterService.getMonnaiesListe();
        //model.addAttribute("bienvenue", "Bienvenue au service de conversion de monnaies");
        //model.addAttribute("monnaies", liste);
        return "login";
    }
    
    //retourne 0 pour un login rÃ©ussi, 1 pour une erreur de compte
    // et 2 pur un mauvais password
    @RequestMapping(method = RequestMethod.GET, value="login", params={"courriel","password"})
    public String login(@RequestParam("courriel") String courriel, @RequestParam("password") String password,ModelMap model, HttpSession session){
        
        if((courriel.isEmpty() || courriel.equalsIgnoreCase(""))){
            model.addAttribute("message","votre courriel doit etre au moin 1 caractere");
        }
        
        if(password.isEmpty() || password.equalsIgnoreCase("")){
            model.addAttribute("message","votre mot de passe doit etre au moin 1 caractere");
        }
        
        User user = new User(courriel,password);
        int resultat = service.login(user);
        switch (resultat){
            case 0:
                session.setAttribute("User",user );
                break;
                
            case 1:
                model.addAttribute("message","votre compte nexiste pas");
                break;
                
            case 2:
                model.addAttribute("message","vous avez entre un mauvai password");
                break;
        }
        //la requete va etre intercepter par l'intercepteur et forward au catalogue
        return "login";
    }
    
    @RequestMapping(method = RequestMethod.GET, value="inscription", params={"courriel","password"})
    public String inscription(@RequestParam("courriel") String courriel, @RequestParam("password") String password,ModelMap model){
        
        if((courriel.isEmpty() || courriel.equalsIgnoreCase(""))){
            model.addAttribute("message","votre courriel doit etre au moin 1 caractere");
        }
        
        if(password.isEmpty() || password.equalsIgnoreCase("")){
            model.addAttribute("message","votre mot de passe doit etre au moin 1 caractere");
        }
        
        User user = new User(courriel,password);
        boolean resultat = service.inscription(user);
        
        if(resultat){
            model.addAttribute("message", "inscription reussie");
        }
        else{
            model.addAttribute("message","inscription a echouer");
        }
        
        return "login";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "logout")
    public String logout(ModelMap model, HttpSession session){
        session.invalidate();
        return "login";
    }
    /*//@ResponseBody
    @RequestMapping(method = RequestMethod.GET, value="/", params={"nom"})
    public String convert(@RequestParam("nom") String nom, ModelMap model) {
        model.addAttribute("message", "1 "+nom+" vaut "+converterService.getTaux(nom)+" $CAN");
        return "convert";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(ModelMap model) throws IOException
    {
        model.put("form", new Form());    
        return "add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public View create(HttpSession session, Form form, ModelMap model) throws IOException
    {
        Monnaie monnaie = new Monnaie();
        monnaie.setNom(form.getNom());
        monnaie.setValeur(form.getValeur());
        this.converterService.addMonnaie(monnaie);

        return new RedirectView("/", true, false);
    }
    
    public static class Form {
        private String nom;
        private double valeur;

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public double getValeur() {
            return valeur;
        }

        public void setValeur(double valeur) {
            this.valeur = valeur;
        }       
    }*/
    
}
