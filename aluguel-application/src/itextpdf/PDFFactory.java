package itextpdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFFactory {
    
    /*public static Document getDocument() throws DocumentException {
        
        Document doc = new Document();
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\romer\\Documents"));
            
            doc.open();
            
            doc.add(new Paragraph("Gerando PDF - Java"));
        } catch (DocumentException | IOException de) {
            System.out.println(de.getMessage());
        }

        return null;
    }*/
    
    public static void main(String[] args) {
           // criação do documento
          Document document = new Document();
          try {
              
              PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\romer\\Documents\\PDF_teste.pdf"));
              document.open();
              
              // adicionando um parágrafo no documento
              document.add(new Paragraph("Gerando PDF - Java"));
    }
          catch(DocumentException | IOException de) {
              System.err.println(de.getMessage());
          }
          document.close();
      }
    
}
