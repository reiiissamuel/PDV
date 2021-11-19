/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;


import controladores.ControleFormasPagamento;
import controladores.ControleItemVenda;
import controladores.ControleOperacoes;
import controladores.ControlePagamentoVenda;
import controladores.ControleProduto;
import controladores.ControleVenda;
import java.math.BigDecimal;
import java.util.ArrayList;
import objetos.Funcionario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import objetos.FuncionarioPF;
import objetos.ItemVenda;
import objetos.PagamentoVenda;
import objetos.Produto;
import objetos.Venda;

/**
 *
 * @author User
 */
public class FinalizaCompra extends javax.swing.JFrame {
    private int fieldLength = 0;
    private FuncionarioPF usuario;
    private ArrayList<ItemVenda> auxiliar;
    private ControleItemVenda controleItemVenda;
    private ControleVenda controleVenda;
    private int cod;
    private LocalDate data;
    private String dataFormatada;
    private String total;
    private int qtdItens;
    private Venda venda;
    private Produto produto;
    private PagamentoVenda pagamentoVenda;
    private ControlePagamentoVenda controlePagamentoVenda;
    private ControleFormasPagamento controleFormasPagamento;
    private ControleProduto controleProduto;
    private ControleOperacoes controleOperacoes;
    
    
    public FinalizaCompra(FuncionarioPF funcionario, ArrayList<ItemVenda> auxiliar, String subTotal, int qtdItens) {
        usuario = funcionario;
        total = subTotal;
        venda = new Venda();
        pagamentoVenda = new PagamentoVenda();
        produto = new Produto();
        
        this.qtdItens = qtdItens;
        controleOperacoes = new ControleOperacoes();
        controleProduto = new ControleProduto(new ArrayList<>());
        controleFormasPagamento = new ControleFormasPagamento(new ArrayList<>());
        controlePagamentoVenda = new ControlePagamentoVenda(new ArrayList<>());
        controleItemVenda = new ControleItemVenda(new ArrayList<>());
        controleVenda = new ControleVenda(new ArrayList<>()); 
        this.auxiliar = new ArrayList<>(auxiliar);
        initComponents();
        
        data = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dataFormatada = data.format(formatter);
        
        ZoneId zoneId = ZoneId.systemDefault();
        cod = (int) LocalDateTime.now().atZone(zoneId).toEpochSecond();
        txtVendedor.setText(usuario.getNome());
        txtCod.setText(Integer.toString(cod));
        txtData.setText(dataFormatada);
        txtTotal.setText(total);
        txtTotal.setEditable(false);
        txtQtdItens.setText(Integer.toString(qtdItens));
        txtQtdItens.setEditable(false);
        txtTroco.setEditable(false);
        txtDinheiro.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtDinheiro = new javax.swing.JTextField();
        jComboPagamento = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtQtdItens = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCancela = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JLabel();
        txtCod = new javax.swing.JLabel();
        txtData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Dinheiro Recebido:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Forma de pagamento:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Total R$");

        txtDinheiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDinheiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDinheiroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDinheiroKeyReleased(evt);
            }
        });

        jComboPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "Dinheiro", "Crédito", "Débito", "Cartão da loja" }));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("R$");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Troco:");

        txtTroco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("R$");

        btnFinalizar.setText("Proxima Venda >>");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Qtd de itens:");

        txtQtdItens.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtQtdItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdItensActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("R$");

        txtCancela.setText("Cancelar Compra");
        txtCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCancelaActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Vendedor:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Códiogo da Venda:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Data:");

        txtVendedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtVendedor.setText("vendedor");

        txtCod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCod.setText("cod");

        txtData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtData.setText("data");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(77, 77, 77)
                                .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel23))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(txtQtdItens))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(17, 17, 17)
                                .addComponent(jComboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdItens, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jComboPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(372, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtQtdItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdItensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdItensActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (jComboPagamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione a quantia que lhe foi passado!");

        } else if ("0".equals(txtDinheiro.getText()) && jComboPagamento.getSelectedIndex() == 1) {
            JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento!");

        } else {
            
            //salvando a venda
            venda.setCodigoVenda(cod);
            venda.setData(data);
            venda.setFuncionario(usuario);
            BigDecimal tF = new BigDecimal(txtTotal.getText());
            venda.setPrecoTotal(tF);
            venda.setQtdItens(Integer.parseInt(txtQtdItens.getText()));
            
            
            
           /* //salvando os itens da venda
            for (int i = 0; i < auxiliar.size(); i++) {
                auxiliar.get(i).setVenda(venda);
                controleItemVenda.saveItemVenda(auxiliar.get(i));
            }*/
            
            //salvandao forma de pagamento 
           
            for(int i = 0; i < controleFormasPagamento.obterListaPagamentos().size(); i ++){
                if(controleFormasPagamento.getPagamentos(i).getCodigo() == jComboPagamento.getSelectedIndex()){
                   pagamentoVenda.setFormasPagamento(controleFormasPagamento.getPagamentos(i));
                   pagamentoVenda.setFormasPagamento(controleFormasPagamento.getPagamentos(i));
                }
            }
            pagamentoVenda.setVenda(venda);
            
            
            /*//atualização de estoque
            controleProduto.obterListaProdutos();
            for (int i = 0; i < auxiliar.size(); i++) {
                float f = controleProduto.getProduto(0).getEstoque() - Float.parseFloat(auxiliar.get(i).getQtdItem());
                controleProduto.getProduto(i).setEstoque(f);
                controleProduto.updateProduto(controleProduto.getProduto(i), i);
            }*/
            
            System.out.println(venda.getCodigoVenda());
            System.out.println(pagamentoVenda.getVenda().getCodigoVenda());
            System.out.println(auxiliar.size());

            controleOperacoes.executarOperacoesVenda(auxiliar, venda, pagamentoVenda);
            
            TelaPrincipal telaPrincipal = new TelaPrincipal(usuario);
            dispose();
            telaPrincipal.setVisible(true);
        }

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCancelaActionPerformed
        Confirma confirma = new Confirma(null, true);
        confirma.setVisible(true);
        boolean retorno = confirma.Op();
        if (retorno == true) {
            TelaPrincipal telaPrincipal = new TelaPrincipal(usuario);
            dispose();
            telaPrincipal.setVisible(true);
        }

    }//GEN-LAST:event_txtCancelaActionPerformed

    private void txtDinheiroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDinheiroKeyReleased
        BigDecimal a = new BigDecimal(txtDinheiro.getText());
        BigDecimal b = new BigDecimal(total);
        BigDecimal res = a.subtract(b).setScale(2, 5);
        txtTroco.setText(res.toPlainString());
    }//GEN-LAST:event_txtDinheiroKeyReleased

    private void txtDinheiroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDinheiroKeyPressed
        fieldLength = txtDinheiro.getText().length();
    }//GEN-LAST:event_txtDinheiroKeyPressed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JComboBox<String> jComboPagamento;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton txtCancela;
    private javax.swing.JLabel txtCod;
    private javax.swing.JLabel txtData;
    private javax.swing.JTextField txtDinheiro;
    private javax.swing.JTextField txtQtdItens;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JLabel txtVendedor;
    // End of variables declaration//GEN-END:variables
}