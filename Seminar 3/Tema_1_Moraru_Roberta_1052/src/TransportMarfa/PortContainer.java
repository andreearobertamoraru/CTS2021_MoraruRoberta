package TransportMarfa;



public class PortContainer implements Cloneable,Numarabil,Descarcare{

    private int idContainer;
    private StatusContainer statusContainer; 
    private String eticheta;
    private Tip[] tipContainer;
    private int[] nrContainere;

    public PortContainer() {
        this.idContainer=0;
        this.statusContainer= StatusContainer.NECUNOSCUT;
        this.eticheta=null;
        this.tipContainer=null;
        this.nrContainere=null;
    }

    public PortContainer(int idContainer, StatusContainer statusContainer, String eticheta, Tip[] tipContainer, int[] nrContainere) {
        this.idContainer = idContainer;
        this.statusContainer = statusContainer;
        this.eticheta = eticheta;
        this.tipContainer = tipContainer;
        this.nrContainere = nrContainere;
    }

    public PortContainer(int idContainer, StatusContainer statusContainer, String eticheta, Tip[] tipContainer) {
        this.idContainer = idContainer;
        this.statusContainer = statusContainer;
        this.eticheta = eticheta;
        this.tipContainer = tipContainer;
    }

    public int getIdContainer() {
        return idContainer;
    }

    public void setIdContainer(int idContainer) {
        this.idContainer = idContainer;
    }

    public StatusContainer getStatusContainer() {
        return statusContainer;
    }

    public void setStatusContainer(StatusContainer statusContainer) {
        this.statusContainer = statusContainer;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public Tip[] getTipContainer() {
        return tipContainer;
    }

    public void setTipContainer(Tip[] tipContainer) {
        this.tipContainer = tipContainer;
    }
    public int[] getNrContainere()
    {
    return nrContainere;
    }
    public int getNrContainere(int ind) {
        return nrContainere[ind];
    }

    public void setNrContainere(int[] nrContainere ) {
        this.nrContainere = nrContainere;
    }
    public void setNrContainere(int ind, int val )
    {
        nrContainere[ind]=val;
    }



    @Override
    protected Object clone() throws CloneNotSupportedException {
        PortContainer copy= (PortContainer)super.clone();
        copy = new PortContainer(this.idContainer,this.statusContainer,this.eticheta,this.tipContainer);
        int[] test=new int[4] ;
        for(int aux=0;aux<4;aux++)
            test[aux]=this.getNrContainere(aux);
        copy.setNrContainere(test);
        return copy;

    }

    @Override
    public String toString() {
           return this.getEticheta()+ ","+
                this.tipContainer[0].toString()+ "," +this.tipContainer[1].toString()+","+this.tipContainer[2].toString()+","+this.tipContainer[3].toString()+","+
                String.valueOf(this.statusContainer)+","+this.nrContainere[0]+","+this.nrContainere[1]+","+this.nrContainere[2]+","+this.nrContainere[3];

    }


    @Override
    public int getCapacitate()
    {
        int capacitateTotala;
        capacitateTotala=100*nrContainere[3]+50*nrContainere[2]+25*nrContainere[1]+10*nrContainere[0];
        return capacitateTotala;
    }

    @Override
    public int DescarcaContainer( PortContainer pc, Macara mc)
    {
        if(mc.getTipContainer()==Tip.Jumbo_100mc)
        {
        return pc.getNrContainere(3);
        }  else if(mc.getTipContainer()==  Tip.Mare_50mc)
        {
            return pc.getNrContainere(2);
        }  else if(mc.getTipContainer()==Tip.Mediu_25mc)
        {
            return pc.getNrContainere(1);
        }  else if(mc.getTipContainer()==Tip.Mic_10mc)
        {
            return pc.getNrContainere(0);
        }
        else
        {
        return 0;
        }
    }
}
