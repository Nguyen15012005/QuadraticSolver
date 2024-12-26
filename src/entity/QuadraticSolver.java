package entity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class QuadraticSolver extends JFrame {
    private JTextField txtA, txtB, txtC, txtResult;
    private JButton btnSolve, btnClear, btnExit;
    
    public QuadraticSolver() {
        // Đặt tên cho ứng dụng
        setTitle("^-^");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        
        JPanel pnTop = new JPanel();
        JLabel lbltitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
        Font ft = new Font("Arial", Font.BOLD, 25);
        lbltitle.setFont(ft);
        lbltitle.setForeground(Color.black);
        pnTop.setBackground(Color.CYAN);
        pnTop.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnTop.add(lbltitle);
        container.add(pnTop, BorderLayout.NORTH);
        
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        container.add(pnCenter, BorderLayout.CENTER);
        
        // Labels and TextFields định dạng cho từng fields
        JPanel pnA = new JPanel();
        pnA.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblA = new JLabel("Nhập a: ");
        lblA.setFont(new Font("Arial", Font.BOLD, 14));
        txtA = new JTextField(20);
        pnA.add(lblA);
        pnA.add(txtA);
        pnCenter.add(pnA);
        
        JPanel pnB = new JPanel();
        pnB.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblB = new JLabel("Nhập b: ");
        lblB.setFont(new Font("Arial", Font.BOLD, 14));
        txtB = new JTextField(20);
        pnB.add(lblB);
        pnB.add(txtB);
        pnCenter.add(pnB);
        
        JPanel pnC = new JPanel();
        pnC.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblC = new JLabel("Nhập c: ");
        lblC.setFont(new Font("Arial", Font.BOLD, 14));
        txtC = new JTextField(20);
        pnC.add(lblC);
        pnC.add(txtC);
        pnCenter.add(pnC);
        
        JPanel pnResult = new JPanel();
        pnResult.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblResult = new JLabel("Kết quả: ");
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        txtResult = new JTextField(20);
        txtResult.setEnabled(false);
        pnResult.add(lblResult);
        pnResult.add(txtResult);
        pnCenter.add(pnResult);
        
//        JPanel pnOutput = new JPanel();
        
//        txtResult.setHorizontalAlignment(SwingConstants.CENTER);
//        pnOutput.setLayout(new FlowLayout(FlowLayout.CENTER));
//        pnOutput.add(txtResult);
//        pnCenter.add(pnOutput);
        
        // Buttons
        btnSolve = new JButton("Giải");
        btnSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                solveEquation();
            }
        });
        
        btnClear = new JButton("Xóa rỗng");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        
        btnExit = new JButton("Thoát");
        btnExit.addActionListener(e -> System.exit(0));
        
        JPanel pnBot = new JPanel();
        TitledBorder borderBot = new TitledBorder(BorderFactory.createLineBorder(Color.blue), "Chọn tác vụ");
        pnBot.setBorder(borderBot);
        pnBot.setLayout(new FlowLayout(FlowLayout.CENTER));
        pnBot.add(btnSolve);
        pnBot.add(btnClear);
        pnBot.add(btnExit);
        container.add(pnBot, BorderLayout.SOUTH);
    }
    
    private void solveEquation() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());
            String result;
            
            if (a == 0) {
                result = "Không phải phương trình bật hai!";
            } else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    result = "Phương trình vô nghiệm";
                } else if (delta == 0) {
                    result = "Nghiệm kép: x = " + (-b / (2 * a));
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);                    
                    result = "x1 = " + x1 + ", x2 = " + x2;
                }
            }
            
            txtResult.setText(result);
        } catch (NumberFormatException ex) {
            txtResult.setText("Lỗi! Vui lòng nhập số hợp lệ!");
        }
    }
    
    private void clearFields() {
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtResult.setText("");
    }
}
