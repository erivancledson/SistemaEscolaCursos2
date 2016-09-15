package Escola.Curso;

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

public class TelaListarCursoL extends JFrame {

	public JFrame frmCurso;
	private JTable tableCurso;
	private Fachada fachada;
	private String[] colunaTabelaCurso;
	private DefaultTableModel tabelaCurso;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarCursoL window = new TelaListarCursoL();
					window.frmCurso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarCursoL() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurso = new JFrame();
		frmCurso.setType(Type.UTILITY);
		frmCurso.getContentPane().setBackground(Color.WHITE);
		frmCurso.setTitle("CURSO");
		frmCurso.setBounds(100, 100, 628, 460);
		frmCurso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmCurso.setExtendedState(frmCurso.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCurso.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmCurso.getContentPane());
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
		
		tableCurso = new JTable();
		colunaTabelaCurso = new String[] {"NOME", "DIA", "HORARIO"};
		tabelaCurso = new DefaultTableModel(new Object[][] {},colunaTabelaCurso);
		tableCurso.setModel(tabelaCurso);
		scrollPaneListagemCliente.setViewportView(tableCurso);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmCurso.getContentPane().setLayout(groupLayout);
		
		
		listarTodosCurso();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosCurso() {
		
		try {
			ArrayList<Curso> listar = Fachada.getInstance().cursoListarLog();
			for(Curso curso: listar) {
				Vector vector = new Vector();
				vector.add(curso.getNome());
				vector.add(curso.getDia_semana());
				vector.add(curso.getHorario());
		
				tabelaCurso.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmCurso, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
