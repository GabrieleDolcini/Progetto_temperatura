public class Misurazione {
    private int id;
    private String aula;
    private String data;
    private String ora;
    private float temperatura;

    public Misurazione(int id, String aula, String data, String ora, float temperatura) {
        this.id = id;
        this.aula = aula;
        this.data = data;
        this.ora = ora;
        this.temperatura = temperatura;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getAula() {
        return aula;
    }

    public String getData() {
        return data;
    }

    public String getOra() {
        return ora;
    }

    public float getTemperatura() {
        return temperatura;
    }

    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
}