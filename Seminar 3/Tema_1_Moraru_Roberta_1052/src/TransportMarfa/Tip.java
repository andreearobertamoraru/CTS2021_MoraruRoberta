package TransportMarfa;

public enum Tip {

    Mic_10mc("Mic_10mc"),
    Mediu_25mc("Mediu_25mc"),
    Mare_50mc("Mare_50mc"),
    Jumbo_100mc("Jumbo_100mc");

    private String valoareMarfa;
    Tip(String valoareMarfa)
    {
        this.valoareMarfa=valoareMarfa;
    }



}
