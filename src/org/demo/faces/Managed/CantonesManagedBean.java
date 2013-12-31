package org.demo.faces.Managed;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.demo.faces.*;

import com.demo.faces.EJB.Entity.Usuario;
import com.demo.faces.EJB.Session.*;

@ManagedBean(name = "cantonesManagedBean")
@ViewScoped
public class CantonesManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Cantones> listaCantones = new ArrayList<Cantones>();
	private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	private List<UsuarioLocal> listaUsuarioLocal = new ArrayList<UsuarioLocal>();
	private String cantonSeleccionado;
	private Usuario usuario = new Usuario();
	private UsuariosSessionBean usuarioSessionBean = new UsuariosSessionBean();

	public CantonesManagedBean() {
		try {
			InitialContext ini = new InitialContext();
			usuarioSessionBean = (UsuariosSessionBean) ini
					.lookup("java:module/UsuariosSessionBean");
			llenarListaCantones();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCantonSeleccionado() {
		return cantonSeleccionado;
	}

	public void setCantonSeleccionado(String cantonSeleccionado) {
		this.cantonSeleccionado = cantonSeleccionado;
	}

	public void guardarDatos() {
		listaUsuarioLocal.clear();
		usuarioSessionBean.GuardarUsuario(usuario);
		listaUsuarios = usuarioSessionBean.ObtenerUsuariosRecuperados();
		combinarListas();
	}

	private void combinarListas() {
		int idCantonUsuarios = 0;
		int idCantonCantones = 0;
		String loginUsuarios = "";
		String cantonCantones = "";
		int sizeUsuarios = listaUsuarios.size();
		int sizeCantones = listaCantones.size();
		List<Usuario> listaTempUsuario = listaUsuarios;
		List<Cantones> listaTempCantones = listaCantones;
		System.out.println("Size Usuarios = " + sizeUsuarios);
		for (int i = 0; i < sizeUsuarios; i++) {
			idCantonUsuarios = listaTempUsuario.get(i).getCantonUsuarios();
			loginUsuarios = listaTempUsuario.get(i).getLoginUsuarios();
			System.out.println("POR AGREGAR = ANTES" + loginUsuarios);
			for (int j = 0; j < sizeCantones; j++) {
				idCantonCantones = Integer.parseInt(listaTempCantones.get(j)
						.getIdCanton());
				cantonCantones = listaTempCantones.get(j)
						.getDescripcionCanton();

				System.out.println("POR AGREGAR = " + loginUsuarios + " "
						+ cantonCantones);
				if (idCantonUsuarios == idCantonCantones) {
					listaUsuarioLocal.add(new UsuarioLocal(loginUsuarios,
							cantonCantones));
					System.out.println("AGREGADO = " + loginUsuarios + " "
							+ cantonCantones);
					j = sizeCantones + 1;
				}
			}
		}
		listaUsuarios.clear();
		
	}

	private void llenarListaCantones() {
		// listaCantones = new ArrayList<Cantones>();
		JSONParser parser = new JSONParser();
		JSONObject uno;
		Cantones cantones;

		try {

			int i = 0;
			JSONObject jsonObjecto = (JSONObject) parser.parse(new FileReader(
					"/home/faces-developer/developer/jsondemo.json"));
			JSONArray jsonArray = (JSONArray) jsonObjecto.get("cantones");
			System.out.println("tamaño -> " + jsonArray.size());
			Iterator iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				uno = new JSONObject((JSONObject) iterator.next());
				listaCantones.add(new Cantones(uno.get("idCanton").toString(),
						uno.get("descripcionCanton").toString()));
			}
			Iterator iterator1 = listaCantones.iterator();
			while (iterator1.hasNext()) {
				cantones = new Cantones((Cantones) iterator1.next());
				System.out.println("APARTE -> "
						+ cantones.getDescripcionCanton());
				i++;
			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public List<Cantones> getListaCantones() {

		return listaCantones;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<UsuarioLocal> getListaUsuarioLocal() {
		return listaUsuarioLocal;
	}

}// fin de la clase
