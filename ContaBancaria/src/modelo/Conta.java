package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import visualizacao.EntradaSaida;

public class Conta {

	private String titularDaConta;
	private int tipo;
	private int saldo = 1000;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	
	public String getTitularDaConta() {
		return titularDaConta;
	}
	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}
	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}
	
	public void depositar(int tipo, String data, int valor) {
		Movimentacao contaDeposito = new Movimentacao();
		contaDeposito.setTipo(tipo);
		contaDeposito.setData(data);
		contaDeposito.setValor(valor);
		listaDeMovimentacao.add(contaDeposito);
		
		//this.saldo += contaDeposito.getValor();
	}
	public void sacar(int tipo, String data, int valor) {
		Movimentacao contaSaque = new Movimentacao();
		contaSaque.setTipo(tipo);
		contaSaque.setData(data);
		contaSaque.setValor(valor);
		listaDeMovimentacao.add(contaSaque);
		
		//this.saldo -= contaSaque.getValor();
		
	}
	public int gerarSaldo(int valor, int tipo) {
		int saldoAtual;
		if (tipo==1) {
			saldoAtual = getSaldo() - valor;
			if (saldoAtual<= -1000) {
				JOptionPane.showMessageDialog(null, "Limite do Cheque Especial atingido!");
				System.out.println();
			}else {
			}
		} else {
			saldoAtual = getSaldo() + valor;
		}

		return saldoAtual;
	}
	public String geraDadosDaConta(int tipo, String titularDaConta, int saldo){
		String conta;
		if (tipo==1) {
			conta = "Conta Poupança";
		} else {
			conta = "Conta Corrente";
		}
		String dados = ("Titular da Conta: "+titularDaConta+"\nTipo de Conta: "+conta+"\nSaldo: "+saldo);
		return dados;
	}
	public String gerarExtrato() {
		String extrato="";
		for (int i=0; i<listaDeMovimentacao.size(); i++) {
			
			Movimentacao e = listaDeMovimentacao.get(i);
			String tipoExtrato;
			String tipoMovimentado;
			if (e.getTipo()==1) {
				tipoExtrato = "Saque"; 
				tipoMovimentado = "Sacado: -";
			} else {
				tipoExtrato = "Deposito";
				tipoMovimentado = "Depositado: +";
			}
			extrato +="Extrato de "+tipoExtrato+"\nData: "+e.getData()+"\nValor "+tipoMovimentado+e.getValor()+"\n\n";
		}
		return extrato;
	}
	public void gerarExtratoDepositos() {
		String extrato="";
		for (int i=0; i<listaDeMovimentacao.size(); i++) {
			Movimentacao e = listaDeMovimentacao.get(i);
			if (e.getTipo()==2) {
				extrato +="Extrato de Deposito"+"\nData: "+e.getData()+"\nValor Depositado: "+e.getValor()+"\n\n";
			}else {	
			}
		}
		EntradaSaida.exibirExtradoDeDepositos(extrato);
	}
	public void gerarExtratoSaques() {
		String extrato="";
		for (int i=0; i<listaDeMovimentacao.size(); i++) {
			Movimentacao e = listaDeMovimentacao.get(i);
			if (e.getTipo()==1) {
				extrato +="Extrato de Saque"+"\nData: "+e.getData()+"\nValor Sacado: "+e.getValor()+"\n\n";
			}else {
			}
		}
		EntradaSaida.exibirExtratoDeSaque(extrato);
	}
}
