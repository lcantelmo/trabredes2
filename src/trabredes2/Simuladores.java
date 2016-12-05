/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabredes2;

/**
 * Simulador que recebe como argumentos de linha de comando os seguintes valores
 * 
 * <nomeMétodo> <tampacotes gerados> <npacotes gerados> <seed> <probabilidade de inserção de erros> <polinomio gerador (opcional)>
 * (crc ou checksum)
 */
public class Simuladores {


	public static void main(String[] args)  {
		long tempoInicial = System.currentTimeMillis();
		int tamanho = Integer.parseInt(args[1]);
		double npacotes = Double.parseDouble(args[2]);
		long seed = Long.parseLong(args[3]);// Integer.parseInt(args[3]);
		double probabilidade = Double.parseDouble(args[4]);
		double contaErro = 0;
		if (args[0].equalsIgnoreCase("csum") || args[0].equalsIgnoreCase("checksum")) {
			for (int i = 0; i < npacotes; i++) {
				Integer[] msg = MessageManager.geraMensagem(tamanho, seed++);
				Integer[] checksumMensagem = Checksum.executa(msg);
				Integer[] msgErro = MessageManager.insereErro(msg, probabilidade, seed);
				Integer[] checksumMensagemErro = Checksum.executa(msgErro);
				boolean erro = MessageManager.comparaVetor(checksumMensagem, checksumMensagemErro);
				if (erro) {
					//System.out.print("Mensagem:           ");Util.imprimeVetor(msg);
					//System.out.print("Mensagem com erros: ");Util.imprimeVetor(msgErro);
					//System.out.print("Checksum Mensagens: ");Util.imprimeVetor(checksumMensagem);
					contaErro++;
				}
			}
			long tempoFinal = System.currentTimeMillis();
			System.out.println("Numero de Erros: "+ contaErro);
			System.out.println("Porcentagem de erros: " + ((contaErro / npacotes) * 100) + "%");
			System.out.println("Tempo de execução: " + (tempoFinal - tempoInicial)/1000 + " segundos\n");
		}
		if (args[0].equalsIgnoreCase("crc")) {
			CRC crc = new CRC(args[5]);
			for (int i = 0; i < npacotes; i++) {
				Integer[] msg = MessageManager.geraMensagem(tamanho, seed++);
				//Util.imprimeVetor(msg);
				Integer[] crcMensagem = crc.executa(msg);
				//Util.imprimeVetor(crcMensagem);
				Integer[] msgErro = MessageManager.insereErro(msg, probabilidade, seed);
				Integer[] crcMensagemErro = crc.executa(msgErro);
				//Util.imprimeVetor(crcMensagemErro);
				boolean erro = MessageManager.comparaVetor(crcMensagem, crcMensagemErro);
				if (erro) {
					//System.out.print("Mensagem:           ");Util.imprimeVetor(msg);
					//System.out.print("Mensagem com erros: ");Util.imprimeVetor(msgErro);
					//System.out.print("CRC Mensagens:      ");Util.imprimeVetor(crcMensagem);
					contaErro++;
				}
			}
			long tempoFinal = System.currentTimeMillis();
			System.out.println("Numero de Colisões:     "+ contaErro);
			System.out.println("Percentual de Colisões: " + ((contaErro / npacotes) * 100) + "%");
			System.out.println("Tempo de execução: " + (tempoFinal - tempoInicial)/1000 + " segundos\n");
		}

	}

}