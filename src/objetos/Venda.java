/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.math.BigDecimal;
import java.time.LocalDate;
/**
 *
 * @author User
 */
public class Venda {

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public FuncionarioPF getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioPF funcionario) {
        this.funcionario = funcionario;
    }
    

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    private int codigoVenda;
    private LocalDate data;
    private int    qtdItens;
    private  FuncionarioPF funcionario;
    private BigDecimal precoTotal;
    
    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }
    
}
