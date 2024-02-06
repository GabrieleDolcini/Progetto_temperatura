import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        int scelta;
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci le misurazioni massime da fare: ");
        int max_mis = sc.nextInt();
        sc.nextLine();
        Statistica stats = new Statistica(max_mis);

        do{
            scelta = Test.menu();
            switch (scelta) {
                case 1:
                    System.out.println("id: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("aula: ");
                    String aula = sc.nextLine();
                    System.out.println("data: ");
                    String data = sc.nextLine();
                    System.out.println("ora: ");
                    String ora = sc.nextLine();
                    System.out.println("temperatura: ");
                    float temperatura = sc.nextFloat();
                    sc.nextLine();
                    stats.aggiungiMisurazione(new Misurazione(id,aula,data,ora,temperatura));
                    break;
                case 2:
                    stats.SalvaSuFile();
                    System.out.println("Operazione completata!");
                    break;
                case 3:
                    int pos = 0;
                    Statistica copia = new Statistica(max_mis);
                    copia.caricaMisurazioni();
                    System.out.println("id: " + copia.getMisurazione(pos).getId());
                    System.out.println("aula: " + copia.getMisurazione(pos).getAula());
                    System.out.println("data: " + copia.getMisurazione(pos).getData());
                    System.out.println("ora: " + copia.getMisurazione(pos).getOra());
                    System.out.println("temperatura: " + copia.getMisurazione(pos).getTemperatura());
                    pos ++;
                break;
                case 4:
                    stats.toString();

                    break;
            }
        }while(scelta !=0);
    }
        public static int menu(){
            int scelta = -1;
            System.out.println("\nMENU");
            System.out.println("\n1) Aggiungi misurazioni");
            System.out.println("2) Salva su file");
            System.out.println("3)Leggi da file");
            System.out.println("4)Situazione misurazioni");
            System.out.println("0) Fine");
            System.out.print("Scelta: ");
            Scanner s = new Scanner(System.in);
        try {
            scelta = s.nextInt();
        }catch (java.util.InputMismatchException e){
            System.out.println("Scelta errata");
        }
            return scelta;
        }
}



