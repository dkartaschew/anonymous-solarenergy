package com.anonymous.solar.desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;


public class AddPanel extends javax.swing.JDialog implements ActionListener {

	private static final long serialVersionUID = 7786544899511067111L;
	
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	public AddPanel(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();


        
    }
	
	private void initComponents() {
	      setSize(WIDTH, HEIGHT);
	      
	      
	      setLayout(new BorderLayout());
	      panelInput = new JPanel();
	      panelInput.setLayout(new GridLayout(1, 3));

	      redPanel = new JPanel();
	      redPanel.setBackground(Color.LIGHT_GRAY);
	      panelInput.add(redPanel);

	      add(panelInput, BorderLayout.CENTER);
	      
	      
	      JPanel buttonPanel = new JPanel();
	      buttonPanel.setBackground(Color.LIGHT_GRAY);
	      buttonPanel.setLayout(new FlowLayout());

	      buttonSubmit = new JButton("Submit");
	      buttonSubmit.setBackground(Color.RED);
	      buttonSubmit.addActionListener(this);
	      buttonPanel.add(buttonSubmit);
	      
	      buttonClose = new JButton("Close");
	      buttonClose.setBackground(Color.RED);
	      buttonClose.addActionListener(this);
	      buttonPanel.add(buttonClose);

	      add(buttonPanel, BorderLayout.SOUTH);
	      

	      
	      
		
	}
	
	public void actionPerformed(ActionEvent e) {
	      String buttonString = e.getActionCommand();

	      if (buttonString.equals("Submit")) {
	         redPanel.setBackground(Color.RED);
	      }
	   }
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton buttonClose;
	private JPanel redPanel;
	private JButton buttonSubmit;
	private JPanel panelInput;


}
