package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.CadastroEstudante;

public class Dao {
	
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
			prep.setDate(10, form.getDataNascEstudante());
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
			prep.setDate(25, form.getDataInicialEstagio());
			prep.setDate(26, form.getDataFinalEstagio());
			prep.setString(27, form.getCargaHorariaEstagio());
			prep.setString(28, form.getNumApoliceSeguroEstagio());
			prep.setString(29, form.getSeguradoraEstagio());
			prep.setString(30, form.getSupervEstagio());
			prep.setString(31, form.getNumSiapeEstagio());
			prep.setString(32, form.getOrientadorEstagio());
			prep.setString(33, form.getCargoSupervEstagio());
			prep.setString(34, form.getAtividadesEstagio());
			prep.setDate(35, form.getDataPreenchimento());
			
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
	
	public void excluirFormulario(String cpfAluno) {
		
		Connection con = ConexaoMySQL.getConexao();
		
		String sql = "DELETE FROM formularios WHERE cpfEstudanteFormulario LIKE ?";
		
		try {
			PreparedStatement prep = con.prepareStatement(sql);
			
			prep.setString(1, cpfAluno);
			
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

}
