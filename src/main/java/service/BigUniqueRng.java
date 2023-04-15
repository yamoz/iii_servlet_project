package service;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class BigUniqueRng implements Iterator<Integer> {
	/**
	 * refer to 
	 * https://www.baeldung.com/java-unique-random-numbers
	 */

	private Random random = new Random();
    private Set<Integer> generated = new LinkedHashSet<>();

    public BigUniqueRng(int size, int max) {
        while (generated.size() < size) { // 陣列內的元素數量還不足時，增加元素
            Integer next = random.nextInt(max); // 產生在範圍內的隨機數
            generated.add(next); // 存入生成的隨機數至set中
        }
    }
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer next() { // 每當讀取了一個元素，就從set中移除一個元素
		Iterator<Integer> iterator = generated.iterator();
	    Integer next = iterator.next();
	    iterator.remove();
	    return next;
	}

}
