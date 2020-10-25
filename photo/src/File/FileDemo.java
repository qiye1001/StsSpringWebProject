package File;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo {
	public static void main(String[] args) {
		File file1 = new File("G:" + File.separator + "新建文件夹 (4)\\于晓成/image");
		if (file1.isDirectory()) { // 判断该文件是否为目录

			// 列出当前目录下的所有文件名
			String[] names = file1.list();
//			System.out.println(Arrays.toString(names));

			// 列出当前目录下的所有文件
			File[] fs = file1.listFiles();
			for (File f : fs) {
//				System.out.println("绝对路径：" + f.getAbsolutePath());
//				System.out.println("相对路径：" + f.getPath());
//				System.out.println("是否为隐藏文件：" + f.isHidden());
//				System.out.println("文件长度（大小（字节））：" + f.length());
//				System.out.println("是否为可读文件：" + f.canRead());
//				System.out.println("文件最后修改时间：" + f.lastModified());
			}

			File file2 = new File("G:" + File.separator + "新建文件夹 (4)\\于晓成/image/01.jpg");
			// 判断文件是否存在
			if (file2.exists()) {
//				try {
//					file2.createNewFile();
//					System.out.println("文件创建成功");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				file2.listFiles(new FileFilter() {
//					
//					@Override
//					public boolean accept(File pathname) {
//						return false;
//					}
//				});
				File[] fs2 = file2.listFiles((pathName) -> pathName.getName().endsWith(".png"));
//				
				if (fs2 != null) {
					for (File f2 : fs2) {
						// if(f2.length() < 9000) {
						// f2.delete();
						// }
						// System.out.println(f2.getAbsoluteFile());

						System.out.println(f2);

						// if(f2.getName().endsWith(".txt")) {
						// String[] s = (""+f2.getAbsoluteFile()).split("\\." ,2);
						// f2.renameTo(new File(s[0]+".jpg"));
						// };

					}
				}
			}

			File file3 = new File("G:" + File.separator + "新建文件夹 (4)" + File.separator + "于晓成" + "\\web/test.txt");
			if (file3.exists()) {
//				boolean f = file3.mkdirs();
//				System.out.println(f);

//				file3.mkdirs();
				boolean f = file3.renameTo(new File(String.valueOf(file3.getAbsoluteFile())));
				System.out.println(f);

				if (file3.isDirectory()) {
					try {
						System.out.println(file3.getAbsoluteFile() + File.separator);
						boolean s = new File(file3.getAbsoluteFile() + File.separator + "新建文件按键.txt").createNewFile();
						System.out.println(s);

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
