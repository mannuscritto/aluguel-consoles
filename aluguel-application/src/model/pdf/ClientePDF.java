package model.pdf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import itextpdf.PDFFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Cliente;
import model.dao.ClienteDAO;

public class ClientePDF {
    
    public void print() {
        
        ClienteDAO dao = new ClienteDAO();
        
        try {
            Document doc = PDFFactory.getDocument("Cliente");
            
            for (Cliente c: dao.read()) {
                Paragraph para = new Paragraph();
                para.add(c.getPrimeiroNome());
                para.add(c.getUltimoNome());
                doc.add(para);
            }
        
            PDFFactory.closeDocument(doc);
        } catch (DocumentException ex) {
            System.out.println("Erro ao gerar relatório de cliente: " + ex);
            Logger.getLogger(ClientePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
