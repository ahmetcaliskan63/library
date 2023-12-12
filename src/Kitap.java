class Kitap extends BaseDemos{
    private String ad;// Kitabın adını temsil eden özellik
    private String yazar;// Kitabın yazarını temsil eden özellik

    public Kitap(String ad, String yazar) {
        this.ad = ad;
        this.yazar = yazar;
    }
    public String getYazar() {
        return yazar;
    }

    // toString metodu, nesnenin bilgilerini String olarak döndürür
    @Override
    public String toString() {
        return ad + " - " + yazar;
    }

    // BaseDemos sınıfındaki abstract metodu implemente eden metot
    @Override
    public String getAd() {
        return ad;
    }
}