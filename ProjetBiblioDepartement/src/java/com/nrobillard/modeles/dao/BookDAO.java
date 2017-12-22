package com.nrobillard.modeles.dao;

import com.nrobillard.modeles.classes.Book;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Query;

public class BookDAO extends DAO<Book>
{
    
    public BookDAO()
    {

    }

    @Override
    public boolean create(Book x)
    {
        try
        {
            t.begin();
            em.persist(x);
            t.commit();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("EXCEPTION : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Book x)
    {
        try
        {
            Book u = em.find(Book.class, x.getIsbn());
            if (u != null)
            {
                t.begin();
                em.remove(u);
                t.commit();
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            System.out.println("EXCEPTION : " + e.getMessage());
            return false;
        }
    }

    @Override
    public Book read(int id)
    {
        return this.read("" + id);
    }

    @Override
    public Book read(String id)
    {
        List<Book> resultat = new LinkedList();
        try
        {
            Query qFindId = em.createNamedQuery("Book.findByIsbn");
            qFindId.setParameter("isbn", id);
            resultat = qFindId.getResultList();
            return (resultat.isEmpty()) ? null : resultat.get(0);
        }
        catch (Exception exp)
        {
            System.out.println("EXCEPTION :" + exp.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(Book u)
    {
        try
        {
            t.begin();
            em.merge(u);
            t.commit();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("EXCEPTION : " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Book> findAll()
    {
        List<Book> resultat = new LinkedList();
        try
        {
            Query qFindAll = em.createNamedQuery("Book.findAll");
            resultat = qFindAll.getResultList();
            return resultat;
        }
        catch (Exception exp)
        {
            System.out.println("EXCEPTION :" + exp.getMessage());
            return resultat;
        }
    }
}
