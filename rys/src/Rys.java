
import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Stack;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */




public class Rys extends javax.swing.JFrame {
int[] yiyecek = {250,300,500,350};
int[] icecek = {75,50,75,60};
double kdv = 0, servis = 0,yiyecektotal = 0,icecektotal =0;
double aratoplam = 0, geneltoplam =0;



private void updateServisUcreti() {
    if (cb_servis.isSelected()) {
        servis = (yiyecektotal + icecektotal) * 0.10;
        lbl_servis.setText(String.format("%.2f TL", servis));
    }
}

private void yiyecek_hesap(javax.swing.JCheckBox cb, javax.swing.JTextField txt, int fiyat_index) {
    if (cb.isSelected()) {
        if (txt.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Değer giriniz");
            cb.setSelected(false);
            return;
        }

        int yiyecek_adet;
        try {
            yiyecek_adet = Integer.parseInt(txt.getText().trim());
            if (yiyecek_adet <= 0) {
                JOptionPane.showMessageDialog(null, "Lütfen 0'dan büyük bir sayı giriniz");
                cb.setSelected(false);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lütfen sayısal bir değer giriniz");
            cb.setSelected(false);
            return;
        }

        yiyecektotal += yiyecek_adet * yiyecek[fiyat_index];
        txt.setEnabled(false);
        txt.putClientProperty("lastValue", yiyecek_adet);

    } else {
        Object val = txt.getClientProperty("lastValue");
        if (val instanceof Integer) {
            int onceki_adet = (Integer) val;
            yiyecektotal -= onceki_adet * yiyecek[fiyat_index]; 
        }
        txt.setEnabled(true);
        txt.putClientProperty("lastValue", null); 
    }

    lbl_yiyecek.setText(String.format("%.2f TL", yiyecektotal));

    
    if (cb_servis.isSelected()) {
        updateServisUcreti();
    }
}


private void icecek_hesap(javax.swing.JCheckBox cb, javax.swing.JTextField txt, int fiyat_index) {
    if (cb.isSelected()) {
        if (txt.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Değer giriniz");
            cb.setSelected(false);
            txt.requestFocus();
            return;
        }

        int icecek_adet;
        try {
            icecek_adet = Integer.parseInt(txt.getText().trim());
            if (icecek_adet <= 0) {
                JOptionPane.showMessageDialog(null, "Lütfen 0'dan büyük bir sayı giriniz");
                cb.setSelected(false);
                txt.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Geçerli bir sayı giriniz.");
            cb.setSelected(false);
            txt.requestFocus();
            return;
        }

        icecektotal += icecek_adet * icecek[fiyat_index];
        txt.setEnabled(false);
        txt.putClientProperty("lastValue", icecek_adet); 

    } else {
        
        Object val = txt.getClientProperty("lastValue");
        if (val instanceof Integer) {
            int onceki_adet = (Integer) val;
            icecektotal -= onceki_adet * icecek[fiyat_index];
        }
        txt.setEnabled(true);
        txt.putClientProperty("lastValue", null); 
    }

    lbl_icecek.setText(String.format("%.2f TL", icecektotal));
    
}


private void toplam_guncelle(javax.swing.JLabel lbl_servis) {
    double toplam = yiyecektotal + icecektotal;
    lbl_servis.setText( toplam + " TL");
}


    public Rys() {
        initComponents();
    }
    public class Eval {
    public static double evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        Stack<Double> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
           
            if (tokens[i] == ' ')
                continue;

            
            if (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.') {
                StringBuilder sbuf = new StringBuilder();
                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.'))
                    sbuf.append(tokens[i++]);
                i--;
                values.push(Double.parseDouble(sbuf.toString()));
            }

            
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }

        
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    
    public static boolean hasPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

   
    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("0'a bölünemez");
                return a / b;
        }
        return 0;
    }
}

 
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cb_salgam = new javax.swing.JCheckBox();
        cb_soda = new javax.swing.JCheckBox();
        cb_ayran = new javax.swing.JCheckBox();
        cb_kola = new javax.swing.JCheckBox();
        txt_kola = new javax.swing.JTextField();
        txt_ayran = new javax.swing.JTextField();
        txt_soda = new javax.swing.JTextField();
        txt_salgam = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lbl_yiyecek = new javax.swing.JLabel();
        lbl_servis = new javax.swing.JLabel();
        lbl_icecek = new javax.swing.JLabel();
        cb_servis = new javax.swing.JCheckBox();
        cb_kdv = new javax.swing.JCheckBox();
        lblicecek = new javax.swing.JLabel();
        lblyiyecek = new javax.swing.JLabel();
        lblservis = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_kdv = new javax.swing.JLabel();
        lbl_toplam = new javax.swing.JLabel();
        lbl_aratoplam = new javax.swing.JLabel();
        lblaratoplam = new javax.swing.JLabel();
        lblkdv = new javax.swing.JLabel();
        lbltoplam = new javax.swing.JLabel();
        pnl1 = new javax.swing.JPanel();
        cb_tavuk = new javax.swing.JCheckBox();
        cb_et = new javax.swing.JCheckBox();
        cb_iskender = new javax.swing.JCheckBox();
        cb_burdur = new javax.swing.JCheckBox();
        txt_tavuk = new javax.swing.JTextField();
        txt_et = new javax.swing.JTextField();
        txt_iskender = new javax.swing.JTextField();
        txt_burdur = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btn_toplam = new javax.swing.JButton();
        btn_fatura = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_kapat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btn_7 = new javax.swing.JButton();
        btn_8 = new javax.swing.JButton();
        btn_9 = new javax.swing.JButton();
        btn_eksi = new javax.swing.JButton();
        btn_4 = new javax.swing.JButton();
        btn_5 = new javax.swing.JButton();
        btn_6 = new javax.swing.JButton();
        btn_artı = new javax.swing.JButton();
        btn_1 = new javax.swing.JButton();
        btn_2 = new javax.swing.JButton();
        btn_3 = new javax.swing.JButton();
        btn_bolme = new javax.swing.JButton();
        btn_0 = new javax.swing.JButton();
        btn_temizleme = new javax.swing.JButton();
        btn_sonuc = new javax.swing.JButton();
        btn_carpma = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        txt_ekran = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtarea_fatura = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        cb_salgam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_salgam.setText("Şalgam");
        cb_salgam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_salgamActionPerformed(evt);
            }
        });

        cb_soda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_soda.setText("Soda");
        cb_soda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sodaActionPerformed(evt);
            }
        });

        cb_ayran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_ayran.setText("Ayran");
        cb_ayran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ayranActionPerformed(evt);
            }
        });

        cb_kola.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_kola.setText("Kola");
        cb_kola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kolaActionPerformed(evt);
            }
        });

        txt_kola.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_kola.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_kola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kolaActionPerformed(evt);
            }
        });

        txt_ayran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_ayran.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_soda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_soda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_salgam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_salgam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cb_salgam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(txt_salgam, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_kola)
                            .addComponent(cb_ayran)
                            .addComponent(cb_soda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_soda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_ayran, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_kola, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_kola)
                    .addComponent(txt_kola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ayran)
                    .addComponent(txt_ayran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_soda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_soda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_salgam)
                    .addComponent(txt_salgam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbl_yiyecek.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lbl_servis.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lbl_icecek.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        cb_servis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_servis.setText("Servis bedeli");
        cb_servis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_servisActionPerformed(evt);
            }
        });

        cb_kdv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_kdv.setText("KDV");
        cb_kdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kdvActionPerformed(evt);
            }
        });

        lblicecek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblicecek.setText("içecek");

        lblyiyecek.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblyiyecek.setText("Yiyecek");

        lblservis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblservis.setText("Servis");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cb_servis, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_kdv))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblservis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblicecek, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblyiyecek, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_icecek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_yiyecek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_servis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_icecek, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(lblicecek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_yiyecek, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(lblyiyecek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblservis, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(lbl_servis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_servis)
                    .addComponent(cb_kdv))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        lbl_kdv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lbl_toplam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lbl_aratoplam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblaratoplam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblaratoplam.setText("Ara Toplam");

        lblkdv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblkdv.setText("KDV");

        lbltoplam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbltoplam.setText("Toplam");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbltoplam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblaratoplam, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblkdv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_aratoplam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_kdv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_toplam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblaratoplam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(lblkdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(lbltoplam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_aratoplam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbl_kdv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbl_toplam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        cb_tavuk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_tavuk.setText("Tavuk Döner");
        cb_tavuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tavukActionPerformed(evt);
            }
        });

        cb_et.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_et.setText("Et Döner");
        cb_et.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_etActionPerformed(evt);
            }
        });

        cb_iskender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_iskender.setText("İskender");
        cb_iskender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_iskenderActionPerformed(evt);
            }
        });

        cb_burdur.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_burdur.setText("Burdur Şiş");
        cb_burdur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_burdurActionPerformed(evt);
            }
        });

        txt_tavuk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_tavuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_tavuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tavukActionPerformed(evt);
            }
        });

        txt_et.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_et.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_iskender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_iskender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_burdur.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_burdur.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addComponent(cb_burdur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_burdur, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_tavuk)
                    .addComponent(cb_et)
                    .addComponent(cb_iskender))
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_iskender, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_et, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tavuk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_tavuk)
                    .addComponent(txt_tavuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_et)
                    .addComponent(txt_et, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_iskender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_iskender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_burdur)
                    .addComponent(txt_burdur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        btn_toplam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_toplam.setText("Toplam");
        btn_toplam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_toplamActionPerformed(evt);
            }
        });

        btn_fatura.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_fatura.setText("Fatura");
        btn_fatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_faturaActionPerformed(evt);
            }
        });

        btn_reset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_kapat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_kapat.setText("Kapat");
        btn_kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kapatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btn_toplam)
                .addGap(40, 40, 40)
                .addComponent(btn_fatura)
                .addGap(40, 40, 40)
                .addComponent(btn_reset)
                .addGap(40, 40, 40)
                .addComponent(btn_kapat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_toplam)
                    .addComponent(btn_fatura)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_reset)
                        .addComponent(btn_kapat)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel5.setLayout(new java.awt.GridLayout(4, 4, 5, 5));

        btn_7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_7.setText("7");
        btn_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_7ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_7);

        btn_8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_8.setText("8");
        btn_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_8ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_8);

        btn_9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_9.setText("9");
        btn_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_9ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_9);

        btn_eksi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_eksi.setText("-");
        btn_eksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eksiActionPerformed(evt);
            }
        });
        jPanel5.add(btn_eksi);

        btn_4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_4.setText("4");
        btn_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_4ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_4);

        btn_5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_5.setText("5");
        btn_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_5ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_5);

        btn_6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_6.setText("6");
        btn_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_6ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_6);

        btn_artı.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_artı.setText("+");
        btn_artı.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_artıActionPerformed(evt);
            }
        });
        jPanel5.add(btn_artı);

        btn_1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_1.setText("1");
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_1);

        btn_2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_2.setText("2");
        btn_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_2ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_2);

        btn_3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_3.setText("3");
        btn_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_3ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_3);

        btn_bolme.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_bolme.setText("÷");
        btn_bolme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bolmeActionPerformed(evt);
            }
        });
        jPanel5.add(btn_bolme);

        btn_0.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_0.setText("0");
        btn_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_0ActionPerformed(evt);
            }
        });
        jPanel5.add(btn_0);

        btn_temizleme.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_temizleme.setText("C");
        btn_temizleme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_temizlemeActionPerformed(evt);
            }
        });
        jPanel5.add(btn_temizleme);

        btn_sonuc.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_sonuc.setText("=");
        btn_sonuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sonucActionPerformed(evt);
            }
        });
        jPanel5.add(btn_sonuc);

        btn_carpma.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_carpma.setText("×");
        btn_carpma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_carpmaActionPerformed(evt);
            }
        });
        jPanel5.add(btn_carpma);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        txt_ekran.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_ekran.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_ekran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ekranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_ekran)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txt_ekran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Hesap makinesi", jPanel8);

        txtarea_fatura.setEditable(false);
        txtarea_fatura.setColumns(20);
        txtarea_fatura.setRows(5);
        jScrollPane2.setViewportView(txtarea_fatura);

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Fatura", jPanel9);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Restaurant Yönetim Sistemi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_servisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_servisActionPerformed
            if (cb_servis.isSelected()) {
            updateServisUcreti(); 
        } else {
            servis = 0;
            lbl_servis.setText("0.00 TL");

            kdv = 0;
            cb_kdv.setSelected(false);
            lbl_kdv.setText("0.00 TL");
        }
    }//GEN-LAST:event_cb_servisActionPerformed



    private void cb_tavukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tavukActionPerformed
   
        yiyecek_hesap(cb_tavuk,txt_tavuk,0);
        if (cb_servis.isSelected()) {
    updateServisUcreti();
}
        
    }//GEN-LAST:event_cb_tavukActionPerformed

    private void cb_etActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_etActionPerformed
        
        yiyecek_hesap(cb_et,txt_et,1);
        if (cb_servis.isSelected()) {
    updateServisUcreti();
}


    }//GEN-LAST:event_cb_etActionPerformed

    private void cb_iskenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_iskenderActionPerformed
        
        yiyecek_hesap(cb_iskender,txt_iskender,2);
        if (cb_servis.isSelected()) {
    updateServisUcreti();
}


  
    }//GEN-LAST:event_cb_iskenderActionPerformed

    private void cb_burdurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_burdurActionPerformed
        
        yiyecek_hesap(cb_burdur,txt_burdur,3);
        if (cb_servis.isSelected()) {
    updateServisUcreti();
}


    }//GEN-LAST:event_cb_burdurActionPerformed

    private void cb_ayranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ayranActionPerformed
        
        icecek_hesap(cb_ayran, txt_ayran, 1);
        if (cb_servis.isSelected()) {
    updateServisUcreti();
}



    }//GEN-LAST:event_cb_ayranActionPerformed

    private void cb_kolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kolaActionPerformed
       
        icecek_hesap(cb_kola, txt_kola, 0);
        if (cb_servis.isSelected()) {
    updateServisUcreti();
}

    }//GEN-LAST:event_cb_kolaActionPerformed

    private void cb_sodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sodaActionPerformed
        
        icecek_hesap(cb_soda,txt_soda, 2);
        if (cb_servis.isSelected()) {
    updateServisUcreti();
}

    }//GEN-LAST:event_cb_sodaActionPerformed

    private void cb_salgamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_salgamActionPerformed
      
        icecek_hesap(cb_salgam,txt_salgam, 3);
        if (cb_servis.isSelected()) {
    updateServisUcreti();
}

    }//GEN-LAST:event_cb_salgamActionPerformed

    private void txt_ekranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ekranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ekranActionPerformed

    private void btn_carpmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_carpmaActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "x");
    }//GEN-LAST:event_btn_carpmaActionPerformed

    private void btn_sonucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sonucActionPerformed
        String expression = txt_ekran.getText();

        
        expression = expression.replaceAll("x", "*");
        expression = expression.replaceAll("÷", "/");

        try {
            double result = Eval.evaluate(expression);
            txt_ekran.setText(String.valueOf(result));
        } catch (Exception e) {
            txt_ekran.setText("Hatalı işlem");
        }
    }//GEN-LAST:event_btn_sonucActionPerformed

    private void btn_temizlemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_temizlemeActionPerformed
        
        txt_ekran.setText("");
    }//GEN-LAST:event_btn_temizlemeActionPerformed

    private void btn_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_0ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "0");
    }//GEN-LAST:event_btn_0ActionPerformed

    private void btn_bolmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bolmeActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "÷");
    }//GEN-LAST:event_btn_bolmeActionPerformed

    private void btn_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_3ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "3");
    }//GEN-LAST:event_btn_3ActionPerformed

    private void btn_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_2ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "2");
    }//GEN-LAST:event_btn_2ActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed

        txt_ekran.setText(txt_ekran.getText() + "1");
    }//GEN-LAST:event_btn_1ActionPerformed

    private void btn_artıActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_artıActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "+");
    }//GEN-LAST:event_btn_artıActionPerformed

    private void btn_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_6ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "6");
    }//GEN-LAST:event_btn_6ActionPerformed

    private void btn_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_5ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "5");
    }//GEN-LAST:event_btn_5ActionPerformed

    private void btn_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_4ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "4");
    }//GEN-LAST:event_btn_4ActionPerformed

    private void btn_eksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eksiActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "-");
    }//GEN-LAST:event_btn_eksiActionPerformed

    private void btn_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_9ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "9");
    }//GEN-LAST:event_btn_9ActionPerformed

    private void btn_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_8ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "8");
    }//GEN-LAST:event_btn_8ActionPerformed

    private void btn_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_7ActionPerformed
        
        txt_ekran.setText(txt_ekran.getText() + "7");
    }//GEN-LAST:event_btn_7ActionPerformed

    private void cb_kdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kdvActionPerformed
        if (cb_kdv.isSelected()) {
    
    if (cb_servis.isSelected()) {
        kdv = (yiyecektotal + icecektotal + servis) * 0.18;
        lbl_kdv.setText(String.format("%.2f TL", kdv));  
    } else {
        JOptionPane.showMessageDialog(null, "Önce servis bedelini seçmelisiniz.", 
                                      "Hata", JOptionPane.ERROR_MESSAGE);
        cb_kdv.setSelected(false);  
        lbl_kdv.setText("0.00 TL");
    }
} else {
    kdv = 0;
    lbl_kdv.setText("0.00 TL");
}



    }//GEN-LAST:event_cb_kdvActionPerformed

    private void btn_toplamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_toplamActionPerformed

    
    if (!cb_kdv.isSelected()) {
        JOptionPane.showMessageDialog(null, "Lütfen KDV'yi seçiniz.", "Hata", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    
    if (!cb_servis.isSelected()) {
        JOptionPane.showMessageDialog(null, "Lütfen Servis Ücreti'ni seçiniz.", "Hata", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    
    double aratoplama = yiyecektotal + icecektotal + servis;
    double geneltoplam;

   
    if (cb_kdv.isSelected()) {
        geneltoplam = aratoplama + kdv; 
    } else {
        geneltoplam = aratoplama;
    }

   
    lbl_aratoplam.setText(String.format("%.2f TL", aratoplama));

    
    lbl_toplam.setText(String.format("%.2f TL", geneltoplam));



    }//GEN-LAST:event_btn_toplamActionPerformed

    private void btn_kapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kapatActionPerformed
 
        System.exit(0);
    }//GEN-LAST:event_btn_kapatActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
    yiyecektotal=0;
    icecektotal=0;
    servis=0;
    aratoplam=0;
    geneltoplam=0;
    kdv=0;
    
    txt_tavuk.setText("");
    txt_tavuk.setEnabled(true);

    txt_et.setText("");
    txt_et.setEnabled(true);

    txt_iskender.setText("");
    txt_iskender.setEnabled(true);

    txt_burdur.setText("");
    txt_burdur.setEnabled(true);

    txt_kola.setText("");
    txt_kola.setEnabled(true);

    txt_ayran.setText("");
    txt_ayran.setEnabled(true);

    txt_soda.setText("");
    txt_soda.setEnabled(true);

    txt_salgam.setText("");
    txt_salgam.setEnabled(true);

    
    lbl_yiyecek.setText("");
    lbl_icecek.setText("");
    lbl_servis.setText("");
    lbl_aratoplam.setText("");
    lbl_toplam.setText("");
    lbl_kdv.setText("");

   
    txtarea_fatura.setText("");

    
    cb_tavuk.setSelected(false);
    cb_et.setSelected(false);
    cb_iskender.setSelected(false);
    cb_burdur.setSelected(false);
    cb_kola.setSelected(false);
    cb_ayran.setSelected(false);
    cb_soda.setSelected(false);
    cb_salgam.setSelected(false);
    cb_servis.setSelected(false);
    cb_kdv.setSelected(false);
        
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_faturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_faturaActionPerformed
    
    if (yiyecektotal == 0 && icecektotal == 0) {
        JOptionPane.showMessageDialog(null, "Lütfen toplamı hesaplatın.", "Hata", JOptionPane.ERROR_MESSAGE);
        return;  
    }

    
    if (!cb_kdv.isSelected()) {
        JOptionPane.showMessageDialog(null, "Lütfen KDV'yi seçiniz.", "Hata", JOptionPane.ERROR_MESSAGE);
        return;  
    }

    if (!cb_servis.isSelected()) {
        JOptionPane.showMessageDialog(null, "Lütfen Servis Ücreti'ni seçiniz.", "Hata", JOptionPane.ERROR_MESSAGE);
        return;  
    }

    
    StringBuilder faturaMetni = new StringBuilder();
    faturaMetni.append("------ Fatura ------\n\n");

    
    int tavukAdet = txt_tavuk.getText().trim().isEmpty() ? 0 : Integer.parseInt(txt_tavuk.getText());
    int etAdet = txt_et.getText().trim().isEmpty() ? 0 : Integer.parseInt(txt_et.getText());
    int iskenderAdet = txt_iskender.getText().trim().isEmpty() ? 0 : Integer.parseInt(txt_iskender.getText());
    int burdurAdet = txt_burdur.getText().trim().isEmpty() ? 0 : Integer.parseInt(txt_burdur.getText());

   
    int kolaAdet = txt_kola.getText().trim().isEmpty() ? 0 : Integer.parseInt(txt_kola.getText());
    int ayranAdet = txt_ayran.getText().trim().isEmpty() ? 0 : Integer.parseInt(txt_ayran.getText());
    int sodaAdet = txt_soda.getText().trim().isEmpty() ? 0 : Integer.parseInt(txt_soda.getText());
    int salgamAdet = txt_salgam.getText().trim().isEmpty() ? 0 : Integer.parseInt(txt_salgam.getText());

    
    if (tavukAdet > 0) {
        faturaMetni.append("Tavuk Döner: " + tavukAdet + " adet\n");
    }
    if (etAdet > 0) {
        faturaMetni.append("Et Döner: " + etAdet + " adet\n");
    }
    if (iskenderAdet > 0) {
        faturaMetni.append("İskender: " + iskenderAdet + " adet\n");
    }
    if (burdurAdet > 0) {
        faturaMetni.append("Burdur Şiş: " + burdurAdet + " adet\n");
    }

    
    if (kolaAdet > 0) {
        faturaMetni.append("Kola: " + kolaAdet + " adet\n");
    }
    if (ayranAdet > 0) {
        faturaMetni.append("Ayran: " + ayranAdet + " adet\n");
    }
    if (sodaAdet > 0) {
        faturaMetni.append("Soda: " + sodaAdet + " adet\n");
    }
    if (salgamAdet > 0) {
        faturaMetni.append("Şalgam: " + salgamAdet + " adet\n");
    }

    
    faturaMetni.append("\nServis Ücreti: " + String.format("%.2f TL", servis) + "\n");
    faturaMetni.append("KDV: " + String.format("%.2f TL", kdv) + "\n");

    
    double aratoplama = yiyecektotal + icecektotal + servis;
    double geneltoplam = aratoplama + kdv;
    faturaMetni.append("\nAra Toplam: " + String.format("%.2f TL", aratoplama) + "\n");
    faturaMetni.append("Toplam: " + String.format("%.2f TL", geneltoplam) + "\n");

    
    txtarea_fatura.setText(faturaMetni.toString());
        
        
    }//GEN-LAST:event_btn_faturaActionPerformed

    private void txt_kolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kolaActionPerformed

    private void txt_tavukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tavukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tavukActionPerformed


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
            java.util.logging.Logger.getLogger(Rys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rys().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_0;
    private javax.swing.JButton btn_1;
    private javax.swing.JButton btn_2;
    private javax.swing.JButton btn_3;
    private javax.swing.JButton btn_4;
    private javax.swing.JButton btn_5;
    private javax.swing.JButton btn_6;
    private javax.swing.JButton btn_7;
    private javax.swing.JButton btn_8;
    private javax.swing.JButton btn_9;
    private javax.swing.JButton btn_artı;
    private javax.swing.JButton btn_bolme;
    private javax.swing.JButton btn_carpma;
    private javax.swing.JButton btn_eksi;
    private javax.swing.JButton btn_fatura;
    private javax.swing.JButton btn_kapat;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sonuc;
    private javax.swing.JButton btn_temizleme;
    private javax.swing.JButton btn_toplam;
    private javax.swing.JCheckBox cb_ayran;
    private javax.swing.JCheckBox cb_burdur;
    private javax.swing.JCheckBox cb_et;
    private javax.swing.JCheckBox cb_iskender;
    private javax.swing.JCheckBox cb_kdv;
    private javax.swing.JCheckBox cb_kola;
    private javax.swing.JCheckBox cb_salgam;
    private javax.swing.JCheckBox cb_servis;
    private javax.swing.JCheckBox cb_soda;
    private javax.swing.JCheckBox cb_tavuk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_aratoplam;
    private javax.swing.JLabel lbl_icecek;
    private javax.swing.JLabel lbl_kdv;
    private javax.swing.JLabel lbl_servis;
    private javax.swing.JLabel lbl_toplam;
    private javax.swing.JLabel lbl_yiyecek;
    private javax.swing.JLabel lblaratoplam;
    private javax.swing.JLabel lblicecek;
    private javax.swing.JLabel lblkdv;
    private javax.swing.JLabel lblservis;
    private javax.swing.JLabel lbltoplam;
    private javax.swing.JLabel lblyiyecek;
    private javax.swing.JPanel pnl1;
    private javax.swing.JTextField txt_ayran;
    private javax.swing.JTextField txt_burdur;
    private javax.swing.JTextField txt_ekran;
    private javax.swing.JTextField txt_et;
    private javax.swing.JTextField txt_iskender;
    private javax.swing.JTextField txt_kola;
    private javax.swing.JTextField txt_salgam;
    private javax.swing.JTextField txt_soda;
    private javax.swing.JTextField txt_tavuk;
    private javax.swing.JTextArea txtarea_fatura;
    // End of variables declaration//GEN-END:variables
}
