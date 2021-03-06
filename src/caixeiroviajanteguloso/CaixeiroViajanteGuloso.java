/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixeiroviajanteguloso;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tarcisio
 */
public class CaixeiroViajanteGuloso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int largura=800, altura=600;
                
                
        Pontos pt = new Pontos(4,largura,altura);
        JFrame application = new JFrame("Resultado");
        application.add(pt);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(largura,altura);
        application.setVisible(true);
        
        
        
        Gulosa gulosa = new Gulosa(pt.getCustos(), pt.getCoordenadas(), 3);
        int[] rota = gulosa.getRota();
        String aux = "";
        for (int i = 0; i < rota.length; i++) {
            aux+= "--"+rota[i];
        }
        JOptionPane.showMessageDialog(null, aux);
        
        Calculos cal = new Calculos(pt.getCustos(),gulosa.getRota(),pt.getCoordenadas());
        JFrame s_gulosa = new JFrame("Metodo GUloso");
        s_gulosa.add(cal);
        s_gulosa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s_gulosa.setSize(largura,altura);
        s_gulosa.setVisible(true);
        
        //Busca local aleatória
        BuscaLocal bl = new BuscaLocal(3, pt.getCustos());
        Calculos c2 = new Calculos(pt.getCustos(), bl.getRota(), pt.getCoordenadas());
        JFrame buscaAleatoria = new JFrame("Busca local aleatória");
        buscaAleatoria.add(c2);
        buscaAleatoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buscaAleatoria.setSize(altura,largura);
        buscaAleatoria.setVisible(true);
        
    }
    
}
