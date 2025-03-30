package blazo.dev.app;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    private Menu() throws Exception {
        throw new Exception("This class can not be instate");
    }

    public static ArrayList<String> getMenuOptions() {
        return new ArrayList<>(Arrays.asList(
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
        ));
    }


    public static void displayOptions(ArrayList<String> menuList) {
        for (int i = 0; i < menuList.size(); i++) {
            System.out.printf("%d - %s\n", (i + 1), menuList.get(i));
        }
    }

    public static void displayMenu() {
        System.out.println("\nWhat would you like to do now? 🤔");

        displayOptions(getMenuOptions());
    }


}
