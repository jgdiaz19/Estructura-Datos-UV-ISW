package uv.estructuras_datos._1_primitivas._3_colas.E0_Cola_Impresion;

public class FusionadorDeColas {
    public static ColaImpresion fusionar(ColaImpresion c1, ColaImpresion c2) {
        ColaImpresion nueva = new ColaImpresion();
        Nodo actual = c1.getFrente();
        while (actual != null) {
            nueva.agregarDocumento(actual.documento);
            actual = actual.siguiente;
        }
        actual = c2.getFrente();
        while (actual != null) {
            nueva.agregarDocumento(actual.documento);
            actual = actual.siguiente;
        }
        return nueva;
    }
}
