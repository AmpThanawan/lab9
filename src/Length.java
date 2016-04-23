

public enum Length implements Unit{
	
	METER("Meter",1.0),
	FOOT("Foot",0.3048),
	CENTIMETER("Centimeter",0.01),
	KILOMETER("kilometer",1000.0),
	MILE("Mile",1609.344),
	WA("Wa",2.0);

	public final String name ;
	public final double value;

	Length(String name , double value){
		this.name = name ;
		this.value = value ;
	}

	public double getValue(){ 
		return value; }




}
