package ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import objetos.Arista;
import objetos.Coordenadas;
import objetos.Grafo;
import objetos.Nodo;
import objetos.Nombres;
import operaciones.Disjktra;

public class UI1 extends javax.swing.JFrame {

    Grafo grafo = new Grafo();
    Nodo nodoInicio = null;
    Nodo nodoFin = null;
    Nombres nombres = new Nombres();
    String item;
    Tienda t = new Tienda();
    public UI1() {
        initComponents();
        setBVisible(false);
        
    }
    
    public void setBVisible(boolean x){
        jButton2.setVisible(!x);
        jLabel3.setVisible(x);
        jComboBox2.setVisible(false);
    }

    /*  92 */ public void dibujarGrafo() {
        this.jPanel1.paint(this.jPanel1.getGraphics());
        /*  93 */ dibujarArista();
        /*  94 */ dibujarNodos();
        /*     */    }

    /*     */
 /*  97 */ public void dibujarNodos() {
        java.util.ArrayList<Nodo> listaNodo = this.grafo.getListaNodos();
        /*  98 */ for (Nodo nodo : listaNodo) /*  99 */ {
            nodo.getCirculo().dibujarCirculo(this.jPanel1.getGraphics());
        }
        /*     */    }

    /*     */
 /*     */ public void dibujarArista() {
        /* 103 */ java.util.ArrayList<Nodo> listaNodo = this.grafo.getListaNodos();
        /* 104 */ for (Nodo nodo : listaNodo) {
            /* 105 */ java.util.ArrayList<objetos.Enlace> listaEnlace = nodo.getListaNodoAdyacente();
            /* 106 */ if (listaEnlace != null) {
                /* 107 */ for (objetos.Enlace enlace : listaEnlace) /* 108 */ {
                    enlace.getArista().getLineaQuebrada().dibujarLineaQuebrada(this.jPanel1.getGraphics());
                }
                /*     */            }
            /*     */        }
        /*     */    }

    /*     */
 /*     */ private int ingresarPeso() {
        /* 114 */ String peso = javax.swing.JOptionPane.showInputDialog("Digite el peso.");
        /* 115 */ int intPeso = 0;
        /*     */ try {
            /* 117 */ intPeso = Integer.parseInt(peso);
            /*     */        } catch (Exception ex) {
            /* 119 */ intPeso = ingresarPeso();
            /*     */        }
        /* 121 */ return intPeso;
        /*     */    }

    /*     */
 /*     */ private void eliminarNodo(int x, int y) {
        /* 125 */ if (this.grafo.buscarNodo(x, y) != null) {
            /* 126 */ Nodo temp = this.grafo.buscarNodo(x, y);
            /* 127 */ this.grafo.eliminarAristasEntrante(temp);
            /* 128 */ if (this.grafo.eliminarNodo(temp)) {
                /* 129 */ javax.swing.JOptionPane.showMessageDialog(null, "Eliminado");
                /* 130 */ dibujarGrafo();
                /*     */            }
            /*     */        }
        /*     */    }

    /*     */
 /*     */
    public void crearArista() /*     */ {
        int intPeso = ingresarPeso();
        Arista arista = new Arista();
        arista.setPeso(intPeso);
        Coordenadas c = new Coordenadas(100000, 100000);
        c.addCoordenada(this.nodoInicio.getCirculo().getX() + this.nodoInicio.getCirculo().getDiametro() / 2, this.nodoInicio.getCirculo().getY() + this.nodoInicio.getCirculo().getDiametro() / 2);
        c.addCoordenada(this.nodoFin.getCirculo().getX() + this.nodoInicio.getCirculo().getDiametro() / 2, this.nodoFin.getCirculo().getY() + this.nodoInicio.getCirculo().getDiametro() / 2);
        objetos.LineaQuebrada lq = new objetos.LineaQuebrada(c);
        arista.setLineaQuebrada(lq);
        this.grafo.crearEnlacesNoDirigido(this.nodoInicio, this.nodoFin, arista);
    }

