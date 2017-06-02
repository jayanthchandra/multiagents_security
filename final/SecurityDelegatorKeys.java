
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
public class SecurityDelegatorKeys {
 
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec myKeySpec;
    private SecretKeyFactory mySecretKeyFactory;
    private Cipher cipher;
    byte[] keyAsBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;
 
    public SecurityDelegatorKeys(String SecretPhrase) throws Exception
    {
        myEncryptionKey = "3082 014b 0201 0030 8201 2c06 072a 8648 ce38 0401 3082 011f 0281 8100 fd7f 5381 1d75 1229 52df 4a9c 2eec e4e7 f611 b752 3cef 4400 c31e 3f80 b651 2669 455d 4022 51fb 593d 8d58 fabf c5f5 ba30 f6cb 9b55 6cd7 813b 801d 346f f266 60b7 6b99 50a5 a49f 9fe8 047b 1022 c24f bba9 d7fe b7c6 1bf8 3b57 e7c6 a8a6 150f 04fb 83f6 d3c5 1ec3 0235 5413 5a16 9132 f675 f3ae 2b61 d72a eff2 2203 199d d148 01c7 0215 0097 6050 8f15 230b ccb2 92b9 82a2 eb84 0bf0 581c f502 8181 00f7 e1a0 85d6 9b3d decb bcab 5c36 b857 b979 94af bbfa 3aea 82f9 574c 0b3d 0782 6751 5957 8eba d459 4fe6 7107 1081 80b4 4916 7123 e84c 2816 13b7 cf09 328c c8a6 e13c 167a 8b54 7c8d 28e0 a3ae 1e2b b3a6 7591 6ea3 7f0b fa21 3562 f1fb 627a 0124 3bcc a4f1 bea8 5190 89a8 83df e15a e59f 0692 8b66 5e80 7b55 2564 014c 3bfe cf49 2a04 1602 1452 ac00 1d82 2f8e 2362 063b 804f 0aa9 0038 d0f4 f3";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        myKeySpec = new DESedeKeySpec(keyAsBytes);
        mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = mySecretKeyFactory.generateSecret(myKeySpec);
    }
 

    public String encrypt(String unencryptedString) {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            BASE64Encoder base64encoder = new BASE64Encoder();
            encryptedString = base64encoder.encode(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }

    public String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            BASE64Decoder base64decoder = new BASE64Decoder();
            byte[] encryptedText = base64decoder.decodeBuffer(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            decryptedText= bytes2String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }

    private static String bytes2String(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            stringBuffer.append((char) bytes[i]);
        }
        return stringBuffer.toString();
    }

 
}

