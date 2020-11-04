package utilitarios.util;

public interface Pair<K, T> {
	
	public K getKey();
	
	public T getValue();
	
	public void set(K key, T value);
}
