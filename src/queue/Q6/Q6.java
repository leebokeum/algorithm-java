package queue.Q6;

public class Q6 {
    /**
     * 동물 보호소: 먼저 들어온 동물이 먼저 나가는 동물 보호소(animal shelter) 가 있다고 하자.
     * 이 보호소는 개와 고양이만 수용한다. 사람들은 보호소 에서 가장 오래된 동물부터 입양할 수 있는데, 개와 고양이 중 어떤 동물 을 데려갈지 선택할 수 있다.
     * 하지만 특정한 동물을 지정해 데려갈 수는 없다.
     *
     * 이 시스템을 자료구조로 구현하라.
     *
     * 이 자료구조는 enqueue, dequeweAny, dequeueDog, dequeueCat 의 연산을 제공해야 한다.
     * 기본적으로 탑재되어 있는 LinkedList 자료구조를 사용해도 좋다.
     */
    public static void main(String[] args) {

        // 동물 보호소 Queue
        AnimalQueue animals = new AnimalQueue();
        animals.enqueue(new Cat("Callie"));
        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Dog("Fido"));
        animals.enqueue(new Dog("Dora"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Dexter"));
        animals.enqueue(new Dog("Dobo"));
        animals.enqueue(new Cat("Copa"));

        // 개 입양
        System.out.println(animals.dequeueDogs().name());

        // 고양이 입양
        System.out.println(animals.dequeueCats().name());

        // 아무 동물이나 입양
        System.out.println(animals.dequeueAny().name());

        // 동물 추가
        animals.enqueue(new Dog("Dapa"));
        animals.enqueue(new Cat("Kilo"));


        // 모든 동물 순차적으로 입양
        while (animals.size() != 0) {
            System.out.println(animals.dequeueAny().name());
        }
    }
}
