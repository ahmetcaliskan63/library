import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Kutuphane {
    private ArrayList<Kitap> kitaplar = new ArrayList<>();
    private ArrayList<Uye> uyeler = new ArrayList<>();
    private ArrayList<Gorevli> gorevliler = new ArrayList<>();
    private Map<Uye, Kitap> oduncKitaplar = new HashMap<>();

    // Sarmalama: İlkel veri türleri için sarmalayıcı sınıflar kulandım
    private static class KitapSarmalayici {
        private Kitap kitap;

        public KitapSarmalayici(Kitap kitap) {
            this.kitap = kitap;
        }

        public Kitap getKitap() {
            return kitap;
        }
    }

    // Referanslar: Nesneleri bağlamak için referansları kullanın
    private KitapSarmalayici sonOduncKitap;

    // Nesne Oluşturma ve Yok Etme: Yapıcı metotlar kullanın
    public Kutuphane() {
        // Yapıcı metot
    }

    // Statik Yöntemler ve Değişkenler: Uygun yerlerde statik yöntemleri ve değişkenleri kullanın
    private static int toplamKitapSayisi = 0;

    public static int getToplamKitapSayisi() {
        return toplamKitapSayisi;
    }

    // Kitap ekleme
    public void kitapEkle(String ad, String yazar) {
        Kitap yeniKitap = new Kitap(ad, yazar);
        kitaplar.add(yeniKitap);
        toplamKitapSayisi++;
    }

    // Kitap çıkarma
    public void kitapCikar(Kitap kitap) {
        kitaplar.remove(kitap);
        toplamKitapSayisi--;
    }

    // Üye ekleme
    public void uyeEkle(String ad, String tcKimlik) {
        Uye yeniUye = new Uye(ad, tcKimlik);
        uyeler.add(yeniUye);
    }

    // Üye çıkarma
    public void uyeCikar(Uye uye) {
        uyeler.remove(uye);
    }

    // Görevli ekleme
    public void gorevliEkle(String ad, String sicilNo) {
        Gorevli yeniGorevli = new Gorevli(ad, sicilNo);
        gorevliler.add(yeniGorevli);
    }

    // Görevli çıkarma
    public void gorevliCikar(Gorevli gorevli) {
        gorevliler.remove(gorevli);
    }

    // Kitap ödünç verme
    public void kitapOduncVer(String uyeAd, String kitapAd) {
        Uye uye = null;
        Kitap kitap = null;

        for (Uye u : uyeler) {
            if (u.getAd().equals(uyeAd)) {
                uye = u;
                break;
            }
        }

        for (Kitap k : kitaplar) {
            if (k.getAd().equals(kitapAd)) {
                kitap = k;
                break;
            }
        }

        if (uye != null && kitap != null && !oduncKitaplar.containsKey(uye)) {
            oduncKitaplar.put(uye, kitap);
            sonOduncKitap = new KitapSarmalayici(kitap);
        }
    }

    // Kitap ödünç alma
    public void kitapOduncAl(String uyeAd) {
        Uye uye = null;

        for (Uye u : oduncKitaplar.keySet()) {
            if (u.getAd().equals(uyeAd)) {
                uye = u;
                break;
            }
        }

        if (uye != null) {
            oduncKitaplar.remove(uye);
            sonOduncKitap = null;
        }
    }

    // Ödünç alınan kitapların kimlerde olduğunu takip etme
    public void oduncKitaplariTakipEt() {
        if (sonOduncKitap != null) {
            System.out.println("Son Ödünç Verilen Kitap: " + sonOduncKitap.getKitap().toString());
        } else {
            System.out.println("Şu anda ödünç alınan kitap yok.");
        }
    }

    // Kütüphanedeki bütün kitapları listeleme
    public void kitaplariListele() {
        System.out.println("Kütüphanedeki Kitaplar:\n");
        int n=1;
        for (Kitap kitap : kitaplar) {
            System.out.println(n +"- "+kitap.toString());
            n++;
        }

        System.out.println("**********************************\n");

    }

    // Kütüphanedeki bütün üyeleri listeleme
    public void uyeleriListele() {
        System.out.println("Kütüphanedeki Üyeler:");

        for (Uye uye : uyeler) {
            System.out.println(uye.toString());
        }
        System.out.println("**********************");
    }
    public ArrayList<Kitap> getKitaplar() {
        return kitaplar;
    }

    public ArrayList<Uye> getUyeler() {
        return uyeler;
    }

    public ArrayList<Gorevli> getGorevliler() {
        return gorevliler;
    }
}