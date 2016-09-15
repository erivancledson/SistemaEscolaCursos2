package Escola.Aluno;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Escola.Contato.Contato;
import Escola.Endereco.Endereco;
import Escola.Fachada.Fachada;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TelaBuscarAluno extends JFrame {

	private JPanel contentPane;

	Fachada fachada;
	Aluno aluno;
	Contato contato;
	Endereco endereco;
	
	private JTextField textFieldNome;
	private JTextField textFieldCpf;
	private JTextField textFieldSexo;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldCelular;
	private JTextField textFieldRua;
	private JTextField textFieldN;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldCep;
	private JTextField textFieldC;
	
	public JFrame frmBuscarAluno;
	private JButton btnBucar;
	private JButton btnSair;
	private JButton btnAtualizar;
	private JButton btnRemover;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarAluno frame = new TelaBuscarAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaBuscarAluno() {
		setTitle("Buscar Aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 91, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(31, 26, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(245, 130, 46, 14);
		contentPane.add(lblSexo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(69, 88, 284, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(76, 23, 159, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(301, 127, 52, 20);
		contentPane.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 130, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(69, 127, 166, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 168, 67, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(79, 165, 103, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(202, 168, 46, 14);
		contentPane.add(lblCelular);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setBounds(247, 165, 106, 20);
		contentPane.add(textFieldCelular);
		textFieldCelular.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 214, 46, 14);
		contentPane.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(69, 211, 190, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblRua_1 = new JLabel("N\u00BA:");
		lblRua_1.setBounds(269, 214, 38, 14);
		contentPane.add(lblRua_1);
		
		textFieldN = new JTextField();
		textFieldN.setBounds(301, 211, 52, 20);
		contentPane.add(textFieldN);
		textFieldN.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 254, 46, 14);
		contentPane.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(69, 251, 126, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 294, 46, 14);
		contentPane.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(69, 291, 126, 20);
		contentPane.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(202, 294, 46, 14);
		contentPane.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(245, 291, 46, 20);
		contentPane.add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(205, 254, 46, 14);
		contentPane.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(245, 251, 108, 20);
		contentPane.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JLabel lblCodigoDoCurso = new JLabel("Codigo do curso:");
		lblCodigoDoCurso.setBounds(10, 334, 101, 14);
		contentPane.add(lblCodigoDoCurso);
		
		textFieldC = new JTextField();
		textFieldC.setBounds(103, 331, 89, 20);
		contentPane.add(textFieldC);
		textFieldC.setColumns(10);
		
		btnBucar = new JButton("Bucar");
		btnBucar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = textFieldCpf.getText();
				try {
					
					Fachada.getInstance().alunoProcurar(cpf);
					Fachada fachada = Fachada.getInstance();
					Aluno temp = fachada.alunoProcurar(cpf);
					
					textFieldNome.setText(temp.getNome_aluno().toUpperCase());
					textFieldCpf.setText(temp.getCpf());
					textFieldSexo.setText(temp.getSexo());
						
					
					textFieldEmail.setText(temp.getContato().getEmail());
					textFieldTelefone.setText(temp.getContato().getTelefone());
					textFieldCelular.setText(temp.getContato().getCelular());
					
					
					textFieldRua.setText(temp.getEndereco().getLogradouro().toUpperCase());
					textFieldN.setText(temp.getEndereco().getNumero());
					textFieldBairro.setText(temp.getEndereco().getBairro().toUpperCase());
					textFieldCidade.setText(temp.getEndereco().getCidade().toUpperCase());
					textFieldEstado.setText(temp.getEndereco().getEstado().toUpperCase());
					textFieldCep.setText(temp.getEndereco().getCep().toUpperCase());
					
					
					textFieldC.setText(Integer.toString(temp.getCod_curso()));
					
					

				} catch (Escola.Aluno.CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (AlunoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (Escola.Aluno.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 
				
			}
		});
		btnBucar.setBounds(250, 22, 89, 23);
		contentPane.add(btnBucar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnSair.setBounds(10, 382, 89, 23);
		contentPane.add(btnSair);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String cpf = textFieldCpf.getText();
					Fachada fachada = Fachada.getInstance();
					Aluno aluno = fachada.alunoProcurar(cpf);
					Endereco endereco = aluno.getEndereco();
					Contato contato = aluno.getContato();
					
					aluno.setNome_aluno(textFieldNome.getText());
					aluno.setSexo(textFieldSexo.getText());
		
					contato.setEmail(textFieldEmail.getText());
					contato.setTelefone(textFieldTelefone.getText());
					contato.setCelular(textFieldCelular.getText());
					aluno.setContato(contato);

					
					endereco.setLogradouro(textFieldRua.getText());
					endereco.setNumero(textFieldN.getText());
					endereco.setBairro(textFieldBairro.getText());
					endereco.setCidade(textFieldCidade.getText());
					endereco.setEstado(textFieldEstado.getText());
					endereco.setCep(textFieldCep.getText());
					aluno.setEndereco(endereco);
					
					aluno.setCod_curso(Integer.parseInt(textFieldC.getText()));
					
					fachada.AlunoAtualizar(aluno);
					
				} catch (Escola.Aluno.CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (AlunoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (Escola.Aluno.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 
				}
				
				
			
		});
		btnAtualizar.setBounds(277, 382, 89, 23);
		contentPane.add(btnAtualizar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarAluno, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().alunoRemover(cpf);
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarAluno, "Removido com Sucesso!");
			
						
					} catch (Escola.Aluno.CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (AlunoNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (Escola.Aluno.CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarAluno, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
				
				}
			}
		});
		btnRemover.setBounds(149, 382, 89, 23);
		contentPane.add(btnRemover);
	}

}
