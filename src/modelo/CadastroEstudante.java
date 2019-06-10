package modelo;

import java.sql.Date;

public class CadastroEstudante {
	
	private String cpfEstudante;
	private String nomeEstudante;
	private String rgEstudante;
	private String enderecoEtudante;
	private String bairroEstudante;
	private String cidadeEstudante;
	private int cursoEstudante; //JComboBox
	private int semestEstudante; //JComboBox
	private Date dataNascEstudante; 
	private String complemEstudante;
	private String cepEstudante;
	private String ufEstudante; //JComboBox
	private String matricEstudante;
	
	private String nomeCoord;
	private String cpfCoord;
	private String rgCoord;
	private int cursoCoord; //JComboBox
	
	private String nomeResp;
	private String cpfResp;
	private String rgResp;
	private String cargoResp;
	
	private String areaAtuacaoEstagio;
	private Date dataInicialEstagio;
	private String cargaHorariaEstagio;
	private String numApoliceSeguroEstagio;
	private String duracaoEstagio;
	private Date dataFinalEstagio;
	private String seguradoraEstagio;
	private String numSiapeEstagio;
	private String cargoSupervEstagio;
	private String atividadesEstagio;
	
	private Date dataPreenchimento;
	
	//PanelLogin
	private String usuarioLogin;
	private String senhaLogin;
	
	public CadastroEstudante() {}
	
