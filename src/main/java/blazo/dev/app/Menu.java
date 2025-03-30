package blazo.dev.app;

import java.util.Arrays;
import java.util.List;

public class Menu {

    private Menu() throws Exception {
        throw new Exception("This class cannot be instantiated");
    }

    public static List<String> getMenuOptions() {
        return Arrays.asList(
                "📚 Add student",
                "👨‍🏫 Add teacher",
                "📖 Add course",
                "📝 Assign Courses to Students",
                "🏫 Assign Courses to Teachers",
                "🔍 View Student by ID",
                "👥 View every Student and Teacher",
                "📜 View every Course",
                "✏️ Update Student",
                "🗑️ Delete Student",
                "🚪 Exit"
        );
    }


    public static void displayOptions(List<String> menuList) {
        for (int i = 0; i < menuList.size(); i++) {
            System.out.printf("%d - %s\n", (i + 1), menuList.get(i));
        }
    }

    public static void displayMenu() {
        System.out.println("\n=========================");
        System.out.println("What would you like to do now? 🤔");
        displayOptions(getMenuOptions());
        System.out.println("=========================");
    }


}
