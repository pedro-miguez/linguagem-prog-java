public class Empregado {

    private String primeiroNome;
    private String ultimoNome;
    private Data dataContrato;
    private Tempo horaEntrada;
    private Tempo horaSaida;

    public Empregado (String primeiroNome, String ultimoNome, Data dataContrato, Tempo horaEntrada, Tempo horaSaida) {
        setPrimeiroNome(primeiroNome);
        setUltimoNome(ultimoNome);
        setDataContrato(new Data (dataContrato));
        setHoraEntrada(new Tempo (horaEntrada));
        setHoraSaida(new Tempo(horaSaida));
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public Data getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Data dataContrato) {
        this.dataContrato = dataContrato;
    }

    public Tempo getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Tempo horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Tempo getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Tempo horaSaida) {
        this.horaSaida = horaSaida;
    }

    public double calcularHorasSemanais() {
        int difference = getHoraEntrada().diferencaEmSegundos(getHoraSaida());

        return (double)difference / 3600 * 5;
    }

    public int calcularDiasContratado() {
        return getDataContrato().diferenca(Data.dataAtual());
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "primeiroNome=' " + primeiroNome + '\'' +
                ", ultimoNome=' " + ultimoNome + '\'' +
                ", dataContrato= " + dataContrato +
                ", horaEntrada= " + horaEntrada +
                ", horaSaida= " + horaSaida +
                '}';
    }
}
