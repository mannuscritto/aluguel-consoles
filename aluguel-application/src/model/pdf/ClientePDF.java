package model.pdf;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import itextpdf.PDFFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                para.add("Nome: " + c.getPrimeiroNome());
                para.add(" Sobrenome: " + c.getUltimoNome());
                doc.add(para);
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");
            
            doc.addTitle("Relatório de Clientes no sistema AluguelConsoles em " + sdf.format(new Date()));
            doc.addSubject("Dados de todos os clientes que estavam com cadastro ativo na data de criação deste documento.");
            
            PDFFactory.closeDocument(doc);
        } catch (DocumentException ex) {
            System.out.println("Erro ao gerar relatório de cliente: " + ex);
            Logger.getLogger(ClientePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
