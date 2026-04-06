import java.util.Scanner;

// ==============================
// CLASS LAGU
// ==============================
class Lagu {
    private String judul;
    private String artis;
    private double durasi;

    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi;
    }

    public String getJudul() {
        return judul;
    }

    public String getArtis() {
        return artis;
    }

    public double getDurasi() {
        return durasi;
    }

    public void tampilkanInfo() {
        System.out.println(judul + " - " + artis + " (" + durasi + " menit)");
    }
}

// ==============================
// CLASS UTAMA
// ==============================
public class PlaylistArray {
    static Lagu[] playlist = new Lagu[10];
    static int jumlah = 0;
    static Scanner input = new Scanner(System.in);

    // ==============================
    // TRAVERSAL (method buat nampilin semua lagu)
    // ==============================
    static void tampilkanSemuaLagu() {
        if (jumlah == 0) {
            System.out.println("Playlist kosong.");
        } else {
            System.out.println("Daftar Lagu:");
            for (int i = 0; i < jumlah; i++) {
                System.out.print((i + 1) + ". ");
                playlist[i].tampilkanInfo();
            }
        }
    }

    // ==============================
    // INSERTION (tambah lagu)
    // ==============================
    static void tambahLagu() {
        if (jumlah == playlist.length) {
            System.out.println("Playlist penuh!");
            return;
        }

        System.out.print("Masukkan judul lagu: ");
        String judul = input.nextLine();

        System.out.print("Masukkan artis: ");
        String artis = input.nextLine();

        System.out.print("Masukkan durasi: ");
        double durasi = input.nextDouble();
        input.nextLine();

        playlist[jumlah] = new Lagu(judul, artis, durasi);
        jumlah++;

        System.out.println("Lagu berhasil ditambahkan!");
    }

    // ==============================
    // SEARCHING (cari lagu (linear search))
    // ==============================
    static void cariLagu() {
        System.out.print("Masukkan judul lagu yang dicari: ");
        String cari = input.nextLine();

        boolean ketemu = false;

        for (int i = 0; i < jumlah; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(cari)) {
                System.out.println("Lagu ditemukan:");
                playlist[i].tampilkanInfo();
                ketemu = true;
                break;
            }
        }

        if (!ketemu) {
            System.out.println("Lagu tidak ditemukan.");
        }
    }

    // ==============================
    // DELETION (hapus lagu)
    // ==============================
    static void hapusLagu() {
        System.out.print("Masukkan judul lagu yang ingin dihapus: ");
        String hapus = input.nextLine();

        int index = -1;

        for (int i = 0; i < jumlah; i++) {
            if (playlist[i].getJudul().equalsIgnoreCase(hapus)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < jumlah - 1; i++) {
                playlist[i] = playlist[i + 1];
            }
            jumlah--;
            System.out.println("Lagu berhasil dihapus.");
        } else {
            System.out.println("Lagu tidak ditemukan.");
        }
    }

    // ==============================
    // SORTING (bubble sort)
    // ==============================
    static void urutkanDurasi() {
        for (int i = 0; i < jumlah - 1; i++) {
            for (int j = 0; j < jumlah - i - 1; j++) {
                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {
                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;
                }
            }
        }
        System.out.println("Playlist berhasil diurutkan.");
    }

    // ==============================
    // MAIN MENU
    // ==============================
    public static void main(String[] args) {
        int pilih;

        do {
            System.out.println("\n=== MENU PLAYLIST MUSIK ===");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu");
            System.out.println("3. Hapus lagu");
            System.out.println("4. Cari lagu");
            System.out.println("5. Urutkan durasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1: tampilkanSemuaLagu(); break;
                case 2: tambahLagu(); break;
                case 3: hapusLagu(); break;
                case 4: cariLagu(); break;
                case 5: urutkanDurasi(); break;
                case 6: System.out.println("Terima kasih"); break;
                default: System.out.println("Pilihan tidak valid");
            }

        } while (pilih != 6);
    }
}
