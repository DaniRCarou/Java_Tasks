package main;

import waitnotify.MyQueue;
import waitnotify.Consumer;
import waitnotify.Producer;

public class Main {
	public static void main(String[] args) {
		
		
		// Creating a single queue 
		
		MyQueue queue = new MyQueue();
		
		
		// The three productors will use the same queue
		
		Producer p1 = new Producer("Producto 1",queue);
		Producer p2 = new Producer("Producto 2",queue);
		Producer p3 = new Producer("Producto 3",queue);
		
		
		// The three consumers will use the same queue
		
		Consumer c1 = new Consumer("Consumidor 1",queue);
		Consumer c2 = new Consumer("Consumidor 2",queue);
		Consumer c3 = new Consumer("Consumidor 3",queue);
		
		
		// Starting threads
		
		p1.start();
		p2.start();
		p3.start();
		
		c1.start();
		c2.start();
		c3.start();
	}
}
