
import java.io.*;

import java.security.*;

import java.security.spec.*;


public class MakeKeys {
	
	String pri1,pub1;

	public static void main(String[] args) {
		
  MakeKeys MakeKeys = new MakeKeys();
  try {
   String path = "C://Users/trish/Desktop/trun";
   KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
   keyGen.initialize(512); 
   KeyPair g_keypair = keyGen.genKeyPair();
   System.out.println("The generated key pair:");
   MakeKeys.dump_kp(g_keypair);
   //MakeKeys.save_kp(path, g_keypair);
   //KeyPair l_keypair = MakeKeys.LoadKeyPair(path, "DSA");
   //System.out.println("Key Pair Loaded into file");
   //MakeKeys.dump_kp(l_keypair);
  } 
  catch (Exception e) {
   e.printStackTrace();
   return;
  }
 }
 private void dump_kp(KeyPair keyPair) {
  PublicKey pub = keyPair.getPublic();
  //System.out.println("Public Key: " + get_hex(pub.getEncoded()));
  pub1=get_hex(pub.getEncoded());
  System.out.println("Public Key: "+pub1);   // to check
  PrivateKey priv = keyPair.getPrivate();
  //System.out.println("Private Key: " + get_hex(priv.getEncoded()));
  pri1=get_hex(priv.getEncoded());
  System.out.println("Private Key: "+pri1); // to check
 }

 private String get_hex(byte[] b) {
  String result = "";
  for (int i = 0; i < b.length; i++) {
   result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
  }
  return result;
 }

 /*public void save_kp(String path, KeyPair keyPair) throws IOException {
  PrivateKey privateKey = keyPair.getPrivate();
  PublicKey publicKey = keyPair.getPublic();
  // Store Public Key.
  X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
    publicKey.getEncoded());
  FileOutputStream fos = new FileOutputStream(path + "/public.key");
  fos.write(x509EncodedKeySpec.getEncoded());
  fos.close();
  // Store Private Key.
  PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
    privateKey.getEncoded());
  fos = new FileOutputStream(path + "/private.key");
  fos.write(pkcs8EncodedKeySpec.getEncoded());
  fos.close();
 }

 public KeyPair LoadKeyPair(String path, String algorithm)
   throws IOException, NoSuchAlgorithmException,
   InvalidKeySpecException {
  // Read Public Key.
  File filePublicKey = new File(path + "/public.key");
  FileInputStream fis = new FileInputStream(path + "/public.key");
  byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
  fis.read(encodedPublicKey);
  fis.close();
  // Read Private Key.
  File filePrivateKey = new File(path + "/private.key");
  fis = new FileInputStream(path + "/private.key");
  byte[] encodedPrivateKey = new byte[(int) filePrivateKey.length()];
  fis.read(encodedPrivateKey);
  fis.close();
  // Generate KeyPair.
  KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
  X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
    encodedPublicKey);
  PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
  PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
    encodedPrivateKey);
  PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
  return new KeyPair(publicKey, privateKey);
 }*/
}