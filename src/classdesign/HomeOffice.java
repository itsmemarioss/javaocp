package classdesign;

interface House {
	public default String getAddress(){
		return "101 Main Str";
	}
}

interface Office {
	public default String getAddress(){
		return "101 Smart Str";
	}
}

class HomeOffice implements House, Office {
	public String getAddress(){ 
		return "R No 1, Home";
	}
}