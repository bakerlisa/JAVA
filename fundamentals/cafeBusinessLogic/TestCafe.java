public class TestCafe {
    public static void main(String[] args){
        CafeUtil cafeApp = new CafeUtil();
        int streak = cafeApp.getStreakGoal(12);
        System.out.println(streak);

    }
}
