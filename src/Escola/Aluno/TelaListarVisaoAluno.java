package Escola.Aluno;

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

public class TelaListarVisaoAluno extends JFrame {

	private JPanel contentPane;

	public JFrame frmAlunoVisao;
	private JTable tableAlunoVisao;
	private Fachada fachada;
	private String[] colunaTabelaAlunoVisao;
	private DefaultTableModel tabelaAlunoVisao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarVisaoAluno window = new TelaListarVisaoAluno();
					window.frmAlunoVisao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaListarVisaoAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlunoVisao = new JFrame();
		frmAlunoVisao.setType(Type.UTILITY);
		frmAlunoVisao.getContentPane().setBackground(Color.WHITE);
		frmAlunoVisao.setTitle("Alunos");
		frmAlunoVisao.setBounds(100, 100, 628, 460);
		frmAlunoVisao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmAlunoVisao.setExtendedState(frmAlunoVisao.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAlunoVisao.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmAlunoVisao.getContentPane());
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
		
		tableAlunoVisao = new JTable();
		colunaTabelaAlunoVisao = new String[] {"COD. CURSO", "COD. ALUNO", "NOME"};
		tabelaAlunoVisao = new DefaultTableModel(new Object[][] {},colunaTabelaAlunoVisao);
		tableAlunoVisao.setModel(tabelaAlunoVisao);
		scrollPaneListagemCliente.setViewportView(tableAlunoVisao);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmAlunoVisao.getContentPane().setLayout(groupLayout);
		
		
		listarTodosAlunosVisao();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosAlunosVisao() {
		
		try {
			ArrayList<Aluno> listar = Fachada.getInstance().alunoListar();
			for(Aluno aluno: listar) {
				Vector vector = new Vector();
				vector.add(aluno.getCod_curso());
				vector.add(aluno.getCod_aluno());
				vector.add(aluno.getNome_aluno());
				
				
				
			
			
				
				tabelaAlunoVisao.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmAlunoVisao, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
