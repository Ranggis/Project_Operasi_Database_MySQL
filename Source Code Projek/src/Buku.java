import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Buku {
    String sql;
    String url = "jdbc:mysql://localhost:3306/perpustakaan";
    String user = "root";
    String pass = "";
    Connection koneksi;

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, pass);
    }

    public void readBuku(){
        sql = "SELECT * FROM buku";
        try {
            koneksi = getConnection();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getInt("id_buku") + " | ");
                System.out.print(rs.getString("judul") + " | ");
                System.out.print(rs.getString("pengarang") + " | ");
                System.out.print(rs.getInt("tahun_terbit") + " | ");
                System.out.print(rs.getInt("jumlah") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBuku(String judul, String pengarang, int tahunTerbit, int jumlah){
        sql = "INSERT INTO buku (judul, pengarang, tahun_terbit, jumlah) VALUES (?, ?, ?, ?)";
        try {
            koneksi = getConnection();
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, judul);
            ps.setString(2, pengarang);
            ps.setInt(3, tahunTerbit);
            ps.setInt(4, jumlah);

            int result = ps.executeUpdate();
            if(result > 0){
                System.out.println("Data buku berhasil ditambahkan.");
            } else {
                System.out.println("Data buku gagal ditambahkan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
}