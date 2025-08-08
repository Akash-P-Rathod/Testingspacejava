package testngapp.com.weblink;

public class Animal {
	 
    private String name;
    private int age;
    private String species; 

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getAge() {
		return age;
	}
    public void setspecies(String species) {
    	this.setSpecies(species);
    	
    }

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	
}