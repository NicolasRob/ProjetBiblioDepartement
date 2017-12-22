package com.nrobillard.controleurs;

import com.nrobillard.service.BookService;
import com.nrobillard.modeles.classes.Book;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView ajouter(@Valid @ModelAttribute Book b, BindingResult bindingResult, ModelMap model)
    {
        model.addAttribute("livre", b);
        if (bindingResult.hasErrors())
        {
            model.addAttribute("message", "Les données entrées sont incorrects."
                    + " Assurez-vous que les champs de date et de pages sont des nombres entiers de moins de 12 chiffres");
            return new ModelAndView("ajout", model);
        }
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
                //Redirection pour éviter les double submit
                return new ModelAndView("redirect:/book/catalogue", model);
            }
            else if (resultat == 1)
            {
                model.addAttribute("message", "Un livre avec ce ISBN existe déja");
                return new ModelAndView("ajout", model);
            }
            else
            {
                model.addAttribute("message", "Une erreur est survenu lors de l'ajout du livre."
                        + " Assurez-vous que le langage contient moins de 8 caractères et que"
                        + " le mot-clé est moins de 7 caractères. ");
                return new ModelAndView("ajout", model);
            }
        }
    }
    
}
