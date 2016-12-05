package trabredes2;

import java.util.Random;

/**
 * Classe respons�vel por gerenciar aspectos relacionados a qualquer mensagem
 */
public class MessageManager {
	
	/**
	 * M�todo que gera uma mensagem a partir do tamanho definido
	 * Utiliza a seed do parametro para gerar numeros pseudo aleat�rios
	 * @param tamanho
	 * @param seed
	 * @return mensagem gerada
	 */
	public static Integer[] geraMensagem(int tamanho, long seed) {
		Random gerador = new Random(seed);
        Integer[] msg = new Integer[tamanho*8];
        for(int i=0; i<msg.length ; i++){
            msg[i] = gerador.nextInt(100) > 50 ? 1 : 0;
        }
        gerador.nextInt();
//        Util.imprimeVetor(msg);
		return msg;
	}
	
	/**
	 * M�todo que retorna uma mensagem que cont�m bits alterados da mensagem original recebida
	 * @param msg
	 * @param probabilidade
	 * @param seed
	 * @return mensagem com erros
	 */
	public static Integer[] insereErro(Integer[] msg ,double probabilidade,long seed){
		Random gerador = new Random(seed);
		int contagemErros = 0;
		Integer[] msgComErros = new Integer[msg.length];
		while(contagemErros<=0){
			for(int i=0;i<msg.length;i++){
				double randomDouble = gerador.nextDouble();
				if(randomDouble<=probabilidade){
					msgComErros[i] = msg[i]==0?1:0;
					contagemErros++;
				}
				else{
					msgComErros[i] = msg[i];
				}
			}
		}
		//System.out.print("MSG: ");Util.imprimeVetor(msg);
		//System.out.print("MSG com Erros: ");Util.imprimeVetor(msgComErros);
		//System.out.println(msgComErros.length-msg.length);
		return msgComErros;
	}

	/**
	 * M�todo que compara dois vetores de inteiro
	 * @param vet1
	 * @param vet2
	 * @return
	 */
	public static boolean comparaVetor(Integer[] vet1, Integer[] vet2) {

		for(int i=0;i<vet1.length;i++){
			if(vet1[i] != vet2[i]){
				return false;
			}
		}
		return true;
	}
	
}