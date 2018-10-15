/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impressao;

/**
 *
 * @author estagio
 */
public class ticket {

    private String criadoEm;
    private String nCte;
    private String valorTotal;
    private String tipoItem;
    private String valorItem;
    
    private String contentTicket = 
            "GW SISTEMAS - Teste Impressão" +
            "Expedido em :" + criadoEm + "" +
            " =========================== " +
            "CNPJ : XXX.XXX.XXX-1000      " +
            "Nº CT-e : " + nCte + "       " +
            "                             " +
            "Total :" + valorTotal + "    " +
            "Item:                        " +
            "                             " +
            "Tipo do Item:" + tipoItem + "" +
            "Valor do item:" + valorItem +""
    ;

    public ticket(String criadoEm, String nCte, String valorTotal, String tipoItem, String valorItem) {
        this.criadoEm = criadoEm;
        this.nCte = nCte;
        this.valorTotal = valorTotal;
        this.tipoItem = tipoItem;
        this.valorItem = valorItem;
    }
    
    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getnCte() {
        return nCte;
    }

    public void setnCte(String nCte) {
        this.nCte = nCte;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public String getValorItem() {
        return valorItem;
    }

    public void setValorItem(String valorItem) {
        this.valorItem = valorItem;
    }

    public String getContentTicket() {
        return contentTicket;
    }

    public void setContentTicket(String contentTicket) {
        this.contentTicket = contentTicket;
    }
    
}
