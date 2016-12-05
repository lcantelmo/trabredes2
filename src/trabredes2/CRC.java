package trabredes2;

public class CRC {

	Integer[] polinomio;

	/**
	 * Construtor do CRC que recebe seu atributo polinomio como parâmetro
	 * @param polinomio
	 */
	public CRC(String polinomio) {
		Integer[] temp = Util.hexToBinary(polinomio);
		this.polinomio = temp;
	}

	
	/**
	 * Função que calcula o CRC a partir de uma mensagem representada por um vetor de inteiros que representam bits
	 * @param msg
	 * @return crc da mensagem calculada
	 */
	public Integer[] executa(Integer[] msg) {
		int tamMsg = msg.length;
		Integer[] crc = new Integer[8];
		Integer[] msgMultiplicada = new Integer[tamMsg + crc.length];
		boolean msg0 = msgnula(msg);

		// método equivalente a multiplicação de polinômios pelo tamanho do
		// polinômio gerador
		for (int i = 0; i < tamMsg; i++) {
			msgMultiplicada[i] = msg[i];
		}
		//Util.imprimeVetor(msgMultiplicada);
		// padding
		for (int i = tamMsg ; i < (tamMsg + crc.length); i++) {
			msgMultiplicada[i] = 0;
		}
		int ponto1 = 0;
		int j = 0;
		if (!msg0) {
			while (msgMultiplicada[ponto1] != 1) {
				ponto1++;
			}
			while (ponto1 <= msgMultiplicada.length - polinomio.length && !msg0) {
				// posicionamento da variável ponto1 no primeiro índice 1 da
				// mensagem
				j = 0;				
				// realização do xOR entre o polinomio gerador e a mensagem
				for (int i = ponto1; i < ponto1 + polinomio.length; i++) {
					msgMultiplicada[i] = getxOR(msgMultiplicada[i], j);
					j++;
				}
				msg0 = msgnula(msgMultiplicada);
				while (msgMultiplicada[ponto1] != 1 && !msg0) {
					ponto1++;
				}
			}
		}

		j = 0;
		// crc pega os últimos 8 bits da mensagemMultilplicada
		for (int i = msgMultiplicada.length - crc.length; i < msgMultiplicada.length; i++) {
			crc[j] = msgMultiplicada[i];
			j++;
		}
		return crc;
	}
	
	/**
	 * Método que verifica se uma mensagem contém apenas 0s ou não
	 * @param msg
	 * @return true se mensagem contém apenas 0s 
	 * false se mensagem contém 1s
	 */
	private boolean msgnula(Integer[] msg) {
		for (int i = 0; i < msg.length; i++) {
			if (msg[i] != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Método que realiza xOR entre bits
	 * @param msgMultiplicadaIndex
	 * @param i
	 * @return valor do xOR entre um bit da mensagem e um bit do polinomio 
	 */
	private Integer getxOR(Integer msgIndex, int i) {
		Integer xORResult = msgIndex == polinomio[i] ? 0 : 1;
		return xORResult;

	}
}