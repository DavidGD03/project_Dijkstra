/*    */ package objetos;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Enlace
/*    */ {
/*    */   private Arista arista;
/*    */   
/*    */ 
/*    */ 
/*    */   private Nodo nodo;
/*    */   
/*    */ 
/*    */ 
/*    */   public Enlace()
/*    */   {
/* 18 */     this(new Arista(), new Nodo());
/*    */   }
/*    */   
/*    */   public Enlace(Arista arista, Nodo nodo) {
/* 22 */     this.arista = arista;
/* 23 */     this.nodo = nodo;
/*    */   }
/*    */   
/* 26 */   public void setArista(Arista arista) { this.arista = arista; }
/*    */   
/*    */   public Arista getArista() {
/* 29 */     return this.arista;
/*    */   }
/*    */   
/* 32 */   public void setNodo(Nodo nodo) { this.nodo = nodo; }
/*    */   
/*    */   public Nodo getNodo() {
/* 35 */     return this.nodo;
/*    */   }
/*    */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\objetos\Enlace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */