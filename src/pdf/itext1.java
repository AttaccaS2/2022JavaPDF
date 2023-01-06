package pdf;

import java.io.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;

public class itext1 {

	public static void main(String[] args) throws Exception {

		String fileName="simple_table.pdf";
		String dir="./";
		
		File directory = new File(dir);
		if(!directory.exists()) directory.mkdirs(); //파일경로 없으면 생성          
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(dir+fileName));
		
		document.open();
		PdfPTable table = new PdfPTable(4);
		for(int i = 0; i < 16; i++){
			table.addCell("cellNumber:" + i);
		}
		document.add(table);
		document.close();
	}

}
