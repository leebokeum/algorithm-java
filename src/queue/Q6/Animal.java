package queue.Q6;

/**
 * 동물 클래스 (최상위 부모 클래스)
 */
public abstract class Animal {
	// 순서
	private int order;

	// 동물 이름
	protected String name;
	public Animal(String n) {
		name = n;
	}
	
	public abstract String name();
	
	public void setOrder(int ord) {
		order = ord;
	}
	
	public int getOrder() {
		return order;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}
