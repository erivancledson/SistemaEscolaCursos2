package Escola.Professor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Escola.Fachada.Fachada;

public class TelaListarProfessor extends JFrame {

	public JFrame frmProfessor;
	private JTable tableProfessor;
	private Fachada fachada;
	private String[] colunaTabelaProfessor;
	private DefaultTableModel tabelaProfessor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarProfessor window = new TelaListarProfessor();
					window.frmProfessor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfessor = new JFrame();
		frmProfessor.setType(Type.UTILITY);
		frmProfessor.getContentPane().setBackground(Color.WHITE);
		frmProfessor.setTitle("PROFESSOR");
		frmProfessor.setBounds(100, 100, 628, 460);
		frmProfessor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmProfessor.setExtendedState(frmProfessor.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProfessor.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmProfessor.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 1169, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(btnSair)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPaneListagemCliente, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSair))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableProfessor = new JTable();
		colunaTabelaProfessor = new String[] {"ID", "NOME", "CPF", "SEXO", "EMAIL", "TELEFONE", "CELULAR", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP","COD CURSO"};
		tabelaProfessor = new DefaultTableModel(new Object[][] {},colunaTabelaProfessor);
		tableProfessor.setModel(tabelaProfessor);
		scrollPaneListagemCliente.setViewportView(tableProfessor);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmProfessor.getContentPane().setLayout(groupLayout);
		
		
		listarTodosProfessor();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosProfessor() {
		
		try {
			ArrayList<Professor> listar = Fachada.getInstance().professorListar();
			for(Professor professor: listar) {
				Vector vector = new Vector();
				vector.add(professor.getCod_professor());
				vector.add(professor.getNome_professor());
				vector.add(professor.getCpf());
				vector.add(professor.getSexo());
				vector.add(professor.getContato().getEmail());
				vector.add(professor.getContato().getTelefone());
				vector.add(professor.getContato().getCelular());
				vector.add(professor.getEndereco().getLogradouro());
				vector.add(professor.getEndereco().getNumero());
				vector.add(professor.getEndereco().getBairro());
				vector.add(professor.getEndereco().getCidade());
				vector.add(professor.getEndereco().getEstado());
				vector.add(professor.getEndereco().getCep());
				
				vector.add(professor.getCod_curso());
			
			
				
				tabelaProfessor.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmProfessor, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}


}
