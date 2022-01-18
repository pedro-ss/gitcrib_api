package br.com.gitcrib.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordEncoder {
	
	public static String criptografarSenha(String senha) {
		Argon2 argon2 = Argon2Factory.create(
				Argon2Factory.Argon2Types.ARGON2i, 32, 64);
		Integer iterations = 22;
		Integer memory = 65536;
		Integer parallelism = 1;
		char[] password = senha.toCharArray();
		String hash = argon2.hash(iterations, memory, parallelism, password);
		
		return hash;
	}
	
	public static boolean verificacaoSenha(String hash, String senha) {
 		Argon2 argon2 = Argon2Factory.create(
				Argon2Factory.Argon2Types.ARGON2i, 32, 64);
		return argon2.verify(hash, senha.toCharArray());
	} 
}
