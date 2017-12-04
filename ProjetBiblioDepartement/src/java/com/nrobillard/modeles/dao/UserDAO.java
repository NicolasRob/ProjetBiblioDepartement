/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrobillard.modeles.dao;

import com.nrobillard.modeles.classes.User;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Vengor
 */
public class UserDAO extends DAO<User>
{

    public UserDAO()
    {

    }

    @Override
    public boolean create(User x)
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
    public boolean delete(User x)
    {
        try
        {
            User u = em.find(User.class, x.getCourriel());
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
    public User read(int id)
    {
        return this.read("" + id);
    }

    @Override
    public User read(String id)
    {
        List<User> resultat = new LinkedList();
        try
        {
            Query qFindId = em.createNamedQuery("User.findByCourriel");
            qFindId.setParameter("courriel", id);
            resultat = qFindId.getResultList();
            return (resultat.isEmpty()) ? null : resultat.get(0);
        }
        catch (Exception exp)
        {
            System.out.println("Erreur :" + exp.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(User u)
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
    public List<User> findAll()
    {
        List<User> resultat = new LinkedList();
        try
        {
            Query qFindAll = em.createNamedQuery("User.findAll");
            resultat = qFindAll.getResultList();
            return resultat;
        }
        catch (Exception exp)
        {
            System.out.println("Erreur :" + exp.getMessage());
            return resultat;
        }
    }
}
