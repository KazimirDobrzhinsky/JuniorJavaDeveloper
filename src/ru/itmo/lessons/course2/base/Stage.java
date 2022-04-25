package ru.itmo.lessons.course2.base;

public enum Stage {
    FOX("Лисенок",
            "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не было исключением. " +
                    "Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. " +
                    "Лисёнок ждал, ждал, но так и не смог дождаться своего друга. " +
                    "\" Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" - " +
                    "подумал Лисёнок. Как поступить Лисенку?",
            "1. Вернуться домой",
            "2. Отправиться на поиски",
            false),
    GOHOME("Вернуться домой",
            "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой злобных пчел. " +
                    "Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга!",
            null, null, true),
    GOSEARCH("Отправиться на поиски",
            "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. " +
                    "Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.",
            "1. Попытаться разузнать о Бельчонке у лесных жителей",
            "2. Искать Бельчонка в одиночку", false),
    ASKFORESTPEOPLE("Попытаться разузнать о Бельчонке у лесных жителей",
            "Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. " +
                    "Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?",
            "1. Расспросить Сову",
            "2. Расспросить Волка", false),
    SEARCHALONE("Искать Бельчонка в одиночку",
            "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.",
            null, null, false),
    ASKOWL("Расспросить Сову",
            "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. " +
                    "Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.",
            "1. Поверить Сове и отправиться вглубь леса",
            "2. Сове не стоит верить -> Искать Бельчонка в одиночку", false),
    ASKWOLF("Расспросить Волка",
            "Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?",
            "1. Волк прав -> Вернуться домой",
            "2. Искать Бельчонка в одиночку", false),
    TRUSTOWL("Поверить Сове и отправиться вглубь леса",
            "В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, что знает, если Лисёнок принесёт ему мёда",
            "1. Нет, потрачено слишком много времени, нужно идти дальше -> Искать Бельчонка в одиночку",
            "2. Нужно воспользоваться шансом и раздобыть мёд", false),
    HONEY("Нужно воспользоваться шансом и раздобыть мёд",
            "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но и не найти друга он тоже боялся.",
            "1. Подождать, вдруг пчёлы улетят",
            "2. Нужно попытаться выкрасть мёд немедленно", false),
    WAITBEES("Подождать, вдруг пчёлы улетят",
            "Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден. Что же делать?",
            "1. Поесть немного и передохнуть",
            "2. Скорее отнести мёд Медвежонку", false),
    STEELHONEY("Нужно попытаться выкрасть мёд немедленно",
            "Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь.",
            null, null, false),
    REST("Поесть немного и передохнуть",
            "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не сможет продолжить поиски.",
            null, null, false),
    HONEYTOBEAR("Скорее отнести мёд Медвежонку",
            "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, что Бельчонок никогда не пошёл бы в глубь леса. " +
                    "Он заверял Лисёнка, что Белки не попадают в неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.",
            "1. Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку",
            "2. Может быть он прав и Лисёнок просто паникует -> Вернуться домой", false);
    private final String title;
    private final String text;
    private final String firstReply;
    private final String secondReply;
    private Stage nextStageFirst;
    private Stage nextStageSecond;
    private final boolean win;


    Stage(String title, String text, String firstReply, String secondReply, boolean win) {
        this.title = title;
        this.text = text;
        this.firstReply = firstReply;
        this.secondReply = secondReply;
        this.win = win;
    }

    public Stage getNextStageFirst() {
        return nextStageFirst;
    }

    public Stage getNextStageSecond() {
        return nextStageSecond;
    }

    private void setNextStageFirst(Stage nextStageFirst) {
        this.nextStageFirst = nextStageFirst;
    }

    private void setNextStageSecond(Stage nextStageSecond) {
        this.nextStageSecond = nextStageSecond;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getFirstReply() {
        return firstReply;
    }

    public String getSecondReply() {
        return secondReply;
    }

    public boolean isWin() {
        return win;
    }


    static {
        FOX.setNextStageFirst(GOHOME);
        FOX.setNextStageSecond(GOSEARCH);
        GOHOME.setNextStageFirst(null);
        GOHOME.setNextStageSecond(null);
        GOSEARCH.setNextStageFirst(ASKFORESTPEOPLE);
        GOSEARCH.setNextStageSecond(SEARCHALONE);
        SEARCHALONE.setNextStageFirst(null);
        SEARCHALONE.setNextStageSecond(null);
        ASKFORESTPEOPLE.setNextStageFirst(ASKOWL);
        ASKFORESTPEOPLE.setNextStageSecond(ASKWOLF);
        ASKOWL.setNextStageFirst(TRUSTOWL);
        ASKOWL.setNextStageSecond(SEARCHALONE);
        ASKWOLF.setNextStageFirst(GOHOME);
        ASKWOLF.setNextStageSecond(GOSEARCH);
        TRUSTOWL.setNextStageFirst(SEARCHALONE);
        TRUSTOWL.setNextStageSecond(HONEY);
        HONEY.setNextStageFirst(WAITBEES);
        HONEY.setNextStageSecond(STEELHONEY);
        STEELHONEY.setNextStageSecond(null);
        STEELHONEY.setNextStageSecond(null);
        WAITBEES.setNextStageFirst(REST);
        WAITBEES.setNextStageSecond(HONEYTOBEAR);
        REST.setNextStageFirst(null);
        REST.setNextStageSecond(null);
        HONEYTOBEAR.setNextStageFirst(SEARCHALONE);
        HONEYTOBEAR.setNextStageSecond(GOHOME);
    }
}
