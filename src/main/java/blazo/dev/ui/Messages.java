package blazo.dev.ui;

public class Messages {

    private Messages() throws Exception {
        throw new Exception("This class can not be instate");
    }

    public static void displayTitle(String title) {
        String border = "═".repeat(title.length() + 8);
        System.out.println("╔" + border + "╗");
        System.out.printf("║    %s    ║%n", title);
        System.out.println("╚" + border + "╝");
    }


}
