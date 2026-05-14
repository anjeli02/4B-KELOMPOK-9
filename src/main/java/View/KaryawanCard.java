package View;
import java.awt.*;
import javax.swing.*;

public class KaryawanCard extends JPanel {
    
    public interface CardListener {
        void onEdit(String nik);
        void onDelete(String nik);
    }
    
    public KaryawanCard(String nama, String nik, String jabatan, String departemen, String status, CardListener listener) {
        setLayout(null);
        setBackground(new Color(255, 165, 0));
        setBorder(BorderFactory.createLineBorder(new Color(255, 0, 255), 3));
        setPreferredSize(new Dimension(220, 180));
        
        JLabel lblNama = new JLabel("Nama: " + nama);
        lblNama.setForeground(Color.WHITE);
        lblNama.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblNama.setBounds(10, 10, 200, 25);
        
        JLabel lblNik = new JLabel("NIK: " + nik);
        lblNik.setForeground(Color.WHITE);
        lblNik.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblNik.setBounds(10, 38, 200, 25);
        
        JLabel lblJabatan = new JLabel("Jabatan: " + jabatan);
        lblJabatan.setForeground(Color.WHITE);
        lblJabatan.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblJabatan.setBounds(10, 63, 200, 25);
        
        JLabel lblDept = new JLabel("Dept: " + departemen);
        lblDept.setForeground(Color.WHITE);
        lblDept.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblDept.setBounds(10, 88, 200, 25);
        
        JLabel lblStatus = new JLabel("Status: " + status);
        lblStatus.setForeground(Color.WHITE);
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblStatus.setBounds(10, 113, 200, 25);
        
        JButton btnEdit = new JButton("Edit");
        btnEdit.setBackground(new Color(230, 120, 0));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setBounds(10, 145, 85, 28);
        btnEdit.setBorderPainted(false);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(e -> listener.onEdit(nik));
        
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(new Color(200, 0, 0));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setBounds(115, 145, 95, 28);
        btnDelete.setBorderPainted(false);
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin menghapus karyawan " + nama + "?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (confirm == JOptionPane.YES_OPTION) {
                listener.onDelete(nik);
            }
});
        
        add(lblNama);
        add(lblNik);
        add(lblJabatan);
        add(lblDept);
        add(lblStatus);
        add(btnEdit);
        add(btnDelete);
    }
}