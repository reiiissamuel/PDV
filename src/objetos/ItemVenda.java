/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public class ItemVenda {
    private Venda venda;
    private Produto produto;
    private BigDecimal precoUnitario;
    private String qtdItem;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(String qtdItem) {
        this.qtdItem = qtdItem;
    }
    
}
