/*    */ package operaciones;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import objetos.Nodo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ListaNodo
/*    */   extends ArrayList<Nodo>
/*    */ {
/*    */   public Nodo buscarMenor()
/*    */   {
/* 17 */     Nodo aux = new Nodo();
/* 18 */     aux.setLongitudCamino(9999999);
/*    */     
/* 20 */     for (Nodo nodo : this) {
/* 21 */       if (nodo.getLongitudCamino() < aux.getLongitudCamino()) {
/* 22 */         aux = nodo;
/*    */       }
/*    */     }
/*    */     
/* 26 */     return aux;
/*    */   }
/*    */   
/* 29 */   public boolean isContenido(Nodo nodo) { boolean retornado = false;
/* 30 */     for (Nodo n : this) {
/* 31 */       if (n == nodo) {
/* 32 */         retornado = true;
/*    */       }
/*    */     }
/* 35 */     return retornado;
/*    */   }
/*    */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\operaciones\ListaNodo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */