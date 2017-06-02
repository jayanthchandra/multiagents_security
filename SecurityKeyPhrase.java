class SecurityKeyPhrase{
	 String PublicKey
	 String PrivateKey

	SecurityKeyPhrase(){
		SecurityKeyGen xx = new SecurityKeyGen()
		PublicKey = xx.getpublicKey()
		PrivateKey = xx.getPrivateKey()
	}

}

class SecurityKeyGen{

// Implement your Encryption Logic

}
