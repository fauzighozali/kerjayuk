package com.example.kerjayuk;

class Profil {
    private long id;
    private String namanama;
    private String namajk;
    private String namapendidikan;
    private String namaalamat;
    private String namakontak;

    public Profil()
    {

    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getNamanama() {
        return namanama;
    }
    public void setNamanama(String namanama) {
        this.namanama = namanama;
    }


    public String getNamajk() {
        return namajk;
    }
    public void setNamajk(String namajk) {
        this.namajk = namajk;
    }


    public String getNamapendidikan() { return namapendidikan; }
    public void setNamapendidikan(String namapendidikan) {
        this.namapendidikan= namapendidikan;
    }

    public String getNamaalamat() { return namaalamat; }
    public void setNamaalamat(String namaalamat) {
        this.namaalamat= namaalamat;
    }

    public String getNamakontak() { return namakontak; }
    public void setNamakontak(String namakontak) {
        this.namakontak= namakontak;
    }


    @Override
    public String toString()
    {
        return "Profil :"+ namanama +", "+ namajk + ", "+ namapendidikan + ", " + namaalamat + ", " + namakontak;
    }
}


