package Iterator;

public class ConcreteAggregate implements MyList{
	
	private Object[] elements;
	private int index;
	private int size;

	public ConcreteAggregate() {
		this.elements = new Object[10];
	}

	@Override
	public void add(Object obj) {
		elements[index] = obj;
		++index;
		++size;
	}
	
	@Override
	public Object get(int index) {
		return elements[index];
	}

	@Override
	public Iterator iterator() {
		return new ConcreteIterator(this);
	}

	@Override
	public int getsize() {
		return size;
	}
	
}
