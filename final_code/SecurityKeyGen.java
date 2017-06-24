/* Code for Generating key Pair */
import java.io.*;
import java.security.*;
import java.security.spec.*;


public class SecurityKeyGen {
String pr,pb;
 

 public static void main(String args[]) {
  SecurityKeyGen obj = new SecurityKeyGen();
  try {


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

  pb=getHexString(pub.getEncoded());
  System.out.println("Public Key: " +pb);   // to check

  PrivateKey priv = keyPair.getPrivate();

  pr=getHexString(priv.getEncoded());
  System.out.println("Private Key: " +pr); // to check
 }

 private String getHexString(byte[] b) {
  String result = "";
  for (int i = 0; i < b.length; i++) {
   result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
  }
  return result;
 }

public String getPublicKey(){
return pb;}
public String getPrivateKey(){
 return pr;}

  
}