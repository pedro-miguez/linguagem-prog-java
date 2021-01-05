import java.util.ArrayList;

public class MainEmpregado {

    public static void main(String[] args) {
        Data d1 = new Data(2010, 5, 10);
        Data d2 = new Data(2016, 6, 11);
        System.out.println(d1);

        Tempo t1 = new Tempo(9, 0,0);
        Tempo t2 = new Tempo(17, 0, 0);
        Tempo t3 = new Tempo(8, 30, 0);
        Tempo t4 = new Tempo(18, 0, 0);
        System.out.println(t1);
        System.out.println(t2);

        Empregado e1 = new Empregado("Jorge", "Assiz", d1, t1, t2);
        System.out.println(e1);

        Empregado e2 = new Empregado("Maria", "Cabriz", d1, t1, t2);
        System.out.println(e2);

        e2.setDataContrato(d2);
        e2.setHoraEntrada(t3);
        e2.setHoraSaida(t4);

        System.out.println(e1);
        System.out.println(e2);

        d1.setData(2020, 5, 11);
        t1.setHoras(10);
        t2.setHoras(20);

        System.out.println(e1);

        ArrayList<Empregado> empregados = new ArrayList<>();
        empregados.add(e1);
        empregados.add(e2);

        for (Empregado e : empregados) {
            System.out.println(e);
        }

        for (Empregado e : empregados) {
            System.out.println("Nome: " + e.getPrimeiroNome() + " " + e.getUltimoNome());
            System.out.println("Horas de trabalho Semanais: " + e.calcularHorasSemanais());
            System.out.println("Trabalha na empresa ha: " + e.calcularDiasContratado() + " dias.");
        }


    }

}
