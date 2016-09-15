package Escola.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Escola.Aluno.TelaBuscarAluno;
import Escola.Aluno.TelaCadastroAluno;
import Escola.Aluno.TelaListarAluno;
import Escola.Aluno.TelaListarVisaoAluno;
import Escola.Contrato.TelaBuscarContrato;
import Escola.Contrato.TelaCadastroContrato;
import Escola.Contrato.TelaListarContrato;
import Escola.Curso.TelaBuscarCurso;
import Escola.Curso.TelaCadastroCurso;
import Escola.Curso.TelaListarCurso;
import Escola.Curso.TelaListarCursoL;
import Escola.Professor.TelaBuscarProfessor;
import Escola.Professor.TelaCadastroProfessor;
import Escola.Professor.TelaListarProfessor;
import Escola.Professor.TelaListarProfessorSub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Cad Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1400, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBarPrinciapal = new JMenuBar();
		menuBarPrinciapal.setBounds(0, 0, 1370, 21);
		contentPane.add(menuBarPrinciapal);
		
		JMenu mnCurso = new JMenu("Curso");
		menuBarPrinciapal.add(mnCurso);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar Curso");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaCadastroCurso frame = new TelaCadastroCurso();
				frame.setVisible(true);
			}
		});
		mnCurso.add(mntmCadastrar);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar Curso");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarCurso frame = new TelaBuscarCurso();
				frame.setVisible(true);
			}
		});
		mnCurso.add(mntmBuscar);
		
		JMenuItem mntmListar = new JMenuItem("Listar Cursos");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarCurso window = new TelaListarCurso();
				window.frmCurso.setVisible(true);
			}
		});
		mnCurso.add(mntmListar);
		
		JMenuItem mntmListarLog = new JMenuItem("Listar Log de Cursos deletados");
		mntmListarLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarCursoL window = new TelaListarCursoL();
				window.frmCurso.setVisible(true);
			}
		});
		mnCurso.add(mntmListarLog);
		
		JMenu mnProfessor = new JMenu("Professor");
		menuBarPrinciapal.add(mnProfessor);
		
		JMenuItem mntmCadastrarProfessor = new JMenuItem("Cadastrar Professor");
		mntmCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProfessor frame = new TelaCadastroProfessor();
				frame.setVisible(true);
			}
		});
		mnProfessor.add(mntmCadastrarProfessor);
		
		JMenuItem mntmBuscarProfessor = new JMenuItem("Buscar Professor");
		mntmBuscarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarProfessor frame = new TelaBuscarProfessor();
				frame.setVisible(true);
			}
		});
		mnProfessor.add(mntmBuscarProfessor);
		
		JMenuItem mntmListarProfessor = new JMenuItem("Listar Professor");
		mntmListarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarProfessor window = new TelaListarProfessor();
				window.frmProfessor.setVisible(true);
			}
		});
		mnProfessor.add(mntmListarProfessor);
		
		JMenuItem mntmListarProfessorSubselect = new JMenuItem("Listar Professor subselect");
		mntmListarProfessorSubselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarProfessorSub window = new TelaListarProfessorSub();
				window.frmProfessorSub.setVisible(true);
			}
		});
		mnProfessor.add(mntmListarProfessorSubselect);
		
		JMenu mnAluno = new JMenu("Aluno");
		menuBarPrinciapal.add(mnAluno);
		
		JMenuItem mntmCadastraraluno = new JMenuItem("CadastrarAluno");
		mntmCadastraraluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAluno frame = new TelaCadastroAluno();
				frame.setVisible(true);
			}
		});
		mnAluno.add(mntmCadastraraluno);
		
		JMenuItem mntmBuscarAluno = new JMenuItem("Buscar Aluno");
		mntmBuscarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarAluno frame = new TelaBuscarAluno();
				frame.setVisible(true);
			}
		});
		mnAluno.add(mntmBuscarAluno);
		
		JMenuItem mntmListarAluno = new JMenuItem("Listar Aluno");
		mntmListarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarAluno window = new TelaListarAluno();
				window.frmAluno.setVisible(true);
			}
		});
		mnAluno.add(mntmListarAluno);
		
		JMenuItem mntmTelaListarViso = new JMenuItem("Tela Listar Vis\u00E3o Aluno");
		mntmTelaListarViso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarVisaoAluno window = new TelaListarVisaoAluno();
				window.frmAlunoVisao.setVisible(true);
			}
		});
		mnAluno.add(mntmTelaListarViso);
		
		JMenu mnContrato = new JMenu("Contrato");
		menuBarPrinciapal.add(mnContrato);
		
		JMenuItem mntmCadastrarContrato = new JMenuItem("Cadastrar Contrato");
		mntmCadastrarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroContrato frame = new TelaCadastroContrato();
				frame.setVisible(true);
			}
		});
		mnContrato.add(mntmCadastrarContrato);
		
		JMenuItem mntmBuscarContrato = new JMenuItem("Buscar Contrato");
		mntmBuscarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaBuscarContrato frame = new TelaBuscarContrato();
				frame.setVisible(true);
			}
		});
		mnContrato.add(mntmBuscarContrato);
		
		JMenuItem mntmListarContrato = new JMenuItem("Listar Contrato");
		mntmListarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarContrato window = new TelaListarContrato();
				window.frmContrato.setVisible(true);
			}
		});
		mnContrato.add(mntmListarContrato);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(1250, 629, 95, 43);
		contentPane.add(btnSair);
	}
}
