import java.util.Comparator;

public class SortbyPopulation implements Comparator<College> {

	@Override
	public int compare(College o1, College o2) {
		return (int) (o1.getPopulation()-o2.getPopulation());
	}

}
