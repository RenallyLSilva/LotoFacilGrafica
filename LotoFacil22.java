import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LotoFacil22 extends JFrame {
    private JPanel LotoFacil22;
    private JLabel lbl1;
    private JLabel lbl2;
    private JLabel lbl3;
    private JTextField jtf1;
    private JTextField jtf2;
    private JTextField jtf3;
    private JButton jbApostar1;
    private JButton jbApostar2;
    private JButton jbApostar3;
    private JButton jbSair;

    public LotoFacil22() {
        LotoFacil22 = new JPanel();
        lbl1 = new JLabel("Aposta 0 e 100:");
        lbl2 = new JLabel("Aposta de A a Z:");
        lbl3 = new JLabel("Aposta par ou impar");

        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jtf3 = new JTextField();

        jbApostar1 = new JButton("Apostar");
        jbApostar2 = new JButton("Apostar");
        jbApostar3 = new JButton("Apostar");
        jbSair = new JButton("SAIR");

        jbApostar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroStr = jtf1.getText();

                try {
                    int aposta1 = Integer.parseInt(numeroStr);
                    int valor = (int) (Math.random() * 100);

                    if (aposta1 >= 0 && aposta1 <= 100 && aposta1 == valor) {
                        JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
                    } else if (aposta1 < 0 || aposta1 > 100) {
                        JOptionPane.showMessageDialog(null, "O número digitado de estar entre 0 e 100");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena, o numero sorteado foi: " + valor);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                }

                jtf1.setText("");
            }
        });

        jbApostar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aposta2 = jtf2.getText().toUpperCase();
                String valor2 = "G";

                if (aposta2.equals(valor2)) {
                    JOptionPane.showMessageDialog(null, "Você ganhou 1.000,00 reais!");
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + valor2);
                }
                jtf2.setText("");
            }
        });

        jbApostar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int aposta3 = Integer.parseInt(jtf3.getText());

                    if (aposta3 % 2 == 0) {
                        JOptionPane.showMessageDialog(null, "Você ganhou 100,00 reais");
                    } else {
                        JOptionPane.showMessageDialog(null, "Que pena! O número digitado foi ímpar e a premiação foi para números pares");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                }

                jtf3.setText("");
            }
        });

        jbSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
            }
        });

        LotoFacil22.add(lbl1);
        LotoFacil22.add(jtf1);
        LotoFacil22.add(jbApostar1);

        LotoFacil22.add(lbl2);
        LotoFacil22.add(jtf2);
        LotoFacil22.add(jbApostar2);

        LotoFacil22.add(lbl3);
        LotoFacil22.add(jtf3);
        LotoFacil22.add(jbApostar3);

        LotoFacil22.add(jbSair);
        LotoFacil22.setLayout(new GridLayout(4, 3));

        this.setContentPane(LotoFacil22);
        this.setTitle("LotoFacil");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(400, 200);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LotoFacil22();
            }
        });
    }
}