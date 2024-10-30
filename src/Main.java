import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Kelas yang merepresentasikan sebuah buku dengan judul, penulis, dan tahun terbit.
 */
class Buku {
    private String judul;
    private String penulis;
    private int tahun;

    /**
     * Konstruktor untuk membuat objek Buku.
     *
     * @param judul Judul buku
     * @param penulis Penulis buku
     * @param tahun Tahun terbit buku
     */
    public Buku(String judul, String penulis, int tahun) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
    }

    /**
     * Mengambil judul buku.
     *
     * @return Judul buku
     */
    public String getJudul() {
        return judul;
    }

    /**
     * Mengambil nama penulis buku.
     *
     * @return Nama penulis buku
     */
    public String getPenulis() {
        return penulis;
    }

    /**
     * Mengambil tahun terbit buku.
     *
     * @return Tahun terbit buku
     */
    public int getTahun() {
        return tahun;
    }

    /**
     * Menampilkan informasi buku (judul, penulis, dan tahun terbit) ke konsol.
     */
    public void tampilkanInfo() {
        System.out.println("Judul: " + judul + ", Penulis: " + penulis + ", Tahun: " + tahun);
    }
}

/**
 * Kelas yang merepresentasikan perpustakaan, yang berisi daftar buku
 * dan menyediakan metode untuk menambah dan menampilkan buku.
 */
class Perpustakaan {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private static final int TAMBAH_BUKU = 1;
    private static final int TAMPILKAN_BUKU = 2;
    private static final int KELUAR = 3;

    /**
     * Menambahkan buku baru ke dalam daftar perpustakaan berdasarkan input dari pengguna.
     * Menghandle kesalahan input untuk tahun terbit.
     */
    public void tambahBuku() {
        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan penulis buku: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan tahun terbit buku: ");

        int tahun = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                tahun = scanner.nextInt();
                validInput = true; // Input valid
            } catch (InputMismatchException e) {
                System.out.println("Input tahun tidak valid. Silakan coba lagi.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.nextLine(); // consume newline
        daftarBuku.add(new Buku(judul, penulis, tahun));
        System.out.println("Buku berhasil ditambahkan!");
    }

    /**
     * Menampilkan daftar buku yang ada di perpustakaan.
     * Jika tidak ada buku, menampilkan pesan bahwa daftar kosong.
     */
    public void tampilkanDaftarBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku dalam daftar.");
        } else {
            for (Buku buku : daftarBuku) {
                buku.tampilkanInfo();
            }
        }
    }

    /**
     * Menampilkan menu utama perpustakaan dan menangani pilihan pengguna.
     * Berisi opsi untuk menambah buku, menampilkan daftar buku, atau keluar.
     */
    public void menu() {
        while (true) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case TAMBAH_BUKU:
                    tambahBuku();
                    break;
                case TAMPILKAN_BUKU:
                    tampilkanDaftarBuku();
                    break;
                case KELUAR:
                    System.out.println("Terima kasih, sampai jumpa!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    /**
     * Menampilkan menu pilihan yang tersedia di perpustakaan.
     */
    private void tampilkanMenu() {
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tampilkan Daftar Buku");
        System.out.println("3. Keluar");
    }
}

/**
 * Kelas utama yang menjalankan aplikasi perpustakaan.
 */
public class Main {
    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan();
        perpustakaan.menu();
    }
}