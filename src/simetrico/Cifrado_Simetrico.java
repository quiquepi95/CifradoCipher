package simetrico;

import javax.crypto.*;
public class Cifrado_Simetrico {
	public static void main(String[] args) {
		try {
			System.out.println("Obteniendo generador de claves con cifrado AES");
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			
			System.out.println("Generando clave");
			SecretKey key = keygen.generateKey();
			
			System.out.println("Obteniendo objeto Cipher con cifrado AES");
			Cipher aesCipher = Cipher.getInstance("AES");
			
			System.out.println("Configurando Cipher para encriptar");
			aesCipher.init(Cipher.ENCRYPT_MODE, key);
			
			System.out.println(" Preparando el mensaje");
			String mensaje = "Mensaje que se cifrará con AES";
			System.out.println("Mensaje Original: "+ mensaje);
			System.out.println("Cifrando el mensaje");
			byte[] bitcodificado = aesCipher.doFinal(mensaje.getBytes());
			String mensajeCifrado = new String(bitcodificado);
			
			System.out.println("El mensaje cifrado es: " +mensajeCifrado);
			System.out.println("Configurando Cipher para desencriptar");
			aesCipher.init(Cipher.DECRYPT_MODE, key);
			
			System.out.println("Descifrando mensaje");
			byte[] bitcodificado2 =aesCipher.doFinal(bitcodificado);
			String mensaje_descifrado = new String(bitcodificado2);
			
			System.out.println(" Mensaje desencriptado: " + mensaje_descifrado);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
