package vendas_express;

public class Produtos {
    
    public int codProd;
    public String tipoProd;
    private int Valor;
    public String Descrição;
   
        //Metodós Acessores
        public void EstadoAtual() {
        System.out.println("===============================");
        System.out.println("Código do Produto :" + codProd);
        System.out.println("Usabilidade do Produto :" + tipoProd);
        System.out.println("Valor do Produto : " + Valor);
        System.out.println("Descrição do Produto : " +Descrição);
}
    
    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public String getDescrição() {
        return Descrição;
    }

    public void setDescrição(String Descrição) {
        this.Descrição = Descrição;
    }
    
        
    
}


