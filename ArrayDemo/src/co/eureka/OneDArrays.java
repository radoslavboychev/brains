package co.eureka;

public class OneDArrays {

	public static void main(String[] args) {
		// Single Value Container
		
		int state1PopulationCount = 502;
		int state2PopulationCount = 765;
		int state3PopulationCount = 987;
		int state4PopulationCount = 456;
		int state5PopulationCount = 876;
	
		// Multi Value Container
		
		//int[] countryPopulation = new int[5];
		
		int[] countryPopulation = {502,765,987,456,876};
		
		System.out.println("countryPopulation is: " +countryPopulation);
		
		//Read single element in array
		
		System.out.println("countryPopulation[0] is: " + countryPopulation[0]);
		System.out.println("countryPopulation[1] is: " + countryPopulation[1]);
		
		//Read all
		
		for(int i=0;i<countryPopulation.length;i++)
		{
			System.out.println("countryPopulation[" +i+ "] is: "+countryPopulation[i]);
		}
		
		//Update operation
		
		countryPopulation[0] = 502;
		countryPopulation[1] = 765;
		countryPopulation[2] = 987;
		countryPopulation[3] = 456;
		countryPopulation[4] = 876;
		
		//Print all again
		
		for(int i=0; i<countryPopulation.length; i++)
		{
			System.out.println("the country population of " + i + " is " + countryPopulation[i]);
		}

	
	}
		

}
