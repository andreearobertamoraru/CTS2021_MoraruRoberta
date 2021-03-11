package TransportMarfa;

import com.sun.jdi.connect.Connector;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Testare {

    public static void main(String[] args)
    {
          
          Tip tip[]={Tip.Jumbo_100mc,Tip.Mare_50mc,Tip.Mediu_25mc,Tip.Mic_10mc};
          int[] nrCnt1={1,2,3,4};
          int[] nrCnt2={0,0,10,4};
          int[] nrCnt3={4,23,44,58};
          int[] nrCnt4={2,66,92,0};

               
            PortContainer pc1=new PortContainer(1,StatusContainer.PLIN,"PortContainer1",tip,nrCnt1 );
            PortContainer pc2=new PortContainer(2,StatusContainer.GOL,"PortContainer2",tip,nrCnt1 );
            PortContainer pc3=new PortContainer(3,StatusContainer.INCARCAT,"PortContainer3",tip,nrCnt1 );
            PortContainer pc4=new PortContainer(4,StatusContainer.NECUNOSCUT,"PortContainer4",tip,nrCnt1 );  
            
        try {
            PortContainer pcCopy = (PortContainer) pc3.clone();
            System.out.println( pcCopy.toString());
        } catch (CloneNotSupportedException exception) {
            exception.printStackTrace();
        } 
        
        ArrayList<PortContainer> ListaContainere =new ArrayList<PortContainer>();
        ListaContainere.add(pc1);
        ListaContainere.add(pc2);
        ListaContainere.add(pc3);
        ListaContainere.add(pc4);
        System.out.println("\nAfisare ListaContainere");
        
        for (PortContainer aux : ListaContainere){
            System.out.println(aux.toString());
        }
        try {
            PortContainer pcCopy = (PortContainer) pc3.clone();
            System.out.println( pcCopy.clone());
        } catch (CloneNotSupportedException exception) {
            exception.printStackTrace();
        }

        Macara mc1=new Macara(1, StatusMacara.NEUTILIZABILA,Tip.Mare_50mc,365400);
        Macara mc2=new Macara(2, StatusMacara.SE_UITILIZEAZA,Tip.Jumbo_100mc,43900);
        Macara mc3=new Macara(3, StatusMacara.TIMEOUT,Tip.Mic_10mc,24000);
        Macara mc4=new Macara(4, StatusMacara.UTILIZABILA,Tip.Mediu_25mc,10000);


        try {
            Macara mcCopy = (Macara) mc2.clone();

            System.out.println( mcCopy.toString());
        } catch (CloneNotSupportedException exception) {
            exception.printStackTrace();
        }
        
        ArrayList<Macara> ListaMacara =new ArrayList<Macara>();
        ListaMacara.add(mc1);
        ListaMacara.add(mc2);
        ListaMacara.add(mc3);
        ListaMacara.add(mc4);

        try {
            FileWriter outfile =new FileWriter("PortContainer.csv",false);
            BufferedWriter bufferedWriter=new BufferedWriter(outfile);

            for(PortContainer aux : ListaContainere){
                bufferedWriter.write(aux.toString());
                bufferedWriter.newLine();
            }
//
            bufferedWriter.close();
            outfile.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        try {
            FileWriter outfile =new FileWriter("Macara.csv",false);
            BufferedWriter bufferedWriter=new BufferedWriter(outfile);

            for(Macara aux : ListaMacara){
                bufferedWriter.write(aux.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            outfile.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        ArrayDeque<PortContainer> ListaContainer2=new ArrayDeque<PortContainer>();

        try {
            FileReader inFile=new FileReader("PortContainer.csv");
            BufferedReader bufferedReader =new BufferedReader(inFile);

            Scanner scanner=new Scanner(bufferedReader);
            while(scanner.hasNext()){
                String line=scanner.nextLine();
                Scanner LineScanner=new Scanner(line);
                LineScanner.useDelimiter(",");
               
                PortContainer local = new PortContainer();
                local.setEticheta(LineScanner.next());

                Tip[] auxCOntainer=new Tip[4];
                for(int i=0;i<4;i++){
                    auxCOntainer[i]=Tip.valueOf(LineScanner.next());
                }

                local.setTipContainer(auxCOntainer);

                local.setStatusContainer(StatusContainer.valueOf(LineScanner.next()));

                int[] auxNr=new int[4];
                for(int i=0;i<4;i++){
                    auxNr[i]=LineScanner.nextInt();
                }

                local.setNrContainere(auxNr);
                ListaContainer2.offerLast(local);
            }

           
        bufferedReader.close();
        scanner.close();
     
            inFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            PortContainer The_ITERATOR;
        System.out.println("\nLISTA A 2-A )");
        while(!ListaContainer2.isEmpty()){
            The_ITERATOR = ListaContainer2.pollFirst();
            System.out.println(The_ITERATOR.toString());
        }

    }
}
