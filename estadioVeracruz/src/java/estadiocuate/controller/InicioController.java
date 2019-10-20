/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadiocuate.controller;

import estadiocuate.bean.InicioBean;
import estadiocuate.dao.InicioDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ejemplo
 */
@ManagedBean(name = "inicioController")
@SessionScoped
public class InicioController {
    
  
    
    @PostConstruct
    public void init(){
        System.out.println("Entro");
        
    }

   

    
    
}
