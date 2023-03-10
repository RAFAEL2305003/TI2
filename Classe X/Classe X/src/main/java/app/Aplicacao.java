package app;

import dao.DAO;
import java.util.List;
import java.util.*;
import dao.UsuarioDAO;
import model.Usuario;

public class Aplicacao {
	public static Scanner sc = new Scanner(System.in);
	public static void inserir() {
		
		int codigo = 0;
		String login = "";
		String senha = "";
		char sexo = '*';
		
		UsuarioDAO newusuario = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		System.out.println("Insira seu codigo: ");
		codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Insira seu login: ");
		login = sc.nextLine();
		System.out.println("Insira sua senha: ");
		senha = sc.nextLine();
		System.out.println("Insira seu sexo: ");
		sexo = sc.next().charAt(0);
		
		usuario.setCodigo(codigo);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setSexo(sexo);
		
		newusuario.insert(usuario);
		newusuario.close();
		
	}
	public static void listar() {
		UsuarioDAO newusuario = new UsuarioDAO();
		
		List<Usuario> usuario = newusuario.get();
		
		for(int i = 0; i < usuario.size(); i++) {
			Usuario usuario1 = usuario.get(i);
			System.out.println(usuario1.toString());
		}
		newusuario.close();
		
	}
	public static void atualizar() {
		int codigo = 0;
		String login = "";
		String senha = "";
		char sexo = '*';
		
		Usuario usuario = new Usuario();
		UsuarioDAO newusuario = new UsuarioDAO();
		
		System.out.println("Digite o novo codigo: ");
		codigo = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o novo login: ");
		login = sc.nextLine();
		System.out.println("Digite a nova senha: ");
		senha = sc.nextLine();
		sexo = sc.next().charAt(0);
		
		usuario.setCodigo(codigo);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setSexo(sexo);
		
		newusuario.update(usuario);
		newusuario.close();
	}
	public static void apagar() {
		
		int codigo = 0;
		UsuarioDAO newusuario = new UsuarioDAO();
		System.out.println("Digite o codigo para apagar: ");
		codigo = sc.nextInt();
		
		newusuario.delete(codigo);
		newusuario.close();
		
	}
	public static void main(String[] args) throws Exception{
		
		DAO dao = new DAO();
		dao.conectar();
		
		int caso = 0;
		System.out.println("Opcoes: 1) Inserir, 2) Listar, 3) Atualizar, 4) Excluir, 5) Sair");
		caso = sc.nextInt();
		while(caso != 5) {
			if(caso == 1) {
				inserir();
			}
			else if(caso == 2) {
				listar();
			}
			else if(caso == 3) {
				atualizar();
			}
			else if(caso == 4) {
				apagar();
			}
			System.out.println("Opcoes: 1) Inserir, 2) Listar, 3) Atualizar, 4) Excluir, 5) Sair");
			caso = sc.nextInt();
	}
	}
	
}