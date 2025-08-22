package threads;

public class thread1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread());
		Thread t1=new Thread();
		System.out.println(t1);
		t1.setName("luffy");
		t1.setPriority(2);
		System.out.println(t1);
		System.out.println(t1.getName());
		System.out.println(t1.getPriority());
	}

}
