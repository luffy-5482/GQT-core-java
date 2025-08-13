package polymorphism;

class plane1{
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
class cargoplane1 extends plane1{
	void fly() {
		System.out.println("cargo plane fly at low heights");
	}
	void carrygoods() {
		System.out.println("cargo plane carry goods");
	}
}
class passengerplane1 extends plane1{
	void fly() {
		System.out.println("passenger plane fly at medium heights");
	}
	void carrypassengers() {
		System.out.println("passenger plane carry passengers");
	}
}
class fighterplane1 extends plane1{
	void fly() {
		System.out.println("fighter plane fly at reat height");
	}
	void carryweapons() {
		System.out.println("fighter plane carry weapons");
	}
}
class airport{
	void permit(plane1 ref) {
		ref.takeoff();
		ref.fly();
		ref.lands();
	}
}
public class example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargoplane1 cp=new cargoplane1();
		passengerplane1 pp=new passengerplane1();
		fighterplane1 fp=new fighterplane1();
		airport ap=new airport();
		
		ap.permit(cp);
		cp.carrygoods();
		System.out.println("------------------");
		
		ap.permit(pp);
		pp.carrypassengers();
		System.out.println("------------------");
		ap.permit(fp);
		fp.carryweapons();
	}
}
