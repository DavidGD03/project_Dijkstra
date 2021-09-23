/*     */ package objetos;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Grafo
/*     */ {
/*     */   private ArrayList<Nodo> listaNodo;
/*     */   
/*  16 */   public Grafo() { this.listaNodo = new ArrayList(); }
/*     */   
/*     */   public boolean adjuntarNodo(Nodo nodo) {
/*  19 */     Nodo nodoTemp = buscarNodo(nodo.getDato());
/*  20 */     if (nodoTemp == null) {
/*  21 */       this.listaNodo.add(nodo);
/*  22 */       return true;
/*     */     }
/*  24 */     return false;
/*     */   }
/*     */   
/*     */   public void crearEnlacesDirigido(Nodo padre, Nodo adyacente, Arista arista)
/*     */   {
/*  29 */     if ((padre != null) && (adyacente != null)) {
/*  30 */       padre.addNodoAdyacente(arista, adyacente);
/*     */     }
/*     */   }
/*     */   
/*     */   public void crearEnlacesNoDirigido(Nodo padre, Nodo adyacente, Arista arista) {
/*  35 */     crearEnlacesDirigido(padre, adyacente, arista);
/*  36 */     crearEnlacesDirigido(adyacente, padre, arista);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Nodo buscarNodo(Object dato)
/*     */   {
/*  46 */     Nodo temp = null;
/*  47 */     if (dato != null) {
/*  48 */       for (Nodo nodo : this.listaNodo) {
/*  49 */         if (dato.equals(nodo.getDato())) {
/*  50 */           temp = nodo;
/*     */         }
/*     */       }
/*     */     }
/*  54 */     return temp;
/*     */   }
/*     */   
/*  57 */   public Nodo buscarNodo(int x, int y) { Nodo nodoAuxiliar = null;
/*  58 */     for (int i = 0; i < this.listaNodo.size(); i++) {
/*  59 */       int xNodo = ((Nodo)this.listaNodo.get(i)).getCirculo().getX();
/*  60 */       int yNodo = ((Nodo)this.listaNodo.get(i)).getCirculo().getY();
/*  61 */       if ((x > xNodo) && (x < xNodo + ((Nodo)this.listaNodo.get(i)).getCirculo().getDiametro()) && 
/*  62 */         (y > yNodo) && (y < yNodo + ((Nodo)this.listaNodo.get(i)).getCirculo().getDiametro())) {
/*  63 */         nodoAuxiliar = (Nodo)this.listaNodo.get(i);
/*  64 */         break;
/*     */       }
/*     */     }
/*     */     
/*  68 */     return nodoAuxiliar;
/*     */   }
/*     */   
/*     */   public ArrayList<Nodo> getAdyacentes(Object dato) {
/*  72 */     ArrayList<Nodo> lista = null;
/*  73 */     Nodo principal = buscarNodo(dato);
/*  74 */     ArrayList<Enlace> aristas = principal.getListaNodoAdyacente();
/*  75 */     if (aristas != null) {
/*  76 */       for (int i = 0; i < aristas.size(); i++) {
/*  77 */         lista.add(((Enlace)aristas.get(i)).getNodo());
/*     */       }
/*     */     }
/*  80 */     return lista;
/*     */   }
/*     */   
/*  83 */   public ArrayList<Nodo> getListaNodos() { return this.listaNodo; }
/*     */   
/*     */   public boolean isAdyacente(Nodo n1, Nodo n2) {
/*  86 */     boolean aux = false;
/*  87 */     ArrayList<Enlace> listaAristas = n1.getListaNodoAdyacente();
/*  88 */     if (listaAristas != null) {
/*  89 */       for (int i = 0; i < listaAristas.size(); i++) {
/*  90 */         if (((Enlace)listaAristas.get(i)).getNodo() == n2) {
/*  91 */           aux = true;
/*     */         }
/*     */       }
/*     */     }
/*  95 */     return aux;
/*     */   }
/*     */   
/*  98 */   public boolean isAdyacente(Object datoNodoInicio, Object datoNodoDestino) { boolean aux = false;
/*  99 */     Nodo n1 = buscarNodo(datoNodoInicio);
/* 100 */     Nodo n2 = buscarNodo(datoNodoDestino);
/* 101 */     ArrayList<Enlace> listaAristas = n1.getListaNodoAdyacente();
/* 102 */     if (listaAristas != null) {
/* 103 */       for (int i = 0; i < listaAristas.size(); i++) {
/* 104 */         if (((Enlace)listaAristas.get(i)).getNodo() == n2) {
/* 105 */           aux = true;
/*     */         }
/*     */       }
/*     */     }
/* 109 */     return aux;
/*     */   }
/*     */   
/* 112 */   public Arista getArista(Object datoNodo1, Object datoNodo2) { return getArista(buscarNodo(datoNodo1), buscarNodo(datoNodo2)); }
/*     */   
/*     */   public Arista getArista(String nombreVia) {
/* 115 */     Arista aux = null;
/* 116 */     if (nombreVia != null) {
/* 117 */       ArrayList<Nodo> listaN = this.listaNodo;
/* 118 */       for (Nodo nd : listaN) {
/* 119 */         ArrayList<Enlace> lA = nd.getListaNodoAdyacente();
/* 120 */         for (Enlace enlace : lA) {
/* 121 */           if (enlace.getArista().getNombreArista().equals(nombreVia)) {
/* 122 */             aux = enlace.getArista();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 127 */     return aux;
/*     */   }
/*     */   
/* 130 */   public Arista getArista(Nodo n1, Nodo n2) { Arista aux = null;
/* 131 */     if (isAdyacente(n1, n2)) {
/* 132 */       ArrayList<Enlace> listaAristas = n1.getListaNodoAdyacente();
/* 133 */       for (int i = 0; i < listaAristas.size(); i++) {
/* 134 */         if (((Enlace)listaAristas.get(i)).getNodo() == n2) {
/* 135 */           aux = ((Enlace)listaAristas.get(i)).getArista();
/*     */         }
/*     */       }
/* 138 */     } else if (isAdyacente(n2, n1)) {
/* 139 */       aux = getArista(n2, n1);
/*     */     }
/* 141 */     return aux;
/*     */   }
/*     */   
/* 144 */   public Enlace getEnlace(Object datoNodo1, Object datoNodo2) { Enlace aux = null;
/* 145 */     if (isAdyacente(datoNodo1, datoNodo2)) {
/* 146 */       Nodo n1 = buscarNodo(datoNodo1);
/* 147 */       Nodo n2 = buscarNodo(datoNodo2);
/* 148 */       ArrayList<Enlace> listaAristas = n1.getListaNodoAdyacente();
/* 149 */       for (int i = 0; i < listaAristas.size(); i++) {
/* 150 */         if (((Enlace)listaAristas.get(i)).getNodo() == n2) {
/* 151 */           aux = (Enlace)listaAristas.get(i);
/*     */         }
/*     */       }
/*     */     }
/* 155 */     else if (isAdyacente(datoNodo2, datoNodo1)) {
/* 156 */       aux = getEnlace(datoNodo2, datoNodo1);
/*     */     }
/* 158 */     return aux;
/*     */   }
/*     */   
/* 161 */   public void reiniciarGrafoParaDisjktra() { for (Nodo n : this.listaNodo) {
/* 162 */       n.setMarca(false);
/* 163 */       n.setNodoAntecesorDisjktra(null);
/* 164 */       n.setLongitudCamino(-1);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean eliminarNodo(Nodo nodo) {
/* 169 */     boolean retornado = false;
/* 170 */     if (nodo != null) {
/* 171 */       retornado = this.listaNodo.remove(nodo);
/*     */     }
/* 173 */     return retornado;
/*     */   }
/*     */   
/*     */   public void reiniciarColores() {
/* 177 */     if (this.listaNodo != null) {
/* 178 */       for (Nodo nodo : this.listaNodo) {
/* 179 */         nodo.getCirculo().setColor(Color.yellow);
/* 180 */         ArrayList<Enlace> la = nodo.getListaNodoAdyacente();
/* 181 */         if (la != null) {
/* 182 */           for (Enlace enlace : la)
/* 183 */             if (enlace.getArista().isHabilitado()) {
/* 184 */               enlace.getArista().getLineaQuebrada().setColor(Color.black);
/* 185 */               enlace.getArista().getLineaQuebrada().setGrosorLinea(1.0F);
/*     */             }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Arista> aristasEntrante(Nodo nodo) {
/* 193 */     ArrayList<Arista> listaArista = null;
/* 194 */     for (Nodo n : this.listaNodo) {
/* 195 */       ArrayList<Enlace> enlaces = n.getListaNodoAdyacente();
/* 196 */       if (enlaces != null) {
/* 197 */         listaArista = new ArrayList();
/* 198 */         for (Enlace e : enlaces) {
/* 199 */           if (e.getNodo() == nodo) {
/* 200 */             listaArista.add(e.getArista());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 205 */     return listaArista;
/*     */   }
/*     */   
/* 208 */   public ArrayList<Arista> aristasSaliente(Nodo nodo) { ArrayList<Arista> listaArista = null;
/* 209 */     if ((nodo != null) && 
/* 210 */       (this.listaNodo.contains(nodo))) {
/* 211 */       ArrayList<Enlace> listaEnlace = nodo.getListaNodoAdyacente();
/* 212 */       if (listaArista != null) {
/* 213 */         listaArista = new ArrayList();
/* 214 */         for (Enlace e : listaEnlace) {
/* 215 */           listaArista.add(e.getArista());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 220 */     return listaArista;
/*     */   }
/*     */   
/*     */   private void eliminarAristas(Nodo nodo) {
/* 224 */     ArrayList<Arista> aristas = aristasSaliente(nodo);
/* 225 */     for (Arista a : aristas)
/* 226 */       a = null;
/*     */   }
/*     */   
/*     */   public void eliminarAristasSalientes(Nodo nodo) {
/* 230 */     ArrayList<Arista> aristas = aristasSaliente(nodo);
/* 231 */     eliminarAristas(nodo);
/*     */   }
/*     */   
/* 234 */   public void eliminarAristasEntrante(Nodo nodo) { ArrayList<Arista> aristas = aristasEntrante(nodo);
/* 235 */     eliminarAristas(nodo);
/*     */   }
/*     */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\objetos\Grafo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */