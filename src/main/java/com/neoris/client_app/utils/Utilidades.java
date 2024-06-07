package com.neoris.client_app.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static org.apache.commons.codec.binary.Base64.encodeBase64;

public class Utilidades {
    /*
     * Cifra la cadena de texto proporcionada
     * y el texto que se desea cifrar
     * @param modoCifrado: El modo de cifraoo a utilizar
     * @param algoritmo: El tipo de algoritmo a utilizar
     * @param key: La llave  a utilizar
     * @param iv: El vector de inicialización a utilizar
     * @param texto: La cadena de texto a encriptar
     * @return el texto cifrado en modo String
     */
    public static String encriptar(String cifrado, String algoritmo, String key, String iv, String texto) throws Exception {
        Cipher cipher = Cipher.getInstance(cifrado);
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), algoritmo);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(texto.getBytes());
        return new String( encodeBase64(encrypted));
    }
}
