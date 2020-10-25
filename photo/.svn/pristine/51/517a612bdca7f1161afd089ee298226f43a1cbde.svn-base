package IO;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class StingStreamDemo {
	
	private static void String() {
		String str = "good hello world exception";
		
		StringReader sr = new StringReader(str);
		
		StreamTokenizer st = new StreamTokenizer(sr);
		int count = 0;
		while (st.ttype != StreamTokenizer.TT_EOF) {
			try {
				if (st.nextToken() == StreamTokenizer.TT_WORD) {
					++count;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
		sr.close();
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		String();
	}
}
