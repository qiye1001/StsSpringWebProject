package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class ObjectStreamDemo {

	private static void readObject() {
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
		try {
			InputStream in = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(in);
			ObjectInputStream ois = new ObjectInputStream(bis);
			Dog[] dogs = (Dog[])ois.readObject();
			ois.close();
			System.out.println(Arrays.toString(dogs));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void writeObject() {
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
		Dog dog1 = new Dog("huahua", 4, "公", 10001);
		Dog dog2 = new Dog("huahua2", 3, "母", 10002);
		Dog[] dogs = {dog1, dog2};
		try {
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(dogs);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		writeObject();
		readObject();
	}
}