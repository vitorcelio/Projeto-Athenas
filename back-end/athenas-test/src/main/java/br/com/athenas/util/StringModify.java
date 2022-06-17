package br.com.athenas.util;

public class StringModify {
	public static Double converteDouble(String valor) {
		String novo = valor.replace(",", ".");
		return Double.parseDouble(novo);
	}
}
