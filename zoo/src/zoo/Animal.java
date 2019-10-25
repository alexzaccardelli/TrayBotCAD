package zoo;

public class Animal {
	private String species, department;
	private double age, growthRate, servings;
	
	public Animal(String species, String department, double age, double growthRate) {
		this.species = species;
		this.department = department;
		this.age = age;
		this.growthRate = growthRate;
      servings = age / 2.0 + 7.0;
	}
	
	public void grow(double years) {
		age += growthRate * years;
      servings = age / 2.0 + 7.0;
	}
	
	
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
   public double getServings() {
		return servings;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public double getGrowthRate() {
		return growthRate;
	}
	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
	}

	public String toString() {
		return "[species=" + species + ", department=" + department + ", age=" + age + ", growthRate=" + growthRate + ", servings=" + servings + "]";
	}
	
	
	
}
