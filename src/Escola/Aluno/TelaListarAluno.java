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

public class TelaListarAluno extends JFrame {

	
	public JFrame frmAluno;
	private JTable tableAluno;
	private Fachada fachada;
	private String[] colunaTabelaAluno;
	private DefaultTableModel tabelaAluno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListarAluno window = new TelaListarAluno();
					window.frmAluno.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListarAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAluno = new JFrame();
		frmAluno.setType(Type.UTILITY);
		frmAluno.getContentPane().setBackground(Color.WHITE);
		frmAluno.setTitle("Alunos");
		frmAluno.setBounds(100, 100, 628, 460);
		frmAluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//copia isso
		frmAluno.setExtendedState(frmAluno.MAXIMIZED_BOTH);
		
		JScrollPane scrollPaneListagemCliente = new JScrollPane();
		scrollPaneListagemCliente.setViewportBorder(new LineBorder(SystemColor.activeCaption, 2, true));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAluno.dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmAluno.getContentPane());
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
		
		tableAluno = new JTable();
		colunaTabelaAluno = new String[] {"ID", "NOME", "CPF", "SEXO", "EMAIL", "TELEFONE", "CELULAR", "LOGRADOURO", "NUMERO", "BAIRRO", "CIDADE", "ESTADO", "CEP","COD. CURSO"};
		tabelaAluno = new DefaultTableModel(new Object[][] {},colunaTabelaAluno);
		tableAluno.setModel(tabelaAluno);
		scrollPaneListagemCliente.setViewportView(tableAluno);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPaneListagemCliente.setColumnHeaderView(scrollBar);
		frmAluno.getContentPane().setLayout(groupLayout);
		
		
		listarTodosAluno();
	}
	
	
	
	// Listando todos os clientes do repositório
	private void listarTodosAluno() {
		
		try {
			ArrayList<Aluno> listar = Fachada.getInstance().alunoListar();
			for(Aluno aluno: listar) {
				Vector vector = new Vector();
				vector.add(aluno.getCod_aluno());
				vector.add(aluno.getNome_aluno());
				vector.add(aluno.getCpf());
				vector.add(aluno.getSexo());
				vector.add(aluno.getContato().getEmail());
				vector.add(aluno.getContato().getTelefone());
				vector.add(aluno.getContato().getCelular());
				vector.add(aluno.getEndereco().getLogradouro());
				vector.add(aluno.getEndereco().getNumero());
				vector.add(aluno.getEndereco().getBairro());
				vector.add(aluno.getEndereco().getCidade());
				vector.add(aluno.getEndereco().getEstado());
				vector.add(aluno.getEndereco().getCep());
				
				vector.add(aluno.getCod_curso());
			
			
				
				tabelaAluno.addRow(vector);
			}
		
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frmAluno, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

}
