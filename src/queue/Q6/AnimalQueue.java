package queue.Q6;

import java.util.LinkedList;

/**
 * 동물 보호소 큐
 */
public class AnimalQueue {

	// 개의 목록을 저장할 저장소
	LinkedList<Dog> dogs = new LinkedList<Dog>();

	// 고양의 목록을 저장할 저장소
	LinkedList<Cat> cats = new LinkedList<Cat>();

	// 동물이 들어온 순서
	private int order = 0;

	/**
	 * 동물을 등록한다. (입력)
	 */
	public void enqueue(Animal a) {
		// 1. 순서 부여
		a.setOrder(order);

		// 2. 순서 1 증가
		order++;

		// 3. 개 or 고양이인지에 따라서 저장소에 저장한다.
		if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat)a);
		}
	}

	/**
	 * 아무 동물이나 입양한다. (출력)
	 */
	public Animal dequeueAny() {

		// 개 or 고양이가 비어 있는지에 따라, 개와 고양이를 꺼내고 종료한다.
		if (dogs.isEmpty()) {
			return dequeueCats();
		} else if (cats.isEmpty()) {
			return dequeueDogs();
		}

		// 둘다 비어있지 않다면

		// 개를 확인
		Dog dog = dogs.peek();

		// 고양이를 확인
		Cat cat = cats.peek();

		// 개와 고양이의 순서를 비교하여, 순서가 먼저인 동물을 꺼낸다.
		if (dog.isOlderThan(cat)) {
			return dogs.poll();
		} else {
			return cats.poll();
		}
	}

	/**
	 * 가장 먼저 입양될 동물을 확인
	 */
	public Animal peek() {
		if (dogs.isEmpty()) {
			return cats.peek();
		} else if (cats.isEmpty()) {
			return dogs.peek();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat)) {
			return dog;
		} else {
			return cat;
		}
	}

	/**
	 * 전체 사이즈 : 개 + 고양이
	 */
	public int size() {
		return dogs.size() + cats.size();
	}

	/**
	 * 개 입양
	 */
	public Dog dequeueDogs() {
		return dogs.poll();
	}
	
	public Dog peekDogs() {
		return dogs.peek();
	}

	/**
	 * 고양이 입양
	 */
	public Cat dequeueCats() {
		return cats.poll();
	}
	
	public Cat peekCats() {
		return cats.peek();
	}
}
