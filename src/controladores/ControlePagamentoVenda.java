/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.PagamentoVenda;
import pdv.Conexao;

/**
 *
 * @author User
 */
public class ControlePagamentoVenda {
    private ControleVenda controleVenda;
    private ControleFormasPagamento controleFormasPagamento;
    private Connection con = null;
    private ArrayList<PagamentoVenda> pagamentos;
    
   public ControlePagamentoVenda (ArrayList<PagamentoVenda> pagamentos) {
       this.controleFormasPagamento = new ControleFormasPagamento(new ArrayList<>());
       this.controleVenda = new ControleVenda (new ArrayList<>());
        con = Conexao.getConnection();
        this.pagamentos = new ArrayList<>(pagamentos);
    }
   
   
    public void savePagamentos(PagamentoVenda pagamento) {
        
        PreparedStatement stmt = null;
        try {
            String sql = "insert into pagamento_venda (codigo_venda, codigo_pagamento) values(?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pagamento.getVenda().getCodigoVenda());
            stmt.setInt(2, pagamento.getFormasPagamento().getCodigo());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
            
        }/*finally{
            Conexao.closeConnection(con, stmt);
        }*/
        
    }
    
    
    public void deletePagamentoVenda(PagamentoVenda pagamento){
        
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM pagamento_venda WHERE codigo_pagamento = ?";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pagamento.getFormasPagamento().getCodigo());
            stmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex2) {
               
            }finally{
                Conexao.closeConnection(con, stmt);
            }
        }
        
   }
    
    public void findAll() {
        limpar();
        String sql = "select * from pagamentos_venda";
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            String f = null;
            int s = 0;
            
            while(rs.next()){
                PagamentoVenda pagamento = new PagamentoVenda();
                
               f = Integer.toString(rs.getInt("codigo_venda"));
                for (int i = 0; i < controleVenda.ObterPesquisaVenda(f, 1).size(); i++) {
                    s = Integer.parseInt(f);
                if (controleVenda.getVenda(i).getCodigoVenda()== s ) {
                    pagamento.setVenda(controleVenda.getVenda(i));
                }
            }
                
                f = Integer.toString(rs.getInt("codigo_pagamento"));
                for (int i = 0; i < controleFormasPagamento.obterListaPagamentos().size(); i++) {
                    s = Integer.parseInt(f);
                if (controleFormasPagamento.getPagamentos(i).getCodigo()== s ) {
                    pagamento.setFormasPagamento(controleFormasPagamento.getPagamentos(i));
                }
            }
                pagamentos.add(pagamento);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //Conexao.closeConnection(con, stmt, rs);
        }
         
    }
    
    public void limpar() {
    
        pagamentos.clear();
}
    
    
    public ArrayList<PagamentoVenda> obterListaPagamentoVenda() {
        //consultarClientesArquivo();
        return pagamentos;
    }
    
    
    
    
    public PagamentoVenda getPagamentoVenda(int i){
        return pagamentos.get(i);
    }

    public void setPagamentoVenda(int i, PagamentoVenda pagamento){
        pagamentos.set(i, pagamento);        
    }}