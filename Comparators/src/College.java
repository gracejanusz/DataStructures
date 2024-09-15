
public class College {
	private double population;
	private double acceptancerate;
	private String name;
	
	public College(String name, double pop, double accept) {
		this.name = name;
		population = pop;
		acceptancerate = accept;
	}
	//return population`
	public double getPopulation() {
		return population;
	}
	//return acceptancerate
	public double getAcceptanceRate() {
		return acceptancerate;
	}
	//returns endowment
	public String getName() {
		return name;
	}

	public String toString() {
		return "Name: " + name + "\n Population: " + population + "\n Acceptance Rate: " 
	+ acceptancerate;
	}
}
