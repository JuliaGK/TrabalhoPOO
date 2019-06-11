package visao;

import javax.swing.JPanel;
import java.awt.SystemColor;
import java.text.ParseException;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelNovoF extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField FieldNomeCoord;
	private MaskFormatter CPFCoord;
	private JTextField FieldNomeResp;
	private MaskFormatter CPFResp;
	private MaskFormatter RGCoord;
	private MaskFormatter RGResp;
	private JTextField FieldNomeEst;
	private JTextField FieldCargoResp;
	private MaskFormatter NascEst;
	private MaskFormatter CPFEst;
	private MaskFormatter RGEst;
	private JTextField FieldEndereco;
	private JTextField FieldComplemento;
	private JTextField FieldBairro;
	private MaskFormatter CEPEst;
	private JTextField FieldCidade;
	private MaskFormatter MatEst;
	private JTextField FieldAreaAtuacao;
	private JTextField FieldDuracaoEstag;
	private JTextField FieldCHSem;
	private JTextField FieldNApolSeg;
	private JTextField FieldSeguradora;
	private JTextField FieldProfResp;
	private JTextField FieldSIAPE;
	private JTextField FieldSupervidorEmpresa;
	private JTextField FieldCargoSupervEmpresa;
	private JTextArea textArea;
	private JButton btnLimpar;
	private JFormattedTextField FieldDataInicial;
	private JFormattedTextField FieldDataFinal;
	private JComboBox comboBoxSemestre;
	private JFormattedTextField FieldMatEst;
	private JComboBox<String> comboBoxCursoEst;
	private JComboBox comboBoxUF;
	private JFormattedTextField FieldCEP;
	private JFormattedTextField FieldCPFEst;
	private JFormattedTextField FieldRGEst;
	private JFormattedTextField FieldNascEst;
	private JFormattedTextField FieldCPFResp;
	private JFormattedTextField FieldRGResp;
	private JComboBox<String> comboBoxCursoCoord;
	private JFormattedTextField FieldCPFCoord;
	private JFormattedTextField FieldRGCoord;
	private JButton btnCadastrar;
	private JFormattedTextField FieldCPFBusca;
	private MaskFormatter dataIni;
	private MaskFormatter dataFinal;

	/**
	 * Create the panel.
	 */
	public PanelNovoF() {

		setBackground(SystemColor.inactiveCaption);
		setLayout(new MigLayout("", "[90.00,grow][320.00,grow][15.00][90.00,grow][263.00,grow]",
				"[5.00][][17.00][][][][][][][][][][][][][][][][][][][][][][][][][][][grow][100px][]"));

		JLabel lblNovoFormulrio = new JLabel("FORMUL\u00C1RIO DE TERMO DE COMPROMISSO DE EST\u00C1GIO");
		lblNovoFormulrio.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblNovoFormulrio, "cell 0 1 5 1,alignx center");

		JLabel lblDadosUniversidade = new JLabel("DADOS DA UNIVERSIDADE");
		lblDadosUniversidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblDadosUniversidade, "cell 0 3 5 1,alignx center");

		JLabel lblNomeCoordenador = new JLabel("Nome Coordenador(a)");
		lblNomeCoordenador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblNomeCoordenador, "flowx,cell 0 4");

		FieldNomeCoord = new JTextField();
		add(FieldNomeCoord, "cell 1 4,growx");
		FieldNomeCoord.setColumns(10);

		try {
			RGCoord = new MaskFormatter("##########");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			CPFCoord = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblRgCoordenadora = new JLabel("RG Coordenador(a)");
		lblRgCoordenadora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblRgCoordenadora, "flowx,cell 3 4");
		FieldRGCoord = new JFormattedTextField(RGCoord);
		add(FieldRGCoord, "cell 4 4,growx");

		JLabel lblCpfCoordenadora = new JLabel("CPF Coordenador(a)");
		lblCpfCoordenadora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCpfCoordenadora, "cell 0 5,alignx left");
		FieldCPFCoord = new JFormattedTextField(CPFCoord);
		add(FieldCPFCoord, "cell 1 5,growx");

		JLabel lblCursoCoord = new JLabel("Curso de Gradua\u00E7\u00E3o");
		lblCursoCoord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCursoCoord, "cell 3 5");

		comboBoxCursoCoord = new JComboBox<String>();
		add(comboBoxCursoCoord, "cell 4 5");

		JLabel lblDadosConcedente = new JLabel("DADOS DA UNIDADE CONCEDENTE DE EST\u00C1GIO");
		lblDadosConcedente.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblDadosConcedente, "cell 0 7 5 1,alignx center");

		JLabel lblResponsávelEmpresa = new JLabel("Nome Respons\u00E1vel");
		lblResponsávelEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblResponsávelEmpresa, "flowx,cell 0 8");

		FieldNomeResp = new JTextField();
		add(FieldNomeResp, "cell 1 8,growx");
		FieldNomeResp.setColumns(10);

		try {
			RGResp = new MaskFormatter("##########");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			CPFResp = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblRGResp = new JLabel("RG Respons\u00E1vel");
		lblRGResp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblRGResp, "cell 3 8");
		FieldRGResp = new JFormattedTextField(RGResp);
		add(FieldRGResp, "cell 4 8,growx");

		JLabel lblCPFResp = new JLabel("CPF Respons\u00E1vel");
		lblCPFResp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCPFResp, "cell 0 9,alignx left");
		FieldCPFResp = new JFormattedTextField(CPFResp);
		add(FieldCPFResp, "cell 1 9,growx");

		JLabel lblCargoResponsvel = new JLabel("Cargo Respons\u00E1vel");
		lblCargoResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCargoResponsvel, "flowx,cell 3 9");

		FieldCargoResp = new JTextField();
		add(FieldCargoResp, "cell 4 9,growx");
		FieldCargoResp.setColumns(10);

		JLabel lblDadosDoEstudante = new JLabel("DADOS DO ESTUDANTE");
		lblDadosDoEstudante.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblDadosDoEstudante, "cell 0 11 5 1,alignx center");

		JLabel lblNomeEstudante = new JLabel("Nome Estudante");
		lblNomeEstudante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblNomeEstudante, "cell 0 12,alignx left");

		try {
			NascEst = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FieldNomeEst = new JTextField();
		add(FieldNomeEst, "cell 1 12,growx");
		FieldNomeEst.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblDataDeNascimento, "cell 3 12,alignx left");
		FieldNascEst = new JFormattedTextField(NascEst);
		add(FieldNascEst, "cell 4 12,growx");

		JLabel lblRgEstudante = new JLabel("RG Estudante");
		lblRgEstudante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblRgEstudante, "cell 0 13");

		try {
			CPFEst = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			RGEst = new MaskFormatter("##########");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FieldRGEst = new JFormattedTextField(RGEst);
		add(FieldRGEst, "cell 1 13,growx");

		JLabel lblCpfEstudante = new JLabel("CPF Estudante");
		lblCpfEstudante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCpfEstudante, "cell 3 13,alignx left");
		FieldCPFEst = new JFormattedTextField(CPFEst);
		add(FieldCPFEst, "cell 4 13,growx");

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblEndereco, "cell 0 14");

		FieldEndereco = new JTextField();
		add(FieldEndereco, "cell 1 14,growx");
		FieldEndereco.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblComplemento, "cell 3 14");

		try {
			CEPEst = new MaskFormatter("#####-###");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FieldComplemento = new JTextField();
		add(FieldComplemento, "cell 4 14,growx");
		FieldComplemento.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblBairro, "flowx,cell 0 15,alignx left");

		FieldBairro = new JTextField();
		add(FieldBairro, "cell 1 15,growx");
		FieldBairro.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCep, "cell 3 15");
		FieldCEP = new JFormattedTextField(CEPEst);
		add(FieldCEP, "cell 4 15,growx");

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCidade, "cell 0 16");

		FieldCidade = new JTextField();
		add(FieldCidade, "cell 1 16,growx");
		FieldCidade.setColumns(10);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblUf, "cell 3 16");

		comboBoxUF = new JComboBox();
		add(comboBoxUF, "cell 4 16");
		comboBoxUF.addItem("Selecionar Opção");
		comboBoxUF.addItem("Acre");
		comboBoxUF.addItem("Amapá");
		comboBoxUF.addItem("Amazonas");
		comboBoxUF.addItem("Bahia");
		comboBoxUF.addItem("Ceará");
		comboBoxUF.addItem("Distrito Federal");
		comboBoxUF.addItem("Espírito Santo");
		comboBoxUF.addItem("Goiás");
		comboBoxUF.addItem("Maranhão");
		comboBoxUF.addItem("Mato Grosso");
		comboBoxUF.addItem("Mato Grosso do Sul");
		comboBoxUF.addItem("Minas Gerais");
		comboBoxUF.addItem("Pará");
		comboBoxUF.addItem("Paraíba");
		comboBoxUF.addItem("Paraná");
		comboBoxUF.addItem("Pernambuco");
		comboBoxUF.addItem("Piauí");
		comboBoxUF.addItem("Rio de Janeiro");
		comboBoxUF.addItem("Rio Grande do Norte");
		comboBoxUF.addItem("Rio Grande do Sul");
		comboBoxUF.addItem("Rondônia");
		comboBoxUF.addItem("Roraima");
		comboBoxUF.addItem("Santa Catarina");
		comboBoxUF.addItem("São Paulo");
		comboBoxUF.addItem("Sergipe");
		comboBoxUF.addItem("Tocantins");

		JLabel lblCursoEst = new JLabel("Curso");
		lblCursoEst.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCursoEst, "cell 0 17");

		try {
			MatEst = new MaskFormatter("###########");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		comboBoxCursoEst = new JComboBox<String>();
		add(comboBoxCursoEst, "cell 1 17");

		JLabel lblMatricula = new JLabel("Matr\u00EDcula Estudante");
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblMatricula, "cell 3 17");
		FieldMatEst = new JFormattedTextField(MatEst);
		add(FieldMatEst, "cell 4 17,growx");

		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblSemestre, "cell 0 18");

		comboBoxSemestre = new JComboBox();
		add(comboBoxSemestre, "cell 1 18");
		comboBoxSemestre.addItem("Selecionar Opção");
		comboBoxSemestre.addItem("1");
		comboBoxSemestre.addItem("2");
		comboBoxSemestre.addItem("3");
		comboBoxSemestre.addItem("4");
		comboBoxSemestre.addItem("5");
		comboBoxSemestre.addItem("6");
		comboBoxSemestre.addItem("7");
		comboBoxSemestre.addItem("8");
		comboBoxSemestre.addItem("9");
		comboBoxSemestre.addItem("10");
		comboBoxSemestre.addItem("11");
		comboBoxSemestre.addItem("12");

		JLabel lblDadosDoEstgio = new JLabel("DADOS DO EST\u00C1GIO");
		lblDadosDoEstgio.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblDadosDoEstgio, "cell 0 20 5 1,alignx center");

		JLabel lblAreaDoEstgio = new JLabel("\u00C1rea de Atua\u00E7\u00E3o");
		lblAreaDoEstgio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblAreaDoEstgio, "cell 0 21");

		FieldAreaAtuacao = new JTextField();
		add(FieldAreaAtuacao, "cell 1 21,growx");
		FieldAreaAtuacao.setColumns(10);

		JLabel lblDuracao = new JLabel("Dura\u00E7\u00E3o ");
		lblDuracao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblDuracao, "cell 3 21");

		FieldDuracaoEstag = new JTextField();
		add(FieldDuracaoEstag, "cell 4 21,growx");
		FieldDuracaoEstag.setColumns(10);

		JLabel lblDataInicial = new JLabel("Data Inicial");
		lblDataInicial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblDataInicial, "cell 0 22");
		try {
			dataIni = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FieldDataInicial = new JFormattedTextField(dataIni);
		add(FieldDataInicial, "cell 1 22,growx");

		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblDataFinal, "cell 3 22");
		try {
			dataFinal = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FieldDataFinal = new JFormattedTextField(dataFinal);
		add(FieldDataFinal, "cell 4 22,growx");

		JLabel lblCargaHorriaSemanal = new JLabel("Carga Hor\u00E1ria Semanal");
		lblCargaHorriaSemanal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCargaHorriaSemanal, "cell 0 23");

		FieldCHSem = new JTextField();
		add(FieldCHSem, "cell 1 23,growx");
		FieldCHSem.setColumns(10);

		JLabel lblNApliceDo = new JLabel("N\u00BA Ap\u00F3lice do Seguro");
		lblNApliceDo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblNApliceDo, "cell 0 24");

		FieldNApolSeg = new JTextField();
		add(FieldNApolSeg, "cell 1 24,growx");
		FieldNApolSeg.setColumns(10);

		JLabel lblSeguradora = new JLabel("Seguradora");
		lblSeguradora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblSeguradora, "cell 3 24");

		FieldSeguradora = new JTextField();
		add(FieldSeguradora, "cell 4 24,growx");
		FieldSeguradora.setColumns(10);

		JLabel lblProfessoraResponsvel = new JLabel("Professor(a) Respons\u00E1vel");
		lblProfessoraResponsvel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblProfessoraResponsvel, "cell 0 26");

		FieldProfResp = new JTextField();
		add(FieldProfResp, "cell 1 26,growx");
		FieldProfResp.setColumns(10);

		JLabel lblNSiape = new JLabel("N\u00BA SIAPE");
		add(lblNSiape, "cell 3 26");

		FieldSIAPE = new JTextField();
		add(FieldSIAPE, "cell 4 26,growx");
		FieldSIAPE.setColumns(10);

		JLabel lblSupervidorResponsvelempresa = new JLabel("Supervisor(a) (empresa)");
		lblSupervidorResponsvelempresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblSupervidorResponsvelempresa, "cell 0 27");

		FieldSupervidorEmpresa = new JTextField();
		add(FieldSupervidorEmpresa, "cell 1 27,growx");
		FieldSupervidorEmpresa.setColumns(10);

		JLabel lblCargoDoSupervidor = new JLabel("Cargo do(a) Supervidor(a)");
		lblCargoDoSupervidor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblCargoDoSupervidor, "cell 3 27");

		FieldCargoSupervEmpresa = new JTextField();
		add(FieldCargoSupervEmpresa, "cell 4 27,growx");
		FieldCargoSupervEmpresa.setColumns(10);

		JLabel lblAtividadesDesenvolvidasPelo = new JLabel("Atividades desenvolvidas pelo estagi\u00E1rio");
		lblAtividadesDesenvolvidasPelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblAtividadesDesenvolvidasPelo, "cell 0 28 2 1");

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 0 29 5 2,grow");

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(PanelNovoF.class.getResource("/imagens/plus (1).png")));
		add(btnCadastrar, "flowx,cell 1 31,alignx center");

		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(PanelNovoF.class.getResource("/imagens/close-button.png")));
		add(btnLimpar, "cell 1 31,alignx center");

	}

	public JTextField getFieldNomeCoord() {
		return FieldNomeCoord;
	}

	public void setFieldNomeCoord(JTextField fieldNomeCoord) {
		FieldNomeCoord = fieldNomeCoord;
	}

	public MaskFormatter getCPFCoord() {
		return CPFCoord;
	}

	public void setCPFCoord(MaskFormatter cPFCoord) {
		CPFCoord = cPFCoord;
	}

	public JTextField getFieldNomeResp() {
		return FieldNomeResp;
	}

	public void setFieldNomeResp(JTextField fieldNomeResp) {
		FieldNomeResp = fieldNomeResp;
	}

	public MaskFormatter getCPFResp() {
		return CPFResp;
	}

	public void setCPFResp(MaskFormatter cPFResp) {
		CPFResp = cPFResp;
	}

	public MaskFormatter getRGCoord() {
		return RGCoord;
	}

	public void setRGCoord(MaskFormatter rGCoord) {
		RGCoord = rGCoord;
	}

	public MaskFormatter getRGResp() {
		return RGResp;
	}

	public void setRGResp(MaskFormatter rGResp) {
		RGResp = rGResp;
	}

	public JTextField getFieldNomeEst() {
		return FieldNomeEst;
	}

	public void setFieldNomeEst(JTextField fieldNomeEst) {
		FieldNomeEst = fieldNomeEst;
	}

	public JTextField getFieldCargoResp() {
		return FieldCargoResp;
	}

	public void setFieldCargoResp(JTextField fieldCargoResp) {
		FieldCargoResp = fieldCargoResp;
	}

	public MaskFormatter getNascEst() {
		return NascEst;
	}

	public void setNascEst(MaskFormatter nascEst) {
		NascEst = nascEst;
	}

	public MaskFormatter getCPFEst() {
		return CPFEst;
	}

	public void setCPFEst(MaskFormatter cPFEst) {
		CPFEst = cPFEst;
	}

	public MaskFormatter getRGEst() {
		return RGEst;
	}

	public void setRGEst(MaskFormatter rGEst) {
		RGEst = rGEst;
	}

	public JTextField getFieldEndereco() {
		return FieldEndereco;
	}

	public void setFieldEndereco(JTextField fieldEndereco) {
		FieldEndereco = fieldEndereco;
	}

	public JTextField getFieldComplemento() {
		return FieldComplemento;
	}

	public void setFieldComplemento(JTextField fieldComplemento) {
		FieldComplemento = fieldComplemento;
	}

	public JTextField getFieldBairro() {
		return FieldBairro;
	}

	public void setFieldBairro(JTextField fieldBairro) {
		FieldBairro = fieldBairro;
	}

	public MaskFormatter getCEPEst() {
		return CEPEst;
	}

	public void setCEPEst(MaskFormatter cEPEst) {
		CEPEst = cEPEst;
	}

	public JTextField getFieldCidade() {
		return FieldCidade;
	}

	public void setFieldCidade(JTextField fieldCidade) {
		FieldCidade = fieldCidade;
	}

	public MaskFormatter getMatEst() {
		return MatEst;
	}

	public void setMatEst(MaskFormatter matEst) {
		MatEst = matEst;
	}

	public JTextField getFieldAreaAtuacao() {
		return FieldAreaAtuacao;
	}

	public void setFieldAreaAtuacao(JTextField fieldAreaAtuacao) {
		FieldAreaAtuacao = fieldAreaAtuacao;
	}

	public JTextField getFieldDuracaoEstag() {
		return FieldDuracaoEstag;
	}

	public void setFieldDuracaoEstag(JTextField fieldDuracaoEstag) {
		FieldDuracaoEstag = fieldDuracaoEstag;
	}

	public JTextField getFieldCHSem() {
		return FieldCHSem;
	}

	public void setFieldCHSem(JTextField fieldCHSem) {
		FieldCHSem = fieldCHSem;
	}

	public JTextField getFieldNApolSeg() {
		return FieldNApolSeg;
	}

	public void setFieldNApolSeg(JTextField fieldNApolSeg) {
		FieldNApolSeg = fieldNApolSeg;
	}

	public JTextField getFieldSeguradora() {
		return FieldSeguradora;
	}

	public void setFieldSeguradora(JTextField fieldSeguradora) {
		FieldSeguradora = fieldSeguradora;
	}

	public JTextField getFieldProfResp() {
		return FieldProfResp;
	}

	public void setFieldProfResp(JTextField fieldProfResp) {
		FieldProfResp = fieldProfResp;
	}

	public JTextField getFieldSIAPE() {
		return FieldSIAPE;
	}

	public void setFieldSIAPE(JTextField fieldSIAPE) {
		FieldSIAPE = fieldSIAPE;
	}

	public JTextField getFieldSupervidorEmpresa() {
		return FieldSupervidorEmpresa;
	}

	public void setFieldSupervidorEmpresa(JTextField fieldSupervidorEmpresa) {
		FieldSupervidorEmpresa = fieldSupervidorEmpresa;
	}

	public JTextField getFieldCargoSupervEmpresa() {
		return FieldCargoSupervEmpresa;
	}

	public void setFieldCargoSupervEmpresa(JTextField fieldCargoSupervEmpresa) {
		FieldCargoSupervEmpresa = fieldCargoSupervEmpresa;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	public JFormattedTextField getFieldDataInicial() {
		return FieldDataInicial;
	}

	public void setFieldDataInicial(JFormattedTextField fieldDataInicial) {
		FieldDataInicial = fieldDataInicial;
	}

	public JFormattedTextField getFieldDataFinal() {
		return FieldDataFinal;
	}

	public void setFieldDataFinal(JFormattedTextField fieldDataFinal) {
		FieldDataFinal = fieldDataFinal;
	}

	public JComboBox getComboBoxSemestre() {
		return comboBoxSemestre;
	}

	public void setComboBoxSemestre(JComboBox comboBoxSemestre) {
		this.comboBoxSemestre = comboBoxSemestre;
	}

	public JFormattedTextField getFieldMatEst() {
		return FieldMatEst;
	}

	public void setFieldMatEst(JFormattedTextField fieldMatEst) {
		FieldMatEst = fieldMatEst;
	}

	public JComboBox<String> getComboBoxCursoEst() {
		return comboBoxCursoEst;
	}

	public void setComboBoxCursoEst(JComboBox<String> comboBoxCursoEst) {
		this.comboBoxCursoEst = comboBoxCursoEst;
	}

	public JComboBox getComboBoxUF() {
		return comboBoxUF;
	}

	public void setComboBoxUF(JComboBox comboBoxUF) {
		this.comboBoxUF = comboBoxUF;
	}

	public JFormattedTextField getFieldCEP() {
		return FieldCEP;
	}

	public void setFieldCEP(JFormattedTextField fieldCEP) {
		FieldCEP = fieldCEP;
	}

	public JFormattedTextField getFieldCPFEst() {
		return FieldCPFEst;
	}

	public void setFieldCPFEst(JFormattedTextField fieldCPFEst) {
		FieldCPFEst = fieldCPFEst;
	}

	public JFormattedTextField getFieldRGEst() {
		return FieldRGEst;
	}

	public void setFieldRGEst(JFormattedTextField fieldRGEst) {
		FieldRGEst = fieldRGEst;
	}

	public JFormattedTextField getFieldNascEst() {
		return FieldNascEst;
	}

	public void setFieldNascEst(JFormattedTextField fieldNascEst) {
		FieldNascEst = fieldNascEst;
	}

	public JFormattedTextField getFieldCPFResp() {
		return FieldCPFResp;
	}

	public void setFieldCPFResp(JFormattedTextField fieldCPFResp) {
		FieldCPFResp = fieldCPFResp;
	}

	public JFormattedTextField getFieldRGResp() {
		return FieldRGResp;
	}

	public void setFieldRGResp(JFormattedTextField fieldRGResp) {
		FieldRGResp = fieldRGResp;
	}

	public JComboBox<String> getComboBoxCursoCoord() {
		return comboBoxCursoCoord;
	}

	public void setComboBoxCursoCoord(JComboBox<String> comboBoxCursoCoord) {
		this.comboBoxCursoCoord = comboBoxCursoCoord;
	}

	public JFormattedTextField getFieldCPFCoord() {
		return FieldCPFCoord;
	}

	public void setFieldCPFCoord(JFormattedTextField fieldCPFCoord) {
		FieldCPFCoord = fieldCPFCoord;
	}

	public JFormattedTextField getFieldRGCoord() {
		return FieldRGCoord;
	}

	public void setFieldRGCoord(JFormattedTextField fieldRGCoord) {
		FieldRGCoord = fieldRGCoord;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JFormattedTextField getFieldCPFBusca() {
		return FieldCPFBusca;
	}

	public void setFieldCPFBusca(JFormattedTextField fieldCPFBusca) {
		FieldCPFBusca = fieldCPFBusca;
	}

	public MaskFormatter getDataIni() {
		return dataIni;
	}

	public void setDataIni(MaskFormatter dataIni) {
		this.dataIni = dataIni;
	}

	public MaskFormatter getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(MaskFormatter dataFinal) {
		this.dataFinal = dataFinal;
	}

}
