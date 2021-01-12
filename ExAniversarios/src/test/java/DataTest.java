import static org.junit.jupiter.api.Assertions.*;

class DataTest {

    @org.junit.jupiter.api.Test
    void setDataDia() throws MesInvalidoException {
        boolean result = false;
        try {
            Data d1 = new Data(1, 1, 40);
        } catch (DiaInvalidoException e) {
            result = true;
        }
        assertTrue(result);
    }

    @org.junit.jupiter.api.Test
    void setDataMes() throws DiaInvalidoException {
        boolean result = false;
        try {
            Data d1 = new Data(1, 0, 1);
        } catch (MesInvalidoException e) {
            result = true;
        }
        assertTrue(result);
    }

}