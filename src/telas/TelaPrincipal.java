/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controladores.ControleProduto;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import objetos.Funcionario;
import objetos.FuncionarioPF;
import objetos.ItemVenda;

/**
 *
 * @author User
 */
public class TelaPrincipal extends javax.swing.JFrame {
   private ControleProduto controleProduto;
   private int fieldLength = 0;
   private FuncionarioPF usuario;
   private ArrayList<ItemVenda> auxiliar; //lista para ir salvando os itens da venda antes de passar as informações ao BD
   private DefaultListModel lista;
   private String subTotal;
   private int qtdProdutos;
   private ItemVenda itensVenda;
   
    public TelaPrincipal(FuncionarioPF funcionario) {
        
        initComponents();
        qtdProdutos = 0;
        subTotal = null;
        auxiliar = new ArrayList<>();
        controleProduto = new ControleProduto(new ArrayList<>());
        usuario = funcionario;
        jTextUsuario.setText(usuario.getNome());
        jTextUsuario.setEditable(false);
        lista = new DefaultListModel();
        
        txtQuantidade.setEnabled(false);
        txtPesoLiquido.setEditable(false);
        txtUnidadeAbnt.setEditable(false);
        txtPrecoUnd.setEditable(false);
        txtPrecoTotal.setEditable(false);
        txtPane.setEditable(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPrecoUnd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrecoTotal = new javax.swing.JTextField();
        txtPesquisa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtInserir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLista = new javax.swing.JList<>();
        txtFinaliza = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPane = new javax.swing.JTextPane();
        jTextUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPesoLiquido = new javax.swing.JTextField();
        txtUnidadeAbnt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Quantidade:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Preço unitário (kg, g, L, ml, pct):");

        txtPrecoUnd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Preço total item:");

        txtPrecoTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrecoTotal.setText("0");

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPesquisa.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtPesquisaComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                txtPesquisaComponentRemoved(evt);
            }
        });
        txtPesquisa.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtPesquisaInputMethodTextChanged(evt);
            }
        });
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Código do produto:");

        txtInserir.setText("Inserir Produto");
        txtInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInserirActionPerformed(evt);
            }
        });

        jLista.setBackground(new java.awt.Color(255, 255, 153));
        jLista.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jScrollPane1.setViewportView(jLista);

        txtFinaliza.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtFinaliza.setText("Finalizar Compra");
        txtFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFinalizaActionPerformed(evt);
            }
        });

        txtPane.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jScrollPane2.setViewportView(txtPane);

        jTextUsuario.setText("jTextField1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Usuário:");

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Peso liquido Vendido:");

        txtPesoLiquido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPesoLiquido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesoLiquidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesoLiquidoKeyReleased(evt);
            }
        });

        txtUnidadeAbnt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("R$");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("R$");

        txtQuantidade.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtQuantidade.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        txtQuantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtQuantidadeStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Sub-Total:");

        txtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSubTotal.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("R$");

        jMenu1.setText("File");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("jMenuItem2");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtFinaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPesoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecoUnd, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(310, 310, 310)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(txtUnidadeAbnt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(601, 601, 601)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(690, 690, 690)
                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(150, 150, 150)
                                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(4, 4, 4)
                                .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(txtInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7))
                            .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addComponent(txtInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(txtPesoLiquido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtPrecoUnd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(txtUnidadeAbnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(txtFinaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(851, 589));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFinalizaActionPerformed
        if(!"0".equals(txtSubTotal.getText())){
        
            subTotal = txtSubTotal.getText();
            FinalizaCompra finalizaCompra = new FinalizaCompra(usuario, auxiliar, subTotal, qtdProdutos);
            auxiliar.clear();
            dispose();
            finalizaCompra.setVisible(true);
            
        }else{
            
        }
    }//GEN-LAST:event_txtFinalizaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        TelaControle telaControle = new TelaControle (null, true, usuario);
        
        dispose();
        telaControle.setVisible(true);
        
        
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void txtInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInserirActionPerformed
        itensVenda = new ItemVenda();
        jLista.setModel(lista);
        String qtd = "";
        BigDecimal a = new BigDecimal(txtPrecoTotal.getText());
        BigDecimal b = new BigDecimal(txtSubTotal.getText()).add(a);
        BigDecimal l = new BigDecimal(txtPrecoUnd.getText());

        if ("Código Inesistente!".equals(txtPesquisa.getText())) {
        } else {
            for (int i = 0; i < controleProduto.ObterPesquisaProduto(txtPesquisa.getText(), 1).size(); i++) {

                if (Integer.parseInt(txtPesquisa.getText()) == controleProduto.getProduto(i).getCodigo()) {

                    if (controleProduto.getProduto(i).isVendaFraconada() == false) {

                        txtSubTotal.setText(b.toPlainString());
                        lista.addElement(controleProduto.getProduto(i).getNome() + "" + txtPesoLiquido.getText() + txtUnidadeAbnt.getText());
                        lista.addElement(controleProduto.getProduto(i).getPreco() + "R$");
                        lista.addElement("---------------------------------------");


                    } else {
                        if ("0".equals(txtPesoLiquido.getText())) {
                            JOptionPane.showMessageDialog(null, "Selecione o peso deste produto!");
                        } else {
                            txtSubTotal.setText(b.toPlainString());

                            qtd = txtPesoLiquido.getText();
                            

                            lista.addElement(controleProduto.getProduto(i).getNome() + "" + txtPesoLiquido.getText() + txtUnidadeAbnt.getText());
                            lista.addElement(txtPrecoTotal.getText() + "R$");
                            lista.addElement("---------------------------------------");

                            txtPesoLiquido.setText("0");
                        }
                    }
                }
                
                qtdProdutos = qtdProdutos + 1;
                itensVenda.setQtdItem(txtPesoLiquido.getText());
                itensVenda.setPrecoUnitario(l);
                itensVenda.setVenda(null);
                itensVenda.setProduto(controleProduto.getProduto(i));
                auxiliar.add(itensVenda);
                
                
                jLista.setModel(lista);
            }
            txtPesoLiquido.setText("0");
            txtUnidadeAbnt.setText("");
            txtQuantidade.setValue(0);
            txtPrecoTotal.setText("0");
            txtPesquisa.setText("");
            txtQuantidade.setEnabled(false);
            txtPesoLiquido.setEditable(false);
        }


    }//GEN-LAST:event_txtInserirActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
       
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void txtPesquisaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtPesquisaComponentAdded
        
    }//GEN-LAST:event_txtPesquisaComponentAdded

    private void txtPesquisaComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtPesquisaComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaComponentRemoved

    private void txtPesquisaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtPesquisaInputMethodTextChanged
       
        
    }//GEN-LAST:event_txtPesquisaInputMethodTextChanged

    private void txtPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyPressed
        fieldLength = txtPesquisa.getText().length();
    }//GEN-LAST:event_txtPesquisaKeyPressed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        if (fieldLength > txtPesquisa.getText().length()) {
            txtPane.setText("");
            txtUnidadeAbnt.setText("0");
            txtPesoLiquido.setText("0");
            txtPrecoUnd.setText("0");
            txtPrecoTotal.setText("0");
            txtQuantidade.setEnabled(false);
            txtPesoLiquido.setEditable(false);

        } else {
            int d = controleProduto.ObterPesquisaProduto(txtPesquisa.getText(), 1).size();
            if (d == 0) {
                txtPane.setText("Código Inesistente!");
            } else {
                for (int i = 0; i < d; i++) {
                    if (Integer.parseInt(txtPesquisa.getText()) == controleProduto.getProduto(i).getCodigo()) {
                        txtPane.setText(controleProduto.getProduto(i).getNome());
                        txtUnidadeAbnt.setText(controleProduto.getProduto(i).getUnidadeAbnt());
                        txtPrecoUnd.setText(controleProduto.getProduto(i).getPreco().toPlainString());
                        txtPrecoTotal.setText(txtPrecoUnd.getText());
                        
                        if(controleProduto.getProduto(i).isVendaFraconada() == true){
                            txtPesoLiquido.setEditable(true);
                            txtPesoLiquido.setText("0");
                        }else{
                            txtQuantidade.setEnabled(true);
                            txtPesoLiquido.setText(Float.toString(controleProduto.getProduto(i).getQtdUnidadeAbt()));
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void txtQuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtQuantidadeStateChanged
        txtQuantidade.getValue().toString();
        BigDecimal a = new BigDecimal(txtQuantidade.getValue().toString());
        BigDecimal b = new BigDecimal(txtPrecoUnd.getText());

        int d = controleProduto.ObterPesquisaProduto(txtPesquisa.getText(), 1).size();
        if (d != 0) {
            for (int i = 0; i < d; i++) {
                if (Integer.parseInt(txtPesquisa.getText()) == controleProduto.getProduto(i).getCodigo()) {

                    BigDecimal res = a.multiply(b).setScale(2, 5);
                    
                    txtPrecoTotal.setText(res.toPlainString());

                }
            }
        } else {

        }
    }//GEN-LAST:event_txtQuantidadeStateChanged

    private void txtPesoLiquidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoLiquidoKeyPressed
        fieldLength = txtPesoLiquido.getText().length();
        
    }//GEN-LAST:event_txtPesoLiquidoKeyPressed

    private void txtPesoLiquidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoLiquidoKeyReleased
        if (fieldLength > txtPesoLiquido.getText().length()) {

        } else {
            BigDecimal b = new BigDecimal(txtPesoLiquido.getText());
            BigDecimal c = new BigDecimal(txtPrecoUnd.getText());
            BigDecimal res = b.multiply(c).setScale(2, 5);
            txtPrecoTotal.setText(res.toPlainString());
           
        }
    }//GEN-LAST:event_txtPesoLiquidoKeyReleased

    
   /* public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jLista;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextUsuario;
    private javax.swing.JButton txtFinaliza;
    private javax.swing.JButton txtInserir;
    private javax.swing.JTextPane txtPane;
    private javax.swing.JTextField txtPesoLiquido;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPrecoTotal;
    private javax.swing.JTextField txtPrecoUnd;
    private javax.swing.JSpinner txtQuantidade;
    private javax.swing.JLabel txtSubTotal;
    private javax.swing.JTextField txtUnidadeAbnt;
    // End of variables declaration//GEN-END:variables
}
