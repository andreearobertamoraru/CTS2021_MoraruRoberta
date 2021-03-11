package TransportMarfa;

public enum StatusContainer {
    PLIN("PLIN"),
    GOL("GOL"),
    INCARCAT("INCARCAT"),
    NECUNOSCUT("NECUNOSCUT");

    private String valoareContainer;
    StatusContainer(String valoareContainer)
    {
        this.valoareContainer=valoareContainer;
    }
}
