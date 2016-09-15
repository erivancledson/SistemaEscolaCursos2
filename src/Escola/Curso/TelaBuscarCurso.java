package Escola.Curso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Escola.Contato.Contato;
import Escola.Endereco.Endereco;
import Escola.Fachada.Fachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TelaBuscarCurso extends JFrame {

	private JPanel contentPane;
	
	Fachada fachada;
	Curso curso;
	Contato contato;
	Endereco endereco;
	
	public JFrame frmBuscarCurso;
	private JTextField textFieldCod_curso;
	private JTextField textFieldNome;
	private JTextField textFieldDia_semana;
	private JTextField textFieldHorario;
	private JTextField textFieldImagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscarCurso frame = new TelaBuscarCurso();
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
	public TelaBuscarCurso() {
		setTitle("Buscar Curso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCod_curso = new JTextField();
		textFieldCod_curso.setBounds(107, 47, 63, 20);
		contentPane.add(textFieldCod_curso);
		textFieldCod_curso.setColumns(10);
		
		JLabel lblCdigoDoCurso = new JLabel("C\u00F3digo do curso:");
		lblCdigoDoCurso.setBounds(10, 50, 105, 14);
		contentPane.add(lblCdigoDoCurso);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cod_curso = textFieldCod_curso.getText();
				try {
					
				
					Fachada.getInstance().cursoProcurar(cod_curso);
					Fachada fachada = Fachada.getInstance();
					Curso temp = fachada.cursoProcurar(cod_curso);
					
					textFieldNome.setText(temp.getNome());
					textFieldDia_semana.setText(temp.getDia_semana());
					textFieldHorario.setText(temp.getHorario());
					textFieldImagem.setText(temp.getImagem());
				
					
					
					
					
				} catch (CursoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (Escola.Curso.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 

			}
		});
		btnBuscar.setBounds(196, 46, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 143, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da semana:");
		lblDiaDaSemana.setBounds(10, 183, 97, 14);
		contentPane.add(lblDiaDaSemana);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setBounds(10, 224, 46, 14);
		contentPane.add(lblHorrio);
		
		textFieldNome = new JTextField();
		textFieldNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textFieldNome.setBounds(56, 137, 233, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldDia_semana = new JTextField();
		textFieldDia_semana.setBounds(95, 180, 178, 20);
		contentPane.add(textFieldDia_semana);
		textFieldDia_semana.setColumns(10);
		
		textFieldHorario = new JTextField();
		textFieldHorario.setBounds(66, 221, 223, 20);
		contentPane.add(textFieldHorario);
		textFieldHorario.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(10, 307, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String cod_curso = textFieldCod_curso.getText();
					Fachada fachada = Fachada.getInstance();
					Curso curso = fachada.cursoProcurar(cod_curso);
					
					curso.setNome(textFieldNome.getText());
					curso.setDia_semana(textFieldDia_semana.getText());
					curso.setHorario(textFieldHorario.getText());

					
					fachada.cursoAtualizar(curso);
					
				
				} catch (CursoNaoEncontradoException e1){
					JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
				} catch (Escola.Curso.CampoObrigatorioException e1) {
					JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}catch (Exception e1){
					JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				} 
				}
			
		});
		btnAtualizar.setBounds(215, 307, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultado = JOptionPane.showConfirmDialog(frmBuscarCurso, "Deseja Excluir?\n" +textFieldNome.getText(),"Excluir",JOptionPane.YES_NO_CANCEL_OPTION);
				if(resultado == JOptionPane.YES_OPTION){
					try {
						String cod_curso = textFieldCod_curso.getText();
						Fachada.getInstance().cursoRemover(cod_curso);
						Fachada fachada = Fachada.getInstance();
						JOptionPane.showMessageDialog(frmBuscarCurso, "Removido com Sucesso!");
			
						
				
					} catch (CursoNaoEncontradoException e1){
						JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
					} catch (Escola.Curso.CampoObrigatorioException e1) {
						JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					}catch (Exception e1){
						JOptionPane.showMessageDialog(frmBuscarCurso, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					} 
			}
			}
		});
		btnRemover.setBounds(117, 307, 88, 23);
		contentPane.add(btnRemover);
		
		JLabel lblImagem = new JLabel("Imagem:");
		lblImagem.setBounds(10, 264, 63, 14);
		contentPane.add(lblImagem);
		
		textFieldImagem = new JTextField();
		textFieldImagem.setBounds(72, 261, 213, 20);
		contentPane.add(textFieldImagem);
		textFieldImagem.setColumns(10);
	}
}
