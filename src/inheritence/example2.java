package inheritence;
class plane{
	void takeoff() {
		System.out.println("plane took off");
	}
	void fly() {
		System.out.println("plane fly");
	}
	void lands() {
		System.out.println("plane lands");
	}
}
class cargoplane extends plane{
	void fly() {
		System.out.println("cargo plane fly at low heights");
	}
	void carrygoods() {
		System.out.println("cargo plane carry goods");
	}
}
class passengerplane extends plane{
	void fly() {
		System.out.println("passenger plane fly at medium heights");
	}
	void carrypassengers() {
		System.out.println("passenger plane carry passengers");
	}
}
class fighterplane extends plane{
	void fly() {
		System.out.println("fighter plane fly at reat height");
	}
	void carryweapons() {
		System.out.println("fighter plane carry weapons");
	}
}
public class example2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargoplane cp=new cargoplane();
		passengerplane pp=new passengerplane();
		fighterplane fp=new fighterplane();
		cp.takeoff();
		cp.fly();
		cp.lands();
		cp.carrygoods();
		System.out.println("------------------");
		pp.takeoff();
		pp.fly();
		pp.lands();
		pp.carrypassengers();
		System.out.println("------------------");
		fp.takeoff();
		fp.fly();
		fp.lands();
		fp.carryweapons();
	}
}
