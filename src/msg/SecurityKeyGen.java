/* Code for Generating key Pair */
package msg;
import java.io.*;
import java.security.*;
import java.security.spec.*;

@SuppressWarnings("unused")
public class SecurityKeyGen {
static String pr,pb;

 public static void maincnew() {
  SecurityKeyGen obj = new SecurityKeyGen();
  try {
   //String path = "F:/Project/rp";

   KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");

   keyGen.initialize(512);
   KeyPair generatedKeyPair = keyGen.genKeyPair();

   System.out.println("Generated Key Pair");
   obj.dumpKeyPair(generatedKeyPair);
  } catch (Exception e) {
   e.printStackTrace();
   return;
  }
 }

 private void dumpKeyPair(KeyPair keyPair) {
  PublicKey pub = keyPair.getPublic();
  //System.out.println("Public Key: " + getHexString(pub.getEncoded()));
  pb=getHexString(pub.getEncoded());


  PrivateKey priv = keyPair.getPrivate();
  //System.out.println("Private Key: " + getHexString(priv.getEncoded()));
  pr=getHexString(priv.getEncoded());
 }

 private String getHexString(byte[] b) {
  String result = "";
  for (int i = 0; i < b.length; i++) {
   result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
  }
  return result;
 }

public String getpublicKey(){
return pb;}
public String getPrivateKey(){
 return pr;}

  
}