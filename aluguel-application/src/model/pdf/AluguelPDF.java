package model.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import itextpdf.PDFFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.bean.Aluguel;
import model.dao.AluguelDAO;

public class AluguelPDF {
    
    public void print() {
        
        AluguelDAO adao = new AluguelDAO();
        
        try {
            Document doc = PDFFactory.getDocument("Aluguel");
            
            for (Aluguel a: adao.read()) {
                Paragraph para = new Paragraph();
                para.add("Cliente: " + a.getCliente().getPrimeiroNome());
                para.add(" Data de Início: " + a.getDataInicioAsString());
                para.add(" Data de Término: " + a.getDataFinalAsString());
                para.add(" Controle(s): " + String.valueOf(a.getNumeroControles()));
                para.add(" Valor Total: " + String.valueOf(a.getValorTotal()));
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMMM 'de' yyyy");
            
                doc.addTitle("Relatório de Aluguéis no sistema AluguelConsoles em " + sdf.format(new Date()));
                doc.addSubject("Dados de todos os aluguéis que estavam com cadastro ativo na data de criação deste documento.");
                
                doc.add(para);
            }
            
            PDFFactory.closeDocument(doc);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório de Aluguéis: " + ex);
        }
        
    }
    
}
