package lesson3.champagne;

public enum Cru {
    // создать перчисление с тремя элементами
    // с каждым элементом связать качество
    AUTRE(80), PREMIER(90), GRAND(100)
    ;

    // добавить поле качество
    private int quality;

    // добавить конструктор
    Cru(int quality) {
        this.quality = quality;
    }

    // добавить геттер
    public int getQuality() {
        return quality;
    }

}
