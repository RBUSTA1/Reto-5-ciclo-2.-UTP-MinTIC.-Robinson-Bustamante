/*Importaciones*/
package reto4.view;
//------------------------------
import reto4.controller.Controlador;
//------------------------------
import reto4.model.vo.LiderPorSalario;
import reto4.model.vo.LideresPorNombre;
import reto4.model.vo.ProyectoPorTipo;
//------------------------------
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
//------------------------------
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

//-----------------------------------------------------------------------------------------------------------------------

public class VistaRequerimientosReto4_MODIFICADA extends JFrame{
    public static final Controlador control = new Controlador();
    //------------------------------
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea AreaTexto;

    public VistaRequerimientosReto4_MODIFICADA() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 200, 820, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null); //Muy importante, optimiza la vista
        //------------------------------
        /*Etiquetas*/
        JLabel RETO5_Etiqueta = new JLabel("RETO 5");
        RETO5_Etiqueta.setBounds(28, 15, 60, 16);
        contentPane.add(RETO5_Etiqueta);

        JLabel CICLO2_Etiqueta = new JLabel("Robinson Dario Bustamante Restrepo");
        CICLO2_Etiqueta.setBounds(28, 35, 220, 16);
        contentPane.add(CICLO2_Etiqueta);
        //------------------------------
        /*Funcion de deslizamiento o "scroll"*/
        JScrollPane scroll_funcion = new JScrollPane();
        scroll_funcion.setBounds(28, 70, 740, 455);
        contentPane.add(scroll_funcion);
        //------------------------------
        /*Area de texto*/
        AreaTexto = new JTextArea();
        scroll_funcion.setViewportView(AreaTexto);
        //------------------------------
        /*Boton consulta #1*/
        JButton boton_consulta1 = new JButton("Consulta 1");
        boton_consulta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento1();
            }
        });
        boton_consulta1.setBounds(28, 528, 120, 30);
        contentPane.add(boton_consulta1);
        //------------------------------
        /*Boton consulta #2*/
        JButton boton_consulta2 = new JButton("Consulta 2");
        boton_consulta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento2();
            }
        });
        boton_consulta2.setBounds(150, 528, 120, 30);
        contentPane.add(boton_consulta2);
        //------------------------------
        /*Boton consulta #3*/
        JButton boton_consulta3 = new JButton("Consulta 3");
        boton_consulta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requerimiento3();
            }
        });
        boton_consulta3.setBounds(272, 528, 120, 30);
        contentPane.add(boton_consulta3);
    }
    //---------------------------------------------------
    /*Requerimiento #1*/
    public void requerimiento1(){
        try {
            ArrayList<LiderPorSalario> lista = control.requerimiento_1();
            String output = "*** Lider por Salario *** \n\nNombre\tPrimer_Apellido\t\tID_Lider\t\tSalario\n\n";
            for (LiderPorSalario lider : lista) {
                output += lider.getNombre();
                output += "\t";
                output += lider.getApellido();
                output += "\t\t";
                output += lider.getId_lider();
                output += "\t\t";
                output += lider.getSalario();
                output += "\n";
            }
            AreaTexto.setText(output);
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
    //---------------------------------------------------
    /*Requerimiento #2*/
    public void requerimiento2(){
        try {
            ArrayList<ProyectoPorTipo> lista = control.requerimiento_2();
            String output = "*** Proyectos por Tipo *** \n\nID_Proyecto\tConstructora\t\tCiudad\t\tEstrato\n\n";
            for (ProyectoPorTipo lider : lista) {
                output += lider.getId_p();
                output += "\t";
                output += lider.getConstructora();
                /*if(lider.getConstructora().length() <= 11) {
                    output += "\t\t";
                } else {
                    output += "\t";
                }
                //output += "\t";*/
                if(lider.getConstructora().equals("Pegaso")){
                    output += "\t\t";
                } else {
                    output += "\t";
                }
                output += lider.getCiudad();
                if(lider.getId_p() == 128){
                    output += "\t";
                    output += lider.getCiudad();
                    output += "\t\t";
                } else if(lider.getId_p() == 195){
                    output += "\t";
                    output += lider.getCiudad();
                    output += "\t\t";
                } else if(lider.getId_p() == 363){
                    output += "\t";
                    output += lider.getCiudad();
                    output += "\t\t";
                } else if(lider.getId_p() == 353){
                    output += "\t";
                    output += lider.getCiudad();
                    output += "\t\t";
                } else {
                    output += "\t\t";
                }
                output += lider.getEstrato();
                output += "\n";
            }
            AreaTexto.setText(output);
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
    //---------------------------------------------------
    /*Requerimiento #3*/
    public void requerimiento3(){
        try {
            ArrayList<LideresPorNombre> lista = control.requerimiento_3();
            String output = "*** Lideres por Nombre *** \n\nID_Lider\tNombre\t\tPrimer_Apellido\n\n";
            for (LideresPorNombre lider : lista) {
                output += lider.getId_lider();
                output += "\t";
                output += lider.getNombre();
                output += "\t\t";
                output += lider.getApellido();
                output += "\n";
            }
            AreaTexto.setText(output);
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error!" + e.getMessage());
        }
    }
}