package impressao;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

public class impressao {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        PrintService[] printService = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.AUTOSENSE, null);
        System.out.println("N�mero de Impressoras : " + printService.length);

        PrintService defaultPrinter = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println("Impressora Padr�o � : " + defaultPrinter.getName());

        DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        HashDocAttributeSet hashDocAttributeSet = new HashDocAttributeSet();
        
            ticket t = new ticket("30.709.115/0001-10", "077740874", "29,59",  "Peixe Cioba", "Peixe", "31,50");
        
//         Cria��o do Arquivo que ir� ser Impresso
        try {
            OutputStream outputStream = new FileOutputStream("/home/estagio/teste.txt");
            String s = t.getContentTicket();
            int count = 0;
            while (count < s.length() - 1) {
                outputStream.write(s.charAt(count));

                count++;
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Pegando arquivo que ser� impresso
        try {
            FileInputStream fileInputStream = new FileInputStream("/home/estagio/teste.txt");
            Doc doc = new SimpleDoc(fileInputStream, docFlavor, hashDocAttributeSet);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();

            if (defaultPrinter != null) {
                DocPrintJob docPrintJob = defaultPrinter.createPrintJob();
                    System.out.println("Impress�o Finalizada com Sucesso!!");;
            
                try {
                    //Mandar impress�o abaixo :
                    docPrintJob.print(doc, printRequestAttributeSet);
                } catch (PrintException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else {
                JOptionPane.showMessageDialog(null , "Impress�o cancelada com sucesso!");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}