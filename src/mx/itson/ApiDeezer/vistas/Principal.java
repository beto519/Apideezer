/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.ApiDeezer.vistas;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import mx.itson.ApiDeezer.entidades.*;

/**
 *
 * @author Carlos Soto Pacheco
 * @author Jesus Alberto Rivera Lopez
 * @author Raul Ernesto Molina Lizarraga
 * @author Sebastian Santana
 */
/**
 *Clase main Jframe, contiene metodos para mostrar los datos 
 */



    public class Principal extends javax.swing.JFrame {

    public static Color noSeleccionado = new Color(204, 204, 204);
    public static Color Seleccionado = new Color(0, 51, 51);

    public static ContenedorArtista artista;
    public static ContenedorAlbum album;

    /**
     * Creates new form Vista1
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        TextPrompt promt = new TextPrompt("Buscar artista...", txtBuscar);
        propiedadesTabla();
        ocultar();
    }
/**
 * Agregar propiedades a la tabla 
 */
    public void propiedadesTabla() {
        tablaAlbumes.setDefaultRenderer(Object.class, new img());
        tablaAlbumes.setRowHeight(120);
        tablaCanciones.setRowHeight(50);

    }
/**
 * ocultar labels y paneles 
 */
    public static void ocultar() {
        panelResultados.setVisible(false);
        labelMejorResultado.setVisible(false);
        labelResultado1.setVisible(false);
        labelResultado2.setVisible(false);
        labelResultado3.setVisible(false);
        labelResultado4.setVisible(false);
        labelResultado5.setVisible(false);
        labelResultado6.setVisible(false);
        labelResultado7.setVisible(false);
        labelResultado8.setVisible(false);
        labelResultado9.setVisible(false);
        resultado.setVisible(false);
        separadorResultados.setVisible(false);
        panelInformacionArtista.setVisible(false);
        panelAlbumes.setVisible(false);
        panelCanciones.setVisible(false);

    }
/**
 * 
 * @param infoArtista 
 * mostrar la informacion del artista 
 */
    public static void llenarInformacion(Artista infoArtista) {
        try {
            URL url = new URL(infoArtista.getImagenMediana().toString());

            Image image = ImageIO.read(url);
            lblImagenArtista.setIcon(new ImageIcon(image));
        } catch (Exception e) {
        }
        panelInformacionArtista.setVisible(true);
        logo.setVisible(false);

        lblNombreA.setText(infoArtista.getNombre());

        lblNumeroA.setText("Albumes: " + infoArtista.getNumeroAlbumes() + "");

        lblNumeroS.setText("Followers: " + infoArtista.getFans() + "");

        panelInformacionArtista.setVisible(true);

    }
/**
 * 
 * @param a 
 * Mostrar los 10 primeros resultados obtenidos en la busqueda 
 */
    public static void llenarResultados(ContenedorArtista a) {
        ocultar();

        artista = a;

        try {

            if (a.getResultados() != null) {

                labelMejorResultado.setText(a.getResultados().get(0).getNombre());
                labelMejorResultado.setBackground(Seleccionado);
                llenarInformacion(a.getResultados().get(0));
                ContenedorAlbum.buscarAlbumes(artista.getResultados().get(0).getNombre());
                try {
                    URL url = new URL(a.getResultados().get(0).getImagen_pequeña().toString());
                    Image image = ImageIO.read(url);
                    labelMejorResultado.setIcon(new ImageIcon(image));

                } catch (Exception e) {
                }
                resultado.setVisible(true);
                labelMejorResultado.setVisible(true);

                if (!a.getResultados().get(1).getNombre().equals("")) {
                    separadorResultados.setVisible(true);
                    labelResultado1.setText(a.getResultados().get(1).getNombre());
                    labelResultado1.setVisible(true);
                }

                if (!a.getResultados().get(2).getNombre().equals("")) {
                    labelResultado2.setText(a.getResultados().get(2).getNombre());
                    labelResultado2.setVisible(true);
                }

                if (!a.getResultados().get(3).getNombre().equals("")) {
                    labelResultado3.setText(a.getResultados().get(3).getNombre());
                    labelResultado3.setVisible(true);
                }

                if (!a.getResultados().get(4).getNombre().equals("")) {
                    labelResultado4.setText(a.getResultados().get(4).getNombre());
                    labelResultado4.setVisible(true);
                }

                if (!a.getResultados().get(5).getNombre().equals("")) {
                    labelResultado5.setText(a.getResultados().get(5).getNombre());
                    labelResultado5.setVisible(true);
                }

                if (!a.getResultados().get(6).getNombre().equals("")) {
                    labelResultado6.setText(a.getResultados().get(6).getNombre());
                    labelResultado6.setVisible(true);
                }

                if (!a.getResultados().get(7).getNombre().equals("")) {
                    labelResultado7.setText(a.getResultados().get(7).getNombre());
                    labelResultado7.setVisible(true);
                }

                if (!a.getResultados().get(8).getNombre().equals("")) {
                    labelResultado8.setText(a.getResultados().get(8).getNombre());
                    labelResultado8.setVisible(true);
                }

                if (!a.getResultados().get(9).getNombre().equals("")) {
                    labelResultado9.setText(a.getResultados().get(9).getNombre());
                    labelResultado9.setVisible(true);
                }

            }

        } catch (Exception e) {
        }

        panelResultados.setVisible(true);

    }
/**
 * 
 * @param a 
 * para llenar tabla con los albunes del artista seleccionado
 */
    public static void llenarTablaAlbumes(ContenedorAlbum a) {

        panelCanciones.setVisible(false);
        album = a;

        DefaultTableModel model = (DefaultTableModel) tablaAlbumes.getModel();
        model.setRowCount(0);
        panelAlbumes.setVisible(true);
        for (int i = 0; i < a.getListaAlbumes().size(); i++) {
            try {
                URL url = new URL(a.getListaAlbumes().get(i).getImagen().toString());

                Image image = ImageIO.read(url);

                model.addRow(new Object[]{
                    new JLabel(new ImageIcon(image))
                });

            } catch (Exception e) {
            }

        }

    }
/**
 * 
 * @param a
 * @param nombreAlbum 
 * llenar tabla de canciones 
 */
    public static void llenarTablaCanciones(ContenedorCanciones a, String nombreAlbum) {
        DefaultTableModel model = (DefaultTableModel) tablaCanciones.getModel();

        model.setRowCount(0);
        lblNombreAlbum.setText(nombreAlbum);

        panelCanciones.setVisible(true);
        DefaultTableModel modelA = (DefaultTableModel) tablaCanciones.getModel();
        modelA.setRowCount(0);
        for (int i = 0; i < a.getCanciones().size(); i++) {

            model.addRow(new Object[]{
                a.getCanciones().get(i).getTitulo()
            });

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

        jPanel2 = new javax.swing.JPanel();
        panelLateral = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panelResultados = new javax.swing.JPanel();
        labelResultado1 = new javax.swing.JLabel();
        labelResultado2 = new javax.swing.JLabel();
        labelResultado3 = new javax.swing.JLabel();
        labelResultado4 = new javax.swing.JLabel();
        labelResultado5 = new javax.swing.JLabel();
        labelResultado6 = new javax.swing.JLabel();
        labelResultado7 = new javax.swing.JLabel();
        labelResultado8 = new javax.swing.JLabel();
        labelResultado9 = new javax.swing.JLabel();
        resultado = new javax.swing.JLabel();
        labelMejorResultado = new javax.swing.JLabel();
        separadorResultados = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        panelInformacionArtista = new javax.swing.JPanel();
        lblImagenArtista = new javax.swing.JLabel();
        lblNombreA = new javax.swing.JLabel();
        lblNumeroS = new javax.swing.JLabel();
        lblNumeroA = new javax.swing.JLabel();
        panelAlbumes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlbumes = new javax.swing.JTable();
        panelCanciones = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCanciones = new javax.swing.JTable();
        lblNombreAlbum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        panelLateral.setBackground(new java.awt.Color(0, 102, 102));
        panelLateral.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelLateralMouseDragged(evt);
            }
        });
        panelLateral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelLateralMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelLateralMouseReleased(evt);
            }
        });
        panelLateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/ApiDeezer/imagen/icons8_search_35px.png"))); // NOI18N
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        panelLateral.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 6, -1, -1));

        txtBuscar.setBackground(new java.awt.Color(0, 102, 102));
        txtBuscar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setBorder(null);
        panelLateral.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 218, 30));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        panelLateral.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 220, 10));

        panelResultados.setBackground(new java.awt.Color(0, 102, 102));
        panelResultados.setLayout(new java.awt.GridLayout(9, 0));

        labelResultado1.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado1.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado1.setText("Resultado!");
        labelResultado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado1.setOpaque(true);
        labelResultado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado1MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado1);

        labelResultado2.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado2.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado2.setText("Resultado!");
        labelResultado2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado2.setOpaque(true);
        labelResultado2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado2MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado2);

        labelResultado3.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado3.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado3.setText("Resultado!");
        labelResultado3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado3.setOpaque(true);
        labelResultado3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado3MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado3);

        labelResultado4.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado4.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado4.setText("Resultado!");
        labelResultado4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado4.setOpaque(true);
        labelResultado4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado4MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado4);

        labelResultado5.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado5.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado5.setText("Resultado!");
        labelResultado5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado5.setOpaque(true);
        labelResultado5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado5MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado5);

        labelResultado6.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado6.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado6.setText("Resultado!");
        labelResultado6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado6.setOpaque(true);
        labelResultado6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado6MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado6);

        labelResultado7.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado7.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado7.setText("Resultado!");
        labelResultado7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado7.setOpaque(true);
        labelResultado7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado7MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado7);

        labelResultado8.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado8.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado8.setText("Resultado!");
        labelResultado8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado8.setOpaque(true);
        labelResultado8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado8MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado8);

        labelResultado9.setBackground(new java.awt.Color(204, 204, 204));
        labelResultado9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelResultado9.setForeground(new java.awt.Color(255, 255, 255));
        labelResultado9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResultado9.setText("Resultado!");
        labelResultado9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelResultado9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelResultado9.setOpaque(true);
        labelResultado9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado9MouseClicked(evt);
            }
        });
        panelResultados.add(labelResultado9);

        panelLateral.add(panelResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 270, 410));

        resultado.setBackground(new java.awt.Color(0, 102, 102));
        resultado.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        resultado.setForeground(new java.awt.Color(255, 255, 255));
        resultado.setText("Mejor Resultado....");
        resultado.setOpaque(true);
        panelLateral.add(resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 270, 41));

        labelMejorResultado.setBackground(new java.awt.Color(0, 51, 51));
        labelMejorResultado.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        labelMejorResultado.setForeground(new java.awt.Color(255, 255, 255));
        labelMejorResultado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelMejorResultado.setText("Resultado!");
        labelMejorResultado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        labelMejorResultado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMejorResultado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        labelMejorResultado.setOpaque(true);
        labelMejorResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMejorResultadoMouseClicked(evt);
            }
        });
        panelLateral.add(labelMejorResultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 270, 70));

        separadorResultados.setForeground(new java.awt.Color(255, 255, 255));
        panelLateral.add(separadorResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 270, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/ApiDeezer/imagen/icons8_close_window_26px_2.png"))); // NOI18N
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/ApiDeezer/imagen/fondo_1.jpeg"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, -1, -1));

        panelInformacionArtista.setBackground(new java.awt.Color(0, 0, 0));

        lblImagenArtista.setBackground(new java.awt.Color(0, 0, 0));
        lblImagenArtista.setForeground(new java.awt.Color(255, 255, 255));
        lblImagenArtista.setText("Imagen");

        lblNombreA.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblNombreA.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreA.setText("xxxxxxxxxxxxxx");

        lblNumeroS.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNumeroS.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNumeroS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/ApiDeezer/imagen/icons8_heart_outline_48px.png"))); // NOI18N
        lblNumeroS.setText("xxxxxxxxxxxxxx");
        lblNumeroS.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblNumeroA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNumeroA.setForeground(new java.awt.Color(255, 255, 255));
        lblNumeroA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mx/itson/ApiDeezer/imagen/icons8_music_record_30px_1.png"))); // NOI18N
        lblNumeroA.setText("xxxxxxxxxxxxxx");
        lblNumeroA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout panelInformacionArtistaLayout = new javax.swing.GroupLayout(panelInformacionArtista);
        panelInformacionArtista.setLayout(panelInformacionArtistaLayout);
        panelInformacionArtistaLayout.setHorizontalGroup(
            panelInformacionArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionArtistaLayout.createSequentialGroup()
                .addComponent(lblImagenArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelInformacionArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblNumeroS, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                        .addComponent(lblNumeroA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInformacionArtistaLayout.setVerticalGroup(
            panelInformacionArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionArtistaLayout.createSequentialGroup()
                .addComponent(lblImagenArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(panelInformacionArtistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreA)
                .addGap(36, 36, 36)
                .addComponent(lblNumeroS)
                .addGap(33, 33, 33)
                .addComponent(lblNumeroA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelInformacionArtista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 720, 260));

        panelAlbumes.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Albumes");

        tablaAlbumes.setBackground(new java.awt.Color(0, 102, 102));
        tablaAlbumes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaAlbumes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaAlbumes.setTableHeader(null);
        tablaAlbumes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlbumesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaAlbumes);
        if (tablaAlbumes.getColumnModel().getColumnCount() > 0) {
            tablaAlbumes.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout panelAlbumesLayout = new javax.swing.GroupLayout(panelAlbumes);
        panelAlbumes.setLayout(panelAlbumesLayout);
        panelAlbumesLayout.setHorizontalGroup(
            panelAlbumesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlbumesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelAlbumesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelAlbumesLayout.setVerticalGroup(
            panelAlbumesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAlbumesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelAlbumes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 280, 290));

        panelCanciones.setBackground(new java.awt.Color(0, 0, 0));

        tablaCanciones.setBackground(new java.awt.Color(0, 0, 0));
        tablaCanciones.setForeground(new java.awt.Color(255, 255, 255));
        tablaCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCanciones.setTableHeader(null);
        jScrollPane1.setViewportView(tablaCanciones);

        lblNombreAlbum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreAlbum.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreAlbum.setText("Titulo");

        javax.swing.GroupLayout panelCancionesLayout = new javax.swing.GroupLayout(panelCanciones);
        panelCanciones.setLayout(panelCancionesLayout);
        panelCancionesLayout.setHorizontalGroup(
            panelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCancionesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCancionesLayout.createSequentialGroup()
                .addGap(0, 173, Short.MAX_VALUE)
                .addComponent(lblNombreAlbum)
                .addGap(168, 168, 168))
        );
        panelCancionesLayout.setVerticalGroup(
            panelCancionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCancionesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblNombreAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel1.add(panelCanciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 380, 280));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   int xx, xy;
   
   /**
    * 
    * @param evt 
    * Movimiento ventana
    */
    private void panelLateralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLateralMousePressed
        setOpacity((float) 0.8);
        xx = evt.getX();
        xy = evt.getY();

    }//GEN-LAST:event_panelLateralMousePressed

    /**
     * 
     * @param evt 
     * Movimiento ventana
     */
    private void panelLateralMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLateralMouseReleased
        setOpacity((float) 1.0);
    }//GEN-LAST:event_panelLateralMouseReleased
/**
 * 
 * @param evt 
 * Movimiento ventana
 */
    private void panelLateralMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLateralMouseDragged
        int x, y;
        x = evt.getXOnScreen();
        y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }//GEN-LAST:event_panelLateralMouseDragged
/**
 * 
 * @param evt 
 * Cerrar ventana
 */
    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked
/**
 * 
 * @param evt 
 * Cambiar Background a resultado seleccionado
 * 
 */
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        ContenedorArtista.buscarArtista(txtBuscar.getText());
       
        /**
         * Los botones regresan al color "no seleccionado"
         */
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);


    }//GEN-LAST:event_btnBuscarMouseClicked
/**
 * 
 * @param evt 
 * cambio de Background label mejorResultado 
 */
    private void labelMejorResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMejorResultadoMouseClicked
        labelMejorResultado.setBackground(Seleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(noSeleccionado);

        llenarInformacion(artista.getResultados().get(0));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(0).getNombre());

    }//GEN-LAST:event_labelMejorResultadoMouseClicked
/**
 * 
 * @param evt 
 * cambio de Background resultado 1
 */
    private void labelResultado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado1MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(Seleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(noSeleccionado);
        llenarInformacion(artista.getResultados().get(1));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(1).getNombre());
    }//GEN-LAST:event_labelResultado1MouseClicked
/**
 * 
 * @param evt 
 * cambio de Background resultado 2
 */
    private void labelResultado2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado2MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(Seleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(noSeleccionado);
        llenarInformacion(artista.getResultados().get(2));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(2).getNombre());
    }//GEN-LAST:event_labelResultado2MouseClicked
/**
 * 
 * @param evt 
 * cambio de Background resultado 3
 */
    private void labelResultado3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado3MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(Seleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(noSeleccionado);
        llenarInformacion(artista.getResultados().get(3));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(3).getNombre());
    }//GEN-LAST:event_labelResultado3MouseClicked
/**
 * 
 * @param evt 
 * cambio de Background resultado 4
 */
    private void labelResultado4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado4MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(Seleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(noSeleccionado);
        llenarInformacion(artista.getResultados().get(4));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(4).getNombre());
    }//GEN-LAST:event_labelResultado4MouseClicked
/**
 * 
 * @param evt 
 * cambio de Background resultado 5
 */
    private void labelResultado5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado5MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(Seleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(noSeleccionado);
        llenarInformacion(artista.getResultados().get(5));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(5).getNombre());
    }//GEN-LAST:event_labelResultado5MouseClicked
/**
 * 
 * @param evt
 * cambio de Background resultado 6
 */
    private void labelResultado6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado6MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(Seleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(noSeleccionado);
        llenarInformacion(artista.getResultados().get(6));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(6).getNombre());
    }//GEN-LAST:event_labelResultado6MouseClicked
/**
 * 
 * @param evt 
 * cambio de Background resultado 7
 */
    private void labelResultado7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado7MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(Seleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(noSeleccionado);
        llenarInformacion(artista.getResultados().get(7));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(7).getNombre());
    }//GEN-LAST:event_labelResultado7MouseClicked
/**
 * 
 * @param evt
 * cambio de Background resultado 8
 */
    private void labelResultado8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado8MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(Seleccionado);
        labelResultado9.setBackground(noSeleccionado);
        llenarInformacion(artista.getResultados().get(8));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(8).getNombre());
    }//GEN-LAST:event_labelResultado8MouseClicked
/**
 * 
 * @param evt
 * cambio de Background resultado 9
 */
    private void labelResultado9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelResultado9MouseClicked
        labelMejorResultado.setBackground(noSeleccionado);
        labelResultado1.setBackground(noSeleccionado);
        labelResultado2.setBackground(noSeleccionado);
        labelResultado3.setBackground(noSeleccionado);
        labelResultado4.setBackground(noSeleccionado);
        labelResultado5.setBackground(noSeleccionado);
        labelResultado6.setBackground(noSeleccionado);
        labelResultado7.setBackground(noSeleccionado);
        labelResultado8.setBackground(noSeleccionado);
        labelResultado9.setBackground(Seleccionado);
        llenarInformacion(artista.getResultados().get(9));
        ContenedorAlbum.buscarAlbumes(artista.getResultados().get(9).getNombre());
    }//GEN-LAST:event_labelResultado9MouseClicked
/**
 * 
 * @param evt 
 * Mostrar canciones pertenecientes al album seleccionado en tablaCanciones
 */
    private void tablaAlbumesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlbumesMouseClicked
        int i = tablaAlbumes.getSelectedRow();

        try {
            ContenedorCanciones canciones = ContenedorCanciones.buscarCanciones(album.getListaAlbumes().get(i).getId());
            llenarTablaCanciones(canciones, album.getListaAlbumes().get(i).getTitulo());

        } catch (Exception e) {
        }


    }//GEN-LAST:event_tablaAlbumesMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel labelMejorResultado;
    public static javax.swing.JLabel labelResultado1;
    public static javax.swing.JLabel labelResultado2;
    public static javax.swing.JLabel labelResultado3;
    public static javax.swing.JLabel labelResultado4;
    public static javax.swing.JLabel labelResultado5;
    public static javax.swing.JLabel labelResultado6;
    public static javax.swing.JLabel labelResultado7;
    public static javax.swing.JLabel labelResultado8;
    public static javax.swing.JLabel labelResultado9;
    public static javax.swing.JLabel lblImagenArtista;
    public static javax.swing.JLabel lblNombreA;
    public static javax.swing.JLabel lblNombreAlbum;
    public static javax.swing.JLabel lblNumeroA;
    public static javax.swing.JLabel lblNumeroS;
    public static javax.swing.JLabel logo;
    public static javax.swing.JPanel panelAlbumes;
    public static javax.swing.JPanel panelCanciones;
    public static javax.swing.JPanel panelInformacionArtista;
    private javax.swing.JPanel panelLateral;
    public static javax.swing.JPanel panelResultados;
    public static javax.swing.JLabel resultado;
    public static javax.swing.JSeparator separadorResultados;
    public static javax.swing.JTable tablaAlbumes;
    public static javax.swing.JTable tablaCanciones;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
