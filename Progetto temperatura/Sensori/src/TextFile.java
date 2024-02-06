import java.io.*;

/**
 * classe per la gestione sequenziale di un file di testo
 */
public class TextFile {
    private char mode; //R=read, W=write
    private BufferedReader reader;
    private BufferedWriter writer;

    /**
     * costruisce un oggetto di tipo BufferedReader/BufferedWriter
     * sopra il file specificato dal nome indicato.
     *
     * @param filename percorso e nome del file
     * @param mode     R per sola lettura, W per la scrittura
     */
    public TextFile(String filename, char mode) throws IOException {
        this.mode = 'R';
        if (mode == 'W' || mode == 'w') {
            this.mode = 'W';
            writer = new BufferedWriter(new FileWriter(filename));
        } else {
            reader = new BufferedReader(new FileReader(filename));
        }
    }
    /**
     * scrive una riga di testo in un file aperto in scrittura.
     * @param line riga di testo da scrivere nel file
     * @throws FileException se ol file è aperto in lettura
     */
    public void toFile(String line) throws FileException, IOException
    {
        if (this.mode == 'R') throw new FileException("Read-only"+"file!");
        writer.write(line);
        writer.newLine();
    }
    /**
     * legge una riga di testo da un file aperto in lettura.
     * @return riga di testo letta dal file
     * @throws FileException se il file è aperto in scrittura
     * @tjrows FileException se è stat raggiunta la fine del file
     */
    public String fromFile() throws FileException, IOException
    {
        String tmp;
        if(this.mode == 'W') throw new FileException("Write-only-file!");
        tmp = reader.readLine();
        if(tmp == null) throw new FileException("End of file!");
        return  tmp;
    }
    /**
     * chiude il file aperto dal costruttore
     */
    public void closeFile() throws IOException
    {
        if(this.mode == 'W')
            writer.close();
        else //this.mode == 'R'
            reader.close();
    }
}

