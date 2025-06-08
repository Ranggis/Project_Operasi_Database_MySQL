import java.sql.*;
import java.util.Scanner;

public class PerpustakaanApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BukuDAO dao = new BukuDAO();
        int pilihan;

        do {
            System.out.println("\n=== MENU OPERASI DATABASE BUKU ===");
            System.out.println("1. Tampilkan Data Buku");
            System.out.println("2. Input Data Buku");
            System.out.println("3. Cari Data Buku");
            System.out.println("4. Ubah Data Buku");
            System.out.println("5. Hapus Data Buku");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu [1-6]: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Input harus angka 1‑6, ulangi: ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.println("\n== Daftar Buku ==");
                    dao.readBuku();
                    break;
                case 2:
                    System.out.println("\n== Input Data Buku Baru ==");
                    System.out.print("Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Pengarang: ");
                    String pengarang = scanner.nextLine();
                    System.out.print("Tahun Terbit: ");
                    int tahun = scanner.nextInt();
                    System.out.print("Jumlah Eksemplar: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();
                    dao.insertBuku(judul, pengarang, tahun, jumlah);
                    break;
                case 3:
                    System.out.println("\n== Cari Buku ==");
                    System.out.print("Masukkan ID Buku: ");
                    int idCari = scanner.nextInt();
                    scanner.nextLine();
                    if (dao.findBukuById(idCari)) {
                        System.out.println("Buku dengan ID " + idCari + " ditemukan.");
                    } else {
                        System.out.println("Buku tidak ditemukan.");
                    }
                    break;
                case 4:
                    System.out.println("\n== Ubah Data Buku ==");
                    System.out.print("Masukkan ID Buku: ");
                    int idUbah = scanner.nextInt();
                    scanner.nextLine();
                    if (!dao.findBukuById(idUbah)) {
                        System.out.println("ID tidak ditemukan.");
                        break;
                    }
                    System.out.print("Judul Baru: ");
                    judul = scanner.nextLine();
                    System.out.print("Pengarang Baru: ");
                    pengarang = scanner.nextLine();
                    System.out.print("Tahun Terbit Baru: ");
                    tahun = scanner.nextInt();
                    System.out.print("Jumlah Baru: ");
                    jumlah = scanner.nextInt();
                    scanner.nextLine();
                    dao.updateBuku(idUbah, judul, pengarang, tahun, jumlah);
                    break;
                case 5:
                    System.out.println("\n== Hapus Buku ==");
                    System.out.print("Masukkan ID Buku: ");
                    int idHapus = scanner.nextInt();
                    scanner.nextLine();
                    if (!dao.findBukuById(idHapus)) {
                        System.out.println("ID tidak ditemukan.");
                        break;
                    }
                    dao.deleteBuku(idHapus);
                    break;
                case 6:
                    System.out.println("Keluar dari program…");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 6);

        scanner.close();
    }
}

/**
 * Kelas DAO (Data Access Object) untuk tabel buku.
 */
class BukuDAO {
    private static final String URL  = "jdbc:mysql://localhost:3306/perpustakaan";
    private static final String USER = "root";
    private static final String PASS = "";

    // Mendapatkan koneksi – dipanggil tiap operasi; gunakan connection‑pool di production
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /**
     * Menampilkan seluruh data buku.
     */
    public void readBuku() {
        String sql = "SELECT * FROM buku";
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("ID | Judul | Pengarang | Tahun | Jumlah");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %d | %d%n",
                        rs.getInt("id_buku"),
                        rs.getString("judul"),
                        rs.getString("pengarang"),
                        rs.getInt("tahun_terbit"),
                        rs.getInt("jumlah"));
            }
        } catch (SQLException e) {
            System.err.println("Gagal membaca data: " + e.getMessage());
        }
    }

    /**
     * Memeriksa apakah buku dgn id tertentu ada.
     */
    public boolean findBukuById(int id) {
        String sql = "SELECT * FROM buku WHERE id_buku = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Menampilkan detail buku
                    System.out.println("Buku ditemukan:");
                    System.out.println("ID Buku       : " + rs.getInt("id_buku"));
                    System.out.println("Judul         : " + rs.getString("judul"));
                    System.out.println("Pengarang     : " + rs.getString("pengarang"));
                    System.out.println("Tahun Terbit  : " + rs.getInt("tahun_terbit"));
                    System.out.println("Jumlah        : " + rs.getInt("jumlah"));
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error findBukuById: " + e.getMessage());
            return false;
        }
    }


    /**
     * Menambah buku baru.
     */
    public void insertBuku(String judul, String pengarang, int tahunTerbit, int jumlah) {
        String sql = "INSERT INTO buku (judul, pengarang, tahun_terbit, jumlah) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, judul);
            ps.setString(2, pengarang);
            ps.setInt(3, tahunTerbit);
            ps.setInt(4, jumlah);
            int result = ps.executeUpdate();
            System.out.println(result > 0 ? "Data buku berhasil ditambahkan." : "Data buku gagal ditambahkan.");
        } catch (SQLException e) {
            System.err.println("Error insertBuku: " + e.getMessage());
        }
    }

    /**
     * Memperbarui data buku.
     */
    public void updateBuku(int id, String judul, String pengarang, int tahunTerbit, int jumlah) {
        String sql = "UPDATE buku SET judul = ?, pengarang = ?, tahun_terbit = ?, jumlah = ? WHERE id_buku = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, judul);
            ps.setString(2, pengarang);
            ps.setInt(3, tahunTerbit);
            ps.setInt(4, jumlah);
            ps.setInt(5, id);
            int result = ps.executeUpdate();
            System.out.println(result > 0 ? "Data buku berhasil diubah." : "Data buku gagal diubah.");
        } catch (SQLException e) {
            System.err.println("Error updateBuku: " + e.getMessage());
        }
    }

    /**
     * Menghapus buku berdasarkan ID.
     */
    public void deleteBuku(int id) {
        String sql = "DELETE FROM buku WHERE id_buku = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            System.out.println(result > 0 ? "Buku berhasil dihapus." : "Buku gagal dihapus.");
        } catch (SQLException e) {
            System.err.println("Error deleteBuku: " + e.getMessage());
        }
    }
}