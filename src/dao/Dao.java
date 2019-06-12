package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import modelo.CadastroCurso;
import modelo.CadastroEstudante;
import modelo.LoginSenha;

public class Dao {
	
	/**
	 * Registra um formulário no banco de dados
	 * @param form Modelo do formulário a ser registrado
	 */
	
	public void registrarFormulario (CadastroEstudante form) {
		
		Connection con = ConexaoMySQL.getConexao();
		
		String sqlInsert = "INSERT INTO formularios VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement prep = con.prepareStatement(sqlInsert);
			
			prep.setString(1, form.getNomeCoord());
			prep.setInt(2, form.getCursoCoord());
			prep.setString(3, form.getRgCoord());
			prep.setString(4, form.getCpfCoord());
			prep.setString(5, form.getCargoResp());
			prep.setString(6, form.getNomeResp());
			prep.setString(7, form.getRgResp());
			prep.setString(8, form.getCpfResp());
			prep.setString(9, form.getNomeEstudante());
			prep.setString(10, form.getDataNascEstudante());
			prep.setString(11, form.getCpfEstudante());
			prep.setString(12, form.getRgEstudante());
			prep.setString(13, form.getLogradEstudante());
			prep.setString(14, form.getEnderecoEtudante());
			prep.setString(15, form.getComplemEstudante());
			prep.setString(16, form.getBairroEstudante());
			prep.setString(17, form.getCepEstudante());
			prep.setString(18, form.getCidadeEstudante());
			prep.setString(19, form.getUfEstudante());
			prep.setInt(20, form.getCursoEstudante());
			prep.setString(21, form.getMatricEstudante());
			prep.setInt(22, form.getSemestEstudante());
			prep.setString(23, form.getAreaAtuacaoEstagio());
			prep.setString(24, form.getDuracaoEstagio());
			prep.setString(25, form.getDataInicialEstagio());
			prep.setString(26, form.getDataFinalEstagio());
			prep.setString(27, form.getCargaHorariaEstagio());
			prep.setString(28, form.getNumApoliceSeguroEstagio());
			prep.setString(29, form.getSeguradoraEstagio());
			prep.setString(30, form.getSupervEstagio());
			prep.setString(31, form.getNumSiapeEstagio());
			prep.setString(32, form.getOrientadorEstagio());
			prep.setString(33, form.getCargoSupervEstagio());
			prep.setString(34, form.getAtividadesEstagio());
			prep.setString(35, form.getDataPreenchimento());
			
			prep.executeUpdate();
			System.out.println("Cadastro efetuado");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Exclui do banco de dados o formulário de um aluno
	 * @param cpfAluno CPF do aluno
	 * @return Caso seja possível excluir, retorna true. Caso contrário, retorna false.
	 */
	
	public boolean excluirFormulario(String cpfAluno) {
		
		Connection con = ConexaoMySQL.getConexao();
		
		String sql = "DELETE FROM formularios WHERE cpfEstudanteFormulario LIKE ?";
		
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			
			prep.setString(1, cpfAluno);
			
			prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Verifica se existe um formulário já cadastrado no banco de dados para o aluno
	 * @param cpfAluno String com o cpf do aluno a ser buscado
	 * @return Caso exista, retorna o modelo do formulário
	 */
	
	public CadastroEstudante consultarFormulario (String cpfAluno) {
		
		CadastroEstudante form = new CadastroEstudante();
		
		Connection con = ConexaoMySQL.getConexao();
		
		String sql = "SELECT * FROM formularios WHERE cpfEstudanteFormulario LIKE ?";
		
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			
			prep.setString(1, cpfAluno);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				
				form.setNomeCoord(rs.getString(2));
				form.setCursoCoord(rs.getInt(3));
				form.setRgCoord(rs.getString(4));
				form.setCpfCoord(rs.getString(5));
				form.setCargoResp(rs.getString(6));
				form.setNomeResp(rs.getString(7));
				form.setRgResp(rs.getString(8));
				form.setCpfResp(rs.getString(9));
				form.setNomeEstudante(rs.getString(10));
				form.setDataNascEstudante(rs.getString(11));
				form.setCpfEstudante(rs.getString(12));
				form.setRgEstudante(rs.getString(13));
				form.setLogradEstudante(rs.getString(14));
				form.setEnderecoEtudante(rs.getString(15));
				form.setComplemEstudante(rs.getString(16));
				form.setBairroEstudante(rs.getString(17));
				form.setCepEstudante(rs.getString(18));
				form.setCidadeEstudante(rs.getString(19));
				form.setUfEstudante(rs.getString(20));
				form.setCursoEstudante(rs.getInt(21));
				form.setMatricEstudante(rs.getString(22));
				form.setSemestEstudante(rs.getInt(23));
				form.setAreaAtuacaoEstagio(rs.getString(24));
				form.setDuracaoEstagio(rs.getString(25));
				form.setDataInicialEstagio(rs.getString(26));
				form.setDataFinalEstagio(rs.getString(27));
				form.setCargaHorariaEstagio(rs.getString(28));
				form.setNumApoliceSeguroEstagio(rs.getString(29));
				form.setSeguradoraEstagio(rs.getString(30));
				form.setSupervEstagio(rs.getString(31));
				form.setNumSiapeEstagio(rs.getString(32));
				form.setOrientadorEstagio(rs.getString(33));
				form.setCargoSupervEstagio(rs.getString(34));
				form.setAtividadesEstagio(rs.getString(35));
				form.setDataPreenchimento(rs.getString(36));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return form;
	}
	
	/**
	 * Retorna uma lista com todos os cursos cadastrados no banco de dados
	 * @return LinkedList com os cursos cadastrados
	 */
	
	public LinkedList<String> retornarTodosCursos() {
		LinkedList<String> cursos = new LinkedList<>();
		
		Connection con =  ConexaoMySQL.getConexao();
		
		String sql = "SELECT nomeCurso FROM cursos";
		
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()) {
				cursos.add(rs.getString(1));
			}
			
			return cursos;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cursos;
	}
	
	/** 
	 * Cadastra um curso no banco de dados
	 * @param curso Modelo a ser adicionado no banco 
	 */
	
	public void cadastraCurso(CadastroCurso curso) {
		
		Connection con =  ConexaoMySQL.getConexao();
		
		String sql = "INSERT INTO cursos VALUES (null,?,?)";
		
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			prep.setString(1, curso.getNomeCurso());
			prep.setString(2, curso.getObservCurso());
			
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Verifica se o usuario está cadastrado no banco e se a senha está correta 
	 * @param usuario Modelo de LoginSenha com os dados do usuario
	 * @return Retorna true se existe um usuario com as informações inseridas. Caso contrário, retorna false.
	 */
	
	public boolean validarLogin(LoginSenha usuario) {
		
		Connection con = ConexaoMySQL.getConexao();
		
		String sql = "SELECT loginUsuario FROM usuarios WHERE loginUsuario = ? AND senhaUsuario = ?";
		
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			
			prep.setString(1, usuario.getLogin());
			prep.setString(2, usuario.getSenha());
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				if(rs.getString(1)==null) {
					return false;
				}else {
					return true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
		
	}
	
	public boolean atualizar() {
		return true;
	}
}
