package vendas_express;

public class Vendas_Express {

    public static void main(String[] args) {
        Produtos P1 = new Produtos();
            P1.setCodProd(1);
            P1.setTipoProd("Copo");
            P1.setValor(50);
            P1.setDescrição("Produto bem feito, com esfera bem elaborada");
           
            P1.EstadoAtual();
            
    }
    
}
