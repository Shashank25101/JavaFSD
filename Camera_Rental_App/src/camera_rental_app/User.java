package camera_rental_app;

class User {
	 private String username;
	 private String password;
	 private double wallet;

	 // Defining the constructor
	 public User(String username, String password, double wallet) {
	     this.username = username;
	     this.password = password;
	     this.wallet = wallet;
	 }

	 public String getUsername() {
	     return username;
	 }

	 public String getPassword() {
	     return password;
	 }

	 public double getWallet() {
	     return wallet;
	 }

	 public void setWallet(double wallet) {
	     this.wallet = wallet;
	 }
}

