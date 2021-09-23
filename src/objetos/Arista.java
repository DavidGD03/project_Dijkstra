/*    */ package objetos;
/*    */ 
/*    */ 
/*    */ public class Arista
/*    */ {
/*    */   private int idArista;
/*    */   
/*    */   private String nombreArista;
/*    */   
/*    */   private int peso;
/*    */   
/*    */   private LineaQuebrada lineaQuebrada;
/*    */   
/*    */   private boolean habilitado;
/*    */   
/*    */   public Arista()
/*    */   {
/* 18 */     this(-1, "");
/*    */   }
/*    */   
/*    */   public Arista(int idArista) {
/* 22 */     this(-1, "");
/*    */   }
/*    */   
/*    */   public Arista(int idArista, String nombreArista) {
/* 26 */     this(-1, "", 1);
/*    */   }
/*    */   
/*    */   public Arista(int idArista, String nombreArista, int peso) {
/* 30 */     this.idArista = idArista;
/* 31 */     this.nombreArista = nombreArista;
/* 32 */     this.peso = peso;
/* 33 */     this.lineaQuebrada = null;
/* 34 */     this.habilitado = true;
/*    */   }
/*    */   
/* 37 */   public void setIdArista(int idArista) { this.idArista = idArista; }
/*    */   
/*    */   public int getIdArista() {
/* 40 */     return this.idArista;
/*    */   }
/*    */   
/* 43 */   public void setNombreArista(String nombreVia) { this.nombreArista = nombreVia; }
/*    */   
/*    */   public String getNombreArista() {
/* 46 */     return this.nombreArista;
/*    */   }
/*    */   
/* 49 */   public void setPeso(int peso) { this.peso = peso; }
/*    */   
/*    */ 
/* 52 */   public int getPeso() { return this.peso; }
/*    */   
/*    */   public void setLineaQuebrada(LineaQuebrada lineaQuebrada) {
/* 55 */     this.lineaQuebrada = lineaQuebrada;
/* 56 */     if (lineaQuebrada != null)
/* 57 */       this.lineaQuebrada.setLongitud(this.peso);
/*    */   }
/*    */   
/*    */   public LineaQuebrada getLineaQuebrada() {
/* 61 */     return this.lineaQuebrada;
/*    */   }
/*    */   
/*    */   public boolean isHabilitado() {
/* 65 */     return this.habilitado;
/*    */   }
/*    */   
/*    */   public void setHabilitado(boolean habilitado) {
/* 69 */     this.habilitado = habilitado;
/*    */   }
/*    */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\objetos\Arista.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */