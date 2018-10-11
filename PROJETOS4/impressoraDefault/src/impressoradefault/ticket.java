/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressoradefault;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

import impressoradefault.ImpressoraDefault;

/**
 *
 * @author estagio
 */
public class ticket {
    
    private String contentTicket = 
            "GW SISTEMAS - Teste Impressão" +
            "Expedido em : {{criadoEm}}   " +
            " =========================== " +
            "CNPJ : {{CNPJ}}              " +
            "Nº CT-e : {{nCte}}           " +
            "                             " +
            "Total: {{valorTotal}}        " +
            "Item: {{itens}}              " +
            "\n \n \n \n \n \n \n \n \n \n" +
            " =========================== " ;
    
    
ticket(String criadoEm , String CNPJ , String nCte , String valorTotal , String itens ) {
    this.contentTicket = this.contentTicket.replace("{{criadoEm}}", criadoEm);
    this.contentTicket = this.contentTicket.replace("{{CNPJ}}", CNPJ);
    this.contentTicket = this.contentTicket.replace("{{valorTotal}}", valorTotal);
    this.contentTicket = this.contentTicket.replace("{{valorTotal}}", itens);
    }

    public void print() {
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
        PrintService service = ServiceUI.printDialog(null, 0, 700, printService, defaultService, flavor, pras);
        
        
        byte[] bytes;

            bytes = this.contentTicket.getBytes();
            Doc doc  = new SimpleDoc(bytes, flavor, null);
            
            DocPrintJob job = service.createPrintJob();
            
            try {
                job.print(doc, null);
            } catch (PrintException ex) {
                JOptionPane.showMessageDialog(null, "Erro a Imprimir arquivo!!");
            }
            
    }

}