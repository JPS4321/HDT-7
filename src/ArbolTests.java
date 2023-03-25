import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ArbolTests {
    @Test
    void Buscar() {
        ArbolBinario test1 = new ArbolBinario();
        test1.insertar("hello","hola");
        Assertions.assertEquals("hola",test1.buscar("hello"));
    }
    void Insertar() {
        ArbolBinario test1 = new ArbolBinario();
        test1.insertar("dos","two");
        Assertions.assertEquals("two",test1.buscar("dos"));
    }



}
