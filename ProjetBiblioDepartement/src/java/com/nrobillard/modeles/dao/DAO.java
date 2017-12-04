package com.nrobillard.modeles.dao;

import com.nrobillard.util.Connexion;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class DAO<T>
{
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction t;
    protected Connexion connexion;

    public DAO() 
    {
        //this.emf = Persistence.createEntityManagerFactory("ProjetBiblioDepartementPU");
    }

    public void setConnexion(Connexion connexion)
    {
        this.connexion = connexion;
    }

    public void setEmf(EntityManagerFactory emf)
    {
        this.emf = emf;
        this.em = emf.createEntityManager();
        this.t = em.getTransaction();
    }

    public abstract boolean create(T x);
    public abstract boolean delete(T x);
    public abstract boolean update(T x);
    public abstract T read(String x);
    public abstract T read(int x);
    public abstract List<T> findAll();
}
