package Escola.Contrato;

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

public class TelaListarContrato extends JFrame {

	public JFrame frmContrato;
	private JTable tableContrato;
	private Fachada fachada;
	private String[] colunaTabelaContrato;
	private DefaultTableModel tabelaContrato;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarContrato window = new TelaListarContrato();
					window.frmContrato.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarContrato() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContrato = new JFrame();
		frmContrato.setType(Type.UTILITY);
		frmContrato.getContentPane().setBackground(Color.WHITE);
		frmContrato.setTitle("CONTRATO");
		frmContrato.setBounds(100, 100, 628, 460);
		frmContrato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmContrato.setExtendedState(frmContrato.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmContrato.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmContrato.getContentPane());
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
		
		tableContrato = new JTable();
		colunaTabelaContrato = new String[] {"ID", "NOME ALUNO", "NOME CURSO", "DESCRICAO"};
		tabelaContrato = new DefaultTableModel(new Object[][] {},colunaTabelaContrato);
		tableContrato.setModel(tabelaContrato);
		scrollPaneListagemCliente.setViewportView(tableContrato);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmContrato.getContentPane().setLayout(groupLayout);
		
		
		listarTodosContrato();
	}
	
	
	

	private void listarTodosContrato() {
		
		try {
			ArrayList<Contrato> listar = Fachada.getInstance().contratoListar();
			for(Contrato contrato: listar) {
				Vector vector = new Vector();
				vector.add(contrato.getCod_contrato());
				vector.add(contrato.getAluno().getNome_aluno());
				vector.add(contrato.getCurso().getNome());
				vector.add(contrato.getDescricao());
	
				tabelaContrato.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmContrato, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
