/*     */ package objetos;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LineaQuebrada
/*     */ {
/*     */   private Coordenadas coordenadas;
/*     */   private Color color;
/*     */   private float grosorLinea;
/*     */   private String etiqueta;
/*     */   private int longitud;
/*     */   private boolean mostrarEtiqueta;
/*     */   
/*     */   public LineaQuebrada(Coordenadas coordenadas)
/*     */   {
/*  24 */     this.coordenadas = coordenadas;
/*  25 */     this.grosorLinea = 1.0F;
/*  26 */     this.color = Color.black;
/*  27 */     this.mostrarEtiqueta = true;
/*     */   }
/*     */   
/*  30 */   public void dibujarLineaQuebrada(Graphics g) { ((Graphics2D)g).setColor(getColor());
/*  31 */     ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*  32 */     BasicStroke stroke = new BasicStroke(this.grosorLinea);
/*  33 */     ((Graphics2D)g).setStroke(stroke);
/*  34 */     if (this.coordenadas != null) {
/*  35 */       int[] aux = new int[0];
/*  36 */       for (int i = 0; i < this.coordenadas.size(); i++) {
/*  37 */         aux = (int[])this.coordenadas.get(i);
/*  38 */         if (i == 0) {
/*  39 */           ((Graphics2D)g).drawLine(aux[0], aux[1], aux[0], aux[1]);
/*     */         } else {
/*  41 */           ((Graphics2D)g).drawLine(((int[])this.coordenadas.get(i - 1))[0], ((int[])this.coordenadas.get(i - 1))[1], aux[0], aux[1]);
/*     */         }
/*     */       }
/*     */       
/*  45 */       if (this.mostrarEtiqueta) {
/*  46 */         ((Graphics2D)g).setColor(Color.blue);
/*  47 */         Font fuente = new Font("Monospaced", 1, 12);
/*  48 */         g.setFont(fuente);
/*     */         
/*  50 */         if (this.coordenadas.size() == 2) {
/*  51 */           int xMenor = menor(((int[])this.coordenadas.get(0))[0], ((int[])this.coordenadas.get(1))[0]);
/*  52 */           int yMenor = menor(((int[])this.coordenadas.get(0))[1], ((int[])this.coordenadas.get(1))[1]);
/*     */           
/*  54 */           int xMayor = mayor(((int[])this.coordenadas.get(0))[0], ((int[])this.coordenadas.get(1))[0]);
/*  55 */           int yMayor = mayor(((int[])this.coordenadas.get(0))[1], ((int[])this.coordenadas.get(1))[1]);
/*     */           
/*  57 */           int distanciaVertical = yMayor - yMenor;
/*  58 */           int distanciaHorizontal = xMayor - xMenor;
/*  59 */           ((Graphics2D)g).drawString(this.longitud + "", distanciaHorizontal / 2 + xMenor, distanciaVertical / 2 + yMenor);
/*     */         } else {
/*  61 */           int pos = this.coordenadas.size() / 2;
/*     */           
/*  63 */           ((Graphics2D)g).drawString(this.longitud + "", ((int[])this.coordenadas.get(pos))[0] + 3, ((int[])this.coordenadas.get(pos))[1] - 8);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  70 */     stroke = new BasicStroke(1.0F);
/*  71 */     ((Graphics2D)g).setStroke(stroke);
/*     */   }
/*     */   
/*     */   private int mayor(int n1, int n2) {
/*  75 */     return n1 > n2 ? n1 : n2;
/*     */   }
/*     */   
/*  78 */   private int menor(int n1, int n2) { return n1 < n2 ? n1 : n2; }
/*     */   
/*     */   public void setColor(Color color) {
/*  81 */     this.color = color;
/*     */   }
/*     */   
/*  84 */   public Color getColor() { return this.color; }
/*     */   
/*     */   public void setGrosorLinea(float grosorLinea) {
/*  87 */     this.grosorLinea = grosorLinea;
/*     */   }
/*     */   
/*  90 */   public float getGrosorLinea() { return this.grosorLinea; }
/*     */   
/*     */   public void setEtiqueta(String etiqueta) {
/*  93 */     this.etiqueta = etiqueta;
/*     */   }
/*     */   
/*  96 */   public String getEtiqueta() { return this.etiqueta; }
/*     */   
/*     */   public int getLongitud()
/*     */   {
/* 100 */     return this.longitud;
/*     */   }
/*     */   
/*     */   public void setLongitud(int longitud) {
/* 104 */     this.longitud = longitud;
/*     */   }
/*     */   
/*     */   public Coordenadas getCoordenadas() {
/* 108 */     return this.coordenadas;
/*     */   }
/*     */   
/*     */   public void setCoordenadas(Coordenadas coordenadas) {
/* 112 */     this.coordenadas = coordenadas;
/*     */   }
/*     */   
/*     */   public boolean isMostrarEtiqueta() {
/* 116 */     return this.mostrarEtiqueta;
/*     */   }
/*     */   
/*     */   public void setMostrarEtiqueta(boolean mostrarEtiqueta) {
/* 120 */     this.mostrarEtiqueta = mostrarEtiqueta;
/*     */   }
/*     */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\objetos\LineaQuebrada.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */