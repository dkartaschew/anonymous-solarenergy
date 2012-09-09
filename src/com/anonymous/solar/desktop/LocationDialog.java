/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anonymous.solar.desktop;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;
import org.openstreetmap.gui.jmapviewer.tilesources.OsmTileSource;

import com.anonymous.solar.shared.DoubleArray;
import com.anonymous.solar.shared.LocationData;
import com.anonymous.solar.client.LocationInformation;
import com.anonymous.solar.client.LocationInformationService;

/**
 * 
 * @author darran
 */
public class LocationDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6271655096624960857L;

	MapMarker currentLocation = null;

	Wizard parent = null;

	LocationData locationData = new LocationData();

	/**
	 * Creates new form LocationDialog
	 */
	public LocationDialog(Wizard parent, boolean modal) {
		// super((java.awt.Frame)parent, modal);
		setModal(modal);
		this.parent = parent;
		initComponents();
		SetupMapSelectionComboBox();
		SetupMapMouseHandlers();
		SetupTable();
		SetupLoadLocations();
		if (parent.getSetup().getLocation() == null) {
			jComboBoxLocationName.setSelectedIndex(0);
		} else {
			locationData = parent.getSetup().getLocation();
			jTextFieldLocationName.setText(locationData.getLocationName());
			jTextFieldLatitude.setText(locationData.getLatitude().toString());
			jTextFieldLongitude.setText(locationData.getLongitude().toString());
			Double[][] locWData = locationData.getLocationWeatherData();
			// Set the table!
			for (int row = 0; row < 12; row++) {
				jTableWeatherDetails.getModel().setValueAt(locWData[row][0], row, 1);
				jTableWeatherDetails.getModel().setValueAt(locWData[row][1], row, 2);
			}
			jMapViewer1.setDisplayPositionByLatLon(locationData.getLatitude(), locationData.getLongitude(),
					jMapViewer1.getZoom());
			AddMarker(new Coordinate(locationData.getLatitude(), locationData.getLongitude()));
		}

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

		jMapViewer1 = new org.openstreetmap.gui.jmapviewer.JMapViewer();
		jSeparator1 = new javax.swing.JSeparator();
		jButtonClose = new javax.swing.JButton();
		jButtonOK = new javax.swing.JButton();
		jPanelDefinedLocation = new javax.swing.JPanel();
		jComboBoxLocationName = new javax.swing.JComboBox();
		jLabelLocationName = new javax.swing.JLabel();
		jPanelLocationDetails = new javax.swing.JPanel();
		jTextFieldLocationName = new javax.swing.JTextField();
		jLabelLocationNameR = new javax.swing.JLabel();
		jTextFieldLatitude = new javax.swing.JTextField();
		jTextFieldLongitude = new javax.swing.JTextField();
		jLabelLat = new javax.swing.JLabel();
		jLabelLong = new javax.swing.JLabel();
		jLabelWeather = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTableWeatherDetails = new javax.swing.JTable();
		jButtonSave = new javax.swing.JButton();
		jComboBoxTileLoadSelector = new javax.swing.JComboBox();
		jLabelViewMode = new javax.swing.JLabel();
		jLabelMapInstructions = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Select Location");
		setModal(true);
		setName("dialogLocation"); // NOI18N
		setResizable(false);

		jMapViewer1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		jMapViewer1.setMapMarkerVisible(false);
		jMapViewer1.setZoom(7);

		jButtonClose.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/anonymous/solar/desktop/images/window-close.png"))); // NOI18N
		jButtonClose.setText("Close");
		jButtonClose.setPreferredSize(new java.awt.Dimension(100, 26));
		jButtonClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonCloseActionPerformed(evt);
			}
		});

		jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/anonymous/solar/desktop/images/dialog-ok.png"))); // NOI18N
		jButtonOK.setText("OK");
		jButtonOK.setPreferredSize(new java.awt.Dimension(100, 26));
		jButtonOK.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonOKActionPerformed(evt);
			}
		});

		jPanelDefinedLocation.setBorder(javax.swing.BorderFactory.createTitledBorder("Pre-defined Locations"));

		jComboBoxLocationName.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				LocationItemStateChange(evt);
			}
		});

		jLabelLocationName.setText("Location:");

		javax.swing.GroupLayout jPanelDefinedLocationLayout = new javax.swing.GroupLayout(jPanelDefinedLocation);
		jPanelDefinedLocation.setLayout(jPanelDefinedLocationLayout);
		jPanelDefinedLocationLayout.setHorizontalGroup(jPanelDefinedLocationLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanelDefinedLocationLayout.createSequentialGroup().addContainerGap().addComponent(jLabelLocationName)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jComboBoxLocationName, 0, 183, Short.MAX_VALUE).addContainerGap()));
		jPanelDefinedLocationLayout.setVerticalGroup(jPanelDefinedLocationLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelDefinedLocationLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanelDefinedLocationLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jComboBoxLocationName, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabelLocationName)).addContainerGap(13, Short.MAX_VALUE)));

		jPanelLocationDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Location Details"));

		jLabelLocationNameR.setText("Location:");

		jTextFieldLatitude.setEditable(false);
		jTextFieldLatitude.setFocusable(false);

		jTextFieldLongitude.setEditable(false);
		jTextFieldLongitude.setFocusable(false);

		jLabelLat.setText("Latitude:");

		jLabelLong.setText("Longitude:");

		jLabelWeather.setText("Weather Details:");

		jTableWeatherDetails.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { "Jan", null, null },
				{ "Feb", null, null }, { "Mar", null, null }, { "Apr", null, null }, { "May", null, null },
				{ "Jun", null, null }, { "Jul", null, null }, { "Aug", null, null }, { "Sep", null, null },
				{ "Oct", null, null }, { "Nov", null, null }, { "Dec", null, null } }, new String[] { "Month",
				"Cloudy Days", "Efficiency Loss" }) {
			Class[] types = new Class[] { java.lang.String.class, java.lang.Double.class, java.lang.Double.class };
			boolean[] canEdit = new boolean[] { false, true, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTableWeatherDetails.getTableHeader().setResizingAllowed(false);
		jTableWeatherDetails.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(jTableWeatherDetails);

		jButtonSave.setText("Save Details");
		jButtonSave.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSaveActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanelLocationDetailsLayout = new javax.swing.GroupLayout(jPanelLocationDetails);
		jPanelLocationDetails.setLayout(jPanelLocationDetailsLayout);
		jPanelLocationDetailsLayout
				.setHorizontalGroup(jPanelLocationDetailsLayout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelLocationDetailsLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelLocationDetailsLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanelLocationDetailsLayout
																		.createSequentialGroup()
																		.addGroup(
																				jPanelLocationDetailsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabelLocationNameR)
																						.addComponent(jLabelLat)
																						.addComponent(jLabelLong))
																		.addGap(18, 18, 18)
																		.addGroup(
																				jPanelLocationDetailsLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jTextFieldLatitude)
																						.addComponent(
																								jTextFieldLocationName)
																						.addComponent(
																								jTextFieldLongitude)))
														.addGroup(
																jPanelLocationDetailsLayout.createSequentialGroup()
																		.addComponent(jLabelWeather)
																		.addGap(0, 0, Short.MAX_VALUE))
														.addComponent(jScrollPane1,
																javax.swing.GroupLayout.PREFERRED_SIZE, 0,
																Short.MAX_VALUE)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanelLocationDetailsLayout.createSequentialGroup()
																		.addGap(0, 0, Short.MAX_VALUE)
																		.addComponent(jButtonSave))).addContainerGap()));
		jPanelLocationDetailsLayout.setVerticalGroup(jPanelLocationDetailsLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanelLocationDetailsLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								jPanelLocationDetailsLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldLocationName, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabelLocationNameR))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								jPanelLocationDetailsLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldLatitude, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabelLat))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								jPanelLocationDetailsLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextFieldLongitude, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabelLong))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabelWeather)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addGap(11, 11, 11).addComponent(jButtonSave).addContainerGap()));

		jLabelViewMode.setText("View Mode:");

		jLabelMapInstructions.setFont(jLabelMapInstructions.getFont().deriveFont(
				jLabelMapInstructions.getFont().getSize() - 2f));
		jLabelMapInstructions.setText("Left Click to select location, Right click to move. ");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(0, 0, Short.MAX_VALUE)
																.addComponent(jButtonOK,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jButtonClose,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jPanelLocationDetails,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jPanelDefinedLocation,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jMapViewer1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						481,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabelMapInstructions)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE)
																								.addComponent(
																										jLabelViewMode)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																								.addComponent(
																										jComboBoxTileLoadSelector,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												layout.createSequentialGroup()
														.addComponent(jPanelDefinedLocation,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jPanelLocationDetails,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(
												layout.createSequentialGroup()
														.addComponent(jMapViewer1,
																javax.swing.GroupLayout.DEFAULT_SIZE, 448,
																Short.MAX_VALUE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(
																layout.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(jComboBoxTileLoadSelector,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(jLabelViewMode)
																		.addComponent(jLabelMapInstructions))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCloseActionPerformed
		this.setVisible(false);
		locationData = null;
	}// GEN-LAST:event_jButtonCloseActionPerformed

	private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonOKActionPerformed
		boolean success = false;
		try {
			success = submitLocationData();
		} catch (Exception e) {
		}
		// Setup error conditions.
		javax.swing.border.LineBorder borderError = new javax.swing.border.LineBorder(Color.red, 1);
		javax.swing.border.LineBorder clear = new javax.swing.border.LineBorder(Color.white, 0);
		jTextFieldLocationName.setBorder(clear);
		jTextFieldLatitude.setBorder(clear);
		jTextFieldLongitude.setBorder(clear);
		// If we suceeded, then dispose;
		if (success) {
			parent.getSetup().setLocation(locationData);
			this.setVisible(false);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "alert", "Information not valid or present",
					JOptionPane.WARNING_MESSAGE);
			if (jTextFieldLocationName.getText().isEmpty()) {
				jTextFieldLocationName.setBorder(borderError);
			}
			if (jTextFieldLatitude.getText().isEmpty()) {
				jTextFieldLatitude.setBorder(borderError);
			}
			if (jTextFieldLongitude.getText().isEmpty()) {
				jTextFieldLongitude.setBorder(borderError);
			}
		}
	}// GEN-LAST:event_jButtonOKActionPerformed

	private void LocationItemStateChange(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_LocationItemStateChange
		// Update the location panel.
		LocationData locData = (LocationData) jComboBoxLocationName.getSelectedItem();
		jTextFieldLocationName.setText(locData.getLocationName());
		jTextFieldLatitude.setText(locData.getLatitude().toString());
		jTextFieldLongitude.setText(locData.getLongitude().toString());
//		Double[][] locWData = locData.getLocationWeatherData();
//		// Set the table!
//		for (int row = 0; row < 12; row++) {
//			jTableWeatherDetails.getModel().setValueAt(locWData[row][0], row, 1);
//			jTableWeatherDetails.getModel().setValueAt(locWData[row][1], row, 2);
//		}
		for(int row =0; row < 12; row++){
			jTableWeatherDetails.getModel().setValueAt(locData.getLocationWeatherData().get(row).getItem().get(0) , row, 1);
			jTableWeatherDetails.getModel().setValueAt(locData.getLocationWeatherData().get(row).getItem().get(1) , row, 2);
		}
		jMapViewer1.setDisplayPositionByLatLon(locData.getLatitude(), locData.getLongitude(), jMapViewer1.getZoom());
		AddMarker(new Coordinate(locData.getLatitude(), locData.getLongitude()));
	}// GEN-LAST:event_LocationItemStateChange

	private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {
		LocationData locData = new LocationData();
		try {
			locData.setLatitude(Double.valueOf(jTextFieldLatitude.getText()));
			locData.setLongitude(Double.valueOf(jTextFieldLongitude.getText()));
			locData.setLocationName(jTextFieldLocationName.getText());
			for (int row = 0; row < 12; row++) {
				DoubleArray dbl = new DoubleArray();
				dbl.getItem().add((Double) jTableWeatherDetails.getValueAt(row, 1));
				dbl.getItem().add((Double) jTableWeatherDetails.getValueAt(row, 2));
				locData.getLocationWeatherData().add(dbl);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		loadLocationComboBox(locData);
		jComboBoxLocationName.setSelectedIndex(jComboBoxLocationName.getComponentCount());
		// Save location information to GAE.
		try {
			LocationInformation locationSOAP = new LocationInformationService().getLocationInformationPort();
			com.anonymous.solar.shared.LocationData soapData = new com.anonymous.solar.shared.LocationData();
			Long result = locationSOAP.storeLocationInformation(soapData);
			System.out.printf("Location Item stored: key = %d \n", result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JButton jButtonClose;
	private javax.swing.JButton jButtonOK;
	private javax.swing.JButton jButtonSave;
	private javax.swing.JComboBox jComboBoxLocationName;
	private javax.swing.JComboBox jComboBoxTileLoadSelector;
	private javax.swing.JLabel jLabelLat;
	private javax.swing.JLabel jLabelLocationName;
	private javax.swing.JLabel jLabelLocationNameR;
	private javax.swing.JLabel jLabelLong;
	private javax.swing.JLabel jLabelMapInstructions;
	private javax.swing.JLabel jLabelViewMode;
	private javax.swing.JLabel jLabelWeather;
	private org.openstreetmap.gui.jmapviewer.JMapViewer jMapViewer1;
	private javax.swing.JPanel jPanelDefinedLocation;
	private javax.swing.JPanel jPanelLocationDetails;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTable jTableWeatherDetails;
	private javax.swing.JTextField jTextFieldLatitude;
	private javax.swing.JTextField jTextFieldLocationName;
	private javax.swing.JTextField jTextFieldLongitude;

	// End of variables declaration//GEN-END:variables

	/**
	 * Setup the map mode selection combo box, will all available map modes.
	 */
	private void SetupMapSelectionComboBox() {
		// Setup the mapping components
		jComboBoxTileLoadSelector.addItem((TileSource) new OsmTileSource.Mapnik());
		// Disbaled as has no maps for Australia.
		// jComboBoxTileLoadSelector.addItem((TileSource) new
		// OsmTileSource.TilesAtHome());
		jComboBoxTileLoadSelector.addItem((TileSource) new OsmTileSource.CycleMap());
		jComboBoxTileLoadSelector.addItem((TileSource) new BingAerialTileSource());

		jComboBoxTileLoadSelector.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e != null) {
					if (e.getItem() != null) {
						try {
							jMapViewer1.setTileSource((TileSource) e.getItem());
						} catch (Exception ex) {
						}
					}
				}
			}
		});
	}

	/**
	 * Setup the weather conditions table
	 */
	private void SetupTable() {
		jTableWeatherDetails.setFont(jTableWeatherDetails.getFont().deriveFont(
				jTableWeatherDetails.getFont().getStyle(), jTableWeatherDetails.getFont().getSize() - 1));
		jTableWeatherDetails.getTableHeader().setFont(
				jTableWeatherDetails.getFont().deriveFont(jTableWeatherDetails.getFont().getStyle(),
						jTableWeatherDetails.getFont().getSize() - 1));
		jTableWeatherDetails.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumn col = jTableWeatherDetails.getColumnModel().getColumn(0);
		col.setPreferredWidth(50);
	}

	/**
	 * Setup all the mapping left click handlers.
	 */
	private void SetupMapMouseHandlers() {
		jMapViewer1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMarker(jMapViewer1.getPosition(e.getPoint()));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// throw new
				// UnsupportedOperationException("Not supported yet.");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// throw new
				// UnsupportedOperationException("Not supported yet.");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// throw new
				// UnsupportedOperationException("Not supported yet.");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// throw new
				// UnsupportedOperationException("Not supported yet.");
			}
		});
	}

	/**
	 * Adds a marker to the map, as well, update the applicable text fields.
	 * 
	 * @param location
	 */
	private void AddMarker(Coordinate location) {
		Double longitude = location.getLon();
		Double latitude = location.getLat();
		jTextFieldLatitude.setText(latitude.toString());
		jTextFieldLongitude.setText(longitude.toString());
		if (currentLocation != null) {
			jMapViewer1.removeMapMarker(currentLocation);
		}
		currentLocation = new MapMarkerDot(latitude, longitude);
		jMapViewer1.addMapMarker(currentLocation);
		jMapViewer1.setDisplayPositionByLatLon(latitude, longitude, jMapViewer1.getZoom());
		jMapViewer1.setMapMarkerVisible(true);
	}

	private void SetupLoadLocations() {
		LocationData defaultLocation = new LocationData();
		try {
			defaultLocation.setLocationName("Brisbane (QUT)");
			defaultLocation.setLongitude(153.0259519815445);
			defaultLocation.setLatitude(-27.47330928257259);
			loadLocationComboBox(defaultLocation);
			defaultLocation = new LocationData();
			defaultLocation.setLocationName("Melbourne (RMIT)");
			defaultLocation.setLongitude(144.96462106704712);
			defaultLocation.setLatitude(-37.80804628684809);
			loadLocationComboBox(defaultLocation);
			// Add additional locations from GAE.
			try {
				LocationInformation locationSOAP = new LocationInformationService().getLocationInformationPort();
				ArrayList<LocationData> locData = (ArrayList<LocationData>) locationSOAP.storeLocationGetAll();
				for (LocationData loc : locData) {
					loadLocationComboBox(loc);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		} catch (Exception e) {
		}
	}

	private boolean submitLocationData() {
		try {
			locationData.setLatitude(Double.valueOf(jTextFieldLatitude.getText()));
			locationData.setLongitude(Double.valueOf(jTextFieldLongitude.getText()));
			locationData.setLocationName(jTextFieldLocationName.getText());
			locationData.getLocationWeatherData().clear();
			for (int row = 0; row < 12; row++) {
				DoubleArray rowData = new DoubleArray();
				rowData.getItem().add((Double) jTableWeatherDetails.getValueAt(row, 1));
				rowData.getItem().add((Double) jTableWeatherDetails.getValueAt(row, 2));
				locationData.getLocationWeatherData().add(rowData);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void loadLocationComboBox(LocationData defaultLocation) {
		jComboBoxLocationName.addItem(defaultLocation);
		jComboBoxLocationName.validate();
	}
}
