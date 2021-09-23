/*    */ package objetos;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Coordenadas
/*    */   extends ArrayList<int[]>
/*    */ {
/*    */   private int xMaxima;
/*    */   private int yMaxima;
/*    */   
/*    */   public Coordenadas()
/*    */   {
/* 16 */     this(0, 0);
/*    */   }
/*    */   
/*    */   public Coordenadas(int xMaxima, int yMaxima)
/*    */   {
/* 21 */     this.xMaxima = xMaxima;
/* 22 */     this.yMaxima = yMaxima;
/*    */   }
/*    */   
/*    */   public Coordenadas(int xMaxima, int yMaxima, int x, int y)
/*    */   {
/* 27 */     this.xMaxima = xMaxima;
/* 28 */     this.yMaxima = yMaxima;
/* 29 */     addCoordenada(x, y);
/*    */   }
/*    */   
/* 32 */   public void setXMaxima(int xMaxima) { this.xMaxima = xMaxima; }
/*    */   
/*    */ 
/* 35 */   public void setYMaxima(int yMaxima) { this.yMaxima = yMaxima; }
/*    */   
/*    */   public void addCoordenada(int x, int y) {
/* 38 */     if ((x >= 0) && (x <= this.xMaxima) && (y >= 0) && (y <= this.yMaxima))
/*    */     {
/* 40 */       int[] parXY = { x, y };
/* 41 */       add(parXY);
/*    */     }
/*    */   }
/*    */   
/*    */   public int getxMaxima() {
/* 46 */     return this.xMaxima;
/*    */   }
/*    */   
/*    */   public int getyMaxima() {
/* 50 */     return this.yMaxima;
/*    */   }
/*    */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\objetos\Coordenadas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */