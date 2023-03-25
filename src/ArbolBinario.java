public class ArbolBinario {
    NodoArbol raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(String clave, String valor) {
        NodoArbol nuevoNodo = new NodoArbol(clave, valor);

        if (this.raiz == null) {
            this.raiz = nuevoNodo;
        } else {
            insertarAux(this.raiz, nuevoNodo);
        }
    }

    private void insertarAux(NodoArbol nodoActual, NodoArbol nuevoNodo) {
        if (nodoActual.clave.compareTo(nuevoNodo.clave) > 0) {
            if (nodoActual.izquierda == null) {
                nodoActual.izquierda = nuevoNodo;
            } else {
                insertarAux(nodoActual.izquierda, nuevoNodo);
            }
        } else if (nodoActual.clave.compareTo(nuevoNodo.clave) < 0) {
            if (nodoActual.derecha == null) {
                nodoActual.derecha = nuevoNodo;
            } else {
                insertarAux(nodoActual.derecha, nuevoNodo);
            }
        } else {
            nodoActual.valor = nuevoNodo.valor;
        }
    }

    public String buscar(String clave) {
        NodoArbol nodoActual = this.raiz;

        while (nodoActual != null) {
            if (nodoActual.clave.compareTo(clave) > 0) {
                nodoActual = nodoActual.izquierda;
            } else if (nodoActual.clave.compareTo(clave) < 0) {
                nodoActual = nodoActual.derecha;
            } else {
                return nodoActual.valor;
            }
        }

        return null;
    }

    public void imprimirRelaciones() {
        imprimirRelacionesAux(this.raiz);
    }

    private void imprimirRelacionesAux(NodoArbol nodoActual) {
        if (nodoActual != null) {
            System.out.println("Clave: " + nodoActual.clave + ", Valor: " + nodoActual.valor);
            if (nodoActual.izquierda != null) {
                System.out.println("Relación con nodo izquierdo: Clave: " + nodoActual.izquierda.clave + ", Valor: " + nodoActual.izquierda.valor);
            }
            if (nodoActual.derecha != null) {
                System.out.println("Relación con nodo derecho: Clave: " + nodoActual.derecha.clave + ", Valor: " + nodoActual.derecha.valor);
            }
            imprimirRelacionesAux(nodoActual.izquierda);
            imprimirRelacionesAux(nodoActual.derecha);
        }
    }
}