package controle;

import visualizacao.EntradaSaida;
import modelo. *;

public class Controladora {

	Conta conta = new Conta();
	Movimentacao movimentacao = new Movimentacao();
	
	public void exibeMenu(){
		
		int opcao; 
		int movimenta=0;
		do {
		conta.setTitularDaConta(EntradaSaida.solicitaTitularDaConta());
		opcao = EntradaSaida.solicitaOpcao();   			
		switch(opcao){
			case 0:
				conta.setTipo(1);
				movimenta = EntradaSaida.solicitaMovimentacao();
				switch(movimenta) { 
					case 0:
						movimentacao.setTipo(1);
						movimentacao.setData(EntradaSaida.solicitaData());
						movimentacao.setValor(EntradaSaida.solicitarInformacoesSaque());
						conta.sacar(movimentacao.getTipo(), movimentacao.getData(), movimentacao.getValor());
						int saldo = conta.gerarSaldo(movimentacao.getValor(), movimentacao.getTipo());
						conta.setSaldo(saldo);
						String dadosConta = conta.geraDadosDaConta(conta.getTipo(), conta.getTitularDaConta(), conta.getSaldo());
						EntradaSaida.exibirDadosDaConta(dadosConta);
						EntradaSaida.exibirSaldo(saldo);
					break;
					case 1:
						movimentacao.setTipo(2);
						movimentacao.setData(EntradaSaida.solicitaData());
						movimentacao.setValor(EntradaSaida.solicitarInformacoesDeposito());
						conta.depositar(movimentacao.getTipo(), movimentacao.getData(), movimentacao.getValor());
						saldo = conta.gerarSaldo(movimentacao.getValor(), movimentacao.getTipo());
						conta.setSaldo(saldo);
						dadosConta = conta.geraDadosDaConta(conta.getTipo(), conta.getTitularDaConta(), conta.getSaldo());
						EntradaSaida.exibirDadosDaConta(dadosConta);
						EntradaSaida.exibirSaldo(saldo);
					break;
				}
			break;
			case 1:
				conta.setTipo(2);
				movimenta = EntradaSaida.solicitaMovimentacao();
				switch(movimenta) { 
					case 0:
						movimentacao.setTipo(1);
						movimentacao.setData(EntradaSaida.solicitaData());
						movimentacao.setValor(EntradaSaida.solicitarInformacoesSaque());
						conta.sacar(movimentacao.getTipo(), movimentacao.getData(), movimentacao.getValor());
						int saldo = conta.gerarSaldo(movimentacao.getValor(), movimentacao.getTipo());
						conta.setSaldo(saldo);
						String dadosConta = conta.geraDadosDaConta(conta.getTipo(), conta.getTitularDaConta(), conta.getSaldo());
						EntradaSaida.exibirDadosDaConta(dadosConta);
						EntradaSaida.exibirSaldo(saldo);
					break;
					case 1:
						movimentacao.setTipo(2);
						movimentacao.setData(EntradaSaida.solicitaData());
						movimentacao.setValor(EntradaSaida.solicitarInformacoesDeposito());
						conta.depositar(movimentacao.getTipo(), movimentacao.getData(), movimentacao.getValor());
						saldo = conta.gerarSaldo(movimentacao.getValor(), movimentacao.getTipo());
						conta.setSaldo(saldo);
						dadosConta = conta.geraDadosDaConta(conta.getTipo(), conta.getTitularDaConta(), conta.getSaldo());
						EntradaSaida.exibirDadosDaConta(dadosConta);
						EntradaSaida.exibirSaldo(saldo);
					break;
					}
			break;
			case 2:
				int tipoExtrato = EntradaSaida.solicitaTipoExtrato();
				switch(tipoExtrato) {
					case 0:
						String extrato = conta.gerarExtrato();
						EntradaSaida.exibirExtratoCompleto(extrato);
					break;
					case 1:
						conta.gerarExtratoDepositos();
						
					break;
					case 2:
						conta.gerarExtratoSaques();
					break;
				}
			break;
			case 3:
			break;
		}
		}while(opcao!=3);
	}
}
