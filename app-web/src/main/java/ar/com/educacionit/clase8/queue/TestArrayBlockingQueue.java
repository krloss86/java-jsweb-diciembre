package ar.com.educacionit.clase8.queue;

import java.util.concurrent.ArrayBlockingQueue;

import ar.com.educacionit.domain.Producto;

public class TestArrayBlockingQueue {

	public static void main(String[] args) {
		ArrayBlockingQueue<Long> cola = new ArrayBlockingQueue<>(1);

		cola.offer(1l);
		
		cola.add(2l);
		
		System.out.println(cola);
	}

}
