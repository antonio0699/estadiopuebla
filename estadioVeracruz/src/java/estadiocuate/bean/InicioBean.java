/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadiocuate.bean;

import java.util.List;

/**
 *
 * @author ejemplo
 */
public class InicioBean {
    
    private int idMenu;
    private String menu;
    private String pantalla;
    private List<InicioBean> submenus;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public List<InicioBean> getSubmenus() {
        return submenus;
    }

    public void setSubmenus(List<InicioBean> submenus) {
        this.submenus = submenus;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }
    
    
    
    
}
