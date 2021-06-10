package elektronskoPoslovanje;

public abstract class Prodavnica {

	protected SpisakKlijenata spisakKlijenata;
	protected Zaposleni[] spisakZaposlenih;
	private float stanjeRacuna;
	
	Prodavnica() {}
	
	Prodavnica(int maxBrojKlijenata){
		this.spisakKlijenata = new SpisakKlijenata(maxBrojKlijenata);
	}
	
	public float getStanjeRacuna() {
		return stanjeRacuna;
	}

	public void setStanjeRacuna(float stanjeRacuna) {
		this.stanjeRacuna = stanjeRacuna;
	}

	public void izracunajPDV() {
		System.out.println("Stopa PDV je 20%!");
	}
	
	public abstract String[] uzmiIzInventara();
	
	public abstract void nabaviInventar(String artikal);
	
}
