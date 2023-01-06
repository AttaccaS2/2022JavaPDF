package pdf;

import com.aspose.pdf.*;
import com.aspose.pdf.drawing.GradientAxialShading;

public class Pdf2 {

	public static void main(String[] args) {
		// PDF 문서 로드
		Document document = new Document();

		// 페이지 추가
		Page page = document.getPages().add();

		// 텍스트 조각 만들기
		TextFragment textFragment = new TextFragment(
				"Text 1: We have now applied text formatting. This is PDF generated by Aspose.PDF for .NET");
		textFragment.setPosition(new Position(100, 700));
		TextFragment textFragment1 = new TextFragment(
				"Text 2: We have now applied text formatting. This is PDF generated by Aspose.PDF for .NET");
		textFragment1.setPosition(new Position(100, 600));

		// 텍스트 속성 설정
		textFragment.getTextState().setFontSize(12);
		textFragment.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
		textFragment.getTextState().setBackgroundColor(Color.getLightGray());
		textFragment.getTextState().setForegroundColor(Color.getRed());

		textFragment1.getTextState().setDrawTextRectangleBorder(true);
		textFragment1.getTextState().setUnderline(true);
		textFragment1.getTextState().setStrikeOut(true);

		// 패턴 색상 공간으로 새 색상 만들기
		Color color = new Color();
		color.setPatternColorSpace(new GradientAxialShading(Color.getRed(), Color.getBlue()));		
		textFragment1.getTextState().setForegroundColor(color);

		// TextBuilder 객체 생성
		TextBuilder textBuilder = new TextBuilder(page);

		// PDF 페이지에 텍스트 조각 추가
		textBuilder.appendText(textFragment);
		textBuilder.appendText(textFragment1);

		// PDF 문서 저장
		document.save("Generated-PDF.pdf");
	}

}