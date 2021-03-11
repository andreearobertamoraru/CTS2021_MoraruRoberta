package TransportMarfa;

public enum StatusMacara {
    UTILIZABILA("UTILIZABILA"),
    NEUTILIZABILA("NEUTILIZABILA"),
    SE_UITILIZEAZA("SE_UTILIZEAZA"),
    TIMEOUT("TIMEOUT");


   private String valoareMacara;
     StatusMacara(String valoareMacara)
    {
        this.valoareMacara=valoareMacara;
    }
}
