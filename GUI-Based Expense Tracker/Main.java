import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ExpenseTracker {

    private JFrame frame;
    private JTextField descriptionField, amountField;
    private JTable table;
    private DefaultTableModel model;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ExpenseTracker window = new ExpenseTracker();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ExpenseTracker() {
        frame = new JFrame("Expense Tracker");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(30, 30, 80, 20);
        frame.getContentPane().add(descriptionLabel);

        descriptionField = new JTextField();
        descriptionField.setBounds(120, 30, 150, 20);
        frame.getContentPane().add(descriptionField);
        descriptionField.setColumns(10);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 70, 80, 20);
        frame.getContentPane().add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(120, 70, 150, 20);
        frame.getContentPane().add(amountField);
        amountField.setColumns(10);

        JButton addButton = new JButton("Add Expense");
        addButton.setBounds(120, 110, 150, 30);
        frame.getContentPane().add(addButton);

        String[] columnNames = {"Description", "Amount"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 150, 500, 150);
        frame.getContentPane().add(scrollPane);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                String amount = amountField.getText();

                if (!description.isEmpty() && !amount.isEmpty()) {
                    model.addRow(new Object[]{description, amount});
                    descriptionField.setText("");
                    amountField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill in both fields.");
                }
            }
        });
    }
}
