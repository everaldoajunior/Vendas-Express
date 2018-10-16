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
    private String itens;
    
    private static final String contentTicket
            = "         GW SISTEMAS         \n\n"
            + "Expedido em : ${criadoEm}      \n"
            + "\n===========================  \n"
            + "CNPJ : XXX.XXX.XXX-1000        \n"
            + ""
            + "Nº CT-e : ${nCte}              \n"
            + "\n\n\n\n\n\n                   \n"
            + "Total : ${valorTotal}          \n"
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
            + " ========================== ";

    public ticket(String criadoEm, String nCte, String valorTotal, String tipoItem, String valorItem, String itens) {
        this.criadoEm = criadoEm;
        this.nCte = nCte;
        this.valorTotal = valorTotal;
        this.tipoItem = tipoItem;
        this.valorItem = valorItem;
        this.itens = itens;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        criadoEm = criadoEm;
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

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        itens = itens;
    }

    public String getContentTicket() {
        String texto = contentTicket;
        
        texto = texto.replace("${criadoEm}", criadoEm);
        texto = texto.replace("${nCte}", nCte);
        texto = texto.replace("${valorTotal}", valorTotal);
        texto = texto.replace("${tipoItem}", tipoItem);
        texto = texto.replace("${valorItem}", valorItem);
        texto = texto.replace("${itens}", itens);

        return texto;
    }
}
