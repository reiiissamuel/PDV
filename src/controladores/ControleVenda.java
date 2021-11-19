/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import objetos.Venda;
import pdv.Conexao;

/**
 *
 * @author User
 */
public class ControleVenda extends AbstractTableModel {
    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_VENDEDOR = 1;
    private static final int COLUNA_DATA = 2;
    private static final int COLUNA_QTD = 3;
    private static final int COLUNA_TOTAL = 4;
    
    private ControleFuncionario controleFuncionario;
    private Connection con = null;
    private String[] colunas = new String[]{"Código da venda", "Vendedor", "Data", "quantida de produtos", "total(R$)"};
    private ArrayList<Venda> vendas;
    
    
   public ControleVenda(ArrayList<Venda> vendas) {
        this.controleFuncionario = new ControleFuncionario(new ArrayList<> ());
        con = Conexao.getConnection();
        this.vendas = new ArrayList<>(vendas);
        
    }
   
    public void saveVenda(Venda venda) {
        PreparedStatement stmt; 
        try {
            String sql = "insert into venda (codigo_venda, data, total_itens, id_func, preco_total) values(?, ?, ?, ?, ?)";
            //con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, venda.getCodigoVenda());
            stmt.setDate(2, java.sql.Date.valueOf(venda.getData()));
            stmt.setInt(3, venda.getQtdItens());
            stmt.setInt(4, venda.getFuncionario().getId_func());
            stmt.setBigDecimal(5, venda.getPrecoTotal());
            stmt.executeUpdate();
            //con.commit();
            vendas.add(venda);
            //int ultimo = getRowCount()-1;
            //fireTableRowsInserted(ultimo, ultimo);
            
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
           /* try {
                con.rollback();
            } catch (SQLException ex2) {

            }
        }finally{
            Conexao.closeConnection(con, stmt);*/
        }
        
    }
    
    public void updateVenda(Venda venda, int i){
        
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE venda SET data = ?, total_itens = ?, id_func = ?, preco_total = ? WHERE codigo_venda = ?;";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, java.sql.Date.valueOf(venda.getData()));
            stmt.setInt(2, venda.getQtdItens());
            stmt.setInt(3, venda.getFuncionario().getId_func());
            stmt.setBigDecimal(4, venda.getPrecoTotal());
            stmt.executeUpdate();
            con.commit();
            vendas.set(i, venda); 
            fireTableRowsUpdated(i, i);
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
    
    public void deleteVenda(Venda venda, int i){
        
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM venda WHERE codigoProduto = ?";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, venda.getCodigoVenda());
            stmt.executeUpdate();
            con.commit();
            vendas.remove(venda);
            fireTableRowsDeleted(i, i);
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
        String sql = "select * from venda";
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Venda venda = new Venda();
                venda.setCodigoVenda(rs.getInt("codigo_venda"));
                venda.setData(rs.getDate("data").toLocalDate());
                venda.setQtdItens(rs.getInt("total_itens"));
                venda.setPrecoTotal(rs.getBigDecimal("preco_total"));
                String f = Integer.toString(rs.getInt("id_func"));
                for (int i = 0; i < controleFuncionario.ObterPesquisaFuncionario(f, 1).size(); i++) {
                    int s = Integer.parseInt(f);
                if (controleFuncionario.getFuncionario(i).getId_func() == s ) {
                    venda.setFuncionario(controleFuncionario.getFuncionario(i));
                    venda.setFuncionario(controleFuncionario.getFuncionario(i));
                }
            }
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           // Conexao.closeConnection(con, stmt, rs);
        }
         
    }
    
    
    public ArrayList<Venda> ObterPesquisaVenda(String valor, int indice) {
        limpar();
        String variavel = null;
        switch (indice) {
            case 1:
                variavel = "codigo_venda";
                break;
            case 2:
                variavel = "data";
                break;
            case 3:
                variavel = "total_itens";
                break;
            case 4:
                variavel = "preco_total";
                break;
            case 5:
                variavel = "id_func";
                break;
        }

        String sql = "select * from venda where  "  +  variavel  +  " like '%"  +  valor  + "%'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setCodigoVenda(rs.getInt("codigo_venda"));
                venda.setData(rs.getDate("data").toLocalDate());
                venda.setQtdItens(rs.getInt("total_itens"));
                venda.setPrecoTotal(rs.getBigDecimal("preco_total"));
                String f = Integer.toString(rs.getInt("id_func"));
                for (int i = 0; i < controleFuncionario.ObterPesquisaFuncionario(f, 1).size(); i++) {
                    int s = Integer.parseInt(f);
                if (controleFuncionario.getFuncionario(i).getId_func() == s ) {
                    venda.setFuncionario(controleFuncionario.getFuncionario(i));
                }
            }
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           // Conexao.closeConnection(con, stmt, rs);
        }
        return vendas;
    }
         
    public void limpar() {
    
        vendas.clear();
 
    // Notifica a mudança.
    fireTableDataChanged();
}
    
   

    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public int getRowCount(){
        return vendas.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    public ArrayList<Venda> obterListaVendas() {
        findAll();
        return vendas;
    }
    
    
   /* public ArrayList<Produto> obterListaVazia(){
        produtos.clear();
        return produtos;
    }*/
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    @Override
    public Object getValueAt(int row, int col){
        Venda venda = vendas.get(row);
        switch(col){
            case COLUNA_CODIGO:
                return venda.getCodigoVenda();
            case COLUNA_VENDEDOR:
                return venda.getFuncionario().getNome();
            case COLUNA_DATA:
                return venda.getData();
            case COLUNA_QTD:
                return venda.getQtdItens();
            case COLUNA_TOTAL:
                return venda.getPrecoTotal();
        }
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column){
        Venda venda = vendas.get(row);
        
        switch(column){
            case COLUNA_CODIGO:
                 venda.setCodigoVenda(venda.getCodigoVenda());
            case COLUNA_VENDEDOR:
                 venda.setFuncionario(venda.getFuncionario());
            case COLUNA_DATA:
                 venda.setData(venda.getData());
            case COLUNA_QTD:
                 venda.setQtdItens(venda.getQtdItens());
            case COLUNA_TOTAL:
                 venda.setPrecoTotal(venda.getPrecoTotal());
        }
        
    }
    
  /*  public void AtualizarRows(Produto produtos, String nome, String cpf, String tel){
        Produto produto = produtos;
        
            case COLUNA_CODIGO:
                 produto.setCodigo(produto.getCodigo());
            case COLUNA_NOME:
                 produto.setNome(aValue.toString());
            case COLUNA_UNIDADE:
                 produto.setUnidade(aValue.toString());
            case COLUNA_PRECO:
                 produto.setPreco(produto.getPreco());
            case COLUNA_ESTOQUE:
                 produto.setEstoque(produto.getEstoque());
          
    }*/
    
   
    
    public Venda getVenda(int i){
        return vendas.get(i);
    }

    public void setVenda(int i, Venda venda){
        vendas.set(i, venda); 
       // int ultimo = getRowCount()-1;
       // fireTableRowsInserted(i, i);
        fireTableRowsUpdated(i, i);
        
    }
}
