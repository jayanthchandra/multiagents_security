import java.io.*;
//import SecurityKeyGen.java;
public class SecurityKeyPhrase{
	static String PublicKey;
    static String PrivateKey;

	private static void GetKeys(){
		SecurityKeyGen xx = new SecurityKeyGen();
		PublicKey = xx.getpublicKey();
		PrivateKey = xx.getPrivateKey();
 System.out.println("Public Key: "+PublicKey);
	}
public static void main(String[] args){
    GetKeys();
   
}

}
