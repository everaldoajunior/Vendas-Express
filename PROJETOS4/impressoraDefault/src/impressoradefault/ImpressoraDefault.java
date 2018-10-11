/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressoradefault;

import java.io.FileOutputStream;
import javax.print.DocFlavor;


/**
 *
 * @author estagio
 */
public class ImpressoraDefault {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String criadoEm = "2018-11-10";
        String CNPJ = "100-375-574/1000";
        String nCte = "100254";
        String valorTotal = "548,555";
        String itens = "Cadernos Capa dura";
        
        ticket ticket = new ticket(criadoEm, CNPJ, nCte, valorTotal, itens);

//            FileOutputStream fileOutputStream = new FileOutputStream
                
    }

}
