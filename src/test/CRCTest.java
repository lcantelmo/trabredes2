package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import trabredes2.CRC;



/**
 * Classe que realiza testes no cálculo do CRC
 * Para sua execução, é necessário que o projeto tenha junit 4 for como biblioteca
 */
public class CRCTest {

	//testes baseados nos resultados obtidos no site: http://www.sunshine2k.de/coding/javascript/crc/crc_js.html
	
	@Test
	public void startsWithOneTest() {
		//polinomio 10010101
		final Integer[] vetor = {1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0};//B5AE
		String polinomio = "1DE";
		CRC crc = new CRC(polinomio);		
		assertEquals("[1, 1, 1, 0, 1, 0, 1, 0]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void startsWithZeroTest() {
		//polinomio 10010101
		final Integer[] vetor = {0,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0};//35AE
		String polinomio = "1DE";
		CRC crc = new CRC(polinomio);		
		assertEquals("[0, 0, 1, 0, 0, 1, 1, 0]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void AllOneTest() {
		final Integer[] vetor = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};//FFFF
		String polinomio = "1DE";
		CRC crc = new CRC(polinomio);		
		assertEquals("[1, 1, 0, 0, 0, 0, 1, 0]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void AllZeroTest() {
		final Integer[] vetor = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//B5AE
		String polinomio = "1DE";
		CRC crc = new CRC(polinomio);		
		assertEquals("[0, 0, 0, 0, 0, 0, 0, 0]",Arrays.toString(crc.executa(vetor)));
	}
	
	@Test
	public void FalsoPositivoTest() {
		final Integer[] vetor = {0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0};//248830
		String polinomio = "1DE"; //111011110
		CRC crc = new CRC(polinomio);		
		assertEquals("[0, 1, 1, 0, 1, 1, 1, 0]",Arrays.toString(crc.executa(vetor)));
	}
}