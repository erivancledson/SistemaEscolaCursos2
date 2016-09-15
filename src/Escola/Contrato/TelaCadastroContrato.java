package Escola.Contrato;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Escola.Fachada.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TelaCadastroContrato extends JFrame {

	private JPanel contentPane;
	
	public JFrame frmCadastroContrato;
	private JTextField textFieldCodC;
	private JTextField textFieldCodA;
	private JTextField textFieldDescricao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroContrato frame = new TelaCadastroContrato();
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
	public TelaCadastroContrato() {
		setTitle("Cadastrar Contrato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarContrato = new JLabel("Cadastrar Contrato");
		lblCadastrarContrato.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCadastrarContrato.setBounds(96, 11, 217, 20);
		contentPane.add(lblCadastrarContrato);
		
		JLabel lblCodigoDoCurso = new JLabel("Codigo do curso:");
		lblCodigoDoCurso.setBounds(21, 74, 95, 14);
		contentPane.add(lblCodigoDoCurso);
		
		textFieldCodC = new JTextField();
		textFieldCodC.setBounds(126, 71, 55, 20);
		contentPane.add(textFieldCodC);
		textFieldCodC.setColumns(10);
		
		JLabel lblCodigoDoAluno = new JLabel("Codigo do aluno:");
		lblCodigoDoAluno.setBounds(21, 116, 95, 14);
		contentPane.add(lblCodigoDoAluno);
		
		textFieldCodA = new JTextField();
		textFieldCodA.setBounds(126, 113, 55, 20);
		contentPane.add(textFieldCodA);
		textFieldCodA.setColumns(10);
		
		JLabel lblDescio = new JLabel("Desci\u00E7\u00E3o:");
		lblDescio.setBounds(21, 160, 63, 14);
		contentPane.add(lblDescio);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(126, 157, 115, 20);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(126, 228, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
			}
		});
		btnLimpar.setBounds(21, 228, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarContrato();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(225, 228, 89, 23);
		contentPane.add(btnSalvar);
	}
	
	
private void limparCampos(){
		
		textFieldCodC.setText("");
		textFieldCodA.setText("");
		textFieldDescricao.setText("");
	
	}
private void cadastrarContrato() throws Exception {
	
	
	
	
	
	String codC = textFieldCodC.getText();
	String codA = textFieldCodA.getText();
	String descricao = textFieldDescricao.getText();
	

	  int cod_curso = Integer.parseInt(codC);
	  int cod_aluno = Integer.parseInt(codA);
	
	Contrato contrato = new Contrato(cod_curso, cod_aluno, descricao);
	
	try {

	Fachada.getInstance().contratoCadastrar(contrato);
	
	JOptionPane.showMessageDialog(frmCadastroContrato, "Cadastro Realizado com sucesso!");
	this.limparCampos();



} catch (Escola.Aluno.CampoObrigatorioException e) {
	JOptionPane.showMessageDialog(frmCadastroContrato, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
} catch (SQLException e) {
	JOptionPane.showMessageDialog(frmCadastroContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
}catch (Exception e){
	JOptionPane.showMessageDialog(frmCadastroContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
} 
	

}


}
