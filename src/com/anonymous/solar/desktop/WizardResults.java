/*
 *
 */
package com.anonymous.solar.desktop;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.anonymous.solar.client.SolarCalculator;
import com.anonymous.solar.client.SolarCalculatorService;
import com.anonymous.solar.shared.Direction;
import com.anonymous.solar.shared.SolarPanels;
import com.anonymous.solar.shared.SolarResult;
import com.anonymous.solar.shared.SolarSetup;

/**
 * Wizard Panel to display the results that come back from the server.
 * 
 * @author 07627505 Darran Kartaschew
 * @version 1.0
 */
public class WizardResults extends javax.swing.JPanel implements WizardPanel {

	private static final long serialVersionUID = 1185924630290486108L;

	private final String title = "Results";

	private Wizard parent = null;

	/**
	 * Creates new form WizardFinish, with reference to parent
	 */
	public WizardResults(Wizard parent) {
		initComponents();
		this.parent = parent;
	}

	/**
	 * Creates new form WizardResults
	 */
	public WizardResults() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jTabbedPaneResults = new javax.swing.JTabbedPane();
		jPanelSummaryResults = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextAreaConfirmationDetails = new javax.swing.JEditorPane("text/html", "");
		jPanelGraphResults = new javax.swing.JPanel();
		jPanelGraph = new javax.swing.JPanel();
		jPanelTableresults = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		jTabbedPaneResults.setName("TabResults"); // NOI18N

		jPanelSummaryResults.setName("TabSummary"); // NOI18N

		jTextAreaConfirmationDetails.setEditable(false);
		jTextAreaConfirmationDetails.setName("txtAreaResults"); // NOI18N
		jScrollPane1.setViewportView(jTextAreaConfirmationDetails);

		javax.swing.GroupLayout jPanelSummaryResultsLayout = new javax.swing.GroupLayout(jPanelSummaryResults);
		jPanelSummaryResults.setLayout(jPanelSummaryResultsLayout);
		jPanelSummaryResultsLayout.setHorizontalGroup(jPanelSummaryResultsLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelSummaryResultsLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
						.addContainerGap()));
		jPanelSummaryResultsLayout.setVerticalGroup(jPanelSummaryResultsLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelSummaryResultsLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
						.addContainerGap()));

		jTabbedPaneResults.addTab("Summary", jPanelSummaryResults);

		jPanelGraphResults.setName("TabGraph"); // NOI18N

		jPanelGraph.setName("pnlGraph"); // NOI18N

		javax.swing.GroupLayout jPanelGraphLayout = new javax.swing.GroupLayout(jPanelGraph);
		jPanelGraph.setLayout(jPanelGraphLayout);
		jPanelGraphLayout.setHorizontalGroup(jPanelGraphLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 583, Short.MAX_VALUE));
		jPanelGraphLayout.setVerticalGroup(jPanelGraphLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 347, Short.MAX_VALUE));

		javax.swing.GroupLayout jPanelGraphResultsLayout = new javax.swing.GroupLayout(jPanelGraphResults);
		jPanelGraphResults.setLayout(jPanelGraphResultsLayout);
		jPanelGraphResultsLayout.setHorizontalGroup(jPanelGraphResultsLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelGraphResultsLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanelGraph, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));
		jPanelGraphResultsLayout.setVerticalGroup(jPanelGraphResultsLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelGraphResultsLayout
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanelGraph, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addContainerGap()));

		jTabbedPaneResults.addTab("Graphical Results", jPanelGraphResults);

		jPanelTableresults.setName("TabTableResults"); // NOI18N

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }) {
			Class[] types = new Class[] { java.lang.Double.class, java.lang.Double.class, java.lang.Double.class,
					java.lang.Double.class };
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTable1.setName("tblResults"); // NOI18N
		jScrollPane2.setViewportView(jTable1);

		javax.swing.GroupLayout jPanelTableresultsLayout = new javax.swing.GroupLayout(jPanelTableresults);
		jPanelTableresults.setLayout(jPanelTableresultsLayout);
		jPanelTableresultsLayout.setHorizontalGroup(jPanelTableresultsLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelTableresultsLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
						.addContainerGap()));
		jPanelTableresultsLayout.setVerticalGroup(jPanelTableresultsLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelTableresultsLayout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
						.addContainerGap()));

		jTabbedPaneResults.addTab("Tabulated Results", jPanelTableresults);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(jTabbedPaneResults).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap().addComponent(jTabbedPaneResults).addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents
		// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JPanel jPanelGraph;
	private javax.swing.JPanel jPanelGraphResults;
	private javax.swing.JPanel jPanelSummaryResults;
	private javax.swing.JPanel jPanelTableresults;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane jTabbedPaneResults;
	private javax.swing.JTable jTable1;
	private javax.swing.JEditorPane jTextAreaConfirmationDetails;

	// End of variables declaration//GEN-END:variables

	/**
	 * Callback method used by the parent panel to notify this panel that we
	 * have been given context to the user.
	 * 
	 * @return true is ok to move.
	 */
	@Override
	public boolean callbackStart() {
		SolarSetup global = parent.getSetup();
		SolarResult results = null;
		String output = "";
		String output2 = "";
		if (global != null) {

			SolarCalculator calculatorSOAP = new SolarCalculatorService().getSolarCalculatorPort();
			results = calculatorSOAP.calculateAllResults(global, 10);

			output2 += "<br /> Daily Savings: " + String.format("$%,.2f", results.getDailySavings()) + "<br />";
			output2 += "<br /> Monthly Savings: " + String.format("$%,.2f", results.getMonthlySavings()) + "<br />";
			output2 += "<br /> Yearly Savings: " + String.format("$%,.2f", results.getYearlySavings()) + "<br />";

			jPanelGraph.setLayout(new BorderLayout());
			jPanelGraph.add(new org.jfree.chart.ChartPanel(new ResultChart(results).getChartPanel()),
					BorderLayout.CENTER);

			setResultsTable(results);

			// results = calculator.calculateDailySavings(results, 1);
			// results = calculator.calculateYearlySavings(results, 1);
			// results = calculator.calculateYearlySavingsOverTime(results, 10);

			try {
				output += "<br />Your inverter will be at  50% efficiency in " + global.LengthUntilInverter(50)
						+ " years <br />";
				output += "<br />In 20 years time your inverter will be at " + global.DetermineInverterLoss(20)
						+ "% efficiency";
				output += "<br /><br />In 20 years time your panels will be at:";
				for (SolarPanels panls : global.GetDirectionalPanels(Direction.NORTH)) {
					output += "<br />" + panls.getPanelType().getPanelName() + " will go from 100% to "
							+ Math.floor(panls.getPanelType().DetermineLoss(20.0)) + "% efficient";
					output += "<br />This panel will reach 50% efficiency in "
							+ Math.floor(panls.getPanelType().LengthUntilPanel(50.0)) + " years<br />";

				}
				for (SolarPanels panls : global.GetDirectionalPanels(Direction.EAST)) {
					output += "<br />" + panls.getPanelType().getPanelName() + " will go from 100% to "
							+ Math.floor(panls.getPanelType().DetermineLoss(20.0)) + "% efficient";
					output += "<br />This panel will reach 50% efficiency in "
							+ Math.floor(panls.getPanelType().LengthUntilPanel(50.0)) + " years<br />";

				}
				for (SolarPanels panls : global.GetDirectionalPanels(Direction.SOUTH)) {
					output += "<br />" + panls.getPanelType().getPanelName() + " will go from 100% to "
							+ Math.floor(panls.getPanelType().DetermineLoss(20.0)) + "% efficient";
					output += "<br />This panel will reach 50% efficiency in "
							+ Math.floor(panls.getPanelType().LengthUntilPanel(50.0)) + " years<br />";

				}
				for (SolarPanels panls : global.GetDirectionalPanels(Direction.WEST)) {
					output += "<br />" + panls.getPanelType().getPanelName() + " will go from 100% to "
							+ Math.floor(panls.getPanelType().DetermineLoss(20.0)) + "% efficient<br />";
					output += "<br />This panel will reach 50% efficiency in "
							+ Math.floor(panls.getPanelType().LengthUntilPanel(50.0)) + " years";

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			jTextAreaConfirmationDetails.setText(output2);

		}
		return true;
	}

	/**
	 * Populate the results table.
	 * 
	 * @param results
	 */
	@SuppressWarnings("serial")
	private void setResultsTable(SolarResult results) {
		// Update table model
		ArrayList<Double> resultTable = results.getSavingsOverYears();

		int numResultColumns = resultTable.size();

		String[] columnTitles = new String[numResultColumns];
		for (int i = 0; i < numResultColumns; i++) {
			columnTitles[i] = new String(String.format("Year %d", i + 1));
		}

		@SuppressWarnings("rawtypes")
		final Class[] types = new Class[numResultColumns];
		for (int i = 0; i < numResultColumns; i++) {
			types[i] = java.lang.Double.class;
		}

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { resultTable.toArray() }, columnTitles) {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		});
		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable1.setSize(5000, jScrollPane2.getHeight());
		for (int i = 0; i < numResultColumns; i++) {
			jTable1.getColumnModel().getColumn(i).setResizable(true);
			jTable1.getColumnModel().getColumn(i).setMinWidth(120);
			jTable1.getColumnModel().getColumn(i).setCellRenderer((TableCellRenderer) new MyTableCellRenderer());
		}
		jScrollPane2.setEnabled(true);
		jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}

	/**
	 * Result Table Cell renderer to ensure all numbers are displayed in $
	 * format.
	 */
	@SuppressWarnings("serial")
	public class MyTableCellRenderer extends JLabel implements TableCellRenderer {
		// This method is called each time a cell in a column
		// using this renderer needs to be rendered.
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				boolean hasFocus, int rowIndex, int vColIndex) {
			// 'value' is value contained in the cell located at
			// (rowIndex, vColIndex)

			if (isSelected) {
				// cell (and perhaps other cells) are selected
			}

			if (hasFocus) {
				// this cell is the anchor and the table has the focus
			}

			// Configure the component with the specified value
			String valueStr = String.format("$%,.2f", value);
			setText(valueStr);

			// Set tool tip if desired
			setToolTipText(valueStr);

			// Since the renderer is a component, return itself
			return this;
		}

		// The following methods override the defaults for performance reasons
		public void validate() {
		}

		public void revalidate() {
		}

		protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		}

		public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
		}
	}

	/**
	 * Callback method used by the parent panel to notify this panel that we
	 * have requested a move away from this panel.
	 * 
	 * @return true is ok to move.
	 */
	@Override
	public boolean callbackDispose(boolean validateInput) {

		return true;
	}

	/**
	 * Return the title to be used for this wizard panel;
	 * 
	 * @return
	 */
	@Override
	public String getTitle() {
		return title;
	}
}
