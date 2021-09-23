/*    */ package operaciones;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.util.ArrayList;
import javax.swing.JOptionPane;
/*    */ import objetos.Arista;
/*    */ import objetos.Enlace;
/*    */ import objetos.Grafo;
/*    */ import objetos.LineaQuebrada;
/*    */ import objetos.Nodo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Disjktra
/*    */ {
/*    */   Grafo grafo;
/*    */   ListaNodo listaNodosAdyacentes;
/* 21 */   ArrayList<Arista> aux = new ArrayList();
/*    */   int sumPesos;
           int cNodos;
/* 23 */   public Disjktra(Grafo grafo) { this.grafo = grafo;
/* 24 */     this.listaNodosAdyacentes = new ListaNodo();
/*    */   }
           
           public int getPesos(){
               return sumPesos;
           }
           
           public int getCNodos(){
               return cNodos;
           }
/*    */   
/* 27 */   private void llenarConAdyacentes(Nodo nodo) { if (nodo != null) {
/* 28 */       ArrayList<Enlace> listaAux = nodo.getListaNodoAdyacente();
/* 29 */       if (listaAux != null) {
/* 30 */         for (Enlace enlace : listaAux) {
/* 31 */           Nodo aux2 = enlace.getNodo();
/* 32 */           if (!aux2.isMarca())
/*    */           {
/* 34 */             if (this.listaNodosAdyacentes.isContenido(aux2)) {
/* 35 */               int longitud = nodo.getLongitudCamino() + enlace.getArista().getPeso();
/* 36 */               if (aux2.getLongitudCamino() > longitud) {
/* 37 */                 aux2.setLongitudCamino(longitud);
/* 38 */                 aux2.setNodoAntecesorDisjktra(nodo);
/*    */               }
/*    */             } else {
/* 41 */               aux2.setLongitudCamino(nodo.getLongitudCamino() + enlace.getArista().getPeso());
/* 42 */               aux2.setNodoAntecesorDisjktra(nodo);
/* 43 */               this.listaNodosAdyacentes.add(aux2);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void ejecutar(Nodo nodoInicio) {
/* 52 */     nodoInicio.setLongitudCamino(0);
/* 53 */     if (nodoInicio != null) {
/* 54 */       this.listaNodosAdyacentes = new ListaNodo();
/* 55 */       this.listaNodosAdyacentes.add(nodoInicio);
/* 56 */       while (!this.listaNodosAdyacentes.isEmpty()) {
/* 57 */         Nodo menor = this.listaNodosAdyacentes.buscarMenor();
/* 58 */         menor.setMarca(true);
/* 59 */         this.listaNodosAdyacentes.remove(menor);
/* 60 */         llenarConAdyacentes(menor);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private void rutaCorta(Nodo nodoFinal) {
/* 66 */     this.aux.clear();
/* 67 */     Nodo nAux = nodoFinal;
/* 68 */     while (nAux.getNodoAntecesorDisjktra() != null)
/*    */     {
/*    */ 
/* 71 */       this.aux.add(this.grafo.getArista(nAux, nAux.getNodoAntecesorDisjktra()));
/*    */       
/* 73 */       nAux = nAux.getNodoAntecesorDisjktra();
/*    */     }
/*    */   }
/*    */   
/*    */   public void marcarRutaCorta(Nodo nodoFinal, Color color) {
/* 78 */     if (nodoFinal != null) {
/* 79 */       rutaCorta(nodoFinal);
               sumPesos = 0;
               cNodos = -1;
/* 80 */       for (int i = 0; i < this.aux.size(); i++) {
/* 81 */         if (!this.aux.isEmpty()) {
/* 82 */           ((Arista)this.aux.get(i)).getLineaQuebrada().setColor(color);
/* 83 */           ((Arista)this.aux.get(i)).getLineaQuebrada().setGrosorLinea(4.0F);
                   sumPesos = sumPesos + ((Arista)this.aux.get(i)).getPeso();
                   cNodos = cNodos + 1;
/*    */         }
/*    */       }
             }
/*    */   }
/*    */ }


/* Location:              E:\PERSONAL\DESCARGAS\SimpleGrafo.jar!\operaciones\Disjktra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */