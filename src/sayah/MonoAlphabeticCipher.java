package sayah;

public class MonoAlphabeticCipher implements Cipher {

	private String secretAlphabet;
	private String alphabet=("abcdefghijklmnopqrstuvwxyz");

	public MonoAlphabeticCipher() {

	}

	public String getSecretAlphabet() {
		return null;

	}

	protected void setSecretAlphabet(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}

	@Override
	public String encrypt(String text) {
		boolean tf = false;
		String encrypted = "";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			tf = false;
			for (int j = 0; j < this.alphabet.length(); j++) {
				if (text.charAt(i) == alphabet.charAt(j)) {
					encrypted = encrypted + this.secretAlphabet.charAt(j);
					tf = true;
				}
			}
			if(tf == false){
				encrypted = encrypted + text.charAt(i);
			}
		}
		return encrypted;
	}

	public String decrypt(String text) {
		boolean tf = false;
		String decrypted="";
		text = text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {
			tf=false;
			for (int j = 0; j < this.secretAlphabet.length(); j++) {
				if (text.charAt(i) == secretAlphabet.charAt(j)) {
					decrypted = decrypted + this.alphabet.charAt(j);
					tf=true;
				}
			}
			if(tf==false){
				decrypted += text.charAt(i);
			}
		}
		
		
		return decrypted;
	}
	public static void main(String[] args) {
		MonoAlphabeticCipher a=new MonoAlphabeticCipher();
		a.setSecretAlphabet("sdfghjklayxcvbnmqwertzuiop");
		System.out.println(a.encrypt("Hallo mein Freund?!;"));
		System.out.println(a.decrypt(a.encrypt("Hallo mein Freund?;!")));
	}
}
