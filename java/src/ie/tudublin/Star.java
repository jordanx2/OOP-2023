package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star {
    private boolean hap;

    public Star(boolean hap, String displayName, float xG, float yG, float zG, float absMag, float distance) {
        this.hap = hap;
        this.displayName = displayName;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
        this.distance = distance;
    }

    public Star(TableRow row){
        this(
            row.getInt("Hab?") == 1,
            row.getString("Display Name"),
            row.getFloat("Xg"),
            row.getFloat("Yg"),
            row.getFloat("Zg"),
            row.getFloat("AbsMag"),
            row.getFloat("Distance")
            );
    }

    public void render(PApplet p){
        float border = p.width * 0.1f;
        float x = PApplet.map(xG, -5, 5, border, p.width - border);
        float y = PApplet.map(yG, -5, 5, border, p.height - border);

        p.stroke(255, 255, 0);
    }

    private String displayName;
    private float xG;
    private float yG;
    private float zG;
    private float absMag;
    private float distance;

    public boolean isHap() {
        return hap;
    }
    public String getDisplayName() {
        return displayName;
    }
    public float getxG() {
        return xG;
    }
    public float getyG() {
        return yG;
    }
    public float getzG() {
        return zG;
    }
    public float getAbsMag() {
        return absMag;
    }
    public float getDistance() {
        return distance;
    }
    public void setHap(boolean hap) {
        this.hap = hap;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setxG(float xG) {
        this.xG = xG;
    }
    public void setyG(float yG) {
        this.yG = yG;
    }
    public void setzG(float zG) {
        this.zG = zG;
    }
    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }
    public void setDistance(float distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Star [hap=" + hap + ", displayName=" + displayName + ", xG=" + xG + ", yG=" + yG + ", zG=" + zG
                + ", absMag=" + absMag + ", distance=" + distance + "]";
    }
    
    
    
}