    public void crearArista(Nodo x, Nodo y, int peso) {
        Arista arista = new Arista();
        arista.setPeso(peso);
        Coordenadas c = new Coordenadas(100000, 100000);
        c.addCoordenada(x.getCirculo().getX() + x.getCirculo().getDiametro() / 2, x.getCirculo().getY() + x.getCirculo().getDiametro() / 2);
        c.addCoordenada(y.getCirculo().getX() + y.getCirculo().getDiametro() / 2, y.getCirculo().getY() + y.getCirculo().getDiametro() / 2);
        objetos.LineaQuebrada lq = new objetos.LineaQuebrada(c);
        arista.setLineaQuebrada(lq);
        this.grafo.crearEnlacesNoDirigido(x, y, arista);
    }

    public void crearNodo(int x, int y) /*     */ {
        Coordenadas c = new Coordenadas(100000, 100000, x, y);
        String dato = javax.swing.JOptionPane.showInputDialog("Digite un dato");
        if (dato != null) {
            dato = dato.toUpperCase();
            Nodo nodo = new Nodo(dato, c);
            nodo.getCirculo().setDiametro(12);
            nodo.getCirculo().setEtiqueta(nodo.getDato() + "");
            if (this.grafo.adjuntarNodo(nodo)) {
                nodo.getCirculo().dibujarCirculo(this.jPanel1.getGraphics());
            }

            this.nodoInicio = null;
            this.nodoFin = null;
        }
    }

    public void crearNodo(int x, int y, String dato) {
        nombres.setNombre(dato.toUpperCase());
        Coordenadas c = new Coordenadas(100000, 100000, x, y);
        if (dato != null) {
            dato = dato.toUpperCase();
            Nodo nodo = new Nodo(dato, c);
            nodo.getCirculo().setDiametro(12);
            nodo.getCirculo().setEtiqueta(nodo.getDato() + "");
            if (this.grafo.adjuntarNodo(nodo)) {
                nodo.getCirculo().dibujarCirculo(this.jPanel1.getGraphics());
            }

            this.nodoInicio = null;
            this.nodoFin = null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventana/Mapa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 40, 576, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 680, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ruta de tu paquete");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 11, 625, -1));

        jButton2.setText("Buscar camino");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 680, 179, 34));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BODEGA DRONES" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 690, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        int x = evt.getX();
        int y = evt.getY();
        if (evt.isMetaDown()) {

            if (this.grafo.buscarNodo(x, y) != null) {
                if (this.nodoInicio == null) {
                    this.grafo.reiniciarGrafoParaDisjktra();
                    this.grafo.reiniciarColores();
                    this.nodoInicio = this.grafo.buscarNodo(x, y);
                    this.nodoInicio.getCirculo().setColor(java.awt.Color.red);
                } else {
                    this.nodoFin = this.grafo.buscarNodo(x, y);
                    operaciones.Disjktra disjktra = new operaciones.Disjktra(this.grafo);
                    disjktra.ejecutar(this.nodoInicio);
                    disjktra.marcarRutaCorta(this.nodoFin, java.awt.Color.red);

                    this.nodoInicio = null;
                    this.nodoFin = null;
                }

            }

        } else if (this.grafo.buscarNodo(x, y) != null) {
            if (this.nodoInicio == null) {
                this.nodoInicio = this.grafo.buscarNodo(x, y);
                this.nodoInicio.getCirculo().setColor(java.awt.Color.red);
            } else {
                this.nodoFin = this.grafo.buscarNodo(x, y);
                crearArista();

                this.nodoInicio.getCirculo().setColor(java.awt.Color.yellow);

                this.nodoInicio = null;
                this.nodoFin = null;
            }
        } else {
            crearNodo(x, y);
        }
        dibujarGrafo();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ArrayList<Nodo> m = new ArrayList<Nodo>();
        crearNodo(80, 100, "Bodega Drones"); //0
        crearNodo(60,360, "Cliente 1"); // 1
        crearNodo(150, 550, "Droguería Alemana"); // 2
        crearNodo(339, 378, "Droguería la universidad"); // 3 
        crearNodo(405, 238, "Drogas la rebaja");  // 4
        crearNodo(300, 120, "Droguería el bosque");  // 5
        crearNodo(339,450,"Cliente 2"); // 6
        crearNodo(200,580,"Cliente 3"); // 7
        crearNodo(300,80,"Cliente 4"); // 8
        crearNodo(470,300,"Cliente 5"); // 9
        //---------------------------------------------
        m = grafo.getListaNodos();
            crearArista(m.get(0), m.get(2), 700);
            crearArista(m.get(0), m.get(3), 500);
            crearArista(m.get(0), m.get(4), 300);
            crearArista(m.get(0), m.get(5), 200);
            crearArista(m.get(2), m.get(3), 320);
            crearArista(m.get(2), m.get(4), 450);
            crearArista(m.get(2), m.get(5), 700);
            crearArista(m.get(3), m.get(4), 250);
            crearArista(m.get(3), m.get(5), 350);
            crearArista(m.get(4), m.get(5), 250);
            crearArista(m.get(1), m.get(2), 250);
            crearArista(m.get(1), m.get(3), 300);
            crearArista(m.get(1), m.get(4), 400);
            crearArista(m.get(1), m.get(5), 380);
            crearArista(m.get(2),m.get(6),260);
            crearArista(m.get(3),m.get(6),50);
            crearArista(m.get(4),m.get(6),300 );
            crearArista(m.get(5),m.get(6),450);
            crearArista(m.get(2),m.get(7),40);
            crearArista(m.get(3),m.get(7),370);
            crearArista(m.get(4),m.get(7),500);
            crearArista(m.get(5),m.get(7),700);
            crearArista(m.get(2),m.get(8),800);
            crearArista(m.get(3),m.get(8),400);
            crearArista(m.get(4),m.get(8),300);
            crearArista(m.get(5),m.get(8),30);
            crearArista(m.get(2),m.get(9),420);
            crearArista(m.get(3),m.get(9),250);
            crearArista(m.get(4),m.get(9),100);
            crearArista(m.get(5),m.get(9),300);

