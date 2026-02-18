package carte;

public abstract class Probleme extends Carte {

	private Type type;
	
	protected Probleme(Type type) {
		type = this.type;
	}

	public Type getType() {
		return type;
	}
	
}
