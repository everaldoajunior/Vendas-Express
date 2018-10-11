package impressao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class listarImpressoras {

    public static void main(String[] args) {

        try 
            {    
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
            {
                ex.printStackTrace();
            }
        PrintService [] printService = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            System.out.println("Número de Impressoras : " +printService.length );
            
        PrintService impressoraPadrao = PrintServiceLookup.lookupDefaultPrintService();
            System.out.println("Impressora Padrão é : " +impressoraPadrao.getName());
            
        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            HashDocAttributeSet hashDocAttributeSet = new HashDocAttributeSet();
            
        try 
            {
            FileInputStream fileInputStream = new FileInputStream("/home/estagio/teste.txt");
            Doc doc  = new SimpleDoc(fileInputStream, docFlavor, hashDocAttributeSet);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            PrintService printServico = ServiceUI.printDialog(null, 50, 10, printService, impressoraPadrao, docFlavor, printRequestAttributeSet);
            
            if (printServico != null) {
                DocPrintJob docPrintJob = printServico.createPrintJob();
                try {
                    //Mandar impressão abaixo :
                    docPrintJob.print(doc, printRequestAttributeSet);
                } catch (PrintException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
    }
}
