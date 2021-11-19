/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import enums.Funcao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import objetos.Funcionario;
import objetos.FuncionarioPF;
import objetos.FuncionarioPJ;
import pdv.Conexao;

/**
 *
 * @author User
 */
public class ControleFuncionario extends AbstractTableModel {
    private static final int COLUNA_ID = 0;
    private static final int COLUNA_NOME = 1;
    private static final int COLUNA_CPF = 2;
    private static final int COLUNA_FUNCAO = 3;
    private static final int COLUNA_SALARIO = 4;
    private static final int COLUNA_TELEFONE = 5;
   
    private Connection con = null;
    private String[] colunas = new String[]{"Id", "Nome", "CPF", "Função", "Salário", "Telefone"};
    private ArrayList<FuncionarioPF> funcionarios;
    
    
   public ControleFuncionario(ArrayList<FuncionarioPF> funcionarios) {
        con = Conexao.getConnection();
        this.funcionarios = new ArrayList<> (funcionarios);
        
    }
   
   public void saveFuncionario(FuncionarioPF funcionario){
        PreparedStatement stmt = null;
        funcionarios.add(funcionario);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
        try {
            String sql = "INSERT INTO funcionario (id_func, nome, cpf, funcao, senha, salario, logado, telefone) VALUES(?, ?, ?, ?, ?, ?, false, ?)";
            con.setAutoCommit(false);
            
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId_func());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getCpf());
            stmt.setString(4, funcionario.getFuncao());
            stmt.setString(5, funcionario.getSenha());
            stmt.setBigDecimal(6, funcionario.getSalario());
            stmt.setString(7, funcionario.getTelefone());
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
   
    public void updateFuncionario(FuncionarioPF funcionario, int i){
       
        PreparedStatement stmt = null;
        funcionarios.set(i, funcionario); 
        fireTableRowsUpdated(i, i);
        try {
            String sql = "UPDATE funcionario SET nome = ?, cpf = ?, funcao = ?, senha = ?, salario = ?, telefone = ? WHERE id_func = ?;";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getFuncao());
            stmt.setString(4, funcionario.getSenha());
            stmt.setInt(7, funcionario.getId_func());
            stmt.setString(6, funcionario.getTelefone());
            stmt.setBigDecimal(5, funcionario.getSalario());
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
    
    public void setLogInLogOut(Funcionario funcionario){
        PreparedStatement stmt = null;
        try {
            String sql = "UPDATE funcionario SET logado = ? WHERE id_func = ?;";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, funcionario.getLogado());
            stmt.setInt(2, funcionario.getId_func());
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

    public void deleteFuncionario(Funcionario funcionario, int i){
        
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE FROM funcionario WHERE id_func = ?";
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, funcionario.getId_func());
            stmt.executeUpdate();
            con.commit();
            funcionarios.remove(i);
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
    
      public ArrayList<FuncionarioPF> findAll() {
        limpar();
        String sql = "select * from funcionario ";
        PreparedStatement stmt = null;
        ResultSet rs = null;

       
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                FuncionarioPF funcionario = new FuncionarioPF();
                funcionario.setId_func(rs.getInt("id_func"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setSalario(rs.getBigDecimal("salario"));
                funcionario.setLogado(rs.getBoolean("logado"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
          //  Conexao.closeConnection(con, stmt, rs);
        }
        return funcionarios;
         
    }  
      
     public ArrayList<FuncionarioPF> ObterPesquisaFuncionario(String valor, int i) {
         limpar();
         String variavel = null;
        switch(i){
            case 1:
                variavel = "id_func";
                break;
            case 2:
                variavel = "nome";
                break;
            case 3:
                variavel = "cpf";
                break;
            case 4:
                variavel = "funcao";
                break;
            case 5:
                variavel = "senha";
                break;
            case 6:
                variavel = "salario";
                break;
            case 7:
                variavel = "telefone";
                break;
        }
        
        String sql = "select * from funcionario where  "  +  variavel  +  " like '%"  +  valor  + "%'";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                FuncionarioPF funcionario = new FuncionarioPF();
                funcionario.setId_func(rs.getInt("id_func"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setSalario(rs.getBigDecimal("salario"));
                funcionario.setLogado(rs.getBoolean("logado"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleProduto.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //Conexao.closeConnection(con, stmt, rs);
        }
        
        return funcionarios;
}

     
    public void limpar() {
    
        funcionarios.clear();
 
    // Notifica a mudança.
    fireTableDataChanged();
}
    
   

    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public int getRowCount(){
        return funcionarios.size();
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    public ArrayList<FuncionarioPF> obterListaFuncionarios() {
        findAll();
        return funcionarios;
    }
    
    
   /* public ArrayList<Funcionario> obterListaVazia(){
        funcionarios.clear();
        return funcionarios;
    }*/
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
    
    @Override
    public Object getValueAt(int row, int col){
        FuncionarioPF funcionario = funcionarios.get(row);
        switch(col){
            case COLUNA_ID:
                return funcionario.getId_func();
            case COLUNA_NOME:
                return funcionario.getNome();
            case COLUNA_CPF:
                return funcionario.getCpf();
            case COLUNA_FUNCAO:
                return funcionario.getFuncao();
            case COLUNA_SALARIO:
                return funcionario.getSalario();
            case COLUNA_TELEFONE:
                return funcionario.getTelefone();
              }
        return "";
    }
    
    @Override
    public void setValueAt(Object aValue, int row, int column){
        FuncionarioPF funcionario = funcionarios.get(row);
        
        switch(column){
            case COLUNA_ID:
                 funcionario.setId_func(funcionario.getId_func());
            case COLUNA_NOME:
                 funcionario.setNome(aValue.toString());
            case COLUNA_CPF:
                 funcionario.setCpf(aValue.toString());
            case COLUNA_FUNCAO:
                 funcionario.setFuncao(funcionario.getFuncao());
            case COLUNA_SALARIO:
                funcionario.setSalario(funcionario.getSalario());
            case COLUNA_TELEFONE:
                funcionario.setTelefone(funcionario.getTelefone());
                 
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
    
   
    
    public FuncionarioPF getFuncionario(int i){
        return funcionarios.get(i);
    }

    public void setFuncionario(int i, FuncionarioPF funcionario){
        funcionarios.set(i, funcionario); 
        fireTableRowsUpdated(i, i);
        //gravarClientesArquivo();
    }
    
    
    
  /*  public void cadastrarFuncionario(Funcionario funcionario) {
        //consultarClientesArquivo();
        findAll();
        funcionarios.add(funcionario);
        int ultimo = getRowCount()-1;
        fireTableRowsInserted(ultimo, ultimo);
        saveFuncionario(funcionario);
    }
    
    

    public void removerFuncionario(int i) {
        funcionarios.remove(i);
        fireTableRowsDeleted(i, i);
        //gravarClientesArquivo();
    }*/
    
}