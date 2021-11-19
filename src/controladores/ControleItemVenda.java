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
import javax.swing.table.AbstractTableModel;
import objetos.ItemVenda;
import objetos.Venda;
import pdv.Conexao;

/**
 *
 * @author User
 */
public class ControleItemVenda extends AbstractTableModel {
    private static final int COLUNA_COD_VENDA = 0;
    private static final int COLUNA_PRODUTO = 1;
    private static final int COLUNA_QTD = 2;
    private static final int COLUNA_PRECO = 3;
    
    private ControleProduto controleProduto;
    private ControleVenda controleVenda;
    private Connection con = null;
    private String[] colunas = new String[]{"Código da venda", "Produto", "Quantidade", "Preço Unidade"};
    private ArrayList<ItemVenda> itemVendas;
    
    
   public ControleItemVenda(ArrayList<ItemVenda> itemVendas) {
        this.controleProduto = new ControleProduto(new ArrayList<> ());
        this.controleVenda = new ControleVenda (new ArrayList<>());
        con = Conexao.getConnection();
        this.itemVendas = new ArrayList<>(itemVendas);
        
    }
   
    public void saveItemVenda(ItemVenda itemVenda) {
        
        PreparedStatement stmt = null;
        try {
            String sql = "insert into item_venda (codigo_venda,codigo_produto, qtd_item, preco_unitario) values(?, ?, ?, ?)";
            //con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, itemVenda.getVenda().getCodigoVenda());
            stmt.setInt(2, itemVenda.getProduto().getCodigo());
            stmt.setString(3, itemVenda.getQtdItem());
            stmt.setBigDecimal(4, itemVenda.getProduto().getPreco());
            stmt.executeUpdate();
            //con.commit();
            itemVendas.add(itemVenda);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
            /*try {
                
            } catch (SQLException ex2) {

            }
        }finally{
           // Conexao.closeConnection(con, stmt);*/
        }
        
    }
    
    
  
    
    
    public void findAll() {
        limpar();
        String sql = "select * from item_venda";
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            String f = null;
            int s = 0;
            while(rs.next()){
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setQtdItem(rs.getString("qtd_item"));
                itemVenda.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                
                f = Integer.toString(rs.getInt("codigo_venda"));
                for (int i = 0; i < controleVenda.ObterPesquisaVenda(f, 1).size(); i++) {
                    s = Integer.parseInt(f);
                if (controleVenda.getVenda(i).getCodigoVenda()== s ) {
                    itemVenda.setVenda(controleVenda.getVenda(i));
                }
            }
                
                f = Integer.toString(rs.getInt("codigo_produto"));
                for (int i = 0; i < controleProduto.ObterPesquisaProduto(f, 1).size(); i++) {
                    s = Integer.parseInt(f);
                if (controleProduto.getProduto(i).getCodigo()== s ) {
                    itemVenda.setProduto(controleProduto.getProduto(i));
                }
            }
                
                itemVendas.add(itemVenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //Conexao.closeConnection(con, stmt, rs);
        }
         
    }
    
    
    public ArrayList<ItemVenda> ObterPesquisaItemVenda(String valor, int indice) {
        limpar();
        String variavel = null;
        switch (indice) {
            case 1:
                variavel = "codigo_venda";
                break;
            case 2:
                variavel = "codigo_produto";
                break;
            case 3:
                variavel = "qtd_item";
                break;
            case 4:
                variavel = "preco_unitario";
                break;
            
        }

        String sql = "select * from item_venda where  "  +  variavel  +  " like '"  +  valor  + "'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            String f = null;
            int s = 0;
            while (rs.next()) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setQtdItem(rs.getString("qtd_item"));
                itemVenda.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                f = Integer.toString(rs.getInt("codigo_venda"));
                for (int i = 0; i < controleVenda.ObterPesquisaVenda(f, 1).size(); i++) {
                    s = Integer.parseInt(f);
                if (controleVenda.getVenda(i).getCodigoVenda()== s ) {
                    itemVenda.setVenda(controleVenda.getVenda(i));
                }
            }
                
                f = Integer.toString(rs.getInt("codigo_produto"));
                for (int i = 0; i < controleProduto.ObterPesquisaProduto(f, 1).size(); i++) {
                    s = Integer.parseInt(f);
                if (controleProduto.getProduto(i).getCodigo()== s ) {
                    itemVenda.setProduto(controleProduto.getProduto(i));
                }
            }
                
                itemVendas.add(itemVenda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Conexao.closeConnection(con, stmt, rs);
        }
        return itemVendas;
    }
         
    public void limpar() {
    
        itemVendas.clear();
 
    fireTableDataChanged();
}
    
   

    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public int getRowCount(){
        return itemVendas.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    public ArrayList<ItemVenda> obterListaItemVendas() {
        findAll();
        return itemVendas;
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
        ItemVenda itemVenda = itemVendas.get(row);
        switch(col){
            case COLUNA_COD_VENDA:
                return itemVenda.getVenda().getCodigoVenda();
            case COLUNA_PRODUTO:
                return itemVenda.getProduto().getNome();
            case COLUNA_QTD:
                return itemVenda.getQtdItem();
            case COLUNA_PRECO:
                return itemVenda.getPrecoUnitario();
           }
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column){
        ItemVenda itemVenda = itemVendas.get(row);
        
        switch(column){
            case COLUNA_COD_VENDA:
                 itemVenda.setVenda(itemVenda.getVenda());
            case COLUNA_PRODUTO:
                 itemVenda.setProduto(itemVenda.getProduto());
            case COLUNA_QTD:
                 itemVenda.setQtdItem(itemVenda.getQtdItem());
            case COLUNA_PRECO:
                 itemVenda.setPrecoUnitario(itemVenda.getPrecoUnitario());
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
    
   
    
    public ItemVenda getItemVenda(int i){
        return itemVendas.get(i);
    }

    public void setItemVenda(int i, ItemVenda itemVenda){
        itemVendas.set(i, itemVenda); 
        fireTableRowsUpdated(i, i);
        //gravarClientesArquivo();
    }
}
