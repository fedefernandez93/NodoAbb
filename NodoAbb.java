# NodoAbb

/*Clase NodoAbb
*
*Arbol Binario de Integer
*
*@author Federico Fernadez
*
*/


public class NodoAbb {
	//Atributos

	Integer item;
	/**
	*item: valor de los nodos
	*/

	NodoAbb hi;

	/**
	*hi: direccion del nodo izquierdo
	*/

	NodoAbb hd;

	/**
	*hd: direccion del nodo derecho
	*/	

	/**
	*Constructor de la clase
	*/

	public NodoAbb() {
		item = null;
		hi = null;
		hd = null;
	}
	

	/**
	*Setea el el valor del nodo
	*@param x
	*/
	public void setItem(Integer x) {
		item = x;
	}
	

	/**
	*Setea la direccion del Nodo izquierdo (hi)
	*@param x
	*/
	public void setHi(NodoAbb x) {
		hi = x;
	}
	

	/**
	*Setea la direccion del Nodo derecho (hd)
	*@param x
	*/
	public void setHd(NodoAbb x) {
		hd = x;
	}
	
	/**
	*Retorna el valor del nodo
	*@return item
	*/

	public Integer getItem() {
		return item;
	}
	

	/**
	*Retorna la direccion del Nodo izquierdo(hi)
	*@return hi
	*/

	public NodoAbb getHi() {
		return hi;
	}
	
	
	/**
	*Retorna la direccion del Nodo Derecho(hd)
	*@return hd
	*/
	public NodoAbb getHd() {
		return hd;
	}
	
	/**
	*
	*Imprime por pantalla el arbol en PreOrder
	*/
	public void printPreOrder() {
		System.out.println(item);
		if (this.hi != null) 
			hi.printPreOrder();
		if (this.hd != null) 
			hd.printPreOrder();
	}
	
	/**
	*
	*Imprime por pantalla el arbol en InOrder
	*/
	public void printInOrder() {
		if (this.hi != null)
			hi.printInOrder();
		System.out.println(item);
		if (this.hd != null)
			hd.printInOrder();
	}
	

	/**
	*
	*Imprimer por pantalla el arbol en PostOrder
	*/
	public void printPostOrder() {
		if (this.hi != null)
			hi.printPostOrder();
		if (this.hd != null)
			hd.printPostOrder();
		System.out.println(item);
	}
	

	/**
	*ins: inserta un nodo en el arbol
	*@param x
	*/
	public void ins(NodoAbb x) {
		if ((x.getItem() < this.getItem()) && (this.getHi() == null)) {
			this.hi = x;
			return ;
		}
		if ((x.getItem() > this.getItem()) && (this.getHd() == null)) {
			this.hd = x;
			return ;
		}
		if ((x.getItem() < this.getItem()) && (this.getHi() != null)) {
			this.hi.ins(x);
		}
		if ((x.getItem() > this.getItem()) && (this.getHd() != null)) {
			this.hd.ins(x);
		}
	}
	

	/**
	*search: busca un nodo en el arbol
	*@param x,y
	*@return x
	*/
	public NodoAbb search(NodoAbb x, Integer y) {
		if (y == x.getItem())
			return x;
		while (((x.getHi() != null) || (x.getHd() !=  null)) && (y != x.getItem())){
			if (y < x.getItem())
				x = x.getHi();
			else{
				if (y > x.getItem())
					x = x.getHd();
			}
		}
		if (x.getItem() == y)
			return x;
		else
			throw new RuntimeException("El elemento no esta en el arbol");
		
	}

	/**
	*pert: retorna true si el nodo buscado esta en el arbol
	*	     sino retorna false
	*@param y 
	*@return boolean
	*/
	public boolean pert(NodoAbb y){
		NodoAbb rec = new NodoAbb();
		NodoAbb aux = new NodoAbb();
		rec = this;
		aux = this.search(rec, y.getItem());
		if (y.getItem() == aux.getItem()){
			return true;
		} else {
			return false;
		}
	}
	
}
