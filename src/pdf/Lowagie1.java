package pdf;

import java.io.*;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class Lowagie1 {

	public static void main(String[] args) throws Exception {

		String fileName="simple_table.pdf";
		String dir="./";
		
		File directory = new File(dir);
		if(!directory.exists()) directory.mkdirs(); //파일경로 없으면 생성          
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(dir+fileName));
		
		document.open();
		
	// 한글 입력을 위해 폰트를 선택해줍니다. iTextAsian.jar에서는 다음 3개의 폰트를 사용할 수 있습니다.
	// HYGoThic-Medium, HYSMyeongJo-Medium, HYSMyeongJoStd-Medium
		String fontFace = "HYGoThic-Medium";
					
	// 글자 방향을 결정하는 CMap은 두가지가 있습니다. 
	// UniKS-UCS2-H : 가로, UniKS-UCS2-V : 세로
		String fontNameH = "UniKS-UCS2-H";
		
	// 준비한 설정값들을 활용해 Font 객체를 생성해줍니다. 생성자에 들어가는 인자는 BaseFont 와 사이즈 입니다.
		BaseFont bf = BaseFont.createFont(fontFace, fontNameH, BaseFont.NOT_EMBEDDED);

		Font font = new Font(bf, 20);
		
		document.add(new Paragraph("안녕하세요", font));
		
		PdfPTable table = new PdfPTable(4);

		for (int i = 0; i < 16; i++) {
			table.addCell(new Paragraph("셀넘버" + i, font));
		}
		document.add(table);
		document.close();
	}

}
