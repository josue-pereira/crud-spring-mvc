package br.com.pmi.projetoinicial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.pmi.projetoinicial.domain.Usuario;
import br.com.pmi.projetoinicial.util.ConexaoSqlServer;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private Connection conn = null;
	private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public UsuarioDaoImpl() {
		conn = ConexaoSqlServer.getConexao();

	}

	@Override
	public void salvar(Usuario usuario) {

		String sql = "INSERT INTO usuarios(nome, sobrenome, data_nascimento) VALUES(?, ?, ?)";

		PreparedStatement stmt = null;

		java.sql.Date dataSql = null;
		try {
			Date data = df.parse(usuario.getData_nascimento());
			dataSql = new java.sql.Date(data.getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setDate(3, dataSql);
			stmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void editar(Usuario usuario) {
		String sql = "UPDATE usuarios SET nome = ?, sobrenome = ?, data_nascimento = ? WHERE id = ?";

		PreparedStatement stmt = null;

		java.sql.Date dataSql = null;
		try {
			Date data = df.parse(usuario.getData_nascimento());
			dataSql = new java.sql.Date(data.getTime());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setDate(3, dataSql);
			stmt.setLong(4, usuario.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void excluir(Long id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";

		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Usuario getId(Long id) {
		Usuario usuario = new Usuario();

		String sql = "SELECT * FROM usuarios WHERE id = ?";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			rs.next();

			usuario.setId(rs.getLong("id"));
			usuario.setData_nascimento(rs.getString("data_nascimento"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSobrenome(rs.getString("sobrenome"));

		} catch (SQLException ex) {
			System.out.println(ex);
		}

		return usuario;
	}

	@Override
	public List<Usuario> getTodos() {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuarios";

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {

				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setData_nascimento(rs.getString("data_nascimento"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuarios.add(usuario);
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}

		return usuarios;
	}

}
