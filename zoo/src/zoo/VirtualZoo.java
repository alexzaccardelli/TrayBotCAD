package zoo;

import java.util.*;

public class VirtualZoo {
   String name;
   private Map<String, Animal> map;
   private List<String> graveyard;
	
   public VirtualZoo(String n) {
      map = new HashMap<String, Animal>();
      graveyard = new ArrayList<String>();
      name = n;
   }
	
   public void print() {
      System.out.println(name + ":");
      for (String x : map.keySet()) {
         System.out.println(x + ": " + map.get(x).toString());
      }
      if(graveyard.size() > 0) {
         System.out.print("R.I.P.: " + graveyard.get(0));
         for (int i = 1; i < graveyard.size(); i++)
            System.out.print(", " + graveyard.get(i));
         System.out.println();
      }
      System.out.println();
   }
	
   public void fastForward(double years) {
      Map<String, Animal> temp = new HashMap<String, Animal>();
      for (String x : map.keySet()) {
         map.get(x).grow(years);
         if(map.get(x).getAge() < 100) {
            temp.put(x, map.get(x));
         }
         else {
            graveyard.add(x);
         }
      }
      map = temp;
   }

   public void addAnimal(String n, String species, String department, double age, double growthRate) {
      if(age < 100)
         map.put(n, new Animal(species, department, age, growthRate));
      else
         graveyard.add(n);
   }
   
   public void escape(String d) {
      Map<String, Animal> temp = new HashMap<String, Animal>();
      for (String x : map.keySet()) {
         if(!map.get(x).getDepartment().equals(d)) {
            temp.put(x, map.get(x));
         }
      }
      map = temp;
   }

   public static void main(String[] args) {
   	
      VirtualZoo test = new VirtualZoo("Tester Zoo");
      test.addAnimal("Dwight", "Dog", "Mammal", 16.0, 0.3);
      test.addAnimal("Jim", "Goldfish", "Fish", 31.0, 0.5);
      test.addAnimal("Pam", "Salmon", "Fish", 19.0, 0.1);
      test.addAnimal("Michael", "Cat", "Mammal", 0.0, 0.7);
      test.addAnimal("Meredith", "Zebra", "Mammal", 120.0, 0.2);
      
   	/*String name = "";
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
   	}*/
   
      test.print();
      test.escape("Fish");
      //test.fastForward(200.0);
      test.print();
   }
}
