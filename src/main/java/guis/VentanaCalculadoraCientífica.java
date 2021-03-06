package guis;

import modelo.Calculadora;
import modelo.CalculadoraCientifica;
import utilidades.Validador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Clase que contiene la ventana de la calculadora científica
 */
public class VentanaCalculadoraCientífica extends VentanaCalculadora {

    //// Atributos
    /**
     * Botón para realizar una potencia
     */
    private JButton potenciaButton;
    /**
     * Botón para realizar una raíz
     */
    private JButton raizButton;

    //// Constructores
    public VentanaCalculadoraCientífica(){
        iniciar();

        v = new Validador();

        //// Otras características de la ventana
        // Título
        setTitle("Calculadora Científica VM");
        // Tamaño inicial
        setSize(640, 300);
        // Iniciar en el centro
        setLocationRelativeTo(null);
        // Terminar el programa al salir de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciar(){
        super.iniciar();

        panel.remove(limpiarButton);
        panel.remove(salirButton);

        potenciaButton = new JButton("Potencia (n1^n2)");
        raizButton = new JButton("Raíz n2-ésima");

        panel.add(potenciaButton);
        panel.add(raizButton);
        panel.add(limpiarButton);
        panel.add(salirButton);

        // Implementación de ActionListener para el botón potenciaButton
        potenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si el texto no se puede convertir a double
                if(!v.esDouble(textFieldNumero1.getText()) || !v.esDouble(textFieldNumero1.getText())){
                    textFieldResultado.setText("ERROR");
                }

                else {
                    CalculadoraCientifica cc;
                    double num1 = Double.parseDouble(textFieldNumero1.getText());
                    double num2 = Double.parseDouble(textFieldNumero2.getText());

                    cc = new CalculadoraCientifica(num1, num2);

                    double resultado = cc.potencia();

                    textFieldResultado.setText("" + resultado);
                }
            }
        });

        // Implementación de ActionListener para el botón raizButton
        raizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si el texto no se puede convertir a double
                if(!v.esDouble(textFieldNumero1.getText()) || !v.esDouble(textFieldNumero1.getText())){
                    textFieldResultado.setText("ERROR");
                }

                else {
                    CalculadoraCientifica cc;
                    double num1 = Double.parseDouble(textFieldNumero1.getText());
                    double num2 = Double.parseDouble(textFieldNumero2.getText());

                    cc = new CalculadoraCientifica(num1, num2);

                    double resultado = cc.raiz();

                    textFieldResultado.setText("" + resultado);
                }
            }
        });
    }
}
