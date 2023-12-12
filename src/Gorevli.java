class Gorevli extends BaseDemos{
    private String ad;// Gorevli adını temsil eder
    private String sicilNo;// Gorevli Sicil numarasını temsil eder

    // Gorevli sınıfının constructor'ı
    public Gorevli(String ad, String sicilNo) {
        this.ad = ad;
        this.sicilNo = sicilNo;
    }
    //SicilNo numarasını getiren metot
    public String getSicilNo() {
        return sicilNo;
    }

    // toString metodu, nesnenin bilgilerini String olarak döndürür
    @Override
    public String toString() {
        return ad + " - " + sicilNo;
    }

    // BaseDemos sınıfındaki abstract metodu implemente eden metot
    @Override
    public String getAd() {
        return ad;
    }
}
