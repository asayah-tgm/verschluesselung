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
		char c;
		String encrypted = "";
		text.toLowerCase();
		for (int i = 0; i < text.length(); i++) {

			for (int j = 0; j < this.alphabet.length(); j++) {
				if (text.charAt(i) == alphabet.charAt(j)) {
					encrypted = encrypted + this.secretAlphabet.charAt(j);
				

				}
			}
		}
		return encrypted;
	}

	public String decrypt(String text) {
		char c;
		String decrypted="";
		for (int i = 0; i < text.length(); i++) {
			c = text.charAt(i);
			for (int j = 0; j < this.alphabet.length(); j++) {
				if (text.charAt(i) == alphabet.charAt(j)) {
					decrypted = decrypted + this.alphabet.charAt(j);
				} else {
					if (j == alphabet.length() - 1) {
						decrypted = decrypted + text.charAt(i);
					}

				}
			}
		}
		
		
		return decrypted;
	}
	public static void main(String[] args) {
		MonoAlphabeticCipher a=new MonoAlphabeticCipher();
		a.setSecretAlphabet("sdfghjklayxcvbnmqwertzuiop");
		System.out.println(a.encrypt("Hallo"));
		System.out.println(a.decrypt("Haalllloo"));
	}
}
