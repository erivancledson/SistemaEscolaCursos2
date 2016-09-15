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

public class TelaListarProfessorSub extends JFrame {

	private JPanel contentPane;
	public JFrame frmProfessorSub;
	private JTable tableProfessorSub;
	private Fachada fachada;
	private String[] colunaTabelaProfessorSub;
	private DefaultTableModel tabelaProfessorSub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarProfessorSub window = new TelaListarProfessorSub();
					window.frmProfessorSub.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListarProfessorSub() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProfessorSub = new JFrame();
		frmProfessorSub.setType(Type.UTILITY);
		frmProfessorSub.getContentPane().setBackground(Color.WHITE);
		frmProfessorSub.setTitle("PROFESSOR");
		frmProfessorSub.setBounds(100, 100, 628, 460);
		frmProfessorSub.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmProfessorSub.setExtendedState(frmProfessorSub.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmProfessorSub.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmProfessorSub.getContentPane());
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
		
		tableProfessorSub = new JTable();
		colunaTabelaProfessorSub = new String[] {"NOME", "CPF"};
		tabelaProfessorSub = new DefaultTableModel(new Object[][] {},colunaTabelaProfessorSub);
		tableProfessorSub.setModel(tabelaProfessorSub);
		scrollPaneListagemCliente.setViewportView(tableProfessorSub);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmProfessorSub.getContentPane().setLayout(groupLayout);
		
		
		listarTodosProfessor();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosProfessor() {
		
		try {
			ArrayList<Professor> listar = Fachada.getInstance().professorListarSub();
			for(Professor professor: listar) {
				Vector vector = new Vector();
			
				vector.add(professor.getNome_professor());
				vector.add(professor.getCpf());
			
				
			
			
			
				
				tabelaProfessorSub.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmProfessorSub, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}


}
