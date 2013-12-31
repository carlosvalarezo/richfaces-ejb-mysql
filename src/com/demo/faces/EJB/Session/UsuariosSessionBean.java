package com.demo.faces.EJB.Session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.demo.faces.EJB.Entity.*;
import com.demo.faces.EJB.Session.*;

/*
 * Session Bean implementation class UsuariosSessionBean
 */
@Stateless
@LocalBean
public class UsuariosSessionBean {
	@PersistenceContext
	private EntityManager em;
	private List<Usuario> usuariosRecuperados = new ArrayList<Usuario>();

	
	public void GuardarUsuario(Usuario usuario)
	{		
		try{
			
				System.out.println("DESDE SESSION");
				int idLocal = usuario.getIdUsuarios();
				String nombreLocal = usuario.getLoginUsuarios();
				String passwordLocal = usuario.getPasswordUsuarios();
				System.out.println(idLocal + " " + nombreLocal + " " + passwordLocal);				
				em.persist(usuario);			
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public List<Usuario> ObtenerUsuariosRecuperados()
	{
		
		usuariosRecuperados = (List<Usuario>)em.createQuery("FROM Usuario").getResultList();		
			
		return usuariosRecuperados;
		
	}
	
    /**
     * Default constructor. 
     */
    public UsuariosSessionBean() {
        // TODO Auto-generated constructor stub
    }
	public List<Usuario> getUsuariosRecuperados() {
		return usuariosRecuperados;
	}

}
