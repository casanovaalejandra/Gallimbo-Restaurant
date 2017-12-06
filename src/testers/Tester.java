package testers;
import tools.ArrayIndexList;

public class Tester<E> {
	private E[] tester1;
	
	public static void main(String[] args) {
		
		ArrayIndexList<Integer> tester = new ArrayIndexList();
		
		tester.add(1);
		tester.add(2);
		tester.add(3);
		tester.add(4);
		System.out.println(tester.capacity());
		int counter=0;
		System.out.println("");
		while(tester.hasNext()) {
			tester.remove(counter);
			counter++;
		}
		
		for(int i = 0; i<tester.capacity()-1;i++) {
			tester.remove(i);
			if(tester.hasNext()) {
				System.out.println(" The method hasNext works\n");
			}
		}
		
	}



}



