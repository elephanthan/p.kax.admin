package ssu.pickax.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EncryptUtil
{
  private static byte[] sharedvector = { 
    1, 2, 3, 5, 7, 11, 13, 17 };

  public static String encryptSHA256(String value)
    throws NoSuchAlgorithmException
  {
    String encryptData = "";

    MessageDigest sha = MessageDigest.getInstance("SHA-256");
    sha.update(value.getBytes());

    byte[] digest = sha.digest();
    for (int i = 0; i < digest.length; i++) {
      encryptData = encryptData + Integer.toHexString(digest[i] & 0xFF).toUpperCase();
    }

    return encryptData;
  }

  public static String encryptMD5(String RawText)
  {
    String EncText = "";
    byte[] keyArray = new byte[24];

    String key = "developersnotedotcom";
    byte[] toEncryptArray = null;
    try
    {
      toEncryptArray = RawText.getBytes("UTF-8");
      MessageDigest m = MessageDigest.getInstance("MD5");
      byte[] temporaryKey = m.digest(key.getBytes("UTF-8"));

      if (temporaryKey.length < 24)
      {
        int index = 0;
        for (int i = temporaryKey.length; i < 24; i++)
        {
          keyArray[i] = temporaryKey[index];
        }
      }

      Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
      c.init(1, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
      byte[] encrypted = c.doFinal(toEncryptArray);
      EncText = Base64.encodeBase64String(encrypted);
    }
    catch (NoSuchAlgorithmException|UnsupportedEncodingException|NoSuchPaddingException|InvalidKeyException|InvalidAlgorithmParameterException|IllegalBlockSizeException|BadPaddingException NoEx)
    {
      NoEx.printStackTrace();
    }

    return EncText;
  }

  public static String decryptMD5(String EncText)
  {
    String RawText = "";
    byte[] keyArray = new byte[24];

    String key = "developersnotedotcom";
    byte[] toEncryptArray = null;
    try
    {
      MessageDigest m = MessageDigest.getInstance("MD5");
      byte[] temporaryKey = m.digest(key.getBytes("UTF-8"));

      if (temporaryKey.length < 24)
      {
        int index = 0;
        for (int i = temporaryKey.length; i < 24; i++)
        {
          keyArray[i] = temporaryKey[index];
        }
      }

      Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
      c.init(2, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(sharedvector));
      byte[] decrypted = c.doFinal(Base64.decodeBase64(EncText));

      RawText = new String(decrypted, "UTF-8");
    }
    catch (NoSuchAlgorithmException|UnsupportedEncodingException|NoSuchPaddingException|InvalidKeyException|InvalidAlgorithmParameterException|IllegalBlockSizeException|BadPaddingException NoEx)
    {
      NoEx.printStackTrace();
    }

    return RawText;
  }
}