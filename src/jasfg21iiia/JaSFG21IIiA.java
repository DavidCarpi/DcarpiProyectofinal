/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasfg21iiia;

import bd.conectar;
import ec.edu.intsuperior.controlador.acceso;

/**
 *
 * @author Usuario
 */
public class JaSFG21IIiA {

    public static void main(String[] args) {
        acceso acc=new acceso();
        conectar cn = new conectar();
          cn.getConexion();
        acc.show();
        
        
        
    }
    
}




