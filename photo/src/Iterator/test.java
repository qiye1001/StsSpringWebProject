package Iterator;

public class test {
	public static void main(String[] args) {
		MyList list = new ConcreteAggregate();
		list.add("fgag");
		list.add("gajas");
		list.add("jdsa");
		list.add("hgse");
		list.add("ussg");
		
		Iterator it = list.iterator();
		while(it.hashNext()) {
			System.out.println(it.next());
		}
	}
}
