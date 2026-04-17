package CaseMethod24;

import java.util.Scanner;

public class Main {
    static void bukuTerbanyak(Peminjaman[] pinjam, Buku[] buku){
        int max =0;
        Buku palingSering = null;
        
    System.out.println("\nJumlah peminjaman tiap buku:");
    for (int i = 0; i < buku.length; i++) {
        int count = 0;

        for (int j = 0; j < pinjam.length; j++) {
            if (pinjam[j].buku.judul.equals(buku[i].judul)) {
                count++;
            }
        }

        System.out.println(buku[i].judul + " = " + count + " kali");

        if (count > max) {
            max = count;
            palingSering = buku[i];
        }
    }
        System.out.println("\nBUKU PALING SERING DIPINJAM: ");
        if (palingSering != null) {
            System.out.println(palingSering.judul + " (" + max + " kali)");
        }
    }
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    Mahasiswa[] mhs = {
        new Mahasiswa("22001", "Andi", "Teknik Informatika"),
        new Mahasiswa("22002", "Budi", "Teknik Informatika"),
        new Mahasiswa("22003", "Citra", "Sistem Informasi Bisnis")
    };
    Buku[] buku = {
        new Buku("B001", "Algoritma", 2020),
        new Buku("B002", "Basis Data", 2019),
        new Buku("B003", "Pemrograman", 2021),
        new Buku("B004", "Fisika", 2024)
    };
    Peminjaman[] pinjam={
        new Peminjaman(mhs[0], buku[0], 7),
        new Peminjaman(mhs[1], buku[1], 3),
        new Peminjaman(mhs[2], buku[2], 10),
        new Peminjaman(mhs[2], buku[3], 6),
        new Peminjaman(mhs[0], buku[1], 4)
    };
    int pilih;
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Berdasarkan Denda");
            System.out.println("5. Cari Berdasarkan NIM (Binary Search)");
            System.out.println("6. Buku Yang Sering Dipinjam");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilih = s.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("\nDaftar Mahasiswa:");
                    for (Mahasiswa m : mhs) {
                        m.tampil();
                    }
                    break;

                case 2:
                    System.out.println("\nDaftar Buku:");
                    for (Buku b : buku) {
                        b.tampil();
                    }
                    break;

                case 3:
                    System.out.println("\nData Peminjaman:");
                    for (Peminjaman p : pinjam) {
                        p.tampil();
                    }
                    break;

                case 4:
                    // INSERTION SORT (denda terbesar)

                    for (int i = 1; i < pinjam.length; i++) {
                        Peminjaman key = pinjam[i];
                        int j = i - 1;

                        while (j >= 0 && pinjam[j].denda < key.denda) {
                            pinjam[j + 1] = pinjam[j];
                            j--;
                        }
                        pinjam[j + 1] = key;
                    }

                    System.out.println("\nSetelah diurutkan (Denda terbesar):");
                    for (Peminjaman p : pinjam) {
                        p.tampil();
                    }
                    break;

                case 5:
                    s.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String cari = s.nextLine();

                    // SORT berdasarkan NIM dulu (Bubble Sort)

                    for (int i = 0; i < pinjam.length - 1; i++) {
                        for (int j = 0; j < pinjam.length - i - 1; j++) {
                            if (pinjam[j].mhs.nim.compareTo(pinjam[j + 1].mhs.nim) > 0) {
                                Peminjaman temp = pinjam[j];
                                pinjam[j] = pinjam[j + 1];
                                pinjam[j + 1] = temp;
                            }
                        }
                    }

                    // BINARY SEARCH

                    int left = 0;
                    int right = pinjam.length - 1;
                    boolean ketemu = false;

                    while (left <= right) {
                        int mid = (left + right) / 2;
                        int hasil = pinjam[mid].mhs.nim.compareTo(cari);

                        if (hasil == 0) {
                            ketemu = true;

                            // tampilkan semua data dengan NIM sama
                            int i = mid;
                            while (i >= 0 && pinjam[i].mhs.nim.equals(cari)) {
                                pinjam[i].tampil();
                                i--;
                            }

                            i = mid + 1;
                            while (i < pinjam.length && pinjam[i].mhs.nim.equals(cari)) {
                                pinjam[i].tampil();
                                i++;
                            }

                            break;
                        } else if (hasil < 0) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }

                    if (!ketemu) {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;
                case 6:
                    bukuTerbanyak(pinjam, buku);
                    break;
            }

        } while (pilih != 0);
        }
    }

  

