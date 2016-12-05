package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import trabredes2.Checksum;

/**
 * Classe que realiza testes no cálculo do Checksum
 * Para sua execução, é necessário que o projeto tenha junit 4 for como biblioteca
 */
public class checksumtest {
	@Test
	public void startsWithOneTest() {
		
		//polinomio 10010101
		final Integer[] vetor = {1,0,1,1,0,1,0,1,1,0,1,0,1,1,1,0};//B5AE	
		assertEquals("[1, 0, 0, 1, 1, 0, 1, 1]",Arrays.toString(Checksum.executa(vetor)));
	}
	
	@Test
	public void startsWithZeroTest() {
		final Integer[] vetor = {0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,0};
		assertEquals("[1, 1, 1, 1, 1, 0, 1, 1]",Arrays.toString(Checksum.executa(vetor)));
	}
	
	@Test
	public void moreThan16BitTest() {
		final Integer[] vetor = {0,1,0,1,0,1,0,1,1,0,1,0,1,1,1,0,1,1,1,0,1,0,1,1};
		assertEquals("[0, 0, 0, 1, 0, 0, 0, 0]",Arrays.toString(Checksum.executa(vetor)));
	}
	
	@Test
	public void AllOneTest() {
		final Integer[] vetor = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};//FFFF	
		assertEquals("[0, 0, 0, 0, 0, 0, 0, 0]",Arrays.toString(Checksum.executa(vetor)));
	}
	
	@Test
	public void AllZeroTest() {
		final Integer[] vetor = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//B5AE		
		assertEquals("[1, 1, 1, 1, 1, 1, 1, 1]",Arrays.toString(Checksum.executa(vetor)));
	}
}