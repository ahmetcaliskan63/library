class Uye extends BaseDemos{
    private String ad;// Üye adını temsil eder
    private String tcKimlik;// Üye TC Kimlik numarasını temsil eder

    // Uye sınıfının constructor'ı
    public Uye(String ad, String tcKimlik) {
        this.ad = ad;
        this.tcKimlik = tcKimlik;
    }

    // TC Kimlik numarasını getiren metot
    public String getTcKimlik() {
        return tcKimlik;
    }

    // toString metodu, nesnenin bilgilerini String olarak döndürür
    @Override
    public String toString() {
        return ad + " - " + tcKimlik;
    }

    // BaseDemos sınıfındaki abstract metodu implemente eden metot
    @Override
    public String getAd() {
        return ad;
    }
}