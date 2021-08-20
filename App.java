package reto4;

import java.awt.EventQueue;
import reto4.view.VistaRequerimientosReto4_MODIFICADA;

public class App{
    public static void main( String[] args ){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                try{
                    VistaRequerimientosReto4_MODIFICADA frame = new VistaRequerimientosReto4_MODIFICADA();
                    frame.setVisible(true);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