	public CadastroEstudante(String cpfEstudante, String nomeEstudante, String rgEstudante, String enderecoEtudante,
			String bairroEstudante, String cidadeEstudante, int cursoEstudante, int semestEstudante,
			Date dataNascEstudante, String complemEstudante, String cepEstudante, String ufEstudante,
			String matricEstudante, String nomeCoord, String cpfCoord, String rgCoord, int cursoCoord, String nomeResp,
			String cpfResp, String rgResp, String cargoResp, String areaAtuacaoEstagio, Date dataInicialEstagio,
			String cargaHorariaEstagio, String numApoliceSeguroEstagio, String duracaoEstagio, Date dataFinalEstagio,
			String seguradoraEstagio, String numSiapeEstagio, String cargoSupervEstagio, String atividadesEstagio,
			Date dataPreenchimento, String usuarioLogin, String senhaLogin) {
		super();
		this.cpfEstudante = cpfEstudante;
		this.nomeEstudante = nomeEstudante;
		this.rgEstudante = rgEstudante;
		this.enderecoEtudante = enderecoEtudante;
		this.bairroEstudante = bairroEstudante;
		this.cidadeEstudante = cidadeEstudante;
		this.cursoEstudante = cursoEstudante;
		this.semestEstudante = semestEstudante;
		this.dataNascEstudante = dataNascEstudante;
		this.complemEstudante = complemEstudante;
		this.cepEstudante = cepEstudante;
		this.ufEstudante = ufEstudante;
		this.matricEstudante = matricEstudante;
		this.nomeCoord = nomeCoord;
		this.cpfCoord = cpfCoord;
		this.rgCoord = rgCoord;
		this.cursoCoord = cursoCoord;
		this.nomeResp = nomeResp;
		this.cpfResp = cpfResp;
		this.rgResp = rgResp;
		this.cargoResp = cargoResp;
		this.areaAtuacaoEstagio = areaAtuacaoEstagio;
		this.dataInicialEstagio = dataInicialEstagio;
		this.cargaHorariaEstagio = cargaHorariaEstagio;
		this.numApoliceSeguroEstagio = numApoliceSeguroEstagio;
		this.duracaoEstagio = duracaoEstagio;
		this.dataFinalEstagio = dataFinalEstagio;
		this.seguradoraEstagio = seguradoraEstagio;
		this.numSiapeEstagio = numSiapeEstagio;
		this.cargoSupervEstagio = cargoSupervEstagio;
		this.atividadesEstagio = atividadesEstagio;
		this.dataPreenchimento = dataPreenchimento;
		this.usuarioLogin = usuarioLogin;
		this.senhaLogin = senhaLogin;
	}
	public String getCpfEstudante() {
		return cpfEstudante;
	}
	public void setCpfEstudante(String cpfEstudante) {
		this.cpfEstudante = cpfEstudante;
	}
	public String getNomeEstudante() {
		return nomeEstudante;
	}
	public void setNomeEstudante(String nomeEstudante) {
		this.nomeEstudante = nomeEstudante;
	}
	public String getRgEstudante() {
		return rgEstudante;
	}
	public void setRgEstudante(String rgEstudante) {
		this.rgEstudante = rgEstudante;
	}
	public String getEnderecoEtudante() {
		return enderecoEtudante;
	}
	public void setEnderecoEtudante(String enderecoEtudante) {
		this.enderecoEtudante = enderecoEtudante;
	}
	public String getBairroEstudante() {
		return bairroEstudante;
	}
	public void setBairroEstudante(String bairroEstudante) {
		this.bairroEstudante = bairroEstudante;
	}
	public String getCidadeEstudante() {
		return cidadeEstudante;
	}
	public void setCidadeEstudante(String cidadeEstudante) {
		this.cidadeEstudante = cidadeEstudante;
	}
	public int getCursoEstudante() {
		return cursoEstudante;
	}
	public void setCursoEstudante(int cursoEstudante) {
		this.cursoEstudante = cursoEstudante;
	}
	public int getSemestEstudante() {
		return semestEstudante;
	}
	public void setSemestEstudante(int semestEstudante) {
		this.semestEstudante = semestEstudante;
	}
	public Date getDataNascEstudante() {
		return dataNascEstudante;
	}
	public void setDataNascEstudante(Date dataNascEstudante) {
		this.dataNascEstudante = dataNascEstudante;
	}
	public String getComplemEstudante() {
		return complemEstudante;
	}
	public void setComplemEstudante(String complemEstudante) {
		this.complemEstudante = complemEstudante;
	}
	public String getCepEstudante() {
		return cepEstudante;
	}
	public void setCepEstudante(String cepEstudante) {
		this.cepEstudante = cepEstudante;
	}
	public String getUfEstudante() {
		return ufEstudante;
	}
	public void setUfEstudante(String ufEstudante) {
		this.ufEstudante = ufEstudante;
	}
	public String getMatricEstudante() {
		return matricEstudante;
	}
	public void setMatricEstudante(String matricEstudante) {
		this.matricEstudante = matricEstudante;
	}
	public String getNomeCoord() {
		return nomeCoord;
	}
	public void setNomeCoord(String nomeCoord) {
		this.nomeCoord = nomeCoord;
	}
	public String getCpfCoord() {
		return cpfCoord;
	}
	public void setCpfCoord(String cpfCoord) {
		this.cpfCoord = cpfCoord;
	}
	public String getRgCoord() {
		return rgCoord;
	}
	public void setRgCoord(String rgCoord) {
		this.rgCoord = rgCoord;
	}
	public int getCursoCoord() {
		return cursoCoord;
	}
	public void setCursoCoord(int cursoCoord) {
		this.cursoCoord = cursoCoord;
	}
	public String getNomeResp() {
		return nomeResp;
	}
	public void setNomeResp(String nomeResp) {
		this.nomeResp = nomeResp;
	}
	public String getCpfResp() {
		return cpfResp;
	}
	public void setCpfResp(String cpfResp) {
		this.cpfResp = cpfResp;
	}
	public String getRgResp() {
		return rgResp;
	}
	public void setRgResp(String rgResp) {
		this.rgResp = rgResp;
	}
	public String getCargoResp() {
		return cargoResp;
	}
	public void setCargoResp(String cargoResp) {
		this.cargoResp = cargoResp;
	}
	public String getAreaAtuacaoEstagio() {
		return areaAtuacaoEstagio;
	}
	public void setAreaAtuacaoEstagio(String areaAtuacaoEstagio) {
		this.areaAtuacaoEstagio = areaAtuacaoEstagio;
	}
	public Date getDataInicialEstagio() {
		return dataInicialEstagio;
	}
	public void setDataInicialEstagio(Date dataInicialEstagio) {
		this.dataInicialEstagio = dataInicialEstagio;
	}
	public String getCargaHorariaEstagio() {
		return cargaHorariaEstagio;
	}
	public void setCargaHorariaEstagio(String cargaHorariaEstagio) {
		this.cargaHorariaEstagio = cargaHorariaEstagio;
	}
	public String getNumApoliceSeguroEstagio() {
		return numApoliceSeguroEstagio;
	}
	public void setNumApoliceSeguroEstagio(String numApoliceSeguroEstagio) {
		this.numApoliceSeguroEstagio = numApoliceSeguroEstagio;
	}
	public String getDuracaoEstagio() {
		return duracaoEstagio;
	}
	public void setDuracaoEstagio(String duracaoEstagio) {
		this.duracaoEstagio = duracaoEstagio;
	}
	public Date getDataFinalEstagio() {
		return dataFinalEstagio;
	}
	public void setDataFinalEstagio(Date dataFinalEstagio) {
		this.dataFinalEstagio = dataFinalEstagio;
	}
	public String getSeguradoraEstagio() {
		return seguradoraEstagio;
	}
	public void setSeguradoraEstagio(String seguradoraEstagio) {
		this.seguradoraEstagio = seguradoraEstagio;
	}
	public String getNumSiapeEstagio() {
		return numSiapeEstagio;
	}
	public void setNumSiapeEstagio(String numSiapeEstagio) {
		this.numSiapeEstagio = numSiapeEstagio;
	}
	public String getCargoSupervEstagio() {
		return cargoSupervEstagio;
	}
	public void setCargoSupervEstagio(String cargoSupervEstagio) {
		this.cargoSupervEstagio = cargoSupervEstagio;
	}
	public String getAtividadesEstagio() {
		return atividadesEstagio;
	}
	public void setAtividadesEstagio(String atividadesEstagio) {
		this.atividadesEstagio = atividadesEstagio;
	}
	public Date getDataPreenchimento() {
		return dataPreenchimento;
	}
	public void setDataPreenchimento(Date dataPreenchimento) {
		this.dataPreenchimento = dataPreenchimento;
	}
	public String getUsuarioLogin() {
		return usuarioLogin;
	}
	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}
	public String getSenhaLogin() {
		return senhaLogin;
	}
	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}
	
	
}

