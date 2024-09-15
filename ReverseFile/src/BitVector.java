

public class BitVector {

	private boolean[] data;
	private int size;
	
	public BitVector() {
		data = new boolean[1];
		size = 0;
	}
	
	public boolean add(boolean bit) {
		if(size >= data.length) {
			boolean[] data2 = new boolean[data.length*2];
			for(int i=0; i<size; i++) {
				data2[i] = data[i];
			}
			data = data2;
		}
		data[size++] = bit;
		return true;
	}
	
	public boolean remove(int i) {
		boolean result = data[i];
		for(int j=i; j<size-1; j++) {
			data[j]=data[j+1];
		}
		data[size--] = false;
		return result;
	}
	
	public boolean remove(boolean bit) {
		for(int i=0; i<size; i++) {
			if(bit == (data[i])) {
				remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean set(int i, boolean bit) {
		boolean result = data[i];
		data[i] = bit;
		return result;
	}
	
	public boolean get(int i) {
		return data[i];
	}
	
	public String toString() {
		if(size == 0) {
			return "[]";
		} 
		String result = "[ " + data[0];
		for(int i=1; i<size; i++) {
			result += ", " + data[i];
		}
		result += " ]";
		return result;
	}
	
	public static void main(String[] args) {
		
	}
	
}