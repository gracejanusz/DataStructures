import java.util.Comparator;

public class SortbyAcceptanceRate implements Comparator<College>{

	@Override
	public int compare(College o1, College o2) {
		// TODO Auto-generated method stub
		return (int) (o2.getAcceptanceRate()-o1.getAcceptanceRate());
	}

}
