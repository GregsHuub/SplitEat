package pl.gregsApp.pdfMaker;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfCreate {


    public void pdfPrinterItext(String inputedText, String pdfFileName) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pdfFileName + ".pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, BaseColor.BLACK);
        Chunk chunkTitle = new Chunk("List of Dishes", font);
        Chunk chunk = new Chunk(inputedText, font);



        document.add(chunkTitle);
        document.add(new Paragraph("\n"));
        document.add(chunk);
        document.close();
    }




}
