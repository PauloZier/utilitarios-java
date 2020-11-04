package utilitarios.util;

public class PairImpl<K, T> implements Pair<K, T> {

	private K key;
	private T value;
	
	@Override
	public K getKey() {
		
		return this.key;
	}

	@Override
	public T getValue() {
	
		return this.value;
	}

	@Override
	public void set(K key, T value) {
		
		this.key = key;
		this.value = value;
	}
}
