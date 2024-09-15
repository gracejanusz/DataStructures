import java.util.Comparator;

public class SortbyName implements Comparator<College> {

	@Override
	public int compare(College o1, College o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
