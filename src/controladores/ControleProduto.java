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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import objetos.ItemVenda;
import objetos.Produto;
import pdv.Conexao;

/**
 *
 * @author User
 */


public class ControleProduto extends AbstractTableModel {

    private static final int COLUNA_CODIGO = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_QTDUND = 2; 
    private static final int COLUNA_UNIDADE = 3;
    private static final int COLUNA_PRECO = 4;
    private static final int COLUNA_ESTOQUE = 5;
    private static final int COLUNA_FRACIONADA = 6;
    
    
    private Connection con = null;
    private String[] colunas = new String[]{"Código", "Nome", "Quantidade Unidade", "Unidade abnt", "Preço", "Estoque", "Fracionada"};
    private ArrayList<Produto> produtos;
    
    
   public ControleProduto(ArrayList<Produto> produtos) {
        con = Conexao.getConnection();
        this.produtos = new ArrayList<>(produtos);
        
    }
   
    public void saveProduto(Produto produto) {
        ZoneId zoneId = ZoneId.systemDefault();
        produto.setCodigo((int) LocalDateTime.now().atZone(zoneId).toEpochSecond());
        PreparedStatement stmt = null;
        produtos.add(produto);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
        try {
            
            String sql = "insert into produto (nome, qtd_unidade_abnt, unidade_abnt, preco, qtd_estoque, venda_fracionada, codigo) values(?, ?, ?, ?, ?, ?, ?)";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getQtdUnidadeAbt());
            stmt.setString(3, produto.getUnidadeAbnt());
            stmt.setBigDecimal(4, produto.getPreco());
            stmt.setFloat(5, produto.getQtdEstoque());
            stmt.setBoolean(6, produto.isVendaFraconada());
            stmt.setInt(7, produto.getCodigo());
            stmt.executeUpdate();
            con.commit();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
            try {
                con.rollback();
            } catch (SQLException ex2) {

            }
        }finally{
            //Conexao.closeConnection(con, stmt);
        }
        
    }
    
    
    
    public void updateProduto(Produto produto, int i){
        
        PreparedStatement stmt = null;
        produtos.set(i, produto); 
        fireTableRowsUpdated(i, i);
        try {
            String sql = "UPDATE produto SET nome = ?, qtd_unidade_abnt = ?, unidade_abnt = ?, preco = ?, qtd_estoque = ?, venda_fracionada = ? WHERE codigo = ?;";
            stmt = con.prepareStatement(sql);
            con.setAutoCommit(false);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getQtdUnidadeAbt());
            stmt.setString(3, produto.getUnidadeAbnt());
            stmt.setBigDecimal(4, produto.getPreco());
            stmt.setFloat(5, produto.getQtdEstoque());
            stmt.setBoolean(6, produto.isVendaFraconada());
            stmt.setInt(7, produto.getCodigo());
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
    
    public void updateEstoque(ItemVenda itemVenda){
        
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE produto SET qtd_estoque = qtd_estoque - ? WHERE codigo = ?;";
            stmt = con.prepareStatement(sql);
            stmt.setFloat(1, Float.parseFloat(itemVenda.getQtdItem()));
            stmt.setInt(2, itemVenda.getProduto().getCodigo());
            
            stmt.executeUpdate();
            
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
    
    public void deleteProduto(Produto produto, int i){
        
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM produto WHERE codigo = ?";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getCodigo());
            stmt.executeUpdate();
            con.commit();
            produtos.remove(produto);
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
    
    public ArrayList<Produto> findAll() {
        limpar();
        String sql = "select * from produto";
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setQtdUnidadeAbt(rs.getFloat("qtd_unidade_abnt"));
                produto.setUnidadeAbnt(rs.getString("unidade_abnt"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produto.setQtdEstoque(rs.getFloat("qtd_estoque"));
                produto.setVendaFraconada(rs.getBoolean("venda_fracionada"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //Conexao.closeConnection(con, stmt, rs);
        }
         return produtos;
    }
    
    
    public ArrayList<Produto> ObterPesquisaProduto(String valor, int indice) {
        limpar();
        String op = "";
        String variavel = null;
        switch (indice) {
            case 1:
                variavel = "codigo";
                break;
            case 2:
                variavel = "nome";
                break;
            case 3:
                variavel = "unidade_abnt";
                break;
            case 4:
                variavel = "preco";
                break;
            case 5:
                variavel = "qtd_estoque";
                break;
            case 6:
                variavel = "qtd_unidade_abnt";
                break;
            case 7:
                variavel = "venda_fracionada";
        }
        
        if(indice == 1){
           op = "select * from produto where  "  +  variavel  +  " like '"  +  valor  + "'";
        }else{
           op = "select * from produto where  "  +  variavel  +  " like '%"  +  valor  + "%'";
        }
        String sql = op;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setQtdUnidadeAbt(rs.getFloat("qtd_unidade_abnt"));
                produto.setUnidadeAbnt(rs.getString("unidade_abnt"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produto.setQtdEstoque(rs.getFloat("qtd_estoque"));
                produto.setVendaFraconada(rs.getBoolean("venda_fracionada"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Conexao.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
         
    public void limpar() {
    
        produtos.clear();
 
    // Notifica a mudança.
    fireTableDataChanged();
}
    
   

    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public int getRowCount(){
        return produtos.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    public ArrayList<Produto> obterListaProdutos() {
        findAll();
        return produtos;
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
        Produto produto = produtos.get(row);
        switch(col){
            case COLUNA_CODIGO:
                return produto.getCodigo();
            case COLUNA_NOME:
                return produto.getNome();
            case COLUNA_UNIDADE:
                return produto.getUnidadeAbnt();
            case COLUNA_PRECO:
                return produto.getPreco();
            case COLUNA_ESTOQUE:
                return produto.getQtdEstoque();
            case COLUNA_QTDUND:
                return produto.getQtdUnidadeAbt();
            case COLUNA_FRACIONADA:
                return produto.isVendaFraconada();
        }
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column){
        Produto produto = produtos.get(row);
        
        switch(column){
            case COLUNA_CODIGO:
                 produto.setCodigo(produto.getCodigo());
            case COLUNA_NOME:
                 produto.setNome(aValue.toString());
            case COLUNA_UNIDADE:
                 produto.setUnidadeAbnt(aValue.toString());
            case COLUNA_PRECO:
                 produto.setPreco(produto.getPreco());
            case COLUNA_ESTOQUE:
                 produto.setQtdEstoque(produto.getQtdEstoque());
            case COLUNA_QTDUND:
                 produto.setQtdUnidadeAbt(produto.getQtdUnidadeAbt());
            case COLUNA_FRACIONADA:
                produto.setVendaFraconada(produto.isVendaFraconada());
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
    
   
    
    public Produto getProduto(int i){
        return produtos.get(i);
    }

    public void setProduto(int i, Produto produto){
        produtos.set(i, produto); 
        fireTableRowsUpdated(i, i);
        //gravarClientesArquivo();
    }
    
   /* public void cadastrarProduto(Produto produto) {
        //consultarClientesArquivo();
        produtos.add(produto);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
        saveProduto(produto);
    }
    
    

    public void removerProduto(int i) {
        produtos.remove(i);
        fireTableRowsDeleted(i, i);
    }*/

}