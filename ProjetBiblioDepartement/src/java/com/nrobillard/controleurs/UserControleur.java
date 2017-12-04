/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrobillard.controleurs;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
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
    /*private ConverterService converterService;
    public void setConverterService(ConverterService converterService) {
        this.converterService = converterService;
    }*/
    //@ResponseBody
    @RequestMapping("/")
    public String login(ModelMap model) {
        //List<String> liste = this.converterService.getMonnaiesListe();
        //model.addAttribute("bienvenue", "Bienvenue au service de conversion de monnaies");
        //model.addAttribute("monnaies", liste);
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
