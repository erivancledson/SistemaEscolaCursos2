package Escola.Professor;

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

public class TelaBuscarProfessor extends JFrame {

	private JPanel contentPane;
	
	Fachada fachada;
	Professor professor;
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
	private JTextField textFieldCod_curso;
	
	public JFrame frmBuscarProfessor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarProfessor frame = new TelaBuscarProfessor();
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
	public TelaBuscarProfessor() {
		setTitle("Buscar Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 79, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(23, 36, 38, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(270, 79, 32, 14);
		contentPane.add(lblSexo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(56, 76, 204, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(56, 33, 191, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(301, 76, 38, 20);
		contentPane.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 117, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(56, 114, 204, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 156, 66, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(86, 153, 126, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(222, 156, 57, 14);
		contentPane.add(lblCelular);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setBounds(277, 153, 89, 20);
		contentPane.add(textFieldCelular);
		textFieldCelular.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 188, 46, 14);
		contentPane.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(56, 188, 204, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblRua_1 = new JLabel("N\u00BA:");
		lblRua_1.setBounds(277, 191, 28, 14);
		contentPane.add(lblRua_1);
		
		textFieldN = new JTextField();
		textFieldN.setBounds(296, 185, 38, 20);
		contentPane.add(textFieldN);
		textFieldN.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 219, 46, 14);
		contentPane.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(56, 216, 283, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 247, 46, 14);
		contentPane.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(56, 247, 283, 20);
		contentPane.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(192, 281, 68, 14);
		contentPane.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(238, 278, 101, 20);
		contentPane.add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 278, 46, 14);
		contentPane.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(56, 278, 126, 20);
		contentPane.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JLabel lblCodigoDoCurso = new JLabel("Codigo do curso:");
		lblCodigoDoCurso.setBounds(10, 317, 101, 14);
		contentPane.add(lblCodigoDoCurso);
		
		textFieldCod_curso = new JTextField();
		textFieldCod_curso.setBounds(115, 314, 46, 20);
		contentPane.add(textFieldCod_curso);
		textFieldCod_curso.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String cpf = textFieldCpf.getText();
				try {
					
					Fachada.getInstance().professorProcurar(cpf);
					Fachada fachada = Fachada.getInstance();
					Professor temp = fachada.professorProcurar(cpf);
					
					textFieldNome.setText(temp.getNome_professor().toUpperCase());
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
					
					
					textFieldCod_curso.setText(Integer.toString(temp.getCod_curso()));
					
					

				} catch (Escola.Professor.CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (ProfessorNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (Escola.Professor.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 
				
			}
		});
		btnBuscar.setBounds(257, 32, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnSair.setBounds(22, 360, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String cpf = textFieldCpf.getText();
					Fachada fachada = Fachada.getInstance();
					Professor professor = fachada.professorProcurar(cpf);
					Endereco endereco = professor.getEndereco();
					Contato contato = professor.getContato();
					
					professor.setNome_professor(textFieldNome.getText());
					professor.setSexo(textFieldSexo.getText());
		
					contato.setEmail(textFieldEmail.getText());
					contato.setTelefone(textFieldTelefone.getText());
					contato.setCelular(textFieldCelular.getText());
					professor.setContato(contato);

					
					endereco.setLogradouro(textFieldRua.getText());
					endereco.setNumero(textFieldN.getText());
					endereco.setBairro(textFieldBairro.getText());
					endereco.setCidade(textFieldCidade.getText());
					endereco.setEstado(textFieldEstado.getText());
					endereco.setCep(textFieldCep.getText());
					professor.setEndereco(endereco);
					
					professor.setCod_curso(Integer.parseInt(textFieldCod_curso.getText()));
					
					fachada.professorAtualizar(professor);
					
				} catch (Escola.Professor.CPFInvalidoException e1) {
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (ProfessorNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (Escola.Professor.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		btnAtualizar.setBounds(238, 360, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = JOptionPane.showConfirmDialog(frmBuscarProfessor, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cpf = textFieldCpf.getText();
						Fachada.getInstance().professorRemover(cpf);
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarProfessor, "Removido com Sucesso!");
			
						
					} catch (Escola.Professor.CPFInvalidoException e1) {
						JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (ProfessorNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (Escola.Professor.CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarProfessor, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
				
				}
			}
		});
		btnRemover.setBounds(128, 360, 89, 23);
		contentPane.add(btnRemover);
	}
}
