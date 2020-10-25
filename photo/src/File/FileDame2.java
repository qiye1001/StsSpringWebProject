package File;

import java.io.File;

public class FileDame2 {
	public static void main(String[] args) {
		findFile(new File("G:\\"), "奥运");
	}

	public static void findFile(File target, String ext) {
		if (target == null)
			return;
		if (target.isDirectory()) {
			// 文件是目录
			File[] files = target.listFiles();
			if (files != null) {
				for (File f : files) {
					findFile(f, ext);
				}
				
			}
		} else {
			String name = target.getName().toLowerCase(); // 获取文件名并转小写
			if (name.startsWith(ext)) {
				System.out.println(target.getAbsolutePath());
			}
		}
	}
}
