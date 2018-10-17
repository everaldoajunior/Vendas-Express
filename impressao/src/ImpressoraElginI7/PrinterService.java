/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImpressoraElginI7;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 *
 * @author estagio
 */
public class PrinterService implements Printable{
    
    public List <String> getPrinters() {
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService printServices[] = PrintServiceLookup.lookupPrintServices( flavor , pras );
        
        List <String> printerList = new ArrayList<String>();
        for(PrintService printerService: printServices) {
            printerList.add(printerService.getName());
        }
    return printerList; 
}
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if ( page > 0 ) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d .translate(pf.getImageableX(), pf.getImageableX());
        g.setFont(new Font("Romam", 0 , 10));
        g.drawString("Hello World!", 0,8);
        return PAGE_EXISTS;
     }
    
    public void PrintString (String printerName, String text) throws UnsupportedEncodingException {
//        g.setFont(new Font("Romam", 0 , 10));
        DocFlavor docFlavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(docFlavor, pras);
        PrintService service = findPrintService(printerName, printService);
        
            DocPrintJob job = service.createPrintJob();

                TicketImpresso t = new TicketImpresso("30.709.115/0001-10", "077740874", "29,59",  "Peixe Cioba", "Peixe", "31,50");
       
        try {
            
            byte[] bytes;
            
            bytes = text.getBytes("CP437");
            
            Doc doc = new SimpleDoc( bytes, docFlavor, null );
            
            job.print( doc , null );
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void PrintObject(String printerName, Object TicketImpresso ) {
        DocFlavor docFlavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(docFlavor, pras);
        PrintService service = findPrintService(printerName, printService);
        
            DocPrintJob jog = service.createPrintJob();
            
                TicketImpresso t = new TicketImpresso("30.709.115/0001-10", "077740874", "29,59",  "Peixe Cioba", "Peixe", "31,50");
                
                try {
                        Doc doc = new SimpleDoc(TicketImpresso, docFlavor, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }
    
    public void PrintBytes(String printerName, byte[] bytes) {
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
            
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
            PrintService service = findPrintService(printerName, printService);
            
            DocPrintJob job = service.createPrintJob();
            
     try {
        
        Doc doc = new SimpleDoc(bytes, flavor, null);
        
        job.print(doc , null);
    }   catch (Exception e) { 
            e.printStackTrace();
        } 
}

    private PrintService findPrintService(String printerName, PrintService[] services) {
        for (PrintService service: services) {
            if (service.getName().equalsIgnoreCase(printerName)) {
                return service;
            }
        }
        return null;
    }
}
