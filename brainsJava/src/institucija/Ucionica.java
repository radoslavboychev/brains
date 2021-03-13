package institucija;

public class Ucionica {

	protected String oznaka, tip;
	protected int brMesta;
	protected double povrsina;

	public Ucionica(String oznaka, String tip, int brMesta, double povrsina) {
		this.oznaka = oznaka;
		this.tip = tip;
		this.brMesta = brMesta;
		this.povrsina = povrsina;
	}

	public String oznaka() {
		return oznaka;
	}

	public String tip() {
		return tip;
	}

	public int brMesta() {
		return brMesta;
	}

	public double povrsina() {
		return povrsina;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public void setBrMesta(int brMesta) {
		this.brMesta = brMesta;
	}

	public void setPovrsina(double povrsina) {
		this.povrsina = povrsina;
	}

	public String toString() {
		return oznaka + "(" + tip + "), broj mesta: " + brMesta + ", povrsina: " + povrsina + " m2";
	}
}