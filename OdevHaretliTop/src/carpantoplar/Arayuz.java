package carpantoplar;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



public class Arayuz extends JPanel implements Runnable { 
// 5 adet topumuzu tanımladıktan sonra bu topların bir birne mesafesini hesaplamamız lazım onun için 
// 1 için 1 den 2,3,4,5 e - 2 için 3,4,5 e -3 için 4 ,5 - 4 içinde 5 e olan mesafeler hesaplanacak     
    Top top1, top2, top3,top4,top5 ;
    double top12x, top12y, mesafe12, top13x, top13y, mesafe13, top23x, top23y, mesafe23;
    double top14x, top14y, mesafe14, top15x, top15y, mesafe15, top24x, top24y, mesafe24; 
    double top25x, top25y, mesafe25, top34x, top34y, mesafe34, top35x, top35y, mesafe35, top45x, top45y, mesafe45;
    Thread islem;

    public Arayuz() {        
        top1 = new Top(150, 150, 80, Color.green); // yeşil renkli topumuz
        top2 = new Top(90, 90, 60, Color.black);  // siyah renkli topumuz
        top3 = new Top(250, 200, 45, Color.blue); // mavi renkli topumuz
        top4 = new Top(200, 150, 70, Color.red); // kırmızı renkli topumuz
        top5 = new Top(120, 120, 60, Color.yellow); // sarı renkli toplumuz
        //topların x ve y yönündeki hız
        top1.isleXHiz(6);
        top1.isleYHiz(7);
        
        top2.isleXHiz(4);
        top2.isleYHiz(5);

        top3.isleXHiz(2);
        top3.isleYHiz(4);
        
        top4.isleXHiz(3);
        top4.isleYHiz(5);
        
        top5.isleXHiz(7);
        top5.isleYHiz(8);
       
        islem = new Thread(this);
        islem.start();
    }

    
    public void paintComponent(Graphics Deger) {
        super.paintComponent(Deger);
        top1.ciz(Deger);
        top2.ciz(Deger);
        top3.ciz(Deger);
        top4.ciz(Deger);
        top5.ciz(Deger);
    }

    
    public void run() {
        while (true) {            
            top1.hareket();
            top2.hareket();
            top3.hareket();
            top4.hareket();
            top5.hareket();

            carpisma();

            repaint();

            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                
            }
        }
    }

    public void carpisma() {        
        int carp1 = 3;
        int carp2 = 14;
        int carp3 = 8;
       
        
        int bol = 11;

        top12x = Math.abs(top1.getirX() - top2.getirX());
        top12y = Math.abs(top1.getirY() - top2.getirY());  
        mesafe12 = top12x * top12x + top12y * top12y;
        
        if (mesafe12 < (top1.getirCap() / 2 + top2.getirCap() / 2) * (top1.getirCap() / 2 + top2.getirCap() / 2)){
            double yeniXHizA = (top1.getirXHiz() * -carp1 + (carp2 * top2.getirXHiz())) / bol;
            double yeniXHizB = (top2.getirXHiz() * carp1 + (carp3 * top1.getirXHiz())) / bol;
            double yeniYHizA = (top1.getirYHiz() * -carp1 + (carp2 * top2.getirYHiz())) / bol;
            double yeniYHizB = (top2.getirYHiz() * carp1 + (carp3 * top1.getirYHiz())) / bol;
            top2.isleXHiz(yeniXHizB);
            top2.isleYHiz(yeniYHizB);
            top1.isleXHiz(yeniXHizA);
            top1.isleYHiz(yeniYHizA);
        }
        
        top13x = Math.abs(top1.getirX() - top3.getirX());
        top13y = Math.abs(top1.getirY() - top3.getirY());
        mesafe13 = top13x * top13x + top13y * top13y;
        
        if (mesafe13 < (top1.getirCap() / 2 + top3.getirCap() / 2) * (top1.getirCap() / 2 + top3.getirCap() / 2)){
            double yeniXHizA = (top1.getirXHiz() * -carp1 + (carp2 * top3.getirXHiz())) / bol;
            double yeniXHizB = (top3.getirXHiz() * carp1 + (carp3 * top1.getirXHiz())) / bol;
            double yeniYHizA = (top1.getirYHiz() * -carp1 + (carp2 * top3.getirYHiz())) / bol;
            double yeniYHizB = (top3.getirYHiz() * carp1 + (carp3 * top1.getirYHiz())) / bol;
            top3.isleXHiz(yeniXHizB);
            top3.isleYHiz(yeniYHizB);
            top1.isleXHiz(yeniXHizA);
            top1.isleYHiz(yeniYHizA);
        }
        
        top23x = Math.abs(top2.getirX() - top3.getirX());
        top23y = Math.abs(top2.getirY() - top3.getirY());
        mesafe23 = top23x * top23x + top23y * top23y;
        
        if (mesafe23 < (top2.getirCap() / 2 + top3.getirCap() / 2) * (top2.getirCap() / 2 + top3.getirCap() / 2)){
            double yeniXHizA = (top2.getirXHiz() * carp1 + (carp2 * top3.getirXHiz())) / bol;
            double yeniXHizB = (top3.getirXHiz() * carp1 + (carp3 * top2.getirXHiz())) / bol;
            double yeniYHizA = (top2.getirYHiz() * carp1 + (carp2 * top3.getirYHiz())) / bol;
            double yeniYHizB = (top3.getirYHiz() * carp1 + (carp3 * top2.getirYHiz())) / bol;
            top3.isleXHiz(yeniXHizB);
            top3.isleYHiz(yeniYHizB);
            top2.isleXHiz(yeniXHizA);
            top2.isleYHiz(yeniYHizA);
        }
        
        top14x = Math.abs(top1.getirX() - top4.getirX());
        top14y = Math.abs(top1.getirY() - top4.getirY());  
        mesafe14 = top14x * top14x + top14y * top14y;
        
        if (mesafe14 < (top1.getirCap() / 2 + top4.getirCap() / 2) * (top1.getirCap() / 2 + top4.getirCap() / 2)){
            double yeniXHizA = (top1.getirXHiz() * -carp1 + (carp2 * top4.getirXHiz())) / bol;
            double yeniXHizB = (top4.getirXHiz() * carp1 + (carp3 * top1.getirXHiz())) / bol;
            double yeniYHizA = (top1.getirYHiz() * -carp1 + (carp2 * top4.getirYHiz())) / bol;
            double yeniYHizB = (top4.getirYHiz() * carp1 + (carp3 * top1.getirYHiz())) / bol;
            top4.isleXHiz(yeniXHizB);
            top4.isleYHiz(yeniYHizB);
            top1.isleXHiz(yeniXHizA);
            top1.isleYHiz(yeniYHizA);
        }
        top15x = Math.abs(top1.getirX() - top5.getirX());
        top15y = Math.abs(top1.getirY() - top5.getirY());  
        mesafe15 = top15x * top15x + top15y * top15y;
        
        if (mesafe15 < (top1.getirCap() / 2 + top5.getirCap() / 2) * (top1.getirCap() / 2 + top5.getirCap() / 2)){
            double yeniXHizA = (top1.getirXHiz() * -carp1 + (carp2 * top5.getirXHiz())) / bol;
            double yeniXHizB = (top5.getirXHiz() * carp1 + (carp3 * top1.getirXHiz())) / bol;
            double yeniYHizA = (top1.getirYHiz() * -carp1 + (carp2 * top5.getirYHiz())) / bol;
            double yeniYHizB = (top5.getirYHiz() * carp1 + (carp3 * top1.getirYHiz())) / bol;
            top5.isleXHiz(yeniXHizB);
            top5.isleYHiz(yeniYHizB);
            top1.isleXHiz(yeniXHizA);
            top1.isleYHiz(yeniYHizA);
        }
        top24x = Math.abs(top2.getirX() - top4.getirX());
        top24y = Math.abs(top2.getirY() - top4.getirY());  
        mesafe24 = top24x * top24x + top24y * top24y;
        
        if (mesafe24 < (top2.getirCap() / 2 + top4.getirCap() / 2) * (top2.getirCap() / 2 + top4.getirCap() / 2)){
            double yeniXHizA = (top2.getirXHiz() * -carp1 + (carp2 * top4.getirXHiz())) / bol;
            double yeniXHizB = (top4.getirXHiz() * carp1 + (carp3 * top2.getirXHiz())) / bol;
            double yeniYHizA = (top2.getirYHiz() * -carp1 + (carp2 * top4.getirYHiz())) / bol;
            double yeniYHizB = (top4.getirYHiz() * carp1 + (carp3 * top2.getirYHiz())) / bol;
            top4.isleXHiz(yeniXHizB);
            top4.isleYHiz(yeniYHizB);
            top2.isleXHiz(yeniXHizA);
            top2.isleYHiz(yeniYHizA);
        }
        
        top25x = Math.abs(top2.getirX() - top5.getirX());
        top25y = Math.abs(top2.getirY() - top5.getirY());  
        mesafe25 = top25x * top25x + top25y * top25y;
        
        if (mesafe25 < (top2.getirCap() / 2 + top5.getirCap() / 2) * (top2.getirCap() / 2 + top5.getirCap() / 2)){
            double yeniXHizA = (top2.getirXHiz() * -carp1 + (carp2 * top5.getirXHiz())) / bol;
            double yeniXHizB = (top5.getirXHiz() * carp1 + (carp3 * top2.getirXHiz())) / bol;
            double yeniYHizA = (top2.getirYHiz() * -carp1 + (carp2 * top5.getirYHiz())) / bol;
            double yeniYHizB = (top5.getirYHiz() * carp1 + (carp3 * top2.getirYHiz())) / bol;
            top5.isleXHiz(yeniXHizB);
            top5.isleYHiz(yeniYHizB);
            top2.isleXHiz(yeniXHizA);
            top2.isleYHiz(yeniYHizA);
        }
        top35x = Math.abs(top3.getirX() - top5.getirX());
        top35y = Math.abs(top3.getirY() - top5.getirY());  
        mesafe35 = top35x * top35x + top35y * top35y;
        
        if (mesafe35 < (top3.getirCap() / 2 + top5.getirCap() / 2) * (top3.getirCap() / 2 + top5.getirCap() / 2)){
            double yeniXHizA = (top3.getirXHiz() * -carp1 + (carp2 * top5.getirXHiz())) / bol;
            double yeniXHizB = (top5.getirXHiz() * carp1 + (carp3 * top3.getirXHiz())) / bol;
            double yeniYHizA = (top3.getirYHiz() * -carp1 + (carp2 * top5.getirYHiz())) / bol;
            double yeniYHizB = (top5.getirYHiz() * carp1 + (carp3 * top3.getirYHiz())) / bol;
            top5.isleXHiz(yeniXHizB);
            top5.isleYHiz(yeniYHizB);
            top3.isleXHiz(yeniXHizA);
            top3.isleYHiz(yeniYHizA);
        }
        top34x = Math.abs(top3.getirX() - top4.getirX());
        top34y = Math.abs(top3.getirY() - top4.getirY());  
        mesafe34 = top34x * top34x + top34y * top34y;
        
        if (mesafe34 < (top3.getirCap() / 2 + top4.getirCap() / 2) * (top3.getirCap() / 2 + top4.getirCap() / 2)){
            double yeniXHizA = (top3.getirXHiz() * -carp1 + (carp2 * top4.getirXHiz())) / bol;
            double yeniXHizB = (top4.getirXHiz() * carp1 + (carp3 * top3.getirXHiz())) / bol;
            double yeniYHizA = (top3.getirYHiz() * -carp1 + (carp2 * top4.getirYHiz())) / bol;
            double yeniYHizB = (top4.getirYHiz() * carp1 + (carp3 * top3.getirYHiz())) / bol;
            top4.isleXHiz(yeniXHizB);
            top4.isleYHiz(yeniYHizB);
            top3.isleXHiz(yeniXHizA);
            top3.isleYHiz(yeniYHizA);
        }
        top45x = Math.abs(top4.getirX() - top5.getirX());
        top45y = Math.abs(top4.getirY() - top5.getirY());  
        mesafe45 = top45x * top45x + top45y * top45y;
        
        if (mesafe45 < (top4.getirCap() / 2 + top5.getirCap() / 2) * (top4.getirCap() / 2 + top5.getirCap() / 2)){
            double yeniXHizA = (top4.getirXHiz() * -carp1 + (carp2 * top5.getirXHiz())) / bol;
            double yeniXHizB = (top5.getirXHiz() * carp1 + (carp3 * top4.getirXHiz())) / bol;
            double yeniYHizA = (top4.getirYHiz() * -carp1 + (carp2 * top5.getirYHiz())) / bol;
            double yeniYHizB = (top5.getirYHiz() * carp1 + (carp3 * top4.getirYHiz())) / bol;
            top5.isleXHiz(yeniXHizB);
            top5.isleYHiz(yeniYHizB);
            top4.isleXHiz(yeniXHizA);
            top4.isleYHiz(yeniYHizA);
        }
        
    }
    
}