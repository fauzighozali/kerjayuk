package com.example.kerjayuk;


public class model {
    private int id;
    private String inama;
    private String ijk;
    private String ipendidikan;
    private String ialamat;
    private String ikontak;
    private byte[] iimage;

    public model(int id, String nama, String jeniskelamin, String pendidikan, String alamat, String kontak, byte[] image) {
        this.id = id;
        this.inama = nama;
        this.ijk = jeniskelamin;
        this.ipendidikan = pendidikan;
        this.ialamat = alamat;
        this.ikontak = kontak;
        this.iimage = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return inama;
    }

    public void setNama(String inama) {
        this.inama = inama;
    }

    public String getJeniskelamin() {
        return ijk;
    }

    public void setJenisKelamin(String ijk) {
        this.ijk = ijk;
    }

    public String getPendidikan() {
        return ipendidikan;
    }

    public void setPendidikan(String ipendidikan) {
        this.ipendidikan = ipendidikan;
    }

    public String getAlamat() { return ialamat; }

    public void setAlamat(String ialamat) {
        this.ialamat = ialamat;
    }

    public String getKontak() {
        return ikontak;
    }

    public void setKontak(String ikontak) {
        this.ikontak = ikontak;
    }

    public byte[] getImage() {
        return iimage;
    }

    public void setImage(byte[] iimage) {
        this.iimage = iimage;
    }
}