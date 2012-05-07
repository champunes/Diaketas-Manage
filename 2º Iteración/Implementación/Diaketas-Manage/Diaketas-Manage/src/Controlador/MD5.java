/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 ** NOMBRE CLASE: 
 *      MD5 
 * 
 * DESCRIPCION: 
 *      Genera el MD5 de un String
 * 
 * 
 * 
 * DESARROLLADO POR: 
 *      Raphael Colleau (RC) 
 * 
 * 
 * SUPERVISADO POR: 
 * 
 * 
 * HISTORIA: 
 *      000 - 4 mai 2012 - RC - Creacion y implementacion
 *      http://respawner.fr/blog/index.php?post/2008/09/03/Generation-d-un-MD5-avec-Java
 * 
 * NOTAS: 
 * 
 *
 */
public class MD5 {

    public static String encode(String password) {
        byte[] uniqueKey = password.getBytes();
        byte[] hash = null;

        try {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        } catch (NoSuchAlgorithmException e) {
            throw new Error("No MD5 support in this VM.");
        }

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            } else {
                hashString.append(hex.substring(hex.length() - 2));
            }
        }
        return hashString.toString();
    }
}
