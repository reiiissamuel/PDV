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
public class Produto {

    private String nome;
    private String unidadeAbnt;
    private float qtdUnidadeAbt;
    private int codigo;
    private BigDecimal preco;
    private float qtdEstoque;
    private boolean vendaFraconada;

    public boolean isVendaFraconada() {
        return vendaFraconada;
    }

    public void setVendaFraconada(boolean vendaFraconada) {
        this.vendaFraconada = vendaFraconada;
    }
    
    public float getQtdUnidadeAbt() {
        return qtdUnidadeAbt;
    }

    public void setQtdUnidadeAbt(float qtdUnidadeAbt) {
        this.qtdUnidadeAbt = qtdUnidadeAbt;
    }

    public String getUnidadeAbnt() {
        return unidadeAbnt;
    }

    public void setUnidadeAbnt(String unidadeAbnt) {
        this.unidadeAbnt = unidadeAbnt;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public float getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(float qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
}
