/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadiocuate.controller;

import estadiocuate.bean.InicioBean;
import estadiocuate.bean.loginBean;
import estadiocuate.dao.InicioDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ejemplo
 */
@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController implements  Serializable{
    
    private loginBean login = new loginBean();
    private List<InicioBean> inicio = new ArrayList<>();
    
    
    @PostConstruct
    public void init(){
      
    }
    
    public boolean validaUsuario(loginBean log){
        InicioDao inc = new InicioDao();
        
        login = inc.validaUsuariBean(log);
        if(login != null){
            System.out.println("Usuario logeado de forma éxitosa");
            inicio = inc.buscaMenu(login);
            for(InicioBean inic : inicio){
                List<InicioBean> sub = new ArrayList<>();
                sub = inc.buscaSubmenu(inic.getIdMenu());
                if(sub != null) 
                inic.setSubmenus(sub);
                
            }
            return true;
        }
        return false;
    }
    public String inisiaSesion(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Entro en el login");
        
        if(validaUsuario(getLogin())){
           return "pages/inicio.puebla";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Usuario incorrect "));
            return "login.puebla";
        }    
    }

    public loginBean getLogin() {
        return login;
    }
    public void setLogin(loginBean login) {
        this.login = login;
    }    

    /**
     * @return the inicio
     */
    public List<InicioBean> getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(List<InicioBean> inicio) {
        this.inicio = inicio;
    }
    
}
