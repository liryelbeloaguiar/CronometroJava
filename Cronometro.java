import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// PARA RODAR 
// ABRA A JANELA - OUTPUT
// DEPOIS ADICIONAR COMENTARIOS EXPLICANDO O CODIGO
public class Cronometro extends JFrame {
    private JLabel label;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton; 
    private Timer timer;

    public Cronometro() {
        setTitle("Cronometro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("0");

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        resetButton = new JButton("Reset"); 
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                update();
            }
        });

        setLayout(new FlowLayout());
        add(label);
        add(startButton);
        add(stopButton);
        add(resetButton); 

        pack();
        setVisible(true);
    }

    private void start() {
        timer.start();
    }

    private void stop() {
        timer.stop();
    }

    private void reset() {
        label.setText("0");
    }

    private void update() {
        int count = Integer.parseInt(label.getText()) + 1;
        label.setText(Integer.toString(count));
    }

    public static void main(String[] args) {
        new Cronometro();
    }
}