package com.nrobillard.service;

import com.nrobillard.modeles.classes.Book;
import com.nrobillard.modeles.dao.BookDAO;
import java.util.List;

public class BookService
{
    private BookDAO dao;
    
    public void setDao(BookDAO dao)
    {
        this.dao = dao;
    }
    
    public List<Book> obtenirLivresCatalogue()
    {
        return dao.findAll();
    }
    
    //Utilise des entiers pour représenter des codes d'erreurs
    //Retourne 1 si l'isbn existe déja
    //Retourne 2 si la création du livre échoue
    public int ajouterLivreCatalogue(Book b)
    {
        if (dao.read(b.getIsbn()) != null)
            return 1;
        if (dao.create(b))
            return 0;
        else
            return 2;
    }
}
