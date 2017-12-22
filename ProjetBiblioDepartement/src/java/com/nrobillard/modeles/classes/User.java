/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrobillard.modeles.classes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vengor
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByCourriel", query = "SELECT u FROM User u WHERE u.courriel = :courriel")
    , @NamedQuery(name = "User.findByMdp", query = "SELECT u FROM User u WHERE u.mdp = :mdp")
})
public class User implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COURRIEL")
    private String courriel;
    @Column(name = "MDP")
    private String mdp;

    public User()
    {
    }

    public User(String courriel)
    {
        this.courriel = courriel;
    }

    public User(String courriel, String password) {
        this.courriel = courriel;
        this.mdp = password;
    }

    public String getCourriel()
    {
        return courriel;
    }

    public void setCourriel(String courriel)
    {
        this.courriel = courriel;
    }

    public String getMdp()
    {
        return mdp;
    }

    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (courriel != null ? courriel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User))
        {
            return false;
        }
        User other = (User) object;
        if ((this.courriel == null && other.courriel != null) || (this.courriel != null && !this.courriel.equals(other.courriel)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "com.robillard.modeles.User[ courriel=" + courriel + " ]";
    }
    
}
