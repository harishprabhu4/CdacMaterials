package queueoperation;
//done without counts
public class CircularQueueusingArray {

	int queue[] = new int[5];
	int size;
	int front;
	int rear;

	public void enQueue(int data) throws Exception{

		if (!isFull()) {

			queue[rear] = data; // Inserting element in Queue at rear
			rear = (rear + 1) % 5; 
// rear pointer will increment by 1
//Circular Queue works by the process of circular increment 
//i.e. when we try to increment the pointer and we reach the end of the queue, we start from the beginning of the queue.
//Here, the circular increment is performed by modulo division with the queue size. 
//if rear + 1 == 5 (overflow!), rear = (rear + 1)%5 = 0 (start of queue)

			size = size + 1;
			
		} else
     		System.out.println("Queue is Full");
			//throw new Exception("Queue is Full");
	}

	public int deQueue() {

		int data = queue[front]; // Removing element from Queue from front
		if (!isEmpty()) {
			front = (front + 1) % 5;
			size = size - 1;
		} else
			System.out.println("Queue is Empty");
		return data;
	}

	public void show() {

		System.out.print("Elements: ");
		for (int i = 0; i < size; i++) {

			System.out.print(queue[(front + i) % 5] + " ");
		}
		System.out.println();

		for (int n : queue) {
			System.out.print(n + " ");
		}
	}

	public int getSize() {

		return size;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public boolean isFull() {
		return getSize() == 5;
	}

}