package labtest;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode {
    private String name;
    private int length;
    private boolean limbs;
    private String gender;
    private boolean eyes;
    private PApplet p;
    private int c;

    public Nematode(TableRow tr, PApplet p) {
        this.name = tr.getString("name");
        this.length = tr.getInt("length");
        this.limbs = (tr.getInt("limbs") == 1) ? true : false;
        this.gender = tr.getString("gender");
        this.eyes = (tr.getInt("eyes") == 0) ? false : true;
        this.p = p;
        c = p.color(p.random(255), p.random(255), p.random(255));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    @Override
    public String toString() {
        return "Nematode [name=" + name + ", length=" + length + ", limbs=" + limbs + ", gender=" + gender + ", eyes="
                + eyes + "]";
    }

    int w = 50;
    public void render(){
        float creatureLength = w * length * 0.5f;
        p.pushMatrix();
        p.translate(p.width / 2, p.height / 2);
        p.translate(0, -creatureLength);
        p.fill(c);
        p.textAlign(PApplet.CENTER, PApplet.CENTER);
        p.text(getName(), 0, -w * 2);
        p.noFill();
        p.stroke(c);

        for(int i = 0; i < length; i++){
            float y = i * w;
            if(i == 0 && isEyes()){
                renderEyes(45);
                renderEyes(-45);
            }
            p.circle(0, y, w);

            if(limbs){
                renderLimbs(y);
            }

            if(i == length - 1){
                renderGender(y);
            }   

        }
        p.popMatrix();



    }

    private void renderLimbs(float y) {
        p.line(w, y, w/2, y);
        p.line(-w, y, -w/2, y);
    }

    private void renderGender(float y){
        switch(getGender()){
            case "m":
                p.line(0, y + (w / 2) , 0, y + w);
                p.circle(0, y + w, 5);
                break;
            case "f": 
                p.circle(0, y, w / 2);
                break;

            case "h": 
                p.line(0, y + (w / 2) , 0, y + w);
                p.circle(0, y + w, 5);
                p.circle(0, y, w / 2);
                break;
        }
    }

    private void renderEyes(float angle){
        int temp = w;
        w = w / 2;

        float x1 = PApplet.sin(PApplet.radians(angle)) * (w);
        float y1 = - PApplet.cos(PApplet.radians(angle)) * (w);

        float x2 = PApplet.sin(PApplet.radians(angle)) * (w + w);
        float y2 = - PApplet.cos(PApplet.radians(angle)) * (w + w);

        float ex = PApplet.sin(PApplet.radians(angle)) * (w + w + 5);
        float ey = - PApplet.cos(PApplet.radians(angle)) * (w + w + 5);

        p.circle(ex, ey, 5 * 2.0f);
        p.line(x1, y1, x2, y2);
        w = temp;
    }

   

}
