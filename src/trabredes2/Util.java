package trabredes2;

public class Util {
	
	/** M�todo que imprime o vetor recebido como parametro
	 * @param vet
	 */
	public static void imprimeVetor(Integer[] vet) {
		for(int i=0;i<vet.length;i++){
			System.out.print(vet[i]);
		}
		System.out.println("");
	}
	
	
	/**
	 * M�todo que recebe uma string em hexadecimal e vetor de inteiros 
	 * equivalente ao valor binario da string que est� em hexadecimal
	 * @param hex
	 * @return vetor de inteiros
	 */
	public static Integer[] hexToBinary(String hex) {
		Integer inteiro = Integer.parseInt(hex,16);
		String bin = Integer.toBinaryString(inteiro);
		char[] arrayValores = bin.toCharArray();
		Integer[] valorInteiros = new Integer[bin.length()];
		for (int i = 0; i < arrayValores.length; i++) 
		{
			valorInteiros[i] = Integer
					.parseInt(String.valueOf(arrayValores[i]));
		}
	    return valorInteiros;
	}   
}
