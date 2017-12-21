/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrobillard.service;

import com.nrobillard.modeles.classes.Book;
import com.nrobillard.modeles.dao.BookDAO;
import java.util.List;

/**
 *
 * @author Vengor
 */
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
