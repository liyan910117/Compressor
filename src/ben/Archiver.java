/*
 * 文件名：		Archiver.java
 * 创建日期：	2013-7-22
 * 最近修改：	2013-7-22
 * 作者：		徐犇
 */
package ben;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;

import de.innosystec.unrar.exception.RarException;

/**
 * @author ben
 *
 */
public abstract class Archiver {
	
	/**
	 * 打包或压缩文件
	 * @param files 需要打包和压缩的文件数组
	 * @param destpath 目标文件路径
	 * @throws IOException
	 */
	public abstract void doArchiver(File[] files, String destpath) throws IOException;
	
	/**
	 * 解压或解包文件
	 * @param srcfile 需要解压或解包的源文件
	 * @param destpath 目标路径
	 * @param password 解压密码, 为null时表示不使用密码
	 * @throws IOException
	 * @throws RarException 
	 */
	public abstract void doUnArchiver(File srcfile, String destpath, String password) throws IOException, RarException;
	
	/**
	 * 从bis读取数据并写入bos中
	 * @param bis
	 * @param bos
	 * @throws IOException
	 */
	public void readAndWrite(BufferedInputStream bis, BufferedOutputStream bos) throws IOException {
		byte[] buf = new byte[1024];
		int len;
		while((len = bis.read(buf)) > 0) {
			bos.write(buf, 0, len);
		}
		bos.flush();
		bos.close();
		bis.close();
	}
	
}