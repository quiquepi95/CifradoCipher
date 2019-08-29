package asimetrico;

import javax.crypto.*; 
import java.security.*;
public class CifradoAsimetrico {
	public static void main(String[] args) {
		try { //Obteniendo generador de claves con cifrado RSA
			System.out.println("Obteniendo generador de claves con cifrado RSA");
			KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");
			
			System.out.println("Generando clave");
			KeyPair keypair = keygen.generateKeyPair(); //Generando par de claves
			Cipher rsaCipher = Cipher.getInstance("RSA"); //Obteniendo objeto Cipher RSA
			
			// PublicKey clavePublicaAEnviar = keypair.getPublic(); // Esto es lo que tendría que enviar al cliente
			
			//Configurar Cipher para encriptar con clave privada
			rsaCipher.init(Cipher.ENCRYPT_MODE, keypair.getPrivate());
			
			String mensaje = "Mensaje de prueba del cifrado asimétrico";
			System.out.println("Mensaje Original: "+ mensaje);
			System.out.println("Cifrando el mensaje");
			byte[] bitcodificado = rsaCipher.doFinal(mensaje.getBytes());
			String mensajeCifrado = new String(bitcodificado);
			
			System.out.println("Mensaje cifrado: " + mensajeCifrado);
			
			
			// REcibido public
			
			/*
			 * rsaCipher.init(Cipher.ENCRYPT_MODE, clavePublicaAEnviar);
			 *  generas un SecretKey SECRETO
			 *  encriptas el secretKey --> byte[] bitdescodificado = rsaCipher.doFinal(SECRETO);
			 *  SecretKey claveCifradaEncriptada = new SecretKey(bitdescodificado)
			 *  fsalida.writeObject(claveCifradaEncriptada);
			 *  
			 *  
			 */
			
			System.out.println("Configurando Cipher para desencriptar");
			//Descifrado usando la clave pública
			rsaCipher.init(Cipher.DECRYPT_MODE, keypair.getPublic());
			
			System.out.println("Descifrando mensaje");
			byte[] bitdescodificado = rsaCipher.doFinal(bitcodificado);
			String mensajeDescifrado = new String(bitdescodificado);
			
			System.out.println("Mensaje descifrado: " + mensajeDescifrado);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}
