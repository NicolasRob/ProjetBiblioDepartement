/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrobillard.service;

import com.nrobillard.modeles.classes.User;
import com.nrobillard.modeles.dao.UserDAO;



public class UserService {
    
    private UserDAO dao;
    
    public void setDao (UserDAO dao){
        this.dao = dao;
    }
    
    //retourne un true pour réussite et un false pour un Ã©chec
    public boolean inscription(User user){
        //vérifie si le user existe
        if(dao.read(user.getCourriel()) == null){
            dao.create(user);
            return true; 
        }
        return false;
    }
    
    //retourne 0 pour un login rÃ©ussi, 1 pour une erreur de compte
    // et 2 pur un mauvais password
    public int login(User user){
        User user_from_database = dao.read(user.getCourriel());
        if(user_from_database != null){
            if(user.getMdp().equalsIgnoreCase(user_from_database.getMdp())){
                return 0;
            }
            return 2;
        }
        return 1;
    }
}


