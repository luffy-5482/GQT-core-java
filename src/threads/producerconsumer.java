package threads;


class producer extends Thread {
	queue a;
	public producer(queue q) {
		a=q;
	}
	public void run() {
		int i=1;
		while(true) {
			a.produce(i++);
		}
	}
}
class consumer extends Thread {
	queue b;
	public consumer(queue q) {
		b=q;
	}
	public void run() {
		int i=1;
		while(true) {
			b.consume(i++);
		}
	}
}
class queue{
	int x;
	public void produce(int i) {
		x=i;
		System.out.println("producer has produced the data :"+x);
	}
	public void consume(int i) {
		System.out.println("the consumer has consumed th data :"+x);
	}
}
public class producerconsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		queue queue=new queue();
		(new producer(queue)).start();
		(new consumer(queue)).start();
		
	}

}
