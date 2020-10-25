package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class temp {
	public static final String s = "https://lzdliving.alicdn.com/live_hp/";
	
	public static void main(String[] args) {
//		delect("G:\\temp");
		replace("C:\\Users\\john\\Desktop\\var\\科目一职业理念.m3u8");
	}

	private static void replace(String src) {
		
		File file = new File(src);
		if(file.exists()) {
			InputStream in = null;
			OutputStream out= null;
			StringBuffer str = null;
			try {
				in = new FileInputStream(file);
				out = new FileOutputStream(file.getParent()+"\\"+file.getName()+"_1.m3u8");
				byte[] bytes = new byte[1024];
				int len = -1;
				int index = 0;
				str = new StringBuffer();
				while((len = in.read(bytes)) != -1) {
					str.append(new String(bytes, 0, len));
				};

				int length = str.length();
				for(int i = 0; index <= length+i*s.length()-1; ++i) {
					index = str.indexOf(",", index)+2;
					if(index == 1) {
						break;
					}
					str.insert(index, s);
				}
				out.write(str.toString().getBytes(), 0, str.length());
				System.out.println("操作成功");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null) in.close();
					if (out != null) out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println(file.getAbsolutePath()+"文件不存在");
		}
	}
	
	
	private static void delect(String src) {
		File file = new File(src);
		if (file.exists()) {
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.length() == 0) {
					f.delete();
				}
			}
		}
	}
}
