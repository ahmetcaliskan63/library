

//Ahmet ÇALIŞKAN 1220505025

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Kutuphane kutuphane = new Kutuphane();
        Scanner scanner = new Scanner(System.in);

//Ahmet ÇALIŞKAN 1220505025


        while (true) {
            // Kullanıcıya menü seçenekleri gösteriliyor
            System.out.println("\nAhmet Çalışkan Kütüphane Otamasyonuna hoş geldiniz.");
            System.out.println("***************************\n");
            System.out.println("1- Kütüphaneye kitap ekleme");
            System.out.println("2- kütüphaneden kitap çıkarma");
            System.out.println("3- Kütüphaneye üye ekleme");
            System.out.println("4- kütüphaneden üye çıkarma");
            System.out.println("5- Kütüphaneye görevli ekleme");
            System.out.println("6- kütüphaneden görevli çıkarma");
            System.out.println("7- Bir üyeye ödünç kitap verme");
            System.out.println("8- Bir üyedeki ödünç alınmış kitabı kütüphaneye geri bırakma");
            System.out.println("9- Şu anda ödünç alınan kitapların kimlerde olduğunu takip etme");
            System.out.println("10- Çıkış");
            System.out.print("Lütfen yapmak istediğiniz işlemin numarasını girin: ");

            // Kullanıcının seçimini alınıyor
            int secim = scanner.nextInt();

            // Kullanıcının seçimine göre yapılacak işlemler.
            switch (secim) {
                case 1:
                    // Kütüphaneye yeni bir kitap ekleme
                    System.out.print("Kitap Adı: ");
                    String kitapAdi = scanner.next();
                    System.out.print("Yazar: ");
                    String yazar = scanner.next();
                    kutuphane.kitapEkle(kitapAdi, yazar);
                    System.out.println("Kitap eklendi.");
                    kutuphane.kitaplariListele();
                    break;

                case 2:
                    // Bir kitabı kütüphaneden çıkarma
                    System.out.print("Çıkarılacak Kitap Adı: ");
                    String cikarilacakKitap = scanner.next();
                    for (Kitap kitap : kutuphane.getKitaplar()) {
                        if (kitap.getAd().equals(cikarilacakKitap)) {
                            kutuphane.kitapCikar(kitap);
                            System.out.println("Kitap kütüphaneden çıkarıldı.");

                            kutuphane.kitaplariListele();
                            break;
                        }
                    }
                    break;

                case 3:
                    // Kütüphaneye yeni bir üye ekleme
                    System.out.print("Üye Adı: ");
                    String uyeAdi = scanner.next();
                    System.out.print("TC Kimlik: ");
                    String tcKimlik = scanner.next();
                    kutuphane.uyeEkle(uyeAdi, tcKimlik);
                    System.out.println("Üye eklendi.");
                    kutuphane.uyeleriListele();
                    break;

                case 4:
                    // Bir üyeyi kütüphaneden çıkarma
                    System.out.print("Çıkarılacak Üye Adı: ");
                    String cikarilacakUye = scanner.next();
                    for (Uye uye : kutuphane.getUyeler()) {
                        if (uye.getAd().equals(cikarilacakUye)) {
                            kutuphane.uyeCikar(uye);
                            System.out.println("Üye kütüphaneden çıkarıldı.");
                            break;
                        }
                    }
                    break;

                case 5:
                    // Kütüphaneye yeni bir görevli ekleme
                    System.out.print("Görevli Adı: ");
                    String gorevliAdi = scanner.next();
                    System.out.print("Sicil No: ");
                    String sicilNo = scanner.next();
                    kutuphane.gorevliEkle(gorevliAdi, sicilNo);
                    System.out.println("Görevli eklendi.");
                    break;

                case 6:
                    // Bir görevliyi kütüphaneden çıkarma
                    System.out.print("Çıkarılacak Görevli Adı: ");
                    String cikarilacakGorevli = scanner.next();
                    for (Gorevli gorevli : kutuphane.getGorevliler()) {
                        if (gorevli.getAd().equals(cikarilacakGorevli)) {
                            kutuphane.gorevliCikar(gorevli);
                            System.out.println("Görevli kütüphaneden çıkarıldı.");
                            break;
                        }
                    }
                    break;

                case 7:
                    // Bir üyeye ödünç kitap verme
                    System.out.print("Üye Adı: ");
                    String oduncUyeAdi = scanner.next();
                    System.out.print("Kitap Adı: ");
                    String oduncKitapAdi = scanner.next();
                    kutuphane.kitapOduncVer(oduncUyeAdi, oduncKitapAdi);
                    System.out.println("Kitap ödünç verildi.");
                    break;

                case 8:
                    // Bir üyedeki ödünç alınmış kitabı kütüphaneye geri bırakma
                    System.out.print("Üye Adı: ");
                    String geriBirakUyeAdi = scanner.next();
                    kutuphane.kitapOduncAl(geriBirakUyeAdi);
                    System.out.println("Kitap kütüphaneye geri bırakıldı.");
                    break;

                case 9:
                    // Şu anda ödünç alınan kitapların kimlerde olduğunu takip etme
                    kutuphane.oduncKitaplariTakipEt();
                    break;

                case 10:
                    // Çıkış
                    System.out.println("Programdan çıkılıyor...");
                    System.exit(0);

                default:
                    // Geçersiz seçenek durumu
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
                    break;
            }
        }
    }
}