import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Main extends JFrame {
    JButton[][] A = new JButton[4][5];

    public static void main(String[] args) {
        Main objM = new Main();
    }
    Main() {
        Buttons();
        Labels();
    }

    private void Buttons() {
        this.setLayout(null);
        this.setBounds(555, 200, 500, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("New window.");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                A[i][j] = new JButton();
                this.add(A[i][j]);
                A[i][j].setBounds(50 + i * 100, 150 + j * 100, 70, 70);
            }

        }
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 4; j++) {
                A[i][j].setText(String.valueOf((i + 7) - ((j - 1) * (j + 1)) - ((j - 1) * (j - 2) * (j - 4))));
            }
        }
        A[0][4].setText("+\\-");
        A[1][4].setText("0");
        A[2][4].setText(",");
        A[3][4].setText("=");
        A[3][3].setText("+");
        A[3][2].setText("-");
        A[3][1].setText("*");
        A[3][0].setText("/");
        A[2][0].setText("⌫");
        A[1][0].setText("CE");
        A[0][0].setText("%");
    }

    private void Labels() {
        JLabel jlRes;
        jlRes = new JLabel();
        jlRes.setBackground(Color.blue);
        this.add(jlRes);
        jlRes.setBounds(30, 30, 300, 35);

        System.out.println(jlRes.getText());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int finalI = i;
                int finalJ = j;
                A[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if ((finalI != 1 || finalJ != 0)&&(finalI != 2 || finalJ != 0)&& (finalI != 1 || finalJ != 4)) {
                            jlRes.setText(sDigitOutPut(jlRes.getText()) + A[finalI][finalJ].getText());
                        }
                    }
                });
            }
        }
        A[1][0].addActionListener(new ActionListener() /* CE */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlRes.setText("");
            }
        });

        A[3][0].addActionListener(new ActionListener() /* / */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Integer.parseInt(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.DIV;
            }
        });

        A[3][1].addActionListener(new ActionListener() /* * */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Integer.parseInt(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.MUL;
            }
        });

        A[3][2].addActionListener(new ActionListener() /* - */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Integer.parseInt(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.SUB;
            }
        });
        A[3][3].addActionListener(new ActionListener() /* + */ {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand1 = Integer.parseInt(jlRes.getText());
                jlRes.setText("");
                operacia = Oper.SUM;
            }
        });

        A[3][4].addActionListener(new ActionListener() /* = */ {
                @Override
                public void actionPerformed (ActionEvent e){
                    jlRes.setText(String.valueOf(operacia.operMeth(operand1, Integer.parseInt(jlRes.getText()))));
                }
            });
}
        private String sDigitOutPut(String arg1){
            return  arg1;
        }
        JLabel jlRes;
        private int operand1;
        private Oper operacia = Oper.NONE;

        }