package blazo.dev.ui;

public class Messages {

    private Messages() throws Exception {
        throw new Exception("This class cannot be instantiated");
    }

    public static void displayTitle(String title) {
        int padding = 4;
        String border = "═".repeat(title.length() + padding);
        System.out.println("╔" + border + "╗");
        System.out.printf("║  %s  ║%n", title);
        System.out.println("╚" + border + "╝");
    }

}
