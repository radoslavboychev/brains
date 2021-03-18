package bankApp;

public class Computer {

	private float state;
	private boolean active;
	private String currency;
	
	
	
	
	
	public Computer(float state, boolean active, String currency) {
		super();
		this.state = state;
		this.active = active;
		this.currency = currency;
	}
	public float getState() {
		return state;
	}
	public void setState(float state) {
		this.state = state;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	
}
