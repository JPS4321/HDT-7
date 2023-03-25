public class ArbolBinario {

    private Nodo raiz;

    private class Nodo {
        String clave;
        String valor;
        Nodo izquierdo;
        Nodo derecho;

        public Nodo(String clave, String valor) {
            this.clave = clave;
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public ArbolBinario() {
        raiz = null;
    }

    public void agregar(String clave, String valor) {
        raiz = agregarRecursivo(raiz, clave, valor);
    }

    private Nodo agregarRecursivo(Nodo nodo, String clave, String valor) {
        if (nodo == null) {
            return new Nodo(clave, valor);
        }

        if (clave.compareTo(nodo.clave) < 0) {
            nodo.izquierdo = agregarRecursivo(nodo.izquierdo, clave, valor);
        } else if (clave.compareTo(nodo.clave) > 0) {
            nodo.derecho = agregarRecursivo(nodo.derecho, clave, valor);
        } else {
            nodo.valor = valor;
        }

        return nodo;
    }

    public String buscar(String clave) {
        return buscarRecursivo(raiz, clave);
    }

    private String buscarRecursivo(Nodo nodo, String clave) {
        if (nodo == null) {
            return null;
        }

        if (clave.compareTo(nodo.clave) == 0) {
            return nodo.valor;
        }

        if (clave.compareTo(nodo.clave) < 0) {
            return buscarRecursivo(nodo.izquierdo, clave);
        } else {
            return buscarRecursivo(nodo.derecho, clave);
        }
    }
}
