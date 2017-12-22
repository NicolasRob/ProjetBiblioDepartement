/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrobillard.controleurs;

import com.nrobillard.service.BookService;
import com.nrobillard.modeles.classes.Book;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Vengor
 */
@Controller
public class BookControleur
{
    private BookService bookService;

    public void setBookService(BookService bookService)
    {
        this.bookService = bookService;
    }
    
    @RequestMapping("catalogue")
    public String afficherCatalogue(ModelMap model) {
        List<Book> liste = bookService.obtenirLivresCatalogue();
        model.addAttribute("livres", liste);
        return "catalogue";
    }
    
    @RequestMapping(method = RequestMethod.GET, value="ajout")
    public String afficherAjout(ModelMap model) {
        return "ajout";
    }
    
    @RequestMapping(method = RequestMethod.POST, value="ajout")
    public ModelAndView ajouter(Book b, ModelMap model)
    {
        model.addAttribute("livre", b);
        if (b.getIsbn() == null || "".equals(b.getIsbn().trim()))
        {
            model.addAttribute("message", "Vous devez entrer un ISBN");
            return new ModelAndView("ajout", model);
        }
        else
        {
            int resultat = bookService.ajouterLivreCatalogue(b);
            if (resultat == 0)
            {
                model.addAttribute("message", "Le livre a ete ajoute");
                return new ModelAndView("redirect:/book/catalogue", model);
            }
            else if (resultat == 1)
            {
                model.addAttribute("message", "Un livre avec ce ISBN existe déja");
                return new ModelAndView("ajout", model);
            }
            else
            {
                model.addAttribute("message", "Une erreur est survenu lors de l'ajout du livre");
                return new ModelAndView("ajout", model);
            }
        }
    }
    
}
