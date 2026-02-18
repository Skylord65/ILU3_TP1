package carte;

public enum Type {
	FEU("Feu rouge", "Feu vert", "Prioritaire"),
	CREVAISON("Crevaison", "Roue de secours", "Increvable"),
	ESSENCE("Panne d'essence", "Essence", "Citerne d'essence"),
	ACCIDENT("Accident", "Réparation", "As du volant");
	
	private String attaque;
	private String parade;
	private String botte;
	
	Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}
}
