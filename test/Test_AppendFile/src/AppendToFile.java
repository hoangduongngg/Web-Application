

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {
	private static final String FILENAME = 
        "C:\\CODE\\Web Programming\\Web-Progamming-PTIT\\BaiTap\\BaiThucHanh1\\web\\WEB-INF\\login.txt";

	public static void main(String[] args) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			String data = " Nội dung mới nè" + "\n";

			File file = new File(FILENAME);

			// kiểm tra nếu file chưa có thì tạo file mới
			if (!file.exists()) {
				file.createNewFile();
			}// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(data);
			System.out.println("Xong");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}}
}