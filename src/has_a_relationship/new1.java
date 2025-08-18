package has_a_relationship;
// composition
class OS {
	String version_name;
	double version_number;
	public OS(String version_name, double version_number) {
		super();
		this.version_name = version_name;
		this.version_number = version_number;
	}
	public String getVersion_name() {
		return version_name;
	}
	public double getVersion_number() {
		return version_number;
	}
}
// Aggregation
class Charger {
	String company;
	double voltage;
	public Charger(String company, double voltage) {
		super();
		this.company = company;
		this.voltage = voltage;
	}
	public String getCompany() {
		return company;
	}
	public double getVoltage() {
	return voltage;
}
	
}
class Mobile {
	OS os = new OS("Windows",12.7);
	void hasCharger(Charger c) {
		System.out.println(c.getCompany());
		System.out.println(c.getVoltage());
	}
}
public class new1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Charger c = new Charger("HP", 5.5);
		Mobile m = new Mobile();
        
		System.out.println(m.os.getVersion_number());
		System.out.println(m.os.getVersion_name());
		m.hasCharger(c);
		
		m = null;
		//System.out.println(m.os.getVersion_number());
		//System.out.println(m.os.getVersion_name());
		
		System.out.println(c.getCompany());
		System.out.println(c.getVoltage());
	}

}