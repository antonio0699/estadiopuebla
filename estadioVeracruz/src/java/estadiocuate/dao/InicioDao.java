/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estadiocuate.dao;

import estadiocuate.bd.ConectionDb;
import estadiocuate.bean.InicioBean;
import estadiocuate.bean.loginBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ejemplo
 */
public class InicioDao {
    
    private Connection conec = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    
   public List<InicioBean> buscaEstado(){
       List<InicioBean> inicio = new ArrayList<>();
       List<InicioBean> submenu = new ArrayList<>();

       
       
       InicioBean i1 = new InicioBean();
       i1.setIdMenu(1);
       i1.setMenu("Menu 1");
       InicioBean i11 = new InicioBean();
       i11.setIdMenu(1);
       i11.setMenu("Menu 11");
       submenu.add(i11);
       InicioBean i111 = new InicioBean();
       i111.setIdMenu(2);
       i111.setMenu("Menu 22");
       submenu.add(i111);
       
       
   
       i1.setSubmenus(submenu);

       inicio.add(i1);
       
       InicioBean i2 = new InicioBean();
       i2.setIdMenu(2);
       i2.setMenu("Menu 2");


       inicio.add(i2);
       
       InicioBean i3 = new InicioBean();
       i3.setIdMenu(3);
       i3.setMenu("Menu 3");


       inicio.add(i3);
       
       
       
       return  inicio;
   }
   public List<InicioBean> buscaMenu(loginBean log){
       List<InicioBean> busca = new ArrayList<>();
        ConectionDb c = new ConectionDb();
       conec = c.conectar();
       
       StringBuilder sql = new StringBuilder();
       
       sql.append(" select em.id_menu,em.menu ");
       sql.append(" from ta_estadios_roles er ");
       sql.append(" join ta_estadio_menu em on er.id_rol = em.id_rol ");
       sql.append(" where er.id_rol = ? and er.activo = 1 ");
       
        try {
            preparedStatement = conec.prepareCall(sql.toString());
            preparedStatement.setInt(1, log.getIdRol());

            result = preparedStatement.executeQuery();
            
            while(result.next()){
                InicioBean in = new InicioBean();
                in.setIdMenu(result.getInt(1));
                in.setMenu(result.getString(2));
                System.out.println("--> "+ result.getInt(1));
                busca.add(in);
            }
         return busca;
        } catch (SQLException ex) {
            Logger.getLogger(InicioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           try {
               if(result != null)
                    result.close();
               if(conec != null)
                    conec.close();
           } catch (SQLException ex) {
               Logger.getLogger(InicioDao.class.getName()).log(Level.SEVERE, null, ex);
           } 
        }
        
       
       
       return null;
   }
   
   public List<InicioBean> buscaSubmenu(int idmenu){
       List<InicioBean> busca = new ArrayList<>();
              ConectionDb c = new ConectionDb();
       conec = c.conectar();
       StringBuilder sql = new StringBuilder();
       
       sql.append(" select em.id_menu,es.submenu,es.url_pantall  ");
       sql.append(" from ta_estadios_roles er ");
       sql.append(" join ta_estadio_menu em on er.id_rol = em.id_rol ");
       sql.append(" join ta_estadio_submenu es on em.id_menu = es.id_menu ");
       sql.append(" where es.id_menu = ? and er.activo = 1 ");
       
        try {
            preparedStatement = conec.prepareCall(sql.toString());
            preparedStatement.setInt(1, idmenu);

            result = preparedStatement.executeQuery();
            
            while(result.next()){
                
                InicioBean in = new InicioBean();
                in.setIdMenu(result.getInt(1));
                in.setMenu(result.getString(2));
                in.setPantalla(result.getString(3));
       
                busca.add(in);
            }
            
            System.out.println("tamaño "+ busca.size());
         return busca;
        } catch (SQLException ex) {
            Logger.getLogger(InicioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
               if(result != null)
                    result.close();
               if(conec != null)
                    conec.close();
           } catch (SQLException ex) {
               Logger.getLogger(InicioDao.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       
       
       return null;
   }
   
   public loginBean validaUsuariBean(loginBean bean){
       loginBean datos = new loginBean();
       ConectionDb c = new ConectionDb();
       conec = c.conectar();
       
       String sql = "select id_rol from ta_estadio_usuarios where usuario = ? and password = ?";
       
        try {
            preparedStatement = conec.prepareCall(sql);
            preparedStatement.setString(1, bean.getUsuario());
            preparedStatement.setString(2, bean.getPassword());
            result = preparedStatement.executeQuery();
            
            if(result.next()){
                datos.setIdRol(result.getInt(1));
            }
         return datos;
        } catch (SQLException ex) {
            Logger.getLogger(InicioDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           try {
               if(result != null)
                    result.close();
               if(conec != null)
                    conec.close();
           } catch (SQLException ex) {
               Logger.getLogger(InicioDao.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       
       
       
       return  null;
   }
   
    
}
