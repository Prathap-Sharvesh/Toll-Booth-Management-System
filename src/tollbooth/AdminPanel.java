package tollbooth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JFrame {
    private admin adminOps = new admin();

    public AdminPanel() {
        setTitle("Admin Control Panel");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 10, 10));

        // Buttons
        JButton addButton = new JButton("Add Vehicle");
        JButton deleteButton = new JButton("Delete Vehicle");
        JButton modifyButton = new JButton("Modify Vehicle");
        JButton viewButton = new JButton("View Vehicles");
        JButton searchButton = new JButton("Search Vehicle");
        JButton exitButton = new JButton("Exit");

        add(addButton);
        add(deleteButton);
        add(modifyButton);
        add(viewButton);
        add(searchButton);
        add(exitButton);

        // Add Vehicle
        addButton.addActionListener(e -> {
            try {
                vehicle v = new vehicle();

                String vNoStr = JOptionPane.showInputDialog(this, "Enter Vehicle Number:");
                v.vehicleNo = Integer.parseInt(vNoStr);

                v.brandName = JOptionPane.showInputDialog(this, "Enter Brand Name:");

                String[] types = { "2 - Two Wheeler", "4 - Four Wheeler", "8 - Eight Wheeler" };
                String typeStr = (String) JOptionPane.showInputDialog(this, "Select Vehicle Type:", "Vehicle Type",
                        JOptionPane.PLAIN_MESSAGE, null, types, types[0]);
                v.vehicleType = Integer.parseInt(typeStr.split(" ")[0]);

                String feeStr = JOptionPane.showInputDialog(this, "Enter Toll Fee:");
                v.fees = Integer.parseInt(feeStr);

                adminOps.addDetails(v);

                JOptionPane.showMessageDialog(this, "Vehicle added successfully!");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Delete Vehicle
        deleteButton.addActionListener(e -> {
            try {
                String noStr = JOptionPane.showInputDialog(this, "Enter Vehicle Number to Delete:");
                int no = Integer.parseInt(noStr);
                adminOps.removeDetails(no);
                JOptionPane.showMessageDialog(this, "Delete operation attempted. Check console for result.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Modify Vehicle
        modifyButton.addActionListener(e -> {
            try {
                String noStr = JOptionPane.showInputDialog(this, "Enter Vehicle Number to Modify:");
                int no = Integer.parseInt(noStr);
                adminOps.modifyDetails(no);
                JOptionPane.showMessageDialog(this, "Modification complete. Check console for result.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // View Vehicles
        viewButton.addActionListener(e -> {
            try {
                adminOps.viewDetails();
                JOptionPane.showMessageDialog(this, "Check console for all vehicle details.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Search Vehicle
        searchButton.addActionListener(e -> {
            try {
                String noStr = JOptionPane.showInputDialog(this, "Enter Vehicle Number to Search:");
                int no = Integer.parseInt(noStr);
                adminOps.searchDetails(no);
                JOptionPane.showMessageDialog(this, "Search complete. Check console for result.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Exit
        exitButton.addActionListener(e -> dispose());
    }

    // Main for standalone testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminPanel().setVisible(true);
        });
    }
}
