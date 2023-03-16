package project;

import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class CenterElement {
    private PApplet p;
    private FFT fft;
    private int h, w;
    private float r;
    private LifeBoard board;

    public CenterElement(PApplet p, FFT fft){
        this.p = p;
        this.fft = fft;
        h = p.height / 2;
        w = p.width / 2;
        r = 310;
        board = new LifeBoard(200, p, r, w, h);
        board.spawnGliderGun();
    }

    public void outwardsSpikes(float amp){
        float xCord, yCord, angle = 0;
        float strokeV = 0;
        for(int i = 0; i < fft.specSize(); i+=10){
            angle = PApplet.radians(i);
			xCord = getW() + PApplet.sin(angle) * (amp / 3);
			yCord = getH() + PApplet.cos(angle) * (amp / 3);

            strokeV = PApplet.pow(PApplet.map(i, 15, fft.specSize(), 0, 1), 2) * 255;

            p.stroke(0, strokeV, strokeV);
            p.line(getW(), getH(), xCord, yCord);
        }
        
    }

    public void drawOutterCircle(float amp, float abSize){
        p.noStroke();
        float mapped = PApplet.map(amp, 0, abSize, 0, 255);
        int blue = p.color(0, 0, mapped);
        int brightBlue = p.color(0, mapped, mapped);

        p.fill(p.lerpColor(blue, brightBlue, 0.06f));    

        p.circle(getW(), getH(), getR());
        p.fill(0);
    }

    public void drawInnerCircle(){
        p.noStroke();
        p.fill(10, 0, 10);
        p.circle(w, h, getR() - 20);
        board.render();
        board.applyRules();
    }

    public void render(float amp, float abSize){
        outwardsSpikes(amp);    
        drawOutterCircle(amp, abSize); 
        drawInnerCircle(); 
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
}
