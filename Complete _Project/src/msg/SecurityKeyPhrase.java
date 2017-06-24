package msg;
import java.io.*;

@SuppressWarnings("unused")
public class SecurityKeyPhrase{
	static String PublicKey;
	static String PrivateKey;

	public static void GetKeys(){
		SecurityKeyGen securityKeyGen = new SecurityKeyGen();
		SecurityKeyGen.maincnew();
		PublicKey = securityKeyGen.getpublicKey();
		PrivateKey = securityKeyGen.getPrivateKey();
	}
}

