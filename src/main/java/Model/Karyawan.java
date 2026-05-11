package Model;

public class Karyawan {
    private String nama;
    private String nik;
    private String jabatan;
    private String departemen;
    private String rfidTag;
    private String email;
    private String noTelp;
    private String status;
    private String tanggalBergabung;

    // Constructor kosong
    public Karyawan() {}

    // Constructor lengkap
    public Karyawan(String nama, String nik, String jabatan, String departemen,
                    String rfidTag, String email, String noTelp,
                    String status, String tanggalBergabung) {
        this.nama = nama;
        this.nik = nik;
        this.jabatan = jabatan;
        this.departemen = departemen;
        this.rfidTag = rfidTag;
        this.email = email;
        this.noTelp = noTelp;
        this.status = status;
        this.tanggalBergabung = tanggalBergabung;
    }

    // Getters & Setters
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    public String getDepartemen() { return departemen; }
    public void setDepartemen(String departemen) { this.departemen = departemen; }

    public String getRfidTag() { return rfidTag; }
    public void setRfidTag(String rfidTag) { this.rfidTag = rfidTag; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTanggalBergabung() { return tanggalBergabung; }
    public void setTanggalBergabung(String tanggalBergabung) { this.tanggalBergabung = tanggalBergabung; }
}