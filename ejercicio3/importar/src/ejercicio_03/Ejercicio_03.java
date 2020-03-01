/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_03;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Eric Ruiz Diaz
 */
public class Ejercicio_03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            
            Scanner leer1 = new Scanner(System.in);
            Scanner leer2 = new Scanner(System.in);
            
            System.out.println("Ingrese la columna");
            String nombreColumnaParam = leer1.next();
            
            System.out.println("Ingrese el valor");
            String valorParam = leer2.next();
            
            String consulta = "select * from potluck where "+ nombreColumnaParam +" = ? ";
            
            Connection conexion= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejercicio_03", "root","");
            PreparedStatement sentencia= conexion.prepareStatement(consulta);
            sentencia.setString(1, valorParam);
            ResultSet rs = sentencia.executeQuery();
            System.out.println("Los resultados son:");
            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("food"));
                System.out.println(rs.getString("confirmed"));
                System.out.println(rs.getDate("signup_date"));
            }
                
            
        }catch(Exception e){
            System.out.println("Hubo un error, uno de los parametros es incorrecto o no existe");
        }
      

    }
    
}
