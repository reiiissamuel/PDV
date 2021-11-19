/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.ItemVenda;
import objetos.PagamentoVenda;
import objetos.Produto;
import objetos.Venda;
import pdv.Conexao;

/**
 *
 * @author User
 */
public class ControleOperacoes {
    
private ControleVenda controleVenda;
private ControleItemVenda controleItemVenda;
private ControlePagamentoVenda controlePagamentoVenda;
private ControleProduto controleProduto;
private Produto produto;
private Venda venda;
private ItemVenda itemVenda;
private PagamentoVenda pagamentoVenda;
private ArrayList<ItemVenda> itensVenda;
 private Connection con = null;

public ControleOperacoes( ){
    con = Conexao.getConnection();
    controleVenda = new ControleVenda(new ArrayList<>());
    controleItemVenda = new ControleItemVenda(new ArrayList<>());
    controlePagamentoVenda = new ControlePagamentoVenda(new ArrayList<>());
    controleProduto = new ControleProduto(new ArrayList<>());
}

public void executarOperacoesVenda(ArrayList<ItemVenda> itensVenda, Venda venda, PagamentoVenda pagamentoVenda){
    this.itensVenda = new ArrayList<>(itensVenda);
    this.venda = venda;
    this.pagamentoVenda = pagamentoVenda;
    PreparedStatement stmt = null;
    
    try {
        con.setAutoCommit(false);
        
        //salvando venda
        controleVenda.saveVenda(venda);
        
        //salvando forma de pagamento
        controlePagamentoVenda.savePagamentos(pagamentoVenda);

        //salvando os itens na venda
        for (int i = 0; i < itensVenda.size(); i++) {
            itensVenda.get(i).setVenda(venda);
            controleItemVenda.saveItemVenda(itensVenda.get(i));
        }

        //atualizzando o estoque
        controleProduto.obterListaProdutos();
        for (int i = 0; i < itensVenda.size(); i++) {

            controleProduto.updateEstoque(itensVenda.get(i));

        }
        
        con.commit();
    } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex2) {

            }
        }finally{
            Conexao.closeConnection(con, stmt);
        }


}
}