
package jvavancado.beans;

import jvavancado.Produtos.beans.Produtos;


public class PedidoItens {
     private int id ;
   private Pedido  pedido;
   private Produtos Produto;
    private double qtde;
    private double PercDesconto;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the produtos
     */
    public Produtos getProdutos() {
        return Produto;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(Produtos produtos) {
        this.Produto = produtos;
    }

    /**
     * @return the qtde
     */
    public double getQtde() {
        return qtde;
    }

    /**
     * @param qtde the qtde to set
     */
    public void setQtde(double qtde) {
        this.qtde = qtde;
    }

    /**
     * @return the percdesconto
     */
    public double getPercdesconto() {
        return PercDesconto;
    }

    /**
     * @param percdesconto the percdesconto to set
     */
    public void setPercdesconto(double percdesconto) {
        this.PercDesconto = percdesconto;
    }
}
