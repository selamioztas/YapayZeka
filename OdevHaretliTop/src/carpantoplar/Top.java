package carpantoplar;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


public class Top {
    
    Color renk;
    private float x, y, cap;
    private double xHiz, yHiz;

    public Top(float x, float y, float cap, Color renk) {
        this.x = x;
        this.y = y;
        this.cap = cap;
        this.renk = renk;
    }

    public void ciz(Graphics Deger) {
        Graphics2D grafik = (Graphics2D) Deger;
        Ellipse2D.Double cember = new Ellipse2D.Double(x - cap / 2, y - cap / 2, cap, cap);
        grafik.setColor(renk);
        grafik.fill(cember);
    }

    public void hareket() {        
        isleX((float) (x + xHiz));
                
        if (x - cap / 2 < 0) {
            x = cap / 2;
            xHiz = -xHiz;
        } else if (x + cap / 2 > Main.genislik) {
            xHiz = -xHiz;
        }

        isleY((float) (y + yHiz));
        if (y - cap / 2 < 0) {
            yHiz = -yHiz;
        } else if (y + cap / 2 > Main.yukseklik) {
            y = Main.yukseklik - cap / 2;
            yHiz = -yHiz;
        }
    }

    public double getirXHiz(){
        return xHiz;
    }
    public void isleXHiz(double Deger){
        this.xHiz = Deger;
    }
    public double getirYHiz(){
        return yHiz;
    }
    public void isleYHiz(double Deger){
        this.yHiz = Deger;
    }
    public float getirX(){
        return x;
    }
    public void isleX(float Deger){
        this.x = Deger;
    }
    public float getirY(){
        return y;
    }
    public void isleY(float Deger){
        this.y = Deger;
    }
    public float getirCap(){
        return cap;
    }
    public void isleCap(float Deger){
        this.cap = Deger;
    }
}
