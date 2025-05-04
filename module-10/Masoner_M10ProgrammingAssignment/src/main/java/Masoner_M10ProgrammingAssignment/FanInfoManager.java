package Masoner_M10ProgrammingAssignment;
//Ean Masoner Module 10 Programming Assignment CSD-420
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FanInfoManager {
    private static final String DB_URL = "jdbc:mysql://localhost/databasedb";
    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    private JFrame frame;
    private JTextField idField, firstNameField, lastNameField, favoriteTeamField;
    private JButton displayButton, updateButton;

    public FanInfoManager() {
        frame = new JFrame("Fan Information Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridLayout(5, 2));

        frame.add(new JLabel("Fan ID:"));
        idField = new JTextField();
        frame.add(idField);

        displayButton = new JButton("Display");
        frame.add(displayButton);

        frame.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        frame.add(firstNameField);

        frame.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        frame.add(lastNameField);

        frame.add(new JLabel("Favorite Team:"));
        favoriteTeamField = new JTextField();
        frame.add(favoriteTeamField);

        updateButton = new JButton("Update");
        frame.add(updateButton);

        displayButton.addActionListener(new DisplayHandler());
        updateButton.addActionListener(new UpdateHandler());

        frame.setVisible(true);
    }

    private Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    class DisplayHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fanId = idField.getText();
            if (!fanId.matches("\\d+")) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection conn = connectToDatabase();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM fans WHERE ID = ?")) {

                stmt.setInt(1, Integer.parseInt(fanId));
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    firstNameField.setText(rs.getString("firstname"));
                    lastNameField.setText(rs.getString("lastname"));
                    favoriteTeamField.setText(rs.getString("favoriteteam"));
                } else {
                    JOptionPane.showMessageDialog(frame, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class UpdateHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fanId = idField.getText();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String favoriteTeam = favoriteTeamField.getText();

            if (!fanId.matches("\\d+")) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection conn = connectToDatabase();
                 PreparedStatement stmt = conn.prepareStatement("UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?")) {

                stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, favoriteTeam);
                stmt.setInt(4, Integer.parseInt(fanId));

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(frame, "Record updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Record not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new FanInfoManager();
    }
}
