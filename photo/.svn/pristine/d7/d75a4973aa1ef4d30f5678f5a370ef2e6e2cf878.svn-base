package IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class CompressionAndDecompressionDemo {
	// 压缩
	private static void compression(String zipFileName, File targetFile) {
		System.out.println("compressing...");
		zipFileName = targetFile.getParent() + "\\" + zipFileName;
		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
			BufferedOutputStream bos = new BufferedOutputStream(out);
			zip(targetFile, out, targetFile.getName(), bos);
			bos.close();
			out.close();
			System.out.println("compression end");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 压缩
	private static void zip(File targetFile, ZipOutputStream zOut, String name, BufferedOutputStream bos)
			throws IOException {
		if (targetFile.isDirectory()) {
			// 该文件是目录 列出该目录下的子目录
			File[] files = targetFile.listFiles();
			if (targetFile.length() == 0) { // 处理空文件夹
				zOut.putNextEntry(new ZipEntry(name + "/"));
			}
			for (File f : files) {
				zip(f, zOut, name + "/" + f.getName(), bos);
			}
		} else {
			zOut.putNextEntry(new ZipEntry(name));
			InputStream in = new FileInputStream(targetFile);
			BufferedInputStream bis = new BufferedInputStream(in);

			byte[] bytes = new byte[1024];
			int len = -1;
			while ((len = bis.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
			}
			in.close();
		}
	}

	// 解压
	private static void decompression(String targetFileName, String parent) {
		System.out.println("decompressing...");
		try {
			ZipInputStream in = new ZipInputStream(new FileInputStream(targetFileName));
			ZipEntry entry = null;
			File file = null;
			while((entry = in.getNextEntry()) != null) {
				while(entry.isDirectory()) {
					entry = in.getNextEntry();
				}
				file = new File(parent, entry.getName());
				// 判断该文件是否存在
				if(!file.exists()) {
					new File(file.getParent()).mkdirs();
				}
				OutputStream out = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				
				byte[] bytes = new byte[1024];
				int len = -1;
				
				while((len = in.read(bytes)) != -1) {
					out.write(bytes, 0, len);
				}
				bos.flush();
				bos.close();
				System.out.println(file.getAbsolutePath() + " 解压成功");
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		compression("于晓成.zip", new File("G:\\新建文件夹 (4)\\于晓成"));
//		decompression("G:\\新建文件夹 (4)\\于晓成.zip", "G:\\新建文件夹 (4)\\test\\temp\\");
	}
}
