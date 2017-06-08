/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Math.E;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Thusitha Dilhan
 */
public class Encryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
     File file = new File ("C:\\Users\\Dilhan\\Desktop\\aa.txt");
     //File file2 = new File ("C:\\Users\\Dilhan\\Desktop\\bb.txt");
     
     // encrypt("aaaaaaaaaaaaaaaa", file , file);
     decrypt("aaaaaaaaaaaaaaaa", file , file);
        System.out.println("Success!!!");

    }
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encrypt(String key, File inputFile, File outputFile)
        {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    public  static void decrypt(String key, File inputFile, File outputFile)
            {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }

    private static  void doCrypto(int cipherMode, String key, File inputFile,
            File outputFile)  {
        try {
             
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
             
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
          
            cipher.init(cipherMode, secretKey);
           

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
            
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException | IOException ex) {
       //  } catch (Exception ex) {   
        }
    }

    private static void encrypt(String abc123, double E) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
