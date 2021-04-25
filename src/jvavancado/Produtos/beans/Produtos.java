package jvavancado.Produtos.beans;

public class Produtos {

    private int id;
    private String descrição;
    private double preco;
    private String un_medida;
    private int estoque;

    /**
     * @return the id
     *
     */
    public Produtos() {
     
    }

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
     * @return the descrição
     */
    public String getDescrição() {
        return descrição;
    }

    /**
     * @param descrição the descrição to set
     */
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }



    /**
     * @return the un_medida
     */
    public String getUn_medida() {
        return un_medida;
    }

    /**
     * @param un_medida the un_medida to set
     */
    public void setUn_medida(String un_medida) {
        this.un_medida = un_medida;
    }

    /**
     * @return the estoque
     */
    public int getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
