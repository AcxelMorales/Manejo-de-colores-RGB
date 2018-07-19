
package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author acxel
 */
public class Ventana extends JFrame {
    
    private JPanel panel;
    private JLabel label;
    private JButton bR, bV, bA;
    private int pulsado = 0, r = 0, v = 0, a = 0;

    public Ventana() {
        
        crearPanel();
        crearLabel();
        crearBotones();
    }
    
    private void crearPanel() {
        
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        eventoRueda();
    }
    
    private void crearLabel() {
        
        label = new JLabel("Color (Rojo, Verde Azul)", SwingConstants.CENTER);
        label.setBounds(100, 30, 400, 50);
        label.setFont(new Font("arial", 0, 20));
        panel.add(label);
    }
    
    private void crearBotones() {
        
        bR = new JButton("Rojo");
        bR.setBounds(50, 230, 130, 50);
        bR.setForeground(Color.red);
        bR.setFont(new Font("arial rounded mt bold", 0, 20));
        panel.add(bR);
        
        bV = new JButton("Verde");
        bV.setBounds(230, 230, 130, 50);
        bV.setForeground(Color.green);
        bV.setFont(new Font("arial rounded mt bold", 0, 20));
        panel.add(bV);
        
        bA = new JButton("Azul");
        bA.setBounds(410, 230, 130, 50);
        bA.setForeground(Color.blue);
        bA.setFont(new Font("arial rounded mt bold", 0, 20));
        panel.add(bA);
        
        bR.addActionListener((ActionEvent e) -> {
            
            pulsado = 1;
        });
        
        bV.addActionListener((ActionEvent e) -> {
            
            pulsado = 2;
        });
        
        bA.addActionListener((ActionEvent e) -> {
            
            pulsado = 3;
        });
    }
    
    private void eventoRueda() {
        
        panel.addMouseWheelListener((MouseWheelEvent e) -> {
            
            if (pulsado != 0) {
                
                if (pulsado == 1) {
                    
                    r += e.getWheelRotation();
                    
                    if (r < 0) r = 0;
                    
                    if (r > 255) r = 255;
                } else if (pulsado == 2) {
                    
                    v += e.getWheelRotation();
                    
                    if (v < 0) v = 0;
                    
                    if (v > 255) v = 255;
                } else {
                    
                    a += e.getWheelRotation();
                    
                    if (a < 0) a = 0;
                    
                    if (a > 255) a = 255;
                }
            }
            
            label.setText("Color (Rojo = "+r+", Verde = "+v+", Azul = "+a+")");
            panel.setBackground(new Color(r, v, a));
        });
    }
    
    public static void main(String... args) {
        
        Ventana o = new Ventana();
        o.setVisible(true);
        o.setSize(600, 400);
        o.setDefaultCloseOperation(EXIT_ON_CLOSE);
        o.setLocationRelativeTo(null);
        o.setResizable(false);
    }
}