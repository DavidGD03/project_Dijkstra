/*     */ package objetos;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Nodo
/*     */ {
/*     */   private Object dato;
/*     */   private ArrayList<Enlace> listaNodoAdyacente;
/*  13 */   private boolean visitado = false;
/*     */   private Circulo circulo;
/*     */   private int izquierda;
/*     */   private int longitudCamino;
/*     */   private Nodo nodoAntecesorDisjktra;
/*     */   private boolean marca;
/*     */   
/*     */   public Nodo()
/*     */   {
/*  22 */     this.dato = new Object();
/*  23 */     this.circulo = null;
/*  24 */     this.izquierda = 0;
/*  25 */     inicializarParaDisjktra();
/*     */   }
/*     */   
/*     */   private void inicializarParaDisjktra() {
/*  29 */     this.longitudCamino = -1;
/*  30 */     this.nodoAntecesorDisjktra = null;
/*  31 */     this.marca = false;
/*     */   }
/*     */   
/*     */   public Nodo(Object dato, Coordenadas coordenada) {
/*  35 */     this.dato = dato;
/*  36 */     this.listaNodoAdyacente = new ArrayList();
/*  37 */     this.circulo = new Circulo(coordenada);
/*  38 */     this.circulo.setIzquierda(this.izquierda);
/*  39 */     inicializarParaDisjktra();
/*     */   }
/*     */   
/*     */   public void setDato(Object dato) {
/*  43 */     this.dato = dato;
/*     */   }
/*     */   
/*  46 */   public Object getDato() { return this.dato; }
/*     */   
/*     */   public ArrayList<Enlace> getListaNodoAdyacente() {
/*  49 */     ArrayList<Enlace> listAristaAux = null;
/*  50 */     if (!this.listaNodoAdyacente.isEmpty()) {
/*  51 */       listAristaAux = new ArrayList();
/*  52 */       for (Enlace enlace : this.listaNodoAdyacente) {
/*  53 */         if (enlace.getArista().isHabilitado()) {
/*  54 */           listAristaAux.add(enlace);
/*     */         }
/*     */       }
/*     */     }
/*  58 */     return listAristaAux;
/*     */   }
/*     */   
/*     */   public void addNodoAdyacente(Enlace arista) {
/*  62 */     this.listaNodoAdyacente.add(arista);
/*     */   }
/*     */   
/*  65 */   public void addNodoAdyacente(Arista via, Nodo nodo) { addNodoAdyacente(new Enlace(via, nodo)); }
/*     */   
/*     */   public void setVisitado(boolean visitado) {
/*  68 */     this.visitado = visitado;
/*     */   }
/*     */   
/*  71 */   public boolean isVisitado() { return this.visitado; }
/*     */   
/*     */   public Circulo getCirculo()
/*     */   {
/*  75 */     return this.circulo;
/*     */   }
/*     */   
/*     */   public void setCirculo(Circulo circulo) {
/*  79 */     this.circulo = circulo;
/*     */   }
/*     */   
/*     */   public int getLongitudCamino() {
/*  83 */     return this.longitudCamino;
/*     */   }
/*     */   
/*     */   public void setLongitudCamino(int longitudCamino) {
/*  87 */     this.longitudCamino = longitudCamino;
/*     */   }
/*     */   
/*     */   public boolean isMarca() {
/*  91 */     return this.marca;
/*     */   }
/*     */   
/*     */   public void setMarca(boolean marca) {
/*  95 */     this.marca = marca;
/*     */   }
/*     */   
/*     */   public Nodo getNodoAntecesorDisjktra() {
/*  99 */     return this.nodoAntecesorDisjktra;
/*     */   }
/*     */   
/*     */   public void setNodoAntecesorDisjktra(Nodo nodoAntecesorDisjktra) {
/* 103 */     this.nodoAntecesorDisjktra = nodoAntecesorDisjktra;
/*     */   }
/*     */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\objetos\Nodo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */