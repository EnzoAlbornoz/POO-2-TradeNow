/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.tradetoday.graphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import br.ufsc.tradetoday.backend.AlphaVantageAPI;
import br.ufsc.tradetoday.config.ConfigHandler;
import br.ufsc.tradetoday.config.ListHandler;

/**
 *
 * @author 18100527
 */
public class AnalyzePanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalyzePanel
     */
    public AnalyzePanel() {
        initComponents();
        api = new AlphaVantageAPI(ConfigHandler.getConfig().getCustomKey());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaCompra = new javax.swing.JList<>();
        compra = new javax.swing.JLabel();
        venda = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaVenda = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(42, 42, 42));
        setMaximumSize(new java.awt.Dimension(750, 540));
        setMinimumSize(new java.awt.Dimension(750, 540));
        setPreferredSize(new java.awt.Dimension(750, 540));

        jScrollPane1.setViewportView(listaCompra);

        compra.setBackground(new java.awt.Color(60, 60, 60));
        compra.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        compra.setForeground(new java.awt.Color(250, 250, 250));
        compra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        compra.setText("Compra");

        venda.setBackground(new java.awt.Color(60, 60, 60));
        venda.setFont(new java.awt.Font("Ubuntu", 1, 48)); // NOI18N
        venda.setForeground(new java.awt.Color(250, 250, 250));
        venda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        venda.setText("Venda");

        jScrollPane2.setViewportView(listaVenda);

        jButton1.setBackground(new java.awt.Color(85, 85, 85));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setText("Analyze");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(compra, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(compra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    	final int TRY_LIMIT = 250;
		int n;
		
		if (ListHandler.getSelectedType() != ListHandler.TYPE_STOCK) ListHandler.changeSelectedType();	// no api oscillator data for cryptocurrencies
		final String[] symbols = ListHandler.getSymbols();
    	
    	final String oscillator = ConfigHandler.getConfig().getRankingAlgorithm();
    	String upperKey = null, lowerKey = null;
    	switch (oscillator) {
    		case AlphaVantageAPI.INDICATOR_OSC_BOLLINGER:
    			upperKey = "Real Upper Band";
    			lowerKey = "Real Lower Band";
    			break;
    		
    		// TODO other oscillators
    			
    		default:
    			System.err.println("OnAnalyseFail() Tried analysing with an invalid oscillator!");;
    			return;
    	}
    	
    	List<String> buy = new ArrayList<>(symbols.length);
    	List<String> sell = new ArrayList<>(symbols.length);
    	    	
    	System.out.println("Analyse() Locking application while pulling data from API.");
    	symbols: for (String symbol : symbols) {
        	Map<String, String> stock = null;
        	n = 0;
            while ((stock = api.getStock(symbol, AlphaVantageAPI.TIME_DAILY)) == null) {
            	if (++n >= TRY_LIMIT) {
            		System.out.printf("\tOnRawRequestTimeout() Gave up after trying %d times.\n", n);
            		continue symbols;
            	}
            };
            
            Map<String, Map<String, String>> bbands = null;
            n = 0;
			while ((bbands = api.getIndicator(symbol, AlphaVantageAPI.TIME_DAILY, oscillator)) == null) {
				if (++n >= TRY_LIMIT) {
            		System.out.printf("\tOnIndicatorRequestTimeout() Gave up after trying %d times.\n", n);
            		continue symbols;
            	}
			};
			
			double last =	Double.parseDouble( stock.values().iterator().next() );
			double upper =	Double.parseDouble( bbands.values().iterator().next().get(upperKey) );
			double lower =	Double.parseDouble( bbands.values().iterator().next().get(lowerKey) );
			
			double sbv = ((last - lower) / (upper - lower)) - 0.5;
			System.out.printf("\tOnResponseReceived() %s shifted_b_value of %f\n", symbol, sbv);
			if (sbv <= -0.34) {
				buy.add(Double.toString(sbv) + " " + symbol);	// @note value concatenated to symbol for sorting
			} else if (sbv >= 0.34) {
				sell.add(Double.toString(sbv) + " " + symbol);
			}
        }
    	
    	Collections.sort(buy, Collections.reverseOrder());
    	String[] buyArray = new String[buy.size()];
    	for (int i = 0; i < buyArray.length; ++i) {
    		String uncut = buy.get(i);
    		buyArray[i] = uncut.substring(uncut.indexOf(" "), uncut.length());	// symbol is extracted from string here
    	}
    	
    	Collections.sort(sell, Collections.reverseOrder());
    	String[] sellArray = new String[sell.size()];
    	for (int i = 0; i < sellArray.length; ++i) {
    		String uncut = sell.get(i);
    		sellArray[i] = uncut.substring(uncut.indexOf(" "), uncut.length());
    	}
    	
    	System.out.println("OnAnalyseDone() Unlocking application and displaying results.");

        listaCompra.setModel( new javax.swing.DefaultComboBoxModel<String>(buyArray) );
        listaVenda.setModel( new javax.swing.DefaultComboBoxModel<String>(sellArray) );
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel compra;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaCompra;
    private javax.swing.JList<String> listaVenda;
    private javax.swing.JLabel venda;
    // End of variables declaration//GEN-END:variables
    private AlphaVantageAPI api;
    
}
