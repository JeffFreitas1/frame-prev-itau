package br.com.cardif.databaseutils;

public enum DatabaseName {

	CARDIF ("dbprodlife"),
	GARANTIAS ("dbgarantias"),
	LUIZA ("dbluizaseg"),
	BVP ("dbbvp");
	
	private String name;
	
	private DatabaseName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
