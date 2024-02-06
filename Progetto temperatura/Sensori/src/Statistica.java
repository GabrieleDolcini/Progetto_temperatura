import java.io.IOException;
import java.util.Arrays;

public class Statistica {
    private Misurazione misurazioni[];

    private int max_misurazioni;

    public Statistica(int max_misurazioni) {
        this.max_misurazioni = max_misurazioni;
        this.misurazioni = new Misurazione[max_misurazioni];
    }

    //Getter

    public Misurazione getMisurazione(int pos) {
        return misurazioni[pos];
    }

    public void aggiungiMisurazione (Misurazione misurazione){
        boolean trovato = false;
        for(int i=0;i<max_misurazioni;i++){
            if(misurazioni[i] == null || !trovato){
                misurazioni[i] = misurazione;
                trovato = true;
            }
        }

    }

    public void SalvaSuFile() throws IOException{
        TextFile out = new TextFile("misurazioni.txt",'W');
        try{
            for(int pos = 0; pos<max_misurazioni; pos++){
                if(misurazioni[pos] != null){
                    String line = Integer.toString(pos);
                    line += ";" + misurazioni[pos].getId();
                    line += ";" + misurazioni[pos].getAula();
                    line += ";" + misurazioni[pos].getData();
                    line += ";" + misurazioni[pos].getOra();
                    line += ";" + misurazioni[pos].getTemperatura();
                    out.toFile(line);
                }
            }
        }catch(FileException exception){

        }
        out.closeFile();
    }

    public void caricaMisurazioni() throws IOException {
        TextFile in = new TextFile("misurazioni.txt", 'R');
        int pos, id;
        String linea, data, ora,aula;
        float temperatura;
        String elementi[];
        Misurazione misurazione;

        try{
            while(true){
                linea = in.fromFile();
                elementi = linea.split(";");
                if (elementi.length == 6){
                    pos = Integer.parseInt(elementi[0]);
                    id = Integer.parseInt(elementi[1]);
                    aula = elementi[2];
                    data = elementi[3];
                    ora = elementi[4];
                    temperatura = Float.parseFloat(elementi[5]);
                    misurazione = new Misurazione(id,aula,data,ora,temperatura);
                    aggiungiMisurazione(misurazione);
                }
            }
        }catch(FileException exception){
        }
    }

    @Override
    public String toString() {
        return "Statistica{" +
                "misurazioni=" + Arrays.toString(misurazioni) +
                ", max_misurazioni=" + max_misurazioni +
                '}';
    }
}
