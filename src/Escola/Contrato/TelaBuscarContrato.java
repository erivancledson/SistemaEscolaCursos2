package Escola.Contrato;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import Escola.Fachada.Fachada;
import Escola.Professor.Professor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TelaBuscarContrato extends JFrame {

	private JPanel contentPane;
	
	public JFrame frmBuscarContrato;
	private JTextField textFieldCodC;
	private JTextField textFieldCodA;
	private JTextField textFieldDescricao;
	private JTextField textFieldCodigo_contrato;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarContrato frame = new TelaBuscarContrato();
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
	public TelaBuscarContrato() {
		setTitle("Buscar Contrato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblCodigoDoCurso = new JLabel("C\u00F3digo do curso:");
		lblCodigoDoCurso.setBounds(22, 94, 95, 14);
		contentPane.add(lblCodigoDoCurso);
		
		textFieldCodC = new JTextField();
		textFieldCodC.setBounds(127, 91, 55, 20);
		contentPane.add(textFieldCodC);
		textFieldCodC.setColumns(10);
		
		JLabel lblCodigoDoAluno = new JLabel("C\u00F3digo do aluno:");
		lblCodigoDoAluno.setBounds(22, 136, 95, 14);
		contentPane.add(lblCodigoDoAluno);
		
		textFieldCodA = new JTextField();
		textFieldCodA.setBounds(127, 133, 55, 20);
		contentPane.add(textFieldCodA);
		textFieldCodA.setColumns(10);
		
		JLabel lblDescio = new JLabel("Desci\u00E7\u00E3o:");
		lblDescio.setBounds(22, 180, 63, 14);
		contentPane.add(lblDescio);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(127, 177, 198, 20);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JLabel lblCdigoContrato = new JLabel("C\u00F3digo Contrato:");
		lblCdigoContrato.setBounds(22, 48, 95, 14);
		contentPane.add(lblCdigoContrato);
		
		textFieldCodigo_contrato = new JTextField();
		textFieldCodigo_contrato.setBounds(127, 45, 55, 20);
		contentPane.add(textFieldCodigo_contrato);
		textFieldCodigo_contrato.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String cod_contrato = textFieldCodigo_contrato.getText();
				try {
					
					
					Fachada.getInstance().contratoProcurar(Integer.parseInt(cod_contrato));
					Fachada fachada = Fachada.getInstance();
					Contrato temp = fachada.contratoProcurar(Integer.parseInt(cod_contrato));
					
					

					textFieldCodC.setText(Integer.toString(temp.getCod_curso()));
					textFieldCodA.setText(Integer.toString(temp.getCod_aluno()));
					textFieldDescricao.setText(temp.getDescricao());
					
					
					
					
					
				} catch (ContratoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (Escola.Curso.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		btnBuscar.setBounds(192, 44, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnSair.setBounds(22, 228, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String cod_contrato = textFieldCodigo_contrato.getText();
					Fachada fachada = Fachada.getInstance();
					Contrato contrato = fachada.contratoProcurar(Integer.parseInt(cod_contrato));
					
					contrato.setCod_curso(Integer.parseInt(textFieldCodC.getText()));
					contrato.setCod_aluno(Integer.parseInt(textFieldCodA.getText()));
					
					contrato.setDescricao(textFieldDescricao.getText());

					
					fachada.contratoAtualizar(contrato);
					
				
				} catch (ContratoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (Escola.Contrato.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 

			}
		});
		btnAtualizar.setBounds(236, 228, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					try {
						
						
						
						String cod_contrato = textFieldCodigo_contrato.getText();
						Fachada.getInstance().contratoRemover(Integer.parseInt(cod_contrato));
						Fachada fachada = Fachada.getInstance();
						
						JOptionPane.showMessageDialog(frmBuscarContrato, "Removido com Sucesso!");
			
						
				
					} catch (ContratoNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (Escola.Contrato.CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarContrato, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
			}
			
		});
		btnRemover.setBounds(135, 228, 89, 23);
		contentPane.add(btnRemover);
	}
}
