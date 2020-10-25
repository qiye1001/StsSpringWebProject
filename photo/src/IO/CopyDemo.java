package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo {
	public static void main(String[] args) {
		copy("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt", "G:\\新建文件夹 (4)\\于晓成\\web\\test.txtjiu\\");
	}
	
	private static void copy(String src, String target) {
		File srcFile = new File(src);
		File targetFile = new File(target + srcFile.getName());
		
		InputStream in = null;
		OutputStream  out = null;
		
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(targetFile);
			byte[] bytes = new byte[1024];
			int len = -1;
			
			while ((len = in.read(bytes)) != -1) {
				out.write(bytes, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
				if(out != null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
