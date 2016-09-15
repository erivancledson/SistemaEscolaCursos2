package Escola.Curso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.io.File;







import Escola.Fachada.Fachada;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TelaCadastroCurso extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public JFrame frmCadastroCurso;
	private JTextField textFieldNome;
	private JTextField textFieldDia_semana;
	private JTextField textFieldHorario;
	private String caminho2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCurso frame = new TelaCadastroCurso();
					
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
	public TelaCadastroCurso() {
		setTitle("Cadastrar Curso");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroCurso = new JFrame();
		frmCadastroCurso.setTitle("CADASTRAR CURSO");
		setBounds(100, 100, 507, 349);
		frmCadastroCurso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroCurso.getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 58, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblDiaDaSemana = new JLabel("Dia da semana:");
		lblDiaDaSemana.setBounds(10, 109, 100, 14);
		contentPane.add(lblDiaDaSemana);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setBounds(10, 151, 46, 14);
		contentPane.add(lblHorario);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frmCadastroCurso.dispose();
				dispose(); 
			}
		});
		btnCancelar.setBounds(21, 249, 92, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				limparCampos();
			}
		});
		btnLimpar.setBounds(123, 249, 81, 23);
		contentPane.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cadastrarCurso();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnSalvar.setBounds(227, 249, 75, 23);
		contentPane.add(btnSalvar);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(54, 55, 207, 20);
		contentPane.add(textFieldNome);
		
		textFieldDia_semana = new JTextField();
		textFieldDia_semana.setBounds(101, 106, 160, 20);
		contentPane.add(textFieldDia_semana);
		textFieldDia_semana.setColumns(10);
		
		textFieldHorario = new JTextField();
		textFieldHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		textFieldHorario.setBounds(55, 148, 206, 20);
		contentPane.add(textFieldHorario);
		textFieldHorario.setColumns(10);
		
		

		
		JLabel lblCadastrarCurso = new JLabel("Cadastrar Curso");
		lblCadastrarCurso.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblCadastrarCurso.setBounds(54, 11, 160, 23);
		contentPane.add(lblCadastrarCurso);
		
		final JLabel lblNewLabelIMG = new JLabel("");
		lblNewLabelIMG.setBounds(292, 19, 175, 192);
		contentPane.add(lblNewLabelIMG);
		
		JButton btnEscolher = new JButton("escolher");
		btnEscolher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				escolherArquivos();
				
			}
			public File[] escolherArquivos() {
				File[] arquivos = null;
				JFileChooser fc = new JFileChooser();
				FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter(
						"IMAGENS", "jpg", "png", "gif");
				fc.setFileFilter(filtroImagen);
				fc.setDialogTitle("Escolha a imagem");
				fc.setDialogType(JFileChooser.OPEN_DIALOG);
				fc.setApproveButtonText("OK");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.setMultiSelectionEnabled(true);
				int resultado = fc.showOpenDialog(fc);
				if (resultado == JFileChooser.CANCEL_OPTION) {

					fc.disable();

					// System.exit(1);
				}
				arquivos = fc.getSelectedFiles();
				for (File f : arquivos) {
					System.out.println("NOME: " + f.getName());
					String caminho;
					System.out.println(caminho = f.getAbsolutePath());
					System.out.println(caminho);
					System.out.println(f.length());
					if (f.length() > 500000) {
						JOptionPane
								.showMessageDialog(null,
										"Erro Escolha um arquivo menor Tamanho Maximo permitido 5 KB");
					}
					String nomeArquivo = f.getName();

					 System.out.println(caminho.replace('\\', '/'));

					 caminho2 = caminho.replace('\\', '/');


					lblNewLabelIMG.setIcon(new ImageIcon(caminho2));

				}
				return arquivos;
			}
		});

		
		btnEscolher.setBounds(350, 222, 89, 23);
		contentPane.add(btnEscolher);
	}
	
	private void limparCampos() {
		textFieldNome.setText("");
		textFieldDia_semana.setText("");
		textFieldHorario.setText("");
	
			
	}
	
	private void cadastrarCurso() throws Exception {
		
		String nome = textFieldNome.getText().toUpperCase();
		String dia_semana = textFieldDia_semana.getText();
		String horario = textFieldHorario.getText();
		String imagem = caminho2;
		// ver aq 
		Curso curso = new Curso(nome, dia_semana, horario, imagem);
		try {
			
			Fachada.getInstance().cursoCadastrar(curso);
			
			JOptionPane.showMessageDialog(frmCadastroCurso, "Cadastro Realizado com sucesso!");
			this.limparCampos();
		
		}catch (CursoJaCadastradoException e){
			JOptionPane.showMessageDialog(frmCadastroCurso, e.getMessage(), " ERRO ", JOptionPane.ERROR_MESSAGE);
		} catch (Escola.Curso.CampoObrigatorioException e) {
			JOptionPane.showMessageDialog(frmCadastroCurso, e.getMessage(), " ERRO " , JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frmCadastroCurso, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e){
			JOptionPane.showMessageDialog(frmCadastroCurso, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		} 
			
	}
}
		
	