        ArrayList<String> y = new ArrayList<String>();
        y = nombres.getNombres();
        int size = m.size();
 for (int i = 0; i <= size-1; i++) {
            t.jComboBox2.addItem(y.get(i));
            jComboBox2.addItem(y.get(i));
 }
        setBVisible(true); 
        dibujarGrafo();
       
        operaciones.Disjktra disjktra = new operaciones.Disjktra(grafo);
        this.grafo.reiniciarGrafoParaDisjktra();
        this.grafo.reiniciarColores();
        this.nodoInicio = this.grafo.buscarNodo(jComboBox2.getSelectedItem().toString());
        this.nodoFin = this.grafo.buscarNodo(t.cliente);
        this.nodoInicio.getCirculo().setColor(java.awt.Color.red);
        this.nodoFin.getCirculo().setColor(java.awt.Color.red);
        disjktra.ejecutar(nodoInicio);
        disjktra.marcarRutaCorta(nodoFin, Color.green);
        dibujarGrafo();
        int i = disjktra.getPesos();
        int x = disjktra.getCNodos();
        int c = i*7;
        int d = 1;
        if (i <= 400)
        {
            d = 1;
        }
        else { if (i > 400) { d=2; } else { if (i > 600) d=3; } }
        JOptionPane.showMessageDialog(null, "El precio del envio es de " + c + " pesos y el dron " + d + " sera el encargado de realizarlo");
     JOptionPane.showMessageDialog(null, "La distancia que recorrerá el dron es: " + i + "m.");
        this.nodoInicio = null;
        this.nodoFin = null; 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
     
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
         * @param args the command line arguments
         */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
