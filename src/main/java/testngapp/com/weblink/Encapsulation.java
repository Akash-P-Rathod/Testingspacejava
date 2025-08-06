package testngapp.com.weblink;

public class Encapsulation {

	private String name; // private variable, direct access नहीं

	public void setName(String n) {
		name=n;
		
	}
	public String getName() {
		return name;
	}

public static void main(String args[]) {
	Encapsulation obj=new Encapsulation();
	obj.setName("Akash");
	System.out.println("Student Name Is "+ obj.getName());
}

}
//🧠समझिए:
//private variable को class के बाहर से सीधे access नहीं कर सकते।
//
//setName() और getName() method की मदद से data access किया जाता है।
//
//यह तरीका data security और control देता है।