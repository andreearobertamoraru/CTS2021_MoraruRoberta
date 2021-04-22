package TransportMarfa;

public interface Descarcare {

    public default int DescarcaContainer(PortContainer pc, Macara m)
    {
        return 0;
    }
}
