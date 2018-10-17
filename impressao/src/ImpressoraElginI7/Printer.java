package ImpressoraElginI7;

import java.io.UnsupportedEncodingException;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author estagio
 */

public class Printer {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws UnsupportedEncodingException {
        
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(DocFlavor.INPUT_STREAM.AUTOSENSE, null);
//        System.out.println("Número de Impressoras : " + printService.length);

        PrintService defaultPrinter = PrintServiceLookup.lookupDefaultPrintService();
//        System.out.println("Impressora Padrão é : " + defaultPrinter.getName());
        PrinterService printerService = new PrinterService();
        
            System.out.println(printerService.getPrinters());
            
            if (printerService != null ) {
                    DocPrintJob docPrintJob= defaultPrinter.createPrintJob();
//                        docPrintJob.print( , null);
                }
            printerService.PrintString(defaultPrinter.getName(),
              "         GW SISTEMAS         \n\n"
            + "\n                             \n"
            + "Expedido em : ${criadoEm} "
            + "às : ${horaExpedicao}          \n"
            + "                               \n"
            + "\n --------------------------- \n"
            + "                               \n"
            + "CNPJ : ${CNPJ}                 \n"
            + "                               \n"
            + "Nº CT-e : ${nCte}              \n"
            + "                               \n"
            + "\n --------------------------- \n"
            + "\n\n\n\n\n\n                   \n"
            + "Total R$ : ${valorTotal}       \n"
            + "\n                             \n"
            + "Item : ${itens}                \n"
            + "                               \n"
            + "Tipo do Item : ${tipoItem}     \n"
            + "\n                             \n"
            + "\nValor do item : ${valorItem} \n"
            + "\n                             \n"
            + "\n                             \n"
            + "\n                             \n"
            + "\n                             \n"
            + "\n                             \n"
            + "\n                             \n"
            + "\n                             \n"
            + "\n                             \n"
            + "============================"
            );
            
//            byte[] cutP = new byte[] { 0x1d, 'V', 1 };
//                printerService.PrintBytes("Elgin i7-2", cutP);
    }
    
}
