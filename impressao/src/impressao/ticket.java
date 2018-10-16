/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 *
 * @author estagio
 */
public class ticket {
    
    private String criadoEm = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now());
    private String horaExpedicao = DateTimeFormatter.ofPattern("hh:mm").format(LocalTime.now());
    private String CNPJ;
    private String nCte;
    private String valorTotal;
    private String itens;
    private String tipoItem;
    private String valorItem;
    
    private static final String contentTicket
            = "         GW SISTEMAS         \n\n"
            + "\n                             \n"
            + "Expedido em : ${criadoEm} "
            + "às : ${horaExpedicao}          \n"
            + "                               \n"
            + "\n ------------------------------ \n"
            + "                               \n"
            + "CNPJ : ${CNPJ}                 \n"
            + "                               \n"
            + "Nº CT-e : ${nCte}              \n"
            + "                               \n"
            + "\n ------------------------------ \n"
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
            + "============================";

    public ticket (String CNPJ, String nCte, String valorTotal, String itens, String tipoItem, String valorItem) {
//        this.criadoEm = criadoEm;
        this.CNPJ = CNPJ;
        this.nCte = nCte;
        this.valorTotal = valorTotal;
        this.itens = itens;
        this.tipoItem = tipoItem;
        this.valorItem = valorItem;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        criadoEm = criadoEm;
    }

    public String CNPJ() {
        return CNPJ;
    }

    public void CNPJ(String nCte) {
        CNPJ = CNPJ;
    }
    public String getnCte() {
        return nCte;
    }

    public void setnCte(String nCte) {
        nCte = nCte;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        valorTotal = valorTotal;
    }
    
    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        itens = itens;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        tipoItem = tipoItem;
    }

    public String getValorItem() {
        return valorItem;
    }

    public void setValorItem(String valorItem) {
        valorItem = valorItem;
    }



    public String getContentTicket() {
        String texto = contentTicket;
        
        texto = texto.replace("${criadoEm}", criadoEm);
        texto = texto.replace("${horaExpedicao}", horaExpedicao);
        texto = texto.replace("${CNPJ}", CNPJ);
        texto = texto.replace("${nCte}", nCte);
        texto = texto.replace("${valorTotal}", valorTotal);
        texto = texto.replace("${itens}", itens);
        texto = texto.replace("${tipoItem}", tipoItem);
        texto = texto.replace("${valorItem}", valorItem);

        return texto;
    }
}
