package ar.com.educacionit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ar.com.educacionit.domain.Producto;

public class TestConexion {

	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			con = AdministradorDeConexiones.obtenerConexion();
			
			//sql
			Statement st = con.createStatement();
			
			//obtengo los resultados
			ResultSet rs = st.executeQuery("SELECT * FROM productos");
			
			Producto[] productos = new Producto[2];
			int i = 0;
			while(rs.next()) {
				Long id = rs.getLong(1);
				String titulo = rs.getString(2);
				Float precio = rs.getFloat(3);
				String codigo = rs.getString(4);
				Long tipoProductgo = rs.getLong(5);
				
				Producto producto = new Producto(titulo, id, precio, codigo);
				productos[i++] = producto;
				//agregar a una lista o vector!!!
			}
			
			
			//mostrarlos!
			for(Producto producto : productos) {
				//producto.detalle();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
		}

	}

}
