package threads;

class producer1 extends Thread {
	Queue a;

	public producer1(Queue q) {
		a = q;
	}

	public void run() {
		int i = 1;
		while (true) {
			a.produce(i++);
		}
	}
}

class consumer1 extends Thread {
	Queue b;

	public consumer1(Queue q) {
		b = q;
	}

	public void run() {
		int i = 1;
		while (true) {
			b.consume(i++);
		}
	}
}

class Queue {
	int x;
	boolean value_inside_x = false;

	synchronized void produce(int i) {
		try {
			if (value_inside_x == false) {
				x = i;
				System.out.println("producer has produced the data :" + x);
				value_inside_x = true;
				notify();
			} else {
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized void consume(int i) {
		try {
			if (value_inside_x == true) {
				System.out.println("the consumer has consumed th data :" + x);
				value_inside_x = false;
				notify();
			} else {
				wait();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

public class producerconsumersolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		(new producer1(q)).start();
		(new consumer1(q)).start();

	}

}
