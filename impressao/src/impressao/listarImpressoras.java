package impressao;

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

public class listarImpressoras{

    private static String criadoEm;
    private static String nCte;
    private static String valorTotal;
    private static String tipoItem;
    private static String valorItem;
    
    private static String contentTicket =
        "   GW SISTEMAS - Teste Impressão\n   " +
        "Expedido em : " + criadoEm + " \n" +
        " ===========================   \n" +
        "CNPJ : XXX.XXX.XXX-1000        \n" +
        "Nº CT-e : " + nCte + "         \n" +
        "\n\n\n\n\n\n                   \n" +
        "Total : " + valorTotal + "     \n" +
        "Item :                         \n" +
        "                               \n" +
        "Tipo do Item : "+ tipoItem +"  \n" +
        "Valor do item : "+ valorItem +"\n"
    ;
    
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
            // Criação do Arquivo que irá ser Impresso
            try {
                OutputStream outputStream = new FileOutputStream("/home/estagio/teste.txt");
                String s = contentTicket;
                int count = 0;
                    while (count < s.length()-1) {
                        outputStream.write(s.charAt(count));
                        
                        count ++;
                    }
                    outputStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
         // Pegando arquivo que será impresso
            try {
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
    
    public listarImpressoras(String criadoEm, String nCte, String valorTotal, String tipoItem, String valorItem) {
        listarImpressoras.criadoEm = criadoEm;
        listarImpressoras.nCte = nCte;
        listarImpressoras.this.valorTotal = valorTotal;
        listarImpressoras.this.tipoItem = tipoItem;
        listarImpressoras.this.valorItem = valorItem;
    }
    
    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        listarImpressoras.criadoEm = criadoEm;
    }

    public String getnCte() {
        return nCte;
    }

    public void setnCte(String nCte) {
        listarImpressoras.nCte = nCte;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        listarImpressoras.valorTotal = valorTotal;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        listarImpressoras.tipoItem = tipoItem;
    }

    public String getValorItem() {
        return valorItem;
    }

    public void setValorItem(String valorItem) {
        listarImpressoras.valorItem = valorItem;
    }

    public String getContentTicket() {
        return contentTicket;
    }

    public void setContentTicket(String contentTicket) {
        listarImpressoras.contentTicket = contentTicket;
    }
    

}
