package Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import DB.MongoManager;
import Model.Karyawan;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class GenericDAO {
    private MongoCollection<Document> collection;

    public GenericDAO(String namaCollection) {
        MongoDatabase db = MongoManager.getDatabase();
        this.collection = db.getCollection(namaCollection);
    }

    // SIMPAN karyawan
    public void simpan(Karyawan k) {
        Document doc = new Document()
            .append("nama", k.getNama())
            .append("nik", k.getNik())
            .append("jabatan", k.getJabatan())
            .append("departemen", k.getDepartemen())
            .append("rfid_tag", k.getRfidTag())
            .append("email", k.getEmail())
            .append("no_telp", k.getNoTelp())
            .append("status", k.getStatus())
            .append("tanggal_bergabung", k.getTanggalBergabung());
        collection.insertOne(doc);
    }

    // TAMPIL semua karyawan
    public List<Karyawan> tampilSemua() {
        List<Karyawan> list = new ArrayList<>();
        for (Document doc : collection.find()) {
            Karyawan k = new Karyawan(
                doc.getString("nama"),
                doc.getString("nik"),
                doc.getString("jabatan"),
                doc.getString("departemen"),
                doc.getString("rfid_tag"),
                doc.getString("email"),
                doc.getString("no_telp"),
                doc.getString("status"),
                doc.getString("tanggal_bergabung")
            );
            list.add(k);
        }
        return list;
    }
}