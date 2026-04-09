package CaseMethod24;

public class Peminjaman {
    Mahasiswa mhs;
    Buku buku;
    int lamaPinjam;
    int terlambat;
    int denda;

    Peminjaman(Mahasiswa mhs,Buku buku,int lamaPinjam){
        this.mhs=mhs;
        this.buku=buku;
        this.lamaPinjam=lamaPinjam;
        hitungDenda();
    }
    void hitungDenda(){
        int batas =5;
        if (lamaPinjam > batas) {
            terlambat = lamaPinjam - batas;
            denda = terlambat *2000;
        }else{
            terlambat = 0;
            denda = 0;
        }
    }
    void tampil(){
        System.out.println(mhs.nama + " | " + buku.judul +" | Lama: " + lamaPinjam +" | Terlambat: " + terlambat +" | Denda: " + denda);
    }
}
