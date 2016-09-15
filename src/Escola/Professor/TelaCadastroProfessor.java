package Escola.Professor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Escola.Contato.Contato;
import Escola.Endereco.Endereco;
import Escola.Fachada.Fachada;

public class TelaCadastroProfessor extends JFrame {

	private JPanel contentPane;
	
	public JFrame frmCadastroProfessor;
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
					TelaCadastroProfessor frame = new TelaCadastroProfessor();
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
	public TelaCadastroProfessor() {
		setTitle("Cadastro de Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 425);
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
		btnCancelar.setBounds(10, 347, 75, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
			}
		});
		btnLimpar.setBounds(122, 347, 100, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarProfessor();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(247, 347, 99, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblCadastrarAluno = new JLabel("Cadastrar Professor");
		lblCadastrarAluno.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCadastrarAluno.setBounds(53, 11, 271, 33);
		contentPane.add(lblCadastrarAluno);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 77, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 122, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(205, 122, 38, 14);
		contentPane.add(lblSexo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(56, 74, 248, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(56, 119, 139, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(235, 119, 69, 20);
		contentPane.add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 157, 46, 14);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(56, 157, 248, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 188, 69, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(66, 185, 89, 20);
		contentPane.add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(162, 188, 46, 14);
		contentPane.add(lblCelular);
		
		textFieldCelular = new JTextField();
		textFieldCelular.setBounds(205, 188, 99, 20);
		contentPane.add(textFieldCelular);
		textFieldCelular.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 219, 46, 14);
		contentPane.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(56, 219, 166, 20);
		contentPane.add(textFieldRua);
		textFieldRua.setColumns(10);
		
		JLabel lblRua_1 = new JLabel("N\u00BA:");
		lblRua_1.setBounds(235, 222, 38, 14);
		contentPane.add(lblRua_1);
		
		textFieldN = new JTextField();
		textFieldN.setBounds(252, 219, 52, 20);
		contentPane.add(textFieldN);
		textFieldN.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 257, 46, 14);
		contentPane.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(56, 250, 139, 20);
		contentPane.add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 282, 46, 14);
		contentPane.add(lblCidade);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(56, 281, 126, 20);
		contentPane.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(192, 282, 46, 14);
		contentPane.add(lblEstado);
		
		textFieldEstado = new JTextField();
		textFieldEstado.setBounds(235, 279, 69, 20);
		contentPane.add(textFieldEstado);
		textFieldEstado.setColumns(10);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(205, 257, 28, 14);
		contentPane.add(lblCep);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(235, 250, 69, 20);
		contentPane.add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JLabel lblCodigoDoCurso = new JLabel("Codigo do curso:");
		lblCodigoDoCurso.setBounds(10, 312, 101, 14);
		contentPane.add(lblCodigoDoCurso);
		
		textFieldCod_curso = new JTextField();
		textFieldCod_curso.setBounds(123, 312, 59, 20);
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
	
private void cadastrarProfessor() throws Exception {
	
		
		
		
		
		String nome_professor = textFieldNome.getText().toUpperCase();
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
		Professor professor = new Professor(nome_professor, cpf, sexo, contato, endereco, cod_curso);
		
		try {
	
		Fachada.getInstance().professorCadastrar(professor);
		
		JOptionPane.showMessageDialog(frmCadastroProfessor, "Cadastro Realizado com sucesso!");
		this.limparCampos();
	
	} catch (Escola.Professor.CPFInvalidoException e) {
		JOptionPane.showMessageDialog(frmCadastroProfessor, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (ProfessorJaCadastradoException e){
		JOptionPane.showMessageDialog(frmCadastroProfessor, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
	} catch (Escola.Professor.CampoObrigatorioException e) {
		JOptionPane.showMessageDialog(frmCadastroProfessor, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(frmCadastroProfessor, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	}catch (Exception e){
		JOptionPane.showMessageDialog(frmCadastroProfessor, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
	} 
		

	}
}
