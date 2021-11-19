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
import objetos.FormasPagamento;
import objetos.Produto;
import pdv.Conexao;

/**
 *
 * @author User
 */
public class ControleFormasPagamento {
    
    private Connection con = null;
    private ArrayList<FormasPagamento> pagamentos;
    
    
   public ControleFormasPagamento(ArrayList<FormasPagamento> pagamentos) {
        con = Conexao.getConnection();
        this.pagamentos = new ArrayList<FormasPagamento>(pagamentos);
        
    }
   
    public void savePagamentos(FormasPagamento pagamento) {
        
        PreparedStatement stmt = null;
        try {
            String sql = "insert into formas_pagamento (codigo, nome) values(?, ?)";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pagamento.getCodigo());
            stmt.setString(2, pagamento.getNome());
            stmt.executeUpdate();
            con.commit();
            
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex2) {

            }
        }finally{
           // Conexao.closeConnection(con, stmt);
        }
        
    }
    
    public void updatePagamanetos(FormasPagamento pagamento){
        
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE formas_pagamento SET nome = ?  WHERE  codigo = ?;";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setString(1, pagamento.getNome());
            stmt.setInt(2, pagamento.getCodigo());
            stmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex2) {
               
            }finally{
              //  Conexao.closeConnection(con, stmt);
            }
        }
        
   }
    
    public void deletePagamento(FormasPagamento pagamento){
        
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM formas_pagamento WHERE codigoProduto = ?";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, pagamento.getCodigo());
            stmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex2) {
               
            }finally{
                //Conexao.closeConnection(con, stmt);
            }
        }
        
   }
    
    public void findAll() {
        limpar();
        String sql = "select * from formas_pagamento";
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                FormasPagamento pagamento = new FormasPagamento();
                pagamento.setCodigo(rs.getInt("codigo"));
                pagamento.setNome(rs.getString("nome"));
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
    
    
    public ArrayList<FormasPagamento> obterListaPagamentos() {
        findAll();
        return pagamentos;
    }
    
   
    
    public FormasPagamento getPagamentos(int i){
        return pagamentos.get(i);
    }

    public void setPagamentos(int i, FormasPagamento pagamento){
        pagamentos.set(i, pagamento); 
        //gravarClientesArquivo();
    }
    
    public void cadastrarPagamentos(FormasPagamento pagamento) {
        //consultarClientesArquivo();
        pagamentos.add(pagamento);
        savePagamentos(pagamento);
    }
    
    

    public void removerPagamentos(int i) {
        pagamentos.remove(i);
        //gravarClientesArquivo();
    }
    
    public FormasPagamento selecionarPagamentoCod(int codigo) {
         //consultarClientesArquivo();

        if (!pagamentos.isEmpty()) {
            for (int i = 0; i <= pagamentos.size(); i++) {
                if (pagamentos.get(i).getCodigo() == codigo) {
                    return pagamentos.get(i);
                }
            }

        }
        return null;
    }
}
