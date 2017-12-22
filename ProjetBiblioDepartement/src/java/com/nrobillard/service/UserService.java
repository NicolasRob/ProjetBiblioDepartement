package com.nrobillard.service;

import com.nrobillard.modeles.classes.User;
import com.nrobillard.modeles.dao.UserDAO;



public class UserService {
    
    private UserDAO dao;
    
    public void setDao (UserDAO dao){
        this.dao = dao;
    }
    
    //retourne true pour réussite et un false pour un échec
    public boolean inscription(User user){
        //vérifie si le user existe
        if(dao.read(user.getCourriel()) == null){
            return dao.create(user);
        }
        return false;
    }
    
    //retourne 0 pour un login réussi, 1 pour une erreur de compte
    // et 2 pur un mauvais mot de passe
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


