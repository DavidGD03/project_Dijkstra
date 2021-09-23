/*     */ package objetos;
/*     */ 
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Circulo
/*     */ {
/*     */   private Coordenadas coordenadas;
/*     */   private Color color;
/*     */   private int diametro;
/*     */   private String etiqueta;
/*     */   private Font fuente;
/*     */   private int izquierda;
/*     */   private int grosorBorde;
/*     */   
/*     */   public Circulo(Coordenadas coordenadas)
/*     */   {
/*  25 */     this.coordenadas = coordenadas;
/*  26 */     this.color = Color.yellow;
/*  27 */     this.diametro = 10;
/*  28 */     this.etiqueta = "";
/*  29 */     this.fuente = null;
/*  30 */     this.izquierda = 0;
/*  31 */     this.grosorBorde = 2;
/*     */   }
/*     */   
/*  34 */   public void dibujarCirculo(Graphics g) { if (this.coordenadas.size() > 0) {
/*  35 */       ((Graphics2D)g).setColor(this.color);
/*     */       
/*  37 */       ((Graphics2D)g).setStroke(new BasicStroke(getGrosorBorde()));
/*     */       
/*  39 */       ((Graphics2D)g).fillOval(((int[])this.coordenadas.get(0))[0], ((int[])this.coordenadas.get(0))[1], this.diametro, this.diametro);
/*  40 */       ((Graphics2D)g).setColor(Color.black);
/*  41 */       ((Graphics2D)g).drawOval(((int[])this.coordenadas.get(0))[0], ((int[])this.coordenadas.get(0))[1], this.diametro, this.diametro);
/*  42 */       if (!"".equals(this.etiqueta)) {
/*  43 */         if (this.fuente != null) {
/*  44 */           g.setFont(this.fuente);
/*     */         }
/*     */         
/*  47 */         ((Graphics2D)g).drawString(this.etiqueta, ((int[])this.coordenadas.get(0))[0] - this.izquierda, ((int[])this.coordenadas.get(0))[1]);
/*     */         
/*     */ 
/*  50 */         ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*     */       }
/*     */     } else {
/*  53 */       System.out.println("No hay coordenadas para el circulo");
/*     */     }
/*     */   }
/*     */   
/*  57 */   public void setColor(Color color) { this.color = color; }
/*     */   
/*     */   public Color getColor() {
/*  60 */     return this.color;
/*     */   }
/*     */   
/*  63 */   public void setDiametro(int diametro) { this.diametro = diametro; }
/*     */   
/*     */   public int getDiametro() {
/*  66 */     return this.diametro;
/*     */   }
/*     */   
/*  69 */   public void setEtiqueta(String etiqueta) { this.etiqueta = etiqueta; }
/*     */   
/*     */   public void setEtiqueta(String etiqueta, boolean izquierda) {
/*  72 */     this.etiqueta = etiqueta;
/*     */   }
/*     */   
/*  75 */   public String getEtiqueta() { return this.etiqueta; }
/*     */   
/*     */   public int getX() {
/*  78 */     if (this.coordenadas.size() > 0) {
/*  79 */       return ((int[])this.coordenadas.get(0))[0];
/*     */     }
/*  81 */     return -1;
/*     */   }
/*     */   
/*     */   public int getY() {
/*  85 */     if (this.coordenadas.size() > 0) {
/*  86 */       return ((int[])this.coordenadas.get(0))[1];
/*     */     }
/*  88 */     return -1;
/*     */   }
/*     */   
/*     */   public Font getFuente()
/*     */   {
/*  93 */     return this.fuente;
/*     */   }
/*     */   
/*     */   public void setFuente(Font fuente) {
/*  97 */     this.fuente = fuente;
/*     */   }
/*     */   
/*     */   public int isIzquierda() {
/* 101 */     return this.izquierda;
/*     */   }
/*     */   
/*     */   public void setIzquierda(int izquierda) {
/* 105 */     this.izquierda = izquierda;
/*     */   }
/*     */   
/*     */   public int getGrosorBorde() {
/* 109 */     return this.grosorBorde;
/*     */   }
/*     */   
/*     */   public void setGrosorBorde(int grosorBorde) {
/* 113 */     this.grosorBorde = grosorBorde;
/*     */   }
/*     */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\objetos\Circulo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */