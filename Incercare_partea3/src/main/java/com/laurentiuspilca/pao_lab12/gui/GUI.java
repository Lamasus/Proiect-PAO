package com.laurentiuspilca.pao_lab12.gui;

import com.laurentiuspilca.pao_lab12.model.Eveniment;
import com.laurentiuspilca.pao_lab12.services.Ev_Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class  GUI  extends JFrame {
    private Ev_Service evenimentService = new Ev_Service();

    private JPanel p1 = new JPanel(new BorderLayout());
    private JPanel p2 = new JPanel(/*new FlowLayout(FlowLayout.LEFT)*/);

    private JLabel e1 = new JLabel("Durata_h:");
    private JLabel e2 = new JLabel("Durata_m:");
    private JLabel e3 = new JLabel("Pret:");
    private JLabel e4 = new JLabel("Locuri:");

    private JTextField t1 = new JTextField(10);
    private JTextField t2 = new JTextField(10);
    private JTextField t3 = new JTextField(10);
    private JTextField t4 = new JTextField(10);
    private JButton b1 = new JButton("ADAUGA");

    private DefaultListModel<Eveniment> model = new DefaultListModel<>();
    private JList<Eveniment> list = new JList<>(model);

    public GUI () {
        super("EVENIMENTE"); // TITLU
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null); // ALINIERE CENTRATA

        add(p1); // PE CENTRU
        add(p2, BorderLayout.SOUTH); // JOS

        p2.add(e1);
        p2.add(t1);
        p2.add(e2);
        p2.add(t2);
        p2.add(e3);
        p2.add(t3);
        p2.add(e4);
        p2.add(t4);
        p2.add(b1);
        b1.addActionListener(ev -> adaugaEv());

        p1.add(list);

        list.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Eveniment p = list.getSelectedValue();
                    if (p != null) {
                        deleteEv(p);
                    }
                }
            }

        });
        afisareEv();

        setVisible(true);
    }

    private void adaugaEv() {
        int duration_h = Integer.parseInt(t1.getText());
        int duration_m = Integer.parseInt(t2.getText());
        double price = Double.parseDouble(t3.getText());
        int locuri = Integer.parseInt(t4.getText());
        evenimentService.adaugaEv(duration_h,duration_m,price,locuri);
        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        t4.setText(null);
        afisareEv();
        JOptionPane.showMessageDialog(this, "Ai adaugat un produs!");
    }

    private void afisareEv() {
        model.clear();
        List<Eveniment> produse = evenimentService.getEv();

        produse.forEach(p -> model.addElement(p));
    }

    private void deleteEv(Eveniment p) {
        evenimentService.deleteEv(p);
        afisareEv();
    }

}
