package Iterator;

public class ConcreteIterator implements Iterator{

	private MyList list;
	private int index;
	
	public ConcreteIterator(MyList list) {
		this.list = list;
	}

	@Override
	public Object next() {
		Object obj = list.get(index);
		++index;
		return obj;
	}

	@Override
	public boolean hashNext() {
		if(index >= list.getsize()) {
			return false;
		}else
			return true;
	}

}
