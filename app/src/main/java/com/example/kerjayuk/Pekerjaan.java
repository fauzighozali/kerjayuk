package com.example.kerjayuk;


public class Pekerjaan {
    private long id;
    private String namaperusahaan;
    private String namapekerjaan;
    private String namapendidikan;
    private String namalokasi;
    private String namadurasi;
    private String namakontak;

    public Pekerjaan()
    {

    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNamaperusahaan() {
        return namaperusahaan;
    }
    public void setNamaperusahaan(String namaperusahaan) {
        this.namaperusahaan = namaperusahaan;
    }


    public String getNamapekerjaan() {
        return namapekerjaan;
    }
    public void setNamapekerjaan(String namapekerjaan) {
        this.namapekerjaan = namapekerjaan;
    }


    public String getNamapendidikan() { return namapendidikan; }
    public void setNamapendidikan(String namapendidikan) {
        this.namapendidikan= namapendidikan;
    }

    public String getNamalokasi() { return namalokasi; }
    public void setNamalokasi(String namalokasi) {
        this.namalokasi= namalokasi;
    }

    public String getNamadurasi() { return namadurasi; }
    public void setNamadurasi(String namadurasi) {
        this.namadurasi= namadurasi;
    }

    public String getNamakontak() {
        return namakontak;
    }
    public void setNamakontak(String namakontak) {
        this.namakontak= namakontak;

    }
    @Override
    public String toString()
    {
        return "Pekerjaan :"+ namaperusahaan +", "+ namapekerjaan + ", "+ namapendidikan + ", " + namalokasi + ", " + namadurasi + ", " + namakontak;
    }
}
