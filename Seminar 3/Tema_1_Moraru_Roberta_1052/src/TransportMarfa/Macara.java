package TransportMarfa;



public class Macara implements Cloneable {

    private int idMacara; 
    private StatusMacara statusMacara; 
    private Tip tipContainer;
    private int timpManipulare;

    public Macara() {
        this.idMacara=0;
        this.statusMacara=null;
        this.tipContainer=null;
        this.timpManipulare=0;
    }

    public Macara(int idMacara, StatusMacara statusMacara, Tip tipContainer, int timpManipulare) {
        this.idMacara = idMacara;
        this.statusMacara = statusMacara;
        this.tipContainer = tipContainer;
        this.timpManipulare = timpManipulare;
    }

    public int getIdMacara() {
        return idMacara;
    }

    public void setIdMacara(int idMacara) {
        this.idMacara = idMacara;
    }

    public StatusMacara getStatusMacara() {
        return statusMacara;
    }

    public void setStatusMacara(StatusMacara statusMacara) {
        this.statusMacara = statusMacara;
    }

    public Tip getTipContainer() {
        return tipContainer;
    }

    public void setTipContainer(Tip tipContainer) {
        this.tipContainer = tipContainer;
    }

    public int getTimpManipulare() {
        return timpManipulare;
    }

    public void setTimpManipulare(int timpManipulare) {
        this.timpManipulare = timpManipulare;
    }


    @Override
    public String toString() {
    			return this.idMacara+","
                +this.getStatusMacara().toString()+","
                +this.timpManipulare+","
                +this.tipContainer.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Macara copy= (Macara)super.clone();
        copy = new Macara(this.idMacara,this.statusMacara,this.tipContainer,this.timpManipulare);

        return copy;

    }
}
