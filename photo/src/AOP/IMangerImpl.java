package AOP;

import java.util.ArrayList;
import java.util.List;

public class IMangerImpl implements IManger {

	List<String> list = new ArrayList<>();
	
	@Override
	public void add(String item) {
		list.add(item);
		System.out.println(item);
	}

}
