package IO;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class PathFileDemo {
	public static void main(String[] args) {
		
		File file = new File("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt\\新建文件按键.txt");
		
		Path p1 = Paths.get("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt", "新建文件按键.txt");
		Path p3 = FileSystems.getDefault().getPath("G:\\新建文件夹 (4)\\于晓成\\web\\test.txt", "新建文件按键.txt");
		Path p2 = file.toPath();
		
		// Files工具类
		Path p4 = Paths.get("G:\\新建文件夹 (4)\\于晓成\\web", "新建文件按键.txt");
		String info = "教法为我叫高国际\r\n";
//		try {
//			Files.write(p4, info.getBytes(), StandardOpenOption.APPEND);	// 追加
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		try {
//			byte[] bytes = Files.readAllBytes(p4);
//			System.out.println(new String(bytes));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// 复制文件
		try {
			// StandardCopyOption.REPLACE_EXISTING  如果存在 替换现有文件
			Files.copy(p4, Paths.get("G:\\新建文件夹 (4)\\于晓成\\web", "新建文件按键2.txt"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 删除文件
		try {
			Files.delete(Paths.get("G:\\新建文件夹 (4)\\于晓成\\web\\新建文件按键2.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 移动文件
		try {
			Files.move(p4, Paths.get("G:\\新建文件夹 (4)\\于晓成\\web\\新建文件按键2.txt"), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
