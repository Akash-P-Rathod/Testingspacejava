package testngapp.com.weblink;

 class Class_objcet {

	 String color = "Red";
	  void display() {
		  System.out.println("Car color is: " + color);
		  
	  }
	  public static void main(String args[]) {
		  Class_objcet obj=new Class_objcet();
		  obj.display();
	  }
}

// class एक template होता है, जैसे कार का डिजाइन।

// object उस class का असल instance होता है, जैसे एक असली कार।
//
// myCar एक object है Car class का।
//
// display() method को object के ज़रिए call किया गया।