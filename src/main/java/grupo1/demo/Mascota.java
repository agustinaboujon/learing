package grupo1.demo;

//@Entity
public class Mascota {
    private String raza;
    private int patas;
    private boolean vivo;
    private String gruñir;

    public Mascota(String raza, int patas, boolean vivo){
        this.raza = raza;
        this.patas = patas;
        this.vivo = vivo;
    }

    public Mascota(){}

    public String getRaza(){
        return raza;
    }
    public void setRaza(String raza){
        this.raza = raza;
    }

    public int getPatas(){
        return patas;
    }
    public void setPatas(int patas){
        this.patas = patas;
    }

    public boolean getVivo(){
        return vivo;
    }
    public void setVivo(boolean vivo){
        this.vivo = vivo;
    }

    public boolean isVivo() {
        return vivo;
    }

    public String getGruñir() {
        return gruñir;
    }

    public void setGruñir(String gruñir) {
        this.gruñir = gruñir;
    }
}
