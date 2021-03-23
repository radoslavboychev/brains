package restaurant;

public class Item {


	//variables
	private String type;
	private String name;
	private float price;

	// constructor
	public Item(String name, float price, String type) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
	}

	// default constructor
	public Item() {

	}

	// getters & setters


	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
//
//	//load info from file
//	@Override
//	public void loadFromFile(BufferedReader br) {
//		
//		try {
//			setName(br.readLine());
//			setPrice(br.read());
//			setType(br.readLine());
//			
//		} catch (IOException e) {
//			System.out.println("An error has occurred!");
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//	@Override
//	public void writeToFile(BufferedWriter bw) {
//		// TODO Auto-generated method stub
//		
//	}

}
