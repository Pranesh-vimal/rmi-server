package email;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfV1 {
	void createdPdf() {
		Document doc = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Dummy.pdf"));
			System.out.println("PDF created.");
			doc.open();
			doc.add(new Paragraph("Hello world."));
			doc.close();
			writer.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
