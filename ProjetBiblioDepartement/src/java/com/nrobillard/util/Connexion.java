package com.nrobillard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import org.springframework.web.context.ServletContextAware;

public class Connexion  implements ServletContextAware{
    private Connection connection;
    private ServletContext servletContext;
   
    public Connection getInstance(){
        if (connection==null) {
            String pilote = servletContext.getInitParameter("pilote");
            String url = servletContext.getInitParameter("urlBd");
            String user = servletContext.getInitParameter("userBd");
            String password = servletContext.getInitParameter("passBd");
            try 
            {
                Class.forName(pilote);
                connection = DriverManager.getConnection(url,user,password);
            }
            catch (ClassNotFoundException | SQLException exp) 
            {
                exp.printStackTrace();
            }
        }
        return connection;
    }
    @Override
    public void setServletContext(ServletContext sc) {
        this.servletContext = sc;
    }
}
