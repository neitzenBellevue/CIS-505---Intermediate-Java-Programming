public class TestFanApp {
    public static void main(String[] args) {
        Fan defaultFan = new Fan();
        Fan argumentFan = new Fan(2, true, 3 , "Red");

        System.out.println(defaultFan);
        System.out.println(argumentFan);
    }
}
