package zoo;

import java.util.*;

public class VirtualZoo {
	String name;
	private Map<String, Animal> map = new HashMap<String, Animal>();
	
	public VirtualZoo(String n) {
	      name = n;
	   }
	
	public void print() {
		for (String x : map.keySet()) {
			System.out.println(x + ": " + map.get(x).toString());
		}
	}
	
	public void fastForward(double years) {
		for (String x : map.keySet()) {
			map.get(x).grow(years);
		}
	}

	public void addAnimal(String n, String species, String department, double age, double growthRate) {
		map.put(n, new Animal(species, department, age, growthRate));
	}

	public static void main(String[] args) {
		
		VirtualZoo test = new VirtualZoo("Tester Zoo");
		String name = "";
		while (!name.equals("0")) {
			Scanner input = new Scanner(System.in);
			System.out.print("Name (0 to quit): ");
			name = input.nextLine();
			if (!name.equals("0")) {
				System.out.print("Species: ");
				String s = input.nextLine();
				System.out.print("Department: ");
				String d = input.nextLine();
				System.out.print("Age: ");
				double a = input.nextDouble();
				System.out.print("Growth Rate: ");
				double g = input.nextDouble();
				test.addAnimal(name, s, d, a, g);
			}
			System.out.println();
		}

		test.print();
		test.fastForward(20.0);
		test.print();
	}
}
