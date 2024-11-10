import java.util.Scanner;

class Bank {
    // Atribut
    private String namaAccount;
    private double saldo;

    // Constructor
    public Bank(String namaAccount, double saldo) {
        this.namaAccount = namaAccount;
        this.saldo = saldo;
    }

    public String getNamaAccount() {
        return namaAccount;
    }

    public void setNamaAccount(String namaAccount) {
        this.namaAccount = namaAccount;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Method untuk mengecek saldo
    public void checkSaldo() {
        System.out.println("Nama Nasabah : " + getNamaAccount());
        System.out.println("Saldo : Rp. " + getSaldo());
    }

    // Method untuk menarik saldo
    public void wdSaldo(double withdraw) {
        if (withdraw > 0 && withdraw <= saldo) {
            saldo -= withdraw;
            System.out.println("Penarikan : Rp. " + withdraw + " berhasil.");
            System.out.println("Sisa saldo anda : Rp. " + getSaldo());
        } else {
            System.out.println("Penarikan gagal: Jumlah penarikan tidak valid atau melebihi saldo anda.");
        }
    }

    // Method untuk menambah saldo
    public void tambahSaldo(double deposit) {
        if (deposit > 0) {
            saldo += deposit;
            System.out.println("Penambahan saldo sebesar Rp. " + deposit + " berhasil.");
            System.out.println("Saldo saat ini : Rp. " + getSaldo());
        } else {
            System.out.println("Penambahan saldo gagal: Jumlah yang dimasukkan tidak valid.");
        }
    }
}

public class MainBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek Bank dengan nama nasabah dan saldo awal
        Bank bank = new Bank("Udin Rojali", 100000);

        // Menampilkan menu satu kali saja
        System.out.println("\n --- Sistem Bank Sederhana ---");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tambah Saldo");
        System.out.println("3. Tarik Saldo");
        System.out.println("4. Keluar");
        System.out.print("Pilih opsi: ");
        int pilihan = scanner.nextInt();

        if (pilihan == 1) {
            bank.checkSaldo();
        } else if (pilihan == 2) {
            System.out.print("Masukkan jumlah yang ingin ditambahkan: Rp. ");
            double jumlahTambah = scanner.nextDouble();
            bank.tambahSaldo(jumlahTambah);
        } else if (pilihan == 3) {
            System.out.print("Masukkan jumlah yang ingin ditarik: Rp. ");
            double jumlahTarik = scanner.nextDouble();
            bank.wdSaldo(jumlahTarik);
        } else if (pilihan == 4) {
            System.out.println("Terima kasih telah menggunakan sistem bank.");
        } else {
            System.out.println("Pilihan tidak valid. Program selesai.");
        }

        // Menutup scanner
        scanner.close();
    }
}
