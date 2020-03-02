package carpantoplar;

import javax.swing.JFrame;



public class Main {
    // ekran ayarı
    public static int genislik = 640; 
    public static int yukseklik = 480;

    public static void main(String[] args) {
        
        JFrame pencere = new JFrame (" 5 tane Çarpan ve Zıplayan Toplar");
        
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setSize(genislik,yukseklik);
        
        Arayuz arayuz = new Arayuz();
        pencere.add(arayuz);        
        pencere.setVisible(true);
    }
}