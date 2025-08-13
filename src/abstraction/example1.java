package abstraction;

abstract class plane{
	abstract void takeoff() ;
	void fly() {
		System.out.println("plane fly");
	}
	void lands() {
		System.out.println("plane lands");
	}
}
class cargoplane extends plane{
	void takeoff() {
		System.out.println("Cargo plane needs long runway to takeoff ");
	}
	void fly() {
		System.out.println("cargo plane fly at low heights");
	}
	void carrygoods() {
		System.out.println("cargo plane carry goods");
	}
}
class passengerplane extends plane{
	void takeoff() {
		System.out.println("passenger plane needs medium runway to takeoff ");
	}
	void fly() {
		System.out.println("passenger plane fly at medium heights");
	}
	void carrypassengers() {
		System.out.println("passenger plane carry passengers");
	}
}
class fighterplane extends plane{
	void takeoff() {
		System.out.println("fighter plane needs short runway to takeoff ");
	}
	void fly() {
		System.out.println("fighter plane fly at reat height");
	}
	void carryweapons() {
		System.out.println("fighter plane carry weapons");
	}
}
public class example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargoplane cp=new cargoplane();
		passengerplane pp=new passengerplane();
		fighterplane fp=new fighterplane();
		plane ref;
		
		ref=cp;
		ref.takeoff();
		ref.fly();
		ref.lands();
		cp.carrygoods();
		System.out.println("------------------");
		
		ref=pp;
		ref.takeoff();
		ref.fly();
		ref.lands();
		pp.carrypassengers();
		System.out.println("------------------");
		
		ref=fp;
		ref.takeoff();
		ref.fly();
		ref.lands();
		fp.carryweapons();
		
		plane plane=new plane() {

			@Override
			void takeoff() {
				// TODO Auto-generated method stub
				System.out.println("take off");
				
			}
			
		};
		plane.takeoff();
	}
}
