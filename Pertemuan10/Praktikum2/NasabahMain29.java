package Pertemuan10.Praktikum2;

import java.util.Scanner;

import Pertemuan10.Praktikum2.Nasabah29.Queue29;

public class NasabahMain29 {
    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek antrian terdepan");
        System.out.println("4. Cek semua antrian");
        System.out.println("5. Cek antrian terakhir");
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Scanner scan29 = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = scan29.nextInt();
        Queue29 antri = new Queue29(jumlah);

        int pilih;
        do {
            menu();
            pilih = scan29.nextInt();
            scan29.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("No Rekening: ");
                    String norek = scan29.nextLine();
                    System.out.print("Nama: ");
                    String nama = scan29.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = scan29.nextLine();
                    System.out.print("Umur: ");
                    int umur = scan29.nextInt();
                    System.out.print("Saldo: ");
                    double saldo = scan29.nextDouble();

                    Nasabah29 nb = new Nasabah29(nama, norek, alamat, umur, saldo);
                    scan29.nextLine();
                    antri.enqueue(nb);
                    break;

                case 2:
                    Nasabah29 data = antri.dequeue();
                    if (!"".equals(data.norek) && !"".equals(data.norek) && !"".equals(data.alamat) && data.umur != 0
                            && data.saldo != 0) {
                        System.out.println("Antrian keluar: " + data.norek + " " + data.nama + " " + data.alamat + " "
                                + data.umur + " " + data.saldo);
                        break;
                    }

                case 3:
                    antri.peek();
                    break;

                case 4:
                    antri.print();
                    break;

                case 5:
                    antri.peekRear();
                    break;

            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);

        scan29.close();
    }
}