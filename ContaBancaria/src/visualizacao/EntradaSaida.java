package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


public class EntradaSaida {
	
	public static int solicitaOpcao() {
		
		String[] opcoes = {"Acessar Conta Poupança","Acessar Conta Corrente",
				"Informações","sair do programa"};
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null,menu, "Selecione a opção desejada",
				JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
		
	}
	public static String solicitaTitularDaConta() {
			String titular = JOptionPane.showInputDialog("Informe o nome do titular da conta?");
		return titular;
	}
	public static int solicitaMovimentacao() {
		String[] opcoes = {"Sacar","Depositar"};
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null,menu, "Selecione a movimentação desejada",
				JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}
	public static String solicitaData() {
		String data = JOptionPane.showInputDialog("Informe a data da movimentação Ex:(##/##/####)");
		return data;
	}
	
	public static int solicitarInformacoesDeposito() {
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor que deseja depositar"));
		return valor;
	}
	public static int solicitarInformacoesSaque() {
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor que deseja sacar"));
		if (valor <=0) {
			JOptionPane.showMessageDialog(null, "Não é possivel depositar ou sacar valores negativos!");
			System.out.println();
		}
		return valor;
	}
	public static void exibirSaldo(int saldo) {
		JOptionPane.showMessageDialog(null, "Saldo Atual: "+ saldo);
	}
	public static void exibirDadosDaConta(String dadosConta) {
		JOptionPane.showMessageDialog(null, "DADOS BANCARIOS\n"+dadosConta);
	}
	public static int solicitaTipoExtrato() {
		String[] opcoes = {"Extrato Total","Extrato de Depositos","Extrato de Saques"};
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null,menu, "Selecione a movimentação desejada",
				JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}
	public static void exibirExtratoCompleto(String extrato) {
		JOptionPane.showMessageDialog(null, extrato);
	}
	public static void exibirExtradoDeDepositos(String extrato) {
		JOptionPane.showMessageDialog(null, extrato);
	}
	public static void exibirExtratoDeSaque(String extrato) {
		JOptionPane.showMessageDialog(null, extrato);
	}
	
	
}
