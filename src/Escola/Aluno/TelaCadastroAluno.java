package Escola.Aluno;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Escola.Contato.Contato;
import Escola.Endereco.Endereco;
import Escola.Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	
	public JFrame frmCadastroAluno;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroAluno frame = new TelaCadastroAluno();
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
	public TelaCadastroAluno() {
		setTitle("Cadastro de Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(277, 368, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
			}
		});
		btnLimpar.setBounds(56, 368, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarAluno();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(413, 368, 89, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Aluno");
		lblCadastrarAluno.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCadastrarAluno.setBounds(168, 22, 183, 33);
		contentPane.add(lblCadastrarAluno);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 77, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(10, 122, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(397, 77, 46, 14);
		contentPane.add(lblSexo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(56, 74, 331, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(56, 119, 248, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(450, 74, 52, 20);
		contentPane.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(324, 122, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(363, 119, 139, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 166, 78, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(67, 163, 200, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(277, 166, 46, 14);
		contentPane.add(lblCelular);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setBounds(324, 163, 178, 20);
		contentPane.add(textFieldCelular);
		textFieldCelular.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 212, 46, 14);
		contentPane.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(56, 209, 323, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblRua_1 = new JLabel("N\u00BA:");
		lblRua_1.setBounds(397, 212, 28, 14);
		contentPane.add(lblRua_1);
		
		textFieldN = new JTextField();
		textFieldN.setBounds(435, 209, 67, 20);
		contentPane.add(textFieldN);
		textFieldN.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 256, 46, 14);
		contentPane.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(56, 253, 211, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(277, 256, 46, 14);
		contentPane.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(333, 253, 169, 20);
		contentPane.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 301, 46, 14);
		contentPane.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(56, 298, 78, 20);
		contentPane.add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(144, 301, 46, 14);
		contentPane.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(168, 298, 155, 20);
		contentPane.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JLabel lblCodigoDoCurso = new JLabel("Codigo do curso:");
		lblCodigoDoCurso.setBounds(333, 301, 101, 14);
		contentPane.add(lblCodigoDoCurso);
		
		textFieldCod_curso = new JTextField();
		textFieldCod_curso.setBounds(435, 298, 67, 20);
		contentPane.add(textFieldCod_curso);
		textFieldCod_curso.setColumns(10);
	}
	
	private void limparCampos(){
		
		textFieldNome.setText("");
		textFieldCpf.setText("");
		textFieldSexo.setText("");
		textFieldEmail.setText("");
		textFieldTelefone.setText("");
		textFieldCelular.setText("");
		textFieldRua.setText("");
		textFieldN.setText("");
		textFieldBairro.setText("");
		textFieldCidade.setText("");
		textFieldEstado.setText("");
		textFieldCep.setText("");
		textFieldCod_curso.setText("");
		
		
	}
	
private void cadastrarAluno() throws Exception {
	
		
		
		
		
		String nome_aluno = textFieldNome.getText().toUpperCase(); // ultimo assunto de bd
		String cpf = textFieldCpf.getText();
		String sexo = textFieldSexo.getText();
		String email = textFieldEmail.getText();
		String telefone = textFieldTelefone.getText();
		String celular = textFieldCelular.getText();
		String logradouro = textFieldRua.getText();
		String numero =  textFieldN.getText();
	    String bairro = textFieldBairro.getText();
	    String cidade = textFieldCidade.getText();
		String estado = textFieldEstado.getText();
		String cep = textFieldCep.getText();
		String cod = textFieldCod_curso.getText();
   
		  int cod_curso = Integer.parseInt(cod);
	
		
		
		Contato contato = new Contato(email, telefone, celular);
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado, cep);
		Aluno aluno = new Aluno(nome_aluno, cpf, sexo, contato, endereco, cod_curso);
		
		try {
	
		Fachada.getInstance().alunoCadastrar(aluno);
		
		JOptionPane.showMessageDialog(frmCadastroAluno, "Cadastro Realizado com sucesso!");
		this.limparCampos();
	
	} catch (Escola.Aluno.CPFInvalidoException e) {
		JOptionPane.showMessageDialog(frmCadastroAluno, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (AlunoJaCadastradoException e){
		JOptionPane.showMessageDialog(frmCadastroAluno, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (Escola.Aluno.CampoObrigatorioException e) {
		JOptionPane.showMessageDialog(frmCadastroAluno, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(frmCadastroAluno, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	}catch (Exception e){
		JOptionPane.showMessageDialog(frmCadastroAluno, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	} 
		

	}

	
}
